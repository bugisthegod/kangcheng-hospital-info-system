package com.woniu.exception;

import com.woniu.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RestControllerAdvice
public class CommonExceptionAdvice {


//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseResult< Set > handleConstraintViolationException(ConstraintViolationException exception){
//        String msg = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
//        return new ResponseResult<>(999,msg);
//    }

    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<Void> constraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        log.warn("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        //String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        AtomicReference<String> message2 = new AtomicReference<>("");
        violations.forEach(violation->{
            String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
            message2.set(String.format("%s:%s", path, violation.getMessage()+" ") + message2);
        });




        return new ResponseResult<>(null, message2.toString(),400);
    }

    @ExceptionHandler(value= {MethodArgumentNotValidException.class , BindException.class})
    public ResponseResult<Map<String,String>> handleVaildException(Exception e){
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException)e).getBindingResult();
        } else if (e instanceof BindException) {
            bindingResult = ((BindException)e).getBindingResult();
        }
        Map<String,String> errorMap = new HashMap<>(16);
        bindingResult.getFieldErrors().forEach((fieldError)->
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage())
        );
        return new ResponseResult<>(errorMap,"非法参数",400);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseResult<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return new ResponseResult<String>(999,"参数类型有误,要求的参数类型为"+e.getRequiredType().getName());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return new ResponseResult<String>(999,"请求类型有误,要求的请求类型为"+e.getSupportedMethods()[0]);
    }

}

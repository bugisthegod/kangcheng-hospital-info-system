package com.woniu.exception;

import com.woniu.utils.ResponseResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(Exception.class)
    // public ResponseResult<Object> getMessage(Exception e){
    //     return new ResponseResult<>(e.getMessage(),"error",400);
    // }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<String> handleConstraintViolationException(ConstraintViolationException exception){
        String msg = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return new ResponseResult<>(999,msg);
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

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseResult<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
    //     String msg = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
    //     return new ResponseResult(999,msg);
    // }
    //
    // @ExceptionHandler(BindException.class)
    // public ResponseResult<String> handleBindException(BindException e){
    //     String msg = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
    //     return new ResponseResult<String>(999,msg);
    // }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseResult<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        return new ResponseResult<String>(999,"参数类型有误,要求的参数类型为"+e.getRequiredType().getName());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        return new ResponseResult<String>(999,"请求类型有误,要求的请求类型为"+e.getSupportedMethods()[0]);
    }
}

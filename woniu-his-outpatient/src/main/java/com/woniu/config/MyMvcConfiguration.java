package com.woniu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {
    /**
     * 配置消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        List<HttpMessageConverter<?>> result = new ArrayList<>();

        //Jackson
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        MediaType mediaType = MediaType.valueOf("application/json;charset=utf-8");
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(mediaType);
        converter.setSupportedMediaTypes(mediaTypeList);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        converter.setObjectMapper(objectMapper);
        result.add(converter);

        result.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        converters.clear();
        converters.addAll(result);
    }
}

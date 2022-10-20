package com.nucpoop.server.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class MultiValueMapConverter {

    private MultiValueMapConverter(){}

    public static MultiValueMap<String, String> convert(ObjectMapper objectMapper, Object dto){
        try{
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            Map<String, String> map = objectMapper.convertValue(dto,
                new TypeReference<>() {
                });
            params.setAll(map);

            return params;
        }catch (Exception e){
            throw new IllegalStateException("url parameter 변환중 오류 발생");
        }
    }
}

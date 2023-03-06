package com.saber.spring6webserverdemo.services.impl;

import com.saber.spring6webserverdemo.dto.HelloResponseDto;
import com.saber.spring6webserverdemo.services.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloResponseDto sayHello(String firstName, String lastName) {
        Map<String,Object> json = new HashMap<>();
        json.put("firstName",firstName);
        json.put("lastName",lastName);
        log.info("Request for sayHello ===>  {} ",json);
        HelloResponseDto responseDto = new HelloResponseDto();
        responseDto.setMessage(String.format("Hello %s %s",firstName,lastName));
        log.info("Response for sayHello ===>  {} ",responseDto);
        return responseDto;
    }
}

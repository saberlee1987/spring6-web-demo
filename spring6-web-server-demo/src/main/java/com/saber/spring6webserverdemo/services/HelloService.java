package com.saber.spring6webserverdemo.services;

import com.saber.spring6webserverdemo.dto.HelloResponseDto;

public interface HelloService {
    HelloResponseDto sayHello(String firstName,String lastName);
}

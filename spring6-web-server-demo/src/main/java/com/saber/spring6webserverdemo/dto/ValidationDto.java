package com.saber.spring6webserverdemo.dto;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.ToNumberPolicy;
import lombok.Data;

@Data
public class ValidationDto {
    private String fieldName;
    private String constraintMessage;

    @Override
    public String toString() {
        return new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .enableComplexMapKeySerialization()
                .setLongSerializationPolicy(LongSerializationPolicy.DEFAULT)
                .setObjectToNumberStrategy(ToNumberPolicy.BIG_DECIMAL)
                .create().toJson(this, ValidationDto.class);

    }
}

package com.spring.boot.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class BundleMessage {

    @JsonProperty("message_en")
    private String messageEn;

    @JsonProperty("message_ar")
    private String messageAr;
}


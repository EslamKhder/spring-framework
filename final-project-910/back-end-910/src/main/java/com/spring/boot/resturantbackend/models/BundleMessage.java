package com.spring.boot.resturantbackend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundleMessage {
    @JsonProperty("message_ar")
    private String messageAr;
    @JsonProperty("message_en")
    private String messageEn;

    public BundleMessage(String messageEn) {
        this.messageEn = messageEn;
    }
}

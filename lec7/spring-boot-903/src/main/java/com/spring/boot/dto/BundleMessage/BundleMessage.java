package com.spring.boot.dto.BundleMessage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class BundleMessage {

    @JsonProperty("message_en")
    private String messageEn;
    @JsonProperty("message_ar")
    private String messageAr;

    public BundleMessage(String messageEn, String messageAr) {
        this.messageEn = messageEn;
        this.messageAr = messageAr;

    }
}

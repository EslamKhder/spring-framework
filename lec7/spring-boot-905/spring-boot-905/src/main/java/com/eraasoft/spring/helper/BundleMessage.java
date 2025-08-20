package com.eraasoft.spring.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundleMessage {

    private String ar;
    private String en;
    private String message;

    public BundleMessage(String ar, String en) {
        this.ar = ar;
        this.en = en;
    }
}

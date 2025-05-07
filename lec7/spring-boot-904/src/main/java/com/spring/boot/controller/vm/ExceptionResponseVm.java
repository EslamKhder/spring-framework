package com.spring.boot.controller.vm;

import com.spring.boot.dto.exception.BundleMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ExceptionResponseVm {

//    private List<BundleMessage> message;

    private List<String> message;
    private HttpStatus status;

    private LocalDate localDate;

    public ExceptionResponseVm(List<String> message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.localDate = LocalDate.now();
    }
}

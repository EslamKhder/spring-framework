package com.spring.boot.spring903.controller.vm;

import com.spring.boot.spring903.dto.BundleMessage.BundleMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ExceptionResponseVm {

    private List<BundleMessage> errorMessages;

    private HttpStatus httpStatus;

    private LocalDate localDate;

    public ExceptionResponseVm(List<BundleMessage> errorMessages, HttpStatus httpStatus) {
        this.errorMessages = errorMessages;
        this.httpStatus = httpStatus;
        this.localDate = LocalDate.now();
    }
}

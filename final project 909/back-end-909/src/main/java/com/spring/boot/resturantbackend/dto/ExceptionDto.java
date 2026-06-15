package com.spring.boot.resturantbackend.dto;

import com.spring.boot.resturantbackend.models.BundleMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDto {
    private BundleMessage bundleMessage;
}

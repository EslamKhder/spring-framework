package com.spring.boot.resturantbackend.controllers.vm;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestOrderVm {
    private List<OrderVm> orderVms;

    public List<OrderVm> getOrderVms() {
        return orderVms;
    }

    public void setOrderVms(List<OrderVm> orderVms) {
        this.orderVms = orderVms;
    }
}

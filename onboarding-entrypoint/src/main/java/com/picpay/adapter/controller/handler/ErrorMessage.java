package com.picpay.adapter.controller.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorMessage {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}

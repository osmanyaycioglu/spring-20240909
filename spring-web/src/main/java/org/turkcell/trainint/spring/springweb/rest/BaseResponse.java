package org.turkcell.trainint.spring.springweb.rest;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private boolean errorOccured;
    private String errorDesc;
    private String errorCause;
    private Integer errorCode;
    private String transId;
    private T response;
}

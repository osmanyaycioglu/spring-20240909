package org.turkcell.trainint.spring.springweb.rest;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String errorDesc;
    private Integer errorCode;

    public ErrorObj() {
    }

    @Builder(setterPrefix = "with")
    public ErrorObj(final List<ErrorObj> subErrorsParam,
                    final String errorDescParam,
                    final Integer errorCodeParam) {
        subErrors = subErrorsParam;
        errorDesc = errorDescParam;
        errorCode = errorCodeParam;
    }
}

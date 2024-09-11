package org.turkcell.trainint.spring.springweb.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestErrorAdvice {

    private static final Logger logger = LoggerFactory.getLogger(RestErrorAdvice.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDescParam(exp.getMessage())
                       .withErrorCodeParam(1055)
                       .build();
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ErrorObj handle(IllegalStateException exp) {
        return ErrorObj.builder()
                       .withErrorDescParam(exp.getMessage())
                       .withErrorCodeParam(1056)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handle(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorDescParam("validation Error")
                       .withErrorCodeParam(1075)
                       .withSubErrorsParam(convertToErrorObj(exp))
                       .build();

    }

    private List<ErrorObj> convertToErrorObj(MethodArgumentNotValidException exp) {
        return exp.getAllErrors()
                  .stream()
                  .map(e -> ErrorObj.builder()
                                    .withErrorDescParam("" + e)
                                    .withErrorCodeParam(1056)
                                    .build())
                  .collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handle(Exception exp) {
        logger.error("[RestErrorAdvice][handle]-> *Error* : " + exp.getMessage(),exp);
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                                 .body(ErrorObj.builder()
                                               .withErrorDescParam(exp.getMessage())
                                               .withErrorCodeParam(1055)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder()
                                           .withErrorDescParam(exp.getMessage())
                                           .withErrorCodeParam(1055)
                                           .build());
    }


}

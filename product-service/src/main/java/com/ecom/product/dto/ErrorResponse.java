package com.ecom.product.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class ErrorResponse {

    private String errorCode;
    private String message;
    private int status;
    private LocalDate timestamp;
    public ErrorResponse(String errorCode, String message, int status){
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
        this.timestamp = LocalDate.now();
    }

    @Override
    public String toString(){
        return errorCode + " " + message+ " " +status+ " " +timestamp;
    }
}

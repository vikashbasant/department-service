package com.dt.ds.exception;

import lombok.Data;

@Data
public class GeneralException extends Exception{
    private String statusCode;
    private String message;
    private transient Object errorMessages;

    public GeneralException(String errorCode, String message, String errorMessages){
        this.statusCode = errorCode;
        this.message = message;
        this.errorMessages = errorMessages;
    }


    public GeneralException(String errorCode, String message){
        this.statusCode = errorCode;
        this.message = message;
    }

}

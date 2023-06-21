package com.soporte.tpg_soporte.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

    private List<String> message;
    

    public ErrorResponse(List<String> message) {
        this.message = message;
    }


    public List<String> getMessage() {
        return this.message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }



}

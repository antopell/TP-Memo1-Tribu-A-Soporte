package com.soporte.tpg_soporte.exception;

public class ErrorNotFound extends RuntimeException{
    public ErrorNotFound(String error) {
        super(error);
    }
}

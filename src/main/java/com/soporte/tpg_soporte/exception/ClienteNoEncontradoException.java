package com.soporte.tpg_soporte.exception;

public class ClienteNoEncontradoException extends RuntimeException{
    public ClienteNoEncontradoException(String cliente) {
        super("El cliente '" + cliente + "' no existe en nuestros registros");
    }
}

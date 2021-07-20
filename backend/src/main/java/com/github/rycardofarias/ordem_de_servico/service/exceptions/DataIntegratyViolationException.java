package com.github.rycardofarias.ordem_de_servico.service.exceptions;

public class DataIntegratyViolationException extends RuntimeException{

    public DataIntegratyViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegratyViolationException(String message) {
        super(message);
    }
}
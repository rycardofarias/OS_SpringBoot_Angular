package com.github.rycardofarias.ordem_de_servico.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private static final long serialVersionUID = 1L;

    private List<FieldMessade> erros = new ArrayList<>();

    public ValidationError(){
        super();
    }
    public ValidationError(Long timestamp, Integer status, String error){
        super(timestamp, status, error);
    }
    public List<FieldMessade> getErros(){
        return erros;
    }
    public void addError(String fieldName, String message){
        this.erros.add(new FieldMessade(fieldName, message));
    }
}

package com.denteconvenio.consultaservice.infra.validation;


public class ValidacaoException extends RuntimeException{

    public ValidacaoException(String mensagem){
        super(mensagem);
    }
}
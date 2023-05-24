package br.com.systempus.systempus.error;

import org.springframework.dao.NonTransientDataAccessException;

public class DataIntegrityViolationException extends NonTransientDataAccessException{

    public DataIntegrityViolationException(String cpf){
        super(cpfExists(cpf));
    }

    public static String cpfExists(String cpf){
        StringBuffer mensagem = new StringBuffer();

        mensagem.append("O CPF: ")
                .append(cpf)
                .append(" já foi cadastrado no sistema");

        return mensagem.toString();
    }
}

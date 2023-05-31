package br.com.systempus.systempus.error;

public class IllegalStateException extends RuntimeException{

    public IllegalStateException(String entidade){
        super(isId(entidade));
    }

    public static String isId(String entidade){
        StringBuffer mensagem = new StringBuffer();
        mensagem.append("Operação Inválida: ")
                .append(entidade)
                .append(" com identificador!");
        return mensagem.toString();
    }

}

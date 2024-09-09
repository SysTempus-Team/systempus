package br.com.systempus.systempus.error;


public class NotFoundException extends RuntimeException{

    public NotFoundException(String entidade, Integer id){
        super(IdNotFound(entidade, id));
    }

    public NotFoundException(String usuario){
        super(NameNotFound(usuario));
    }

    public static String IdNotFound(String entidade, Integer id){
        //StringBuffer sincronizado (quando tem muitos acessos, ele fica lento) - Sessão crítica [mais utilizado]
        //Pode-se colocar StringBuilder //TODO <----- Pesquisar e Estudar
        StringBuffer mensagem = new StringBuffer();
        mensagem.append(entidade)
                .append( " com o id=")
                .append(id)
                .append(" não existe!");

        return mensagem.toString();
    }

    public static String NameNotFound(String usuario){
        StringBuffer mensagem = new StringBuffer();

        mensagem.append("O usuário com nome: ")
                .append(usuario)
                .append(" não existe!");

        return mensagem.toString();
    }
}
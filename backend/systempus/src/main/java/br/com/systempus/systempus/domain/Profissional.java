package br.com.systempus.systempus.domain;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
@Table(name = "tb_profissional")
public class Profissional {
    @NotNull(message = "Campo Obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotNull(message = "Campo Obrigatório")
    @Size(min=4,max=50,message="Descrição deve ter no máximo {max}")
    private String nome;

    private String telefone;

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return telefone;
    }

}

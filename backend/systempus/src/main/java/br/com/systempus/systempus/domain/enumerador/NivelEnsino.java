package br.com.systempus.systempus.domain.enumerador;

import java.lang.reflect.Field;

public enum NivelEnsino {

    INFANTIL(0, "Infantil"),
    FUNDAMENTAL(1, "Fundamental"),
    MEDIO(2, "Médio"),
    SUPERIOR(3, "Superior"),
    POSGRADUACAO(4, "Pós-Graduação");

    private final int value;
    private final String nome;

    NivelEnsino(int value, String nome){
        this.value = value;
        this.nome = nome;
    }

    public int getValue(){
        return value;
    }

    public String getNome(){
        return nome;
    }


    public static NivelEnsino toEnum(Integer codigo){
        if(codigo == null){
            return null;
            throw IllegalArgumentException("Código do Nível de Ensino Inválido: " + codigo);
        }else{
            for( NivelEnsino nivelEnsino : NivelEnsino.values()){
                if(codigo.equals(nivelEnsino.getValue())){
                    return nivelEnsino;
                }
            }
        }
    }


}
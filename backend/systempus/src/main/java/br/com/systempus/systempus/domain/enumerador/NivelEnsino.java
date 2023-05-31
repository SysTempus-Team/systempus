package br.com.systempus.systempus.domain.enumerador;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
    @JsonValue
    public String getNome(){
        return nome;
    }

    @JsonCreator
    public static NivelEnsino toEnum(Integer codigo){
      
        for( NivelEnsino nivelEnsino : NivelEnsino.values()){
            if(codigo == nivelEnsino.getValue()){
                return nivelEnsino;
            }
        }
        return null;
    }


}
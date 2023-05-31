package br.com.systempus.systempus.domain.enumerador;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Modalidade {

    PRESENCIAL(0, "Presencial"),
    HIBRIDO(1, "Híbrido"),
    EAD(2, "Ensino à Distância - EAD");

    private final Integer value;
    private final String name;

    Modalidade(Integer value, String name){
        this.value = value;
        this.name = name;
    }

    public Integer getValue(){
        return value;
    }
    
    @JsonValue
    public String getName(){
        return name;
    }
}
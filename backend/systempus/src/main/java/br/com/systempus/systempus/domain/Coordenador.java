package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;

@Entity
@Table(name = "coordenador")
@DiscriminatorValue("1")
public class Coordenador extends Profissional{

    @JsonManagedReference
    @OneToMany(mappedBy = "coordenador")
    private List<Curso> cursos;

    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;
    }

    public List<Curso> getCursos(){
        return cursos;
    }
}
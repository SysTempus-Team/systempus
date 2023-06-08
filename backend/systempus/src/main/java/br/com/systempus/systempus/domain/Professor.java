package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;


@Entity
@Table(name = "professor")
@DiscriminatorValue("2")
public class Professor extends Profissional{

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name="professor_disciplina", joinColumns = @JoinColumn(name="id_professor"),
    inverseJoinColumns = @JoinColumn(name="id_disciplina"))
    private List<Disciplina> disciplinas;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "professor_curso", joinColumns = @JoinColumn(name = "id_curso"),
    inverseJoinColumns = @JoinColumn(name = "id_professor"))
    private List<Curso> cursos;

    public Professor(){

    }

    public Professor(String cpf, String nome, String telefone){
        this.setCpf(cpf);
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    public void setDisciplinas(List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }

    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;
    }

    public List<Curso> getCursos(){
        return cursos;
    }
}
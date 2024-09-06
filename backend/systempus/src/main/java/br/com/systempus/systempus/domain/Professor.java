package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.DiscriminatorValue;


@Entity
@Table(name = "professor")
@DiscriminatorValue("2")
public class Professor extends Profissional{

    @JsonIgnoreProperties({"modulos", "coordenador"})
    //@JsonManagedReference(value = "professores_cursos")
    @ManyToMany
    @JoinTable(name = "professor_curso", joinColumns = @JoinColumn(name = "id_professor"),
    inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private List<Curso> cursos;

    //@JsonManagedReference(value = "disciplinas_professores")
    @ManyToMany
    @JoinTable(name="professor_disciplina", joinColumns = @JoinColumn(name="id_professor"),
    inverseJoinColumns = @JoinColumn(name="id_disciplina"))
    private List<Disciplina> disciplinas;

    @OneToMany(mappedBy = "professor")
    private List<DisponibilidadeProfessor> disponibilidadeProfessor;

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
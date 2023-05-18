package br.com.systempus.systempus.domain;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor extends Profissional{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToMany
    private List<Disciplina> disciplinas;


    @ManyToMany
    private List<Curso> cursos;

    public Integer getId(){
        return id;
    }

    public Professor(){

    }

    public Professor(String cpf, String nome, String telefone){
        this.setCpf(cpf);
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    public void setDisciplinas(List<Disciplina> disciplina){
        this.disciplinas = disciplina;
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
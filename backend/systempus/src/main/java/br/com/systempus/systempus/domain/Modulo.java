package br.com.systempus.systempus.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Campo Obrigatório")
    private Integer numero;

    private String dataInicio;
    private String dataFim;

    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id")
    private Curso curso;

    @OneToMany
    private List<Disciplina> disciplinas;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}

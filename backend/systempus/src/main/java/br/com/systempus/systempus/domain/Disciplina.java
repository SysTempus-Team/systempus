package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Campo Obrigatório")
    private String nome;

    @JsonIgnore
    //@JsonBackReference(value = "disciplinas_professores")
    @ManyToMany(mappedBy = "disciplinas")
    private List<Professor> professores;

    @JsonIgnore
    //@JsonBackReference(value = "disciplina_modulo")
    @ManyToOne
    @JoinColumn(name = "id_modulo")
    private Modulo modulo;

    @JsonIgnore
    @OneToMany(mappedBy = "disciplina")
    private List<HorarioDisciplina> horarioDisciplina;

    public Disciplina() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }


    public List<Professor> getProfessores() {
        return professores;
    }

    public List<HorarioDisciplina> getHorarioDisciplina() {
        return horarioDisciplina;
    }

    public void setHorarioDisciplina(List<HorarioDisciplina> horarioDisciplina) {
        this.horarioDisciplina = horarioDisciplina;
    }

}

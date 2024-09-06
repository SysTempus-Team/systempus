package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instituicao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Instituicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    
    private String cnpj;

    @OneToMany(mappedBy = "instituicao")
    private List<Periodo> periodo;

    @OneToMany(mappedBy = "instituicao")
    private List<CargaHoraria> cargasHorarias;

    public Instituicao(){}

    public Instituicao(Integer id, String nome, String cnpj, List<Periodo> periodo) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Periodo> getPeriodos() {
        return periodo;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodo = periodos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}

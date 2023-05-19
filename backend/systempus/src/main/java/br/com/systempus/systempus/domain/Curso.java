package br.com.systempus.systempus.domain;

import java.util.List;

import br.com.systempus.systempus.domain.enumerador.Modalidade;
import br.com.systempus.systempus.domain.enumerador.NivelEnsino;
//import br.com.systempus.systempus.Coordenador;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotNull(message = "Campo obrigatório")
    private String nome;

    @NotNull(message = "Campo obrigatório")
    @Enumerated(EnumType.ORDINAL)
    private NivelEnsino nivelEnsino;

    @NotNull(message = "Campo obrigatório")
    private Integer qtdPeriodos;

    @NotNull(message = "Campo obrigatório")
    @Enumerated(EnumType.ORDINAL)
    private Modalidade modalidade;

    private Integer cargaTotal;

    public Curso(){}

    @OneToMany
    private List<Modulo> modulos;

    @ManyToOne
    @JoinColumn(name = "coordenador", referencedColumnName = "id")
    private Coordenador coordenador;

    public void setModalidade(Modalidade modalidade){
        this.modalidade = modalidade;
    }

    public void setNivelEnsino(NivelEnsino nivelEnsino){
        this.nivelEnsino = nivelEnsino;
    }

    public Modalidade getModalidade(){
        return modalidade;
    }

    public NivelEnsino getNivelEnsino(){
        return nivelEnsino;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setQtdPeriodos(Integer qtdPeriodos){
        this.qtdPeriodos = qtdPeriodos;
    }

    public Integer getQtdPeriodos(){
        return qtdPeriodos;
    }

    public void setCargaTotal(Integer cargaTotal){
        this.cargaTotal = cargaTotal;
    }

    public Integer getCargaTotal(){
        return cargaTotal;
    }

    public void setCoordenador(Coordenador coordenador){
        this.coordenador = coordenador;
    }

    public Coordenador getCoordenador(){
        return coordenador;
    }

    public void setModulos(List<Modulo> modulos){
        this.modulos = modulos;
    }

    public List<Modulo> getModulos(){
        return modulos;
    }

    @Override
    public String toString() {
        return "Curso [id=" + id + ", nome=" + nome + ", nivelEnsino=" + nivelEnsino + ", qtdPeriodos=" + qtdPeriodos
                + ", modalidade=" + modalidade + ", cargaTotal=" + cargaTotal + ", modulos=" + modulos
                + ", coordenador=" + coordenador + "]";
    }

    
}

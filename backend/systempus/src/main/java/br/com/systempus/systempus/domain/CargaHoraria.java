package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carga_horaria")
public class CargaHoraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @OneToMany(mappedBy = "cargaHoraria")
    @JsonBackReference(value = "horarios_aula_carga_horaria")
    private List<HorarioAula> horariosAula;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;

    public CargaHoraria(Integer id, Instituicao instituicao) {
        this.id = id;
        this.instituicao = instituicao;
    }

    public CargaHoraria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
    public List<HorarioAula> getHorariosAula() {
        return horariosAula;
    }

    public void setHorarioAula(List<HorarioAula> horariosAula) {
        this.horariosAula = horariosAula;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    
    

    
    
}

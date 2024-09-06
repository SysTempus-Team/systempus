package br.com.systempus.systempus.domain;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private List<HorarioAula> horarioAula;

    @OneToOne
    @JoinColumn(name = "id_instituicao")
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
    public List<HorarioAula> getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(List<HorarioAula> horarioAula) {
        this.horarioAula = horarioAula;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    
    

    
    
}

package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_aula")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class HorarioAula {
    
    // @EmbeddedId
    // private HorarioAulaId id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "carga_horaria_id")
    private CargaHoraria cargaHoraria;

    @OneToMany(mappedBy = "horarioAula")
    private List<DisponibilidadeProfessor> disponibilidadeProfessor;

    @OneToMany(mappedBy = "horarioAula")
    private List<HorarioDisciplina> horarioDisciplina;

    public HorarioAula(){}

    // public HorarioAula(HorarioAulaId id, Set<Professor> professores) {
    //     this.id = id;
    // }

    // public HorarioAula(HorarioAulaId id, Integer idPeriodo, Integer idCargaHoraria) {
    //     this.id = id;
    // }

    // public HorarioAulaId getId() {
    //     return id;
    // }

    // public void setId(HorarioAulaId id) {
    //     this.id = id;
    // }

    // public Periodo getPeriodo() {
    //     return periodo;
    // }

    

    public List<DisponibilidadeProfessor> getDisponibilidadeProfessor() {
        return disponibilidadeProfessor;
    }

    public List<HorarioDisciplina> getHorarioDisciplina() {
        return horarioDisciplina;
    }

    // public void setPeriodo(Periodo periodo) {
    //     this.periodo = periodo;
    // }

    public CargaHoraria getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CargaHoraria cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setHorarioDisciplina(List<HorarioDisciplina> horarioDisciplina) {
        this.horarioDisciplina = horarioDisciplina;
    }

    public void setDisponibilidadeProfessor(List<DisponibilidadeProfessor> disponibilidadeProfessor) {
        this.disponibilidadeProfessor = disponibilidadeProfessor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}

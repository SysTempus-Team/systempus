package br.com.systempus.systempus.domain;

import java.util.Set;


import br.com.systempus.systempus.domain.embeddableclass.HorarioAulaId;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.MapsId;

@Entity
@Table(name = "horario_aula")
public class HorarioAula {
    
    @EmbeddedId
    private HorarioAulaId id;

    @ManyToOne
    // @JoinColumn(name = "id_periodo", insertable = false, updatable = false)
    @MapsId("periodoId")
    private Periodo periodo;

    @ManyToOne
    // @JoinColumn(name = "id_carga_horaria", insertable = false, updatable = false)
    @MapsId("cargaHorariaId")
    private CargaHoraria cargaHoraria;

    @OneToMany(mappedBy = "horarioAula")
    private List<HorarioDisciplina> horarioDisciplina;

    @OneToMany(mappedBy = "horarioAula")
    private List<DisponibilidadeProfessor> disponibilidadeProfessor;

    public HorarioAula(){}

    public HorarioAula(HorarioAulaId id, Set<Professor> professores) {
        this.id = id;
    }

    public HorarioAula(HorarioAulaId id, Integer idPeriodo, Integer idCargaHoraria) {
        this.id = id;
    }

    public HorarioAulaId getId() {
        return id;
    }

    public void setId(HorarioAulaId id) {
        this.id = id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public List<DisponibilidadeProfessor> getDisponibilidadeProfessor() {
        return disponibilidadeProfessor;
    }

    public List<HorarioDisciplina> getHorarioDisciplina() {
        return horarioDisciplina;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

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
    
    
}

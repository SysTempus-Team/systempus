package br.com.systempus.systempus.domain.embeddableclass;

import jakarta.persistence.Embeddable;

@Embeddable
public class DisponibilidadeProfessorId {
    
    private Integer horarioAulaId;
    private Integer professorId;

    public DisponibilidadeProfessorId() {
    }

    public DisponibilidadeProfessorId(Integer horarioAulaId, Integer professorId) {
        this.horarioAulaId = horarioAulaId;
        this.professorId = professorId;
    }

    public Integer getHorarioAulaId() {
        return horarioAulaId;
    }

    public void setHorarioAulaId(Integer horarioAulaId) {
        this.horarioAulaId = horarioAulaId;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }
    
}

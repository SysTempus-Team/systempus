package br.com.systempus.systempus.domain.embeddableclass;

import br.com.systempus.systempus.domain.Disciplina;
import br.com.systempus.systempus.domain.HorarioAula;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class HorarioDisciplinaId {
    
    // @Column
    private HorarioAulaId horarioAulaId;

    // @Column(name = "id_disciplina")
    private Integer disciplinaId;

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public HorarioAulaId getHorarioAulaId() {
        return horarioAulaId;
    }

    public void setHorarioAulaId(HorarioAulaId horarioAulaId) {
        this.horarioAulaId = horarioAulaId;
    }
}

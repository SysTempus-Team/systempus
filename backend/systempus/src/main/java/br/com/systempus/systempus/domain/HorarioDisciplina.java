package br.com.systempus.systempus.domain;

import java.util.List;

import br.com.systempus.systempus.domain.embeddableclass.HorarioDisciplinaId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_disciplina")
public class HorarioDisciplina {
    
    @EmbeddedId
    private HorarioDisciplinaId id;

    @ManyToOne
    @MapsId("disciplinaId")
    private Disciplina disciplina;

    @ManyToOne
    @MapsId("horarioAulaId") 
    private HorarioAula horarioAula;

    @ManyToMany(mappedBy = "horariosDisciplina")
    private List<DisponibilidadeProfessor> disponibilidadeProfessor;

    public HorarioDisciplina(HorarioDisciplinaId id, Integer idHorarioAula, Integer idDisciplina,
            List<DisponibilidadeProfessor> disponibilidadeProfessor) {
        this.id = id;
        this.disponibilidadeProfessor = disponibilidadeProfessor;
    }

    public HorarioDisciplina() {
    }
    public List<DisponibilidadeProfessor> getDisponibilidadeProfessor() {
        return disponibilidadeProfessor;
    }

    public void setDisponibilidadeProfessor(List<DisponibilidadeProfessor> disponibilidadeProfessor) {
        this.disponibilidadeProfessor = disponibilidadeProfessor;
    }

    public HorarioDisciplinaId getId() {
        return id;
    }

    public void setId(HorarioDisciplinaId id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public HorarioAula getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(HorarioAula horarioAula) {
        this.horarioAula = horarioAula;
    }
    
}

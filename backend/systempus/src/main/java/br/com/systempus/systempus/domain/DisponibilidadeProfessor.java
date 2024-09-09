package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.systempus.systempus.domain.embeddableclass.DisponibilidadeProfessorId;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "disponibilidade_professor")
public class DisponibilidadeProfessor {

    @EmbeddedId
    private DisponibilidadeProfessorId id;

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name = "professor_id")
    @JsonBackReference
    private Professor professor;
    
    @ManyToOne
    @MapsId("horarioAulaId")
    @JoinColumn(name = "horario_aula_id")
    @JsonBackReference
    private HorarioAula horarioAula;

    @OneToMany(mappedBy = "disponibilidadeProfessor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioDocente> horariosDocente;

    public DisponibilidadeProfessor(DisponibilidadeProfessorId id, Integer idHorarioAula, Integer idProfessor,
            List<HorarioDisciplina> horariosDisciplina) {
        this.id = id;
    }

    public DisponibilidadeProfessor() {
    }

    public DisponibilidadeProfessorId getId() {
        return id;
    }

    public void setId(DisponibilidadeProfessorId id) {
        this.id = id;
    }

    public HorarioAula getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(HorarioAula horarioAula) {
        this.horarioAula = horarioAula;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
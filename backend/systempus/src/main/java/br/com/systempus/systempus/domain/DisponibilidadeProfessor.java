package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.systempus.systempus.domain.embeddableclass.DisponibilidadeProfessorId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.MapsId;

@Entity
@Table(name = "disponibilidade_professor")
public class DisponibilidadeProfessor {

    @EmbeddedId
    private DisponibilidadeProfessorId id;

    @ManyToOne
    @MapsId("horarioAulaId")
    private HorarioAula horarioAula;

    @ManyToOne
    @MapsId("professorId")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "horario_docente")
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @JoinColumn(name = "id_carga_horaria", referencedColumnName = "id_carga_horaria")
    private List<HorarioDisciplina> horariosDisciplina;

    public DisponibilidadeProfessor(DisponibilidadeProfessorId id, Integer idHorarioAula, Integer idProfessor,
            List<HorarioDisciplina> horariosDisciplina) {
        this.id = id;
        // this.horariosDisciplina = horariosDisciplina;
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

    public List<HorarioDisciplina> getHorariosDisciplina() {
        return horariosDisciplina;
    }

    public void setHorariosDisciplina(List<HorarioDisciplina> horariosDisciplina) {
        this.horariosDisciplina = horariosDisciplina;
    }

}
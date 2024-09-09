package br.com.systempus.systempus.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.systempus.systempus.domain.embeddableclass.HorarioDisciplinaId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_disciplina")
public class HorarioDisciplina {
    
    @EmbeddedId
    private HorarioDisciplinaId id;
    
    @ManyToOne
    @MapsId("horarioAulaId") 
    @JoinColumn(name = "horario_aula_id")
    private HorarioAula horarioAula;

    @ManyToOne
    @MapsId("disciplinaId")
    @JoinColumn(name = "disciplina_id")
    @JsonManagedReference
    private Disciplina disciplina;

    @OneToMany(mappedBy = "horarioDisciplina")
    private List<HorarioDocente> horariosDocente;

    public HorarioDisciplina(HorarioDisciplinaId id, Integer idHorarioAula, Integer idDisciplina,
            List<DisponibilidadeProfessor> disponibilidadeProfessor) {
        this.id = id;
    }

    public HorarioDisciplina() {
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

    public List<HorarioDocente> getHorariosDocente() {
        return horariosDocente;
    }

    public void setHorariosDocente(List<HorarioDocente> horariosDocente) {
        this.horariosDocente = horariosDocente;
    }
    
    
}

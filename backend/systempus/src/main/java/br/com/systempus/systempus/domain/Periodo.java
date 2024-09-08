package br.com.systempus.systempus.domain;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.systempus.systempus.domain.enumerador.Turno;
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
@Table(name = "periodo")
public class Periodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Turno turno;

    @Column(name = "inicio_intervalo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime inicioIntervalo;
    
    @Column(name = "fim_intervalo")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime fimIntervalo;
    
    @Column(name = "inicio_horario")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime inicioHorario;
    
    @Column(name = "fim_horario")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime fimHorario;

    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;

    @OneToMany
    @JoinColumn(name = "periodo_id")
    private List<HorarioAula> horariosAula;

    public Periodo(){}

    public Periodo(Integer id, String nome, LocalTime inicioIntervalo, LocalTime fimIntervalo, LocalTime inicioHorario,
            LocalTime fimHorario, Curso curso, Instituicao instituicao, Turno turno) {
        this.id = id;
        this.turno = turno;
        this.inicioIntervalo = inicioIntervalo;
        this.fimIntervalo = fimIntervalo;
        this.inicioHorario = inicioHorario;
        this.fimHorario = fimHorario;
        // this.curso = curso;
        this.instituicao = instituicao;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    // public Curso getCurso() {
    //     return curso;
    // }

    // public void setCurso(Curso curso) {
    //     this.curso = curso;
    // }

    public LocalTime getInicioIntervalo() {
        return inicioIntervalo;
    }

    public void setInicioIntervalo(LocalTime inicioIntervalo) {
        this.inicioIntervalo = inicioIntervalo;
    }

    public LocalTime getFimIntervalo() {
        return fimIntervalo;
    }

    public void setFimIntervalo(LocalTime fimIntervalo) {
        this.fimIntervalo = fimIntervalo;
    }

    public LocalTime getInicioHorario() {
        return inicioHorario;
    }

    public void setInicioHorario(LocalTime inicioHorario) {
        this.inicioHorario = inicioHorario;
    }

    public LocalTime getFimHorario() {
        return fimHorario;
    }

    public void setFimHorario(LocalTime fimHorario) {
        this.fimHorario = fimHorario;
    }

    public List<HorarioAula> getHorariosAula() {
        return horariosAula;
    }

    public void setHorariosAula(List<HorarioAula> horariosAula) {
        this.horariosAula = horariosAula;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    

    
}

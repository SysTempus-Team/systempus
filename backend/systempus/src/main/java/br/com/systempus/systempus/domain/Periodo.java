package br.com.systempus.systempus.domain;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "periodo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instituicao instituicao;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "periodo_id")
    private List<HorarioAula> horariosAula;



    

    
}

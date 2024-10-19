package br.com.systempus.systempus.domain.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.systempus.systempus.domain.DisponibilidadeProfessor;
import br.com.systempus.systempus.domain.HorarioAula;
import br.com.systempus.systempus.domain.enumerador.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DisponibilidadeProfessorDTO {

    private DiaSemana diaSemana;
    private Integer horarioAulaId;


    public static List<DisponibilidadeProfessorDTO> convertToDTO(List<DisponibilidadeProfessor> disponibilidades) {
        return disponibilidades.stream().map(d -> new DisponibilidadeProfessorDTO(
            d.getDiaSemana(),
            d.getHorarioAula().getId()
        )).collect(Collectors.toList());
    }
}

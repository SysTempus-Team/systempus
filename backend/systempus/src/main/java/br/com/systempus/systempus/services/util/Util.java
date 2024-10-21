package br.com.systempus.systempus.services.util;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import br.com.systempus.systempus.domain.CargaHoraria;
import br.com.systempus.systempus.domain.Periodo;
import br.com.systempus.systempus.domain.enumerador.Turno;
import br.com.systempus.systempus.error.DataIntegrityViolationException;

public class Util {

    public static Boolean matchTurno(Periodo periodo) {
        LocalTime horarioInicio = periodo.getInicioHorario();
        LocalTime horarioFim = periodo.getFimHorario();

        if (periodo.getTurno() == Turno.MATUTINO) {
            return isHorarioMatutino(horarioInicio, horarioFim);
        } else if (periodo.getTurno() == Turno.VESPERTINO) {
            return isHorarioVespertino(horarioInicio, horarioFim);
        } else if (periodo.getTurno() == Turno.NOTURNO) {
            return isHorarioNoturno(horarioInicio, horarioFim);
        } else if (periodo.getTurno() == Turno.INTEGRAL) {
            return isPeriodoIntegral(horarioInicio, horarioFim);
        } else {
            throw new DataIntegrityViolationException(DataIntegrityViolationException.turnoDoesntMatchHours());
        }

    }

    public static Boolean isHorarioMatutino(LocalTime horarioInicio, LocalTime horarioFim) {
        return horarioInicio.isAfter(LocalTime.MIDNIGHT) && horarioFim.isBefore(LocalTime.NOON);
    }

    public static Boolean isHorarioVespertino(LocalTime horarioInicio, LocalTime horarioFim) {
        return horarioInicio.isAfter(LocalTime.NOON) && horarioFim.isBefore(LocalTime.of(18, 00));
    }

    public static Boolean isHorarioNoturno(LocalTime horarioInicio, LocalTime horarioFim) {
        return horarioInicio.isAfter(LocalTime.of(17, 59)) && horarioFim.isBefore(LocalTime.of(23, 59));
    }

    public static Boolean isPeriodoIntegral(LocalTime horarioInicio, LocalTime horarioFim) {
        return horarioInicio.isAfter(LocalTime.of(06, 59)) && horarioFim.isBefore(LocalTime.of(18, 00));
    }

    // TODO: Melhorar nome da função
    public static Boolean matchCargaHoraria(Periodo periodo, CargaHoraria cargaHoraria) {
        try {
            Duration duracaoAteIntervalo = Duration.between(periodo.getInicioHorario(), periodo.getInicioIntervalo());
            long diferenca1 = duracaoAteIntervalo.toMinutes();

            Duration duracaoAteFim = Duration.between(periodo.getFimIntervalo(), periodo.getFimHorario());
            long diferenca2 = duracaoAteFim.toMinutes();

            long carga = (long) cargaHoraria.getCargaHoraria();

            if ((diferenca1 % carga == 0) && (diferenca2 % carga == 0)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new DataIntegrityViolationException(
                    "Os valores dos períodos precisam condizer com a carga horária de " + cargaHoraria.getCargaHoraria()
                            + " minutos da instituição");
        }
    }

    public static void podeCadastrarPorTurno(Periodo periodoCadastro, List<Periodo> periodos){
        for (Periodo p : periodos){
            if (p.getCurso().getId() == periodoCadastro.getCurso().getId() && p.getTurno() == periodoCadastro.getTurno()){
                throw new DataIntegrityViolationException("Turno já cadastrado para este curso");
            }
        }
    }

}

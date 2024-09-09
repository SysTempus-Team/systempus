package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.CargaHoraria;
import br.com.systempus.systempus.domain.Curso;
import br.com.systempus.systempus.domain.Periodo;
import br.com.systempus.systempus.domain.enumerador.Turno;
import br.com.systempus.systempus.error.DataIntegrityViolationException;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.CargaHorariaRepository;
import br.com.systempus.systempus.repository.CursoRepository;
import br.com.systempus.systempus.repository.HorarioAulaRepository;
import br.com.systempus.systempus.repository.PeriodoRepository;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CargaHorariaRepository cargaRepository;

    @Autowired
    private HorarioAulaRepository horarioAulaRepository;

    public Periodo getOne(Integer id){
        Periodo resultado = repository.findById(id).orElseThrow(() -> new NotFoundException(Periodo.class.getSimpleName().toString(), id));
        return resultado;
    }

    public List<Periodo> getAll(){
        List<Periodo> resultado = repository.findAll();
        return resultado;
    }

    public void save(Periodo periodo, Integer idCurso){

        CargaHoraria cargarHoraria = cargaRepository.findById(3).get();

        if (validarTurnoHorario(periodo) == false){
            throw new DataIntegrityViolationException(DataIntegrityViolationException.turnoDoesntMatchHours());
        }

        if (cursoRepository.existsById(idCurso)){
            
            Curso cursoExistente = cursoRepository.findById(idCurso).get();
            
            if (validarHorarios(periodo)){
                // periodo.setCurso(cursoExistente);
                // turnoCadastrado(periodo);
                repository.save(periodo);
            }else{
                throw new DataIntegrityViolationException("Os valores dos períodos precisam condizer com a carga horária de " + cargarHoraria.getCargaHoraria() + " minutos da instituição");
            }
        }else{
            throw new NotFoundException(Curso.class.getSimpleName().toString(), idCurso);
        }
    }

    public void delete(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException(Periodo.class.getSimpleName().toString(), id);
        }
    }

    public void update(Periodo periodo, Integer id){

        CargaHoraria cargarHoraria = cargaRepository.findById(3).get();

        if (validarTurnoHorario(periodo) == false){
            throw new DataIntegrityViolationException(DataIntegrityViolationException.turnoDoesntMatchHours());
        }

        if(repository.existsById(id)){
            if (validarHorarios(periodo)){
                
                Periodo periodoExistente = repository.findById(id).get();
                // periodo.setCurso(periodoExistente.getCurso());

                // turnoCadastrado(periodo);
                
                periodoExistente.setTurno(periodo.getTurno());
                periodoExistente.setInicioIntervalo(periodo.getInicioIntervalo());
                periodoExistente.setFimIntervalo(periodo.getFimIntervalo());
                periodoExistente.setInicioHorario(periodo.getInicioHorario());
                periodoExistente.setFimHorario(periodo.getFimHorario());
    
                repository.saveAndFlush(periodoExistente);
            }else{
                throw new DataIntegrityViolationException("Os valores dos períodos precisam condizer com a carga horária de " + cargarHoraria.getCargaHoraria() + " minutos da instituição");
            }
        }else{
            throw new NotFoundException(Periodo.class.getSimpleName().toString(), periodo.getId());
        }
    }

    public Periodo updatePartial(Map<String, Object> mapValores, Integer id){
        if(repository.existsById(id)){
            Periodo periodoExistente = repository.findById(id).get();

            mapValores.forEach(
                (campo, valor)->{
                    Field field = ReflectionUtils.findField(Periodo.class, campo);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, periodoExistente, valor);
                    field.setAccessible(false);
                }
            );

            repository.saveAndFlush(periodoExistente);
            return periodoExistente;
        }else{
            throw new NotFoundException(Periodo.class.getSimpleName().toString(), id);
        }
    }

    public List<Periodo> getPeriodosByCurso(Integer idCurso){

        if (cursoRepository.existsById(idCurso)){
            Curso cursoExistente = cursoRepository.findById(idCurso).get();
            List<Periodo> periodos = cursoExistente.getPeriodos();
            return periodos;
        }else{
            throw new NotFoundException(Curso.class.getSimpleName().toString(), idCurso);
        }
    }

    private Boolean validarHorarios(Periodo periodo){
        CargaHoraria cargarHoraria = cargaRepository.findById(3).get();

        Duration duracaoAteIntervalo = Duration.between(periodo.getInicioHorario(), periodo.getInicioIntervalo());
        long diferenca1 = duracaoAteIntervalo.toMinutes();

        Duration duracaoAteFim = Duration.between(periodo.getFimIntervalo(), periodo.getFimHorario());
        long diferenca2 = duracaoAteFim.toMinutes();

        long carga = (long) cargarHoraria.getCargaHoraria();

        if ((diferenca1 == carga || diferenca1 == carga * 2) && (diferenca2 == carga || diferenca2 == carga * 2)){
            return true;
        }else{
            return false;
        }
    }

    // private void turnoCadastrado(Periodo periodo){
    //     List<Periodo> periodos = repository.findAllByCurso(periodo.getCurso());

    //     for (Periodo p : periodos){
    //         if (p.getTurno() == periodo.getTurno()){
    //             throw new DataIntegrityViolationException(DataIntegrityViolationException.turnoAlreadyExists(periodo.getTurno().getTurno(), periodo.getCurso().getNome()));
    //         }
    //     }

    // }

    private Boolean validarTurnoHorario(Periodo periodo){
        LocalTime horarioInicio = periodo.getInicioHorario();
        LocalTime horarioFim = periodo.getFimHorario();

        if (periodo.getTurno() == Turno.MATUTINO){
            return isHorarioMatutino(horarioInicio, horarioFim);
        }else if (periodo.getTurno() == Turno.VESPERTINO) {
            return isHorarioVespertino(horarioInicio, horarioFim);
        }else{
            return isHorarioNoturno(horarioInicio, horarioFim);
        }
        
    }

    private Boolean isHorarioMatutino(LocalTime horarioInicio, LocalTime horarioFim){
        return horarioInicio.isAfter(LocalTime.MIDNIGHT) && horarioFim.isBefore(LocalTime.NOON);
    }

    private Boolean isHorarioVespertino(LocalTime horarioInicio, LocalTime horarioFim){
        return horarioInicio.isAfter(LocalTime.NOON) && horarioFim.isBefore(LocalTime.of(18, 00));
    }

    private Boolean isHorarioNoturno(LocalTime horarioInicio, LocalTime horarioFim){
        return horarioInicio.isAfter(LocalTime.of(17, 59)) && horarioFim.isBefore(LocalTime.of(23, 59));
    }
}

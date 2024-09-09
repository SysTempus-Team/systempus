package br.com.systempus.systempus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systempus.systempus.domain.HorarioAula;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.CargaHorariaRepository;
import br.com.systempus.systempus.repository.HorarioAulaRepository;
import br.com.systempus.systempus.repository.PeriodoRepository;

@Service
public class HorarioAulaService {
    
    @Autowired
    private HorarioAulaRepository repository;

    @Autowired
    private CargaHorariaRepository cargaHoraRepository;

    @Autowired
    private PeriodoRepository periodoRepository;

    // public HorarioAula getById(Integer id){
    //     return repository.findById(id).get();
    // }

    public List<HorarioAula> getAll(){
        return repository.findAll();
    }

    public HorarioAula save(HorarioAula horarioAula){
        // if (cargaHoraRepository.existsById(horarioAula.getIdCargaHoraria()) && periodoRepository.existsById(horarioAula.getIdPeriodo())){
            return repository.save(horarioAula);
        // }else{
            // throw new NotFoundException("Carga Horária ou Período não existem no banco de dados");
        // }
    }

    // public HorarioAula update(HorarioAula horarioAula, Integer id){
    //     if (repository.existsById(id)){
    //         HorarioAula existente = repository.findById(id).get();

    //         return repository.saveAndFlush(existente);
    //     }else{
    //         return null;
    //     }
    // }

    // public void deleteById(Integer id){
    //     repository.deleteById(id);
    // }

}

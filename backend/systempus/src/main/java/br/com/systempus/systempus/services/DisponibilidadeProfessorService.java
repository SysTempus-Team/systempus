package br.com.systempus.systempus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.systempus.systempus.domain.DisponibilidadeProfessor;
import br.com.systempus.systempus.repository.DisciplinaRepository;
import br.com.systempus.systempus.repository.DisponibilidadeProfessorRepository;
import br.com.systempus.systempus.repository.HorarioAulaRepository;

@Service
public class DisponibilidadeProfessorService {
    
    @Autowired
    private DisponibilidadeProfessorRepository repository;

    @Autowired
    private HorarioAulaRepository horarioAulaRepository;

    @Autowired
    private DisciplinaRepository profRepository;

    // public DisponibilidadeProfessor getById(Integer id){
    //     // return repository.findById(id).get();
    // }

    public List<DisponibilidadeProfessor> getAll(){
        return repository.findAll();
    }

    public DisponibilidadeProfessor save(DisponibilidadeProfessor disponibilidadeProfessor){
        // if (profRepository.existsById(disponibilidadeProfessor.getIdProfessor()) && horarioAulaRepository.existsById(disponibilidadeProfessor.getIdHorarioAula())){
            return repository.save(disponibilidadeProfessor);
        // }else{
            // throw new DataIntegrityViolationException("Disponibilidade ou Professor não existentes no banco de dados");
        // }

    }

    // public DisponibilidadeProfessor update(DisponibilidadeProfessor disponibilidadeProfessor, Integer id){
    //     if (repository.existsById(id)){
    //         DisponibilidadeProfessor existente = repository.findById(id).get();

    //         return repository.saveAndFlush(existente);
    //     }else{
    //         return null;
    //     }
    // }

    // public void deleteById(Integer id){
    //     repository.deleteById(id);
    // }

}

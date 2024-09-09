package br.com.systempus.systempus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systempus.systempus.domain.HorarioDisciplina;
import br.com.systempus.systempus.repository.HorarioDisciplinaRepository;

@Service
public class HorarioDisciplinaService {
    
    @Autowired
    private HorarioDisciplinaRepository repository;

    // public HorarioDisciplina getById(Integer id){
    //     return repository.findById(id).get();
    // }

    public List<HorarioDisciplina> getAll(){
        return repository.findAll();
    }

    public HorarioDisciplina save(HorarioDisciplina horarioDisciplina){
        return repository.save(horarioDisciplina);
    }

    // public HorarioDisciplina update(HorarioDisciplina horarioDisciplina, Integer id){
    //     if (repository.existsById(id)){
    //         HorarioDisciplina existente = repository.findById(id).get();

    //         return repository.saveAndFlush(existente);
    //     }else{
    //         return null;
    //     }
    // }

    // public void deleteById(Integer id){
    //     repository.deleteById(id);
    // }

}

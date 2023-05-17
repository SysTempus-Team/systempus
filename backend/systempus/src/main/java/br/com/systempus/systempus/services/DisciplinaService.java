package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Disciplina;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public Disciplina insert(Disciplina disciplina){
        Disciplina resultado = repository.save(disciplina);
        return resultado;
    }

    public Disciplina getOne(Integer id){
        Disciplina resultado = repository.findById(id).orElseThrow(() -> new NotFoundException("Disciplina com o id=" + id + " não existe!"));
        return resultado;
    }

    public List<Disciplina> getAll(){
        List<Disciplina> resultado = repository.findAll();
        return resultado;
    }

    public void delete(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException("Disciplina com o id=" + id + " não existe!");
        }
    }

    public void put(Disciplina disciplina, Integer id){
        if(repository.existsById(id)){
            Disciplina disciplinaExistente = repository.findById(id).get();

            disciplinaExistente.setNome(disciplina.getNome());
            disciplinaExistente.setModulo(disciplina.getModulo());
            disciplinaExistente.setProfessores(disciplina.getProfessores());

            repository.saveAndFlush(disciplinaExistente);
        }else{
            throw new NotFoundException("Disciplina com o id=" + id + " não existe!");
        }
    }

    public Disciplina patch(Map<String, Object> disciplina, Integer id){
        if(repository.existsById(id)){
            Disciplina disciplinaExistente = repository.findById(id).get();

            disciplina.forEach(
                (campo, valor)->{
                    Field field = ReflectionUtils.findField(Disciplina.class, campo);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, disciplinaExistente, valor);
                    field.setAccessible(false);
                }
            );

            repository.saveAndFlush(disciplinaExistente);
            return disciplinaExistente;
        }else{
            throw new NotFoundException("Disciplina com o id=" + id + " não existe!");
        }
    }
}

package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Disciplina;
import br.com.systempus.systempus.error.IllegalStateException;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.DisciplinaRepository;
import br.com.systempus.systempus.services.interfaces.IDisciplinaService;

@Service
public class DisciplinaService implements IDisciplinaService{

    @Autowired
    private DisciplinaRepository repository;

    public Disciplina getOne(Integer id){
        Disciplina resultado = repository.findById(id).orElseThrow(() -> new NotFoundException(Disciplina.class.getSimpleName().toString(), id));
        return resultado;
    }

    public List<Disciplina> getAll(){
        List<Disciplina> resultado = repository.findAll();
        return resultado;
    }

    public void save(Disciplina disciplina){
        if (disciplina.getId() == null)
            repository.save(disciplina);
        throw new IllegalStateException(Disciplina.class.getSimpleName().toString());
    }

    public void delete(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException(Disciplina.class.getSimpleName().toString(), id);
        }
    }

    public void update(Disciplina disciplina){
        if(repository.existsById(disciplina.getId())){
            Disciplina disciplinaExistente = repository.findById(disciplina.getId()).get();

            disciplinaExistente.setNome(disciplina.getNome());
            disciplinaExistente.setModulo(disciplina.getModulo());
            disciplinaExistente.setProfessores(disciplina.getProfessores());

            repository.saveAndFlush(disciplinaExistente);
        }else{
            throw new NotFoundException(Disciplina.class.getSimpleName().toString(), disciplina.getId());
        }
    }

    public Disciplina updatePartial(Map<String, Object> mapValores, Integer id){
        if(repository.existsById(id)){
            Disciplina disciplinaExistente = repository.findById(id).get();

            mapValores.forEach(
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
            throw new NotFoundException(Disciplina.class.getSimpleName().toString(), id);
        }
    }
}

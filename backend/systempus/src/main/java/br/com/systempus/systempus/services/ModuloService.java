package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Modulo;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.ModuloRepository;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository repository;

    public Modulo insert(Modulo modulo){
        Modulo resultado = repository.save(modulo);
        return resultado;
    }

    public List<Modulo> getAll(){
        List<Modulo> resultado = repository.findAll();
        return resultado;
    }

    public Modulo getOne(Integer id){
        Modulo resultado = repository.findById(id).orElseThrow(() -> new NotFoundException("Modulo com o id=" + id + " não existe!"));
        return resultado;
    }

    public void delete(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException("Modulo com o id=" + id + " não existe!");
        }
    }

    public void put(Modulo modulo, Integer id){
        if(repository.existsById(id)){
            Modulo moduloExistente = repository.findById(id).get();

            moduloExistente.setNumero(modulo.getNumero());
            moduloExistente.setDataInicio(modulo.getDataInicio());
            moduloExistente.setDataFim(modulo.getDataFim());
            moduloExistente.setCurso(modulo.getCurso());
            moduloExistente.setDisciplinas(modulo.getDisciplinas());

            repository.saveAndFlush(moduloExistente);
        }else{
            throw new NotFoundException("Modulo com o id=" + id + " não existe!");
        }
    }

    public Modulo patch(Map<String, Object> modulo, Integer id){
        if(repository.existsById(id)){
            Modulo moduloExistente = repository.findById(id).get();

            modulo.forEach(
                (campo, valor)->{
                    Field field = ReflectionUtils.findField(Modulo.class, campo);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, moduloExistente, valor);
                }
            );

            repository.saveAndFlush(moduloExistente);
            return moduloExistente;
        }else{
            throw new NotFoundException("Modulo com o id=" + id + " não existe!");
        }
    }
}

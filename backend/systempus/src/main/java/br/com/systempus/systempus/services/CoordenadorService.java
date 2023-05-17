package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Coordenador;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
    @Autowired
    private CoordenadorRepository repository;

    public Coordenador getOne(Integer id){
        Coordenador resultado = repository.findById(id).orElseThrow(()-> new NotFoundException("Coordenador com o id=" + id + " não existe!"));
        return resultado;
    }

    public List<Coordenador> getAll(){
        List<Coordenador> resultado = repository.findAll();
        return resultado;
    }

    public Coordenador insert(Coordenador coordenador){
        Coordenador resultado = repository.save(coordenador);
        return resultado;
    }

    public void delete(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException("Coordenador com o id=" + id + " não existe!");
        }
    }

    public void put(Coordenador coordenador, Integer id){
        if (repository.existsById(id)){
            Coordenador coordenadorExistente = repository.findById(id).get();

            coordenadorExistente.setCpf(coordenador.getCpf());
            coordenadorExistente.setNome(coordenador.getNome());
            coordenadorExistente.setTelefone(coordenador.getTelefone());
            coordenadorExistente.setCursos(coordenador.getCursos());

            repository.saveAndFlush(coordenadorExistente);
        }else{
            throw new NotFoundException("Coordenador com o id=" + id + " não existe!");
        }
    }

    public Coordenador patch(Map<String, Object> coordenador, Integer id){
        if (repository.existsById(id)){
            Coordenador coordenadorExistente = repository.findById(id).get();

            coordenador.forEach(
                (campo, valor)->{
                        Field field = ReflectionUtils.findField(Coordenador.class, campo);
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, coordenadorExistente, valor);
                    }
                );
                repository.saveAndFlush(coordenadorExistente);
                return coordenadorExistente;
        }else{
            throw new NotFoundException("Coordenador com o id=" + id + " não existe!");
        }
    }
}
package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Curso;
import br.com.systempus.systempus.domain.enumerador.NivelEnsino;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> getAll() {
        List<Curso> resultado = repository.findAll();
        return resultado;
    }

    public Curso getOne(Integer id) {
        Curso resultado = repository.findById(id).orElseThrow(() -> new NotFoundException("Curso com id=" + id + " não existe!"));
        return resultado;
    }

    public Curso insert(Curso curso) {
        Curso resultado = repository.save(curso);
        return resultado;
    }

    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Curso com id=" + id + " não existe!");
        }
    }

    public void put(Curso curso, Integer id) {
        if (repository.existsById(id)) {
            Curso cursoExistente = repository.findById(id).get();

            cursoExistente.setNome(curso.getNome());
            cursoExistente.setQtdPeriodos(curso.getQtdPeriodos());
            cursoExistente.setCargaTotal(curso.getCargaTotal());
            cursoExistente.setCoordenador(curso.getCoordenador());
            cursoExistente.setModulos(curso.getModulos());

            repository.saveAndFlush(cursoExistente);

        } else {
            throw new NotFoundException("Curso com id=" + id + " não existe!");
        }
    }


    public Curso patch(Map<String, Object> mapCampoValor, Integer id) {
        if (repository.existsById(id)) {
            Curso cursoExistente = repository.findById(id).get();

            mapCampoValor.forEach(
                    (campo, valor) -> {
                        Field field = ReflectionUtils.findField(Curso.class, campo);
                        field.setAccessible(true);

                        if (!field.getType().isEnum()){
                            ReflectionUtils.setField(field, cursoExistente, valor);
                            field.setAccessible(false);
                        }//else{
                            // Enum.valueOf((Class<Enum<?>>)field.getType(), valor.toString());
                            // ReflectionUtils.setField(field, cursoExistente, );
                        //}
                    }
            );

            repository.saveAndFlush(cursoExistente);
            return cursoExistente;
        } else {
            throw new NotFoundException("Curso com id=" + id + " não existe!");
        }
    }
}
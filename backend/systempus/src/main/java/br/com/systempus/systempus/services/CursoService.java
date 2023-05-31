package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Curso;
import br.com.systempus.systempus.error.IllegalStateException;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.CursoRepository;
import br.com.systempus.systempus.services.interfaces.ICursoService;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private CursoRepository repository;

    public List<Curso> getAll() {
        List<Curso> resultado = repository.findAll();
        return resultado;
    }

    public Curso getOne(Integer id) {
        Curso resultado = repository.findById(id).orElseThrow(() -> new NotFoundException(Curso.class.getSimpleName().toString(), id));
        return resultado;
    }

    public void save(Curso curso) {
        if (curso.getId() == null)
            repository.save(curso);
        throw new IllegalStateException(Curso.class.getSimpleName().toString());
    }

    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException(Curso.class.getSimpleName().toString(), id);
        }
    }

    public void update(Curso curso) {
        if (repository.existsById(curso.getId())) {
            Curso cursoExistente = repository.findById(curso.getId()).get();

            cursoExistente.setNome(curso.getNome());
            cursoExistente.setQtdPeriodos(curso.getQtdPeriodos());
            cursoExistente.setCargaTotal(curso.getCargaTotal());
            cursoExistente.setCoordenador(curso.getCoordenador());
            cursoExistente.setModulos(curso.getModulos());

            repository.saveAndFlush(cursoExistente);

        } else {
            throw new NotFoundException(Curso.class.getSimpleName().toString(), curso.getId());
        }
    }


    public Curso updatePartial(Map<String, Object> mapValores, Integer id) {
        if (repository.existsById(id)) {
            Curso cursoExistente = repository.findById(id).get();

            mapValores.forEach(
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
            throw new NotFoundException(Curso.class.getSimpleName().toString(), id);
        }
    }

}
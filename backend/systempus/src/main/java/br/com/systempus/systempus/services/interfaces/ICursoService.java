package br.com.systempus.systempus.services.interfaces;

import java.util.List;
import java.util.Map;

import br.com.systempus.systempus.domain.Curso;

public interface ICursoService {
    public List<Curso> getAll();

    public Curso getOne(Integer id);

    public void save(Curso curso);

    public void delete(Integer id);

    public void update(Curso curso);

    public Curso updatePartial(Map<String, Object> mapValores, Integer id);
}
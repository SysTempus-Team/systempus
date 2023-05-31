package br.com.systempus.systempus.services.interfaces;

import java.util.List;
import java.util.Map;

import br.com.systempus.systempus.domain.Professor;

public interface IProfessorService {
    public List<Professor> getAll();

    public Professor getOne(Integer id);

    public void save(Professor professor);

    public void delete(Integer id);

    public void update(Professor professor);

    public Professor updatePartial(Map<String, Object> mapValores, Integer id);
}

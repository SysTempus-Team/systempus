package br.com.systempus.systempus.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import br.com.systempus.systempus.domain.Professor;
import br.com.systempus.systempus.error.NotFoundException;
import br.com.systempus.systempus.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public List<Professor> getAll() {
        List<Professor> resultado = repository.findAll();
        return resultado;
    }

    public Professor getOne(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Professor com o id=" + id + "não existe!"));
    }

    public Professor save(Professor professor){
        return repository.save(professor);
    }

    public void delete(Integer id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new NotFoundException("Professor com o id=" + id + " não existe!");
        }
    }

    public void update(Professor professor, Integer id){
        if(repository.existsById(id)){
            Professor professorExistente = repository.findById(id).get();//Pegar Professor existente no repository

            professorExistente.setCpf(professor.getCpf());//Setar CPF do Professor Existente
            professorExistente.setNome(professor.getNome());
            professorExistente.setTelefone(professor.getTelefone());
            professorExistente.setDisciplinas(professor.getDisciplinas());
            professorExistente.setCursos(professor.getCursos());

            repository.saveAndFlush(professorExistente);
        }else{
            throw new NotFoundException("Professor com o id=" + id + " não existe!");
        }
    }


    public Professor patch(Map<String, Object> professor, Integer id){//Conjunto de valores
        if(repository.existsById(id)){
            Professor professorExistente = repository.findById(id).get();//Pegar Professor existente no repository

            professor.forEach(//Transita pela classe professor passada
                (campo, valor)->{//Parâmetros referentes ao campo a ser preenchido e aos valores [String, Professor]
                    Field field = ReflectionUtils.findField(Professor.class, campo);//Classe Field procura o campo passado na classe professor
                    field.setAccessible(true);//Classe Field abre o acesso ao atributo da classe[public]
                    ReflectionUtils.setField(field, professorExistente, valor);//Passa os parâmetros [atributo da classe, classe desejada, valor desejado para o atributo]
                    field.setAccessible(false);//Classe Field fecha o acesso ao atributo da classe[private]
                }
            );

            repository.saveAndFlush(professorExistente);
            return professorExistente;
        }else{
            throw new NotFoundException("Professor com o id=" + id + " não existe!");
        }
    }



}

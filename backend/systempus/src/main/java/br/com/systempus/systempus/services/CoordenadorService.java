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
public class CoordenadorService implements ICoordenadorService{
    @Autowired
    private CoordenadorRepository repository;

    public Coordenador getOne(Integer id) {
        Coordenador resultado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Coordenador com o id=" + id + " não existe!"));
        return resultado;
    }

    public List<Coordenador> getAll() {
        List<Coordenador> resultado = repository.findAll();
        return resultado;
    }

    public void insert(Coordenador coordenador) {
        if ((coordenador.getId() == null)) {
            repository.save(coordenador);
        } else {
            throw new IllegalStateException("Coordenador com o id=" + coordenador.getId() + " já existe!");
        }
    }

    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Coordenador com o id=" + id + " não existe!");
        }
    }

    public void update(Coordenador coordenador) {

        if (!repository.existsById(coordenador.getId()))
            throw new NotFoundException("Coordenador com o id=" + coordenador.getId() + " não existe!");

        Coordenador coordenadorExistente = repository.findById(coordenador.getId()).get();

        coordenadorExistente.setCpf(coordenador.getCpf());
        coordenadorExistente.setNome(coordenador.getNome());
        coordenadorExistente.setTelefone(coordenador.getTelefone());
        coordenadorExistente.setCursos(coordenador.getCursos());

        repository.saveAndFlush(coordenadorExistente);

    }

    public Coordenador updatePartial(Map<String, Object> mapValores, Integer id) {

        if (!repository.existsById(id))
            throw new NotFoundException("Coordenador com o id=" + id + " não existe!");

        Coordenador coordenadorExistente = repository.findById(id).get();

        mapValores.forEach(
                (campo, valor) -> {
                    Field field = ReflectionUtils.findField(Coordenador.class, campo);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, coordenadorExistente, valor);
                });
        repository.saveAndFlush(coordenadorExistente);
        return coordenadorExistente;

    }
}
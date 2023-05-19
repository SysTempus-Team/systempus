package br.com.systempus.systempus.services;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.systempus.systempus.domain.Coordenador;

@Service
public interface ICoordenadorService{

    public Coordenador getOne(Integer id);

    public List<Coordenador> getAll();

    public void insert(Coordenador coordenador);

    public void delete(Integer id);

    public void update(Coordenador coordenador);

	public Coordenador updatePartial(Map<String, Object> mapValores, Integer id);

    

}
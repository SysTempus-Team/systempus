package br.com.systempus.systempus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systempus.systempus.domain.Teste;
import br.com.systempus.systempus.repository.TesteRepository;

@Service
public class TesteService {

    @Autowired
    private TesteRepository repository;

    public Teste save(Teste teste){
        return repository.save(teste);
    }

}
package br.com.systempus.systempus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.Teste;

public interface TesteRepository extends JpaRepository<Teste, Integer> {
    
}

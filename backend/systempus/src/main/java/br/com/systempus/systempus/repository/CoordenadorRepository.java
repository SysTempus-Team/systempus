package br.com.systempus.systempus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer>{
    
}

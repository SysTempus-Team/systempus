package br.com.systempus.systempus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    
}

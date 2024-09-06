package br.com.systempus.systempus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.DisponibilidadeProfessor;
import br.com.systempus.systempus.domain.embeddableclass.DisponibilidadeProfessorId;

public interface DisponibilidadeProfessorRepository extends JpaRepository<DisponibilidadeProfessor, DisponibilidadeProfessorId> {
    
}

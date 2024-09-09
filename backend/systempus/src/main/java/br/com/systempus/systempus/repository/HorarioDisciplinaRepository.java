package br.com.systempus.systempus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.HorarioDisciplina;
import br.com.systempus.systempus.domain.embeddableclass.HorarioDisciplinaId;

public interface HorarioDisciplinaRepository extends JpaRepository<HorarioDisciplina, HorarioDisciplinaId> {
    
}

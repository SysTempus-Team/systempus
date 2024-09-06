package br.com.systempus.systempus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.HorarioAula;
import br.com.systempus.systempus.domain.embeddableclass.HorarioAulaId;

public interface HorarioAulaRepository extends JpaRepository<HorarioAula, HorarioAulaId> {
    

}

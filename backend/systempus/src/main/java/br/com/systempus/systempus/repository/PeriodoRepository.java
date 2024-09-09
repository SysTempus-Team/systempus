package br.com.systempus.systempus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.systempus.systempus.domain.Curso;
import br.com.systempus.systempus.domain.Periodo;
import br.com.systempus.systempus.domain.enumerador.Turno;

public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

    // List<Periodo> findAllByCurso(Curso curso);

}

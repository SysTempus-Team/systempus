package br.com.systempus.systempus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

import br.com.systempus.systempus.domain.Curso;
import br.com.systempus.systempus.services.CursoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curso> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok().body(cursoService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        return ResponseEntity.ok().body(cursoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Curso> post(@Valid @RequestBody Curso curso, UriComponentsBuilder uriBuilder) {

        System.out.println("Indo... "+curso);

        Curso novoCurso = cursoService.insert(curso);

        System.out.println("Voltando... "+curso);

        URI uri = uriBuilder.path("api/v1/curso").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(novoCurso);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Integer id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Curso> put(@Valid @RequestBody Curso curso, @PathVariable Integer id) {
        cursoService.put(curso, id);
        return ResponseEntity.ok().body(curso);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Curso> patch(@RequestBody Map<String, Object> curso, @PathVariable Integer id) {
        Curso cursoAtualizado = cursoService.patch(curso, id);
        return ResponseEntity.ok().body(cursoAtualizado);
    }

}

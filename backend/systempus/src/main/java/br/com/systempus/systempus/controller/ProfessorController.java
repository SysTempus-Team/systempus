package br.com.systempus.systempus.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

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

import br.com.systempus.systempus.domain.Professor;
import br.com.systempus.systempus.services.ProfessorService;

@RestController
@RequestMapping(value = "api/v1/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(professorService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAll(){
        return ResponseEntity.ok().body(professorService.getAll());
    }

    @PostMapping
    public ResponseEntity<Professor> post(@RequestBody Professor professor, UriComponentsBuilder uriBuilder){
        Professor novoProfessor = professorService.save(professor);
        URI uri = uriBuilder.path("api/v1/professor").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(novoProfessor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Professor> delete(@PathVariable Integer id){
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Professor> put(@RequestBody Professor professor, @PathVariable Integer id){
        professorService.update(professor, id);
        return ResponseEntity.ok().body(professor);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Professor> patch(@RequestBody Map<String, Object> professor, @PathVariable Integer id){
        Professor professorAtualizado = professorService.patch(professor, id);
        return ResponseEntity.ok().body(professorAtualizado);
    }

}
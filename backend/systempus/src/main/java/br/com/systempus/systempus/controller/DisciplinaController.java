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

import br.com.systempus.systempus.domain.Disciplina;
import br.com.systempus.systempus.services.DisciplinaService;

@RestController
@RequestMapping(value = "api/v1/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Disciplina> post(@RequestBody Disciplina disciplina, UriComponentsBuilder uriBuilder){
        Disciplina novaDisciplina = service.insert(disciplina);
        URI uri = uriBuilder.path("api/v1/disciplina").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(novaDisciplina);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Disciplina> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Disciplina> put(@RequestBody Disciplina disciplina, @PathVariable Integer id){
        service.put(disciplina, id);
        return ResponseEntity.ok().body(disciplina);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Disciplina> patch(@RequestBody Map<String, Object> disciplina, @PathVariable Integer id){
        Disciplina disciplinaAtualizada = service.patch(disciplina, id);
        return ResponseEntity.ok().body(disciplinaAtualizada);
    }
}

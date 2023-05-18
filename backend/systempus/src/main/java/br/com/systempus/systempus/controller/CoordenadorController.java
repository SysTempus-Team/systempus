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

import br.com.systempus.systempus.domain.Coordenador;
import br.com.systempus.systempus.services.CoordenadorService;

@RestController
@RequestMapping(value = "api/v1/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Coordenador> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(coordenadorService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Coordenador>> getAll(){
        return ResponseEntity.ok().body(coordenadorService.getAll());
    }

    @PostMapping
    public ResponseEntity<Coordenador> post(@RequestBody Coordenador coordenador, UriComponentsBuilder uriBuilder){
        Coordenador novoCoordenador = coordenadorService.insert(coordenador);
        URI uri = uriBuilder.path("api/v1/coordenador").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(novoCoordenador);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Coordenador> delete(@PathVariable Integer id){
        coordenadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Coordenador> put(@RequestBody Coordenador coordenador, @PathVariable Integer id){
        coordenadorService.put(coordenador, id);
        return ResponseEntity.ok().body(coordenador);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Coordenador> patch(@RequestBody Map<String, Object> coordenador, @PathVariable Integer id){
        Coordenador coordenaAtualizado = coordenadorService.patch(coordenador, id);
        return ResponseEntity.ok().body(coordenaAtualizado);
    }

}
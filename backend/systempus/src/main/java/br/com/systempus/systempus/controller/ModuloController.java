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

import br.com.systempus.systempus.domain.Modulo;
import br.com.systempus.systempus.services.ModuloService;

@RestController
@RequestMapping(value = "api/v1/modulo")
public class ModuloController {

    @Autowired
    private ModuloService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Modulo> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Modulo>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Modulo> post(@RequestBody Modulo modulo, UriComponentsBuilder uriBuilder){
        Modulo novoModulo = service.insert(modulo);
        URI uri = uriBuilder.path("api/v1/modulo").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(novoModulo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Modulo> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Modulo> put(@RequestBody Modulo modulo, @PathVariable Integer id){
        service.put(modulo, id);
        return ResponseEntity.ok().body(modulo);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Modulo> patch(@RequestBody Map<String, Object> modulo, @PathVariable Integer id){
        Modulo moduloAtualizado = service.patch(modulo, id);
        return ResponseEntity.ok().body(moduloAtualizado);
    }
}

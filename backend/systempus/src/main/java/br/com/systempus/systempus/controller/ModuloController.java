package br.com.systempus.systempus.controller;

import java.net.URI;
import java.net.URISyntaxException;
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


import br.com.systempus.systempus.domain.Modulo;
import br.com.systempus.systempus.services.ModuloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/v1/modulo")
public class ModuloController {

    @Autowired
    private ModuloService service;


    @GetMapping("/{id}")
    public ResponseEntity<Modulo> getOne(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Modulo>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Modulo> save(@RequestBody Modulo modulo, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException{
        service.save(modulo);

        StringBuffer path = new StringBuffer();

        path.append(request.getRequestURI())
            .append("/")
            .append(modulo.getId());

        URI uri = new URI(path.toString());

        return ResponseEntity.created(uri).body(modulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Modulo> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Modulo> update(@RequestBody Modulo modulo){
        service.update(modulo);
        return ResponseEntity.ok().body(modulo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Modulo> updatePartial(@RequestBody Map<String, Object> mapValores, @PathVariable Integer id){
        Modulo moduloAtualizado = service.updatePartial(mapValores, id);
        return ResponseEntity.ok().body(moduloAtualizado);
    }
}

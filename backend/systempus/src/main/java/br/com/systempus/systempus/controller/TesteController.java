package br.com.systempus.systempus.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.systempus.systempus.domain.Periodo;
import br.com.systempus.systempus.domain.Teste;
import br.com.systempus.systempus.services.TesteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/v1/teste/")
public class TesteController {
    
    @Autowired
    private TesteService service;

    @PostMapping
    public ResponseEntity<Teste> save(@RequestBody Teste teste, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException{
        service.save(teste);

        StringBuffer path = new StringBuffer();

        path.append(request.getRequestURI())
            .append("/")
            .append(teste.getId());


        URI uri = new URI(path.toString());

        return ResponseEntity.created(uri).body(teste);
    }
    

}

package com.github.rycardofarias.ordem_de_servico.resource;

import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

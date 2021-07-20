package com.github.rycardofarias.ordem_de_servico.resource;

import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.dto.TecnicoDTO;
import com.github.rycardofarias.ordem_de_servico.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        TecnicoDTO objDTO = new TecnicoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<TecnicoDTO> listDTO = service.findAll()
                .stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO objDTO){
        Tecnico newObj = service.create(objDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}

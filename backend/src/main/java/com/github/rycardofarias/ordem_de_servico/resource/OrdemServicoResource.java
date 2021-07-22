package com.github.rycardofarias.ordem_de_servico.resource;

import com.github.rycardofarias.ordem_de_servico.dto.OrdemServicoDTO;
import com.github.rycardofarias.ordem_de_servico.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/ordemservico")
public class OrdemServicoResource{

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServicoDTO> findById (@PathVariable Integer id){
        OrdemServicoDTO ordemServicoDTO = new OrdemServicoDTO(ordemServicoService.findById(id));
        return ResponseEntity.ok().body(ordemServicoDTO);
    }

    @GetMapping
    public  ResponseEntity<List<OrdemServicoDTO>> findAll(){
        List<OrdemServicoDTO> list = ordemServicoService.findAll()
                .stream().map(obj -> new OrdemServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> create( @RequestBody OrdemServicoDTO ordemServicoDTO){
        ordemServicoDTO = new OrdemServicoDTO(ordemServicoService.create(ordemServicoDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServicoDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<OrdemServicoDTO> update (@Valid @RequestBody OrdemServicoDTO ordemServicoDTO){
        ordemServicoDTO = new OrdemServicoDTO(ordemServicoService.update(ordemServicoDTO));
        return ResponseEntity.ok().body(ordemServicoDTO);
    }
}

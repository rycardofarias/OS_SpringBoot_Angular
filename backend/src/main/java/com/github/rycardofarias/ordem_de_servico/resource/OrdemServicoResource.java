package com.github.rycardofarias.ordem_de_servico.resource;

import com.github.rycardofarias.ordem_de_servico.dto.OrdemServicoDTO;
import com.github.rycardofarias.ordem_de_servico.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

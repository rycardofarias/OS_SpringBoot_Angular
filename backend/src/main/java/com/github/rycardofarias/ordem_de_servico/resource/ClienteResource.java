package com.github.rycardofarias.ordem_de_servico.resource;

import com.github.rycardofarias.ordem_de_servico.dto.ClienteDTO;
import com.github.rycardofarias.ordem_de_servico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value= "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        ClienteDTO objDTO = new ClienteDTO(clienteService.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<ClienteDTO> listDTO = clienteService.findAll()
                .stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}

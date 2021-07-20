package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.dto.TecnicoDTO;
import com.github.rycardofarias.ordem_de_servico.repository.TecnicoRepository;
import com.github.rycardofarias.ordem_de_servico.resource.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: "+ Tecnico.class.getName())
        );
    }
    public List<Tecnico> findAll(){
        return tecnicoRepository.findAll();
    }
    public Tecnico create(TecnicoDTO objDTO){
        return tecnicoRepository.save(
                new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone())
        );
    }
}

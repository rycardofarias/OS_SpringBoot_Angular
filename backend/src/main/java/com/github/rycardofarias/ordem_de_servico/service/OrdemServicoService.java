package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.OrdemServico;
import com.github.rycardofarias.ordem_de_servico.repository.OrdemServicoRepository;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico findById(Integer id){
        Optional<OrdemServico>  obj = ordemServicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " +OrdemServico.class.getName()
        ));
    }
}

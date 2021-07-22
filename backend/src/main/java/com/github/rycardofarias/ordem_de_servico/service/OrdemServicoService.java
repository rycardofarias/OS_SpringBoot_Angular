package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.Cliente;
import com.github.rycardofarias.ordem_de_servico.domain.OrdemServico;
import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Prioridade;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Status;
import com.github.rycardofarias.ordem_de_servico.dto.OrdemServicoDTO;
import com.github.rycardofarias.ordem_de_servico.repository.OrdemServicoRepository;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public OrdemServico findById(Integer id){
        Optional<OrdemServico>  obj = ordemServicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " +OrdemServico.class.getName()
        ));
    }
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    public OrdemServico create(@Valid OrdemServicoDTO ordemServicoDTO) {
        return fromDTO(ordemServicoDTO);
    }

    public OrdemServico update(@Valid OrdemServicoDTO ordemServicoDTO) {
        findById(ordemServicoDTO.getId());
        return fromDTO(ordemServicoDTO);
    }

    private OrdemServico fromDTO(OrdemServicoDTO ordemServicoDTO){
        OrdemServico newObj = new OrdemServico();
        newObj.setId(ordemServicoDTO.getId());
        newObj.setObservacoes(ordemServicoDTO.getObservacoes());
        newObj.setPrioridade(Prioridade.toEnum(ordemServicoDTO.getPrioridade()));
        newObj.setStatus(Status.toEnum(ordemServicoDTO.getStatus()));

        Tecnico tecnico = tecnicoService.findById(ordemServicoDTO.getTecnico());
        Cliente cliente = clienteService.findById(ordemServicoDTO.getCliente());

        newObj.setTecnico(tecnico);
        newObj.setCliente(cliente);

        if(newObj.getStatus().getCod().equals(2)){
            newObj.setDataFechamento(LocalDateTime.now());
        }
        return ordemServicoRepository.save(newObj);
    }
}

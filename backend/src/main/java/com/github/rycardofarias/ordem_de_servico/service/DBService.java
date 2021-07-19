package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.Cliente;
import com.github.rycardofarias.ordem_de_servico.domain.OrdemServico;
import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Prioridade;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Status;
import com.github.rycardofarias.ordem_de_servico.repository.ClienteRepository;
import com.github.rycardofarias.ordem_de_servico.repository.OrdemServicoRepository;
import com.github.rycardofarias.ordem_de_servico.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public void instanciaDB(){

        Tecnico t1 = new Tecnico (null, "Ricardo Farias", "144.785.300-84", "(83) 99999-9999");
        Cliente c1 = new Cliente (null, "Vagner Sousa", "598.508.200-80", "(83) 99999-9998");

        OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "Teste creat OD", Status.ANDAMENTO, t1, c1);

        tecnicoRepository.saveAll(Arrays.asList(t1));
        clienteRepository.saveAll(Arrays.asList(c1));
        ordemServicoRepository.saveAll(Arrays.asList(os1));

    }
}

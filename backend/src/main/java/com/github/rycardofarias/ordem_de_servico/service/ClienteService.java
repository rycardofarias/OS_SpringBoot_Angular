package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.Cliente;
import com.github.rycardofarias.ordem_de_servico.repository.ClienteRepository;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+ id + "Cliente: " + Cliente.class.getName())
        );
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}

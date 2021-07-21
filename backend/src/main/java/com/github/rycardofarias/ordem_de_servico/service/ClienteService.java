package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.Cliente;
import com.github.rycardofarias.ordem_de_servico.domain.Pessoa;
import com.github.rycardofarias.ordem_de_servico.dto.ClienteDTO;
import com.github.rycardofarias.ordem_de_servico.repository.ClienteRepository;
import com.github.rycardofarias.ordem_de_servico.repository.PessoaRepository;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.DataIntegratyViolationException;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+ id + "Cliente: " + Cliente.class.getName())
        );
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    private Pessoa findByCPF(ClienteDTO objDTO){
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if(obj != null){
            return obj;
        }
        return null;
    }

    public Cliente create(ClienteDTO clienteDTO) {
        if(findByCPF(clienteDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados.");
        }
        return clienteRepository.save(
                new Cliente( null, clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone())
        );
    }

    public Cliente update(Integer id, ClienteDTO clienteDTO) {
        Cliente oldObj = findById(id);

        if (findByCPF(clienteDTO) != null && findByCPF(clienteDTO).getId() != id){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados.");
        }

        oldObj.setNome(clienteDTO.getNome());
        oldObj.setCpf(clienteDTO.getCpf());
        oldObj.setTelefone(clienteDTO.getTelefone());

        return clienteRepository.save(oldObj);
    }
}

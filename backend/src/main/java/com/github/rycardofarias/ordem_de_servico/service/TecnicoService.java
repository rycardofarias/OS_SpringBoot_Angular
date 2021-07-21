package com.github.rycardofarias.ordem_de_servico.service;

import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.dto.TecnicoDTO;
import com.github.rycardofarias.ordem_de_servico.repository.TecnicoRepository;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.DataIntegratyViolationException;
import com.github.rycardofarias.ordem_de_servico.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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
        if(findByCPF(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados.");
        }
        return tecnicoRepository.save(
                    new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone())
            );
    }
    private Tecnico findByCPF(TecnicoDTO objDTO){
        Tecnico obj = tecnicoRepository.findByCPF(objDTO.getCpf());
        if(obj != null){
            return obj;
        }
        return null;
    }
    public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
        Tecnico oldObj = findById(id);

        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados.");
        }
        oldObj.setNome(objDTO.getNome());
        oldObj.setCpf(objDTO.getCpf());
        oldObj.setTelefone(objDTO.getTelefone());
        return tecnicoRepository.save(oldObj);
    }

    public void delete(Integer id) {
        Tecnico obj = findById(id);
        if(obj.getList().size() > 0){
            throw new DataIntegratyViolationException("Tecnico possui Ordem de Serviço, não pode ser delatado!");
        }
        tecnicoRepository.deleteById(id);
    }
}

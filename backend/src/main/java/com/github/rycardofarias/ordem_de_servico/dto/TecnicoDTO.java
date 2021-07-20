package com.github.rycardofarias.ordem_de_servico.dto;

import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public class TecnicoDTO implements Serializable {

    private static final long serialVersiionUID = 1L;

    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    private String telefone;

    public TecnicoDTO(Tecnico obj){
        super();
        this.id  = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.telefone = obj.getTelefone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

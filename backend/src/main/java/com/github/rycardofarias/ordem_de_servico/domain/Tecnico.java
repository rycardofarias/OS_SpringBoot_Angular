package com.github.rycardofarias.ordem_de_servico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa implements Serializable {

    private static final long serialVersiionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<OrdemServico> list  = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    public List<OrdemServico> getList() {
        return list;
    }

    public void setList(List<OrdemServico> list) {
        this.list = list;
    }
}

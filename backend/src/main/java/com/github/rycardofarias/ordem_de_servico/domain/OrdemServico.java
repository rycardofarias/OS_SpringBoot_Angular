package com.github.rycardofarias.ordem_de_servico.domain;

import com.github.rycardofarias.ordem_de_servico.domain.enuns.Prioridade;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Status;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrdemServico {

    private Integer id;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private Prioridade prioridade;
    private String observacoes;
    private Status status;
    private Tecnico tecnico;
    private Cliente cliente;

    public OrdemServico() {
        super();
    }

    public OrdemServico(Integer id, LocalDateTime dataAbertura, LocalDateTime dataFechamento, Prioridade prioridade, String observacoes, Status status, Tecnico tecnico, Cliente cliente) {
        super();
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.prioridade = prioridade;
        this.observacoes = observacoes;
        this.status = status;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OrdemServico that = (OrdemServico) o;
        if (id == null){
            if (that.id != null){
                return false;
            }
        }else if (!id.equals(that.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime =31;
        int result =1;
        result = prime * result + ((id == null ) ? 0 : id.hashCode());
        return result;
    }
}

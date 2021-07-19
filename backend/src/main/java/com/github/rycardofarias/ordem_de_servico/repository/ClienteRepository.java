package com.github.rycardofarias.ordem_de_servico.repository;

import com.github.rycardofarias.ordem_de_servico.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

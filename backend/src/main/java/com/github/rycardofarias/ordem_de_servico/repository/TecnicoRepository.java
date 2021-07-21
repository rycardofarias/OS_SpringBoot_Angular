package com.github.rycardofarias.ordem_de_servico.repository;

import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}

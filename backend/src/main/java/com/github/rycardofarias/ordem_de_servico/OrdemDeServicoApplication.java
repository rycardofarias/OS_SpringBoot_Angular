package com.github.rycardofarias.ordem_de_servico;

import com.github.rycardofarias.ordem_de_servico.domain.Cliente;
import com.github.rycardofarias.ordem_de_servico.domain.OrdemServico;
import com.github.rycardofarias.ordem_de_servico.domain.Tecnico;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Prioridade;
import com.github.rycardofarias.ordem_de_servico.domain.enuns.Status;
import com.github.rycardofarias.ordem_de_servico.repository.ClienteRepository;
import com.github.rycardofarias.ordem_de_servico.repository.OrdemServicoRepository;
import com.github.rycardofarias.ordem_de_servico.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OrdemDeServicoApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrdemDeServicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico t1 = new Tecnico (null, "Ricardo Farias", "144.785.300-84", "(83) 99999-9999");
		Cliente c1 = new Cliente (null, "Vagner Sousa", "598.508.200-80", "(83) 99999-9998");

		OrdemServico os1 = new OrdemServico(null, Prioridade.ALTA, "Teste creat OD", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		ordemServicoRepository.saveAll(Arrays.asList(os1));


	}
}

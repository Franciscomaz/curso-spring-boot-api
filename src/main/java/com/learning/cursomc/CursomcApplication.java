package com.learning.cursomc;

import com.learning.cursomc.domain.categoria.Categoria;
import com.learning.cursomc.domain.categoria.Produto;
import com.learning.cursomc.domain.cliente.Cliente;
import com.learning.cursomc.domain.cliente.TipoCliente;
import com.learning.cursomc.domain.cliente.endereco.Cidade;
import com.learning.cursomc.domain.cliente.endereco.Endereco;
import com.learning.cursomc.domain.cliente.endereco.Estado;
import com.learning.cursomc.infrastructure.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria informatica = new Categoria(null, "Informática");
        Categoria escritorio = new Categoria(null, "Escritório");

        Produto computador = new Produto(null, "Computador", new BigDecimal("2000.00"));
        Produto impressora = new Produto(null, "Impressora", new BigDecimal("8000.00"));
        Produto mouse = new Produto(null, "Mouse", new BigDecimal("80.00"));

        informatica.setProdutos(Arrays.asList(computador, impressora, mouse));
        escritorio.setProdutos(Collections.singletonList(impressora));

        computador.setCategorias(Collections.singletonList(informatica));
        impressora.setCategorias(Arrays.asList(informatica, escritorio));
        mouse.setCategorias(Collections.singletonList(informatica));

        categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
        produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));

        Estado minasGerais = new Estado(null, "Minas Gerais");
        Estado saoPauloEstado = new Estado(null, "São Paulo");

        Cidade uberlandia = new Cidade(null, "Uberlândia", minasGerais);
        Cidade saoPauloCidade = new Cidade(null, "São Paulo", saoPauloEstado);
        Cidade campinas = new Cidade(null, "Campinas", saoPauloEstado);

        minasGerais.setCidades(Collections.singletonList(uberlandia));
        saoPauloEstado.setCidades(Arrays.asList(saoPauloCidade, campinas));

        estadoRepository.saveAll(Arrays.asList(minasGerais, saoPauloEstado));
        cidadeRepository.saveAll(Arrays.asList(uberlandia, saoPauloCidade, campinas));

        Cliente maria = new Cliente(null, "Maria Silva", "maria@gmail.com", "3678912377", TipoCliente.PESSOA_FISICA);
        maria.getTelefones().addAll(Arrays.asList("2736878", "999021313"));

        Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "3898932", maria, saoPauloCidade);
        Endereco endereco2 = new Endereco(null, "Avenidade Matos", "105", "Sala 800", "Centro", "3898932", maria, saoPauloCidade);

        maria.setEnderecos(Arrays.asList(endereco1, endereco2));

        clienteRepository.save(maria);
        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
    }
}

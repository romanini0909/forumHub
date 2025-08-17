package com.br.alura.forumHub.api.service;

import com.br.alura.forumHub.api.topico.*;
import com.br.alura.forumHub.api.repository.TopicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;



@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico cadastrar(DadosCadastroTopico dados) {
        // Lógica de validação de duplicidade
        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            throw new IllegalArgumentException("Tópico com o mesmo título e mensagem já existe.");
        }

        // Criação e persistência do tópico
        var topico = new Topico(dados);
        return repository.save(topico);
    }

    public Page<DadosListagemTopico> listarTodos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(DadosListagemTopico::new);
    }

    public DadosDetalhamentoTopico detalharPorId(Long id) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado com o ID: " + id));

        return new DadosDetalhamentoTopico(topico);
    }

    public DadosDetalhamentoTopico atualizar(DadosAtualizacaoTopico dados) {
        if (!repository.existsById(dados.id())) {
            throw new EntityNotFoundException("Tópico não encontrado com o ID: " + dados.id());
        }

        Topico topico = repository.getReferenceById(dados.id());

        if (dados.titulo() != null) {
            topico.setTitulo(dados.titulo());
        }
        if (dados.mensagem() != null) {
            topico.setMensagem(dados.mensagem());
        }
        if (dados.status() != null) {
            topico.setStatusTopico(dados.status());
        }
        if (dados.curso() != null) {
            topico.setCurso(dados.curso());
        }

        repository.save(topico); // A atualização ocorre automaticamente
        return new DadosDetalhamentoTopico(topico);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Tópico não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }
}
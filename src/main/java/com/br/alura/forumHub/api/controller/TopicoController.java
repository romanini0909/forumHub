package com.br.alura.forumHub.api.controller;

import com.br.alura.forumHub.api.repository.TopicoRepository;
import com.br.alura.forumHub.api.service.TopicoService;
import com.br.alura.forumHub.api.topico.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")


public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        // Delega a lógica de negócio para a camada de serviço
        Topico topicoSalvo = service.cadastrar(dados);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicoSalvo));
    }

    @GetMapping
    public Page<DadosListagemTopico> listar(
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {

        return service.listarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        DadosDetalhamentoTopico dadosDetalhados = service.detalharPorId(id);
        return ResponseEntity.ok(dadosDetalhados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados) {

        DadosAtualizacaoTopico dadosComId = new DadosAtualizacaoTopico(
                id,
                dados.titulo(),
                dados.mensagem(),
                dados.status(),
                dados.curso()
        );

        DadosDetalhamentoTopico dadosAtualizados = service.atualizar(dadosComId);
        return ResponseEntity.ok(dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

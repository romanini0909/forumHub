package com.br.alura.forumHub.api.repository;

import com.br.alura.forumHub.api.topico.DadosListagemTopico;
import com.br.alura.forumHub.api.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(String titulo, String mensagem);

}

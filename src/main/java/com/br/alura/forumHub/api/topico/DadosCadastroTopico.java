package com.br.alura.forumHub.api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public record DadosCadastroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        StatusTopico statusTopico,

        @NotBlank
        String autor,

        @NotNull
        Curso curso) {
}

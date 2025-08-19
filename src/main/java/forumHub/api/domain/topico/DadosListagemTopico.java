package forumHub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico statusTopico,
        String autor,
        Curso curso) {

    // Adicione este construtor que aceita uma entidade Topico
    public DadosListagemTopico(Topico topico) {
        // Usa os métodos do Topico (gerados pelo Lombok) para preencher o record
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatusTopico(), topico.getAutor(), topico.getCurso());
    }
}
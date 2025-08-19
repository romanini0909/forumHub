package forumHub.api.domain.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusTopico statusTopico;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private String respostas;

    public Topico(DadosCadastroTopico dados) {
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.statusTopico = dados.statusTopico();
        this.dataCriacao = LocalDateTime.now();
        this.mensagem = dados.mensagem();
        this.titulo = dados.titulo();
    }

  }
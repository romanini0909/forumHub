ForumHub API
Uma API REST completa para um fórum de discussões. Este projeto é uma solução backend para gerenciar tópicos, usuários e autenticação, permitindo a criação, leitura, atualização e exclusão de tópicos de discussão.

💻 Tecnologias Utilizadas
Java 17: Linguagem de programação principal.

Spring Boot 3.x: Framework para desenvolvimento rápido de APIs REST.

Spring Security: Para autenticação e autorização via JWT (JSON Web Token).

MySQL: Banco de dados relacional para persistência de dados.

Flyway: Para controle de versão do banco de dados (migrations).

Maven: Gerenciador de dependências.

🚀 Como Rodar o Projeto
Clone o repositório:
git clone https://github.com/seu-usuario/seu-repositorio.git

Configuração do Banco de Dados:

Crie um banco de dados MySQL chamado forumhub_api.

Configure as credenciais do banco de dados no arquivo src/main/resources/application.properties.

Executar a Aplicação:

Abra o projeto no IntelliJ ou outra IDE.

Rode a classe ApiApplication.java. O servidor iniciará na porta 8080.

🔑 Autenticação
Para acessar a maioria dos endpoints, é necessário estar autenticado. O processo de autenticação retorna um token JWT que deve ser enviado no cabeçalho Authorization de cada requisição, no formato Bearer <token>.

POST /login

Descrição: Efetua o login de um usuário e retorna um token de autenticação.

Corpo da Requisição:

JSON

{
"login": "usuario_1@forum.hub",
"senha": "123456"
}
📚 Endpoints da API
Tópicos
POST /topicos

Descrição: Cadastra um novo tópico no fórum.

Corpo da Requisição:

JSON

{
"titulo":"Erro ao excluir registro",
"mensagem":"Mensagem de erro anexo",
"autor":"Jeferson",
"curso":"JAVA"
}
GET /topicos

Descrição: Lista todos os tópicos existentes. Suporta paginação.

Exemplo de URL: http://localhost:8080/topicos?size=10&page=0

GET /topicos/{id}

Descrição: Detalha um tópico específico pelo ID.

Exemplo de URL: http://localhost:8080/topicos/2

PUT /topicos/{id}

Descrição: Atualiza as informações de um tópico existente.

Corpo da Requisição:

JSON

{
"id": 1,
"mensagem": "Uma nova mensagem para atualizar o tópico.",
"status": "FECHADO"
}
DELETE /topicos/{id}

Descrição: Deleta um tópico permanentemente.

Exemplo de URL: http://localhost:8080/topicos/2

🎨 Diagrama da Arquitetura
Aqui está um diagrama simples da arquitetura do projeto.

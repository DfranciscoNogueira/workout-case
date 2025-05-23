#Documentação da API - Sistema de Pedidos e Gestão Escolar 🚀

📌 Visão Geral

Esta API foi desenvolvida utilizando Java 17 e Spring Boot 3.

Ela usa Spring Security com JWT, garantindo autenticação segura para os endpoints protegidos.

⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- Banco de Dados H2
- Swagger (Springdoc OpenAPI 3)

🌍 URL Base

A API roda localmente na porta 8080, portanto, todas as requisições devem ser enviadas para:

http://localhost:8080/api

🔑 Autenticação

A API utiliza JWT para autenticação dos endpoints protegidos.
Antes de acessar os endpoints, é necessário obter um token válido através do login: POST /api/autenticacao/login

Body (JSON):

{
  "username": "admin",
  "password": "admin"
}

✅ Se a autenticação for bem-sucedida, a API retorna um token JWT, com validade de 1 hora.
✅ Para acessar os outros endpoints, inclua o token no cabeçalho da requisição: Authorization: Bearer <seu-token-aqui>


📚 Endpoints da API

Após autenticar-se, os seguintes endpoints estarão disponíveis: 

GET /api/escola/professores/horas
GET /api/escola/salas/status

POST /api/pedidos

🛠 Massa de Testes Automática

Ao iniciar a aplicação, a classe IniciarDados.java preenche automaticamente o banco H2 com uma massa de dados para testes. Isso facilita a validação dos endpoints sem necessidade de inserção manual.

Alem disso na pasta "src\main\resources\escola_script.sql" que tem as query

🧪 Testes

A API conta com testes unitários para garantir confiabilidade nas regras de negócio:

✔️ Testes dos services
✔️ Testes dos controllers

🔗 Swagger - Documentação Interativa

A API conta com uma documentação interativa para facilitar testes e entendimento dos endpoints.

📌 Acesse via: http://localhost:8080/api/swagger-ui/index.html

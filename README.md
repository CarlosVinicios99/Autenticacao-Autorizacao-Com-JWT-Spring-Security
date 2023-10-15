# Autenticação e Autorização Com JWT e Spring Security

<p>
  Projeto de API para o desenvolvimento de Autenticação sem estado e autorização sobre serviços utilizando Token JWT e Spring Security, além de outras ferramentas como Flyway para migrações e Swagger para documentação.
</p>

## Geração Do Token JWT
<p>
  O token é gerado no momento do login e deve ser utilizado nas demais requisições.
</p>
<img src = "https://github.com/CarlosVinicios99/Autenticacao-Autorizacao-Com-JWT-Spring-Security/blob/main/geracao_token_jwt.jpg?raw=true">

## Utilização Do Token 
<p>
  Para testar na prática a utilização do Token e a configuração dos "roles" (permissões de usuário), foi criada uma entidade de Produto com seus básicos serviços básicos de CRUD.
  Se o usuário estiver autenticado e possuir o nível de permissão necessário ele consegue utilizar o serviço, caso contrário recebe um erro.
</p>
<img src = "https://github.com/CarlosVinicios99/Autenticacao-Autorizacao-Com-JWT-Spring-Security/blob/main/utilizacao_do_token.jpg?raw=true">

## Documentação Com Swagger
<p>
  Documentação automática utilizando swagger para mapear e listar os serviços desenvolvidos, auxiliando na utilização dos mesmos.
</p>
<img src = "https://github.com/CarlosVinicios99/Autenticacao-Autorizacao-Com-JWT-Spring-Security/blob/main/documentacao_swagger.jpg?raw=true">

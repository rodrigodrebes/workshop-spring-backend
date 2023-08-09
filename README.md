# Workshop Backend Spring Boot

Este workshop apresenta um projeto backend desenvolvido com Spring Boot em Java. 
O projeto integra o uso de JPA e Hibernate para mapeamento objeto-relacional, focando na implementação de um modelo de domínio que envolve Pedidos, Produtos e Usuários. 

## Características

- Modelo de domínio completo;
- Estrutura em camadas:
  - Resource (Controladores REST)
  - Service (Regras de negócio e lógica)
  - Repository (Acesso a dados)
- Integração com banco de dados H2 para testes e Postgre para persistência de dados
- Funcionalidades CRUD completas
- Tratamento avançado de exceções para garantir respostas apropriadas ao cliente.

## Começando

1. **Configuração do Ambiente**:
    - Garanta que você possui o Java e Maven instalados.
    - Clone este repositório.

2. **Perfil de Teste**:
    - Altere o perfil para `test` no arquivo `application.properties`.

3. **Iniciando o Servidor**:
    - Navegue até a pasta raiz do projeto via terminal.
    - Execute o comando `mvn spring-boot:run`.

4. **Testando as APIs**:
    - Utilize o Postman ou qualquer outro cliente REST de sua preferência para fazer requisições.
    - Teste as operações CRUD para os modelos de domínio disponíveis.

5. **Acessando o banco de dados H2**:
    - Vá para [http://localhost:8080/h2-console](http://localhost:8080/h2-console) para acessar a interface web do banco de dados H2.
    - Insira as credenciais e explore os dados.


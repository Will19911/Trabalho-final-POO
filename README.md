arquivo README.md para o projeto:

# Sistema de Gestão de Funcionários

Este projeto é uma aplicação Java simples para gerenciar informações de funcionários em um banco de dados. Ele utiliza a arquitetura **DAO (Data Access Object)** para separar a lógica de negócios da persistência de dados.

-----

##  Funcionalidades

O sistema oferece as seguintes operações de **CRUD (Create, Read, Update, Delete)** para a entidade `Funcionario`:

  * **`inserir`**: Adiciona um novo funcionário ao banco de dados.
  * **`atualizar`**: Atualiza os dados de um funcionário existente com base em seu ID.
  * **`delete`**: Remove um funcionário do banco de dados usando seu ID.
  * **`listar`**: Recupera e exibe a lista completa de todos os funcionários.

-----

## Tecnologias Utilizadas

  * **Java**: Linguagem de programação principal.
  * **JDBC (Java Database Connectivity)**: API para conexão e interação com o banco de dados.
  * **Padrão de Projeto DAO**: Usado para abstrair e encapsular o acesso aos dados.

-----

## Estrutura do Projeto

O código está organizado nos seguintes pacotes:

  * **`entity`**: Contém a classe `Funcionario`, que representa o modelo de dados.
  * **`conexao`**: Inclui a classe `ConnectionFactory` para gerenciar a conexão com o banco de dados.
  * **`persistence`**: Contém a classe `FuncionarioDao`, que implementa a lógica de persistência e acesso aos dados.

-----

## Como Usar

### Pré-requisitos

  * Java Development Kit (JDK) instalado.
  * Um banco de dados compatível com JDBC (por exemplo, MySQL, PostgreSQL, etc.).
  * O driver JDBC correspondente no classpath do seu projeto.

### Configuração

1.  **Configurar a Conexão**: Verifique a classe `conexao.ConnectionFactory` e configure as credenciais do seu banco de dados (URL, usuário e senha).
2.  **Criação da Tabela**: Certifique-se de que a tabela `funcionario` exista no seu banco de dados com as seguintes colunas:
      * `id` (INT)
      * `nome` (VARCHAR)
      * `cpf` (VARCHAR)
      * `data_nascimento` (DATE)
      * `salario_bruto` (DOUBLE)

### Exemplo de Uso

Para utilizar as funcionalidades, você precisará criar uma instância da classe `FuncionarioDao` e chamar os métodos CRUD.

```java
// Exemplo de como adicionar um novo funcionário
Funcionario novoFuncionario = new Funcionario("João Silva", "12345678900", LocalDate.of(1990, 5, 15), 5000.00);
FuncionarioDao dao = new FuncionarioDao();
dao.inserir(novoFuncionario);

// Exemplo de como listar todos os funcionários
List<Funcionario> funcionarios = dao.listar();
for (Funcionario f : funcionarios) {
    System.out.println(f.getNome() + " - " + f.getSalarioBruto());
}
```

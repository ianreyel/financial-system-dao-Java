# Gerenciador de Transações Financeiras 

Este projeto é uma aplicação Java para controle de receitas e despesas. Ele demonstra a aplicação de conceitos avançados de POO e permite que o usuário escolha entre dois métodos de persistência de dados.

## 🛠️ Funcionalidades

- **Gestão de Transações**: Cadastro de Receitas (tributáveis) e Despesas.
- **Persistência Dupla**: 
    - **DAO**: Integração com MariaDB via JDBC.
    - **Serialização**: Salvamento de objetos em arquivos binários (`.bin`) e geração de extratos em `.csv`.
- **Tratamento de Erros**: Exceções customizadas para validação de valores.

---

## 🚀 Como usar o projeto

Siga os passos abaixo para configurar o ambiente e executar a aplicação:

### 1. Preparação do Projeto
1. Crie um novo projeto Java (preferencialmente Maven) na sua IDE.
2. Copie os arquivos das classes para a pasta `src/main/java`.
    - **Nota**: Escolha o modelo de persistência desejado. Se for usar banco de dados, certifique-se de incluir a classe `TransacaoDAO` e `ConexaoFactory`. Se for usar arquivos, utilize `GerenciadorArquivos`.
3. Se estiver usando Maven, adicione a dependência do conector MariaDB no seu `pom.xml` (conforme fornecido no repositório).

### 2. Configuração do Banco de Dados (Docker)
Para a versão que utiliza **DAO**, é necessário subir um container do MariaDB:

1. Certifique-se de ter o **Docker** instalado.
2. Suba um container MariaDB com o seguinte comando no terminal:
   ```bash
   docker run --name mariadb-transacoes -e MYSQL_ROOT_PASSWORD=SUA_SENHA -p 3306:3306 -d mariadb:latest

## 🛠️ Tecnologias e Conceitos

* **Java:** Herança, Polimorfismo, Interfaces e Abstração.
* **MariaDB:** Banco de dados relacional (Versão DAO).
* **Docker:** Conteinerização do banco de dados.
* **Maven:** Gerenciamento de dependências (Driver MariaDB).
* **Serialização:** Persistência de objetos em arquivos `.bin`.

---

## 🚀 Como usar o projeto

Siga os passos abaixo para configurar e rodar a aplicação:

### 1. Preparação do Ambiente
* Certifique-se de ter o JDK e o Maven instalados.
* Tenha o Docker e o MariaDB configurados na sua máquina.

### 2. Configuração do Projeto Java
* Crie um novo projeto Java na sua IDE de preferência.
* Importe os arquivos da pasta `src` deste repositório para o seu projeto.
* **Para usar DAO:** Importe as classes `TransacaoDAO.java` e `ConexaoFactory.java`.
* **Para usar Serialização:** Importe a classe `GerenciadorArquivos.java`.

> **Nota:** As classes base (`Transacao`, `Receita`, `Despesa`, etc) são obrigatórias para ambas as opções.

### 3. Configuração do Banco de Dados (Versão DAO)
Se você optar pela versão com banco de dados, siga estes passos:

**Ligar o Docker:** Crie e inicie um container para o MariaDB executando o comando abaixo no terminal:

```bash
docker run --name mariadb-projeto -e MYSQL_ROOT_PASSWORD=sua_senha -p 3306:3306 -d mariadb:latest

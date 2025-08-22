# 🏠 Sistema de Aluguel de Imóveis

Projeto acadêmico desenvolvido em **Java** com **JDBC** e **Maven**, voltado para o gerenciamento de uma imobiliária.  
O sistema possibilita o **cadastro, consulta e gerenciamento** de imóveis, clientes e contratos de aluguel, além da geração de relatórios simples para apoio às operações.

---

## 📌 Funcionalidades

- ✅ Cadastro de imóveis com suas características  
- ✅ Cadastro de clientes  
- ✅ Registro de contratos de aluguel (valor, data de início, data de término, etc.)  
- ✅ Listagem de imóveis disponíveis para aluguel  
- ✅ Consulta de clientes cadastrados  
- ✅ Listagem de contratos ativos  

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**  
- **Maven**  
- **JDBC**  
- **MySQL**  
- **IntelliJ IDEA** (IDE utilizada no desenvolvimento)  

---

## 🏗️ Arquitetura do Projeto

O sistema segue uma arquitetura em **camadas**, separando responsabilidades de forma organizada:

- **Main (`main/Main.java`)**  
  - Classe principal da aplicação.  
  - Exibe o menu interativo no console.  
  - Encaminha as requisições para a camada DAO.  

- **Modelos (`imobiliaria/`)**  
  - Contém as entidades principais: `Cliente`, `Imovel` e `Contrato`.  
  - Representam as tabelas do banco de dados.  

- **DAO (`daoimobiliaria/`)**  
  - Responsável pela comunicação com o banco de dados via JDBC.  
  - Exemplo: `ClienteDAO` implementa operações de cadastro, busca e listagem de clientes.  

- **Conexão (`conexaoimobiliaria/`)**  
  - Contém a classe `ConexaoImobiliaria`, responsável por abrir e encerrar conexões com o banco.  

- **Scripts (`scripts/`)**  
  - Inclui o arquivo SQL para criação e inicialização das tabelas do banco de dados.  

- **Testes (`test/`)**  
  - Contém testes automatizados utilizando JUnit (em expansão).  

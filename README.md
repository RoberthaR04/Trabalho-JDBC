🏠 Sistema de Aluguel de Imóveis

Projeto acadêmico desenvolvido em Java com JDBC e Maven, voltado para o gerenciamento de uma imobiliária.
O sistema possibilita o cadastro, consulta e gerenciamento de imóveis, clientes e contratos de aluguel, além da geração de relatórios simples para apoio às operações.

📌 Funcionalidades
🔹 Cadastro

Imóveis com suas características

Clientes

Contratos de aluguel (valor, data de início, data de término, etc.)

🔹 Consultas

Listar imóveis disponíveis para aluguel

Listar clientes cadastrados

Listar contratos ativos

⚙️ Tecnologias Utilizadas

Java 17+

Maven

JDBC

MySQL

IntelliJ IDEA (IDE utilizada no desenvolvimento)

🏗️ Arquitetura do Projeto

O sistema segue uma arquitetura em camadas, separando responsabilidades de forma organizada:

Main (main/Main.java)

Classe principal da aplicação

Exibe o menu interativo no console

Encaminha as requisições para a camada DAO

Modelos (imobiliaria/)

Entidades principais: Cliente, Imovel e Contrato

Representam as tabelas do banco de dados

DAO (daoimobiliaria/)

Comunicação com o banco de dados via JDBC

Exemplo: ClienteDAO implementa operações de cadastro, busca e listagem

Conexão (conexaoimobiliaria/)

Classe ConexaoImobiliaria

Abre e encerra conexões com o banco

Scripts (scripts/)

Arquivo SQL para criação e inicialização das tabelas do banco

Testes (test/)

Testes automatizados com JUnit (em expansão)

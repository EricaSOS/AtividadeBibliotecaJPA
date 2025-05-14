# Atividade Prática - Biblioteca com JPA

## 📚 Introdução

Este projeto é uma atividade prática da disciplina de Banco de Dados, utilizando Java com JPA (Java Persistence API) para implementar um sistema básico de biblioteca. Nele, é possível gerenciar alunos, publicações e empréstimos realizados, simulando operações comuns de CRUD (Create, Read, Update, Delete) em um banco de dados relacional.

O objetivo da atividade é aplicar os conceitos de **mapeamento objeto-relacional (ORM)** com **anotações JPA**, usando o banco **H2** como base de dados local.

---

## 💻 Tecnologias Utilizadas

- Java 21
- Maven
- JPA (EclipseLink como provedor)
- Banco de dados H2 (em modo TCP)
- IDE recomendada: IntelliJ, NetBeans ou VS Code com suporte a Maven

---

## 📦 Dependências (via Maven)

As principais dependências do projeto estão no `pom.xml`:

- `javax.persistence` (especificação da JPA)
- `eclipselink` (provedor JPA)
- `h2` (banco de dados embarcado)
- Outras bibliotecas auxiliares do EclipseLink

---

## ⚙️ Como Funciona

1. **Configuração de persistência**:  
   O projeto utiliza um arquivo `persistence.xml`, configurado para usar o banco de dados H2 e gerar as tabelas automaticamente.

2. **Entidades mapeadas**:

   - `Aluno`: representa um estudante da biblioteca.
   - `Publicacao`: representa livros, revistas ou materiais emprestáveis.
   - `Emprestimo`: associa um aluno a uma publicação com data de empréstimo e devolução.

3. **Operações implementadas** (via classe de teste `AtividadeBibliotecaJPA`):

   - Inserir alunos, publicações e empréstimos
   - Listar registros cadastrados
   - Alterar e excluir registros
   - Exibir os dados de forma relacional (ex: um aluno com seus empréstimos)

4. **Banco de dados**:
   - O banco H2 funciona no modo TCP com um arquivo `.mv.db` salvo na máquina.
   - As tabelas são recriadas a cada execução (`schema-generation: create`).

---

## ▶️ Como Executar

1. Certifique-se de que o servidor do H2 está rodando em modo TCP.
2. Clone o projeto e abra na sua IDE Java com suporte a Maven.
3. Rode a classe `AtividadeBibliotecaJPA` como uma aplicação Java.
4. Observe no console as saídas dos dados persistidos e manipulados.

---

## 📝 Observações

- Este projeto é exclusivamente acadêmico, com foco em aprendizado de JPA.
- O banco H2 pode ser substituído por outro (MySQL, PostgreSQL, etc.) com pequenas mudanças no `persistence.xml`.

---

## 👩‍💻 Autoria

Desenvolvido por Érica Santos Oliveira da Silva.  
Curso de Tecnologia em Análise e Desenvolvimento de Sistemas  
Disciplina: Aplicação de Banco de Dados  
Ano: 2025

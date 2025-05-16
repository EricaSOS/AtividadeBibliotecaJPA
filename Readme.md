# Atividade Prática - Biblioteca com JPA

## 📚 Introdução

Este projeto é uma atividade prática da disciplina de Banco de Dados, utilizando Java com JPA (Java Persistence API) para implementar um sistema básico de biblioteca. Nele, é possível gerenciar alunos, publicações e empréstimos realizados, simulando operações comuns de CRUD (Create, Read, Update, Delete) em um banco de dados relacional.

## O objetivo da atividade é aplicar os conceitos de **mapeamento objeto-relacional (ORM)** com **anotações JPA**, usando o banco **H2** como base de dados local.

## 💻 Tecnologias Utilizadas

- Java 21
- Maven
- JPA (EclipseLink como provedor)
- Banco de dados H2 (em modo TCP)
- IDE recomendada: NetBeans, mas pode ser usada a Intellij ou VS Code com suporte a Maven.

---

## 📦 Dependências (via Maven)

As principais dependências do projeto estão no `pom.xml`:

- `javax.persistence` (especificação da JPA) - acabei excluindo, pois causou problemas para a criação do banco.
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

3. **Operações implementadas** (via classes DAO, feito apenas para Empréstimo):

   - Inserir empréstimos;
   - Listar registros cadastrados;
   - Consultar registros;
   - Alterar e excluir registros;
   - Sair da aplicação.

4. **Banco de dados**:
   - O banco H2 funciona no modo TCP com um arquivo `.mv.db` salvo na máquina.
   - As tabelas são recriadas a cada execução (`schema-generation: create`).

---

## ▶️ Como Executar

1. Certifique-se de que o servidor do H2 está rodando em modo TCP (server);
2. Clone o projeto e abra na sua IDE Java com suporte a Maven;
3. Ao abrir e realizar as configurações necessárias, clique com o botão direito do mouse sobre o projeto e escolha a opção "Build";
4. Após isso, execute primeiramente a classe `AtividadeBibliotecaJPA` como uma aplicação Java, para a criação das Tabelas no H2 e atualize para verificar se as tabelas foram devidamente criadas;
5. Logo depois, execute a classe `TesteEmprestimoDAO` e repare que no banco, serão criados 03 registros de alunos e publicações para teste;
6. Para realizar o teste, indique a opção desejada e informe os dados solicitados;
7. Observe no console do H2 as saídas dos dados persistidos e manipulados;
8. Para encerrar, basta dar o comando de sair (0).

---

## 📝 Observações

- Este projeto é exclusivamente acadêmico, com foco em aprendizado de JPA.
- O banco H2 pode ser substituído por outro (MySQL, PostgreSQL, etc.) com pequenas mudanças no `persistence.xml`.

---

## 👩‍💻 Autoria

Desenvolvido por Érica Santos Oliveira da Silva.  
Curso de Tecnologia em Análise e Desenvolvimento de Sistemas  
Disciplina: Aplicação de Banco de Dados
Professor: Cláudio Martins  
Entrega em: 14/05/2025 (última atualização em 16/05/2025)

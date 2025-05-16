package DAO;

import ericasos.atividadebibliotecajpa.entidades.Emprestimo;
import ericasos.atividadebibliotecajpa.TableCreate;
import javax.persistence.EntityManager;
import ericasos.atividadebibliotecajpa.entidades.Aluno;
import ericasos.atividadebibliotecajpa.entidades.Publicacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TesteEmprestimoDAO {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static EntityManager em;
    private static EmprestimoDAO emprestimoDAO;
    
    public static void main(String[] args) {
        em = TableCreate.getEntityManager();
        emprestimoDAO = new EmprestimoDAO(em);
        
        em.getTransaction().begin();

        Aluno a1 = new Aluno();
        a1.setMatriculaAluno(111);
        a1.setNome("Maria");
        em.persist(a1);

        Publicacao p1 = new Publicacao(1001, "Java Básico", 2024, "Autor X", "Livro");
        em.persist(p1);
        
        Aluno a2 = new Aluno();
        a1.setMatriculaAluno(222);
        a1.setNome("Mélvio da Silva");
        em.persist(a2);

        Publicacao p2 = new Publicacao(1002, "Sei programar phyton", 2002, "Autor H", "Documentário");
        em.persist(p2);
        
        Aluno a3 = new Aluno();
        a1.setMatriculaAluno(45874);
        a1.setNome("Sincero");
        em.persist(a3);

        Publicacao p3 = new Publicacao(1005, "Como cometer sincericídio", 1982, "Autor Hipócrates", "Manual");
        em.persist(p3);

        em.getTransaction().commit();
        
        
        int opcao;

        do {
            System.out.println("=== MENU EMPRÉSTIMO ===");
            System.out.println("1. Inserir empréstimo");
            System.out.println("2. Listar empréstimos");
            System.out.println("3. Atualizar data de devolução");
            System.out.println("4. Excluir empréstimo");
            System.out.println("5. Buscar por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> inserirEmprestimo();
                case 2 -> listarEmprestimos();
                case 3 -> atualizarDataDevolucao();
                case 4 -> excluirEmprestimo();
                case 5 -> buscarPorId();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        em.close();
        TableCreate.close();
        scanner.close();
    }
    
     private static void inserirEmprestimo() {
        try {
            System.out.print("ID do Aluno: ");
            Long idAluno = scanner.nextLong();

            System.out.print("ID da Publicação: ");
            Long idPublicacao = scanner.nextLong();
            scanner.nextLine(); // consumir quebra de linha

            System.out.print("Data do Empréstimo (dd/MM/yyyy): ");
            String dataEmprestimoStr = scanner.nextLine();
            Date dataEmprestimo = sdf.parse(dataEmprestimoStr);

            Aluno aluno = em.find(Aluno.class, idAluno);
            Publicacao publicacao = em.find(Publicacao.class, idPublicacao);

            if (aluno == null || publicacao == null) {
                System.out.println("Aluno ou Publicação não encontrados.");
                return;
            }

            Emprestimo emprestimo = new Emprestimo(dataEmprestimo, aluno, publicacao);
            emprestimoDAO.insert(emprestimo);
            System.out.println("Empréstimo cadastrado com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir empréstimo: " + e.getMessage());
        }
    }

    private static void listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoDAO.findAll();
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo encontrado.");
        } else {
            System.out.println("\n=== Lista de Empréstimos ===");
            emprestimos.forEach(System.out::println);
        }
    }

    private static void atualizarDataDevolucao() {
        try {
            System.out.print("ID do Empréstimo para atualizar: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // consumir quebra de linha

            Emprestimo emprestimo = emprestimoDAO.findById(id);
            if (emprestimo == null) {
                System.out.println("Empréstimo não encontrado.");
                return;
            }

            System.out.print("Nova data de devolução (dd/MM/yyyy): ");
            String novaDataStr = scanner.nextLine();
            Date novaData = sdf.parse(novaDataStr);

            emprestimo.setDataDevolucao(novaData);
            emprestimoDAO.update(emprestimo);
            System.out.println("Data de devolução atualizada com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar data: " + e.getMessage());
        }
    }

    private static void excluirEmprestimo() {
        try {
            System.out.print("ID do Empréstimo para excluir: ");
            Long id = scanner.nextLong();
            Emprestimo emprestimo = emprestimoDAO.findById(id);

            if (emprestimo == null) {
                System.out.println("Empréstimo não encontrado.");
            } else {
                emprestimoDAO.delete(emprestimo);
                System.out.println("Empréstimo excluído com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao excluir empréstimo: " + e.getMessage());
        }
    }

    private static void buscarPorId() {
        System.out.print("ID do Empréstimo para buscar: ");
        Long id = scanner.nextLong();
        Emprestimo emprestimo = emprestimoDAO.findById(id);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
        } else {
            System.out.println(emprestimo);
        }
    }
}

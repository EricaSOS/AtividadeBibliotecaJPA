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

    public static void main(String[] args) {
        EntityManager em = TableCreate.getEntityManager();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int opcao;

        do {
            System.out.println("\n=== MENU EMPRESTIMO ===");
            System.out.println("1. Inserir empréstimo");
            System.out.println("2. Listar empréstimos");
            System.out.println("3. Atualizar data de devolução");
            System.out.println("4. Excluir empréstimo");
            System.out.println("5. Buscar por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> {
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
                        } else {
                            Emprestimo emprestimo = new Emprestimo(dataEmprestimo, aluno, publicacao);
                            emprestimoDAO.insert(emprestimo);
                            System.out.println("Empréstimo cadastrado com sucesso.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir empréstimo: " + e.getMessage());
                    }
                }

                case 2 -> {
                    List<Emprestimo> emprestimos = emprestimoDAO.findAll();
                    if (emprestimos.isEmpty()) {
                        System.out.println("Nenhum empréstimo encontrado.");
                    } else {
                        System.out.println("\n=== Lista de Empréstimos ===");
                        for (Emprestimo e : emprestimos) {
                            System.out.println(e);
                        }
                    }
                }

                case 3 -> {
                    try {
                        System.out.print("ID do Empréstimo para atualizar: ");
                        Long idAtualiza = scanner.nextLong();
                        scanner.nextLine(); // consumir quebra de linha

                        Emprestimo emprestimo = emprestimoDAO.findById(idAtualiza);

                        if (emprestimo == null) {
                            System.out.println("Empréstimo não encontrado.");
                        } else {
                            System.out.print("Nova data de devolução (dd/MM/yyyy): ");
                            String dataDevolucaoStr = scanner.nextLine();
                            Date novaData = sdf.parse(dataDevolucaoStr);
                            emprestimo.setDataDevolucao(novaData);
                            emprestimoDAO.update(emprestimo);
                            System.out.println("Data de devolução atualizada com sucesso.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar empréstimo: " + e.getMessage());
                    }
                }

                case 4 -> {
                    try {
                        System.out.print("ID do Empréstimo para excluir: ");
                        Long idExcluir = scanner.nextLong();
                        Emprestimo emprestimoExcluir = emprestimoDAO.findById(idExcluir);

                        if (emprestimoExcluir == null) {
                            System.out.println("Empréstimo não encontrado.");
                        } else {
                            emprestimoDAO.delete(emprestimoExcluir);
                            System.out.println("Empréstimo excluído com sucesso.");
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao excluir empréstimo: " + e.getMessage());
                    }
                }

                case 5 -> {
                    System.out.print("ID do Empréstimo para buscar: ");
                    Long idBusca = scanner.nextLong();
                    Emprestimo emprestimoBuscado = emprestimoDAO.findById(idBusca);

                    if (emprestimoBuscado == null) {
                        System.out.println("Empréstimo não encontrado.");
                    } else {
                        System.out.println(emprestimoBuscado);
                    }
                }

                case 0 -> System.out.println("Encerrando...");

                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        em.close();
        TableCreate.close(); // Fecha o EntityManagerFactory
        scanner.close();
    }
}

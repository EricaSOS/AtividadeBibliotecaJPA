
import main.java.DAO.EmprestimoDAO; 
import ericasos.atividadebibliotecajpa.entidades.Aluno;
import ericasos.atividadebibliotecajpa.entidades.Emprestimo;
import ericasos.atividadebibliotecajpa.entidades.Publicacao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteEmprestimoDAO{

    private static final String PERSISTENCE_UNIT_NAME = "ericasos_AtividadeBibliotecaJPA_jar_1.0-SNAPSHOTPU"; // Nome da unidade de persistência no persistence.xml
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EmprestimoDAO emprestimoDAO;

    public static void main(String[] args) {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = emf.createEntityManager();
            emprestimoDAO = new EmprestimoDAO(em);

            System.out.println("--- Teste de Inclusão ---");
            testIncluirEmprestimo();

            System.out.println("\n--- Teste de Consulta por ID ---");
            testConsultarPorId();

            System.out.println("\n--- Teste de Alteração ---");
            testAlterarEmprestimo();

            System.out.println("\n--- Teste de Consulta Todos ---");
            testConsultarTodos();

            System.out.println("\n--- Teste de Exclusão ---");
            testExcluirEmprestimo();

            System.out.println("\n--- Fim dos Testes ---");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (emprestimoDAO != null) {
                emprestimoDAO.close(); // Fechar o EntityManager
            }
            if (emf != null) {
                emf.close(); // Fechar o EntityManagerFactory
            }
        }
    }

    private static void testIncluirEmprestimo() {
        Aluno aluno = new Aluno();
        aluno.setNome("João da Silva");
        aluno.setMatriculaAluno(2023001);
        
        Publicacao publicacao = new Publicacao();
        publicacao.setTitulo("Livro Teste JPA");
        publicacao.setAutor("Autor Teste");
        publicacao.setAno(2023);
        publicacao.setTipo("LIVRO");
        publicacao.setCodigoPub(1001);
        
        em.getTransaction().begin();
        em.persist(aluno);
        em.persist(publicacao);
        em.getTransaction().commit();

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(new Date());
        // dataDevolucao será definida na alteração
        emprestimo.setAluno(aluno);
        emprestimo.setPublicacao(publicacao);

        emprestimoDAO.salvar(emprestimo);
        System.out.println("Empréstimo incluído com ID: " + emprestimo.getId());
    }

    private static void testConsultarPorId() {
        
        Long idParaConsulta = 1L;

        Emprestimo emprestimoEncontrado = emprestimoDAO.buscarPorId(idParaConsulta); 

        if (emprestimoEncontrado != null) {
            System.out.println("Empréstimo encontrado: ID=" + emprestimoEncontrado.getId() +
                               ", Aluno=" + emprestimoEncontrado.getAluno().getNome() +
                               ", Publicação=" + emprestimoEncontrado.getPublicacao().getTitulo());
        } else {
            System.out.println("Empréstimo com ID " + idParaConsulta + " não encontrado.");
        }
    }

    private static void testAlterarEmprestimo() {
        // Recupera um empréstimo existente para alterar
        Long idParaAlterar = 1L; 

        Emprestimo emprestimoParaAlterar = emprestimoDAO.buscarPorId(idParaAlterar);

        if (emprestimoParaAlterar != null) {
            System.out.println("Empréstimo antes da alteração: " + emprestimoParaAlterar.getId() +
                               " - Data Devolução: " + emprestimoParaAlterar.getDataDevolucao());

            // Altera a data de devolução
            emprestimoParaAlterar.setDataDevolucao(new Date());

            emprestimoDAO.salvar(emprestimoParaAlterar);
            System.out.println("Empréstimo com ID " + idParaAlterar + " alterado.");

            // Consultar novamente para confirmar a alteração
            Emprestimo emprestimoAlterado = emprestimoDAO.buscarPorId(idParaAlterar);
             if (emprestimoAlterado != null) {
                 System.out.println("Empréstimo após alteração: " + emprestimoAlterado.getId() +
                                    " - Data Devolução: " + emprestimoAlterado.getDataDevolucao());
             }

        } else {
            System.out.println("Empréstimo com ID " + idParaAlterar + " não encontrado para alteração.");
        }
    }

    private static void testConsultarTodos() {
        List<Emprestimo> todosEmprestimos = emprestimoDAO.buscarTodos();

        if (todosEmprestimos != null && !todosEmprestimos.isEmpty()) {
            System.out.println("Lista de todos os Empréstimos (" + todosEmprestimos.size() + "):");
            for (Emprestimo emp : todosEmprestimos) {
                System.out.println("  ID: " + emp.getId() +
                                   ", Aluno: " + emp.getAluno().getNome() +
                                   ", Publicação: " + emp.getPublicacao().getTitulo() +
                                   ", Empréstimo: " + emp.getDataEmprestimo() +
                                   ", Devolução: " + emp.getDataDevolucao());
            }
        } else {
            System.out.println("Nenhum empréstimo encontrado.");
        }
    }

    private static void testExcluirEmprestimo() {
        // Recupera um empréstimo existente para excluir
        Long idParaExcluir = 1L; 

        Emprestimo emprestimoParaExcluir = emprestimoDAO.buscarPorId(idParaExcluir);

        if (emprestimoParaExcluir != null) {
            System.out.println("Excluindo empréstimo com ID: " + emprestimoParaExcluir.getId());
            emprestimoDAO.remover(emprestimoParaExcluir);
            System.out.println("Empréstimo com ID " + idParaExcluir + " excluído.");

            // Consultar novamente para confirmar a exclusão
            Emprestimo emprestimoExcluido = emprestimoDAO.buscarPorId(idParaExcluir);
            if (emprestimoExcluido == null) {
                System.out.println("Confirmação: Empréstimo com ID " + idParaExcluir + " não foi mais encontrado.");
            }

        } else {
            System.out.println("Empréstimo com ID " + idParaExcluir + " não encontrado para exclusão.");
        }
    }    
}

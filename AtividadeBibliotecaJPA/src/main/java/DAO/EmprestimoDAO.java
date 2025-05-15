package main.java.DAO;

import DAO.GenericDAO;
import DAO.GenericDAO;
import ericasos.atividadebibliotecajpa.entidades.Emprestimo;
import javax.persistence.*;

import java.util.List;

public class EmprestimoDAO implements GenericDAO<Emprestimo> {

    private EntityManager em;

    public EmprestimoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Emprestimo entidade) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            if (entidade.getId() == null) {
                em.persist(entidade);
            } else {
                em.merge(entidade);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar entidade Emprestimo", e);
        }
    }

    @Override
    public Emprestimo buscarPorId(Long id) {
        try {
            return em.find(Emprestimo.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar Emprestimo por ID", e);
        }
    }

    @Override
    public List<Emprestimo> buscarTodos() {
        try {
            Query query = em.createQuery("SELECT e FROM Emprestimo e", Emprestimo.class);
            return query.getResultList();
        } catch (Exception e) {
             throw new RuntimeException("Erro ao buscar todos os Emprestimos", e);
        }
    }

    @Override
    public void remover(Emprestimo entidade) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Emprestimo entidadeGerenciada = em.merge(entidade);
            em.remove(entidadeGerenciada);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao remover entidade Emprestimo", e);
        }
    }

    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
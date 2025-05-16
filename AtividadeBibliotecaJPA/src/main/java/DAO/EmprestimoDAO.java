package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ericasos.atividadebibliotecajpa.entidades.Emprestimo;

public class EmprestimoDAO implements GenericDAO<Emprestimo> {

    private EntityManager em;

    public EmprestimoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Emprestimo findById(long id){
        return em.find(Emprestimo.class, id);
    }
    
    @Override
    public List<Emprestimo> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder().createQuery();
        cq.select(cq.from(Emprestimo.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    @Override
    public void insert(Emprestimo entidade){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entidade); //SQL INSERT INTO
        transaction.commit();
    }
    
    @Override
    public void update(Emprestimo entidade) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entidade);
        transaction.commit();
    }
        
    @Override
    public void delete(Emprestimo entidade) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        
        Emprestimo emprestimo = em.find(Emprestimo.class, entidade.getId());
        em.remove(emprestimo);
        transaction.commit();
    }    
}
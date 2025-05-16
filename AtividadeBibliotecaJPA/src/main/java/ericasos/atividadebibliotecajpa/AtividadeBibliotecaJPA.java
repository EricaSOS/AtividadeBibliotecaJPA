package ericasos.atividadebibliotecajpa;

import javax.persistence.EntityManager;

public class AtividadeBibliotecaJPA {
    public static void main(String[] args) {
        EntityManager em = TableCreate.getEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        System.out.println("Banco inicializado com sucesso.");
    }
}

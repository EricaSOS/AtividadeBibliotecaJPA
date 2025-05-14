package ericasos.atividadebibliotecajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AtividadeBibliotecaJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ericasos_AtividadeBibliotecaJPA_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Tudo certo! Tabelas criadas no banco.");
    }
}

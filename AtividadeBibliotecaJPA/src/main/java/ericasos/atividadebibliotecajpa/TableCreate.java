package ericasos.atividadebibliotecajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TableCreate {
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("ericasos_AtividadeBibliotecaJPA_jar_1.0-SNAPSHOTPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}

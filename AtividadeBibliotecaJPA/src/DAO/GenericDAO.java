package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface GenericDAO<T> {
    default public EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("ericasos_AtividadeBibliotecaJPA_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
    
    T findById(long id);
    List<T> findAll();
    void insert(T entidade);
    void update(T entidade);
    void delete(T entidade);

}
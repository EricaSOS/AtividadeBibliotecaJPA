package DAO;

import java.util.List;
import ericasos.atividadebibliotecajpa.TableCreate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface GenericDAO<T> {
    default public EntityManager getEntityManager(){
        return TableCreate.getEntityManager();
    }
    
    T findById(long id);
    List<T> findAll();
    void insert(T entidade);
    void update(T entidade);
    void delete(T entidade);

}
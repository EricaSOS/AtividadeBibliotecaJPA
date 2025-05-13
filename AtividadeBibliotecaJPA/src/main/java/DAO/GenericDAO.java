package DAO;

import java.util.List;

public interface GenericDAO<T> {

    void salvar(T entidade);

    T buscarPorId(Long id);

    List<T> buscarTodos();

    void remover(T entidade);

    // Método para fechar os recursos associados a este DAO.
   
    void close();

}
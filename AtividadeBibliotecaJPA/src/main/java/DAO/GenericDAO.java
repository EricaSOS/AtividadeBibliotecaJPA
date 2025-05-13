/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;

public interface GenericDAO<T> {

    void salvar(T entidade);

    T buscarPorId(Object id);

    List<T> buscarTodos();

    void remover(T entidade);

    // Método para fechar os recursos associados a este DAO.
    // A implementação concreta será responsável por fechar o EntityManager subjacente.
    void close();

}
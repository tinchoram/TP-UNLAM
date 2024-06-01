/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import gui.persona.PersonaException;

import java.sql.SQLException;
import java.util.List;
public abstract class DAO<T,K>{
    
    public abstract void create(T entity) throws DaoException;
    public abstract T read(K id) throws DaoException;
    public abstract void update(T entity) throws DaoException, SQLException;
    public abstract void delete(K id) throws DaoException, SQLException;
    
    public abstract T findById(K id) throws DaoException;
    public abstract List<T> findAll(boolean solaActivos) throws DaoException, SQLException, PersonaException;
    
    public abstract boolean exist(K id) throws DaoException;
    
    public abstract void closeConnection() throws DaoException;

    public void execute(String sql) throws SQLException {
    }
}

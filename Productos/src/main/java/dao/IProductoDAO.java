/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import model.Producto;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public interface IProductoDAO {
    ObjectId create(Producto entity) throws DaoException;
    Optional<Producto> findById(ObjectId _id) throws EntityNotFoundException;
    List<Producto> findAll(int limit) throws EntityNotFoundException;
    boolean update(Producto entity) throws DaoException;
    boolean deleteById(ObjectId _id) throws EntityNotFoundException, DaoException;
    boolean deleteAll() throws DaoException;
    List<Producto> findByNombre(String nombre) throws EntityNotFoundException;
    List<Producto> findByCategoria(String categoria) throws EntityNotFoundException;
}

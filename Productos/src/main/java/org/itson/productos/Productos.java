/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.productos;

import config.MongoClientProvider;
import dao.IProductoDAO;
import dao.mongo.ProductoDAO;
import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
import model.Proovedor;

/**
 *
 * @author axelm
 */
public class Productos {

    public static void main(String[] args) {
        MongoClientProvider.INSTANCE.init();
        IProductoDAO pDAO = new ProductoDAO();
        List<String> categorias = new ArrayList<>();
        categorias.add("Tecnologia");
        categorias.add("Electronico");
        Proovedor proovedor = new Proovedor(null, "Pepe", "459687954", "Mexico");
        Producto p = new Producto(null, "Celular", 10000D, 20, proovedor, categorias, Instant.now(), null);
        try{
            System.out.println("Agregar al producto");
            pDAO.create(p);
            
            System.out.println("Buscar por ID");
            List<Producto> lista = pDAO.findAll(1);
            Producto pAux = lista.getFirst();
            pDAO.findById(pAux.getId()).ifPresent(producto -> {
                System.out.println("Encontrado: " + producto.getNombre());
            });
            
            System.out.println("Actualizar");
            pAux.setNombre("Iphone 15");
            pDAO.update(pAux);
            pDAO.findById(pAux.getId()).ifPresent(producto -> {
                System.out.println("Producto actualizado: " + producto.getNombre());
            });
            
            System.out.println("Lista de todos los productos");
            lista = pDAO.findAll(100);
            lista.forEach(p1 -> System.out.println("Id: " + p1.getId() + ", Nombre: " + p1.getNombre()));
            
            System.out.println("Eliminar");
            if(pDAO.deleteById(pAux.getId())){
                lista = pDAO.findAll(100);
                lista.forEach(p1 -> System.out.println("Id: " + p1.getId() + ", Nombre: " + p1.getNombre()));
            }
        } catch (DaoException | EntityNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

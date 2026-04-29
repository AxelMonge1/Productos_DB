/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mongo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import config.MongoClientProvider;
import dao.IProductoDAO;
import exceptions.DaoException;
import exceptions.EntityNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Producto;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class ProductoDAO implements IProductoDAO{
    private final MongoCollection<Producto> col;

    public ProductoDAO() {
        this.col = MongoClientProvider.INSTANCE.getCollection("productos", Producto.class);
    }
    
    @Override
    public ObjectId create(Producto entity) throws DaoException{
        try{
            if(entity.getId() == null){
                entity.setId(new ObjectId());
            }
            entity.setCreadoEn(Instant.now());
            col.insertOne(entity);
            return entity.getId();
        }catch(MongoException ex){
            throw new DaoException("No se logro insertar el producto");
        }
    }

    @Override
    public Optional<Producto> findById(ObjectId _id) throws EntityNotFoundException{
        try{
            return Optional.ofNullable(col.find(Filters.eq("_id", _id)).first());
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar el producto");
        }
    }

    @Override
    public List<Producto> findAll(int limit) throws EntityNotFoundException{
        try{
            return col.find().limit(limit).into(new ArrayList<>());
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro obtener la lista de productos");
        }
    }

    @Override
    public boolean update(Producto entity) throws DaoException{
        try {
            var result = col.updateOne(Filters.eq("_id", entity.getId()), Updates.combine(
                                                                            Updates.set("nombre", entity.getNombre()),
                                                                            Updates.set("precio", entity.getPrecio()),
                                                                            Updates.set("stock", entity.getStock()),
                                                                            Updates.set("proovedor", entity.getProovedor()),
                                                                            Updates.set("categorias", entity.getCategorias()),
                                                                            Updates.set("actualizadoEn", Instant.now())
            ));
            return result.getMatchedCount() != 0;
        } catch (MongoException ex) {
            throw new DaoException("No se logro actualizar el producto");
        }
    }

    @Override
    public boolean deleteById(ObjectId _id) throws EntityNotFoundException, DaoException{
        try {
            var result = col.deleteOne(Filters.eq("_id", _id));
            if(result.getDeletedCount() == 0){
                throw new EntityNotFoundException("No se encontro el producto");
            }
            return true;
        } catch (MongoException e) {
            throw new DaoException("No se logro eliminar el producto");
        }
    }

    @Override
    public boolean deleteAll() throws DaoException{
        try {
            var result = col.deleteMany(new Document());
            if(result.getDeletedCount() == 0){
                throw new DaoException("No se logro eliminar los productos");
            }
            return true;
        } catch (MongoException e) {
            throw new DaoException("No se logro eliminar los productos");
        }
    }    

    @Override
    public List<Producto> findByNombre(String nombre) throws EntityNotFoundException{
        try{
            List<Producto> lista = col.find(Filters.regex("nombre", nombre)).into(new ArrayList());
            return lista;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar los productos");
        }
    }

    @Override
    public List<Producto> findByCategoria(String categoria) throws EntityNotFoundException{
        try{
            List<Producto> lista = col.find(Filters.eq("categorias", categoria)).into(new ArrayList());
            return lista;
        }catch(MongoException ex){
            throw new EntityNotFoundException("No se logro encontrar los productos");
        }
    }
}
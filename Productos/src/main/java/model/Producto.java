/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.Instant;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class Producto {
    private ObjectId _id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private Proovedor proovedor;
    private List<String> categorias;
    private Instant creadoEn;
    private Instant actualizadoEn;

    public Producto() {
    }

    public Producto(ObjectId _id, String nombre, Double precio, Integer stock, Proovedor proovedor, List<String> categorias, Instant creadoEn, Instant actualizadoEn) {
        this._id = _id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.proovedor = proovedor;
        this.categorias = categorias;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setProovedor(Proovedor proovedor) {
        this.proovedor = proovedor;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }

    public void setActualizadoEn(Instant actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public Proovedor getProovedor() {
        return proovedor;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public Instant getActualizadoEn() {
        return actualizadoEn;
    }
}

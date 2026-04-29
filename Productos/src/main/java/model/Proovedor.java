/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.bson.types.ObjectId;

/**
 *
 * @author axelm
 */
public class Proovedor {
    private ObjectId _Id;
    private String nombre;
    private String contacto;
    private String pais;

    public Proovedor() {
    }

    public Proovedor(ObjectId _Id, String nombre, String contacto, String pais) {
        this._Id = _Id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.pais = pais;
    }

    public void setId(ObjectId _Id) {
        this._Id = _Id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ObjectId getId() {
        return _Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public String getPais() {
        return pais;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

import java.util.Objects;

/**
 * Clase que representa un domicilio del cliente.
 *
 * @author Alan Manjarrez 228982
 */
public class Domicilio {

    /**
     * Creacion de variables
     */
    private int id;
    private String calle;
    private String numero;
    private String codigoPostal;

    /**
     * Constructor por omision
     */
    public Domicilio() {
    }

    /**
     * Constructor sin el id
     *
     * @param calle
     * @param numero
     * @param codigoPostal
     */
    public Domicilio(String calle, String numero, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Constructor con todos los datos del domicilio
     *
     * @param id
     * @param calle
     * @param numero
     * @param codigoPostal
     */
    public Domicilio(int id, String calle, String numero, String codigoPostal) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Este metodo regresa el id del domicilio
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Este metodo agrega el id del domicilio
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Este metodo regresa la calle del domicilio
     *
     * @return
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Este metodo agrega la calle del domicilio
     *
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Este metodo regresa el numero del domicilio
     *
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Este metodo agrega el numero del domicilio
     *
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Este metodo regresa el codigo postal del domicilio
     *
     * @return
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Este metodo agrega el codigo postal del domicilio
     *
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * El método hash() que regresa el código Hash de una instancia de la clase.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.calle);
        hash = 23 * hash + Objects.hashCode(this.numero);
        hash = 23 * hash + Objects.hashCode(this.codigoPostal);
        return hash;
    }

    /**
     * El método equals(Object object) que compara este domicilio con el objeto
     * del parámetro.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.codigoPostal, other.codigoPostal);
    }

    /**
     * Regresa una cadena con los valores de los atributos de una instancia de
     * la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Domicilio{" + "id=" + id + ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + '}';
    }

}

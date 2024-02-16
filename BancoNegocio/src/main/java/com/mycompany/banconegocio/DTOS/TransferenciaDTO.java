/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.DTOS;

/**
 * Clase que representa una transferencia del banco.
 *
 * @author Alan Manjarrez 228982
 */
public class TransferenciaDTO {

    /**
     * Creacion de variable
     */
    private int id;

    /**
     * Constructor por omision
     */
    public TransferenciaDTO() {
    }

    /**
     * Constructor con el id
     *
     * @param id
     */
    public TransferenciaDTO(int id) {
        this.id = id;
    }

    /**
     * Este metodo regresa el id de transferencias
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Este metodo agrega el id de transferencias
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * El método hash() que regresa el código Hash de una instancia de la clase.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    /**
     * El método equals(Object object) que compara esta transferencia con el
     * objeto del parámetro.
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
        final TransferenciaDTO other = (TransferenciaDTO) obj;
        return this.id == other.id;
    }

    /**
     * Regresa una cadena con los valores de los atributos de una instancia de
     * la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Transferencias{" + "id=" + id + '}';
    }

}

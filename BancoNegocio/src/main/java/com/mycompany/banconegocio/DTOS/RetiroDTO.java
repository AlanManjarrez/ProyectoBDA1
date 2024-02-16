/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.DTOS;

import java.util.Objects;

/**
 * Clase que representa un retiro sin tarjeta del banco.
 *
 * @author Alan Manjarrez 228982
 */
public class RetiroDTO {

    /**
     * Declaración de Variables
     */
    private int id;
    private int folioOperacion;
    private String contra;
    private String estado;
    private String fechaTransaccionLimite;

    /**
     * Constructor sin el id
     *
     * @param folioOperacion
     * @param contra
     * @param estado
     * @param fechaTransaccionLimite
     */
    public RetiroDTO(int folioOperacion, String contra, String estado, String fechaTransaccionLimite) {
        this.folioOperacion = folioOperacion;
        this.contra = contra;
        this.estado = estado;
        this.fechaTransaccionLimite = fechaTransaccionLimite;
    }

    /**
     * Este metodo regresa el id de retiro
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Este metodo agrega el id de retiro
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Este metodo regresa el folio de operacion de retiro
     *
     * @return
     */
    public int getFolioOperacion() {
        return folioOperacion;
    }

    /**
     * Este metodo agrega el folio de operacion de retiro
     *
     * @param folioOperacion
     */
    public void setFolioOperacion(int folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    /**
     * Este metodo regresa la contra de retiro
     *
     * @return
     */
    public String getContra() {
        return contra;
    }

    /**
     * Este metodo agrega la contra de retiro
     *
     * @param contra
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * Este metodo regresa el estado de retiro
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Este metodo agrega el estado de retiro
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Este metodo regresa la fecha de transaccion limite de retiro
     *
     * @return
     */
    public String getFechaTransaccionLimite() {
        return fechaTransaccionLimite;
    }

    /**
     * Este metodo agrega la fecha de transaccion limite de retiro
     *
     * @param fechaTransaccionLimite
     */
    public void setFechaTransaccionLimite(String fechaTransaccionLimite) {
        this.fechaTransaccionLimite = fechaTransaccionLimite;
    }

    /**
     *
     * El método hash() que regresa el código Hash de una instancia de la clase.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.folioOperacion;
        hash = 97 * hash + Objects.hashCode(this.contra);
        hash = 97 * hash + Objects.hashCode(this.estado);
        hash = 97 * hash + Objects.hashCode(this.fechaTransaccionLimite);
        return hash;
    }

    /**
     * El método equals(Object object) que compara este retiro con el objeto del
     * parámetro.
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
        final RetiroDTO other = (RetiroDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.folioOperacion != other.folioOperacion) {
            return false;
        }
        if (!Objects.equals(this.contra, other.contra)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return Objects.equals(this.fechaTransaccionLimite, other.fechaTransaccionLimite);
    }

    /**
     * Regresa una cadena con los valores de los atributos de una instancia de
     * la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Retiro{" + "id=" + id + ", folioOperacion=" + folioOperacion + ", contra=" + contra + ", estado=" + estado + ", fechaTransaccionLimite=" + fechaTransaccionLimite + '}';
    }
}

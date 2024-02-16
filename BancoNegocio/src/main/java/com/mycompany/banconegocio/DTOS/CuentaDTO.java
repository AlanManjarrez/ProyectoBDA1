/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.DTOS;

import java.util.Objects;

/**
 * Clase que representa una cuenta del banco.
 *
 * @author Alan Manjarrez 228982
 */
public class CuentaDTO {

    /**
     * Creacion de variables
     */
    private int id;
    private int numeroCuenta;
    private String fechaApertura;
    private String fechaTransaccion;
    private float saldo;
    private String estado;
    private int idCliente;

    /**
     * Constructor sin el id
     *
     * @param numeroCuenta
     * @param fechaApertura
     * @param fechaTransaccion
     * @param saldo
     * @param estado
     * @param idCliente
     */
    public CuentaDTO(int numeroCuenta, String fechaApertura, String fechaTransaccion, float saldo, String estado, int idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.fechaTransaccion = fechaTransaccion;
        this.saldo = saldo;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    /**
     * Este metodo regresa el id de la cuenta
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Este metodo agrega el id de la cuenta
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Este metodo regresa el numero de cuenta de la cuenta
     *
     * @return
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Este metodo agrega el numero de cuenta de la cuenta
     *
     * @param numeroCuenta
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Este metodo regresa la fecha de apertura de la cuenta
     *
     * @return
     */
    public String getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Este metodo agrega la fecha de apertura de la cuenta
     *
     * @param fechaApertura
     */
    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Este metodo regresa la fecha de transaccion de la cuenta
     *
     * @return
     */
    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    /**
     * Este metodo agrega la fecha de transaccion de la cuenta
     *
     * @param fechaTransaccion
     */
    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    /**
     * Este metodo regresa el saldo de la cuenta
     *
     * @return
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Este metodo agrega el saldo de la cuenta
     *
     * @param saldo
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Este metodo regresa el estado de la cuenta
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Este metodo agrega el estado de la cuenta
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Este metodo regresa el id del cliente de la cuenta
     *
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Este metodo agrega el id del cliente de la cuenta
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * El método hash() que regresa el código Hash de una instancia de la clase.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + this.numeroCuenta;
        hash = 19 * hash + Objects.hashCode(this.fechaApertura);
        hash = 19 * hash + Objects.hashCode(this.fechaTransaccion);
        hash = 19 * hash + Float.floatToIntBits(this.saldo);
        hash = 19 * hash + Objects.hashCode(this.estado);
        hash = 19 * hash + this.idCliente;
        return hash;
    }

    /**
     * El método equals(Object object) que compara esta cuenta con el objeto del
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
        final CuentaDTO other = (CuentaDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numeroCuenta != other.numeroCuenta) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.fechaApertura, other.fechaApertura)) {
            return false;
        }
        if (!Objects.equals(this.fechaTransaccion, other.fechaTransaccion)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }

    /**
     * Regresa una cadena con los valores de los atributos de una instancia de
     * la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", numeroCuenta=" + numeroCuenta + ", fechaApertura=" + fechaApertura + ", fechaTransaccion=" + fechaTransaccion + ", saldo=" + saldo + ", estado=" + estado + ", idCliente=" + idCliente + '}';
    }

}

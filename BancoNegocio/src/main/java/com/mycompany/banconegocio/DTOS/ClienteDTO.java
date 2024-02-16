/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio.DTOS;

import java.util.Objects;

/**
 * Clase que representa un cliente del banco.
 *
 * @author Alan Manjarrez 228982
 */
public class ClienteDTO {

    /**
     * Creacion de variables
     */
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String usuario;
    private String contra;

    /**
     * Constructor sin el id
     *
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaNacimiento
     * @param usuario
     * @param contra
     */
    public ClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String usuario, String contra) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contra = contra;
    }

    /**
     * Este metodo regresa el id del cliente
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Este metodo asigna el id del cliente
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Este metodo regresa el nombre del cliente
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo asigna el nombre del cliente
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo regresa el apellido paterno del cliente
     *
     * @return
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Este metodo asigna el apellido paterno del cliente
     *
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Este metodo regresa el apellido materno del cliente
     *
     * @return
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Este metodo asigna el apellido materno del cliente
     *
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Este metodo regresa la fecha de nacimiento del cliente
     *
     * @return
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Este metodo asigna la fecha de nacimiento del cliente
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Este metodo regresa el usuario del cliente
     *
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Este metodo asigna el usuario del cliente
     *
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Este metodo regresa la contraseña del cliente
     *
     * @return
     */
    public String getContra() {
        return contra;
    }

    /**
     * Este metodo asigna la contraseña del cliente
     *
     * @param contra
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * El método hash() que regresa el código Hash de una instancia de la clase.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 79 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 79 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 79 * hash + Objects.hashCode(this.usuario);
        hash = 79 * hash + Objects.hashCode(this.contra);
        return hash;
    }

    /**
     * El método equals(Object object) que compara este cliente con el objeto
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
        final ClienteDTO other = (ClienteDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contra, other.contra);
    }

    /**
     * Regresa una cadena con los valores de los atributos de una instancia de
     * la clase
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario + ", contra=" + contra + '}';
    }

}

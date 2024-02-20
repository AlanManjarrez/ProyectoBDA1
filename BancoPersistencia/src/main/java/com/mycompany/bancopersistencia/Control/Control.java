/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.Control;

import com.mycompany.banconegocio.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.Conexiones.ConexionBD;
import com.mycompany.bancopersistencia.Conexiones.IConexionBD;
import com.mycompany.bancopersistencia.DAOS.ClienteDAO;
import com.mycompany.bancopersistencia.PersistenciaException.PersistenciaException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan Manjarrez 228982
 */
public class Control {
    IConexionBD bd = new ConexionBD("jdbc:mysql://localhost:3306/banco", "root", "0990");

    /**
     * Método para agregar un nuevo cliente a la base de datos.
     *
     * @param clienteDTO El objeto ClienteDTO que representa al cliente a
     * agregar.
     */
    public void agregarCliente(ClienteDTO clienteDTO) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO((IConexionBD) bd.crearConexion());

        this.verificarCamposVacios(clienteDTO);
        this.verificarTextoCliente(clienteDTO);
        this.edadMinima(clienteDTO);
        try {
            clienteDAO.agregarCliente(clienteDTO);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para actualizar la información de un cliente en la base de datos.
     *
     * @param clienteDTO El objeto ClienteDTO con la información actualizada del
     * cliente.
     */
    public void actualizarCliente(ClienteDTO cliente) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO((IConexionBD) bd.crearConexion());

        this.verificarCamposVacios(cliente);
        this.verificarTextoCliente(cliente);
        this.edadMinima(cliente);
        try {
            clienteDAO.actualizarCliente(cliente);
        } catch (PersistenciaException e) {
            throw new SQLException("Error al actualizar el cliente", e);
        }
    }

    private void verificarCamposVacios(ClienteDTO cliente) throws SQLException {
        if ((cliente.getNombre() == null || cliente.getNombre().isEmpty()) && 
            (cliente.getApellidoMaterno() == null || cliente.getApellidoMaterno().isEmpty()) &&
            (cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().isEmpty()) &&  
            (cliente.getContra() == null || cliente.getContra().isEmpty()) &&
            (cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().isEmpty())) {
            throw new SQLException("Todos los campos son obligatorios.");
        }
    }

    private void edadMinima(ClienteDTO cliente) throws SQLException {
        int edadMinima = 18;

        int edadCliente = Integer.parseInt(cliente.getFechaNacimiento().substring(5, 9));

        if (edadCliente < edadMinima) {
            throw new SQLException("No cumples con la edad necesaria");
        }
    }

    private void verificarTextoCliente(ClienteDTO cliente) throws SQLException {
        int maxLongitudTexto = 30;
        int maxLongitudDomicilio = 100;
        if (cliente.getNombre().length() > maxLongitudTexto) {
            throw new SQLException("El nombre no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getApellidoPaterno().length() > maxLongitudTexto) {
            throw new SQLException("El apellido paterno no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getApellidoMaterno().length() > maxLongitudTexto) {
            throw new SQLException("El apellido materno no puede exceder " + maxLongitudTexto + " caracteres.");
        }
        if (cliente.getContra().length() > maxLongitudTexto) {
            throw new SQLException("La Contraseña no puede exceder " + maxLongitudTexto + " caracteres.");
        }
    }
}

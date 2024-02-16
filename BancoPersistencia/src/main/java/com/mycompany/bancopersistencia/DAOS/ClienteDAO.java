/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.banconegocio.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.Conexiones.IConexionBD;
import com.mycompany.bancopersistencia.PersistenciaException.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan Manjarrez 228982
 */
public class ClienteDAO implements IClienteDAO {

    final IConexionBD conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException {
        try ( Connection conexion = this.conexion.crearConexion();) {
            CallableStatement cal = (CallableStatement) conexion.prepareCall("call sp_insertarClienteNuevo(?,?,?,?,?,?,?)");

            cal.setString(1, cliente.getNombre());
            cal.setString(2, cliente.getApellidoPaterno());
            cal.setString(3, cliente.getApellidoMaterno());
            cal.setString(4, cliente.getFechaNacimiento());
            cal.setString(5, cliente.getUsuario());
            cal.setString(6, cliente.getContra());

            int registro = cal.executeUpdate();
            LOG.log(Level.SEVERE, "Se agrego el cliente con exito", registro);

            ResultSet reg = cal.getGeneratedKeys();
            reg.next();

            Cliente clienteNuevo = new Cliente(reg.getInt(1), cliente.getNombre(),
                    cliente.getApellidoMaterno(), cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento(), cliente.getUsuario(), cliente.getContra());

            return clienteNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar al cliente", e);
            throw new PersistenciaException("No se pudo agregar al cliente", e);
        }
    }

    @Override
    public Cliente actualizarCliente(ClienteDTO cliente) throws PersistenciaException {
        try ( Connection conexion = this.conexion.crearConexion();) {
            CallableStatement cal = (CallableStatement) conexion.prepareCall("call sp_actualizar_cliente(?,?,?,?,?,?,?,?)");

            cal.setInt(1, cliente.getId());
            cal.setString(2, cliente.getNombre());
            cal.setString(3, cliente.getApellidoPaterno());
            cal.setString(4, cliente.getApellidoMaterno());
            cal.setString(5, cliente.getFechaNacimiento());
            cal.setString(6, cliente.getUsuario());
            cal.setString(7, cliente.getContra());

            int registro = cal.executeUpdate();
            LOG.log(Level.SEVERE, "Se agrego el cliente con exito", registro);

            if (registro > 0) {
                ResultSet reg = cal.getGeneratedKeys();
                reg.next();

                Cliente clienteNuevo = new Cliente(reg.getInt(1), cliente.getNombre(),
                        cliente.getApellidoMaterno(), cliente.getApellidoMaterno(),
                        cliente.getFechaNacimiento(), cliente.getUsuario(), cliente.getContra());

                return clienteNuevo;
            } else {
                throw new PersistenciaException("No se pudo actualizar el cliente ");
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo actualizar al cliente", e);
            throw new PersistenciaException("No se pudo actualizar al cliente", e);
        }

    }

}

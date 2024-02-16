/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.banconegocio.DTOS.ClienteDTO;
import com.mycompany.bancopersistencia.PersistenciaException.PersistenciaException;

/**
 *
 * @author Alan Manjarrez 228982
 */
public interface IClienteDAO {
    /**
     * Agrega el cliente a la base de datos
     * 
     * @param cliente
     * @return
     * @throws PersistenciaException 
     */
    public Cliente agregarCliente(ClienteDTO cliente) throws PersistenciaException;
    
    /**
     * Actualiza el cliente a la base de datos
     * 
     * @param cliente
     * @return
     * @throws PersistenciaException 
     */
    public Cliente actualizarCliente(ClienteDTO cliente) throws PersistenciaException;
}

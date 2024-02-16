/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan Manjarrez 228982
 */
public class ConexionBD implements IConexionBD {
    final String cadenaConexion;
    final String usuarios;
    final String contra;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    public ConexionBD(String cadenaConexion, String usuarios, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuarios = usuarios;
        this.contra = contra;
    }
   
    @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuarios, contra);
        LOG.log(Level.INFO,"conexion exitosa [0]", cadenaConexion);
        
        return conexion;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.DAOS;

import com.mycompany.banconegocio.DTOS.CuentaDTO;
import com.mycompany.bancopersistencia.PersistenciaException.PersistenciaException;

/**
 *
 * @author Alan Manjarrez 228982
 */
public interface ICuentaDAO {
        /**
         * 
         * 
         * @param cuenta
         * @return
         * @throws PersistenciaException 
         */
        public CuentaDTO crearCuenta(CuentaDTO cuenta)throws PersistenciaException;
        
        /**
         * 
         * 
         * @param cuenta
         * @return
         * @throws PersistenciaException 
         */
        public CuentaDTO cancelarCuenta(CuentaDTO cuenta)throws PersistenciaException;
        
        /**
         * 
         * 
         * @param cuenta
         * @return
         * @throws PersistenciaException 
         */
        public CuentaDTO consultarCuenta(CuentaDTO cuenta)throws PersistenciaException;
}

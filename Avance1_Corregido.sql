CREATE DATABASE banco;

USE banco;

CREATE TABLE Domicilios (
	id_domicilio INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(85) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	codigo_postal VARCHAR(10) NOT NULL
);

CREATE TABLE Clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombres VARCHAR(85) NOT NULL,
  apellido_paterno VARCHAR(85) NOT NULL,
  apellido_materno VARCHAR(85) NOT NULL,
  nombre_completo VARCHAR(255) GENERATED ALWAYS AS (CONCAT(nombres, ' ', apellido_paterno, ' ', apellido_materno)) STORED,
  fecha_nacimiento DATE NOT NULL,
  usuario VARCHAR(50) UNIQUE NOT NULL,
  contraseña VARCHAR(50) NOT NULL,
  id_domicilio INT NOT NULL,
  edad INT,
  FOREIGN KEY (id_domicilio) REFERENCES Domicilios(id_domicilio)
);

CREATE TABLE Cuentas (
  id_cuenta INT PRIMARY KEY AUTO_INCREMENT,
  numero_cuenta INT UNIQUE NOT NULL,
  fecha_apertura DATE NOT NULL,
  fecha_transaccion DATE NOT NULL,
  saldo DECIMAL(10,2) NOT NULL,
  estado ENUM('Activa', 'Cancelada'),
  id_cliente INT NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE Transferencias (
  id_transferencia INT PRIMARY KEY AUTO_INCREMENT,
  FOREIGN KEY (id_transferencia) REFERENCES Cuentas(id_cuenta)
);

CREATE TABLE Retiro_sin_tarjeta (
  id_retiro INT PRIMARY KEY AUTO_INCREMENT,
  folio_operacion INT NOT NULL,
  contrasena VARCHAR(8) NOT NULL,
  estado ENUM('Activo', 'Inactivo'),
  fecha_transaccion_limite DATETIME NOT NULL,
  FOREIGN KEY (id_retiro) REFERENCES Cuentas(id_cuenta)
);
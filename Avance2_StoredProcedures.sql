
-- INSERCION DEL CLIENTE

DELIMITER //
create procedure sp_insertarClienteNuevo(
    in c_nombre VARCHAR(50),
    in c_apellido_paterno VARCHAR(50),
    in c_apellido_materno VARCHAR(50),
    in c_fecha_nacimiento date,
    in c_usuario VARCHAR(30),
    in c_contraseña VARCHAR(30)
	)
BEGIN
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
        ROLLBACK; 
    END;

    START transaction;
    SET AUTOCOMMIT = 0;

    insert clientes(nombres,apellido_paterno,apellido_materno,fecha_nacimiento,usuario,contraseña)
    values (c_nombre, c_apellido_paterno, c_apellido_materno, c_fecha_nacimiento, c_usuario, c_contraseña);

    set @id_cliente_ultimo = last_insert_id();

    insert into cuentas(estado,fecha_apertura,saldo,id_cliente) values (p_numero_cuenta,"Activa",now(),0.0,@id_cliente_ultimo);

    COMMIT; 
END ;
DELIMITER ;

-- ACTUALIZACION DEL CLIENTE

DELIMITER ))
CREATE procedure sp_actualizar_cliente(
in buscar_cliente INT,
in c_nombre VARCHAR(85),
in c_apellido_paterno VARCHAR(85),
in c_apellido_materno VARCHAR(85),
in c_fecha_nacimiento date,
in c_usuario VARCHAR(50),
in c_contraseña VARCHAR(50)
)
BEGIN
    DECLARE EXIT HANDLER FOR sqlexception
	BEGIN 
		ROLLBACK;
	END;

	START transaction;
    SET AUTOCOMMIT = 0;

	UPDATE clientes SET nombre = c_nombre WHERE id_cliente = buscar_cliente;
    UPDATE clientes SET apellido_paterno = c_apellido_paterno WHERE id_cliente = buscar_cliente;
    UPDATE clientes SET apellido_materno = c_apellido_materno WHERE id_cliente = buscar_cliente;
    UPDATE clientes SET fecha_nacimiento = c_fecha_nacimiento WHERE id_cliente = buscar_cliente;
    UPDATE clientes SET usuario = c_usuario WHERE id_cliente = buscar_cliente;
    UPDATE clientes SET contraseña = c_contraseña WHERE id_cliente = buscar_cliente;
    
    COMMIT;
END ))
DELIMITER ;


DELIMITER **
CREATE procedure b_mostrar_cuenta(IN buscar_cuenta INT)
BEGIN 
	SELECT * FROM cuentas WHERE id_cuenta = buscar_cuenta;
END ;
DELIMITER ;

DELIMITER $$
CREATE procedure eliminar_cuenta(in buscar_cuenta INT)
BEGIN 
	DELETE cuentas WHERE id_cuenta = buscar_cuenta;
END ;
DELIMITER ;



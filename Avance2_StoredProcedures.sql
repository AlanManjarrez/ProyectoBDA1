DELIMITER //
create procedure sp_insertarClienteNuevo(
	in c_nombres VARCHAR(85),
	in c_apellido_paterno VARCHAR(85),
	in c_apellido_materno VARCHAR(85),
	in c_fecha_nacimiento date,
	in c_usuario VARCHAR(50),
	in c_contraseña VARCHAR(50), 
    in d_calle VARCHAR(85),
    in d_numero VARCHAR(10),
    in d_codigo_postal VARCHAR(10)
    )
BEGIN
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN
		ROLLBACK; 
	END;
    
    START transaction;
	SET AUTOCOMMIT = 0;

	insert clientes(nombres,apellido_paterno,apellido_materno,fecha_nacimiento,usuario,contraseña,domicilio)
    values (c_nombres, c_apellido_paterno, c_apellido_materno, c_fecha_nacimiento, c_usuario, c_contraseña, c_domicilio);
    
    set @id_cliente_ultimo = last_insert_id();
    
    insert domicilios(calle, numero, codigo_postal, id_cliente)
    values(d_calle,d_numero,d_codigo_postal, @id_cliente_ultimo);
	
    insert into cuentas(estado,fecha_apertura,saldo,id_cliente,fecha_transaccion) values ("Activa",now(),0.0,@id_cliente_ultimo,now());
    
    COMMIT; 
END //
DELIMITER ;

-- ACTUALIZACION DEL CLIENTE

DELIMITER &&
CREATE procedure sp_actualizar_cliente(
in c_id_cliente int,
in c_nombres VARCHAR(85),
in c_apellido_paterno VARCHAR(85),
in c_apellido_materno VARCHAR(85),
in c_fecha_nacimiento date,
in c_usuario VARCHAR(50),
in c_contraseña VARCHAR(50),
in d_calle VARCHAR(85),
in d_numero VARCHAR(10),    
in d_codigo_postal VARCHAR(10)
)
BEGIN
    DECLARE EXIT HANDLER FOR sqlexception
    BEGIN 
        ROLLBACK;
    END;

    START transaction;
    SET AUTOCOMMIT = 0;

    UPDATE clientes SET nombres = c_nombres, apellido_paterno = c_apellido_paterno, apellido_materno = c_apellido_materno,
    fecha_nacimiento = c_fecha_nacimiento, usuario = c_usuario, contraseña = c_contraseña
    where id_cliente = c_id_cliente;
    
    UPDATE domicilios SET calle = d_calle, numero = d_numero, codigo_postal = d_codigo_postal
    where id_cliente = c_id_cliente;
    
    COMMIT;
END && ;
DELIMITER ;

DELIMITER }}
CREATE procedure sp_iniciarSesion(
	IN c_usuario varchar(50),
	IN c_contra varchar(50),
	out c_id int,
	out c_nombres varchar(85),
	out c_apellidoP varchar(85),
	out c_apellidoM varchar(85),
	out c_fechaNac date,
    out d_calle VARCHAR(85),
    out d_numero VARCHAR(10),
    out d_codigo_postal VARCHAR(10)

)
BEGIN
	DECLARE vExisteUsuario INT;
	SELECT COUNT(*) INTO vExisteUsuario FROM clientes WHERE usuario = c_usuario AND contraseña = c_contra;
    
    if vExisteUsuario = 1 then
    select id_cliente, nombres, apellido_paterno, apellido_materno, fecha_nacimiento into c_id, c_nombres, c_apellidoP, c_apellidoM, c_fechaNac from clientes where usuario = c_usuario;
    else
     set c_id= 0;
     set c_nombres= null;
	 set c_apellidoP= null;
	 set c_apellidoM= null;
	 set c_fechaNac= null;
     end if;
     
     if vExisteUsuario = 1 then
     select calle, numero, codigo_postal into d_calle, d_numero, d_codigo_postal from domicilios where usuario = c_usuario;
    else
     set d_calle= null;
	 set d_numero = null;
	 set d_codigo_postal = null;
     end if;
     
     end }};
DELIMITER ;
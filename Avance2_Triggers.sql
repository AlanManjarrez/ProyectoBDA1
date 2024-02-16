DELIMITER $$
CREATE TRIGGER generar_numero_cuenta
BEFORE INSERT ON cuentas
FOR EACH ROW
BEGIN
    DECLARE numero_cuenta BIGINT;
    SET numero_cuenta = FLOOR(100000000000 + RAND() * 900000000000); 
    SET NEW.numero_cuenta = numero_cuenta; 
END$$
DELIMITER ;
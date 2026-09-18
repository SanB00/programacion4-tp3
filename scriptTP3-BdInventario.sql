CREATE DATABASE `bdInventario`;
USE bdInventario;

CREATE TABLE `Categorias` (
    `IdCategoria` int NOT NULL AUTO_INCREMENT,
    `Nombre` varchar(45) NOT NULL,
    PRIMARY KEY (`IdCategoria`)
);

CREATE TABLE `Productos` (
    `Codigo` varchar(20) NOT NULL,
    `Nombre` varchar(45) NOT NULL,
    `Precio` decimal(10,2) NOT NULL,
    `Stock` int NOT NULL,
    `IdCategoria` int NOT NULL,
    PRIMARY KEY (`Codigo`),
    FOREIGN KEY (`IdCategoria`) REFERENCES Categorias(`IdCategoria`)
);


DELIMITER $$
CREATE PROCEDURE sp_AgregarProducto (
    IN pCodigo VARCHAR(20),
    IN pNombre VARCHAR(45),
    IN pPrecio DECIMAL(10,2),
    IN pStock INT,
    IN pIdCategoria INT
)
BEGIN
    INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria)
    VALUES (pCodigo, pNombre, pPrecio, pStock, pIdCategoria);
END$$
DELIMITER ;


/* listado de productos de comida en una casa */
INSERT INTO Categorias (Nombre) VALUES ('Comida');
INSERT INTO Categorias (Nombre) VALUES ('Bebidas');
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('001', 'Agua', 2.50, 100, 2);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('002', 'Leche', 1.75, 150, 2);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('003', 'Pan', 1.25, 200, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('004', 'Huevos', 3.00, 80, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('005', 'Queso', 4.50, 60, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('006', 'Arroz', 2.00, 120, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('007', 'Frijoles', 1.80, 90, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('008', 'Pasta', 1.50, 110, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('009', 'Aceite', 3.20, 70, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('010', 'Azúcar', 1.90, 130, 1);
INSERT INTO Productos (Codigo, Nombre, Precio, Stock, IdCategoria) VALUES ('011', 'Sal', 1.00, 140, 1);
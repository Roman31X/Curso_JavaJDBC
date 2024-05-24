# Java + Base de Datos

## ¿Que es una Base de datos o BD?
- Una base de datos nos permite almacenar información, de manera organizada
en formas de tablas, agregando relaciones entre ellas.
- Para usar una base de datos, se utiliza un gestor de base de datos ***DBMS*** - 
Database Managment System.

## Base de datos usadas para trabajar Java
- Java nos permite trabajar la información de varias bases de datos como:
- [x] PostgreSql
- [x] MySQL
- [x] Oracle
- [x] SQL Server
- [x] etc...

## Lenguaje SQL
- SQL o Structured Query Language es el lenguaje utilizado para consulta o manipular
la información de una BD.
- Las sentencias que utiliza más frecuentemente para manipular la información de
BD son:
```roomsql
- Select -> Seleccionar información
- Insert -> Agregar información
- Update -> Actualizar infromación
- Delete -> Eliminar información
```

## Gestor de base de datos usado para el curso es ***MySQL Workbench 8.0***

- [x] Sintaxis - Crear base de datos en MySQL
```roomsql
-- COMANDO PARA CREAR LA BASE DE DATOS
CREATE SCHEMA `zona_fit_db` ;
```

- [x] Sintaxis - Usar base de datos en MySQL
```roomsql
-- COMANDO PARA USAR LA BD CREADA
USE zona_fit_db;
```

- [x] Sintaxis - Crear una tabla en MySQL
```roomsql
-- CREAMOS LAS TABLAS EN LA BASE DE DATOS
CREATE TABLE `zona_fit_db`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `membresia` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `membresia_UNIQUE` (`membresia` ASC) VISIBLE);
```

## Sentencia CRUD en Mysql
CRUD es el acrónimo de:

- [x] Create (Crear)
- [x] Read (Leer)
- [x] Update (Actualizar)
- [x] Delete (Borrar)

Este concepto se utiliza para describir las cuatro operaciones básicas 
que pueden realizarse en la mayoría de las bases de datos y sistemas de 
gestión de información.

## C - CREATE - CREAR
```roomsql
CREATE TABLE `zona_fit_db`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `membresia` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `membresia_UNIQUE` (`membresia` ASC) VISIBLE);
```

## R - READ - LEER
```roomsql
SELECT * FROM cliente;
```

## U - UPDATE - ACTUALIZAR
```roomsql
UPDATE `zona_fit_db`.`cliente` SET `apellido` = 'Rojas', `membresia` = '150' WHERE (`id` = '2');
```

## D - DELETE - BORRAR
```roomsql
DELETE FROM `zona_fit_db`.`cliente` WHERE (`id` = '3');
```



-- DBUniversidad

--CREAR TABLA UNIVERSIDAD
CREATE TABLE universidades(
	nit VARCHAR(15) PRIMARY KEY NOT NULL,
	nombre VARCHAR(60) NOT NULL, 
	direccion VARCHAR(100) NOT NULL, 
	email VARCHAR(150) NOT NULL
);

--CREAR TABLA TelefonosUniversidad
CREATE TABLE telefonos_universidad(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	numero_telefono VARCHAR(15) NOT NULL,
	universidad_nit VARCHAR(15) NOT NULL,
	FOREIGN KEY(universidad_nit)
	REFERENCES universidades(nit)
);

--CREAR TABLA FACULTADES
CREATE TABLE facultades(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
	codigo VARCHAR(10) NOT NULL, 
	nombre VARCHAR(30) NOT NULL,
	universidad_nit VARCHAR(15) NOT NULL,
	FOREIGN KEY(universidad_nit) REFERENCES universidades(nit)
);

--CREAR TABLA ESTUDIANTES
CREATE TABLE estudiantes(
	cedula VARCHAR(20) PRIMARY KEY NOT NULL, 
	nombre VARCHAR(50) NOT NULL, 
	apellido VARCHAR(50) NOT NULL, 
	edad INTEGER NOT NULL, 
	sexo CHAR NOT NULL, 
	codigo VARCHAR(10) NOT NULL,
	facultad_id INTEGER NOT NULL,
	FOREIGN KEY(facultad_id) REFERENCES facultades(id)
);


CREATE TABLE telefonos_estudiante(
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	numero_telefono VARCHAR(15) NOT NULL,
	estudiante_cedula VARCHAR(20) NOT NULL,
	FOREIGN KEY(estudiante_cedula) REFERENCES estudiantes(cedula)
);






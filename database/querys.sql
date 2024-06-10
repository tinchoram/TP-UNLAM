
-- database: unlam

CREATE TABLE alumnos (
    legajo INTEGER NOT NULL UNIQUE,
    dni INTEGER NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    genero CHAR(1) NOT NULL,
    fec_ing DATE DEFAULT CURRENT_DATE,
    fec_nac DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    localidad VARCHAR(50) NOT NULL,
    cant_mat_aprobadas SMALLINT NOT NULL,
	estado CHAR(1) NOT NULL
);
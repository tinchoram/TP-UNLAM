
-- database: unlam

CREATE TABLE alumnos (
    ID INTEGER NOT NULL,
	DNI INTEGER NOT NULL,
    NOMBRE VARCHAR(50) NOT NULL,
    APELLIDO VARCHAR(50) NOT NULL,
    FEC_NAC DATE NOT NULL,
    ESTADO CHAR(1) NOT NULL,
    PRIMARY KEY (DNI)
);

-- Datos:
INSERT INTO alumnos
(ID, DNI, NOMBRE, APELLIDO, FEC_NAC, ESTADO)
VALUES(('10'::int4), ('223456789'::int4), ('Homer'), ('Perez'), ('1972-03-20 -03'), ('A'));

INSERT INTO alumnos
(ID, DNI, NOMBRE, APELLIDO, FEC_NAC, ESTADO)
VALUES(('20'::int4), ('223456790'::int4), ('Bart'), ('Perez'), ('1972-03-20 -03'), ('A'));

INSERT INTO alumnos
(ID, DNI, NOMBRE, APELLIDO, FEC_NAC, ESTADO)
VALUES(('30'::int4), ('223456791'::int4), ('Lisa'), ('Perez'), ('1972-03-20 -03'), ('A'));

INSERT INTO alumnos
(ID, DNI, NOMBRE, APELLIDO, FEC_NAC, ESTADO)
VALUES(('40'::int4), ('323456792'::int4), ('Marge'), ('Perez'), ('1972-03-20 -03'), ('B'));

INSERT INTO alumnos
(ID, DNI, NOMBRE, APELLIDO, FEC_NAC, ESTADO)
VALUES(('60'::int4), ('523456792'::int4), ('Marge'), ('Perez'), ('1972-03-20 -03'), ('B'));

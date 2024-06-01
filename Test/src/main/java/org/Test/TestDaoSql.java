package org.Test;

import dao.DAO;
import dao.DAOFactory;
import dao.DaoException;
import dao.DaoFactoryException;
import gui.persona.Alumno;
import gui.persona.PersonaException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dao.DAOFactory.*;
import static junit.framework.TestCase.assertEquals;

public class TestDaoSql {

    int legajo = 1;
    String name = "Juan";
    String lastname = "Perez";
    int dni = 123456789;
    LocalDate fecNac = LocalDate.of(1972, 3, 20);
    LocalDate fecIng = LocalDate.of(2024, 3, 1);

    DAO daoSql;
    @Before
    public void setUp() throws IOException, DaoFactoryException, SQLException {

        DAOFactory factory = DAOFactory.getInstance();

        Map<String, String> configMap = new HashMap<>();

        configMap.put(TIPO_DAO, TIPO_DAO_SQL);
        configMap.put(URL_DB, "jdbc:postgresql://localhost:5432/unlam");
        configMap.put(USER_DB, "postgres");
        configMap.put(PWD_DB, "postgres");

        daoSql = factory.crearDAO(configMap);

        // Limpiar table alumno
        String sql = "DELETE FROM alumnos";
        daoSql.execute(sql);
    }

    @Test
    public void testCreateDaoSql() throws DaoException {
        System.out.println("Starting Dao");
    }

    @Test
    public void testCreateAlumnoSql() throws DaoException, PersonaException, DaoFactoryException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu);
        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());
    }

    @Test
    public void testEditAlumnoSql() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu);
        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        aluRead.setNombre(lastname);
        daoSql.update(aluRead);
        Alumno aluReadEdited = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluReadEdited.toString());
        assertEquals(aluReadEdited.getNombre(), lastname);
    }

    @Test
    public void testDeleteAlumnoSql() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu);
        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        daoSql.delete(dni);
        Alumno aluReadDeleted = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluReadDeleted.toString());
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());
    }

    @Test
    public void testFindByIdAlumnoSql() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu);
        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());
    }

    @Test
    public void testFindAllAlumnoSqlTrue() throws DaoException, PersonaException, SQLException {

        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu);
        legajo++;
        dni+=1;
        Alumno alu2 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu2);
        legajo++;
        dni+=1;
        Alumno alu3 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu3);

        List<Alumno> alumnoList = new ArrayList<Alumno>(daoSql.findAll(true));
        System.out.println("Alumnos leídos ==> "+alumnoList.toString());
        assertEquals(alumnoList.size(), 3);
    }

    @Test
    public void testFindAllAlumnoSqlFalse() throws DaoException, PersonaException, SQLException {

        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu);
        legajo++;
        dni+=1;
        Alumno alu2 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu2);
        legajo++;
        dni+=1;
        Alumno alu3 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu3);

        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        daoSql.delete(dni);
        Alumno aluReadDeleted = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> "+aluReadDeleted.toString());
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());

        legajo++;
        dni+=1;
        Alumno alu4 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoSql.create(alu4);

        List<Alumno> alumnoList = new ArrayList<Alumno>(daoSql.findAll(false));
        System.out.println("Alumnos leídos ==> "+alumnoList.toString());
        assertEquals(alumnoList.size(), 4);

    }


}

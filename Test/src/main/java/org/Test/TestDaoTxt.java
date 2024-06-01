package org.Test;

import dao.*;
import gui.persona.Alumno;
import gui.persona.PersonaException;
import org.junit.After;
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

public class TestDaoTxt {

    DAO daoTxt;
    int legajo = 1;
    int dni = 123456789;
    String name = "Homer";
    String lastname = "Simpson";
    short cantMatAprb = 2;
    LocalDate fecNac = LocalDate.of(1972, 3, 20);
    LocalDate fecIng = LocalDate.of(2024, 3, 1);
    private static final String TEST_FILE_PATH = "alumnos_base_test.txt";
//    public static void main(String[] args) throws DaoException {
//        System.out.println("Starting Test");
//
//    }

    @Before
    public void setUp() throws IOException, DaoFactoryException {
        // Eliminar el archivo de prueba si existe antes de cada prueba
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
        DAOFactory factory = DAOFactory.getInstance();
        Map<String, String> configMap = new HashMap<>();
        configMap.put(TIPO_DAO, TIPO_DAO_TXT);
        configMap.put(FULL_PATH, "alumnos_base_test.txt");
        daoTxt = factory.crearDAO(configMap);
    }

    @After
    public void tearDown() throws IOException {
        // Limpiar después de cada prueba si es necesario
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }

    @Test
    public void testCreateDaoTxt() throws DaoException {
        System.out.println("Starting Dao");
    }

    @Test
    public void testCreateAlumnoTxt() throws DaoException, PersonaException, DaoFactoryException {

        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoTxt.create(alu);
        Alumno aluRead = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());
    }

    @Test
    public void testEditAlumnoTxt() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoTxt.create(alu);

        String nameEdited = "HomerEdited";
        Alumno aluRead = (Alumno) daoTxt.read(dni);
        aluRead.setNombre(nameEdited);
        daoTxt.update(aluRead);
        Alumno aluReadEdited = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> "+aluReadEdited.toString());
        assertEquals(aluReadEdited.getNombre(), nameEdited);

    }

    @Test
    public void testDeleteAlumnoTxt() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoTxt.create(alu);

        Alumno aluRead = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());

        daoTxt.delete(dni);
        Alumno aluReadDeleted = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> "+aluReadDeleted.toString());
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());
    }

    @Test
    public void testReadAllAlumnoTxt() throws DaoException, PersonaException, SQLException {
        Alumno alumno1 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoTxt.create(alumno1);
        legajo++;
        Alumno alumno2 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoTxt.create(alumno2);
        legajo++;
        Alumno alumno3 = new Alumno(legajo, name, lastname, 11222333, fecIng, fecNac);
        daoTxt.create(alumno3);
        legajo++;
        Alumno alumno4 = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        daoTxt.create(alumno4);

        Alumno aluRead = (Alumno) daoTxt.read(11222333);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        daoTxt.delete(11222333);


        List<Alumno> alumnoList = new ArrayList<Alumno>(daoTxt.findAll(true));
        System.out.println("Alumnos leídos ==> "+alumnoList.toString());
        assertEquals(alumnoList.size(), 3);
    }



}
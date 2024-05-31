package org.Test;

import dao.*;
import gui.persona.Alumno;
import gui.persona.Carrera;
import gui.persona.PersonaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dao.DAOFactory.*;
import static junit.framework.TestCase.assertEquals;

public class TestDao {

    DAO dao;
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
        //DAOFactory factory2 = DAOFactory.getInstance();

        //DAO dao = new DaoTXT("alumnos.txt");
        //dao = new DaoSQL("jdbc:mysql://localhost:3306/universidad", "root", "root");
        Map<String, String> configMap = new HashMap<>();
        configMap.put(TIPO_DAO, TIPO_DAO_TXT);
        configMap.put(FULL_PATH, "alumnos_base_test.txt");
//        configMap.put(TIPO_DAO, TIPO_DAO_SQL);
//        configMap.put(URL_DB, "jdbc:mysql://localhost:3306/universidad");
//        configMap.put(USER_DB, "root");
//        configMap.put(PWD_DB, "root");

        dao = factory.crearDAO(configMap);
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
        dao.create(alu);
        Alumno aluRead = (Alumno) dao.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());
    }

    @Test
    public void testEditAlumnoTxt() throws DaoException, PersonaException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        dao.create(alu);

        String nameEdited = "HomerEdited";
        Alumno aluRead = (Alumno) dao.read(dni);
        aluRead.setNombre(nameEdited);
        dao.update(aluRead);
        Alumno aluReadEdited = (Alumno) dao.read(dni);
        System.out.println("Alumno leído ==> "+aluReadEdited.toString());
        assertEquals(aluReadEdited.getNombre(), nameEdited);

    }

    @Test
    public void testDeleteAlumnoTxt() throws DaoException, PersonaException {
        Alumno alu = new Alumno(legajo, name, lastname, dni, fecIng, fecNac);
        dao.create(alu);

        Alumno aluRead = (Alumno) dao.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());

        dao.delete(dni);
        Alumno aluReadDeleted = (Alumno) dao.read(dni);
        System.out.println("Alumno leído ==> "+aluReadDeleted.toString());
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());
    }





}
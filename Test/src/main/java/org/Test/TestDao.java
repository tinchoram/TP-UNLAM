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

public class TestDao {

    private static final String TEST_FILE_PATH = "alumnos_base_test.txt";
//    public static void main(String[] args) throws DaoException {
//        System.out.println("Starting Test");
//
//    }

    @Before
    public void setUp() throws IOException {
        // Eliminar el archivo de prueba si existe antes de cada prueba
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
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

        DAO dao = factory.crearDAO(configMap);
        LocalDate fecNac = LocalDate.of(1972, 3, 20);
        LocalDate fecIng = LocalDate.of(2024, 3, 1);
        List<Carrera> carreras = new ArrayList<>();
        int legajo = 1;
        int dni = 12;
        short cantMatAprb = 2;
        Alumno alu = new Alumno(legajo, cantMatAprb, 8, fecIng, carreras, dni, "Juan Carlos", "Perez",
                fecNac);
        dao.create(alu);
        Alumno aluRead = (Alumno) dao.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
    }





}
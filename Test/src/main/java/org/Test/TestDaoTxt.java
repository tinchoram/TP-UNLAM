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
import static junit.framework.TestCase.assertNull;

public class TestDaoTxt {

    DAO daoTxt;
    int legajo = 9999;
    int dni = 123456789;
    String name = "Homer";
    String lastname = "Simpson";

    char genero = 'M';

    String email = "email@email.com";
    String telefono = "12345678";
    String localidad = "La Matanza";
    String direccion = "Calle Falsa 123";
    short cantMatAprobadas = 2;
    LocalDate fecNac = LocalDate.of(2000, 3, 20);
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

        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alu);
        Alumno aluRead = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());
    }
    @Test
    public void testCreateTwoAlumnosTxt() throws DaoException, PersonaException, DaoFactoryException {

        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alu);
        Alumno aluRead = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> "+aluRead.toString());


        Alumno alu2 = new Alumno(legajo, name, lastname, genero, 11222333, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alu2);
        Alumno aluRead2 = (Alumno) daoTxt.read(11222333);
        System.out.println("Alumno leído ==> "+aluRead2.toString());

        assertEquals(alu.getDni(), aluRead.getDni());
    }

    @Test
    public void testEditAlumnoTxt() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
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
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
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
        Alumno alumno1 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alumno1);
        legajo++;
        dni++;
        Alumno alumno2 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alumno2);
        legajo++;
        dni++;
        Alumno alumno3 = new Alumno(legajo, name, lastname, genero, 11222333, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alumno3);
        legajo++;
        dni++;
        Alumno alumno4 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email,  telefono,  direccion,  localidad, cantMatAprobadas);
        daoTxt.create(alumno4);

        Alumno aluRead = (Alumno) daoTxt.read(11222333);
        System.out.println("Alumno leído ==> "+aluRead.toString());
        daoTxt.delete(11222333);


        List<Alumno> alumnoList = new ArrayList<Alumno>(daoTxt.findAll(true));
        System.out.println("Alumnos leídos ==> "+alumnoList.toString());
        assertEquals(alumnoList.size(), 3);
    }

    @Test(expected = DaoException.class)
    public void testCreateDuplicateAlumno() throws DaoException, PersonaException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoTxt.create(alu);

        // Intentar crear el mismo alumno nuevamente
        daoTxt.create(alu);
    }

    @Test(expected = DaoException.class)
    public void testReadNonExistentAlumno() throws DaoException {
        Alumno aluRead = (Alumno) daoTxt.read(99999999); // Usar un DNI que no exista
    }

    @Test(expected = DaoException.class)
    public void testUpdateNonExistentAlumno() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoTxt.update(alu); // Intentar actualizar un alumno que no existe
    }

    @Test(expected = DaoException.class)
    public void testDeleteNonExistentAlumno() throws DaoException, SQLException {
        daoTxt.delete(99999999); // Usar un DNI que no exista
    }

    @Test
    public void testMultipleOperationsConsistency() throws DaoException, PersonaException, SQLException {
        Alumno alu1 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoTxt.create(alu1);

        legajo++;
        dni++;
        Alumno alu2 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoTxt.create(alu2);

        // Leer ambos alumnos
        Alumno aluRead1 = (Alumno) daoTxt.read(alu1.getDni());
        Alumno aluRead2 = (Alumno) daoTxt.read(alu2.getDni());
        assertEquals(alu1.getDni(), aluRead1.getDni());
        assertEquals(alu2.getDni(), aluRead2.getDni());

        // Actualizar uno de los alumnos
        aluRead1.setNombre("HomerUpdated");
        daoTxt.update(aluRead1);

        // Leer el alumno actualizado
        Alumno aluRead1Updated = (Alumno) daoTxt.read(alu1.getDni());
        assertEquals("HomerUpdated", aluRead1Updated.getNombre());

        // Eliminar el otro alumno
        daoTxt.delete(alu2.getDni());

        // Verificar que el alumno eliminado no existe
        Alumno aluReadDeleted = (Alumno) daoTxt.read(alu2.getDni());
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());
    }

    @Test
    public void testUpdateAlumnoTxt() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoTxt.create(alu);

        String nameEdited = "HomerEdited";
        Alumno aluRead = (Alumno) daoTxt.read(dni);
        aluRead.setNombre(nameEdited);
        daoTxt.update(aluRead);
        Alumno aluReadEdited = (Alumno) daoTxt.read(dni);
        System.out.println("Alumno leído ==> " + aluReadEdited.toString());
        assertEquals(aluReadEdited.getNombre(), nameEdited);

        // Verificar que solo la línea actualizada se ha cambiado
        List<Alumno> alumnoList = new ArrayList<>(daoTxt.findAll(true));
        assertEquals(1, alumnoList.size());
        assertEquals(nameEdited, alumnoList.get(0).getNombre());
    }
}
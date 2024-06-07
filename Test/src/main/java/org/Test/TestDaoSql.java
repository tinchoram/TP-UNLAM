package org.Test;

import dao.DAO;
import dao.DAOFactory;
import dao.DaoException;
import dao.DaoFactoryException;
import gui.persona.Alumno;
import gui.persona.PersonaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dao.DAOFactory.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class TestDaoSql {

    DAO daoSql;
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

    @Before
    public void setUp() throws IOException, DaoFactoryException, SQLException {
        DAOFactory factory = DAOFactory.getInstance();
        Map<String, String> configMap = new HashMap<>();
        configMap.put(TIPO_DAO, TIPO_DAO_SQL);
        configMap.put(URL_DB, "jdbc:postgresql://localhost:5432/unlam");
        configMap.put(USER_DB, "postgres");
        configMap.put(PWD_DB, "postgres");

        daoSql = factory.crearDAO(configMap);

        // Limpiar tabla alumnos
        daoSql.execute("DELETE FROM alumnos");
    }

    @After
    public void tearDown() throws IOException, SQLException {
        // Limpiar la tabla después de cada prueba si es necesario
        daoSql.execute("DELETE FROM alumnos");
    }

    @Test
    public void testCreateDaoSql() throws DaoException {
        System.out.println("Starting Dao");
    }

    @Test
    public void testCreateAlumnoSql() throws DaoException, PersonaException, DaoFactoryException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu);
        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> " + aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());
    }

    @Test
    public void testCreateTwoAlumnosSql() throws DaoException, PersonaException, DaoFactoryException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu);
        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> " + aluRead.toString());

        Alumno alu2 = new Alumno(legajo + 1, name, lastname, genero, 11222333, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu2);
        Alumno aluRead2 = (Alumno) daoSql.read(11222333);
        System.out.println("Alumno leído ==> " + aluRead2.toString());

        assertEquals(alu2.getDni(), aluRead2.getDni());
    }

    @Test
    public void testEditAlumnoSql() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu);

        String nameEdited = "HomerEdited";
        Alumno aluRead = (Alumno) daoSql.read(dni);
        aluRead.setNombre(nameEdited);
        daoSql.update(aluRead);
        Alumno aluReadEdited = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> " + aluReadEdited.toString());
        assertEquals(aluReadEdited.getNombre(), nameEdited);
    }

    @Test
    public void testDeleteAlumnoSql() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu);

        Alumno aluRead = (Alumno) daoSql.read(dni);
        System.out.println("Alumno leído ==> " + aluRead.toString());
        assertEquals(alu.getDni(), aluRead.getDni());

        daoSql.delete(dni);
        Alumno aluReadDeleted = (Alumno) daoSql.read(dni);
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());;  // Dado que se ha eliminado, debería ser null
    }

    @Test
    public void testReadAllAlumnoSql() throws DaoException, PersonaException, SQLException {
        Alumno alumno1 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alumno1);
        legajo++;
        dni++;
        Alumno alumno2 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alumno2);
        legajo++;
        dni++;
        Alumno alumno3 = new Alumno(legajo, name, lastname, genero, 11222333, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alumno3);
        legajo++;
        dni++;
        Alumno alumno4 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alumno4);

        Alumno aluRead = (Alumno) daoSql.read(11222333);
        System.out.println("Alumno leído ==> " + aluRead.toString());
        daoSql.delete(11222333);

        List<Alumno> alumnoList = new ArrayList<>(daoSql.findAll(true));
        System.out.println("Alumnos leídos ==> " + alumnoList.toString());
        assertEquals(3, alumnoList.size());
    }

    @Test(expected = DaoException.class)
    public void testCreateDuplicateAlumno() throws DaoException, PersonaException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu);

        // Intentar crear el mismo alumno nuevamente
        daoSql.create(alu);
    }

    @Test(expected = DaoException.class)
    public void testReadNonExistentAlumno() throws DaoException {
        daoSql.read(99999999); // Usar un DNI que no exista
    }

    @Test(expected = DaoException.class)
    public void testUpdateNonExistentAlumno() throws DaoException, PersonaException, SQLException {
        Alumno alu = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.update(alu); // Intentar actualizar un alumno que no existe
    }

    @Test(expected = DaoException.class)
    public void testDeleteNonExistentAlumno() throws DaoException, SQLException {
        daoSql.delete(99999999); // Usar un DNI que no exista
    }

    @Test
    public void testMultipleOperationsConsistency() throws DaoException, PersonaException, SQLException {
        Alumno alu1 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu1);

        legajo++;
        dni++;
        Alumno alu2 = new Alumno(legajo, name, lastname, genero, dni, fecIng, fecNac, email, telefono, direccion, localidad, cantMatAprobadas);
        daoSql.create(alu2);

        // Leer ambos alumnos
        Alumno aluRead1 = (Alumno) daoSql.read(alu1.getDni());
        Alumno aluRead2 = (Alumno) daoSql.read(alu2.getDni());
        assertEquals(alu1.getDni(), aluRead1.getDni());
        assertEquals(alu2.getDni(), aluRead2.getDni());

        // Actualizar uno de los alumnos
        aluRead1.setNombre("HomerUpdated");
        daoSql.update(aluRead1);

        // Leer el alumno actualizado
        Alumno aluRead1Updated = (Alumno) daoSql.read(alu1.getDni());
        assertEquals("HomerUpdated", aluRead1Updated.getNombre());

        // Eliminar el otro alumno
        daoSql.delete(alu2.getDni());

        // Verificar que el alumno eliminado no existe
        Alumno aluReadDeleted = (Alumno) daoSql.read(alu2.getDni());
        assertEquals("B".charAt(0), aluReadDeleted.getEstado());
    }
}

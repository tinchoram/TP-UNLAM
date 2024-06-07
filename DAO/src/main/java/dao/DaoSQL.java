package dao;

import gui.persona.Alumno;
import gui.persona.PersonaException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlumnoUtils;

public class DaoSQL extends DAO<Alumno, Integer>{

    private final Connection connection;

    private final PreparedStatement insertPS;
    private final PreparedStatement readPS;
    private final PreparedStatement updatePS;
    private final PreparedStatement deletePS;
    private final PreparedStatement readAllPS;

    DaoSQL(String url, String user, String password) throws DaoException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado OK a la BBDD");

            String insertSql = "INSERT INTO alumnos (DNI, NOMBRE, APELLIDO, GENERO, FEC_ING, FEC_NAC, EMAIL, TELEFONO, DIRECCION, LOCALIDAD, CANT_MAT_APROBADAS, ESTADO) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            insertPS = connection.prepareStatement(insertSql);

            String readSql = "SELECT * FROM alumnos WHERE DNI = ?;";
            readPS = connection.prepareStatement(readSql);

            String updateSql = "UPDATE alumnos SET NOMBRE = ?, APELLIDO = ?, GENERO = ?, FEC_ING = ?, FEC_NAC = ?, EMAIL = ?, TELEFONO = ?, DIRECCION = ?, LOCALIDAD = ?, CANT_MAT_APROBADAS = ?, ESTADO = ? WHERE DNI = ?;";
            updatePS = connection.prepareStatement(updateSql);

            String deleteSql = "UPDATE alumnos SET ESTADO = 'B' WHERE DNI = ?;";
            deletePS = connection.prepareStatement(deleteSql);

            String readAllSql = "SELECT * FROM alumnos;";
            readAllPS = connection.prepareStatement(readAllSql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo conectar a la BBDD");
        }
    }

    @Override
    public void create(Alumno alu) throws DaoException {
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getNombre());
            insertPS.setString(index++, alu.getApellido());
            insertPS.setString(index++, String.valueOf(alu.getGenero()));
            insertPS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaIng()));
            insertPS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaNac()));
            insertPS.setString(index++, alu.getEmail());
            insertPS.setString(index++, alu.getTelefono());
            insertPS.setString(index++, alu.getDireccion());
            insertPS.setString(index++, alu.getLocalidad());
            insertPS.setShort(index++, (short) alu.getCantMatAprobadas());
            insertPS.setString(index++, String.valueOf(alu.getEstado()));
            insertPS.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoException("Error SQL ==> No se pudo insertar el alumno");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DaoException {
        try {
            readPS.setInt(1, dni);
            ResultSet rs = readPS.executeQuery();
            if (!rs.next()) {
                throw new DaoException("El alumno con DNI " + dni + " no existe");
            }

            Alumno alumno = new Alumno();
            alumno.setLegajo(rs.getInt("LEGAJO"));
            alumno.setDni(rs.getInt("DNI"));
            alumno.setNombre(rs.getString("NOMBRE"));
            alumno.setApellido(rs.getString("APELLIDO"));
            alumno.setGenero(rs.getString("GENERO").charAt(0));
            alumno.setFechaIng(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_ING")));
            alumno.setFechaNac(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_NAC")));
            alumno.setEmail(rs.getString("EMAIL"));
            alumno.setTelefono(rs.getString("TELEFONO"));
            alumno.setDireccion(rs.getString("DIRECCION"));
            alumno.setLocalidad(rs.getString("LOCALIDAD"));
            alumno.setCantMatAprobadas(rs.getShort("CANT_MAT_APROBADAS"));
            alumno.setEstado(rs.getString("ESTADO").charAt(0));

            return alumno;
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo leer el alumno (" + ex.getLocalizedMessage() + ")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al crear el alumno (" + ex.getLocalizedMessage() + ")");
        }
    }

    @Override
    public void update(Alumno alu) throws DaoException {
        try {
            // Verificar si el alumno existe
            if (!exist(alu.getDni())) {
                throw new DaoException("El alumno con DNI " + alu.getDni() + " no existe");
            }

            // Validar fechas
            if (alu.getFechaIng().isBefore(alu.getFechaNac())) {
                throw new DaoException("La fecha de ingreso debe ser mayor a la fecha de nacimiento");
            }

            int index = 1;
            updatePS.setString(index++, alu.getNombre());
            updatePS.setString(index++, alu.getApellido());
            updatePS.setString(index++, String.valueOf(alu.getGenero()));
            updatePS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaIng()));
            updatePS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaNac()));
            updatePS.setString(index++, alu.getEmail());
            updatePS.setString(index++, alu.getTelefono());
            updatePS.setString(index++, alu.getDireccion());
            updatePS.setString(index++, alu.getLocalidad());
            updatePS.setShort(index++, (short) alu.getCantMatAprobadas());
            updatePS.setString(index++, String.valueOf(alu.getEstado()));
            updatePS.setInt(index++, alu.getDni());
            int affectedRows = updatePS.executeUpdate();

            if (affectedRows == 0) {
                throw new DaoException("El alumno con DNI " + alu.getDni() + " no se pudo actualizar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo actualizar el alumno");
        }
    }

    @Override
    public void delete(Integer dni) throws DaoException {
        if (!exist(dni)) {
            throw new DaoException("El alumno con DNI " + dni + " no existe");
        }
        try {
            deletePS.setInt(1, dni);
            int affectedRows = deletePS.executeUpdate();

            if (affectedRows == 0) {
                throw new DaoException("El alumno con DNI " + dni + " no se pudo eliminar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo eliminar el alumno");
        }
    }


    @Override
    public Alumno findById(Integer dni) throws DaoException {
        return read(dni);
    }

    @Override
    public List<Alumno> findAll(boolean soloActivos) throws DaoException, PersonaException {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            ResultSet rs = readAllPS.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setLegajo(rs.getInt("LEGAJO"));
                alumno.setDni(rs.getInt("DNI"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setGenero(rs.getString("GENERO").charAt(0));
                alumno.setFechaIng(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_ING")));
                alumno.setFechaNac(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_NAC")));
                alumno.setEmail(rs.getString("EMAIL"));
                alumno.setTelefono(rs.getString("TELEFONO"));
                alumno.setDireccion(rs.getString("DIRECCION"));
                alumno.setLocalidad(rs.getString("LOCALIDAD"));
                alumno.setCantMatAprobadas(rs.getShort("CANT_MAT_APROBADAS"));
                alumno.setEstado(rs.getString("ESTADO").charAt(0));

                // Verificar si se deben agregar solo los alumnos activos
                if (!soloActivos || alumno.getEstado() == 'A') {
                    alumnos.add(alumno);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo obtener la lista de alumnos");
        }
        return alumnos;
    }

    @Override
    public void closeConnection() throws DaoException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo cerrar la conexión a la BBDD");
        }
    }

    @Override
    public boolean exist(Integer dni) throws DaoException {
        try {
            readPS.setInt(1, dni);
            ResultSet rs = readPS.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo verificar la existencia del alumno");
        }
    }

    public void execute(String query) throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
        }
    }
}

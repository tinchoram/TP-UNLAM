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

    private final PreparedStatement readAllPS;
    
    DaoSQL(String url, String user, String password) throws DaoException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado OK a la BBDD");

            String insertSql = "INSERT INTO alumnos\n" +
                    "(ID, DNI, NOMBRE, APELLIDO, FEC_NAC, ESTADO)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?);";
            insertPS = connection.prepareStatement(insertSql);

            String readSql = "SELECT ID, DNI, NOMBRE, APELLIDO, FEC_NAC,ESTADO FROM alumnos WHERE DNI = ?;";
            readPS = connection.prepareStatement(readSql);

            String updateSql = "UPDATE alumnos SET NOMBRE =?, APELLIDO =?, FEC_NAC =?, ESTADO =? WHERE DNI =?;";
            updatePS = connection.prepareStatement(updateSql);

            String readAllSql = "SELECT ID, DNI, NOMBRE, APELLIDO, FEC_NAC,ESTADO FROM alumnos;";
            readAllPS = connection.prepareStatement(readAllSql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo conectar a la BBDD");
        }
    }
    
    @Override
    public void create(Alumno alu) throws DaoException{
        try {
            int index = 1;
            insertPS.setInt(index++, alu.getLegajo());
            insertPS.setInt(index++, alu.getDni());
            insertPS.setString(index++, alu.getNombre());
            insertPS.setString(index++, alu.getApellido());
            insertPS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaNac()));
            insertPS.setString(index++, String.valueOf(alu.getEstado()));

            insertPS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo insertar el alumno");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DaoException {
        try {
            readPS.setInt(1, dni);
            ResultSet rs = readPS.executeQuery();
            if (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setLegajo(rs.getInt("ID"));
                alumno.setDni(rs.getInt("DNI"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setFechaNac(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_NAC")));
                alumno.setEstado(rs.getString("ESTADO").charAt(0));
                
                return alumno;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo leer el alumno ("+ex.getLocalizedMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al crear el alumno ("+ex.getLocalizedMessage()+")");
        }
        return null;
    }

    @Override
    public void update(Alumno alu) throws DaoException, SQLException {
        try {
            int index = 1;
            updatePS.setString(index++, alu.getNombre());
            updatePS.setString(index++, alu.getApellido());
            updatePS.setDate(index++, AlumnoUtils.localDate2SqlDate(alu.getFechaNac()));
            updatePS.setString(index++, String.valueOf(alu.getEstado()));
            updatePS.setInt(index++, alu.getDni());
            updatePS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error SQL ==> No se pudo actualizar el alumno");
        }



    }

    @Override
    public void delete(Integer dni) throws DaoException, SQLException {
        Alumno actual = read(dni);
        actual.setEstado('B');
        update(actual);

    }

    @Override
    public Alumno findById(Integer dni) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> findAll(boolean solaActivos) throws DaoException, SQLException, PersonaException {

        List<Alumno> alumnos = new ArrayList<Alumno>();
        ResultSet rs = readAllPS.executeQuery();
        while (rs.next()) {
            Alumno alumno = new Alumno();
            alumno.setLegajo(rs.getInt("ID"));
            alumno.setDni(rs.getInt("DNI"));
            alumno.setNombre(rs.getString("NOMBRE"));
            alumno.setApellido(rs.getString("APELLIDO"));
            alumno.setFechaNac(AlumnoUtils.sqlDate2LocalDate(rs.getDate("FEC_NAC")));
            alumno.setEstado(rs.getString("ESTADO").charAt(0));

            // Verificar si se deben agregar solo los alumnos activos
            if (!solaActivos || alumno.getEstado() == 'A') {
                alumnos.add(alumno);
            }
        }
        return alumnos;
    }

    @Override
    public void closeConnection() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean exist(Integer id) throws DaoException {
        // TODO count(*)
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void execute (String query) throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        stmt.execute(query);
    }
    
}

package dao;

import gui.persona.Alumno;
import gui.persona.PersonaException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.AlumnoUtils;
public class DaoTXT extends DAO<Alumno, Integer>{

    private RandomAccessFile raf;
    
    public DaoTXT(String fullpath) throws DaoException {
        try {
            raf = new RandomAccessFile(fullpath, "rws");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> Archivo no encontrado");
        }
        System.out.println("Se conectó OK al TXT ==> "+fullpath);
    }
    
    @Override
    public void create(Alumno alumno) throws DaoException {
        try {
            if (exist(alumno.getDni())) {
                throw new DaoException("Alumno duplicado ==> "+ alumno.getDni());
            }
            raf.seek(raf.length()); // Se posiciona al final del archivo
            raf.writeBytes(alumno.toString()+System.lineSeparator());
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo crear el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public Alumno read(Integer dni) throws DaoException {
        try {
            raf.seek(0);
            String lineaAlu;

            while ((lineaAlu = raf.readLine())!=null) {

                Alumno alumno = AlumnoUtils.str2Alu(lineaAlu);
                if (alumno.getDni() == dni) {
                    return alumno;
                }
            }
            throw new DaoException("Alumno no encontrado ==> "+dni);
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al construir el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public void update(Alumno alu) throws DaoException {
        try {
            // Leer todas las líneas del archivo en memoria
            List<String> lines = new ArrayList<>();
            raf.seek(0);
            String line;
            while ((line = raf.readLine()) != null) {
                lines.add(line);
            }

            // Buscar y actualizar la línea correspondiente
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                Alumno alumno = AlumnoUtils.str2Alu(lines.get(i));
                if (alumno.getDni() == alu.getDni()) {
                    lines.set(i, alu.toString());
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new DaoException("Alumno no encontrado ==> " + alu.getDni());
            }

            // Reescribir el archivo completo con las modificaciones
            raf.setLength(0); // Limpiar el archivo
            for (String updatedLine : lines) {
                raf.writeBytes(updatedLine + System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo" + " (" + ex.getLocalizedMessage() + ")");
        } catch (PersonaException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer dni) throws DaoException {
        try {
            Alumno alu = read(dni);
            alu.setEstado('B');
            update(alu);
        } catch (DaoException e) {
            throw new DaoException("Alumno no encontrado ==> "+dni);
        }

    }

    @Override
    public Alumno findById(Integer dni) throws DaoException {
        return read(dni);
    }

    @Override
    public List<Alumno> findAll(boolean solaActivos) throws DaoException {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            raf.seek(0);
            String lineaAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                Alumno alumno = AlumnoUtils.str2Alu(lineaAlu);
                if (!solaActivos || alumno.getEstado() == 'A') {
                    alumnos.add(alumno);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        } catch (PersonaException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error al construir el alumno"+ "("+ex.getLocalizedMessage()+")");
        }
        
        return alumnos;
    }

    @Override
    public void closeConnection() throws DaoException {
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo cerrar el archivo"+ "("+ex.getLocalizedMessage()+")");
        }
    }

    @Override
    public boolean exist(Integer dni) throws DaoException {
        try {
            raf.seek(0);
            String lineaAlu;
            Integer dniAlu;
            while ((lineaAlu = raf.readLine())!=null) {
                dniAlu = AlumnoUtils.str2Alu(lineaAlu).getDni();
                if (dniAlu.equals(dni)) {
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DaoTXT.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("Error E/S ==> No se pudo leer el archivo"+ "("+ex.getLocalizedMessage()+")");
        } catch (PersonaException e) {
            throw new RuntimeException(e);
        }
    }
}

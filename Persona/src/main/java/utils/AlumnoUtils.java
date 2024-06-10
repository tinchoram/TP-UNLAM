package utils;

import gui.persona.Alumno;
import gui.persona.Persona;
import gui.persona.PersonaException;
import java.sql.Date;
import java.time.LocalDate;


public final class AlumnoUtils {

    public static Alumno str2Alu(String aluStr) throws PersonaException {
        Alumno alu = new Alumno();

        if (aluStr.endsWith(String.valueOf(Persona.END_OF_FILE))) {
            aluStr = aluStr.substring(0, aluStr.length() - 1);
        }

        String[] lineasStr = aluStr.split(String.valueOf(Persona.DELIMITER));

        alu.setLegajo(Integer.valueOf(lineasStr[0]));
        alu.setCantMatAprob(Integer.valueOf(lineasStr[1]));
        alu.setPromedio(Double.valueOf(lineasStr[2]));
        alu.setEstado(lineasStr[3].charAt(0));
        alu.setDni(Integer.valueOf(lineasStr[4]));
        alu.setNombre(lineasStr[5]);
        alu.setApellido(lineasStr[6]);
        alu.setGenero(lineasStr[7].charAt(0));
        String fechaNac = lineasStr[8];
        int year = Integer.valueOf(fechaNac.substring(0, 4));
        int month = Integer.valueOf(fechaNac.substring(4, 6));
        int dayOfMonth = Integer.valueOf(fechaNac.substring(6, 8));
        alu.setFechaNac(LocalDate.of(year, month, dayOfMonth));
        alu.setEmail(lineasStr[9]);
        alu.setTelefono(lineasStr[10]);
        // Manejar posibles valores nulos o vacíos
        alu.setDireccion(lineasStr.length > 11 ? lineasStr[11] : "");
        alu.setLocalidad(lineasStr.length > 12 ? lineasStr[12] : "");


        
        return alu;
    }

    public static Date localDate2SqlDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.valueOf(localDate);
    }

    public static LocalDate sqlDate2LocalDate(Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }
        return sqlDate.toLocalDate();
    }
}

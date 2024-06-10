package gui.alumnogui.mappers;

import gui.alumnogui.dto.AlumnoDTO;
import gui.persona.Alumno;
import gui.persona.PersonaException;

import java.time.LocalDate;

public final class AlumnoMapper {
    
    public static AlumnoDTO alumno2Dto(Alumno alu){
        
        AlumnoDTO dto = new AlumnoDTO();
        dto.setLegajo(alu.getLegajo());
        dto.setDni(alu.getDni());
        dto.setNombre(alu.getNombre());
        dto.setApellido(alu.getApellido());
        // Verificación de fecha de nacimiento nula
        LocalDate defaultFechaNac = LocalDate.of(2000, 1, 1);
        dto.setFecNac(alu.getFechaNac() != null ? alu.getFechaNac() : defaultFechaNac);
        dto.setEstado(alu.getEstado());
        dto.setCorreo(alu.getCorreo(dto.getCorreo()));
        dto.setTelefono(alu.getTelefono());
        dto.setDireccion(alu.getDireccion());
        dto.setLocalidad(alu.getLocalidad());
        dto.setGenero(alu.getGenero());
        dto.setCantidadAprobadas(alu.getCantMatAprobadas());


        
        return dto;
    }
    
    public static Alumno dto2Alumno(AlumnoDTO dto) throws PersonaException{
        
        Alumno alu = new Alumno();
        alu.setLegajo(dto.getLegajo());
        alu.setDni(dto.getDni());
        alu.setNombre(dto.getNombre());
        alu.setApellido(dto.getApellido());
        alu.setFechaNac(dto.getFecNac());
        alu.setEstado(dto.getEstado());
        alu.setCorreo(dto.getCorreo());
        alu.setTelefono(dto.getTelefono());
        alu.setDireccion(dto.getDireccion());
        alu.setLocalidad(dto.getLocalidad());
        alu.setGenero(dto.getGenero());
        alu.setCantMatAprobadas((short) dto.getCantidadAprobadas());

        
        return alu;
    }
}

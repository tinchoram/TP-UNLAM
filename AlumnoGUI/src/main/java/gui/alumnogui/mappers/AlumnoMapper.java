package gui.alumnogui.mappers;

import gui.alumnogui.dto.AlumnoDTO;
import gui.persona.Alumno;
import gui.persona.PersonaException;

public final class AlumnoMapper {
    
    public static AlumnoDTO alumno2Dto(Alumno alu){
        
        AlumnoDTO dto = new AlumnoDTO();
        dto.setLegajo(alu.getLegajo());
        dto.setDni(alu.getDni());
        dto.setNombre(alu.getNombre());
        dto.setApellido(alu.getApellido());
        dto.setFecNac(alu.getFechaNac());
        dto.setEstado(alu.getEstado());
        
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
        
        return alu;
    }
}

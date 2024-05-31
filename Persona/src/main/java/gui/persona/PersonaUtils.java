package gui.persona;

import java.time.LocalDate;


public final class PersonaUtils {
    
    public static final String getFechaNacStr(Persona persona) {
        LocalDate fechaNac = persona.getFechaNac();
        return "FechaNac en formato dd/MM/aaaa = "+fechaNac.getDayOfMonth()+"/"+fechaNac.getMonthValue()+
                "/"+fechaNac.getYear();
    }
    
}

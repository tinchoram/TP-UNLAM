package gui.persona;


public class ProfesorTitular extends Profesor {
    
    @Override
    public String printLegajo() {
        return String.format("%04d", legajo);
    }
    
}

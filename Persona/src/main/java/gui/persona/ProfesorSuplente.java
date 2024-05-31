package gui.persona;


public class ProfesorSuplente extends Profesor {

    @Override
    public String printLegajo() {
        return String.format("%08d", legajo);
    }
    
}

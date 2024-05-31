package gui.persona;

public abstract class Profesor {
    
    private String nombre;
    
    protected int legajo;

    public abstract String printLegajo();

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}

package gui.alumnogui.dto;

import java.time.LocalDate;

public class AlumnoDTO {

    private int legajo;
    private int dni;
    private String nombre;

    private String apellido;
    private LocalDate fecNac;
    private char estado;

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }


    public void setEstado(char estado) {
        this.estado = estado;
    }

    public char getEstado() {
        return estado;
    }
}

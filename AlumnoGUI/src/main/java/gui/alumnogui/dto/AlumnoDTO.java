package gui.alumnogui.dto;

import java.time.LocalDate;

public class AlumnoDTO {

    private int legajo;
    private int dni;
    private String nombre;

    private String apellido;
    private LocalDate fecNac;
    private char estado;
    private String correo;
    private String telefono;
    private String direccion;
    private String localidad;
    private char genero;
    private Integer cantidadAprobadas;

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

    public void setCorreo(String text) {
        this.correo = text;
    }

    public void setTelefono(String text) {
        this.telefono = text;
    }

    public void setDireccion(String text) {
        this.direccion = text;
    }

    public void setLocalidad(String text) {
        this.localidad = text;
    }

    public void setGenero(char c) {
        this.genero = c;
    }

    public void setCantidadAprobadas(int value) {
        this.cantidadAprobadas = value;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public char getGenero() {
        return genero;
    }

    public int getCantidadAprobadas() {
        return cantidadAprobadas;
    }
}

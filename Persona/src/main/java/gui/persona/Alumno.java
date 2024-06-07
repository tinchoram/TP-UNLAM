package gui.persona;

import java.time.LocalDate;
import java.util.List;

public class Alumno extends Persona {

    private int legajo;
    private Integer cantMatAprob;
    private double promedio;
    private LocalDate fechaIng;
    private char estado = 'A';

    private List<Carrera> carreras;

    public Alumno() {
        super();
    }

    
    public Alumno(int legajo, String name, String lastName, int dni, LocalDate fecIng, LocalDate fecNac) throws PersonaException {
        super(dni, name, lastName, fecNac);
        this.legajo = legajo;
        this.fechaIng = fecIng;
    }
    
    public Alumno(int legajo, short cantMatAprob, double promedio, LocalDate fechaIng,
            List<Carrera> carreras) {
        this.legajo = legajo;
        this.cantMatAprob = (int) cantMatAprob;
        this.promedio = promedio;
        this.fechaIng = fechaIng;
        this.carreras = carreras;
    }

    public Alumno(int legajo, short cantMatAprob, double promedio, LocalDate fechaIng,
            List<Carrera> carreras, int dni) {
        super(dni);
        this.legajo = legajo;
        this.cantMatAprob = (int) cantMatAprob;
        this.promedio = promedio;
        this.fechaIng = fechaIng;
        this.carreras = carreras;
    }

    public Alumno(int legajo, short cantMatAprob, double promedio, LocalDate fechaIng,
            List<Carrera> carreras, int dni, String nombre, String apellido, LocalDate fechaNac) throws PersonaException {
        super(dni, nombre, apellido, fechaNac);
        this.legajo = legajo;
        this.cantMatAprob = (int) cantMatAprob;
        this.promedio = promedio;
        setFechaIng(fechaIng);
        this.carreras = carreras;
    }

    public Alumno(int legajo, String name, String lastname, char genero, int dni, LocalDate fecIng, LocalDate fecNac, String email, String telefono, String direccion, String localidad, int cantMatAprobadas) {
        super(dni, name, lastname, genero, fecNac, email, telefono, direccion, localidad);
        this.legajo = legajo;
        this.fechaIng = fecIng;
        this.cantMatAprob = (Integer) cantMatAprobadas;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public Integer getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(Integer cantMatAprob) {
        this.cantMatAprob = cantMatAprob;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {

        this.promedio = promedio;
    }

    public LocalDate getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(LocalDate fechaIng) {
        if (fechaIng == null) {
            throw new IllegalArgumentException("La fecha de ingreso no puede ser nula");
        }
        if (this.fechaNac != null && fechaIng.isBefore(this.fechaNac)) {
            throw new IllegalArgumentException("La fecha de ingreso debe ser mayor a la fecha de nacimiento");
        }
        this.fechaIng = fechaIng;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return String.format("%d%c%d%c%.2f%c%c%c%s",
                this.legajo,
                Persona.DELIMITER,
                this.cantMatAprob,
                Persona.DELIMITER,
                this.promedio,
                Persona.DELIMITER,
                this.estado,
                Persona.DELIMITER,
                super.toString());
    }

    public int getCantMatAprobadas() {
        return this.cantMatAprob;
    }

    public void setCantMatAprobadas(short cantMatAprobadas) {
        this.cantMatAprob = (int) cantMatAprobadas;
    }
}

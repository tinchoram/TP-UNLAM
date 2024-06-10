package gui.persona;

import java.time.LocalDate;


public class Persona {
    public static final char DELIMITER = ',';
    public static final char END_OF_FILE = ';';

    private int dni;
    private String nombre;
    private String apellido;
    protected LocalDate fechaNac;

    private String email;
    private String telefono;
    private String direccion;
    private String localidad;

    private char genero;

    public Persona(int dni, String nombre, String apellido, char genero, LocalDate fechaNac, String email, String telefono, String direccion, String localidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.genero = genero;
    }

    // Suite de Contructores
    public Persona() {
        nombre = "";
    }
    
    public Persona(int dni) {
        this.dni = dni;
    }
    public Persona(int dni, String nombre, String apellido) throws PersonaException {
        this.dni = dni;
        setNombre(nombre);
        this.apellido = apellido;
    }
    public Persona(int dni, String nombre, String apellido, LocalDate fechaNac) throws PersonaException {
        this.dni = dni;
        setNombre(nombre);
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }
    
    // Getters and Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        if (nombre==null) {
            return nombre;
        }
        return nombre.trim();
    }

    public final void setNombre(String nombre) throws PersonaException {
        if (nombre==null) {
            throw new PersonaException("El nombre NO puede ser null");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
    /*
    public String getFechaNacStr() {
        return "FechaNac en formato dd/MM/aaaa = "+fechaNac.getDayOfMonth()+"/"+fechaNac.getMonthValue()+"/"+fechaNac.getYear();
    }
    */

    /**
     * Setea la fecha de Nacimiento de la persona
     * @param fechaNac La fecha de Nacimiento
     */
    public void setFechaNac(LocalDate fechaNac) {
        if (fechaNac == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        this.fechaNac = fechaNac;
    }

    /**
     * toString de Persona
     */
    @Override
    public String toString() {
        return String.format("%08d%c%s%c%s%c%c%c%04d%02d%02d%c%s%c%s%c%s%c%s%c",
                this.dni,
                DELIMITER,
                this.getNombre().trim(),
                DELIMITER,
                this.apellido.trim(),
                DELIMITER,
                this.genero,
                DELIMITER,
                this.fechaNac.getYear(),
                this.fechaNac.getMonthValue(),
                this.fechaNac.getDayOfMonth(),
                DELIMITER,
                this.email.trim(),
                DELIMITER,
                this.telefono.trim(),
                DELIMITER,
                this.direccion.trim(),
                DELIMITER,
                this.localidad.trim(),
                END_OF_FILE
        );
    }

    public void setEmail(String s) {
        this.email = s;
    }

    public void setTelefono(String s) {
        this.telefono = s;
    }

    public void setDireccion(String s) {
            this.direccion = s;
    }

    public void setLocalidad(String s) {
        this.localidad = s;
    }

    public void setGenero(char c) {
        this.genero = c;
    }

    public char getGenero() {
        return this.genero;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public String getCorreo(String correo) {
        return this.email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }
}

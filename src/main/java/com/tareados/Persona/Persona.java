package com.tareados.Persona;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    // Abstracción

    // Atributos requeridos en la tarea (nombre, apellido genero y edad)
    private String nombre;
    private String apellido;
    private String genero;
    private LocalDate fechaNacimiento; // edad

    // Metodos constructores
    // Vacio
    public Persona() {

    }
// Con todos los parametros de la clase persona 
    public Persona(String nombre, String apellido, String genero, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // Encasulamiento, get y set de cada clase (acceder a los atributos privados get y set )
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
// Si quiero cambiar la fecha de nacimiento, por si el usuario se equivoco. 
  public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Metodo para calcular la edad, (cuando se guarden las 5 instacias con las fechas de nacimiento calculo la edad ) 
    public int getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }


}

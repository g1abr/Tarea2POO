package com.tareados.Persona;

import java.util.ArrayList;

public class ArrayPersona {
    private ArrayList<Persona> arregloPersona = new ArrayList<>();

    public void agregarPersona(Persona persona) {
        if (arregloPersona.size() < 5) {
            arregloPersona.add(persona);
            System.out.println("Persona agregada.");
        } else {
            System.out.println("El arreglo está lleno, no se puede agregar más personas.");
        }
    }

    public void listarPersonas() {
        if (arregloPersona.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Persona p : arregloPersona) {
                System.out.println(p.getNombre() + " " + p.getApellido() + ", género: " + p.getGenero() + ", edad: "
                        + p.getEdad());
            }
        }
    }

    public double promedioEdades() {
        if (arregloPersona.isEmpty())
            return 0;

        int suma = 0;
        for (Persona p : arregloPersona) {
            suma += p.getEdad();
        }
        return (double) suma / arregloPersona.size();
    }

    public int ContarHombres() {
        int contadorM = 0;
        for (Persona persona : arregloPersona) { 
            if (persona.getGenero() == Genero.Masculino) {
                contadorM++;
            }
        }
        return contadorM; 
    }

    public int ContarMujeres() {
        int contadorF = 0;
        for (Persona persona : arregloPersona) { 
            if (persona.getGenero() == Genero.Femenino) {
                contadorF++;
            }
        }
        return contadorF; 
    }

    public int totalPersonas() {
        return arregloPersona.size();
    }
}

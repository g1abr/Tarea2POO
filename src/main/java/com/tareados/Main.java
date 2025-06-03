package com.tareados;

import java.time.LocalDate;
import java.util.Scanner;

import com.tareados.Persona.ArrayPersona;
import com.tareados.Persona.Genero;
import com.tareados.Persona.Persona;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayPersona lista = new ArrayPersona();
        int opcion;

        do {
            System.out.println("\n");

            System.out.println("\n==== MENÚ ====");
            System.out.println("1. Crear persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Promedio de edades");
            System.out.println("4. Contar por Hombres");
            System.out.println("5. Contar por Mujeres");
            System.out.println("6. Total de personas");
            System.out.println("7. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Persona p = crearPersona();
                    lista.agregarPersona(p);
                    break;
                case 2:
                    lista.listarPersonas();
                    break;
                case 3:
                    System.out.printf("📊 Promedio de edades: %.2f años\n", lista.promedioEdades());
                    break;
                case 4:
                    System.out.println("Contando Hombres: " + lista.ContarHombres());

                    break;

                case 5:
                    System.out.println("Contando Mujeres: " + lista.ContarMujeres()); // ✅ Esto sí muestra el resultado
                    break;
                case 6:
                    System.out.println("Total personas registradas: " + lista.totalPersonas());
                    break;
                case 7:
                    System.out.println("Salir del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    public static Persona crearPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Género (M/F): ");

        Genero genero = null;
        while (genero == null) {
            System.out.print("Género (M/F): ");
            String entradaGenero = sc.nextLine().trim().toUpperCase();
            if (entradaGenero.equals("M")) {
                genero = Genero.Masculino;
            } else if (entradaGenero.equals("F")) {
                genero = Genero.Femenino;
            } else {
                System.out.println("Entrada inválida. Por favor ingresa M o F.");
            }
        }

        System.out.print("Año de nacimiento: ");
        int anio = sc.nextInt();
        System.out.print("Mes: ");
        int mes = sc.nextInt();
        System.out.print("Día: ");
        int dia = sc.nextInt();
        sc.nextLine();

        LocalDate nacimiento = LocalDate.of(anio, mes, dia);
        return new Persona(nombre, apellido, genero, nacimiento);
    }
}
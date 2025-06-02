package com.tareados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tareados.Persona.Persona;


public class Main {
    // Para capturar datos en java Scanner
    private static Scanner sc = new Scanner(System.in);
    // Para guardar las instancias de las 5 personas usamos una lista para almacenar los datos
    private static List<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
// Para darle sentido al programa, decí darle un proposito.
// Es software que ayuda a la gente marketing, mostrando metricas de los clientes o interesados(los que llenan "el formulario con sus datos"). Con los metodos establecidos en la actividad podriamos cumplir estos objetivos para el equipo de trabajo pueda crear estrategias y venter más. 

        System.out.println("¡Bienvenidos al software Soluciones!");
        System.out.println("Donde hay personas, vemos posibles clientes.");
        System.out.println("Ingresa los datos de los interesados:");
        System.out.println("------------------------------------------");

        capturarPersonas();
        mostrarNombreYGenero();
        
        System.out.println("\nReportes:");
        System.out.println("Promedio de edad: " + calcularPromedioEdad());
        System.out.println("Cantidad de hombres: " + contarGenero("M"));
        System.out.println("Cantidad de mujeres: " + contarGenero("F"));
    }

    // Método para capturar 5 personas
    public static void capturarPersonas() {
        for (int i = 0; i < 5; i++) {
            System.out.println("\nPersona " + (i + 1) + ":");
            String nombre = leerTexto("Nombre");
            String apellido = leerTexto("Apellido");
            LocalDate fechaNacimiento = leerFechaNacimiento();
            String genero = leerGenero();

            personas.add(new Persona(nombre, apellido, genero, fechaNacimiento));
        }
    }

    // Método para leer (nombre, apellido)
    public static String leerTexto(String campo) {
        String infomacion;
        // 
        do {
            System.out.print(campo + ": ");
            infomacion = sc.nextLine().trim(); //lee y borra espacio
            // Usamos un condicional para evitar que se guarden campos vacios. 
            if (infomacion.isEmpty()) {
                System.out.println("El " + campo.toLowerCase() + " no puede estar vacío.");
            }
            // Si determina que esta vacio, usamos un ciclo repetitivo para asegurarnos que usuario vuelva a escribir el campo hasta que cumpla con los requisitos. 
        } while (infomacion.isEmpty());
        return capitalizar(infomacion);
    }

    // Método para leer fecha de nacimiento
    public static LocalDate leerFechaNacimiento() {
        int año, mes, dia;
        while (true) {

            // Para que el usuario ingrese su fecha de nacimiento, como en una pagina web donde se despliega un calendario, pero aquí no tenemos eso, por eso decí separar la fecha, y especificar el formato aceptado. Después, lo convertimos en un objeto de tipo LocalDate. 
            año = leerEntero("Año de nacimiento (YYYY)");
            mes = leerEntero("Mes de nacimiento (1-12)");
            dia = leerEntero("Día de nacimiento (1-31)");

            // Manejamos una excepcion para cuando se ingrese una fecha incorrecta
            try {
                return LocalDate.of(año, mes, dia);
            } catch (Exception e) {
                System.out.println("¡Fecha inválida! Ingresa una fecha válida.");
                System.out.println("--------------------------------------");
            }
        }
    }

    // Método para leer un entero (año, mes, día)
    public static int leerEntero(String campo) {
        
        int valor = -1;
        while (valor < 0) {
            System.out.print(campo + ": ");
            // Un condicional para asegurar un entero
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                if (valor < 0) {
                    System.out.println("El " + campo.toLowerCase() + " no puede ser negativo.");
                }
            } else {
                System.out.println("Entrada inválida. Ingresa un número.");
                sc.nextLine(); // Borar entrada incorrecta
            }
        }
        return valor;
    }

    // Método para leer género (M/F)
    public static String leerGenero() {
        String genero;
        do {
            System.out.print("Género (M/F): ");
            genero = sc.nextLine().trim().toUpperCase(); // Lee y formatea 
            // Validamos que el usuario haya digitado m o f
            if (!genero.equals("M") && !genero.equals("F")) {
                System.out.println("Género inválido. Debe ser M o F.");
                System.out.println("--------------------------------------");

            }
        } while (!genero.equals("M") && !genero.equals("F"));
        return genero;
    }

    // Método para formatear Texto ( "june" -> "June")
    public static String capitalizar(String texto) {
        if (texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    // Método para mostrar nombres y géneros
    public static void mostrarNombreYGenero() {
        System.out.println("\nClientes o Interesados ingresados hoy:");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " - Género: " + p.getGenero());
        }
    }

    // Método para calcular el promedio de edades
    public static int calcularPromedioEdad() {
        if (personas.isEmpty()) return 0;
        int suma = 0;
        for (Persona p : personas) {
            suma += p.getEdad();
        }
        return (int) suma / personas.size();
    }

    // Método para contar personas por género
    public static int contarGenero(String genero) {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getGenero().equalsIgnoreCase(genero)) {
                contador++;
            }
        }
        return contador;
    }
}
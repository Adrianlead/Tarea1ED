package com.company;

import java.io.IOException;
import java.util.Scanner;

public class UI {

    private Scanner in = new Scanner(System.in);

    public void startProgram() throws IOException {
        System.out.println("¡PROGRAMA DE CONVERSIONES DE INFIJOS A PREFIJOS Y POSFIJOS!");
        ejecutarMenu();
    }

    public void ejecutarMenu() throws IOException {
        int opcion = 0;
        mostrarOpciones();

        opcion = in.nextInt();

        while (opcion != 1) {
            System.out.println("Primero hay que cargar los datos. Por favor seleccione la opción 1");
            opcion = in.nextInt();
        }

        Controlador controlador = new Controlador();
        controlador.loadData();
        controlador.loadData();
        System.out.println("Archivo cargado con éxito.");

        Logica logica = new Logica();
        mostrarOpciones();

        do {
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ya los datos han sido cargados.");
                    mostrarOpciones();
                    break;
                case 2:
                    controlador.hacerOpcion2();
                    mostrarOpciones();
                    break;
                case 3:
                    controlador.hacerOpcion3();
                    mostrarOpciones();
                    break;
                case 4:
                    controlador.hacerOpcion4();
                    mostrarOpciones();
                    break;
                case 5:
                    controlador.hacerOpcion5();
                    mostrarOpciones();
                    break;
                case 6:
                    System.out.println("¡Gracias por utilizar el programa! Hecho por: Adrianlead");
                default:
                    System.out.println("Actividad inexistente. Por favor, marque una opción correcta.");
                    mostrarOpciones();
                    break;
            }
        } while (opcion != 6);
    }

    private void mostrarOpciones() {
        System.out.println("Por favor, escriba el número de la actividad que desea realizar:");
        System.out.println("1. Leer documento de texto en C:/data");
        System.out.println("2. Hacer conversiones a prefijos.");
        System.out.println("3. Hacer conversiones a posfijos.");
        System.out.println("4. Guardar un archivo de prefijos en C:/data");
        System.out.println("5. Guardar un archivo de posfijos en C:/data");
        System.out.println("6. Salir del programa.");
    }
}

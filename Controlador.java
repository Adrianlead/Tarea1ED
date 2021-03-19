package com.company;

import java.io.*;
import java.util.ArrayList;

public class Controlador {


    public void loadData() throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();
        Logica logica = new Logica();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/data/expresiones.txt"))) {
            while (br.ready()) {
                data.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = data.toArray(new String[]{});

        for (int i = 0; i < arr.length; i++) {
            String array = arr[i].replaceAll("\\s", "");
            logica.enqueue(array);
            System.out.println(array);
        }
        //logica.printStatus();
    }

    public void hacerOpcion2() throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();
        Logica logica = new Logica();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/data/expresiones.txt"))) {
            while (br.ready()) {
                data.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = data.toArray(new String[]{});

        for (int i = 0; i < arr.length; i++) {
            String array = arr[i].replaceAll("\\s", "");
            logica.enqueue(array);
        }

        InToPre intopre = new InToPre();
        System.out.println("Primero imprime el infijo y luego el prefijo");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(intopre.infixToPrefix(logica.first().toCharArray()));
            logica.dequeue();
        }
    }

    public void hacerOpcion3() {
        ArrayList<String> data = new ArrayList<>();
        Logica logica = new Logica();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/data/expresiones.txt"))) {
            while (br.ready()) {
                data.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = data.toArray(new String[]{});

        for (int i = 0; i < arr.length; i++) {
            String array = arr[i].replaceAll("\\s", "");
            logica.enqueue(array);
        }

        InToPre intopre = new InToPre();
        PreToPos pretopos = new PreToPos();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(pretopos.preToPost(intopre.infixToPrefix(logica.first().toCharArray())));
            logica.dequeue();
        }
    }

    public void hacerOpcion4() {
        ArrayList<String> data = new ArrayList<>();
        Logica logica = new Logica();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/data/expresiones.txt"))) {
            while (br.ready()) {
                data.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = data.toArray(new String[]{});

        for (int i = 0; i < arr.length; i++) {
            String array = arr[i].replaceAll("\\s", "");
            logica.enqueue(array);
        }

        InToPre intopre = new InToPre();

        try {
            FileWriter fw = new FileWriter("C:/data/pre-expresiones.txt");
            for (int i = 0; i < arr.length; i++) {
                fw.write(intopre.infixToPrefix(logica.first().toCharArray()));
                fw.write("\n");
                logica.dequeue();
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Archivo guardado con éxito.");

    }

    public void hacerOpcion5() {
        ArrayList<String> data = new ArrayList<>();
        Logica logica = new Logica();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/data/expresiones.txt"))) {
            while (br.ready()) {
                data.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = data.toArray(new String[]{});

        for (int i = 0; i < arr.length; i++) {
            String array = arr[i].replaceAll("\\s", "");
            logica.enqueue(array);
        }

        InToPre intopre = new InToPre();
        PreToPos pretopos = new PreToPos();

        try {
            FileWriter fw = new FileWriter("C:/data/pos-expresiones.txt");
            for (int i = 0; i < arr.length; i++) {
                fw.write(pretopos.preToPost(intopre.infixToPrefix(logica.first().toCharArray())));
                fw.write("\n");
                logica.dequeue();
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Archivo guardado con éxito.");
    }
}

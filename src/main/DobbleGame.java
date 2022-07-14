package main;

import java.util.ArrayList;
import java.util.Scanner;

public class DobbleGame {

    private Dobble dobble;
    private Player player;
    private String mode;
    private Integer seed;

    public DobbleGame(Dobble dobble, Player player, String mode, Integer seed) {
        this.dobble = dobble;
        this.player = player;
        this.mode = mode;
        this.seed = seed;
    }

    public static void main(String[] args) {

        ArrayList<String> elements = new ArrayList<>();

        elements.add("a");
        elements.add("b");
        elements.add("c");
        elements.add("d");
        elements.add("e");
        elements.add("f");
        elements.add("g");
        elements.add("h");
        elements.add("i");
        elements.add("j");
        elements.add("k");
        elements.add("l");
        elements.add("m");

        // Variables de control de datos.
        ArrayList<String> arreglo = new ArrayList<>();

        ArrayList<Card> baraja = new ArrayList<>();

        // Se inicializa set Dobble.
        Dobble dobble = new Dobble(baraja);
        Dobble setCartas;

        baraja = dobble.CardsSet(elements, 3, 4,3234);
        System.out.println(baraja);

        // Variables de control de menú.
        boolean bandera = true;
        Scanner entrada = new Scanner(System.in);

        while (bandera) {

            System.out.println("¡Bienvenido a Dobble!");
            System.out.println("1.- Jugar");
            System.out.println("2.- Configurar partida");
            System.out.println("3.- Registrar Jugadores");
            System.out.println("4.- Visualizar estado completo de juego");
            System.out.println("5.- Salir del juego");

            System.out.println("Introduzca el número de su opción: ");
            Integer opcion = entrada.nextInt();

                // Si se ingresa opción 1.
            if(opcion == 1) {
                System.out.println("Ingresaste: " + opcion);
                // Si se ingresa opción 2.
            } else if (opcion == 2) {
                System.out.println("Ingresaste: " + opcion);
                // Si se ingresa opción 3.
            } else if(opcion == 3) {

                // Si se ingresa opción 4.
            } else if(opcion == 4) {

                // Si se ingresa opción 5.
            } else if(opcion == 5) {
                bandera = false;
            }
        }
        System.out.println("¡Gracias por jugar Dobble!");
    }
}

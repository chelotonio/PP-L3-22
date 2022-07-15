package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Main
 * Clase desde la cual se inician las operaciones correspondientes a todas las clases existentes.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/14
 */

public class Main {

    public static void main(String[] args) {

        // Lista de elementos para generación de cardsSet
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

        // Variables de control de datos y estados de juego.
        ArrayList<String> baraja;
        ArrayList<Card> setCartas = new ArrayList<>();
        ArrayList<Player> jugadores = new ArrayList<>();

        Player player = null;

        // Se crea objeto de clase Dobble.
        Dobble dobble = new Dobble(setCartas);

        // Se crea objeto de clase DobbleGame.
        DobbleGame partida = null;

        // Instancias de datos para Dobble y DobbleGame.
        int numE = 0;
        int maxC = 0;
        int cantJ = 0;
        int turn = 1;
        String mode = new String();
        String jugador = new String();
        String elementoCorrecto;
        String elementoIngresado;

        partida = new DobbleGame(dobble, cantJ, mode, 5345, jugadores, turn);

        // Variables de tiempo para el cálculo de turnos en DobbleGame.
        double tiempoJ1 = 0;
        double tiempoJ2 = 0;

        // Variables de control de menú.
        boolean bandera = true;
        boolean banderaCP = true;
        boolean banderaPG = true;
        boolean banderaGame = true;
        Scanner entrada = new Scanner(System.in);

        // Ciclo que da inicio al menú interactivo.
        while (bandera) {

            System.out.println("¡Bienvenido a Dobble!");
            System.out.println("1.- Jugar");
            System.out.println("2.- Configurar partida");
            System.out.println("3.- Registrar Jugadores");
            System.out.println("4.- Visualizar estado completo de juego");
            System.out.println("5.- Salir del juego");

            System.out.println("Introduzca su opción: ");
            Integer opcion = entrada.nextInt();

            // __________ Inicio de menú interactivo __________ //

                // Si se ingresa opción 1.
            if(opcion == 1) {

                // Menú pre-game.
                banderaPG = true;
                while (banderaPG) {

                    System.out.println("Partida");
                    System.out.println("1.- ¡Comenzar partida!");
                    System.out.println("2.- Instrucciones de partida");
                    System.out.println("3.- Volver al menú principal");

                    System.out.println("Introduzca su opción: ");
                    opcion = entrada.nextInt();

                    if (opcion == 1) {
                        long inicioEjecucion = System.nanoTime();

                        banderaGame = true;
                        while (banderaGame) {

                            // Se inicia una partida
                            baraja = dobble.cardsSetToString(setCartas);

                            Integer n = setCartas.size() - 2;
                            Integer a = (int) Math.round(Math.random()*(n-0+1));
                            Integer b = (int) Math.round(Math.random()*(n-0+1));

                            Card ccc1 = setCartas.get(a);
                            Card ccc2 = setCartas.get(b);

                            ArrayList<String> cc1 = ccc1.getCarta();
                            ArrayList<String> cc2 = ccc2.getCarta();

                            String c1 = baraja.get(a);
                            String c2 = baraja.get(b);

                            elementoCorrecto = dobble.enComun(cc1, cc2);

                            System.out.println("¡Ingresa el elemento en común entre las dos cartas!");

                            System.out.println("Carta 1: " + c1);
                            System.out.println("Carta 2: " + c2);

                            System.out.println("Introduzca su opción: ");
                            elementoIngresado = entrada.next();

                            if (elementoIngresado.equals(elementoCorrecto)) {

                                long finEjecución = System.nanoTime();

                                if(turn % 2 == 1) {
                                    tiempoJ1 = tiempoJ1 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                                } else {
                                    tiempoJ2 = tiempoJ2 + (finEjecución - inicioEjecucion) * Math.pow(10, -9);
                                }

                                if(turn == cantJ * 2) {

                                    System.out.println("¡Partida finalizada!");

                                    System.out.println(jugadores.get(0)+ " : " +tiempoJ1);
                                    System.out.println(jugadores.get(1)+ " : " +tiempoJ2);

                                    if (tiempoJ1 < tiempoJ2) {
                                        System.out.println("El ganador es: " + jugadores.get(0));
                                    } else {
                                        System.out.println("El ganador es: " + jugadores.get(1));
                                    }
                                    System.out.println("1.- Volver al menú principal");
                                    System.out.println("Introduzca su opción: ");
                                    opcion = entrada.nextInt();

                                    banderaGame = false;
                                    banderaPG = false;
                                }
                                System.out.println("¡Correcto!");

                                System.out.println("Es el turno de " + jugadores.get(turn % 2));
                                System.out.println("Ingrese el número 1 cuando desee comenzar su turno: ");
                                opcion = entrada.nextInt();

                                turn = turn + 1;
                                System.out.println(turn);

                            } else {
                                System.out.println("El elemento ingresado no es correcto, inténtelo nuevamente.");
                            }
                        }

                    } else if(opcion == 2) {

                        System.out.println("--- INSTRUCCIONES DOBBLE GAME ---");
                        System.out.println("Modo de juego: " + mode);
                        System.out.println("Se enfrentan los " + cantJ + " jugadores registrados");
                        System.out.println("por turnos. Cada jugador debe encontrar el elemento");
                        System.out.println("en común que comparten el par de cartas seleccionado");
                        System.out.println("para su respectivo turno. El jugador que tarde la menor");
                        System.out.println("cantidad de tiempo total en hallar el elemento en común");
                        System.out.println("en sus respectivos turnos gana la partida");

                    } else if(opcion == 3) {
                        banderaPG = false;
                    }
                }
                // Si se ingresa opción 2.
            } else if (opcion == 2) {
                banderaCP = true;
                while (banderaCP) {

                    System.out.println("Configuración de partida");
                    System.out.println("1.- Crear baraja");
                    System.out.println("2.- Ingresar cantidad de jugadores");
                    System.out.println("3.- Seleccionar modo de juego");
                    System.out.println("4.- Volver al menú principal");

                    System.out.println("Introduzca su opción: ");
                    opcion = entrada.nextInt();

                    if(opcion == 1) {

                        System.out.println("Introduza el número de elementos por carta que desea: ");
                        opcion = entrada.nextInt();
                        numE = opcion;

                        System.out.println("Introduza el número de cartas a generar que desea: ");
                        opcion = entrada.nextInt();
                        maxC = opcion;

                        // Con los parámetros ingresados se procede a construir un set de cartas.
                        setCartas = dobble.CardsSet(elements, numE, maxC, 1234);

                    } else if(opcion == 2) {

                        System.out.println("Introduzca la cantidad de jugadores de la partida: ");
                        opcion = entrada.nextInt();
                        cantJ = opcion;
                        System.out.println(cantJ);

                    } else if(opcion == 3) {

                        System.out.println("Seleccionar modo de juego");
                        System.out.println("1.- Player vs Player");

                        System.out.println("Introduza la opción que desea: ");
                        opcion = entrada.nextInt();

                        if (opcion == 1) {
                            mode = "Player vs Player";
                        }

                        System.out.println("Modo de juego escogido: " + mode);

                    } else if(opcion == 4) {
                        banderaCP = false;
                    }
                }
                // Si se ingresa opción 3.
            } else if(opcion == 3) {

                // Registro de jugadores.
                System.out.println("Ingrese un nombre de usuario: ");
                jugador = entrada.next();
                partida.dobbleGameRegister(jugador, partida);
                // Si se ingresa opción 4.
            } else if(opcion == 4) {

                // Estado completo de juego.
                System.out.println("Set de carta: " + setCartas);
                System.out.println("Lista de jugadores: " + jugadores);
                System.out.println("Cantidad de jugadores en la partida: " + cantJ);
                System.out.println("Modo de juego escogido: " + mode);

                // Si se ingresa opción 5.
            } else if(opcion == 5) {
                bandera = false;
            }
        }
        System.out.println("¡Gracias por jugar Dobble!");
    }

}

package com.example.practica_ajedrez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.Scanner;
import java.util.Random;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Chess");
        stage.setScene(scene);

        mostrar_interfaz_inicial();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void mostrar_interfaz_inicial () {
        Scanner input = new Scanner(System.in);

        System.out.println("BIENVENIDO A NUESTRA APP DE AJEDREZ");
        System.out.println(" ");
        System.out.println("Para jugar, debes indicar el nombre de los dos jugadores que van a participar.");
        System.out.println(" ");
        System.out.print("Jugador 1: ");
        String usuario1 = input.nextLine();
        System.out.println(" ");
        System.out.print("Jugador 2: ");
        String usuario2 = input.nextLine();

        Random rand = new Random();
        int randomNum = rand.nextInt(2);

        String jugadorBlancas;
        String jugadorNegras;

        if (randomNum == 0) {
            jugadorBlancas = usuario1;
            jugadorNegras = usuario2;
        } else {
            jugadorBlancas = usuario2;
            jugadorNegras = usuario1;
        }
        System.out.println(" ");
        System.out.println("¡YA ESTÁ DECIDIDO! " + jugadorBlancas + " jugará con las blancas y " + jugadorNegras + " jugará con las negras.");
        System.out.println(" ");
        System.out.print("¿Necesitas saber las reglas del ajedrez? (si-no) --> ");
        String respuesta = input.nextLine();
        System.out.println(" ");

        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("¡Perfecto. Que empiece el juego!");
        } else if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Empecemos con la movilidad. Para ver las diferentes normas pulsa enter.");
            System.out.println(" ");
            input.nextLine();
            System.out.println("Movilidad REY: Se puede mover hacia TODOS" +
                    " los lados una casilla MENOS en donde se encuentre en posición de jaque.");
            System.out.println(" ");
            input.nextLine();
            System.out.println("Movilidad DAMA: Se puede mover hacia TODOS los lados las casillas que quiera");
            System.out.println(" ");
            input.nextLine();
            System.out.print("Movilidad TORRE: Se puede mover las casillas que quiera pero solo en LÍNEA RECTA.");
            System.out.println(" ");
            input.nextLine();
            System.out.println("Movilidad ALFIL: Se puede mover las casillas que quiera pero SOLO en DIAGONAL.");
            System.out.println(" ");
            input.nextLine();
            System.out.println("Movilidad CABALLO: Se mueve en forma de L. Se mueve dos casillas hacia un lado" +
                    " y luego una más hacia el lado (ángulo de 90º con el primer movimiento).");
            System.out.println(" ");
            input.nextLine();
            System.out.println("Movilidad PEÓN: SOLO avanza hacia ADELANTE, captura en DIAGONAL y se puede " +
                    "mover dos casillas en su primer movimiento.");
            System.out.println(" ");
            input.nextLine();
            System.out.print("¿Quieres saber el resto de normas? --> ");
            String respuesta2 = input.nextLine();
            if (respuesta2.equalsIgnoreCase("si")) {
                System.out.println("OBJETIVO: Capturar al rey del oponente o lograr un jaque mate.");
                System.out.println(" ");
                input.nextLine();
                System.out.println("JAQUE: Situación en la que el rey está amenazado.");
                System.out.println(" ");
                input.nextLine();
                System.out.println("JAQUE MATE: Cuando el rey está en jaque y no puede escapar.");
                System.out.println(" ");
                input.nextLine();
                System.out.print("ENROQUE: Movimiento especial que implica al rey y una torre.");
                System.out.println(" ");
                input.nextLine();
                System.out.println("PROMOCIÓN: Cuando un peón llega a la última fila del tablero, se puede convertir en una pieza más poderosa.");
            } else {
                System.out.println("¡Empecemos el juego!");
                System.out.println("Se te debe haber abierto una nueva ventana");
            }
        }
    }
}
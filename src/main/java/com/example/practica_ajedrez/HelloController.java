package com.example.practica_ajedrez;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class HelloController {
    // BOOLEANO PARA VERIFICAR SI YA HEMOS SELECCIONADO UNA PIEZA
    private boolean all_ready_selected = false;

    // Array con posibles jugadas
    private StackPane [] first_posiblesJugadas_array = null;
    private StackPane [] posiblesJugadas_array = null;

    // Variable donde guardaremos la celda clicada si es correcta
    private StackPane first_correct_cell = null;
    private String string_first_correct_cell = null;
    private int numTiradas;
    private String [] pieza_first_click_array = null;

    @FXML
    private Label turn_label;
    @FXML
    private ImageView turn_image;
    @FXML
    private Label Info_label;

    @FXML
    private ImageView cell00; // ImageView De la fila 0 columna 0.
    @FXML
    private ImageView cell01;
    @FXML
    private ImageView cell02;
    @FXML
    private ImageView cell03;
    @FXML
    private ImageView cell04;
    @FXML
    private ImageView cell05;
    @FXML
    private ImageView cell06;
    @FXML
    private ImageView cell07;

    // Fila 1
    @FXML
    private ImageView cell10;
    @FXML
    private ImageView cell11;
    @FXML
    private ImageView cell12;
    @FXML
    private ImageView cell13;
    @FXML
    private ImageView cell14;
    @FXML
    private ImageView cell15;
    @FXML
    private ImageView cell16;
    @FXML
    private ImageView cell17;

    // Fila 6
    @FXML
    private ImageView cell60;
    @FXML
    private ImageView cell61;
    @FXML
    private ImageView cell62;
    @FXML
    private ImageView cell63;
    @FXML
    private ImageView cell64;
    @FXML
    private ImageView cell65;
    @FXML
    private ImageView cell66;
    @FXML
    private ImageView cell67;

    // Fila 7
    @FXML
    private ImageView cell70;
    @FXML
    private ImageView cell71;
    @FXML
    private ImageView cell72;
    @FXML
    private ImageView cell73;
    @FXML
    private ImageView cell74;
    @FXML
    private ImageView cell75;
    @FXML
    private ImageView cell76;
    @FXML
    private ImageView cell77;


    // STACK PANES
    @FXML
    private StackPane sp00, sp01, sp02, sp03, sp04, sp05, sp06, sp07,
            sp10, sp11, sp12, sp13, sp14, sp15, sp16, sp17,
            sp20, sp21, sp22, sp23, sp24, sp25, sp26, sp27,
            sp30, sp31, sp32, sp33, sp34, sp35, sp36, sp37,
            sp40, sp41, sp42, sp43, sp44, sp45, sp46, sp47,
            sp50, sp51, sp52, sp53, sp54, sp55, sp56, sp57,
            sp60, sp61, sp62, sp63, sp64, sp65, sp66, sp67,
            sp70, sp71, sp72, sp73, sp74, sp75, sp76, sp77;

    private StackPane [][] tablero = new StackPane[8][8];


    // Colores
    private String SselectN_color = "#508F21";
    private String SselectB_color = "#AEF97B";
    private String SposibleN_color = "#194085";
    private String SposibleB_color = "#A4B8FA";
    private String sN_color = "#130B05";
    private String sB_color = "#d7af8d";
    private String sAttackB_color = "#F65C50";
    private String sAttackN_color = "#C00000";

    private String sAttackB_color2 = "#FBD14B";
    private String sAttackN_color2 = "#C79905";

    // Convertir el color hexadecimal a un objeto Color
    Color selectN_color = Color.web(SselectN_color);
    Color selectB_color = Color.web(SselectB_color);
    Color B_color = Color.web(sB_color);
    Color N_color = Color.web(sN_color);
    Color posibleN_color = Color.web(SposibleN_color);
    Color posibleB_color = Color.web(SposibleB_color);
    Color AttackB_color = Color.web(sAttackB_color);
    Color AttackN_color = Color.web(sAttackN_color);

    Color AttackB_color2 = Color.web(sAttackB_color2);
    Color AttackN_color2 = Color.web(sAttackN_color2);

    private Image [][] image_array = new Image [2][8];

    @FXML
    Button escoger_torre_id, escoger_alfil_id, escoger_caballo_id, escoger_reina_id;

    @FXML
    ImageView escoger_caballo_ImageView, escoger_torre_ImageView, escoger_alfil_ImageView, escoger_reina_ImageView;

    public void initialize() {

        // Cargamos las imágenes de las piezas
        Image peonB = new Image(getClass().getResourceAsStream("/imagenes/peonB.png"));
        Image peonN = new Image(getClass().getResourceAsStream("/imagenes/peonN.png"));
        Image caballoB = new Image(getClass().getResourceAsStream("/imagenes/caballoB.png"));
        Image caballoN = new Image(getClass().getResourceAsStream("/imagenes/caballoN.png"));
        Image alfilB = new Image(getClass().getResourceAsStream("/imagenes/alfilB.png"));
        Image alfilN = new Image(getClass().getResourceAsStream("/imagenes/alfilN.png"));
        Image torreB = new Image(getClass().getResourceAsStream("/imagenes/torreB.png"));
        Image torreN = new Image(getClass().getResourceAsStream("/imagenes/torreN.png"));
        Image reinaB = new Image(getClass().getResourceAsStream("/imagenes/reinaB.png"));
        Image reinaN = new Image(getClass().getResourceAsStream("/imagenes/reinaN.png"));
        Image reyB = new Image(getClass().getResourceAsStream("/imagenes/reyB.png"));
        Image reyN = new Image(getClass().getResourceAsStream("/imagenes/reyN.png"));

        /*System.out.println("Peón blanco --> " + peonB);
        System.out.println("Alfil blanco --> " + alfilB);
        System.out.println("Caballo blanco --> " + caballoB);
        System.out.println("Torre blanco --> " + torreB);
        System.out.println("Reina blanco --> " + reinaB);
        System.out.println("Rey blanco --> " + reyB);

        System.out.println("Peón negro --> " + peonN);
        System.out.println("Alfil negro --> " + alfilN);
        System.out.println("Caballo negro --> " + caballoN);
        System.out.println("Torre negro --> " + torreB);
        System.out.println("Reina negro --> " + reinaN);
        System.out.println("Rey negro --> " + reyN);*/

        image_array[0][1] = peonB;
        image_array[1][1] = peonN;
        image_array[0][2] = alfilB;
        image_array[1][2] = alfilN;
        image_array[0][3] = caballoB;
        image_array[1][3] = caballoN;
        image_array[0][4] = torreB;
        image_array[1][4] = torreN;
        image_array[0][5] = reinaB;
        image_array[1][5] = reinaN;
        image_array[0][6] = reyB;
        image_array[1][6] = reyN;

        // Añadimos Stack panes al array tablero
        tablero[0][0] = sp00; // Fila 1
        tablero[0][1] = sp01;
        tablero[0][2] = sp02;
        tablero[0][3] = sp03;
        tablero[0][4] = sp04;
        tablero[0][5] = sp05;
        tablero[0][6] = sp06;
        tablero[0][7] = sp07;

        tablero[1][0] = sp10; // Fila 2
        tablero[1][1] = sp11;
        tablero[1][2] = sp12;
        tablero[1][3] = sp13;
        tablero[1][4] = sp14;
        tablero[1][5] = sp15;
        tablero[1][6] = sp16;
        tablero[1][7] = sp17;

        tablero[2][0] = sp20; // Fila 3
        tablero[2][1] = sp21;
        tablero[2][2] = sp22;
        tablero[2][3] = sp23;
        tablero[2][4] = sp24;
        tablero[2][5] = sp25;
        tablero[2][6] = sp26;
        tablero[2][7] = sp27;

        tablero[3][0] = sp30; // Fila 4
        tablero[3][1] = sp31;
        tablero[3][2] = sp32;
        tablero[3][3] = sp33;
        tablero[3][4] = sp34;
        tablero[3][5] = sp35;
        tablero[3][6] = sp36;
        tablero[3][7] = sp37;

        tablero[4][0] = sp40; // Fila 5
        tablero[4][1] = sp41;
        tablero[4][2] = sp42;
        tablero[4][3] = sp43;
        tablero[4][4] = sp44;
        tablero[4][5] = sp45;
        tablero[4][6] = sp46;
        tablero[4][7] = sp47;

        tablero[5][0] = sp50; // Fila 6
        tablero[5][1] = sp51;
        tablero[5][2] = sp52;
        tablero[5][3] = sp53;
        tablero[5][4] = sp54;
        tablero[5][5] = sp55;
        tablero[5][6] = sp56;
        tablero[5][7] = sp57;

        tablero[6][0] = sp60; // Fila 7
        tablero[6][1] = sp61;
        tablero[6][2] = sp62;
        tablero[6][3] = sp63;
        tablero[6][4] = sp64;
        tablero[6][5] = sp65;
        tablero[6][6] = sp66;
        tablero[6][7] = sp67;

        tablero[7][0] = sp70; // Fila 8
        tablero[7][1] = sp71;
        tablero[7][2] = sp72;
        tablero[7][3] = sp73;
        tablero[7][4] = sp74;
        tablero[7][5] = sp75;
        tablero[7][6] = sp76;
        tablero[7][7] = sp77;

        numTiradas = 0;
        turn_image.setImage(peonB);
        turn_label.setText("BLANCAS JUEGAN");

        // Ponemos las imagenes en las celdas correspondientes
        cell00.setImage(torreN);
        cell07.setImage(torreN);
        cell01.setImage(caballoN);
        cell06.setImage(caballoN);
        cell02.setImage(alfilN);
        cell05.setImage(alfilN);
        cell03.setImage(reinaN);
        cell04.setImage(reyN);

        cell10.setImage(peonN);
        cell17.setImage(peonN);
        cell11.setImage(peonN);
        cell16.setImage(peonN);
        cell12.setImage(peonN);
        cell15.setImage(peonN);
        cell13.setImage(peonN);
        cell14.setImage(peonN);

        cell70.setImage(torreB);
        cell77.setImage(torreB);
        cell71.setImage(caballoB);
        cell76.setImage(caballoB);
        cell72.setImage(alfilB);
        cell75.setImage(alfilB);
        cell73.setImage(reinaB);
        cell74.setImage(reyB);

        cell60.setImage(peonB);
        cell67.setImage(peonB);
        cell61.setImage(peonB);
        cell66.setImage(peonB);
        cell62.setImage(peonB);
        cell65.setImage(peonB);
        cell63.setImage(peonB);
        cell64.setImage(peonB);

        // Escondemos el botón de volver
        boton_volver.setVisible(false);

        // Cargamos las imagenes para los botones (escoger x)
        Image reinaA = new Image(getClass().getResourceAsStream("/imagenes/reinaA.png"));
        Image caballoA = new Image(getClass().getResourceAsStream("/imagenes/caballoA.png"));
        Image torreA = new Image(getClass().getResourceAsStream("/imagenes/torreA.png"));
        Image alfilA = new Image(getClass().getResourceAsStream("/imagenes/alfilA.png"));

        // Ponemos cada una en el botón correspondiente
        escoger_caballo_ImageView.setImage(caballoA);
        escoger_alfil_ImageView.setImage(alfilA);
        escoger_torre_ImageView.setImage(torreA);
        escoger_reina_ImageView.setImage(reinaA);

        escoger_caballo_id.setVisible(false);
        escoger_alfil_id.setVisible(false);
        escoger_torre_id.setVisible(false);
        escoger_reina_id.setVisible(false);

    }

    // Boleano que verifica si el jugador debe escoger una ficha porque su peón ha llegado al final
    private boolean tiene_que_escoger = false;
    private Image imagen_escogida = null;
    private StackPane donde_va_la_imagen = null;
    @FXML
    public void handleCellClick(MouseEvent event) {
        // Calculamos las jugadas atacadas de ambos bandos (De momento es nuestra idea para descubrir si hay jaque o jaque mate)
        calcular_ataque_blancas();
        calcular_ataque_negras();

        // Limpiamos los colores de los ataques
        limpiar_colores();

        verificar_jaque("Blanco");
        verificar_jaque("Negro");

        // Llamamos clickedCell a la celda clickeada por el ratón
        StackPane clickedCell = (StackPane) event.getSource();

        // Obtener el identificador de la celda clicada
        String cellId = clickedCell.getId();

        // Puedes realizar acciones basadas en el identificador de la celda
        System.out.println("Celda clickeada: " + cellId);

        String pieza = validate_cell(clickedCell);
        // Convertimos el string con la info de la pieza en un array para acceder a las palabras
        String [] array_String_pieza = pieza.split(" "); // Split separa el array por el parámetro que le pases en este caso espacio.
        System.out.println(pieza);

        if (numTiradas >= 1) {
            boton_volver.setVisible(true);
        } else {
            boton_volver.setVisible(false);
        }

        // Juegan las blancas
        if (numTiradas % 2 == 0) {
            turn_image.setImage(image_array[0][1]);
            turn_label.setText("BLANCAS JUEGAN");

            boolean jaqueAblancas = verificar_jaque("Blanco");

            if (!pieza.isEmpty() && array_String_pieza[1].equals("Blanco")) {
                Info_label.setText("Has seleccionado " + pieza);

                // Verificamos que no haya ya una pieza seleccionada (ya que sólo debemos escoger una)
                if (!all_ready_selected) {
                    first_correct_cell = clickedCell;
                    string_first_correct_cell = cellId;
                    pieza_first_click_array = array_String_pieza;
                    changeColorRectangle(first_correct_cell, selectN_color, selectB_color, string_first_correct_cell);
                    all_ready_selected = true;
                    Info_label.setText("Has seleccionado " + array_String_pieza[0] + " de la casilla " + string_first_correct_cell);

                    // Función para averiguar las posibles jugadas con la pieza seleccionada
                    posiblesJugadas_array = posiblesJugadas(first_correct_cell, array_String_pieza, string_first_correct_cell);
                    first_posiblesJugadas_array = posiblesJugadas_array;
                    // Imprimimos array posibles jugadas para verificar un poco que estamos haciendo
                    /*for (int i = 0; i < posiblesJugadas_array.length; i ++) {
                        System.out.println("POSIBLES JUGADAS:");
                        System.out.println(posiblesJugadas_array[i]);
                    } */
                } else {
                    pieza_first_click_array = array_String_pieza;

                    // Limpiamos los colores
                    limpiar_colores();

                    first_correct_cell = clickedCell;
                    string_first_correct_cell = cellId;

                    posiblesJugadas_array = posiblesJugadas(first_correct_cell, array_String_pieza, string_first_correct_cell);
                    first_posiblesJugadas_array = posiblesJugadas_array;

                    changeColorRectangle(first_correct_cell, selectN_color, selectB_color, string_first_correct_cell);
                    Info_label.setText("Has seleccionado " + array_String_pieza[0] + " de la casilla " + string_first_correct_cell);
                }

            } else {
                // Verificamos si nueva casilla clikada está en posibles jugadas si esta no esta vacía
                if (posiblesJugadas_array != null) { // Verificamos que no está vacío
                    for (int i = 0; i < posiblesJugadas_array.length; i ++) {
                        if (clickedCell == posiblesJugadas_array[i]) {
                            // HACEMOS COPIA DEL TABLERO (por si queremos volver atrás)
                            hacer_copia_del_tablero();

                            // VERIFICAMOS SI LA JUGADA HA SIDO UN ENROQUE
                            if (pieza_first_click_array[0].equals("Rey")) { // Si es un rey
                                String direccion_enroque = ha_sido_enroque(first_correct_cell, clickedCell);

                                if (!direccion_enroque.isEmpty()) { // Si hay enroque
                                    mover_torre_enroque(direccion_enroque, clickedCell, pieza_first_click_array[1]);
                                }
                            }

                            // HACEMOS LA JUGADA
                            // System.out.println("HACEMOS LA JUGADA DE " + first_correct_cell + " A " + clickedCell);
                            hacer_jugada(clickedCell, first_correct_cell, pieza_first_click_array);

                            if (tiene_que_escoger) {
                                // Mostramos los botones para escoger
                                escoger_caballo_id.setVisible(true);
                                escoger_alfil_id.setVisible(true);
                                escoger_torre_id.setVisible(true);
                                escoger_reina_id.setVisible(true);

                                donde_va_la_imagen = clickedCell;
                            }

                            // Pasamos a la siguiente jugada
                            numTiradas ++;

                            if (numTiradas >= 1) {
                                boton_volver.setVisible(true);
                            } else {
                                    boton_volver.setVisible(false);
                            }

                            // Limpiamos los colores del tablero
                            limpiar_colores();

                            // Limpiamos variables
                            first_posiblesJugadas_array = null;
                            posiblesJugadas_array = null;
                            string_first_correct_cell = null;
                            all_ready_selected = false;
                            pieza_first_click_array = null;
                            first_correct_cell = null;

                            turn_label.setText("NEGRAS JUEGAN");
                            turn_image.setImage(image_array[1][1]);

                            verificar_jaque("Negro");
                            verificar_jaque("Blanco");

                            break;

                        }
                    }
                } else {
                    Info_label.setText("Casilla no válida");
                    limpiar_colores();

                    verificar_jaque("Blanco");
                    verificar_jaque("Negro");

                }
            }
            // Juegan las negras
        } else {
            System.out.println("Juegan las negras");
            turn_image.setImage(image_array[1][1]);
            turn_label.setText("NEGRAS JUEGAN");

            if (!pieza.isEmpty() && array_String_pieza[1].equals("Negro")) {
                Info_label.setText("Has seleccionado " + pieza);

                // Verificamos que no haya ya una pieza seleccionada (ya que sólo debemos escoger una)
                if (!all_ready_selected) {
                    first_correct_cell = clickedCell;
                    string_first_correct_cell = cellId;
                    pieza_first_click_array = array_String_pieza;
                    changeColorRectangle(first_correct_cell, selectN_color, selectB_color, string_first_correct_cell);
                    all_ready_selected = true;
                    Info_label.setText("Has seleccionado " + array_String_pieza[0] + " de la casilla " + string_first_correct_cell);

                    // Función para averiguar las posibles jugadas con la pieza seleccionada
                    posiblesJugadas_array = posiblesJugadas(first_correct_cell, array_String_pieza, string_first_correct_cell);
                    first_posiblesJugadas_array = posiblesJugadas_array;
                    // Imprimimos array posibles jugadas para verificar un poco que estamos haciendo
                    /*for (int i = 0; i < posiblesJugadas_array.length; i ++) {
                        System.out.println("POSIBLES JUGADAS:");
                        System.out.println(posiblesJugadas_array[i]);
                    }*/
                } else {
                    /*
                    System.out.println("---------------------");
                    System.out.println("YA HAS SELECCIONADO UNA CASILLA --> " + string_first_correct_cell);
                    System.out.println("LA NUEVA CASILLA ES --> " + cellId);
                    System.out.println("---------------------"); */

                    pieza_first_click_array = array_String_pieza;

                    limpiar_colores();

                    first_correct_cell = clickedCell;
                    string_first_correct_cell = cellId;

                    posiblesJugadas_array = posiblesJugadas(first_correct_cell, array_String_pieza, string_first_correct_cell);
                    first_posiblesJugadas_array = posiblesJugadas_array;

                    changeColorRectangle(first_correct_cell, selectN_color, selectB_color, string_first_correct_cell);
                    Info_label.setText("Has seleccionado " + array_String_pieza[0] + " de la casilla " + string_first_correct_cell);

                    // Imprimimos array posibles jugadas para verificar un poco que estamos haciendo
                    /*for (int i = 0; i < posiblesJugadas_array.length; i ++) {
                        System.out.println("POSIBLES JUGADAS:");
                        System.out.println(posiblesJugadas_array[i]);
                    }*/
                }

            } else {
                // Verificamos si nueva casilla clikada está en posibles jugadas (si "posibles_jugadas_array" no es null, ya que sino da error)
                if (posiblesJugadas_array != null) {
                    for (int i = 0; i < posiblesJugadas_array.length; i ++) {
                        if (clickedCell == posiblesJugadas_array[i]) {
                            // HACEMOS COPIA DEL TABLERO (por si queremos volver atrás)
                            hacer_copia_del_tablero();

                            // VERIFICAMOS SI LA JUGADA HA SIDO UN ENROQUE
                            if (pieza_first_click_array[0].equals("Rey")) { // Si es un rey
                                String direccion_enroque = ha_sido_enroque(first_correct_cell, clickedCell);

                                if (!direccion_enroque.isEmpty()) { // Si hay enroque
                                    mover_torre_enroque(direccion_enroque, clickedCell, pieza_first_click_array[1]);
                                }
                            }

                            // HACEMOS LA JUGADA
                            // System.out.println("HACEMOS LA JUGADA DE " + first_correct_cell + " A " + clickedCell);
                            hacer_jugada(clickedCell, first_correct_cell, pieza_first_click_array);

                            if (tiene_que_escoger) {
                                // Mostramos los botones para escoger
                                escoger_caballo_id.setVisible(true);
                                escoger_alfil_id.setVisible(true);
                                escoger_torre_id.setVisible(true);
                                escoger_reina_id.setVisible(true);

                                donde_va_la_imagen = clickedCell;
                            }

                            numTiradas ++;

                            if (numTiradas >= 1) {
                                boton_volver.setVisible(true);
                            } else {
                                boton_volver.setVisible(false);
                            }

                            limpiar_colores();

                            // Limpiamos variables
                            first_posiblesJugadas_array = null;
                            posiblesJugadas_array = null;
                            string_first_correct_cell = null;
                            all_ready_selected = false;
                            pieza_first_click_array = null;
                            first_correct_cell = null;

                            turn_label.setText("BLANCAS JUEGAN");
                            turn_image.setImage(image_array[0][1]);

                            verificar_jaque("Blanco");
                            verificar_jaque("Negro");

                            break;
                        }
                    }
                } else {
                    Info_label.setText("Casilla no válida");
                    limpiar_colores();

                    verificar_jaque("Negro");
                    verificar_jaque("Blanco");
                }
            }
        }
    }
    private void mover_torre_enroque (String direccion, StackPane casilla_rey_final, String bando) {
        int fila = recibir_coordenadas_pieza(casilla_rey_final)[0];
        int columna = recibir_coordenadas_pieza(casilla_rey_final)[1];
        if (direccion.equals("Izquierda")) {
            if (bando.equals("Blanco")) {
                poner_imagen_Image_view(tablero[fila][columna+1] ,image_array[0][4]);
                vaciar_Image_view(tablero[fila][0]);
            } else {
                poner_imagen_Image_view(tablero[fila][columna+1] ,image_array[1][4]);
                vaciar_Image_view(tablero[fila][0]);
            }
        } else if (direccion.equals("Derecha")) {
            if (bando.equals("Blanco")) {
                poner_imagen_Image_view(tablero[fila][columna-1] ,image_array[0][4]);
                vaciar_Image_view(tablero[fila][7]);
            } else {
                poner_imagen_Image_view(tablero[fila][columna-1] ,image_array[1][4]);
                vaciar_Image_view(tablero[fila][7]);
            }
        }
    }
    private String ha_sido_enroque (StackPane casilla_1, StackPane casilla_2) {
        int columna_casilla_1 = recibir_coordenadas_pieza(casilla_1)[1];
        int columna_casilla_2 = recibir_coordenadas_pieza(casilla_2)[1];

        if (columna_casilla_2 == (columna_casilla_1 + 2)) {
            return "Derecha";
        } else if (columna_casilla_2 == (columna_casilla_1 - 2)) {
            return "Izquierda";
        } else {
            return "";
        }
    }
    private boolean verificar_jaque (String color_bando) {
        // Volvemos a calcular el ataque en esta función para mejor funcionamiento
        calcular_ataque_negras();
        calcular_ataque_blancas();

        for (int i = 0; i < tablero.length; i ++) {
            for (int j = 0; j < tablero[0].length; j ++) {
                String pieza = validate_cell(tablero[i][j]); // ¿Qué pieza hay en la casilla?

                if (!pieza.isEmpty()) { // Si hay alguna pieza
                    String [] pieza_array = pieza.split(" ");

                    if (pieza_array[0].equals("Rey")) { // Es un rey
                        if (pieza_array[1].equals(color_bando)) { // Verificamos si el del color del parámetro
                            if (color_bando.equals("Blanco")) {
                                // Si es blanco verificamos si la casilla del rey está dentro de la lista con las casillas atacadas por las negras
                                for (int x = 0; x < ataque_negro.size(); x ++) {
                                    if (tablero[i][j] == ataque_negro.get(x)) {
                                        // Pintamos la casilla de rey de rojo
                                        changeColorRectangle(tablero[i][j], AttackN_color, AttackB_color, tablero[i][j].getId());
                                        // System.out.println("JAQUE AL REY BLANCO");
                                        Info_label.setText("JAQUE");
                                        // Si hay jaque ya no puede enrocar
                                        rey_blanco_puede_enrocar_derecha = false;
                                        rey_blanco_puede_enrocar_izquierda = false;
                                        return true;
                                    }
                                } // Si es negro verificamos si la casilla del rey está dentro de la lista con las casillas atacadas por las blancas
                            } else if (color_bando.equals("Negro")) {
                                for (int x = 0; x < ataque_blanco.size(); x ++) {
                                    if (tablero[i][j] == ataque_blanco.get(x)) {
                                        // Pintamos la casilla de rey de rojo
                                        changeColorRectangle(tablero[i][j], AttackN_color, AttackB_color, tablero[i][j].getId());
                                        // System.out.println("JAQUE AL REY NEGRO");
                                        Info_label.setText("JAQUE");
                                        // Si hay jaque ya no puede enrocar
                                        rey_negro_puede_enrocar_derecha = false;
                                        rey_negro_puede_enrocar_izquierda = false;
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false; // Si no hemos devuelto nada después de todas las iteraciones devolvemos false
    }
    private void limpiar_colores () {
        for (int i = 0; i < tablero.length; i ++) {
            for (int j = 0; j < tablero[0].length; j ++) {
                changeColorRectangle(tablero[i][j], N_color, B_color, tablero[i][j].getId());
            }
        }
    }
    private String validate_cell (StackPane clickedCell) {
        ImageView contenedor_imagen = null;
        for (Node node : clickedCell.getChildren()) {
            if (node instanceof ImageView) {
                contenedor_imagen = (ImageView) node;

                Image imagen = contenedor_imagen.getImage();
                /*System.out.println("La imagen es: " + imagen);*/

                if (imagen == image_array[0][1]) {
                    // System.out.println("La celda contiene un peón BLANCO");
                    return "Peon Blanco";
                } else if (imagen == image_array[1][1]) {
                    // System.out.println("La celda contiene un peón NEGRO");
                    return "Peon Negro";
                } else if (imagen == image_array[0][2]) {
                    // System.out.println("La celda contiene un alfil BLANCO");
                    return "Alfil Blanco";
                } else if (imagen == image_array[1][2]) {
                    // System.out.println("La celda contiene un alfil NEGRO");
                    return "Alfil Negro";
                } else if (imagen == image_array[0][3]) {
                    // System.out.println("La celda contiene un caballo BLANCO");
                    return "Caballo Blanco";
                } else if (imagen == image_array[1][3]) {
                    // System.out.println("La celda contiene un caballo NEGRO");
                    return "Caballo Negro";
                } else if (imagen == image_array[0][4]) {
                    // System.out.println("La celda contiene un torre BLANCA");
                    return "Torre Blanco";
                } else if (imagen == image_array[1][4]) {
                    // System.out.println("La celda contiene un torre NEGRA");
                    return "Torre Negro";
                } else if (imagen == image_array[0][5]) {
                    // System.out.println("La celda contiene un reina BLANCA");
                    return "Reina Blanco";
                } else if (imagen == image_array[1][5]) {
                    // System.out.println("La celda contiene un reina NEGRA");
                    return "Reina Negro";
                } else if (imagen == image_array[0][6]) {
                    // System.out.println("La celda contiene un rey BLANCO");
                    return "Rey Blanco";
                } else if (imagen == image_array[1][6]) {
                    // System.out.println("La celda contiene un rey NEGRO");
                    return "Rey Negro";
                }
            }
        }
        return "";
    }
    private StackPane [] posiblesJugadas (StackPane casilla, String [] pieza_array, String cellId) {
        ArrayList<StackPane> lista_posibles_jugadas = new ArrayList<>();

        if (pieza_array[0].equals("Peon")) { // Posibles jugadas si es un peón
            lista_posibles_jugadas = calcular_jugadas_peon(casilla, pieza_array);
            // Cambiando el color de las casillas con las posibles jugadas
            for (int i = 0; i < lista_posibles_jugadas.size(); i ++) {
                StackPane stackPane_iterado = lista_posibles_jugadas.get(i);
                changeColorRectangle(stackPane_iterado, posibleN_color, posibleB_color, stackPane_iterado.getId());
            }
        } else if (pieza_array[0].equals("Caballo")) {
            lista_posibles_jugadas = calcular_jugadas_caballo(casilla, pieza_array);
            // Cambiando el color de las casillas con las posibles jugadas
            for (int i = 0; i < lista_posibles_jugadas.size(); i ++) {
                StackPane stackPane_iterado = lista_posibles_jugadas.get(i);
                changeColorRectangle(stackPane_iterado, posibleN_color, posibleB_color, stackPane_iterado.getId());
            }
        } else if (pieza_array[0].equals("Torre")) {
            lista_posibles_jugadas = calcular_jugadas_torre(casilla, pieza_array);
            // Cambiando el color de las casillas con las posibles jugadas
            for (int i = 0; i < lista_posibles_jugadas.size(); i ++) {
                StackPane stackPane_iterado = lista_posibles_jugadas.get(i);
                changeColorRectangle(stackPane_iterado, posibleN_color, posibleB_color, stackPane_iterado.getId());
            }
        } else if (pieza_array[0].equals("Alfil")) {
            lista_posibles_jugadas = calcular_jugadas_alfil(casilla, pieza_array);
            // Cambiando el color de las casillas con las posibles jugadas
            for (int i = 0; i < lista_posibles_jugadas.size(); i ++) {
                StackPane stackPane_iterado = lista_posibles_jugadas.get(i);
                changeColorRectangle(stackPane_iterado, posibleN_color, posibleB_color, stackPane_iterado.getId());
            }
        } else if (pieza_array[0].equals("Reina")) {
            lista_posibles_jugadas = calcular_jugadas_reina(casilla, pieza_array);
            // Cambiando el color de las casillas con las posibles jugadas
            for (int i = 0; i < lista_posibles_jugadas.size(); i ++) {
                StackPane stackPane_iterado = lista_posibles_jugadas.get(i);
                changeColorRectangle(stackPane_iterado, posibleN_color, posibleB_color, stackPane_iterado.getId());
            }
        }

        else if (pieza_array[0].equals("Rey")) {
            lista_posibles_jugadas = calcular_jugadas_rey(casilla, pieza_array);
            // Cambiando el color de las casillas con las posibles jugadas
            for (int i = 0; i < lista_posibles_jugadas.size(); i ++) {
                StackPane stackPane_iterado = lista_posibles_jugadas.get(i);
                changeColorRectangle(stackPane_iterado, posibleN_color, posibleB_color, stackPane_iterado.getId());
            }
        }

        StackPane [] posiblesJugadas_array = new StackPane [lista_posibles_jugadas.size()];
        for (int i = 0; i < lista_posibles_jugadas.size(); i++) {
            posiblesJugadas_array[i] = lista_posibles_jugadas.get(i);
        }
        return posiblesJugadas_array;
    }
    private boolean rey_blanco_puede_enrocar_derecha = true;
    private boolean rey_blanco_puede_enrocar_izquierda = true;
    private boolean rey_negro_puede_enrocar_derecha = true;
    private boolean rey_negro_puede_enrocar_izquierda = true;
    private ArrayList<StackPane> jugadas_de_enroque (int fila, int columna) {
        ArrayList<StackPane> jugadas_enroque = new ArrayList<>();
        if (fila == 0) { // Es el rey negro
            // Verificamos si está vació para enrocar correctamente hacia la izquieda
            if (validate_cell(tablero[0][1]).isEmpty() && validate_cell(tablero[0][2]).isEmpty() && validate_cell(tablero[0][3]).isEmpty()) {
                String casilla00 = validate_cell(tablero[0][0]);
                if (casilla00.equals("Torre Negro")) {
                    jugadas_enroque.add(tablero[0][2]);
                }
            }
            // Verificamos si está vació para enrocar correctamente hacia la derecha
            if (validate_cell(tablero[0][5]).isEmpty() && validate_cell(tablero[0][6]).isEmpty()) {
                String casilla07 = validate_cell(tablero[0][7]);
                if (casilla07.equals("Torre Negro")) {
                    jugadas_enroque.add(tablero[0][6]);
                }
            }
        } else if (fila == 7) { // Es el rey negro
            // Verificamos si está vació para enrocar correctamente hacia la izquieda
            if (validate_cell(tablero[7][1]).isEmpty() && validate_cell(tablero[7][2]).isEmpty() && validate_cell(tablero[7][3]).isEmpty()) {
                String casilla70 = validate_cell(tablero[7][0]);
                if (casilla70.equals("Torre Blanco")) {
                    jugadas_enroque.add(tablero[7][2]);
                }
            }
            // Verificamos si está vació para enrocar correctamente hacia la derecha
            if (validate_cell(tablero[7][5]).isEmpty() && validate_cell(tablero[7][6]).isEmpty()) {
                String casilla77 = validate_cell(tablero[7][7]);
                if (casilla77.equals("Torre Blanco")) {
                    jugadas_enroque.add(tablero[7][6]);
                }
            }
        }
        return jugadas_enroque;
    }
    private ArrayList<StackPane> calcular_jugadas_rey (StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        // Booleano para verificar si hay pieza del mismo color
        boolean sonIguales = false;

        String pieza_posible_jugada = "";
        String [] pieza_posibles_jugada_array = null;

        if (rey_negro_puede_enrocar_izquierda || rey_negro_puede_enrocar_derecha) {
            if (pieza_array[1].equals("Negro")) {
                ArrayList<StackPane> jugadas_enroque = jugadas_de_enroque(fila, columna);

                for (int i = 0; i < jugadas_enroque.size(); i ++) { // Añadimos las jugadas
                    jugadas.add(jugadas_enroque.get(i));
                }
            }
        }

        if (rey_blanco_puede_enrocar_izquierda || rey_blanco_puede_enrocar_derecha) {
            if (pieza_array[1].equals("Blanco")) {
                ArrayList<StackPane> jugadas_enroque = jugadas_de_enroque(fila, columna);

                for (int i = 0; i < jugadas_enroque.size(); i ++) { // Añadimos las jugadas
                    jugadas.add(jugadas_enroque.get(i));
                }
            }
        }

        if ((fila - 1) >= 0) {
            if ((columna + 1) <= 7) { // Mover hacia arriba a la derecha
                pieza_posible_jugada = validate_cell(tablero[fila - 1][columna + 1]);
                if (pieza_posible_jugada.isEmpty()) {
                    jugadas.add(tablero[fila - 1][columna + 1]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                    if (!sonIguales) {
                        jugadas.add(tablero[fila - 1][columna + 1]);
                    }
                }
            }
            if ((columna - 1) >= 0) { // Mover hacia arriba a la izquierda
                pieza_posible_jugada = validate_cell(tablero[fila - 1][columna - 1]);
                if (pieza_posible_jugada.isEmpty()) {
                    jugadas.add(tablero[fila - 1][columna - 1]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                    if (!sonIguales) {
                        jugadas.add(tablero[fila - 1][columna - 1]);
                    }
                }
            }

            // Mover hacia arriba
            pieza_posible_jugada = validate_cell(tablero[fila - 1][columna]);
            if (pieza_posible_jugada.isEmpty()) {
                jugadas.add(tablero[fila - 1][columna]);
            } else {
                pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                if (!sonIguales) {
                    jugadas.add(tablero[fila - 1][columna]);
                }
            }
        }

        if ((fila + 1) <= 7) {
            if ((columna + 1) <= 7) { // Mover hacia abajo a la derecha
                pieza_posible_jugada = validate_cell(tablero[fila + 1][columna + 1]);
                if (pieza_posible_jugada.isEmpty()) {
                    jugadas.add(tablero[fila + 1][columna + 1]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                    if (!sonIguales) {
                        jugadas.add(tablero[fila + 1][columna + 1]);
                    }
                }
            }
            if ((columna - 1) >= 0) { // Mover hacia abajo a la izquierda
                pieza_posible_jugada = validate_cell(tablero[fila + 1][columna - 1]);
                if (pieza_posible_jugada.isEmpty()) {
                    jugadas.add(tablero[fila + 1][columna - 1]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                    if (!sonIguales) {
                        jugadas.add(tablero[fila + 1][columna - 1]);
                    }
                }
            }

            // Mover hacia abajo
            pieza_posible_jugada = validate_cell(tablero[fila + 1][columna]);
            if (pieza_posible_jugada.isEmpty()) {
                jugadas.add(tablero[fila + 1][columna]);
            } else {
                pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                if (!sonIguales) {
                    jugadas.add(tablero[fila + 1][columna]);
                }
            }
        }

        // Mover hacia la derecha
        if (columna <= 6) {
            pieza_posible_jugada = validate_cell(tablero[fila][columna + 1]);
            if (pieza_posible_jugada.isEmpty()) {
                jugadas.add(tablero[fila][columna + 1]);
            } else {
                pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                if (!sonIguales) {
                    jugadas.add(tablero[fila][columna + 1]);
                }
            }
        }

        // Mover hacia la izquierda
        if (columna >= 1) {
            pieza_posible_jugada = validate_cell(tablero[fila][columna - 1]);
            if (pieza_posible_jugada.isEmpty()) {
                jugadas.add(tablero[fila][columna - 1]);
            } else {
                pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                if (!sonIguales) {
                    jugadas.add(tablero[fila][columna - 1]);
                }
            }
        }

        return jugadas;
    }
    private ArrayList<StackPane> calcular_jugadas_reina (StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        // La reina es como si fuese un Alfil y una torre a la vez
        // Así que calculamos los movimientos como si fuese cada uno de ellos y los unimos
        ArrayList<StackPane> jugadas_alfil = calcular_jugadas_alfil(casilla, pieza_array);
        ArrayList<StackPane> jugadas_torre = calcular_jugadas_torre(casilla, pieza_array);

        for (int i = 0; i < jugadas_alfil.size(); i ++) {
            jugadas.add(jugadas_alfil.get(i));
        }

        for (int i = 0; i < jugadas_torre.size(); i ++) {
            jugadas.add(jugadas_torre.get(i));
        }
        return jugadas;
    }
    private ArrayList<StackPane> calcular_jugadas_alfil (StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        // Booleano para verificar si hay pieza del mismo color
        boolean sonIguales = false;

        String pieza_posible_jugada = "";
        String [] pieza_posibles_jugada_array = null;

        // Como máximo puede moverse siete casillas
        for (int i = 1; i < 9; i ++) {
            if (fila <= 7) {
                // Moverse hacia arriba a la izquierda
                if (columna >= 1) {
                    if ((fila - i) >= 0 && (columna - i) >= 0) {
                        pieza_posible_jugada = validate_cell(tablero[fila - i][columna - i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila - i][columna - i]);
                        } else {
                            pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                            sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                            if (!sonIguales) { // Si no son iguales añadimos la posible jugada y salimos del bucle
                                jugadas.add(tablero[fila - i][columna - i]);
                            }
                            break; // Si son iguales salimos del bucle directamente
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            if (fila <= 7) {
                // Moverse hacia arriba a la derecha
                if (columna <= 7) {
                    if ((fila - i) >= 0 && (columna + i) <= 7) {
                        pieza_posible_jugada = validate_cell(tablero[fila - i][columna + i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila - i][columna + i]);
                        } else {
                            pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                            sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                            if (!sonIguales) { // Si no son iguales añadimos la posible jugada y salimos del bucle
                                jugadas.add(tablero[fila - i][columna + i]);
                            }
                            break; // Si son iguales salimos del bucle directamente
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            if (fila >= 0) {
                // Moverse hacia abajo a la derecha
                if (columna <= 7) {
                    if ((fila + i) <= 7 && (columna + i) <= 7) {
                        pieza_posible_jugada = validate_cell(tablero[fila + i][columna + i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila + i][columna + i]);
                        } else {
                            pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                            sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                            if (!sonIguales) { // Si no son iguales añadimos la posible jugada y salimos del bucle
                                jugadas.add(tablero[fila + i][columna + i]);
                            }
                            break; // Si son iguales salimos del bucle directamente
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            if (fila >= 0) {
                // Moverse hacia abajo a la izquierda
                if (columna >= 1) {
                    if ((fila + i) <= 7 && (columna - i) >= 0) {
                        pieza_posible_jugada = validate_cell(tablero[fila + i][columna - i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila + i][columna - i]);
                        } else {
                            pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                            sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);
                            if (!sonIguales) { // Si no son iguales añadimos la posible jugada y salimos del bucle
                                jugadas.add(tablero[fila + i][columna - i]);
                            }
                            break; // Si son iguales salimos del bucle directamente
                        }
                    }
                }
            }
        }

        return jugadas;
    }
    private ArrayList<StackPane> calcular_jugadas_torre (StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        // Booleano para verificar si hay pieza del mismo color
        boolean sonIguales = false;

        String pieza_posible_jugada = "";
        String [] pieza_posibles_jugada_array = null;

        // Como máximo puede moverse siete casillas
        for (int i = 1; i < 9; i ++) {
            // Moverse hacia arriba
            if (fila - i >= 0) {
                pieza_posible_jugada = validate_cell(tablero[fila - i][columna]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila - i][columna]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);

                    if (!sonIguales) { // Y si hay pieza del color contrario la añadimos y luego salimos del bucle
                        jugadas.add(tablero[fila - i][columna]);
                    }
                    break; // Si hay pieza del mismo color salimos del bucle directamente
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            // Moverse hacia abajo
            if (fila + i <= 7) {
                pieza_posible_jugada = validate_cell(tablero[fila + i][columna]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila + i][columna]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);

                    if (!sonIguales) { // Y si hay pieza del color contrario la añadimos y luego salimos del bucle
                        jugadas.add(tablero[fila + i][columna]);
                    }
                    break; // Si hay pieza del mismo color salimos del bucle directamente
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            // Moverse hacia derecha
            if (columna + i <= 7) {
                pieza_posible_jugada = validate_cell(tablero[fila][columna + i]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila][columna + i]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);

                    if (!sonIguales) { // Y si hay pieza del color contrario la añadimos y luego salimos del bucle
                        jugadas.add(tablero[fila][columna + i]);
                    }
                    break; // Si hay pieza del mismo color salimos del bucle directamente
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            // Moverse hacia izquierda
            if (columna - i >= 0) {
                pieza_posible_jugada = validate_cell(tablero[fila][columna - i]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila][columna - i]);
                } else {
                    pieza_posibles_jugada_array = pieza_posible_jugada.split(" ");
                    sonIguales = pieza_posibles_jugada_array[1].equals(pieza_array[1]);

                    if (!sonIguales) { // Y si hay pieza del color contrario la añadimos y luego salimos del bucle
                        jugadas.add(tablero[fila][columna - i]);
                    }
                    break; // Si hay pieza del mismo color salimos del bucle directamente
                }
            }
        }

        return jugadas;
    }
    private ArrayList<StackPane> calcular_jugadas_caballo (StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        // Booleano para verificar si son iguales
        boolean sonIguales = false;

        // El caballo puede mover hasta en ocho casillas
        String jugada1 = "";
        String [] jugada1_array = null;


        // Posible jugada 1 (arriba derecaha1)
        if (columna <= 6 && fila >= 2) {
            jugada1 = validate_cell(tablero[fila - 2][columna + 1]);
            // Imprimimos para hacer algunas verificaciones
            // System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                // System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                // System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    jugadas.add(tablero[fila -2][columna+1]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila -2][columna+1]);
            }
        }

        // Posible jugada 2 (arriba derecaha2)
        if (columna <= 5 && fila >= 1) {
            jugada1 = validate_cell(tablero[fila - 1][columna + 2]);
            // Imprimimos para hacer algunas verificaciones
            // System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                // System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                // System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    // System.out.println("Entramos en  la condición");
                    jugadas.add(tablero[fila - 1][columna + 2]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila - 1][columna +  2]);
            }
        }

        // Posible jugada 3 (arriba izquierda1)
        if (columna >= 1 && fila >= 2) {
            jugada1 = validate_cell(tablero[fila - 2][columna - 1]);
            // Imprimimos para hacer algunas verificaciones
            // System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                // System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                // System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    jugadas.add(tablero[fila - 2][columna - 1]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila - 2][columna - 1]);
            }
        }

        // Posible jugada 4 (arriba izquierda2)
        if (columna >= 2 && fila >= 1) {
            jugada1 = validate_cell(tablero[fila - 1][columna - 2]);
            // Imprimimos para hacer algunas verificaciones
            //System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                //System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                //System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    //System.out.println("Entramos en  la condición");
                    jugadas.add(tablero[fila - 1][columna - 2]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila - 1][columna - 2]);
            }
        }

        // Posible jugada 5 (abajo derecaha1)
        if (columna <= 6 && fila <= 5) {
            jugada1 = validate_cell(tablero[fila + 2][columna + 1]);
            // Imprimimos para hacer algunas verificaciones
            //System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                //System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                //System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    jugadas.add(tablero[fila + 2][columna + 1]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila + 2][columna + 1]);
            }
        }

        // Posible jugada 6 (abajo derecaha2)
        if (columna <= 5 && fila <= 6) {
            jugada1 = validate_cell(tablero[fila + 1][columna + 2]);
            // Imprimimos para hacer algunas verificaciones
            // System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                // System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                // System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    // System.out.println("Entramos en  la condición");
                    jugadas.add(tablero[fila + 1][columna + 2]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila + 1][columna + 2]);
            }
        }

        // Posible jugada 7 (abajo izquierda1)
        if (columna >= 1 && fila <= 5) {
            jugada1 = validate_cell(tablero[fila + 2][columna - 1]);
            // Imprimimos para hacer algunas verificaciones
            // System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                // System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                // System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    jugadas.add(tablero[fila + 2][columna - 1]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila + 2][columna - 1]);
            }
        }

        // Posible jugada 8 (abajo izquierda2)
        if (columna >= 2 && fila <= 6) {
            jugada1 = validate_cell(tablero[fila + 1][columna - 2]);
            // Imprimimos para hacer algunas verificaciones
            // System.out.println(jugada1);
            if (!jugada1.isEmpty()) {
                jugada1_array = jugada1.split(" ");
                // Imprimimos para hacer algunas verificaciones
                // System.out.println(jugada1_array[1] + " " + pieza_array[1]);
                sonIguales = jugada1_array[1].equals(pieza_array[1]);
                // System.out.println(sonIguales);
                if (!sonIguales) { // Verificamos que no hay una pieza del mismo color
                    // System.out.println("Entramos en  la condición");
                    jugadas.add(tablero[fila + 1][columna - 2]);
                }
            } else { // No hay pieza
                jugadas.add(tablero[fila + 1][columna - 2]);
            }
        }

        return jugadas;
    }
    private ArrayList<StackPane> calcular_jugadas_peon (StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        String pieza_a_comer1 = "";
        String [] pieza_a_comer1_array = null;
        String pieza_a_comer2 = "";
        String [] pieza_a_comer2_array = null;

        String hay_pieza = validate_cell(tablero[fila + 1][columna]);

        if (pieza_array[1].equals("Blanco")) { // El peón es blanco
            if (fila == 6) { // Al empezar los peones pueden mover 2 casillas
                hay_pieza = validate_cell(tablero[fila - 1][columna]);
                if (hay_pieza.isEmpty()) { // No puede avanzar si tiene una ficha delante
                    // System.out.println("Añadimos a jugadas (fila-columna) (" + (fila - 1) + "-" + columna + ")");
                    jugadas.add(tablero[fila - 1][columna]);

                    hay_pieza = validate_cell(tablero[fila - 2][columna]);
                    if (hay_pieza.isEmpty()) {
                        // System.out.println("Añadimos a jugadas (fila-columna) (" + (fila - 2) + "-" + columna + ")");
                        jugadas.add(tablero[fila - 2][columna]);
                }

                }
            } else if (fila >= 1) { // Luego solo pueden avanzar una casilla
                hay_pieza = validate_cell(tablero[fila - 1][columna]);
                if (hay_pieza.isEmpty()) {
                    // System.out.println("Añadimos a jugadas (fila-columna) (" + (fila - 1) + "-" + columna + ")");
                    jugadas.add(tablero[fila - 1][columna]);
                }
            }

            // Añadimos movimientos para comer piezas si se puede
            if (fila >= 1 && fila <= 6) {
                if (columna >= 1) {
                    pieza_a_comer1= validate_cell(tablero[fila - 1][columna - 1]);
                    if (!pieza_a_comer1.isEmpty()) {
                        pieza_a_comer1_array = pieza_a_comer1.split(" ");
                        // Verificamos que la pieza es nagra para poder comerla
                        if (pieza_a_comer1_array[1].equals("Negro")) {
                            jugadas.add(tablero[fila - 1][columna - 1]);
                        }
                    }
                }
                if (columna <= 6) {
                    pieza_a_comer2 = validate_cell(tablero[fila - 1][columna + 1]);
                    if (!pieza_a_comer2.isEmpty()) {
                        pieza_a_comer2_array = pieza_a_comer2.split(" ");
                        // Verificamos que la pieza es nagra para poder comerla
                        if (pieza_a_comer2_array[1].equals("Negro")) {
                            jugadas.add(tablero[fila - 1][columna + 1]);
                        }
                    }
                }
            }

        } else { // El peón es negro
            if (fila == 1) { // Al empezar los peones pueden mover 2 casillas
                if (hay_pieza.isEmpty()) { // No puede avanzar si hay una pieza delante
                    // System.out.println("Añadimos a jugadas (fila-columna) (" + (fila + 1) + "-" + columna + ")");
                    jugadas.add(tablero[fila + 1][columna]);

                    hay_pieza = validate_cell(tablero[fila + 2][columna]);
                    if (hay_pieza.isEmpty()) { // No puede avanzar si hay una pieza delante
                        // System.out.println("Añadimos a jugadas (fila-columna) (" + (fila + 2) + "-" + columna + ")");
                        jugadas.add(tablero[fila + 2][columna]);
                    }
                }

            } else if (fila <= 6) { // Luego solo pueden avanzar una casilla
                hay_pieza = validate_cell(tablero[fila + 1][columna]);
                if (hay_pieza.isEmpty()) { // No puede avanzar si hay una pieza delante
                    // System.out.println("Añadimos a jugadas (fila-columna) (" + (fila + 1) + "-" + columna + ")");
                    jugadas.add(tablero[fila + 1][columna]);
                }
            }
            // Añadimos movimientos para comer piezas si se puede
            if (fila >= 1 && fila <= 6) {
                if (columna >= 1) {
                    pieza_a_comer1= validate_cell(tablero[fila + 1][columna - 1]);
                    if (!pieza_a_comer1.isEmpty()) {
                        pieza_a_comer1_array = pieza_a_comer1.split(" ");
                        // Verificamos que la pieza es nagra para poder comerla
                        if (pieza_a_comer1_array[1].equals("Blanco")) {
                            jugadas.add(tablero[fila + 1][columna - 1]);
                        }
                    }
                }
                if (columna <= 6) {
                    pieza_a_comer2= validate_cell(tablero[fila + 1][columna + 1]);
                    if (!pieza_a_comer2.isEmpty()) {
                        pieza_a_comer2_array = pieza_a_comer2.split(" ");
                        // Verificamos que la pieza es nagra para poder comerla
                        if (pieza_a_comer2_array[1].equals("Blanco")) {
                            jugadas.add(tablero[fila + 1][columna + 1]);
                        }
                    }
                }
            }

        }

        // Imprimimos para hacer comprobaciones
        for (int i = 0; i < jugadas.size(); i ++) {
            System.out.println(jugadas.get(i));
        }


        return jugadas;
    }
    private void hacer_jugada (StackPane lastClick, StackPane firstClick, String [] pieza) {
        ImageView contenedor_imagen = null;

        // Imprimimos firstClick y lastClick para hacer verificaciones
        System.out.println("FirstClick: " + firstClick);
        System.out.println("LastClick: " + lastClick);

        for (Node node : lastClick.getChildren()) {
            if (node instanceof ImageView) {
                contenedor_imagen = (ImageView) node;

                // Si es un peon blanco
                if (pieza[0].equals("Peon") && pieza[1].equals("Blanco")) {
                    // Añadimos condición por si el peón ha pasado a la última fila
                    if (firstClick.getId().equals("sp10") || firstClick.getId().equals("sp11") || firstClick.getId().equals("sp12") || firstClick.getId().equals("sp13") ||
                            firstClick.getId().equals("sp14") || firstClick.getId().equals("sp15") || firstClick.getId().equals("sp16") || firstClick.getId().equals("sp17")) {
                        escoger_caballo_id.setVisible(true);
                        escoger_alfil_id.setVisible(true);
                        escoger_torre_id.setVisible(true);
                        escoger_reina_id.setVisible(true);
                        tiene_que_escoger = true;
                    } else {
                        // System.out.println("La imagen a mover es un peon Blanco");
                        contenedor_imagen.setImage(image_array[0][1]);
                    }
                }

                // Si es un peon negro
                if (pieza[0].equals("Peon") && pieza[1].equals("Negro")) {
                    // Añadimos condición por si el peón ha pasado a la última fila
                    if (firstClick.getId().equals("sp60") || firstClick.getId().equals("sp61") || firstClick.getId().equals("sp62") || firstClick.getId().equals("sp63") ||
                            firstClick.getId().equals("sp64") || firstClick.getId().equals("sp65") || firstClick.getId().equals("sp66") || firstClick.getId().equals("sp67")) {
                        escoger_caballo_id.setVisible(true);
                        escoger_alfil_id.setVisible(true);
                        escoger_torre_id.setVisible(true);
                        escoger_reina_id.setVisible(true);
                        tiene_que_escoger = true;
                    } else {
                        // System.out.println("La imagen a mover es un peon Negro");
                        contenedor_imagen.setImage(image_array[1][1]);
                    }
                }

                // Si es un caballo blanco
                if (pieza[0].equals("Caballo") && pieza[1].equals("Blanco")) {
                    // System.out.println("La imagen a mover es un Caballo Blanco");
                    contenedor_imagen.setImage(image_array[0][3]);
                }

                // Si es un caballo negro
                if (pieza[0].equals("Caballo") && pieza[1].equals("Negro")) {
                    // System.out.println("La imagen a mover es un Caballo Negro");
                    contenedor_imagen.setImage(image_array[1][3]);
                }

                // Si es un torre blanco
                if (pieza[0].equals("Torre") && pieza[1].equals("Blanco")) {
                    // System.out.println("La imagen a mover es un Torre Blanco");
                    contenedor_imagen.setImage(image_array[0][4]);


                    // Si mueve las torres ya no puede enrocar
                    int fila = recibir_coordenadas_pieza(firstClick)[0];
                    int columna = recibir_coordenadas_pieza(firstClick)[1];

                    if (fila == 7 && columna == 0) {
                        rey_blanco_puede_enrocar_izquierda = false;
                    }

                    if (fila == 7 && columna == 7) {
                        rey_blanco_puede_enrocar_derecha = false;
                    }
                }

                // Si es un torre negro
                if (pieza[0].equals("Torre") && pieza[1].equals("Negro")) {
                    // System.out.println("La imagen a mover es un Torre Negro");
                    contenedor_imagen.setImage(image_array[1][4]);

                    // Si mueve las torres ya no puede enrocar
                    int fila = recibir_coordenadas_pieza(firstClick)[0];
                    int columna = recibir_coordenadas_pieza(firstClick)[1];

                    if (fila == 7 && columna == 0) {
                        rey_negro_puede_enrocar_izquierda = false;
                    }

                    if (fila == 7 && columna == 7) {
                        rey_negro_puede_enrocar_derecha = false;
                    }
                }

                // Si es un Alfil blanco
                if (pieza[0].equals("Alfil") && pieza[1].equals("Blanco")) {
                    // System.out.println("La imagen a mover es un Alfil Blanco");
                    contenedor_imagen.setImage(image_array[0][2]);
                }

                // Si es un Alfil negro
                if (pieza[0].equals("Alfil") && pieza[1].equals("Negro")) {
                    // System.out.println("La imagen a mover es un Alfil Negro");
                    contenedor_imagen.setImage(image_array[1][2]);
                }

                // Si es un Reina blanco
                if (pieza[0].equals("Reina") && pieza[1].equals("Blanco")) {
                    // System.out.println("La imagen a mover es un Reina Blanco");
                    contenedor_imagen.setImage(image_array[0][5]);
                }

                // Si es un Reina negro
                if (pieza[0].equals("Reina") && pieza[1].equals("Negro")) {
                    // System.out.println("La imagen a mover es un Reina Negro");
                    contenedor_imagen.setImage(image_array[1][5]);
                }

                // Si es un Rey blanco
                if (pieza[0].equals("Rey") && pieza[1].equals("Blanco")) {
                    // System.out.println("La imagen a mover es un Rey Blanco");
                    contenedor_imagen.setImage(image_array[0][6]);

                    // Si movemos el rey ya no se puede enrocar
                    rey_blanco_puede_enrocar_derecha = false;
                    rey_blanco_puede_enrocar_izquierda = false;
                }

                // Si es un Rey negro
                if (pieza[0].equals("Rey") && pieza[1].equals("Negro")) {
                    // System.out.println("La imagen a mover es un Rey Negro");
                    contenedor_imagen.setImage(image_array[1][6]);

                    // Si movemos el rey ya no se puede enrocar
                    rey_negro_puede_enrocar_derecha = false;
                    rey_negro_puede_enrocar_izquierda = false;
                }
            }
        }
        vaciar_Image_view(firstClick);
    }
    private void changeColorRectangle(StackPane celda, Color color_claro, Color color_oscuro, String cellId) {
        for (Node node: celda.getChildren()) {
            if (node instanceof Rectangle) {
                Rectangle rectangulo = (Rectangle) node;
                if (cellId.equals("sp00")  || cellId.equals("sp02")  || cellId.equals("sp04")  || cellId.equals("sp06")  ||
                        cellId.equals("sp11")  || cellId.equals("sp13")  || cellId.equals("sp15")  || cellId.equals("sp17") ||
                        cellId.equals("sp20")  || cellId.equals("sp22")  || cellId.equals("sp24")  || cellId.equals("sp26")  ||
                        cellId.equals("sp31")  || cellId.equals("sp33")  || cellId.equals("sp35")  || cellId.equals("sp37") ||
                        cellId.equals("sp40")  || cellId.equals("sp42")  || cellId.equals("sp44")  || cellId.equals("sp46")  ||
                        cellId.equals("sp51")  || cellId.equals("sp53")  || cellId.equals("sp55")  || cellId.equals("sp57") ||
                        cellId.equals("sp60")  || cellId.equals("sp62")  || cellId.equals("sp64")  || cellId.equals("sp66")  ||
                        cellId.equals("sp71")  || cellId.equals("sp73")  || cellId.equals("sp75")  || cellId.equals("sp77")) {
                    rectangulo.setFill(color_oscuro);
                } else {
                    rectangulo.setFill(color_claro);
                }
                break; // Sólo hay un rectángulo en cada Stackpane
            }
        }
    }
    private ArrayList<StackPane> ataque_negro = new ArrayList<>();
    private ArrayList<StackPane> ataque_blanco = new ArrayList<>();
    private void calcular_ataque_negras() {
        // System.out.println("Calculamos ataque de las negras");
        ataque_negro = calcular_ataque("Negro");
    }
    private void calcular_ataque_blancas() {
        // System.out.println("Calculamos ataque de las blancas");
        ataque_blanco = calcular_ataque("Blanco");
    }
    @FXML
    public void mostrar_ataque_negras () {
        // Calculamos el array ya si no hay ningún movimiento no está calculado
        limpiar_colores();
        calcular_ataque_negras();

        // Pintamos de rojo las casillas atacadas
        for (int i = 0; i < ataque_negro.size(); i ++) {
            changeColorRectangle(ataque_negro.get(i), AttackB_color, AttackN_color, ataque_negro.get(i).getId());
        }
    }
    @FXML
    public void mostrar_ataque_blancas () {
        // Calculamos el array ya si no hay ningún movimiento no está calculado
        limpiar_colores();
        calcular_ataque_blancas();

        // Pintamos de rojo las casillas atacadas
        for (int i = 0; i < ataque_blanco.size(); i ++) {
            changeColorRectangle(ataque_blanco.get(i), AttackB_color2, AttackN_color2, ataque_blanco.get(i).getId());
        }
    }
    private ArrayList<StackPane> calcular_ataque(String color_pieza) {
        ArrayList<StackPane> ataque = new ArrayList<>();
        // System.out.println(" ");
        for (int i = 0; i < tablero.length; i ++) {
            for (int j = 0; j < tablero[0].length; j ++) {
                // Imprimimos algunas cosas para hacer verificaciones
                // System.out.print(i+""+j+" ");
                // System.out.println(" ");
                /* System.out.print(tablero[i][j] + " ");
                System.out.println(pieza_string + " "); */
                String pieza_string = validate_cell(tablero[i][j]);

                if (!pieza_string.isEmpty()) { // Si la casilla no está vacía
                    String [] pieza_string_array = pieza_string.split(" ");

                    if (pieza_string_array[1].equals(color_pieza)) { // Si contiene una pieza negra

                        if (pieza_string_array[0].equals("Torre")) { // Si es una Torre
                            ArrayList<StackPane> ataque_pieza = calcular_casillas_atacadas_torre(tablero[i][j]);

                            for (int x = 0; x < ataque_pieza.size(); x ++) {
                                ataque.add(ataque_pieza.get(x));
                            }
                        } else if (pieza_string_array[0].equals("Alfil")) { // Si es un Alfil
                            ArrayList<StackPane> ataque_pieza = calcular_casillas_atacadas_alfil(tablero[i][j]);

                            for (int x = 0; x < ataque_pieza.size(); x ++) {
                                ataque.add(ataque_pieza.get(x));
                            }
                        } else if (pieza_string_array[0].equals("Caballo")) { // Si es un Caballo
                            ArrayList<StackPane> ataque_pieza = calcular_casillas_atacadas_caballo(tablero[i][j]);

                            for (int x = 0; x < ataque_pieza.size(); x ++) {
                                ataque.add(ataque_pieza.get(x));
                            }
                        } else if (pieza_string_array[0].equals("Peon")) { // Si es un Peón
                            ArrayList<StackPane> ataque_pieza = calcular_casillas_atacadas_peon(tablero[i][j], pieza_string_array);

                            for (int x = 0; x < ataque_pieza.size(); x ++) {
                                ataque.add(ataque_pieza.get(x));
                            }
                        } else if (pieza_string_array[0].equals("Reina")) { // Si es un Peón
                            ArrayList<StackPane> ataque_pieza = calcular_casillas_atacadas_reina(tablero[i][j]);

                            for (int x = 0; x < ataque_pieza.size(); x ++) {
                                ataque.add(ataque_pieza.get(x));
                            }
                        } else if (pieza_string_array[0].equals("Rey")) { // Si es un Peón
                            ArrayList<StackPane> ataque_pieza = calcular_casillas_atacadas_rey(tablero[i][j]);

                            for (int x = 0; x < ataque_pieza.size(); x ++) {
                                ataque.add(ataque_pieza.get(x));
                            }
                        }
                    }
                }
            }
        }
        return ataque;
    }
    // Estas funciones son parecidas a las de calcular_posibles_jugadas_...  pero estas devuelven las casillas atacadas por lo
    // que aunque haya una pieza de su mismo color está atacada igualmente. Y son para ayudarnos a calcular si hay jaque mate o no.
    // Seguramente hayan maneras má óptimas de hacerlo pero esta es la que se nos ha ocurrido.
    private ArrayList<StackPane> calcular_casillas_atacadas_torre(StackPane casilla) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];

        String pieza_posible_jugada = "";

        // Como máximo puede atacar siete casillas
        for (int i = 1; i < 9; i ++) {
            // Ataque hacia arriba
            if (fila - i >= 0) {
                pieza_posible_jugada = validate_cell(tablero[fila - i][columna]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila - i][columna]);
                } else { // Si hay pieza añadimos y salimos del bucle
                    jugadas.add(tablero[fila - i][columna]);
                    break;
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            // Atacar hacia abajo
            if (fila + i <= 7) {
                pieza_posible_jugada = validate_cell(tablero[fila + i][columna]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila + i][columna]);
                } else { // Si hay pieza añadimos y salimos del bucle
                    jugadas.add(tablero[fila + i][columna]);
                    break;
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            // Atacar hacia derecha
            if (columna + i <= 7) {
                pieza_posible_jugada = validate_cell(tablero[fila][columna + i]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila][columna + i]);
                } else { // Si hay pieza añadimos y salimos del bucle
                    jugadas.add(tablero[fila][columna + i]);
                    break;
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            // Atacar hacia izquierda
            if (columna - i >= 0) {
                pieza_posible_jugada = validate_cell(tablero[fila][columna - i]);
                if (pieza_posible_jugada.isEmpty()) { // Si no hay pieza añadimos la jugada directamente al array
                    jugadas.add(tablero[fila][columna - i]);
                } else { // Si hay pieza añadimos y salimos del bucle
                    jugadas.add(tablero[fila][columna - i]);
                    break;
                }
            }
        }
        return jugadas;
    }
    private ArrayList<StackPane> calcular_casillas_atacadas_alfil(StackPane casilla) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        String pieza_posible_jugada = "";

        // Como máximo puede atacar siete casillas
        for (int i = 1; i < 9; i ++) {
            if (fila <= 7) {
                // Ataque hacia arriba a la izquierda
                if (columna >= 1) {
                    if ((fila - i) >= 0 && (columna - i) >= 0) {
                        pieza_posible_jugada = validate_cell(tablero[fila - i][columna - i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila - i][columna - i]);
                        } else { // Si no añadimos y salimos del bucle
                            jugadas.add(tablero[fila - i][columna - i]);
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            if (fila <= 7) {
                // Ataque hacia arriba a la derecha
                if (columna <= 7) {
                    if ((fila - i) >= 0 && (columna + i) <= 7) {
                        pieza_posible_jugada = validate_cell(tablero[fila - i][columna + i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila - i][columna + i]);
                        } else { // Si no añadimos y salimos del bucle
                            jugadas.add(tablero[fila - i][columna + i]);
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            if (fila >= 0) {
                // Ataque hacia abajo a la derecha
                if (columna <= 7) {
                    if ((fila + i) <= 7 && (columna + i) <= 7) {
                        pieza_posible_jugada = validate_cell(tablero[fila + i][columna + i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila + i][columna + i]);
                        } else { // Si no añadimos y salimos del bucle
                            jugadas.add(tablero[fila + i][columna + i]);
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < 9; i ++) {
            if (fila >= 0) {
                // Ataque hacia abajo a la izquierda
                if (columna >= 1) {
                    if ((fila + i) <= 7 && (columna - i) >= 0) {
                        pieza_posible_jugada = validate_cell(tablero[fila + i][columna - i]);
                        if (pieza_posible_jugada.isEmpty()) { // Si está vacío añadimos directamente a la lista de jugadas
                            jugadas.add(tablero[fila + i][columna - i]);
                        } else { // Si no añadimos y salimos del bucle
                            jugadas.add(tablero[fila + i][columna - i]);
                            break;
                        }
                    }
                }
            }
        }

        return jugadas;
    }
    private ArrayList<StackPane> calcular_casillas_atacadas_caballo(StackPane casilla) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        String jugada1 = "";

        // El caballo puede mover hasta en ocho casillas

        // Posible jugada 1 (arriba derecaha1)
        if (columna <= 6 && fila >= 2) {
            jugadas.add(tablero[fila -2][columna+1]);
        }

        // Posible jugada 2 (arriba derecaha2)
        if (columna <= 5 && fila >= 1) {
            jugadas.add(tablero[fila - 1][columna +  2]);
        }

        // Posible jugada 3 (arriba izquierda1)
        if (columna >= 1 && fila >= 2) {
            jugadas.add(tablero[fila - 2][columna - 1]);
        }

        // Posible jugada 4 (arriba izquierda2)
        if (columna >= 2 && fila >= 1) {
            jugadas.add(tablero[fila - 1][columna - 2]);
        }

        // Posible jugada 5 (abajo derecaha1)
        if (columna <= 6 && fila <= 5) {
            jugadas.add(tablero[fila + 2][columna + 1]);
        }

        // Posible jugada 6 (abajo derecaha2)
        if (columna <= 5 && fila <= 6) {
            jugadas.add(tablero[fila + 1][columna + 2]);
        }

        // Posible jugada 7 (abajo izquierda1)
        if (columna >= 1 && fila <= 5) {
            jugadas.add(tablero[fila + 2][columna - 1]);
        }

        // Posible jugada 8 (abajo izquierda2)
        if (columna >= 2 && fila <= 6) {
            jugadas.add(tablero[fila + 1][columna - 2]);
        }

        return jugadas;
    }
    private ArrayList<StackPane> calcular_casillas_atacadas_peon(StackPane casilla, String [] pieza_array) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        if (pieza_array[1].equals("Blanco")) { // El peón es blanco
            if (fila >= 1 && fila <= 6) {
                if (columna >= 1) {
                    jugadas.add(tablero[fila - 1][columna - 1]);
                }
                if (columna <= 6) {
                    jugadas.add(tablero[fila - 1][columna + 1]);
                }
            }
        } else { // El peón es negro
            if (fila >= 1 && fila <= 6) {
                if (columna >= 1) {
                    jugadas.add(tablero[fila + 1][columna - 1]);
                }
                if (columna <= 6) {
                    jugadas.add(tablero[fila + 1][columna + 1]);
                }
            }
        }
        return jugadas;
    }
    private ArrayList<StackPane> calcular_casillas_atacadas_reina(StackPane casilla) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        // La reina es como si fuese un Alfil y una torre a la vez
        // Así que calculamos los ataques como si fuese cada uno de ellos y los unimos
        ArrayList<StackPane> jugadas_alfil = calcular_casillas_atacadas_alfil(casilla);
        ArrayList<StackPane> jugadas_torre = calcular_casillas_atacadas_torre(casilla);

        for (int i = 0; i < jugadas_alfil.size(); i ++) {
            jugadas.add(jugadas_alfil.get(i));
        }

        for (int i = 0; i < jugadas_torre.size(); i ++) {
            jugadas.add(jugadas_torre.get(i));
        }
        return jugadas;
    }
    private ArrayList<StackPane> calcular_casillas_atacadas_rey(StackPane casilla) {
        ArrayList<StackPane> jugadas = new ArrayList<>();

        int fila = recibir_coordenadas_pieza(casilla)[0];
        int columna = recibir_coordenadas_pieza(casilla)[1];;

        String pieza_posible_jugada = "";
        String [] pieza_posibles_jugada_array = null;

        if ((fila - 1) >= 0) {
            if ((columna + 1) <= 7) { // Atacar hacia arriba a la derecha
                jugadas.add(tablero[fila - 1][columna + 1]);
            }
            if ((columna - 1) >= 0) { // Atacar hacia arriba a la izquierda
                jugadas.add(tablero[fila - 1][columna - 1]);
            }

            // Atacar hacia arriba
            jugadas.add(tablero[fila - 1][columna]);
        }

        if ((fila + 1) <= 7) {
            if ((columna + 1) <= 7) { // Atacar hacia abajo a la derecha
                jugadas.add(tablero[fila + 1][columna + 1]);
            }
            if ((columna - 1) >= 0) { // Atacar hacia abajo a la izquierda
                jugadas.add(tablero[fila + 1][columna - 1]);
            }

            // Atacar hacia abajo
            jugadas.add(tablero[fila + 1][columna]);
        }

        // Atacar hacia la derecha
        if (columna <= 6) {
            jugadas.add(tablero[fila][columna + 1]);
        }

        // Atacar hacia la izquierda
        if (columna >= 1) {
            jugadas.add(tablero[fila][columna - 1]);
        }

        return jugadas;
    }
    private int [] recibir_coordenadas_pieza(StackPane casilla) {
        int [] fila_y_columna = new int[2];
        int fila = 0;
        int columna = 0;
        // Recibimos la posición del StackPane (Seguro que hay formas más óptimas de hacerlo)
        for (int i = 0; i < tablero.length; i ++) {
            for (int j = 0; j < tablero[0].length; j ++) {
                // System.out.print(tablero[i][j] + " ");
                if (tablero[i][j] == casilla) {
                    // System.out.print(tablero[i][j] + " ");
                    fila = i;
                    columna = j;
                    // System.out.print("Fila " + fila + " Columna " + columna);
                }
                // System.out.println(" ");
            }
        }

        fila_y_columna[0] = fila;
        fila_y_columna[1] = columna;

        return fila_y_columna;
    }
    private String [][] copia_tablero = new String [8][8];
    private void hacer_copia_del_tablero () {
        for (int i = 0; i < tablero.length; i ++) {
            for (int j = 0; j < tablero[0].length; j ++) {
                copia_tablero[i][j] = validate_cell(tablero[i][j]);
            }
        }
    }
    @FXML
    private Button boton_volver;
    @FXML
    private void volver_atras () {
        System.out.println("Volver atrás");

        limpiar_colores();

        // Añadimos este int para que sólo se pueda volver una vez
        int nunTiradasAnterior = numTiradas;

        numTiradas --;

        // Ocultamos el botón
        if (numTiradas < nunTiradasAnterior) {
            boton_volver.setVisible(false);
        }

        if ((numTiradas % 2) == 0) {
            turn_image.setImage(image_array[0][1]);
            turn_label.setText("Juegan las blancas");
        } else {
            turn_image.setImage(image_array[1][1]);
            turn_label.setText("Juegan las negras");
        }

        for (int i = 0; i < copia_tablero.length; i ++) {
            for (int j = 0; j < copia_tablero[0].length; j ++) {
                if (copia_tablero[i][j].isEmpty()) { // Si la casilla no tiene pieza
                    vaciar_Image_view(tablero[i][j]);
                } else {
                    ImageView contenedor_imagen;
                    for (Node node : tablero[i][j].getChildren()) {
                        if (node instanceof ImageView) {
                            contenedor_imagen = (ImageView) node;

                            if (copia_tablero[i][j].equals("Peon Negro")) {
                                contenedor_imagen.setImage(image_array[1][1]);
                            } else if (copia_tablero[i][j].equals("Peon Blanco")) {
                                contenedor_imagen.setImage(image_array[0][1]);
                            } else if (copia_tablero[i][j].equals("Caballo Blanco")) {
                                contenedor_imagen.setImage(image_array[0][3]);
                            } else if (copia_tablero[i][j].equals("Caballo Negro")) {
                                contenedor_imagen.setImage(image_array[1][3]);
                            } else if (copia_tablero[i][j].equals("Alfil Blanco")) {
                                contenedor_imagen.setImage(image_array[0][2]);
                            } else if (copia_tablero[i][j].equals("Alfil Negro")) {
                                contenedor_imagen.setImage(image_array[1][2]);
                            } else if (copia_tablero[i][j].equals("Torre Blanco")) {
                                contenedor_imagen.setImage(image_array[0][4]);
                            } else if (copia_tablero[i][j].equals("Torre Negro")) {
                                contenedor_imagen.setImage(image_array[1][4]);
                            } else if (copia_tablero[i][j].equals("Reina Blanco")) {
                                contenedor_imagen.setImage(image_array[0][5]);
                            } else if (copia_tablero[i][j].equals("Reina Negro")) {
                                contenedor_imagen.setImage(image_array[1][5]);
                            } else if (copia_tablero[i][j].equals("Rey Blanco")) {
                                contenedor_imagen.setImage(image_array[0][6]);
                            } else if (copia_tablero[i][j].equals("Rey Negro")) {
                                contenedor_imagen.setImage(image_array[1][6]);
                            }
                        }
                    }
                }
            }
        }
        verificar_jaque("Blanco");
        verificar_jaque("Negro");
    }
    private void vaciar_Image_view (StackPane stackPane) {
        ImageView contenedor_imagen;
        for (Node node : stackPane.getChildren()) {
            if (node instanceof ImageView) {
                contenedor_imagen = (ImageView) node;
                contenedor_imagen.setImage(null);
            }
        }
    }
    private void poner_imagen_Image_view (StackPane stackPane, Image imagen) {
        ImageView contenedor_imagen;
        for (Node node : stackPane.getChildren()) {
            if (node instanceof ImageView) {
                contenedor_imagen = (ImageView) node;
                contenedor_imagen.setImage(imagen);
            }
        }
    }
    // Funciones que se ejecutaran al pulsar el botón de escoger pieza
    // Para cuando haya un peón se ponga el la última fila
    @FXML
    private void escoger_torre_función () {
        System.out.println("Escoge torre");

        if (!((numTiradas % 2) == 0)) { // Si le toca a las blancas (desigual porque ya le hemos sumado la tirada)
            imagen_escogida = image_array[0][4]; // Torre blanca
        } else { // Si le toca a las negras
            imagen_escogida = image_array[1][4]; // Torre negra
        }

        poner_imagen_Image_view(donde_va_la_imagen, imagen_escogida);

        // Ocultamos los botones
        escoger_caballo_id.setVisible(false);
        escoger_alfil_id.setVisible(false);
        escoger_torre_id.setVisible(false);
        escoger_reina_id.setVisible(false);

        tiene_que_escoger = false;
    }
    @FXML
    private void escoger_alfil_función () {
        System.out.println("Escoge alfil");

        if (!((numTiradas % 2) == 0)) { // Si le toca a las blancas
            imagen_escogida = image_array[0][2]; // Alfil blanco
        } else { // Si le toca a las negras
            imagen_escogida = image_array[1][2]; // Alfil negro
        }

        poner_imagen_Image_view(donde_va_la_imagen, imagen_escogida);

        // Ocultamos los botones
        escoger_caballo_id.setVisible(false);
        escoger_alfil_id.setVisible(false);
        escoger_torre_id.setVisible(false);
        escoger_reina_id.setVisible(false);

        tiene_que_escoger = false;
    }
    @FXML
    private void escoger_caballo_función () {
        System.out.println("Escoge caballo");

        if (!((numTiradas % 2) == 0)) { // Si le toca a las blancas
            imagen_escogida = image_array[0][3]; // Caballo blanco
        } else { // Si le toca a las negras
            imagen_escogida = image_array[1][3]; // Caballo negro
        }

        poner_imagen_Image_view(donde_va_la_imagen, imagen_escogida);

        // Ocultamos los botones
        escoger_caballo_id.setVisible(false);
        escoger_alfil_id.setVisible(false);
        escoger_torre_id.setVisible(false);
        escoger_reina_id.setVisible(false);

        tiene_que_escoger = false;
    }
    @FXML
    private void escoger_reina_función () {
        System.out.println("Escoge reina");

        if (!((numTiradas % 2) == 0)) { // Si le toca a las blancas
            imagen_escogida = image_array[0][5]; // Reina blanca
        } else { // Si le toca a las negras
            imagen_escogida = image_array[1][5]; // Reina negra
        }

        poner_imagen_Image_view(donde_va_la_imagen, imagen_escogida);

        // Ocultamos los botones
        escoger_caballo_id.setVisible(false);
        escoger_alfil_id.setVisible(false);
        escoger_torre_id.setVisible(false);
        escoger_reina_id.setVisible(false);

        tiene_que_escoger = false;
    }
}
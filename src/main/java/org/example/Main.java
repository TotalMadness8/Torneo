package org.example;

import org.example.Clases.Equipo;
import org.example.Clases.Jugador;
import org.example.Clases.Llaves;
import org.example.Clases.Rondas;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {


        JOptionPane.showMessageDialog(null, "Bienvenidos al torneo!", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);

        menu();
    }

    public static void mostrarOpciones() {
        JOptionPane.showMessageDialog(null, "Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "0. Salir", "Opciones", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void menu() {
        JOptionPane.showMessageDialog(null, "Bienvenido al Menu\nSelecciona una de las siguientes opciones:");

        // Se inicializan las variables que se utilizarán durante la ejecución del programa.

        boolean salir = true;
        ArrayList<Equipo> listaDeEquipos = null;
        Jugador jugador = null;
        Llaves llaveDerecha = null;
        Llaves llaveIzquierda = null;
        Rondas ronda = null;
        String opcion = "";

        do {
            mostrarOpciones();

            // Se utiliza la función mostrarOpciones() para mostrar las opciones disponibles.

            opcion = JOptionPane.showInputDialog(null, "Ingrese la opcion: ",
                    "Ingreso opcion", JOptionPane.INFORMATION_MESSAGE);
            switch (opcion) {
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa", "Salida", JOptionPane.INFORMATION_MESSAGE);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingreso invalido");
            }

        } while (salir);
    }

    //Se crea la lista de equipos

    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {

        if (listaDeEquipos == null) {

            JOptionPane.showMessageDialog(null, "Lista creada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            return new ArrayList<>();

        } else {

            JOptionPane.showMessageDialog(null, "Ya hay una lista de equipos", "Error", JOptionPane.INFORMATION_MESSAGE);
            return listaDeEquipos;
        }
    }

    //Se agregan los equipos a la lista

    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {

        String siNo = "";

        if (listaDeEquipos.size() == 0) {

            siNo = JOptionPane.showInputDialog(null, "¿Desea ingresar una lista de equipos manualmente? S/N", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            siNo = siNo.toUpperCase();

            if (siNo.equals("N")) {

                listaDeEquipos.add(new Equipo("Brasil"));
                listaDeEquipos.add(new Equipo("Croacia"));
                listaDeEquipos.add(new Equipo("Inglaterra"));
                listaDeEquipos.add(new Equipo("Francia"));
                listaDeEquipos.add(new Equipo("Portugal"));
                listaDeEquipos.add(new Equipo("Marruecos"));
                listaDeEquipos.add(new Equipo("Paises Bajos"));
                listaDeEquipos.add(new Equipo("Argentina"));

                JOptionPane.showMessageDialog(null, "Lista de equipos creada automaticamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            } else if (siNo.equals("S")) {
                cargarEquipoManualmente(listaDeEquipos);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya hay una lista de equipos creada o la opción ingresada no es valida", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

        //Creador del jugador y elección de un equipo

    public static Jugador elegirEquipo (ArrayList < Equipo > listaDeEquipos) {

        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos);

        return jugador;

    }

    //Se crea la llave derecha

    public static Llaves crearLlaveDerecha (ArrayList < Equipo > listaDeEquipos) {

        Llaves llaveDerecha = new Llaves();
        llaveDerecha.armarLlave(listaDeEquipos, 4);
        JOptionPane.showMessageDialog(null, "Llave derecha creada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        return llaveDerecha;
    }

    //Se crea la llave izquierda

    public static Llaves crearLlaveIzquierda (ArrayList < Equipo > listaDeEquipos) {

        Llaves llaveIzquierda = new Llaves();
        llaveIzquierda.armarLlave(listaDeEquipos, 0);
        JOptionPane.showMessageDialog(null, "Llave izquierda creada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

        return llaveIzquierda;
    }

    //Se crea la ronda

    public static Rondas crearRondas () {

        JOptionPane.showMessageDialog(null, "Rondas creadas", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        return new Rondas();
    }

    //Se juegan los partidos segun las llaves izquierda y derecha

    public static void jugarTorneo (Rondas ronda, Llaves llaveIzquierda, Llaves llaveDerecha, Jugador jugador){
        //Cuartos
        ronda.cuartosDeFinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        //Semi
        ronda.semifinal(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        //Final
        ronda.finalDelTorneo(llaveIzquierda, llaveDerecha);
        jugador.sumarPuntos();
        }

    //Se muestra la cantidad de puntos obtenidas por el jugador

    public static void resultadoDelTorneo (Jugador jugador){

        JOptionPane.showMessageDialog(null, "Has conseguido " + jugador.getPuntaje() + " puntos por elejir al equipo: "
                + jugador.getEquipoSeleciconado().getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    //Creacion manual de la lista de equipos

    public static void cargarEquipoManualmente (ArrayList < Equipo > listaDeEquipos) {

        for (int i = 0; i < 8; i++) {
            listaDeEquipos.add(new Equipo(JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo " + (i + 1) + "/8", "Selección de equipo", JOptionPane.INFORMATION_MESSAGE)));
        }
        JOptionPane.showMessageDialog(null, "Lista de equipos completada", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }
    }
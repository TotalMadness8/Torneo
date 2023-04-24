package org.example.Clases;

import javax.swing.*;
import java.util.List;

public class Rondas {

    //Atributos

    private int numeroDeRonda;
    private int cantidadDeEquiposEnRonda;
    private int cantidadDeEquiposEnLlave;

    //Constructores


    public Rondas() {
    }

    public Rondas(int numeroDeRonda, int cantidadDeEquiposEnRonda, int cantidadDeEquiposEnLlave) {
        this.numeroDeRonda = numeroDeRonda;
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    //Getter Setter


    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setNumeroDeRonda(int numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposEnRonda;
    }

    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposEnRonda) {
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }

    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }

    //Metodos

    //Cuartos de final

    public void cuartosDeFinal(Llaves llaveIzquierda, Llaves llaveDerecha){

        //Se especifica el numero de ronda y cantidad de equipos por llave

        this.numeroDeRonda = 1;
        this.cantidadDeEquiposEnLlave = 4;

        //Se instancia un objeto para usar sus metodos

        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null,"Se jugaran los cuartos de final!","Cuartos de final",JOptionPane.INFORMATION_MESSAGE);

        //Simulacion de los partidos de cada llave

        for (int i = 0; i < cantidadDeEquiposEnLlave; i+=2) {

            partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i), llaveIzquierda.getEquiposDeLaLlave().get(i+1));

            partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i), llaveDerecha.getEquiposDeLaLlave().get(i+1));
        }
        //Eliminacion de los equipos perdedores

        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());

        //Actualizacion de cantidad de equipos por llave

        this.cantidadDeEquiposEnLlave = 2;
    }
    public void removerEquipos(List<Equipo> equipos){

        int contadorDeEquiposPorLlave = cantidadDeEquiposEnLlave;

        for (int i = 0; i < contadorDeEquiposPorLlave; i++) {

            Equipo auxiliar = equipos.get(i);

            if(!auxiliar.isAutorizacion()){

                equipos.remove(auxiliar);
                contadorDeEquiposPorLlave--;
            }
        }
    }

    //Semifinales
    public void semifinal(Llaves llaveIzquierda, Llaves llaveDerecha){

        //Especificacion de numero de ronda

        this.numeroDeRonda = 2;

        //Se instancia un objeto para usar sus metodos

        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null,"Se jugaran las semifinales!", "Semifinal",JOptionPane.INFORMATION_MESSAGE);

        //Simulacion de partidos en cada llave

        partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0),
                llaveDerecha.getEquiposDeLaLlave().get(1));

        partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(1));

        //Eliminacion de los equipos perdedores

        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
    }

    //Final
    public void finalDelTorneo(Llaves llaveIzquierda, Llaves llaveDerecha){

        //Especifucacion de numero de ronda

        this.numeroDeRonda = 3;

        //Se instancia un objeto para usar sus metodos

        Partido partido = new Partido();

        JOptionPane.showMessageDialog(null,"Se jugara la final!", "Final",JOptionPane.INFORMATION_MESSAGE);

        //Se simula el partido final

        Equipo equipo = partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0),
                llaveDerecha.getEquiposDeLaLlave().get(0));

        //Se muestra un mensaje mostrando al ganador

        JOptionPane.showMessageDialog(null,"El ganador del torneo es: " + equipo.getNombre(),"Ganador del torneo", JOptionPane.INFORMATION_MESSAGE);


    }
}

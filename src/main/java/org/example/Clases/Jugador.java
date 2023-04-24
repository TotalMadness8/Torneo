package org.example.Clases;

import javax.swing.*;
import java.util.List;

public class Jugador {

    //Atributos

    private Equipo equipoSeleciconado;
    private int puntaje;

    //Constructores


    public Jugador() {
    }

    public Jugador(Equipo equipoSeleciconado, int puntaje) {
        this.equipoSeleciconado = equipoSeleciconado;
        this.puntaje = puntaje;
    }

    //Getter Setter


    public Equipo getEquipoSeleciconado() {
        return equipoSeleciconado;
    }

    public void setEquipoSeleciconado(Equipo equipoSeleciconado) {
        this.equipoSeleciconado = equipoSeleciconado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    //Metodos

    public void elegirEquipo(List<Equipo> listaEquipos){

        //Se muestran los equipos por pantalla

        String listaDeLosEquiposEnMensaje="Seleccione su equipo: \n";

        for (int i = 0; i < listaEquipos.size(); i++) {
            listaDeLosEquiposEnMensaje+= (i+1) + ", " + listaEquipos.get(i).getNombre() + "\n";

        }
        JOptionPane.showMessageDialog(null,listaDeLosEquiposEnMensaje,"Seleccion", JOptionPane.INFORMATION_MESSAGE);

        //Se ingresa el indice del equipo a elejir asegurandose de que el valor ingresado sea valido

        int indiceEquipo = 0;

        do {
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice de equipo que quiera seleccionar","Seleccion",JOptionPane.INFORMATION_MESSAGE))-1;
        } while (indiceEquipo < 0 || indiceEquipo > 7);

        //Confirmación de selección

        JOptionPane.showMessageDialog(null,"El equipo que elejiste es: " + listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleciconado = listaEquipos.get(indiceEquipo);

    }
        //Sumador de puntos del jugador
    public void sumarPuntos(){
        if (equipoSeleciconado.isAutorizacion()){
            puntaje++;
        }
    }
}



package org.example.Clases;

import org.example.Resultado.Resultado;

import javax.swing.*;

public class Partido {

    //Atributos

    private int golesEquipoLocal=2;
    private int golesEquipoVisitante=3;

    //Constructores


    public Partido() {
    }

    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    //Getter Setter


    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    //Funciones

    //Simulacion del partido

    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante){

        //Mensaje con los resultados del partido

        JOptionPane.showMessageDialog(null,equipoLocal.getNombre() + " "
                + this.golesEquipoLocal + " - " + this.golesEquipoVisitante + " " + equipoVisitante.getNombre()
        ,"Resultado",JOptionPane.INFORMATION_MESSAGE);

        //Se le suman los goles a los equipos

        equipoLocal.nuevosGoles(this.golesEquipoLocal);
        equipoVisitante.nuevosGoles(this.golesEquipoVisitante);

        //Logica del partido

        if (this.golesEquipoLocal>this.golesEquipoVisitante){

            equipoLocal.setResultadoPartido(Resultado.GANADOR);
            equipoVisitante.setResultadoPartido(Resultado.PERDEDOR);
            equipoVisitante.setAutorizacion(false);

            return equipoLocal;

        } else if (this.golesEquipoVisitante == this.golesEquipoLocal){

            JOptionPane.showMessageDialog(null,"Se jugara el desempate entre "
                    + equipoLocal.getNombre() + " y " + equipoVisitante.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE);

            equipoLocal.setResultadoPartido(Resultado.EMPATE);
            equipoVisitante.setResultadoPartido(Resultado.EMPATE);

            simularPartido(equipoLocal, equipoVisitante);

        } else {
            equipoLocal.setAutorizacion(false);
            equipoVisitante.setResultadoPartido(Resultado.GANADOR);
            equipoLocal.setResultadoPartido(Resultado.PERDEDOR);

            return equipoVisitante;
        }

        return null;
    }

}

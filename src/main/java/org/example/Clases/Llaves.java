package org.example.Clases;

import java.util.ArrayList;
import java.util.List;

public class Llaves {

    //Atributos

    private List<Equipo> equiposDeLaLlave;
    private String nombreDeLaLlave;

    //Constructores

    public Llaves() {
    }

    public Llaves(List<Equipo> equiposDeLaLlave, String nombreDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    //Getter Setter


    public List<Equipo> getEquiposDeLaLlave() {
        return equiposDeLaLlave;
    }

    public void setEquiposDeLaLlave(List<Equipo> equiposDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
    }

    public String getNombreDeLaLlave() {
        return nombreDeLaLlave;
    }

    public void setNombreDeLaLlave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    //Métodos
    //Armar llaves

    public void armarLlave(List<Equipo> listaGeneral, int indiceInicial){

        List<Equipo> equiposLlave = new ArrayList<>();

        for (int i = indiceInicial; i < indiceInicial+4 ; i++) {
            equiposLlave.add(listaGeneral.get(i));
        }

        this.equiposDeLaLlave = equiposLlave;
    }


}

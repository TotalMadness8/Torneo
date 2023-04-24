package org.example.Clases;

import org.example.Resultado.Resultado;

public class Equipo {

    //Atributos

    private String nombre;
    private boolean autorizacion = true;
    private Resultado resultadoPartido;
    private int cantidadGoles;

    //constructores

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, boolean autorizacion, Resultado resultadoPartido, int cantidadGoles) {
        this.nombre = nombre;
        this.autorizacion = autorizacion;
        this.resultadoPartido = resultadoPartido;
        this.cantidadGoles = cantidadGoles;
    }

    //Getter Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultadoPartido() {
        return resultadoPartido;
    }

    public void setResultadoPartido(Resultado resultadoPartido) {
        this.resultadoPartido = resultadoPartido;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    //Metodo
    public void nuevosGoles (int nuevosGoles){
        this.cantidadGoles+=nuevosGoles;
    }

}

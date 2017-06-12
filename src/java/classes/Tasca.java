/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor
 */

public class Tasca implements Serializable {

    public static ArrayList<Tasca> tasques;

    private String nomProjecte;
    private String nomTasca;
    private String descripcio;
    private int durada;
    private boolean realitzada;

    public Tasca(String nomProjecte, String nomTasca, String descripcio, int durada, boolean realitzada) {
        this.nomProjecte = nomProjecte;
        this.nomTasca = nomTasca;
        this.descripcio = descripcio;
        this.durada = durada;
        this.realitzada = realitzada;
    }

    public String getNomProjecte() {
        return nomProjecte;
    }

    public void setNomProjecte(String nomProjecte) {
        this.nomProjecte = nomProjecte;
    }

    public String getNomTasca() {
        return nomTasca;
    }

    public void setNomTasca(String nomTasca) {
        this.nomTasca = nomTasca;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public boolean isRealitzada() {
        return realitzada;
    }

    public void setRealitzada(boolean realitzada) {
        this.realitzada = realitzada;
    }

    @Override
    public String toString() {
        return "Tasca{" + "Projecte=" + nomProjecte + ", Tasca=" + nomTasca + ", descripcio=" + descripcio + ", duracio=" + durada + ", realitzada=" + realitzada + '}';
    }

}

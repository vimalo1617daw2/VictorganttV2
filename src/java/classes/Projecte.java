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
public class Projecte implements Serializable {

    public static ArrayList<Projecte> projectes;

    private String nomProjecte;
    private String descripcio;
    private String fechaInicial;
    private String fechaFinal;
    private int dias;

    public Projecte(String nomProjecte, String descripcio, String fechaInicial, String fechaFinal, int dias) {
        this.nomProjecte = nomProjecte;
        this.descripcio = descripcio;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNomProjecte() {
        return nomProjecte;
    }

    public void setNomProjecte(String nomProjecte) {
        this.nomProjecte = nomProjecte;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Projecte{" + "Projecte=" + nomProjecte + ", descripcio=" + descripcio + ", fechaIn=" + fechaInicial + ", fechaFi=" + fechaFinal + ", dies=" + dias + '}';
    }

}

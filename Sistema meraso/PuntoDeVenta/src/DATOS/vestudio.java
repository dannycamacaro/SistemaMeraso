/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

/**
 *
 * @author user
 */
public class vestudio {
    public int codigoEstudio;
    public String nombreEstudio;
    public double precio;
    public int codigoCategoria;

    public vestudio(int codigoEstudio, String nombreEstudio, double precio, int codigoCategoria) {
        this.codigoEstudio = codigoEstudio;
        this.nombreEstudio = nombreEstudio;
        this.precio = precio;
        this.codigoCategoria = codigoCategoria;
    }

    public vestudio() {
    }

    public int getCodigoEstudio() {
        return codigoEstudio;
    }

    public void setCodigoEstudio(int codigoEstudio) {
        this.codigoEstudio = codigoEstudio;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

}

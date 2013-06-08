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
public class vestudiosInstitucion {
    public int numeroEstudio;
    public int codigoEstudios;
    public int codigoOrganizacion;
    public String nombre;
    public Double precios;
    public int categoria;

    public vestudiosInstitucion(int numeroEstudio, int codigoEstudios, int codigoOrganizacion, String nombre, Double precios, int categoria) {
        this.numeroEstudio = numeroEstudio;
        this.codigoEstudios = codigoEstudios;
        this.codigoOrganizacion = codigoOrganizacion;
        this.nombre = nombre;
        this.precios = precios;
        this.categoria = categoria;
    }

    public vestudiosInstitucion() {
    }

    public int getNumeroEstudio() {
        return numeroEstudio;
    }

    public void setNumeroEstudio(int numeroEstudio) {
        this.numeroEstudio = numeroEstudio;
    }

    public int getCodigoEstudios() {
        return codigoEstudios;
    }

    public void setCodigoEstudios(int codigoEstudios) {
        this.codigoEstudios = codigoEstudios;
    }

    public int getCodigoOrganizacion() {
        return codigoOrganizacion;
    }

    public void setCodigoOrganizacion(int codigoOrganizacion) {
        this.codigoOrganizacion = codigoOrganizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecios() {
        return precios;
    }

    public void setPrecios(Double precios) {
        this.precios = precios;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
}

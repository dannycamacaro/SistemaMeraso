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
public class vdetalleSolicitud {
    public int numeroDetalle;
    public int numeroSolicitud;
    public int numeroEstudio;

    public vdetalleSolicitud(int numeroDetalle, int numeroSolicitud, int numeroEstudio) {
        this.numeroDetalle = numeroDetalle;
        this.numeroSolicitud = numeroSolicitud;
        this.numeroEstudio = numeroEstudio;
    }

    public vdetalleSolicitud() {
    }

    public int getNumeroDetalle() {
        return numeroDetalle;
    }

    public void setNumeroDetalle(int numeroDetalle) {
        this.numeroDetalle = numeroDetalle;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(int numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public int getNumeroEstudio() {
        return numeroEstudio;
    }

    public void setNumeroEstudio(int numeroEstudio) {
        this.numeroEstudio = numeroEstudio;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author user
 */
public class vcaja {
     public Date fecha;
    public String turno;
    public Double totalEstudio;
    public int codigoSolicitud; 
    public String nombrePaciente;

    public vcaja(Date fecha, String turno, Double totalEstudio, int codigoSolicitud, String nombrePaciente) {
        this.fecha = fecha;
        this.turno = turno;
        this.totalEstudio = totalEstudio;
        this.codigoSolicitud = codigoSolicitud;
        this.nombrePaciente = nombrePaciente;
    }

    public vcaja() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Double getTotalEstudio() {
        return totalEstudio;
    }

    public void setTotalEstudio(Double totalEstudio) {
        this.totalEstudio = totalEstudio;
    }

    public int getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(int codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    

    
}

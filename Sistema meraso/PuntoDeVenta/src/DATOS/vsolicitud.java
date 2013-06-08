/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

import java.sql.Date;

/**
 *
 * @author user
 */
public class vsolicitud {
    public int numeroSolicitud;
    public Date fecha;
    public String turno;
    public int codigoInstitucion;
    public int codigoPaciente;
    public String numeroReferencia;

    public vsolicitud(int numeroSolicitud, Date fecha, String turno, int codigoInstitucion, int codigoPaciente, String numeroReferencia) {
        this.numeroSolicitud = numeroSolicitud;
        this.fecha = fecha;
        this.turno = turno;
        this.codigoInstitucion = codigoInstitucion;
        this.codigoPaciente = codigoPaciente;
        this.numeroReferencia = numeroReferencia;
    }

    public vsolicitud() {
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(int numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
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

    public int getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(int codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }
     
}

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
public class vrecibo {
    public int numeroFactura;
    public String numeroControl;
    public Date fecha;
    public String hora;
    public String razonSocial;
    public String rifCedula;
    public String direccion;
    public String telefono;
    public Double iva;
    public Double subTotal;
    public Double total;
    public Double descuento;
    public String observacion;
    public int numeroSolicitud;

    public vrecibo(int numeroFactura, String numeroControl, Date fecha, String hora, String razonSocial, String rifCedula, String direccion, String telefono, Double iva, Double subTotal, Double total, Double descuento, String observacion, int numeroSolicitud) {
        this.numeroFactura = numeroFactura;
        this.numeroControl = numeroControl;
        this.fecha = fecha;
        this.hora = hora;
        this.razonSocial = razonSocial;
        this.rifCedula = rifCedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.iva = iva;
        this.subTotal = subTotal;
        this.total = total;
        this.descuento = descuento;
        this.observacion = observacion;
        this.numeroSolicitud = numeroSolicitud;
    }

    public vrecibo() {
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRifCedula() {
        return rifCedula;
    }

    public void setRifCedula(String rifCedula) {
        this.rifCedula = rifCedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(int numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }
    
    
    
    
    
    
    
}

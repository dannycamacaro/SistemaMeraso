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
public class vfactura {
    public int numeroFactura;
    public String numeroControl;
    public Date fecha;
    public Time hora;
    public String razonSocial;
    public String rifCedula;
    public String direccion;
    public String telefono;
    public Double iva;
    public Double subtotal;
    public Double total;
    public Double descuento;
    public String observaciones;
    public int numeroSolicitud;
    public int alicuota;

    public vfactura(int numeroFactura, String numeroControl, Date fecha, Time hora, String razonSocial, String rifCedula, String direccion, String telefono, Double iva, Double subtotal, Double total, Double descuento, String observaciones, int numeroSolicitud, int alicuota) {
        this.numeroFactura = numeroFactura;
        this.numeroControl = numeroControl;
        this.fecha = fecha;
        this.hora = hora;
        this.razonSocial = razonSocial;
        this.rifCedula = rifCedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
        this.descuento = descuento;
        this.observaciones = observaciones;
        this.numeroSolicitud = numeroSolicitud;
        this.alicuota = alicuota;
    }

    public vfactura() {
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(int numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public int getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(int alicuota) {
        this.alicuota = alicuota;
    }
    

}

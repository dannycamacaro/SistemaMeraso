/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

public class vcontrol {
    public long numeroControl;
    public int factura;

    public vcontrol(long numeroControl, int factura) {
        this.numeroControl = numeroControl;
        this.factura = factura;
    }

    public vcontrol() {
    }

    public long getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(long numeroControl) {
        this.numeroControl = numeroControl;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

 

    
}

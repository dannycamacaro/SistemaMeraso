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
public class vimpresora {
    public int codigoImpresora;
    public String nombreImpresora;
    public String direccionImpresora;

    public vimpresora(int codigoImpresora, String nombreImpresora, String direccionImpresora) {
        this.codigoImpresora = codigoImpresora;
        this.nombreImpresora = nombreImpresora;
        this.direccionImpresora = direccionImpresora;
    }

    public vimpresora() {
    }

    public int getCodigoImpresora() {
        return codigoImpresora;
    }

    public void setCodigoImpresora(int codigoImpresora) {
        this.codigoImpresora = codigoImpresora;
    }

    public String getNombreImpresora() {
        return nombreImpresora;
    }

    public void setNombreImpresora(String nombreImpresora) {
        this.nombreImpresora = nombreImpresora;
    }

    public String getDireccionImpresora() {
        return direccionImpresora;
    }

    public void setDireccionImpresora(String direccionImpresora) {
        this.direccionImpresora = direccionImpresora;
    }
    
    
}

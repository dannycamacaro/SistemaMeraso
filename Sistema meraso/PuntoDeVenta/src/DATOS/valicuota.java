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
public class valicuota {
    public int codigoAlicuota;
    public String valor;
    public double porcentaje;

    public valicuota(int codigoAlicuota, String valor, double porcentaje) {
        this.codigoAlicuota = codigoAlicuota;
        this.valor = valor;
        this.porcentaje = porcentaje;
    }

    public valicuota() {
    }

    public int getCodigoAlicuota() {
        return codigoAlicuota;
    }

    public void setCodigoAlicuota(int codigoAlicuota) {
        this.codigoAlicuota = codigoAlicuota;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}

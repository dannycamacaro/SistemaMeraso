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
public class vinstitucion {
    public int codigoInstitucion;
    public String nombreInstitucion;
    public String rif;
    public String direccion;
    public String telefono;
    public String contactoOrganizacion;
    public String telefonoContacto;
    public String cargoContacto;

    public vinstitucion(int codigoInstitucion, String nombreInstitucion, String rif, String direccion, String telefono, String contactoOrganizacion, String telefonoContacto, String cargoContacto) {
        this.codigoInstitucion = codigoInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.rif = rif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contactoOrganizacion = contactoOrganizacion;
        this.telefonoContacto = telefonoContacto;
        this.cargoContacto = cargoContacto;
    }

    public vinstitucion() {
    }

    public int getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(int codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
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

    public String getContactoOrganizacion() {
        return contactoOrganizacion;
    }

    public void setContactoOrganizacion(String contactoOrganizacion) {
        this.contactoOrganizacion = contactoOrganizacion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }
    
    
}

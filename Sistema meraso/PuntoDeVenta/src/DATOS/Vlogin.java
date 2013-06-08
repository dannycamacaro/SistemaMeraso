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
public class Vlogin {
        public int codigoUsuario;
        public String cedula;
        public String nombre;
        public String clave;
        public String privilegio; 

        
        /*
            constructor de el login y el usuario 
        */
    public Vlogin(int codigoUsuario, String cedula, String nombre, String clave, String privilegio) {
        this.codigoUsuario = codigoUsuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.privilegio = privilegio;
    }

    /*
        constructor vacio para inicializar el usuario
    */
    public Vlogin() {
        
    }

    
    /*
        metodos de envio y recepcion de valores
    */
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }
    
    
        

    
}

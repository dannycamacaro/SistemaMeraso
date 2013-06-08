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
public class vusuario {
    
    //declaracion de variables tabla usuario
        public int codigoUsuario;
        public String nombre;
        public String clave;
        public String privilegio; 

        
        /*
            constructor de el login y el usuario 
        */
    public vusuario(int codigoUsuario, String nombre, String clave, String privilegio) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.privilegio = privilegio;
    }

    /*
        constructor vacio para inicializar el usuario
    */

    public vusuario() {
        
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

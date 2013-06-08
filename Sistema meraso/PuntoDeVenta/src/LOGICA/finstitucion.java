/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vestudiosInstitucion;
import DATOS.vinstitucion;
import DATOS.vusuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class finstitucion {
    
    
    
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    public int tamano;
    
    
    public DefaultTableModel mostrarInstitucion (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO INST.","NOMBRE","RIF","DIRECCION","TELEFONO","CONTACTO","TELEFONO CONTACTO","CARGO CONTACTO"};
        String [] registros = new String[8];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from institucion where codigoInstitucion like '%"+ buscar +"%' order by codigoInstitucion";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoInstitucion");
               registros[1]=rs.getString("nombreInstitucion");
               registros[2]=rs.getString("rif");
               registros[3]=rs.getString("direccion");
               registros[4]=rs.getString("telefono");
               registros[5]=rs.getString("contactoOrganizacion");
               registros[6]=rs.getString("telefonoContacto");
               registros[7]=rs.getString("cargoContacto");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
        public DefaultTableModel mostrarInstitucion2 (String parametro,String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO INST.","NOMBRE","RIF","DIRECCION","TELEFONO","CONTACTO","TELEFONO CONTACTO","CARGO CONTACTO"};
        String [] registros = new String[8];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from institucion where  "+parametro+" like '%"+buscar+"%' ";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoInstitucion");
               registros[1]=rs.getString("nombreInstitucion");
               registros[2]=rs.getString("rif");
               registros[3]=rs.getString("direccion");
               registros[4]=rs.getString("telefono");
               registros[5]=rs.getString("contactoOrganizacion");
               registros[6]=rs.getString("telefonoContacto");
               registros[7]=rs.getString("cargoContacto");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (vinstitucion dts){
        sentenciaSQL="insert into institucion (codigoInstitucion,nombreInstitucion,rif,direccion,telefono,contactoOrganizacion,telefonoContacto,cargoContacto)"+
                  "values(?,?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoInstitucion());
            pst.setString(2, dts.getNombreInstitucion());
            pst.setString(3, dts.getRif());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getContactoOrganizacion());
            pst.setString(7, dts.getTelefonoContacto());
            pst.setString(8, dts.getCargoContacto());
            
            
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
              
            }
            
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        
    }
    
    public boolean modificar (vinstitucion dts){
        
        sentenciaSQL="update institucion set nombreInstitucion=?,rif=?,direccion=?,telefono=?,contactoOrganizacion=?,telefonoContacto=?,cargoContacto=?  where codigoInstitucion=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);

            pst.setString(1, dts.getNombreInstitucion());
            pst.setString(2, dts.getRif());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getContactoOrganizacion());
            pst.setString(6, dts.getTelefonoContacto());
            pst.setString(7, dts.getCargoContacto());
            pst.setInt(8, dts.getCodigoInstitucion());           
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
            
    public boolean eliminar (vinstitucion dts){
        sentenciaSQL="delete from institucion where codigoInstitucion=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoInstitucion());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

        
    public int asignarCodigo(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(codigoInstitucion) as siguienteCodigo from institucion ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 codigo=rs.getInt("siguienteCodigo");
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return codigo;    
    }
    public DefaultTableModel retornarEstudios(){
    DefaultTableModel modelo;
        String [] titulos ={"codigoEstudio","nombre","precio","codigoCategoria"};
        String [] registros = new String[4];
        
        modelo= new DefaultTableModel(null,titulos);
        String sSQL="select * from estudio";

        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoEstudio");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("precio");
               registros[3]=rs.getString("codigoCategoria");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public boolean insertarEstudiosInstitucion (vinstitucion dts1){
        sentenciaSQL="insert into estudioinstitucion (numeroEstudio,codigoEstudios,codigoOrganizacion,nombre,precios,categoria)"+
                  "values(?,?,?,?,?,?)";
        System.out.println("entro al procedimiento deseado");
        
        finstitucion funcionEstudio= new finstitucion();
        DefaultTableModel modelo=funcionEstudio.retornarEstudios();
        totalRegistros= funcionEstudio.totalRegistros;
                try {
                    
                    System.out.println("entro al try");
                    int i=0;
                    int codigo=0;
                    festudio funcion= new festudio();  
                    for(i=0;i<totalRegistros;i++){
                        System.out.println("este es el numero de registros en tabla estudios "+totalRegistros);
                            //System.out.println( " el tamano es"+ tam);
                            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
                            codigo= funcion.asignarCodigoEstudio();
                            codigo++;
                                System.out.println(codigo+" codigo asignado");
                            pst.setInt(1, codigo);
                                System.out.println("este es el numero asignado para estudio "+codigo);
                            pst.setInt(2, Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                                System.out.println("dato 1 "+modelo.getValueAt(i, 0).toString());
                            pst.setInt(3, dts1.getCodigoInstitucion());
                                System.out.println("codigo de la institucion nueva"+ dts1.getCodigoInstitucion());
                            pst.setString(4, modelo.getValueAt(i, 1).toString());
                                System.out.println("dato 2 "+modelo.getValueAt(i, 1).toString());
                            pst.setDouble(5,Double.parseDouble(modelo.getValueAt(i, 2).toString()) );
                                System.out.println("dato 3 "+modelo.getValueAt(i, 2).toString());
                            pst.setInt(6, Integer.parseInt(modelo.getValueAt(i, 3).toString()));  
                                System.out.println("dato 4"+modelo.getValueAt(i, 3).toString());          
                            //System.out.println(" numero asignado " +codigo+" codigoestudio"+ dts.getCodigoEstudios() +" codigo institucion "+ cod+" nombre estudio " + dts.getNombre()+" precio estudio" + dts.getPrecios()+" codigo categoria"+dts.getCategoria()+" todos los datos enviados");
                            pst.executeUpdate();
                    }
                         return true;   
                } catch (SQLException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e);
                return false;
                }

    }
    
       /*
    
        PROCEDIMIENTO QUE SOLICITA EL CODIGO DE UN NOMBRE ENVIADO A LA BD
    */
        public DefaultTableModel codigoInstitucion (String nombre){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","NOMBRE DE INSTITUCION"};
        String [] registros = new String[2];

        modelo= new DefaultTableModel(null,titulos);
        sentenciaSQL="select codigoInstitucion, nombreInstitucion from institucion where nombreInstitucion like '%"+nombre+"%' ";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoInstitucion");
               registros[1]=rs.getString("nombreInstitucion");
               modelo.addRow(registros);
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
        

      

    
}

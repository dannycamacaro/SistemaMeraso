/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vdetalleSolicitud;
import DATOS.vestudiosInstitucion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class festudiosInstitucion {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    
        public DefaultTableModel mostrarEstudioPorInstitucion (String parametro,String codigoInstitucion,String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"NUMERO ESTUDIO","CODIGO","COD INSTITUCION","NOMBRE","PRECIO","CATEGORIA"};
        String [] registros = new String[6];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from estudioinstitucion where codigoOrganizacion ='"+codigoInstitucion+"' and  "+parametro+" like '%"+buscar+"%' ORDER BY nombre";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroEstudio");
               registros[1]=rs.getString("codigoEstudios");
               registros[2]=rs.getString("codigoOrganizacion");
               registros[3]=rs.getString("nombre");
               registros[4]=rs.getString("precios");
               registros[5]=rs.getString("categoria");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
        
        
        public DefaultTableModel mostrarEstudio2 (String codigoInstitucion,String codigoCategoria ){
        DefaultTableModel modelo;
        String [] titulos ={"NUMERO ESTUDIO","CODIGO","COD INSTITUCION","NOMBRE","PRECIO","CATEGORIA"};
        String [] registros = new String[6];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from estudioinstitucion where codigoOrganizacion ='"+codigoInstitucion+"' and categoria='"+codigoCategoria+"' ORDER BY nombre";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroEstudio");
               registros[1]=rs.getString("codigoEstudios");
               registros[2]=rs.getString("codigoOrganizacion");
               registros[3]=rs.getString("nombre");
               registros[4]=rs.getString("precios");
               registros[5]=rs.getString("categoria");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
        
        /*
            BUSCA EL CODIGO DE LA CATEGORIA EN BASE AL NOMBRE DE LA MISMA
        
        */
        public int codigoCategoria(String nombre){
        int codigo=0;
        PreparedStatement pst=null;
        ResultSet rs=null;
        sentenciaSQL="select codigoCategoria from categoriaestudio where nombreCategoria like '%"+nombre+"%' ";
        try {
            pst=cn.prepareStatement(sentenciaSQL);
            codigo=rs.getInt("codigoCategoria");
            System.out.println(codigo);
        } catch (SQLException e) {
            
            System.out.println(e);
                    return 0;
        }
            
        return codigo;
    
  }
        

    
}

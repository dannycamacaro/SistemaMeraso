/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vcategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class fcategoria {
  
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
        public DefaultTableModel mostrarCategoria (String parametro,String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO CATEGORIA","NOMBRE"};
        String [] registros = new String[2];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from categoriaestudio where  "+parametro+" like '%"+buscar+"%' ";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoCategoria");
               registros[1]=rs.getString("nombreCategoria");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (vcategoria dts){
        sentenciaSQL="insert into categoriaestudio (codigoCategoria,nombreCategoria)"+
                  "values(?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoCategoria());
            pst.setString(2, dts.getNombreCategoria());
            
            
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
    
    public boolean modificar (vcategoria dts){
        
        sentenciaSQL="update categoriaestudio set nombreCategoria=? where codigoCategoria=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setString(1, dts.getNombreCategoria());
            pst.setInt(2, dts.getCodigoCategoria());
            
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
            
    public boolean eliminar (vcategoria dts){
        sentenciaSQL="delete from categoriaestudio where codigoCategoria=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoCategoria());
            
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

    public int asignarCodigoCategoria(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(codigoCategoria) as siguienteCodigo from categoriaestudio ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 codigo=rs.getInt("siguienteCodigo");
                System.out.println(codigo);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return codigo;    
    }
    
}

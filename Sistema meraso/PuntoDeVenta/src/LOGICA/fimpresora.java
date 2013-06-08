/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vimpresora;
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
public class fimpresora {
    
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
        public DefaultTableModel mostrarImpresora (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO IMPRESORA","NOMBRE","DIRECCION"};
        String [] registros = new String[3];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from impresora where  codigoImpresora like '%"+buscar+"%' ";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoImpresora");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("direccion");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (vimpresora dts){
        sentenciaSQL="insert into impresora (codigoImpresora,nombre,direccion)"+
                  "values(?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoImpresora());
            pst.setString(2, dts.getNombreImpresora());
            pst.setString(3, dts.getDireccionImpresora());
            
            
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
    
    public boolean modificar (vimpresora dts){
        
        sentenciaSQL="update impresora set nombre=?, direccion=? where codigoImpresora=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setString(1, dts.getNombreImpresora());
            pst.setString(2, dts.getDireccionImpresora());
            pst.setInt(3, dts.getCodigoImpresora());
            
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
            
    public boolean eliminar (vimpresora dts){
        sentenciaSQL="delete from impresora where codigoImpresora=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoImpresora());
            
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
}

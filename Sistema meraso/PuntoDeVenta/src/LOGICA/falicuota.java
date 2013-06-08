/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.valicuota;
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
public class falicuota {
    
     private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    public DefaultTableModel mostrarAlicuota (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","VALOR","PORCENTAJE"};
        String [] registros = new String[3];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from alicuota where codigoAlicuota like '%"+ buscar +"%' ";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoAlicuota");
               registros[1]=rs.getString("valor");
               registros[2]=rs.getString("porcentaje");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (valicuota dts){
        sentenciaSQL="insert into alicuota (codigoAlicuota,valor,porcentaje)"+
                  "values(?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoAlicuota());
            pst.setString(2, dts.getValor());
            pst.setDouble(3, dts.getPorcentaje());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    public boolean modificar (valicuota dts){
        
        sentenciaSQL="update alicuota set valor=?,porcentaje=? where codigoAlicuota=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setString(1, dts.getValor());
            pst.setDouble(2, dts.getPorcentaje());
            pst.setInt(3, dts.getCodigoAlicuota());
            
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
            
    public boolean eliminar (valicuota dts){
        sentenciaSQL="delete from alicuota where codigoAlicuota=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoAlicuota());
            
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

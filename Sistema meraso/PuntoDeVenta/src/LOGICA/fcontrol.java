/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vcontrol;
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
public class fcontrol {
    
    
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"Numero de Control"};
        String [] registros = new String[1];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
        sentenciaSQL="select * from numerocontrol where numeroControl like '%"+ buscar +"%' ";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroControl");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    public DefaultTableModel  numeroControl (){
        DefaultTableModel modelo;
        String [] titulos ={"Numero de Control","Factura"};
        String [] registros = new String[2];
       
        modelo= new DefaultTableModel(null,titulos);
        sentenciaSQL="select numeroControl, factura from numerocontrol ";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroControl");
               registros[1]=rs.getString("factura");
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public boolean insertar (vcontrol dts){
        sentenciaSQL="insert into numerocontrol (numeroControl)"+
                  "values(?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
//            pst.setInt(1, dts.getNumeroControl());
            
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
    
    public boolean modificar (vcontrol dts){
        
        sentenciaSQL="update numerocontrol set numeroControl=?, factura=?";
        
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setLong(1, dts.getNumeroControl());
            pst.setInt(2, dts.getFactura());
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
    
    
    public boolean incrementarNumeroControlfch (vcontrol dts){
        long control=dts.getNumeroControl()-1;
        sentenciaSQL="update numerocontrol set numeroControl=?,factura=?";
        System.out.println(sentenciaSQL);
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setLong(1, dts.getNumeroControl());
            pst.setInt(2, dts.getFactura());
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
    
    
    public boolean eliminar (vcontrol dts){
        sentenciaSQL="delete from numerocontrol where numeroControl=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            //pst.setInt(1, dts.getNumeroControl());
            
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

    /*
        PROCEDIMIENTO QUE VALIDA SI SE DEBE CREAR UNA NUEVA SOLICITUD
    */
    
    public boolean ValidarSolicitud (String numeroSolicitado){
        sentenciaSQL="SELECT numeroSolicitud FROM solicitudestudio where numeroSolicitud='"+numeroSolicitado+"'";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);            
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

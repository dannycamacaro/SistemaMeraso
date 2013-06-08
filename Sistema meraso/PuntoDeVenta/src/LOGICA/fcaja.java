/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vcaja;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class fcaja {
   
    
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    public DefaultTableModel mostrarCaja (Date fecha, String turno){
        DefaultTableModel modelo;
        String [] titulos ={"FECHA","TURNO","TOTAL PAGO","SOLICITUD","PACIENTE"};
        String [] registros = new String[5];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from caja where caja ='"+ fecha +"' and turno ='"+turno+"'";    
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("fecha");
               registros[1]=rs.getString("turno");
               registros[2]=rs.getString("totalEstudio");
               registros[3]=rs.getString("codigoSolicitud");
               registros[3]=rs.getString("nombrePaciente");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (vcaja dts){
        sentenciaSQL="insert into caja (fecha,turno,totalEstudio,codigoSolicitud,nombrePaciente)"+
                  "values(?,?,?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setDate(1, dts.getFecha());
            pst.setString(2, dts.getTurno());
            pst.setDouble(3, dts.getTotalEstudio());
            pst.setInt(4, dts.getCodigoSolicitud());
            pst.setString(5, dts.getNombrePaciente());
            
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
    public boolean modificar (vcaja dts){
        
        sentenciaSQL="update caja set hora=?,estado=?   where fecha=? and turno=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setTime(1, dts.getHora());
            pst.setString(2, dts.getEstado());
            pst.setDate(3, dts.getFecha());
            pst.setString(4, dts.getTurno());
            
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
           */ 
    public boolean eliminar (vcaja dts){
        sentenciaSQL="DELETE  FROM caja WHERE codigoSolicitud=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoSolicitud());
            
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

    
    public DefaultTableModel mostrarCajaDelDia (Date fecha){
        DefaultTableModel modelo;
        String[] titulos = {"SOLICITUD", "PACIENTE", "TOTAL", "TURNO"};
        String[] registros = new String[4];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sentenciaSQL = "SELECT codigoSolicitud, nombrePaciente, totalEstudio, turno FROM "
                + " caja WHERE fecha ='"+ fecha +"' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);

            while (rs.next()) {
                registros[0] = rs.getString("codigoSolicitud");
                registros[1] = rs.getString("nombrePaciente");
                registros[2] = rs.getString("totalEstudio");
                registros[3] = rs.getString("turno");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
}

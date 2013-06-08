/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vpaciente;
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
public class fpaciente {
        
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    
    public DefaultTableModel mostrarPaciente (String parametro,String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","CEDULA","NOMBRES","APELLIDOS","FECHA NACIMIENTO","TELEFONO","DIRECCION","SEXO"};
        String [] registros = new String[8];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from paciente where "+parametro+ " like '%"+buscar+"%'";
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoPaciente");
               registros[1]=rs.getString("Cedula");
               registros[2]=rs.getString("nombres");
               registros[3]=rs.getString("apellidos");
               registros[4]=rs.getString("fechaNacimiento");
               registros[5]=rs.getString("telefono");
               registros[6]=rs.getString("direccion");
               registros[7]=rs.getString("sexo");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    public DefaultTableModel mostrarTodosPaciente (String parametro,String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","CEDULA","NOMBRES","APELLIDOS","FECHA NACIMIENTO","TELEFONO","DIRECCION","SEXO"};
        String [] registros = new String[8];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from paciente where "+parametro+" like '%"+buscar+"%' ORDER BY nombres";
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoPaciente");
               registros[1]=rs.getString("Cedula");
               registros[2]=rs.getString("nombres");
               registros[3]=rs.getString("apellidos");
               registros[4]=rs.getString("fechaNacimiento");
               registros[5]=rs.getString("telefono");
               registros[6]=rs.getString("direccion");
               registros[7]=rs.getString("sexo");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (vpaciente dts){
        sentenciaSQL="insert into paciente (codigoPaciente,Cedula,nombres,apellidos,"
                + "fechaNacimiento,telefono,direccion,sexo)"+
                  "values(?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoPaciente());
            pst.setString(2, dts.getCedula());
            pst.setString(3, dts.getNombres());
            pst.setString(4, dts.getApellidos());
            pst.setDate(5, dts.getFechaNacimiento());
            pst.setString(6, dts.getTelefono());
            pst.setString(7, dts.getDireccion());
            pst.setString(8, dts.getSexo());
            
            
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
              
            }
            
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +"ERROR AL INSERTAR EL PACIENTE");
            return false;
        }
        
    }
    
    public boolean modificar (vpaciente dts){
        
        sentenciaSQL="update paciente set Cedula=?,nombres=?,apellidos=?,"
                + "fechaNacimiento=?,telefono=?,direccion=?, sexo=?"
                + " where codigoPaciente=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            
            
            pst.setString(1, dts.getCedula());
            pst.setString(2, dts.getNombres());
            pst.setString(3, dts.getApellidos());
            pst.setDate(4, dts.getFechaNacimiento());
            pst.setString(5, dts.getTelefono());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getSexo());
            pst.setInt(8, dts.getCodigoPaciente());
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
            
    public boolean eliminar (vpaciente dts){
        sentenciaSQL="delete from paciente where codigoPaciente=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoPaciente());
            
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
    
    
    public int asignarCodigoPaciente(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(codigoPaciente) as siguienteCodigo from paciente ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                 codigo=rs.getInt("siguienteCodigo");
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return codigo;    
    }
}

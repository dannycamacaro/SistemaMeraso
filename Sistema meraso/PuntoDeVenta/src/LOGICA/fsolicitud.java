/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vsolicitud;
import java.sql.Connection;
import java.sql.Date;
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
public class fsolicitud {
     
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    
    /*
        PROCEDIMIENTO DE INSERTAR LA SOLICITUD
    */
        public boolean insertar (vsolicitud dts){
        sentenciaSQL="insert into solicitudestudio (numeroSolicitud,fecha,turno,codigoInstitucion,codigoPaciente,numeroReferencia)"+
                  "values(?,?,?,?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroSolicitud());
            pst.setDate(2, dts.getFecha());
            pst.setString(3, dts.getTurno());
            pst.setInt(4, dts.getCodigoInstitucion());
            pst.setInt(5, dts.getCodigoPaciente());
            pst.setString(6, dts.getNumeroReferencia());
            
            
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
              
            }
            
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(null, e +"ERROR EN INSERTAR ESTUDIO");
            return false;
        }
        
    }
   
    
    /*
    PROCEDIMIENTO QUE CARGARA LAS INSTITUCIONES EXISTENTES
    */
    public Object[] instituciones (){
    int registros = 0; 
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select * from institucion";
    /*
    CUENTA CUANTOS REGISTROS SON PARA ASIGNAR EL TAMANO DE UN OBJETO
    */
    try{
     pst = cn.prepareStatement("SELECT count(*) as total FROM institucion");
     rs = pst.executeQuery();
     rs.next();
     registros = rs.getInt("total");
     rs.close();
    }catch(SQLException e){
     System.out.println(e);
    }
    /*
        ASIGNA LOS REGISTROS A UN OBJETO
    */
    Object[] datos = new Object[registros];
      try{
         pst = cn.prepareStatement(sentenciaSQL);
         
         rs = pst.executeQuery();
         int i = 0;
         while(rs.next()){
            datos[i] = rs.getObject("nombreInstitucion");
            i++;
         }
         rs.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }
    /*
        PROCEDIMIENTO QUE ASIGNA EL NUEVO CODIGO DE SOLICITUD
    */  
    
    public int asignarCodigo(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(numeroSolicitud) as siguienteCodigo from solicitudestudio ";
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
    
    
     /*
    
        PROCEDIMIENTO QUE SOLICITA TODOS LOS DATOS  DE UN PACIENTE
        ENVIADO LA CEDULA A LA BD Y RECIBIENDO TODOS SUS DATOS
    */
    
    public DefaultTableModel EncontrarPaciente (String cedula){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","CEDULA","NOMBRES","APELLIDOS","FECHA NAC.","TELEFONO","DIRECCION","SEXO"};
        String [] registros = new String[8];
        System.out.println("este es el tamano del arreglo "+registros.length);
        modelo= new DefaultTableModel(null,titulos);
        sentenciaSQL="select codigoPaciente, cedula, nombres, apellidos, fechaNacimiento,"+
                " "+"telefono, direccion, sexo from paciente where cedula like '%"+cedula+"%' ";
        System.out.println(sentenciaSQL);
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoPaciente");
               registros[1]=rs.getString("cedula");
               registros[2]=rs.getString("nombres");
               registros[3]=rs.getString("apellidos");
               registros[4]=rs.getString("fechaNacimiento");
               registros[5]=rs.getString("telefono");
               registros[6]=rs.getString("direccion");
               registros[7]=rs.getString("sexo");
               modelo.addRow(registros);
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
        
    public int asignarCodigoSolicitud(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(numeroSolicitud) as siguienteCodigo from solicitudestudio ";
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
    
    public boolean modificar (vsolicitud dts){
        
        sentenciaSQL="update solicitudestudio set fecha=?,turno=?,codigoInstitucion=?, codigoPaciente=?, numeroReferencia=? "
                + " where codigoEstudio=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            
            pst.setDate(1, dts.getFecha());
            pst.setString(2, dts.getTurno());
            pst.setInt(3, dts.getCodigoInstitucion());int n=pst.executeUpdate();
            pst.setInt(4, dts.getCodigoPaciente());
            pst.setString(5, dts.getNumeroReferencia());
            pst.setInt(6, dts.getNumeroSolicitud());
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
            
    public boolean eliminar (vsolicitud dts){
        sentenciaSQL="delete from solicitudestudio where numeroSolicitud=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroSolicitud());
            
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
        VALIDAR SOLICITUD PARA FACTURAR EL RECIBO
    */
    public int ValidarSolicitudEstudio(String numeroSolicitado){
        int factura=0;
        PreparedStatement pst=null;
        ResultSet rs=null;
        sentenciaSQL="SELECT numeroSolicitud from solicitudestudio where numeroSolicitud='"+numeroSolicitado+"' ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 factura=rs.getInt("numeroSolicitud");
                System.out.println(factura);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return factura;    
    }
    
     public boolean CancelarEstudiosSolicitud (vsolicitud dts){
        sentenciaSQL="delete from detallesolicitud where numero_solicitud=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroSolicitud());
            
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
    
     
    public DefaultTableModel mostrarSolicitudes(Date fecha, String turno){
        DefaultTableModel modelo;
        String[] titulos = {"Solicitud", "NOMBRE", "APELLIDOS"};
        String[] registros = new String[3];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sentenciaSQL = "SELECT s.numeroSolicitud, p.nombres, p.apellidos FROM solicitudestudio s INNER JOIN paciente p ON"
                + " s.codigoPaciente=p.codigoPaciente WHERE s.fecha='" + fecha + "' AND s.turno='" + turno + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);

            while (rs.next()) {
                registros[0] = rs.getString("s.numeroSolicitud");
                registros[1] = rs.getString("p.nombres");
                registros[2] = rs.getString("p.apellidos");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
     
    public DefaultTableModel mostrarSolicitudDePaciente(int codigoSolicitud){
        DefaultTableModel modelo;
        String[] titulos = {"1", "2", "3","4", "5", "6","7", "8", "9","10"};
        String[] registros = new String[10];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sentenciaSQL = "SELECT s.numeroSolicitud,s.numeroReferencia,p.cedula, p.nombres, p.apellidos"
                + " , p.fechaNacimiento, p.telefono, p.direccion, p.sexo, i.nombreInstitucion"
                + " FROM solicitudestudio s INNER JOIN paciente p ON"
                + " s.codigoPaciente=p.codigoPaciente INNER JOIN institucion i ON "
                + " i.codigoInstitucion= s.codigoInstitucion"
                + " WHERE s.numeroSolicitud='" + codigoSolicitud +"' ";
                System.out.println(sentenciaSQL);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);

            while (rs.next()) {
                registros[0] = rs.getString("s.numeroSolicitud");
                registros[1] = rs.getString("s.numeroReferencia");
                registros[2] = rs.getString("p.cedula");
                registros[3] = rs.getString("p.nombres");
                registros[4] = rs.getString("p.apellidos");
                registros[5] = rs.getString("p.fechaNacimiento");
                registros[6] = rs.getString("p.telefono");
                registros[7] = rs.getString("p.direccion");
                registros[8] = rs.getString("p.sexo");
                registros[9] = rs.getString("i.nombreInstitucion");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vfactura;
import DATOS.vrecibo;
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
public class frecibo {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    public Double totalFactura;
    
    public boolean insertar (vrecibo dts){
        sentenciaSQL="insert into factura (numeroFactura,numero-Control,fecha,hora"
                + "razonSocial,rifCedula,direccion,telefono,iva,subtotal,total"
                + ",descuento,observaciones,numeroSolicitud)"+
                  "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroFactura());
            pst.setString(2, dts.getNumeroControl());
            pst.setDate(3, dts.getFecha());
            pst.setString(4, dts.getHora());
            pst.setString(5, dts.getRazonSocial());
            pst.setString(6, dts.getRifCedula());
            pst.setString(7, dts.getDireccion());
            pst.setString(8, dts.getTelefono());
            pst.setDouble(9, dts.getIva());
            pst.setDouble(10, dts.getSubTotal());
            pst.setDouble(11, dts.getTotal());
            pst.setDouble(12, dts.getDescuento());
            pst.setString(13, dts.getObservacion());
            pst.setInt(14, dts.getNumeroSolicitud());
            
            
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
    
    public boolean modificar (vrecibo dts){
        
        sentenciaSQL="update factura set numero-Control=?,fecha=?,hora=?,razonSocial=?"
                + ",rifCedula=?,direccion=?,telefono=?,iva=?,subtotal=?,descuento=?,observaciones=?"
                + ",numeroSolicitud=?   where numeroFactura=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setString(1, dts.getNumeroControl());
            pst.setDate(2, dts.getFecha());
            pst.setString(3, dts.getHora());
            pst.setString(4, dts.getRazonSocial());
            pst.setString(5, dts.getRifCedula());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setDouble(8, dts.getIva());
            pst.setDouble(9, dts.getSubTotal());
            pst.setDouble(10, dts.getTotal());
            pst.setDouble(11, dts.getDescuento());
            pst.setString(12, dts.getObservacion());
            pst.setInt(13, dts.getNumeroSolicitud());
            pst.setInt(14, dts.getNumeroFactura());
            
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
            
    public boolean eliminar (vrecibo dts){
        sentenciaSQL="delete from factura where numeroFactura=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroFactura());
            
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
    public DefaultTableModel mostrarEstudioSolicitado (String NumeroSolicitud){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","NOMBRE","PRECIO"};
        String [] registros = new String[3];
        
        totalFactura = 0.00;
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
            sentenciaSQL="SELECT  d.numeroEstudio,e.nombre,e.precios FROM detallesolicitud d inner join"
                    + " estudioinstitucion e WHERE d.numero_solicitud='"+NumeroSolicitud+"' and d.numeroEstudio=e.numeroEstudio ";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroEstudio");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("precios");
               totalFactura=totalFactura+Double.parseDouble(registros[2]);
                       
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           if (totalRegistros>0){
               return modelo;
           }
           else{
               return null;
           }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    /*
        ASIGNAR EL NUMERO DE CONTROL SIGUIENTE
    
    */
    
    public int asignarNumeroControl(){
    int numeroControl=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(numeroControl) as siguienteCodigo from numerocontrol ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 numeroControl=rs.getInt("siguienteCodigo");
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return numeroControl;    
    }
    
    public int asignarNumeroFactura(){
    int numeroFactura=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(factura) as siguienteCodigo from numerocontrol ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 numeroFactura=rs.getInt("siguienteCodigo");
                System.out.println(numeroFactura +"esta es la factura");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return numeroFactura;    
    }
    
    public int asignarIva(){
    int iva=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select valor from alicuota ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                iva=rs.getInt("valor");
                System.out.println("el numero de impuesto es "+iva);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return iva;    
    }
    

    
    public boolean ConsultarSolicitud (vfactura dts){
        sentenciaSQL="SELECT * FROM factura WHERE codigoSolicitud=?"+
                  "VALUES(?)";
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
            JOptionPane.showMessageDialog(null, e +"ERROR AL CONSULTAR LA CAJA.");
            return false;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vfactura;
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
public class ffactura {
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    
    /*
        PROCEDIMIENTO QUE ASIGNA EL CODIGO DE LA FACTURA
    */
    
    public int asignarCodigo(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(factura) as siguienteCodigo from numerocontrol";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 codigo=rs.getInt("siguienteCodigo");
                System.out.println(codigo);
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo asignar un nuevo numero de Factura!.");
        }
        return codigo;    
    }


    /*
        PROCEDIMIENTO PARA ASIGNAR EL NUEVO NUMERO DE CONTROL
    
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
                        System.out.println(numeroControl);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo asignar un nuevo numero de Control!.");
                }
                return numeroControl;    
            }
        
        /*
            PROCEDIMIENTO DE VALIDACION DE FACTURA
        */
    
        public int validarFactura(){
            int ultimaFactura=0;
            PreparedStatement pst=null;
            ResultSet rs=null;
            sentenciaSQL="select max(numeroFactura) as ultimaFactura from factura ";
                try {
                   pst=cn.prepareStatement(sentenciaSQL);
                   rs=pst.executeQuery();
                    while (rs.next()) {

                         ultimaFactura=rs.getInt("ultimaFactura");
                        System.out.println(ultimaFactura);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se pudo validar la ultima factura!.");
                }
                return ultimaFactura;    
            }
        
        
        public boolean insertar (vfactura dts){
        sentenciaSQL="insert into factura (numeroFactura,numeroControl,fecha,hora,"
                + "razonSocial,rifCedula,direccion,telefono,iva,subtotal,total"
                + ",descuento,observaciones,numeroSolicitud,alicuota)"+
                  "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroFactura());
            pst.setString(2, dts.getNumeroControl());
            pst.setDate(3, dts.getFecha());
            pst.setTime(4, dts.getHora());
            pst.setString(5, dts.getRazonSocial());
            pst.setString(6, dts.getRifCedula());
            pst.setString(7, dts.getDireccion());
            pst.setString(8, dts.getTelefono());
            pst.setDouble(9, dts.getIva());
            pst.setDouble(10, dts.getSubtotal());
            pst.setDouble(11, dts.getTotal());
            pst.setDouble(12, dts.getDescuento());
            pst.setString(13, dts.getObservaciones());
            pst.setInt(14, dts.getNumeroSolicitud());
            pst.setInt(15, dts.getAlicuota());
            
            
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
        
        public DefaultTableModel mostrarFacturaDePaciente(String parametro,String numeroFactura){
        DefaultTableModel modelo;
        String[] titulos = {"#FACTURA", "#CONTROL", "FECHA","HORA", "RASON SOCIAL"
                , "RIF/CEDULA","DIRECCION", "TELEFONO", "IVA","SUBTOTAL","TOTAL"
                ,"DESCUENTO","OBSERVACIONES","#SOLICITUD","ALICUOTA"};
        String[] registros = new String[15];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sentenciaSQL = "SELECT * FROM factura WHERE "+parametro+"='" + numeroFactura +"' ";
                System.out.println(sentenciaSQL);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentenciaSQL);

            while (rs.next()) {
                registros[0] = rs.getString("numeroFactura");
                registros[1] = rs.getString("numeroControl");
                registros[2] = rs.getString("fecha");
                registros[3] = rs.getString("hora");
                registros[4] = rs.getString("razonSocial");
                registros[5] = rs.getString("rifCedula");
                registros[6] = rs.getString("direccion");
                registros[7] = rs.getString("telefono");
                registros[8] = rs.getString("iva");
                registros[9] = rs.getString("subtotal");
                registros[10] = rs.getString("total");
                registros[11] = rs.getString("descuento");
                registros[12] = rs.getString("observaciones");
                registros[13] = rs.getString("numeroSolicitud");
                registros[14] = rs.getString("alicuota");
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registros);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return modelo;
        }

    }
     
        
}

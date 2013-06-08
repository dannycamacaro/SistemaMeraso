/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vdetalleSolicitud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class fdetalleSolicitud {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    public Double totalFactura;
    public int CodigoDetalle;
    public String costoFactura="";
    
        public boolean insertar (vdetalleSolicitud dts){
            
        asignarCodigoDetalle();
        sentenciaSQL="insert into detalleSolicitud (numeroDetalle,numero_solicitud,numeroEstudio)"+
                  "values(?,?,?)";
        String mensaje;
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);;
            CodigoDetalle=CodigoDetalle+1;
            pst.setInt(1, CodigoDetalle);
            pst.setInt(2, dts.getNumeroSolicitud());
            pst.setInt(3, dts.getNumeroEstudio());
            
            
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
              
            }
            
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e +"ERROR EN INSERTAR ESTUDIO");
            return false;
        }
    }
    
        
        public int asignarCodigoDetalle(){
        int codigo=0;
        PreparedStatement pst=null;
        ResultSet rs=null;
        sentenciaSQL="select max(numeroDetalle) as siguienteCodigo from detallesolicitud ";
        try {
           pst=cn.prepareStatement(sentenciaSQL);
           rs=pst.executeQuery();
            while (rs.next()) {
                
                 codigo=rs.getInt("siguienteCodigo");
                 CodigoDetalle=codigo;
                System.out.println(codigo);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return codigo;    
    }
        
        
        /*
            PROCEDIMIENTO DE ELIMINAR DETALLE DE SOLICITUD
        */
        public boolean eliminarDetalle (vdetalleSolicitud dts){
        sentenciaSQL="delete from detallesolicitud where numeroDetalle=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getNumeroDetalle());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Se eliminaron todos los detalles");
            return false;
        }
    }
        
        
        public DefaultTableModel mostrarEstudioSolicitado (String NumeroSolicitud){
        DefaultTableModel modelo;
        String [] titulos ={"NUMERO DETALLE","NUMEROSOLICITUD","CODIGO","NOMBRE","PRECIO"};
        String [] registros = new String[5];
        NumberFormat nf= NumberFormat.getCurrencyInstance();
        
        totalFactura = 0.00;
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
        //SELECT d.numero_solicitud, d.numeroEstudio,e.nombre,e.precios FROM detallesolicitud d inner join 
        //estudioinstitucion e WHERE d.numero_solicitud='1' and d.numeroEstudio=e.numeroEstudio
            sentenciaSQL="SELECT d.numeroDetalle, d.numero_solicitud, d.numeroEstudio,e.nombre,e.precios FROM detallesolicitud d inner join"
                    + " estudioinstitucion e WHERE d.numero_solicitud='"+NumeroSolicitud+"' and d.numeroEstudio=e.numeroEstudio ";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroDetalle");
               registros[1]=rs.getString("numero_solicitud");
               registros[2]=rs.getString("numeroEstudio");
               registros[3]=rs.getString("nombre");
               registros[4]=rs.getString("precios");
               totalFactura=totalFactura+Double.parseDouble(registros[4]);
               System.out.println(totalFactura);
                       
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           costoFactura=nf.format(totalFactura);
           if (totalRegistros>0){
               return modelo;
               
           }
           else{
               return modelo;
           }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
        
        
}

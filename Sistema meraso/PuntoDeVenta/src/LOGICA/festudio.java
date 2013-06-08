/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vestudio;
import DATOS.vestudiosInstitucion;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class festudio {
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    
    /*
        PROCEDIMIENTO QUE MUESTRA TODOS LOS RESULTAADOS DE UNA BUSQUEDA 
        Y LOS CARGA EN UNA TABLA
    */
    public DefaultTableModel mostrarEstudio (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","NOMBRE","PRECIO","CATEGORIA"};
        String [] registros = new String[6];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from estudio where codigoEstudio like '%"+ buscar +"%' order by codigoEstudio";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoEstudio");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("precio");
               registros[3]=rs.getString("codigoCategoria");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    /*
        BUSCA POR UN PARAMETRO="CAMPO DE BUSQUEDA"
    */
        public DefaultTableModel mostrarEstudio2 (String parametro,String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","NOMBRE","PRECIO","COD. CAT.","CATEGORIA"};
        String [] registros = new String[5];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select e.codigoEstudio, e.nombre, e.precio, e.codigoCategoria, c.nombreCategoria from estudio e "
                    + "inner join categoriaestudio c where"
                    + "  e."+parametro+" like '%"+buscar+"%' AND e.codigoCategoria=c.codigoCategoria ";
            System.out.println(sentenciaSQL);
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoEstudio");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("precio");
               registros[3]=rs.getString("codigoCategoria");
               registros[4]=rs.getString("nombreCategoria");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return modelo;
        }
         
    }
    
    public boolean insertar (vestudio dts){
        sentenciaSQL="insert into estudio (codigoEstudio,nombre,precio,codigoCategoria)"+
                  "values(?,?,?,?)";
        String mensaje;
        mensaje = "Registro Guardado!";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoEstudio());
            pst.setString(2, dts.getNombreEstudio());
            pst.setDouble(3, dts.getPrecio());
            pst.setInt(4, dts.getCodigoCategoria());
            
            
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
    
    public boolean modificar (vestudio dts){
        
        sentenciaSQL="update estudio set nombre=?,precio=?,codigoCategoria=? where codigoEstudio=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            
            pst.setString(1, dts.getNombreEstudio());
            pst.setDouble(2, dts.getPrecio());
            pst.setInt(3, dts.getCodigoCategoria());
            pst.setInt(4, dts.getCodigoEstudio());
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
            
    public boolean eliminar (vestudio dts){
        sentenciaSQL="delete from estudio where codigoEstudio=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoEstudio());
            
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
        PROCEDIMIENTO QUE MUESTRA EN UN COMBO BOX EL VALOR DE UN CAMPO ESPECIFICO
    */
      public Object[] comboCategoria(String tabla, String nombrecol){
      int registros = 0; 
      PreparedStatement pst=null;
      ResultSet rs=null;
      sentenciaSQL="select nombreCategoria from categoriaestudio ORDER BY nombreCategoria";
      /*
        CUENTA CUANTOS REGISTROS SON PARA ASIGNAR EL TAMANO DE UN OBJETO
      */
      try{
         pst = cn.prepareStatement("SELECT count(*) as total FROM categoriaestudio");
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
            datos[i] = rs.getObject("nombreCategoria");
            i++;
         }
         rs.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }
      
    public int codigoCategoria(String nombre){
        int codigo=0;
        PreparedStatement pst=null;
        ResultSet rs=null;
        sentenciaSQL="select codigoCategoria from categoriaestudio where nombreCategoria like '%"+nombre+"%' ";
        try {
            pst=cn.prepareStatement(sentenciaSQL);
            codigo=rs.getInt("codigoCategoria");
            System.out.println(codigo);
        } catch (SQLException e) {
            
            System.out.println(e);
                    return 0;
        }
            
        return codigo;
    
  }
  
        public DefaultTableModel cargaCategoria (String nombre){
        DefaultTableModel modelo;
        String [] titulos ={"Codigo Categoria","NOMBRE DE CATEGORIA"};
        String [] registros = new String[2];

        modelo= new DefaultTableModel(null,titulos);
        sentenciaSQL="select codigoCategoria,nombreCategoria from categoriaestudio where nombreCategoria like '%"+nombre+"%' ";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoCategoria");
               System.out.println(registros[0]);
               registros[1]=rs.getString("nombreCategoria");
               System.out.println(registros[1]);
               System.out.println(registros.toString());
               modelo.addRow(registros);
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return modelo;
        }
    }
    
        
    public int asignarCodigo(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(codigoEstudio) as siguienteCodigo from estudio ";
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
    
    public int asignarCodigoEstudio(){
    int codigo=0;
    PreparedStatement pst=null;
    ResultSet rs=null;
    sentenciaSQL="select max(numeroEstudio) as siguienteCodigo from estudioinstitucion ";
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
            datos[i] = rs.getObject("codigoInstitucion");
            i++;
         }
         rs.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }
    
    public boolean insertarEstudiosInstitucion (vestudiosInstitucion dts){
        sentenciaSQL="insert into estudioinstitucion (numeroEstudio,codigoEstudios,codigoOrganizacion,nombre,precios,categoria)"+
                  "values(?,?,?,?,?,?)";
        
        String sSQL="select codigoInstitucion from institucion";

        int i=0;
        ArrayList codigoInstitucion = new ArrayList();
        //cuenta y almacena los datos de la institucion para su recuperacion y grabado
            try {
               Statement st=cn.createStatement();
               ResultSet rs=st.executeQuery(sSQL);
                while (rs.next()){
                   codigoInstitucion.add(rs.getInt("codigoInstitucion"));
                   i=i+1;
                }

            } catch (Exception e) {
        }
        int tam = codigoInstitucion.size();
        festudio funcion= new festudio();  
       
                try {
                   
                    int codigo=0;
                    int a=0;
                    for(i=0;i<tam;i++){
                            //System.out.println( " el tamano es"+ tam);
                            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
                            codigo= funcion.asignarCodigoEstudio();
                            codigo++;
                            System.out.println(codigo+" codigo asignado");
                            pst.setInt(1, codigo);
                            pst.setInt(2, dts.getCodigoEstudios());
                            int cod=(int) codigoInstitucion.get(i);
                            //System.out.println(cod);
                            pst.setInt(3, cod);
                            pst.setString(4, dts.getNombre());
                            pst.setDouble(5, dts.getPrecios());
                            pst.setInt(6, dts.getCategoria());            
                            //System.out.println(" numero asignado " +codigo+" codigoestudio"+ dts.getCodigoEstudios() +" codigo institucion "+ cod+" nombre estudio " + dts.getNombre()+" precio estudio" + dts.getPrecios()+" codigo categoria"+dts.getCategoria()+" todos los datos enviados");
                            pst.executeUpdate();
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    return false;
                }
                return true;
    }
}

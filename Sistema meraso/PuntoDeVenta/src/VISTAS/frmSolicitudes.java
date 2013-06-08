/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import DATOS.vsolicitud;
import LOGICA.fsolicitud;
import static VISTAS.frmmenu.escritorio;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class frmSolicitudes extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmSolicitudes
     */
    public frmSolicitudes() {
        initComponents();
        asignarFecha();
        btnconsulta.doClick();
    }
    
    
     private void asignarFecha() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        int dia, mes, anio = 0;
        dia = c1.get(Calendar.DATE);
        mes = c1.get(Calendar.MONTH);
        anio = c1.get(Calendar.YEAR) - 1900;
        Date fechaActual = new Date(anio, mes, dia);
        jdfecha.setDate(fechaActual);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSolicitudes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        btnmenu = new javax.swing.JButton();
        lblnombre = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        jdfecha = new com.toedter.calendar.JDateChooser();
        lblturno = new javax.swing.JLabel();
        cbturno = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTA DE SOLICITUDES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(960, 450));
        jPanel1.setMinimumSize(new java.awt.Dimension(960, 450));
        jPanel1.setLayout(null);

        tbSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE"
            }
        ));
        tbSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSolicitudesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbSolicitudesMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbSolicitudes);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(10, 20, 870, 450);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TOTAL DE REGISTROS:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(700, 470, 140, 30);

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setText("0");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(850, 470, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 900, 500);

        panel2.setBackground(new java.awt.Color(0, 102, 153));
        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel2.setLayout(null);

        btnmenu.setBackground(new java.awt.Color(255, 255, 255));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/salida.png"))); // NOI18N
        btnmenu.setText("MENU");
        btnmenu.setToolTipText("IR A MENU");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        panel2.add(btnmenu);
        btnmenu.setBounds(770, 0, 130, 50);

        lblnombre.setBackground(new java.awt.Color(255, 255, 255));
        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText("FECHA");
        panel2.add(lblnombre);
        lblnombre.setBounds(10, 0, 60, 30);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/cubo-de-basura.png"))); // NOI18N
        btnEliminar.setToolTipText("MODIFICAR REGISTROS");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panel2.add(btnEliminar);
        btnEliminar.setBounds(720, 0, 50, 50);

        btnconsulta.setBackground(new java.awt.Color(255, 255, 255));
        btnconsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/presentacion-de-informes.png"))); // NOI18N
        btnconsulta.setToolTipText("CANCELAR MODIFICACION");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });
        panel2.add(btnconsulta);
        btnconsulta.setBounds(270, 10, 50, 50);
        panel2.add(jdfecha);
        jdfecha.setBounds(70, 0, 180, 30);

        lblturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblturno.setForeground(new java.awt.Color(255, 255, 255));
        lblturno.setText("TURNO");
        panel2.add(lblturno);
        lblturno.setBounds(10, 30, 50, 30);

        cbturno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIURNO", "MATUTINO" }));
        panel2.add(cbturno);
        cbturno.setBounds(70, 30, 180, 30);

        getContentPane().add(panel2);
        panel2.setBounds(0, 0, 1060, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public int codigoSolicitud=0;
    private void tbSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSolicitudesMouseClicked
        try {
            int fila =tbSolicitudes.rowAtPoint(evt.getPoint());
            codigoSolicitud=Integer.parseInt(tbSolicitudes.getValueAt(fila, 0).toString());
        } catch (Exception e) {

        }
    }//GEN-LAST:event_tbSolicitudesMouseClicked
    private void sizetable() {
        try {
            TableColumnModel columnModel = tbSolicitudes.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(150);
            columnModel.getColumn(0).setMaxWidth(150);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(1).setMaxWidth(200);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al ajustar la tabla");
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }
    private void mostrar (Date fecha,String turno){
        try {
            DefaultTableModel modelo;
            
            fsolicitud func= new fsolicitud();
            modelo=func.mostrarSolicitudes(fecha,turno);
            tbSolicitudes.setModel(modelo);
            lblTotal.setText(""+ Integer.toString(func.totalRegistros));   
            sizetable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar los registros en la tabla");
            JOptionPane.showMessageDialog(rootPane, e);

        }
 }
    
    
    private void cargarSolicitudDePaciente (int CodigoSolicitud){
        try {
            DefaultTableModel modelo;
            
            fsolicitud func= new fsolicitud();
            modelo=func.mostrarSolicitudDePaciente(CodigoSolicitud);
            frmsolicitud.lblcodigoSolicitud.setText(modelo.getValueAt(0, 0).toString());
            frmsolicitud.txtnumeroReferencia.setText(modelo.getValueAt(0, 1).toString());
            frmsolicitud.txtcedulaPaciente.setText(modelo.getValueAt(0, 2).toString());
            frmsolicitud.txtnombresPaciente.setText(modelo.getValueAt(0, 3).toString());
            frmsolicitud.txtapellidosPacientes.setText(modelo.getValueAt(0, 4).toString());
            frmsolicitud.jdfechaNacimiento.setDate(Date.valueOf(modelo.getValueAt(0, 5).toString()));
            frmsolicitud.txttelefonoPaciente.setText(modelo.getValueAt(0, 6).toString());
            frmsolicitud.txtdireccionPaciente.setText(modelo.getValueAt(0, 7).toString());
            String sexo="";
            sexo=modelo.getValueAt(0, 8).toString();
            if (sexo.equals("MASCULINO")){
                frmsolicitud.cbsexo.setSelectedIndex(0);
            }
            else{
                frmsolicitud.cbsexo.setSelectedIndex(1);
            }
            int i=0;
            while (!frmsolicitud.cbinstitucion.getSelectedItem().equals(modelo.getValueAt(0, 9))){
            frmsolicitud.cbinstitucion.setSelectedIndex(i);
            i++;
            }
            frmsolicitud.mostrarEstudiofrmSolicitud(Integer.toString(CodigoSolicitud));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar los registros.");
            JOptionPane.showMessageDialog(rootPane, e);

        }
 }
    
    private void tbSolicitudesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSolicitudesMousePressed
        int fila = tbSolicitudes.rowAtPoint(evt.getPoint());
        if (evt.getClickCount() == 2) {

            try {              
                codigoSolicitud = Integer.parseInt(tbSolicitudes.getValueAt(fila, 0).toString());
                frmsolicitud form = new frmsolicitud();
                escritorio.add(form);
                form.toFront();
                form.setSize(780, 550);
                form.setVisible(true);
                cargarSolicitudDePaciente(codigoSolicitud);
                frmsolicitud.btnetiqueta.setEnabled(true);
                frmsolicitud.btnrecibo.setEnabled(true);
                frmsolicitud.modificador=true;
                
            } catch (Exception e) {

            }
        }        

    }//GEN-LAST:event_tbSolicitudesMousePressed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere eliminar este registro?", "Confirmar", 2);

        if (confirmacion == 0) {
            try {

                fsolicitud func = new fsolicitud();
                vsolicitud dts = new vsolicitud();
                dts.setNumeroSolicitud(codigoSolicitud);
                boolean resultado = func.eliminar(dts);
                if (resultado == true) {
                    JOptionPane.showMessageDialog(rootPane, "Registro eliminado exitosamente.");
                }

                btnconsulta.doClick();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No se ha podido eliminar el registro");
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed

        /*
        CODIGO DEL CALENDARIO
        */
        Calendar calendario;
        int d, m, a;
        calendario = jdfecha.getCalendar();
        d = calendario.get(Calendar.DAY_OF_MONTH);
        m = calendario.get(Calendar.MONTH);
        a = calendario.get(Calendar.YEAR) - 1900;
        String turno= cbturno.getSelectedItem().toString();
        if(d!=0 && m!=0 && a!=0){
            mostrar(new Date(a,m,d),turno);
        }

    }//GEN-LAST:event_btnconsultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSolicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnmenu;
    private javax.swing.JComboBox cbturno;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblturno;
    private java.awt.Panel panel2;
    public static javax.swing.JTable tbSolicitudes;
    // End of variables declaration//GEN-END:variables
}

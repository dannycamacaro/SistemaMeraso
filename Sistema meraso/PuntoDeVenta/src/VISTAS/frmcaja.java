/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import LOGICA.conexion;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class frmcaja extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcaja
     */
    public frmcaja() {
        initComponents();
        asignarFecha();
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
        lblfecha = new javax.swing.JLabel();
        lblturno = new javax.swing.JLabel();
        jdfecha = new com.toedter.calendar.JDateChooser();
        cbturno = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnreporte = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ARQUEO DE CAJA");
        setMaximumSize(new java.awt.Dimension(280, 200));
        setMinimumSize(new java.awt.Dimension(280, 200));
        setPreferredSize(new java.awt.Dimension(280, 200));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAJA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(280, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(280, 200));
        jPanel1.setLayout(null);

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfecha.setText("FECHA");
        jPanel1.add(lblfecha);
        lblfecha.setBounds(10, 20, 80, 30);

        lblturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblturno.setText("TURNO");
        jPanel1.add(lblturno);
        lblturno.setBounds(10, 60, 80, 30);
        jPanel1.add(jdfecha);
        jdfecha.setBounds(80, 20, 170, 30);

        cbturno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIURNO", "MATUTINO" }));
        jPanel1.add(cbturno);
        cbturno.setBounds(80, 60, 170, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 260, 100);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(null);

        btnreporte.setBackground(new java.awt.Color(255, 255, 255));
        btnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/impresora-3.png"))); // NOI18N
        btnreporte.setText("REPORTE");
        btnreporte.setToolTipText("IMPRIMIR REPORTE");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnreporte);
        btnreporte.setBounds(10, 0, 120, 50);

        btnmenu.setBackground(new java.awt.Color(255, 255, 255));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/salida.png"))); // NOI18N
        btnmenu.setText("MENU");
        btnmenu.setToolTipText("IR A MENU");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnmenu);
        btnmenu.setBounds(130, 0, 120, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Connection connection= new conexion().conectar();
    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        try {
            Calendar calendario;
            int d, m, a;
            calendario = jdfecha.getCalendar();
            d = calendario.get(Calendar.DAY_OF_MONTH);
            m = calendario.get(Calendar.MONTH);
            a = calendario.get(Calendar.YEAR) - 1900;
            Map p = new HashMap();
            p.put("fecha", (new Date(a, m, d)));
            p.put("turno", cbturno.getSelectedItem().toString());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/REPORTES/rptArqueoCaja.jrxml");

                print = JasperFillManager.fillReport(report, p, connection);

                JasperViewer view = new JasperViewer(print, false);

                view.setTitle("Reporte de Caja");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

        }

        

    }//GEN-LAST:event_btnreporteActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

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
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnreporte;
    private javax.swing.JComboBox cbturno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblturno;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

/**
 *
 * @author user
 */
public class frmmenu extends javax.swing.JFrame {

    /**
     * Creates new form frmmenu
     */
    public frmmenu() {
        initComponents();
        this.setExtendedState(frmmenu.MAXIMIZED_BOTH);
        this.setTitle("Sistema de Punto de Venta Meraso");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        lblcodigo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        lblprivilegio = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        menuBar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnusolicitud = new javax.swing.JMenuItem();
        mnucaja = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuconsultaPaciente = new javax.swing.JMenu();
        mnuConsultaInstitucion = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnuConsultaPaciente = new javax.swing.JMenuItem();
        mnucategoriaConsulta = new javax.swing.JMenuItem();
        mnuconsultaEstudio = new javax.swing.JMenuItem();
        mnuConsultaCaja = new javax.swing.JMenuItem();
        mnuSolicitudes = new javax.swing.JMenuItem();
        mnuModulos = new javax.swing.JMenu();
        mnuInstitucion = new javax.swing.JMenuItem();
        mnucategoria = new javax.swing.JMenuItem();
        mnuEstudio = new javax.swing.JMenuItem();
        mnuBaremo = new javax.swing.JMenuItem();
        mnuConfiguracion = new javax.swing.JMenu();
        mnucontrol = new javax.swing.JMenuItem();
        mnuimpresora = new javax.swing.JMenuItem();
        mnualicuota = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuLogin = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU");

        escritorio.setBackground(new java.awt.Color(204, 204, 204));
        escritorio.setMaximumSize(new java.awt.Dimension(800, 600));
        escritorio.setMinimumSize(new java.awt.Dimension(800, 600));

        jToolBar1.setRollover(true);

        jLabel1.setText("COD. EMPLEADO: ");
        jToolBar1.add(jLabel1);

        lblcodigo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblcodigo.setText("CODIGO");
        jToolBar1.add(lblcodigo);
        jToolBar1.add(jSeparator1);

        jLabel2.setText("USUARIO: ");
        jToolBar1.add(jLabel2);

        lblnombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblnombre.setText("nombre");
        jToolBar1.add(lblnombre);
        jToolBar1.add(jSeparator2);

        jLabel3.setText("PRIVILEGIOS: ");
        jToolBar1.add(jLabel3);

        lblprivilegio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblprivilegio.setText("privilegio");
        jToolBar1.add(lblprivilegio);
        jToolBar1.add(jSeparator3);

        escritorio.add(jToolBar1);
        jToolBar1.setBounds(0, 0, 1360, 40);

        menuBar.setBackground(new java.awt.Color(0, 102, 153));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/factura-1.png"))); // NOI18N
        jMenu2.setText("FACTURACION");

        mnusolicitud.setText("SOLICITUD DE ESTUDIO");
        mnusolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnusolicitudActionPerformed(evt);
            }
        });
        jMenu2.add(mnusolicitud);

        mnucaja.setText("ARQUEO DE CAJA");
        mnucaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucajaActionPerformed(evt);
            }
        });
        jMenu2.add(mnucaja);

        jMenuItem6.setText("CONSULTA FACTURA");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem1.setText("PACIENTE");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        menuBar.add(jMenu2);

        mnuconsultaPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/presentacion-de-informes.png"))); // NOI18N
        mnuconsultaPaciente.setMnemonic('e');
        mnuconsultaPaciente.setText("CONSULTAS");

        mnuConsultaInstitucion.setMnemonic('t');
        mnuConsultaInstitucion.setText("INSTITUCION");
        mnuConsultaInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultaInstitucionActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(mnuConsultaInstitucion);

        jMenuItem7.setText("FACTURACION POR MES");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(jMenuItem7);

        mnuConsultaPaciente.setText("PACIENTE");
        mnuConsultaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultaPacienteActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(mnuConsultaPaciente);

        mnucategoriaConsulta.setMnemonic('y');
        mnucategoriaConsulta.setText("CATEGORIAS");
        mnucategoriaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucategoriaConsultaActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(mnucategoriaConsulta);

        mnuconsultaEstudio.setMnemonic('p');
        mnuconsultaEstudio.setText("ESTUDIOS");
        mnuconsultaEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuconsultaEstudioActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(mnuconsultaEstudio);

        mnuConsultaCaja.setText("CAJA");
        mnuConsultaCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultaCajaActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(mnuConsultaCaja);

        mnuSolicitudes.setText("SOLICITUDES");
        mnuSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSolicitudesActionPerformed(evt);
            }
        });
        mnuconsultaPaciente.add(mnuSolicitudes);

        menuBar.add(mnuconsultaPaciente);

        mnuModulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/simbolo-de-configurar.png"))); // NOI18N
        mnuModulos.setMnemonic('f');
        mnuModulos.setText("MODULOS");

        mnuInstitucion.setMnemonic('o');
        mnuInstitucion.setText("INSTITUCION");
        mnuInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInstitucionActionPerformed(evt);
            }
        });
        mnuModulos.add(mnuInstitucion);

        mnucategoria.setMnemonic('s');
        mnucategoria.setText("CATEGORIA");
        mnucategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucategoriaActionPerformed(evt);
            }
        });
        mnuModulos.add(mnucategoria);

        mnuEstudio.setMnemonic('a');
        mnuEstudio.setText("ESTUDIOS");
        mnuEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEstudioActionPerformed(evt);
            }
        });
        mnuModulos.add(mnuEstudio);

        mnuBaremo.setText("BAREMO");
        mnuBaremo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBaremoActionPerformed(evt);
            }
        });
        mnuModulos.add(mnuBaremo);

        menuBar.add(mnuModulos);

        mnuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/ajustes.png"))); // NOI18N
        mnuConfiguracion.setMnemonic('h');
        mnuConfiguracion.setText("CONFIGURACION");

        mnucontrol.setText("CONTROL FACTURACION");
        mnucontrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucontrolActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mnucontrol);

        mnuimpresora.setText("IMPRESORAS");
        mnuimpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuimpresoraActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mnuimpresora);

        mnualicuota.setText("ALICUOTA");
        mnualicuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnualicuotaActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mnualicuota);

        mnuUsuario.setMnemonic('a');
        mnuUsuario.setText("USUARIO");
        mnuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuarioActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mnuUsuario);

        menuBar.add(mnuConfiguracion);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/salida.png"))); // NOI18N
        jMenu1.setText("SALIR");

        mnuLogin.setMnemonic('c');
        mnuLogin.setText("CAMBIAR USUARIO");
        mnuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoginActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLogin);

        jMenuItem3.setText("NO");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("SI");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInstitucionActionPerformed
        // TODO add your handling code here:
        frminstitucion form= new  frminstitucion();
        escritorio.add(form);
        form.toFront();
        form.setSize(630, 430);
        form.setVisible(true);
    }//GEN-LAST:event_mnuInstitucionActionPerformed

    private void mnuConsultaInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaInstitucionActionPerformed
        // TODO add your handling code here:
        frmconsultaInstitucion form= new  frmconsultaInstitucion();
        escritorio.add(form);
        form.toFront();
        form.setSize(830, 550);
        form.setVisible(true);
    }//GEN-LAST:event_mnuConsultaInstitucionActionPerformed

    private void mnucategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucategoriaActionPerformed
        // TODO add your handling code here:
        frmcategoria form= new  frmcategoria();
        escritorio.add(form);
        form.toFront();
        form.setSize(620, 200);
        form.setVisible(true);
        
    }//GEN-LAST:event_mnucategoriaActionPerformed

    private void mnucategoriaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucategoriaConsultaActionPerformed
        // TODO add your handling code here:
        frmconsultaCategoria form= new  frmconsultaCategoria();
        escritorio.add(form);
        form.toFront();
        form.setSize(740, 540);
        form.setVisible(true);
    }//GEN-LAST:event_mnucategoriaConsultaActionPerformed

    private void mnuEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEstudioActionPerformed
        // TODO add your handling code here:
        frmestudio form = new frmestudio();
        escritorio.add(form);
        form.toFront();
        form.setSize(460, 240);
        form.setVisible(true); 
    }//GEN-LAST:event_mnuEstudioActionPerformed

    private void mnuconsultaEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuconsultaEstudioActionPerformed
        // TODO add your handling code here:
        frmconsultaEstudio form = new frmconsultaEstudio();
        escritorio.add(form);
        form.toFront();
        form.setSize(710, 540);
        form.setVisible(true); 
    }//GEN-LAST:event_mnuconsultaEstudioActionPerformed

    private void mnusolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnusolicitudActionPerformed
        // TODO add your handling code here:
        frmsolicitud form = new frmsolicitud();
        escritorio.add(form);
        form.toFront();
        form.setSize(780, 550);
        form.setVisible(true); 
    }//GEN-LAST:event_mnusolicitudActionPerformed

    private void mnuConsultaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaPacienteActionPerformed
        // TODO add your handling code here:
        frmconsultaPaciente form = new frmconsultaPaciente();
        escritorio.add(form);
        form.toFront();
        form.setSize(840, 540);
        form.setVisible(true); 
    }//GEN-LAST:event_mnuConsultaPacienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frmpaciente form = new frmpaciente();
        escritorio.add(form);
        form.toFront();
        form.setSize(720, 270);
        form.setVisible(true); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnualicuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnualicuotaActionPerformed
        // TODO add your handling code here:
        frmAlicuota form = new frmAlicuota();
        escritorio.add(form);
        form.toFront();
        form.setSize(540, 470);
        form.setVisible(true);
    }//GEN-LAST:event_mnualicuotaActionPerformed

    private void mnuimpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuimpresoraActionPerformed
        // TODO add your handling code here:
        frmimpresora form = new frmimpresora();
        escritorio.add(form);
        form.toFront();
        form.setSize(610, 340);
        form.setVisible(true);
    }//GEN-LAST:event_mnuimpresoraActionPerformed

    private void mnucontrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucontrolActionPerformed
        // TODO add your handling code here:
        frmcontrol form= new  frmcontrol();
        escritorio.add(form);
        form.toFront();
        form.setSize(270, 170);
        form.setVisible(true);
    }//GEN-LAST:event_mnucontrolActionPerformed

    private void mnuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuarioActionPerformed
        // TODO add your handling code here:

        frmusuario form= new  frmusuario();
        escritorio.add(form);
        form.toFront();
        form.setSize(530, 510);
        form.setVisible(true);
    }//GEN-LAST:event_mnuUsuarioActionPerformed

    private void mnuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoginActionPerformed
        // TODO add your handling code here:

        frmlogin form = new frmlogin();
        form.toFront();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_mnuLoginActionPerformed

    private void mnuBaremoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBaremoActionPerformed
        // TODO add your handling code here:
        frmbaremoInstitucion form= new  frmbaremoInstitucion();
        escritorio.add(form);
        form.toFront();
        form.setSize(690, 530);
        form.setVisible(true);
    }//GEN-LAST:event_mnuBaremoActionPerformed

    private void mnucajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucajaActionPerformed
        // TODO add your handling code here:
        frmcaja form= new  frmcaja();
        escritorio.add(form);
        form.toFront();
        form.setSize(280, 200);
        form.setVisible(true);
    }//GEN-LAST:event_mnucajaActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        frmConsultaFactura form= new  frmConsultaFactura();
        escritorio.add(form);
        form.toFront();
        form.setSize(740, 540);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        frmfacturacionMes form= new  frmfacturacionMes();
        escritorio.add(form);
        form.toFront();
        form.setSize(500, 240);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void mnuConsultaCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultaCajaActionPerformed
        frmconsultaCaja form= new  frmconsultaCaja();
        escritorio.add(form);
        form.toFront();
        form.setSize(920, 590);
        form.setVisible(true);
    }//GEN-LAST:event_mnuConsultaCajaActionPerformed

    private void mnuSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSolicitudesActionPerformed
        // TODO add your handling code here:
        frmSolicitudes form= new  frmSolicitudes();
        escritorio.add(form);
        form.toFront();
        form.setSize(920, 590);
        form.setVisible(true);
    }//GEN-LAST:event_mnuSolicitudesActionPerformed

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
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    public static javax.swing.JLabel lblcodigo;
    public static javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lblprivilegio;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuBaremo;
    public static javax.swing.JMenu mnuConfiguracion;
    private javax.swing.JMenuItem mnuConsultaCaja;
    public static javax.swing.JMenuItem mnuConsultaInstitucion;
    private javax.swing.JMenuItem mnuConsultaPaciente;
    private javax.swing.JMenuItem mnuEstudio;
    private javax.swing.JMenuItem mnuInstitucion;
    private javax.swing.JMenuItem mnuLogin;
    public static javax.swing.JMenu mnuModulos;
    private javax.swing.JMenuItem mnuSolicitudes;
    private javax.swing.JMenuItem mnuUsuario;
    private javax.swing.JMenuItem mnualicuota;
    private javax.swing.JMenuItem mnucaja;
    private javax.swing.JMenuItem mnucategoria;
    private javax.swing.JMenuItem mnucategoriaConsulta;
    private javax.swing.JMenuItem mnuconsultaEstudio;
    private javax.swing.JMenu mnuconsultaPaciente;
    private javax.swing.JMenuItem mnucontrol;
    private javax.swing.JMenuItem mnuimpresora;
    private javax.swing.JMenuItem mnusolicitud;
    // End of variables declaration//GEN-END:variables

}

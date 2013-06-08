/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import DATOS.vestudio;
import DATOS.vestudiosInstitucion;
import LOGICA.festudio;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class frmestudio extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmestudio
     */
    public frmestudio() {
        initComponents();
        inhabilitar ();
        comboCategoria("categoriaestudios","nombreCategoria");
        txtcodigoCategoria.setVisible(false);

    }
    
        
   private void inhabilitar (){
       //deshabilitar cajas de texto
        txtcodigo.setEnabled(false);
        txtnombreEstudio.setEnabled(false);
        txtprecioEstudio.setEnabled(false);
        txtcodigoCategoria.setEnabled(false);
        

        //deshabilitar botones
        btnguardar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnmodificar.setEnabled(false);
        btncancelar.setEnabled(false);
        
    }
    private void nuevoCodigo(){
        try {
            int codigo=0;
           festudio funcion= new festudio();
           codigo=funcion.asignarCodigo();
           codigo=codigo+1; 
           txtcodigo.setText(String.valueOf(codigo));
           System.out.println(codigo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al cargar el nuevo codigo");
            JOptionPane.showConfirmDialog(rootPane, e);
        }
       
   }
    void vaciarCajas(){
            //vaciar cajas de texto
        txtcodigo.setText("");
        txtnombreEstudio.setText("");
        txtprecioEstudio.setText("");
    }
    void habilitar (){
        //habilitar cajas de texto
        txtcodigo.setEnabled(true);
        txtnombreEstudio.setEnabled(true);
        txtprecioEstudio.setEnabled(true);
        txtcodigoCategoria.setEnabled(true);
        //habilitar botones
        btnguardar.setEnabled(true);
        btnmenu.setEnabled(true);
        btneliminar.setEnabled(true);
        //vaciar cajas de texto
    }

    void cargarCategoria (String nombre){
         try {
            DefaultTableModel modelo;
            festudio func= new festudio();
            vestudio dts= new vestudio();
            dts.setNombreEstudio(nombre);
            modelo=func.cargaCategoria(dts.getNombreEstudio());
            txtcodigoCategoria.setText(modelo.getValueAt(0,0).toString());
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(rootPane, "Error en el procedimiento cargarCategoria");
            
        }
 }
    void comboCategoria(String tabla, String nombrecol){
        try {
            festudio func= new festudio();
            Object[] nombre = func.comboCategoria(tabla,nombrecol);
            cbcategoria.removeAllItems();
            for(int i=0;i<nombre.length;i++){
            cbcategoria.addItem(nombre[i]);    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error en comboCategoria");
        }
        
   }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new java.awt.Panel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombreEstudio = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        txtprecioEstudio = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();
        lblcodigo4 = new javax.swing.JLabel();
        cbcategoria = new javax.swing.JComboBox();
        btnhabilitar = new javax.swing.JButton();
        txtcodigoCategoria = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ESTUDIO");
        setMaximumSize(new java.awt.Dimension(460, 240));
        setMinimumSize(new java.awt.Dimension(460, 240));
        setPreferredSize(new java.awt.Dimension(460, 240));
        getContentPane().setLayout(null);

        panel2.setBackground(new java.awt.Color(0, 102, 153));
        panel2.setLayout(null);

        btnnuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/agregar-documento-simbolo-delineado.png"))); // NOI18N
        btnnuevo.setToolTipText("NUEVO REGISTRO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        panel2.add(btnnuevo);
        btnnuevo.setBounds(0, 0, 50, 50);

        btnguardar.setBackground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/guardar.png"))); // NOI18N
        btnguardar.setToolTipText("GUARDAR REGISTRO");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        panel2.add(btnguardar);
        btnguardar.setBounds(50, 0, 50, 50);

        btnmodificar.setBackground(new java.awt.Color(255, 255, 255));
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/archivo-nuevo.png"))); // NOI18N
        btnmodificar.setToolTipText("MODIFICAR REGISTRO");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        panel2.add(btnmodificar);
        btnmodificar.setBounds(100, 0, 60, 50);

        btncancelar.setBackground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/expediente.png"))); // NOI18N
        btncancelar.setToolTipText("CANCELAR REGISTRO");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        panel2.add(btncancelar);
        btncancelar.setBounds(160, 0, 60, 50);

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/cubo-de-basura.png"))); // NOI18N
        btneliminar.setToolTipText("ELIMINAR REGISTRO");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        panel2.add(btneliminar);
        btneliminar.setBounds(220, 0, 50, 50);

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
        btnmenu.setBounds(320, 0, 120, 50);

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/buscar.png"))); // NOI18N
        btnbuscar.setToolTipText("BUSCAR REGISTRO");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        panel2.add(btnbuscar);
        btnbuscar.setBounds(270, 0, 50, 50);

        getContentPane().add(panel2);
        panel2.setBounds(0, 0, 670, 50);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE ESTUDIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(null);

        lblcodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcodigo.setText("CODIGO ");
        jPanel1.add(lblcodigo);
        lblcodigo.setBounds(10, 20, 60, 30);

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });
        jPanel1.add(txtcodigo);
        txtcodigo.setBounds(70, 20, 100, 30);

        txtnombreEstudio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombreEstudioFocusLost(evt);
            }
        });
        txtnombreEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreEstudioActionPerformed(evt);
            }
        });
        txtnombreEstudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombreEstudioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreEstudioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreEstudioKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombreEstudio);
        txtnombreEstudio.setBounds(70, 60, 360, 30);

        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnombre.setText("NOMBRE");
        jPanel1.add(lblnombre);
        lblnombre.setBounds(10, 60, 60, 30);

        txtprecioEstudio.setNextFocusableComponent(btnguardar);
        txtprecioEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioEstudioActionPerformed(evt);
            }
        });
        txtprecioEstudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioEstudioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioEstudioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioEstudioKeyTyped(evt);
            }
        });
        jPanel1.add(txtprecioEstudio);
        txtprecioEstudio.setBounds(250, 20, 110, 30);

        lblprecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblprecio.setText("PRECIO");
        jPanel1.add(lblprecio);
        lblprecio.setBounds(200, 20, 60, 30);

        lblcodigo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcodigo4.setText("CATEGORIA");
        jPanel1.add(lblcodigo4);
        lblcodigo4.setBounds(10, 100, 80, 30);

        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbcategoria.setNextFocusableComponent(txtprecioEstudio);
        cbcategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcategoriaItemStateChanged(evt);
            }
        });
        cbcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(cbcategoria);
        cbcategoria.setBounds(90, 100, 340, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 440, 150);

        btnhabilitar.setText("habilitar");
        btnhabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnhabilitar);
        btnhabilitar.setBounds(640, 100, 71, 23);

        txtcodigoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoCategoriaActionPerformed(evt);
            }
        });
        txtcodigoCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoCategoriaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoCategoriaKeyReleased(evt);
            }
        });
        getContentPane().add(txtcodigoCategoria);
        txtcodigoCategoria.setBounds(450, 140, 60, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed

        habilitar();
        vaciarCajas();
        txtcodigoCategoria.requestFocus();
        btnmodificar.setEnabled(false);
        btnmenu.setEnabled(false);
        btnnuevo.setEnabled(false);
        btneliminar.setEnabled(false);
        btncancelar.setEnabled(true);
        btnguardar.setEnabled(true);
        nuevoCodigo();
        txtnombreEstudio.requestFocus();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtcodigo.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Codigo para la estudio");
            txtcodigo.requestFocus();
            return;
        }
        if (txtnombreEstudio.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un nombre para el estudio");
            txtnombreEstudio.requestFocus();
            return;
        }
        if (txtprecioEstudio.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio para el estudio");
            txtprecioEstudio.requestFocus();
            return;
        }
        if (txtcodigoCategoria.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una categoria para el estudio");
            txtcodigoCategoria.requestFocus();
            return;
        }
        try {
            vestudio dts= new vestudio();
            festudio func=new festudio();

            dts.setCodigoEstudio(Integer.parseInt(txtcodigo.getText()));
            dts.setNombreEstudio(txtnombreEstudio.getText());
            dts.setPrecio(Double.parseDouble(txtprecioEstudio.getText()));
            dts.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getText()));
            
            func.insertar(dts);
            
            /*
                    AQUI INSERTO EL ESTUDIO PARA CADA ORGANIZACION
            */
            vestudiosInstitucion dts1= new vestudiosInstitucion();
            festudio funcion=new festudio();

            dts1.setCodigoEstudios(Integer.parseInt(txtcodigo.getText()));
            dts1.setNombre(txtnombreEstudio.getText());
            dts1.setPrecios(Double.parseDouble(txtprecioEstudio.getText()));
            dts1.setCategoria(Integer.parseInt(txtcodigoCategoria.getText()));

            boolean resultado= funcion.insertarEstudiosInstitucion(dts1);
            if (resultado==true){
                JOptionPane.showMessageDialog(rootPane, "Registro almacenados exitosamente.");
                inhabilitar();
                //habilitar botones
                btnmenu.setEnabled(true);
                btnnuevo.setEnabled(true);
                //ihabilitar botones
                btnguardar.setEnabled(false);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al almacenar el registro.");
        }

        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        if (txtcodigo.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un Codigo para la estudio");
            txtcodigo.requestFocus();
            return;
        }
        if (txtnombreEstudio.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un nombre para el estudio");
            txtnombreEstudio.requestFocus();
            return;
        }
        if (txtprecioEstudio.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un precio para el estudio");
            txtprecioEstudio.requestFocus();
            return;
        }
        if (txtcodigoCategoria.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una categoria para el estudio");
            txtcodigoCategoria.requestFocus();
            return;
        }
        try {
            vestudio dts = new vestudio();
            festudio func = new festudio();

            dts.setCodigoEstudio(Integer.parseInt(txtcodigo.getText()));
            dts.setNombreEstudio(txtnombreEstudio.getText());
            dts.setPrecio(Double.parseDouble(txtprecioEstudio.getText()));
            dts.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getText()));
            func.modificar(dts);
            inhabilitar();
            JOptionPane.showMessageDialog(rootPane, "Registro se ha modificado exitosamente");
            btnmenu.setEnabled(true);
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(rootPane, "Error al Modificar el registro");
        }
        
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(rootPane, "Se ha cancelado la operacion.");
        inhabilitar ();
        btnmenu.setEnabled(true);
        btnnuevo.setEnabled(true);
        vaciarCajas();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtcodigoCategoria.getText().equals("")) {

            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere eliminar este registro?.", "Confirmar", 2);
            
            if (confirmacion==0) {
                
                try {
                    festudio func = new festudio();
                    vestudio dts = new vestudio();

                    dts.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getText()));
                    boolean resultado = func.eliminar(dts);
                    if (resultado == true) {
                        JOptionPane.showMessageDialog(rootPane, "Registro Eliminado.");
                        inhabilitar();
                        btnmenu.setEnabled(true);
                        vaciarCajas();
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(rootPane, "No se pudo eliminar el registro.");
                }
                
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        frmconsultaEstudio form= new  frmconsultaEstudio();
        form.toFront();
        frmmenu.escritorio.add(form);
        form.setSize(710, 540);
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
        txtnombreEstudio.grabFocus();
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyPressed

    }//GEN-LAST:event_txtcodigoKeyPressed

    private void txtcodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyReleased

    }//GEN-LAST:event_txtcodigoKeyReleased

    private void txtnombreEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreEstudioActionPerformed
        // TODO add your handling code here:
        txtprecioEstudio.transferFocus();
    }//GEN-LAST:event_txtnombreEstudioActionPerformed

    private void txtnombreEstudioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreEstudioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreEstudioKeyPressed

    private void txtnombreEstudioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreEstudioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreEstudioKeyReleased

    private void txtprecioEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioEstudioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioEstudioActionPerformed

    private void txtprecioEstudioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioEstudioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioEstudioKeyPressed

    private void txtprecioEstudioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioEstudioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioEstudioKeyReleased

    private void txtcodigoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoCategoriaActionPerformed

    private void txtcodigoCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoCategoriaKeyPressed

    private void txtcodigoCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoCategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoCategoriaKeyReleased

    private void cbcategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcategoriaItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbcategoriaItemStateChanged

    private void cbcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcategoriaActionPerformed
            Object dato =(String)cbcategoria.getSelectedItem();
            String nombre= String.valueOf(dato);
            cargarCategoria(nombre);
    }//GEN-LAST:event_cbcategoriaActionPerformed

    private void txtnombreEstudioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreEstudioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreEstudioFocusLost

    private void btnhabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhabilitarActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setEnabled(false);
        btnmenu.setEnabled(false);
    }//GEN-LAST:event_btnhabilitarActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
         Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtnombreEstudioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreEstudioKeyTyped
         Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnombreEstudioKeyTyped

    private void txtprecioEstudioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioEstudioKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtprecioEstudioKeyTyped

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
            java.util.logging.Logger.getLogger(frmestudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmestudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmestudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmestudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmestudio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnbuscar;
    public static javax.swing.JButton btncancelar;
    public static javax.swing.JButton btneliminar;
    public static javax.swing.JButton btnguardar;
    public static javax.swing.JButton btnhabilitar;
    public static javax.swing.JButton btnmenu;
    public static javax.swing.JButton btnmodificar;
    public static javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox cbcategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblcodigo4;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblprecio;
    private java.awt.Panel panel2;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtcodigoCategoria;
    public static javax.swing.JTextField txtnombreEstudio;
    public static javax.swing.JTextField txtprecioEstudio;
    // End of variables declaration//GEN-END:variables
}
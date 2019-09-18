package Interfaz;

import Clases.Proveedor;
import Clases.Validar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class JDialog_Proveedor extends javax.swing.JDialog {

    static boolean añadir = false;
    static boolean modificar = false;
    
    private Proveedor cargarDatos(){
        Proveedor prov = new Proveedor();
        
        prov.setId(Integer.valueOf(lbl_ID.getText()));
        prov.setNombre(txt_NombreProveedor.getText());
        prov.setRut(txt_RutProveedor.getText());
        prov.setTelefono(txt_TelefonoProveedor.getText());
        prov.setDireccion(txt_DireccionProveedor.getText());

        int activo = 1;
        if (!cmb_ActivoProveedor.getSelectedItem().equals("1 (Activo)")) 
            activo = 0;

        prov.setActivo(activo);
        
        return prov;
    }
    
    private void iniciarComponentes(){
        txt_NombreProveedor.requestFocus();
        if (añadir) 
            setTitle("Agregar Proveedor - SpeedeX");
        else
            setTitle("Modificar Proveedor - SpeedeX");
        
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        this.setResizable(false);
        setSize(760, 490); 
        
        lbl_Ingresar.setVisible(false);
        lbl_Modificar.setVisible(false);
        
        cmb_ActivoProveedor.removeAllItems();
        cmb_ActivoProveedor.addItem("1 (Activo)");
        cmb_ActivoProveedor.addItem("0 (No activo)");
        
        cambio = false;
        
        Proveedor prov = new Proveedor();
        
        lbl_ID.setText(String.valueOf((prov.buscarID().getId()) + 1));
    }
    
    public JDialog_Proveedor(java.awt.Frame parent, boolean modal, Proveedor prov) {
        super(parent, modal);
        initComponents();
        
        iniciarComponentes();
        
        lbl_Modificar.setVisible(true);
        modificar = true;
        
        lbl_ID.setText(String.valueOf(prov.getId()));
        txt_NombreProveedor.setText(prov.getNombre());
        txt_RutProveedor.setText(prov.getRut());
        txt_TelefonoProveedor.setText(prov.getTelefono());
        txt_DireccionProveedor.setText(prov.getDireccion()); 
        
        int activo = 1;
        if (prov.getActivo() == 1) {
            activo = 0;
        }
        
        cmb_ActivoProveedor.setSelectedIndex(activo);
        
        txt_RutProveedor.setEditable(false);
    }
    
    public JDialog_Proveedor(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        añadir = true;
        
        iniciarComponentes();
        
        lbl_Ingresar.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Proveedor = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txt_RutProveedor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_NombreProveedor = new javax.swing.JTextField();
        txt_DireccionProveedor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_TelefonoProveedor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmb_ActivoProveedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbl_ID = new javax.swing.JLabel();
        btn_LimpiarNombre = new javax.swing.JButton();
        lbl_Ingresar = new javax.swing.JLabel();
        lbl_Modificar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        btn_Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Proveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Nombre.png"))); // NOI18N
        pnl_Proveedor.add(jLabel1);
        jLabel1.setBounds(40, 100, 80, 30);

        txt_RutProveedor.setForeground(new java.awt.Color(0, 153, 153));
        txt_RutProveedor.setToolTipText("");
        txt_RutProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_RutProveedor.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_RutProveedor.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_RutProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_RutProveedorKeyTyped(evt);
            }
        });
        pnl_Proveedor.add(txt_RutProveedor);
        txt_RutProveedor.setBounds(160, 160, 130, 30);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Rut.png"))); // NOI18N
        pnl_Proveedor.add(jLabel21);
        jLabel21.setBounds(70, 160, 50, 30);

        txt_NombreProveedor.setForeground(new java.awt.Color(0, 153, 153));
        txt_NombreProveedor.setToolTipText("");
        txt_NombreProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_NombreProveedor.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_NombreProveedor.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_NombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreProveedorKeyTyped(evt);
            }
        });
        pnl_Proveedor.add(txt_NombreProveedor);
        txt_NombreProveedor.setBounds(160, 100, 130, 30);

        txt_DireccionProveedor.setForeground(new java.awt.Color(0, 153, 153));
        txt_DireccionProveedor.setToolTipText("");
        txt_DireccionProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_DireccionProveedor.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_DireccionProveedor.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_DireccionProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DireccionProveedorKeyTyped(evt);
            }
        });
        pnl_Proveedor.add(txt_DireccionProveedor);
        txt_DireccionProveedor.setBounds(480, 100, 130, 30);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Telefono.png"))); // NOI18N
        pnl_Proveedor.add(jLabel22);
        jLabel22.setBounds(360, 40, 90, 30);

        txt_TelefonoProveedor.setForeground(new java.awt.Color(0, 153, 153));
        txt_TelefonoProveedor.setToolTipText("");
        txt_TelefonoProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_TelefonoProveedor.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_TelefonoProveedor.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_TelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TelefonoProveedorKeyTyped(evt);
            }
        });
        pnl_Proveedor.add(txt_TelefonoProveedor);
        txt_TelefonoProveedor.setBounds(480, 40, 130, 30);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Direccion.png"))); // NOI18N
        pnl_Proveedor.add(jLabel23);
        jLabel23.setBounds(340, 100, 110, 30);

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Activo.png"))); // NOI18N
        pnl_Proveedor.add(jLabel24);
        jLabel24.setBounds(370, 160, 60, 30);

        cmb_ActivoProveedor.setForeground(new java.awt.Color(0, 204, 204));
        cmb_ActivoProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_ActivoProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_Proveedor.add(cmb_ActivoProveedor);
        cmb_ActivoProveedor.setBounds(480, 160, 130, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo.png"))); // NOI18N
        pnl_Proveedor.add(jLabel4);
        jLabel4.setBounds(60, 50, 60, 20);

        lbl_ID.setFont(new java.awt.Font("Mairy Extralight Oblicua", 0, 18)); // NOI18N
        lbl_ID.setForeground(new java.awt.Color(0, 204, 204));
        lbl_ID.setText("----");
        pnl_Proveedor.add(lbl_ID);
        lbl_ID.setBounds(180, 40, 50, 40);

        btn_LimpiarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Limpiar.png"))); // NOI18N
        btn_LimpiarNombre.setBorder(null);
        btn_LimpiarNombre.setBorderPainted(false);
        btn_LimpiarNombre.setContentAreaFilled(false);
        btn_LimpiarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LimpiarNombre.setFocusPainted(false);
        btn_LimpiarNombre.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Limpiar Press.png"))); // NOI18N
        btn_LimpiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarNombreActionPerformed(evt);
            }
        });
        pnl_Proveedor.add(btn_LimpiarNombre);
        btn_LimpiarNombre.setBounds(610, 200, 50, 40);

        getContentPane().add(pnl_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 680, 260));

        lbl_Ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ingresar Proveedor.png"))); // NOI18N
        getContentPane().add(lbl_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 450, -1));

        lbl_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Modificar Proveedor.png"))); // NOI18N
        getContentPane().add(lbl_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 860, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        btn_Volver1.setForeground(new java.awt.Color(255, 51, 51));
        btn_Volver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver.png"))); // NOI18N
        btn_Volver1.setBorderPainted(false);
        btn_Volver1.setContentAreaFilled(false);
        btn_Volver1.setFocusPainted(false);
        btn_Volver1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Press.png"))); // NOI18N
        btn_Volver1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Mouse.png"))); // NOI18N
        btn_Volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Volver1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 70, 60));

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar.png"))); // NOI18N
        btn_Aceptar.setBorder(null);
        btn_Aceptar.setBorderPainted(false);
        btn_Aceptar.setContentAreaFilled(false);
        btn_Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Aceptar.setFocusPainted(false);
        btn_Aceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar Press2.png"))); // NOI18N
        btn_Aceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar Mouse.png"))); // NOI18N
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 170, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LimpiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarNombreActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_LimpiarNombreActionPerformed
    
    private void limpiar(){
        this.txt_NombreProveedor.setText("");
        this.txt_RutProveedor.setText("");
        this.txt_TelefonoProveedor.setText("");
        this.txt_DireccionProveedor.setText("");
    }
    
    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        añadir = false;
        modificar = false;

        seleccionarID();
        
        ultimoID();
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed
    static int id = 0;
    
    public int seleccionarID (){
        return id;
    }
    
    public int ultimoID(){
        if (cambio) 
            return Integer.valueOf(lbl_ID.getText()) - 1 ;
        else
            return 0; 
    }
    static boolean cambio = false;
    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        Proveedor prov;
        if (añadir) {
            prov = cargarDatos();
            
            if (prov.insertarProveedor()){
                JOptionPane.showMessageDialog(null, "El proveedor: "+prov.getNombre()+", fue añadido correctamente.","Proveedor ingresado",JOptionPane.INFORMATION_MESSAGE);
                id = Integer.valueOf(lbl_ID.getText());
                lbl_ID.setText(String.valueOf((prov.buscarID().getId()) + 1));
                cambio = true;
                limpiar();
                
            }
        }
        else if (modificar){
            prov = cargarDatos();
            
            if (prov.actualizarProveedor()){
                JOptionPane.showMessageDialog(null, "Datos editados correctamente.","Datos proveedor editados",JOptionPane.INFORMATION_MESSAGE);
                id = Integer.valueOf(lbl_ID.getText());
            }
        }
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void txt_NombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreProveedorKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_NombreProveedor.getText(), 30))
            evt.consume();
    }//GEN-LAST:event_txt_NombreProveedorKeyTyped

    private void txt_RutProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_RutProveedorKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_NombreProveedor.getText(), 10))
            evt.consume();
    }//GEN-LAST:event_txt_RutProveedorKeyTyped

    private void txt_TelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TelefonoProveedorKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_NombreProveedor.getText(), 9))
            evt.consume();
        
        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_TelefonoProveedorKeyTyped

    private void txt_DireccionProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DireccionProveedorKeyTyped
         Validar v = new Validar();       
        if (!v.maximoLargo(txt_NombreProveedor.getText(), 30))
            evt.consume();
    }//GEN-LAST:event_txt_DireccionProveedorKeyTyped

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
            java.util.logging.Logger.getLogger(JDialog_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_Proveedor dialog = new JDialog_Proveedor(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_LimpiarNombre;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JComboBox<String> cmb_ActivoProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_Ingresar;
    private javax.swing.JLabel lbl_Modificar;
    private javax.swing.JLayeredPane pnl_Proveedor;
    private javax.swing.JTextField txt_DireccionProveedor;
    private javax.swing.JTextField txt_NombreProveedor;
    private javax.swing.JTextField txt_RutProveedor;
    private javax.swing.JTextField txt_TelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}

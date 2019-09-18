package Interfaz;

import Clases.Configurar;
import Clases.Empleado;
import Clases.Validar;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        Validar v = new Validar();
        
        setTitle("Inicio - SpeedeX");
        setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        setResizable(false);
        setSize(624, 454);
        
        if (v.iniciarSecion()) {
            ckb_Recuerdame.setSelected(true);
            txt_CodigoEmpleado.setText(String.valueOf(v.empleado()));
            txtpass_Contraseña.setText(v.contra());
        }
        else{
            valido = false;
            ckb_Recuerdame.setSelected(false);
            txt_CodigoEmpleado.setText("");
            txtpass_Contraseña.setText("");
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        btn_Aceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_CodigoEmpleado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpass_Contraseña = new javax.swing.JPasswordField();
        ckb_Recuerdame = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Normal.png"))); // NOI18N
        btn_Aceptar.setBorder(null);
        btn_Aceptar.setBorderPainted(false);
        btn_Aceptar.setContentAreaFilled(false);
        btn_Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Aceptar.setMaximumSize(new java.awt.Dimension(73, 73));
        btn_Aceptar.setMinimumSize(new java.awt.Dimension(73, 73));
        btn_Aceptar.setPreferredSize(new java.awt.Dimension(122, 54));
        btn_Aceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Press2.png"))); // NOI18N
        btn_Aceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Mouse.png"))); // NOI18N
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo empleado.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, 30));

        txt_CodigoEmpleado.setForeground(new java.awt.Color(0, 153, 153));
        txt_CodigoEmpleado.setCaretColor(new java.awt.Color(0, 153, 153));
        txt_CodigoEmpleado.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_CodigoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodigoEmpleadoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CodigoEmpleadoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_CodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 130, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Contraseña 2.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, 30));

        txtpass_Contraseña.setForeground(new java.awt.Color(0, 153, 153));
        txtpass_Contraseña.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtpass_Contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass_ContraseñaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass_ContraseñaKeyTyped(evt);
            }
        });
        getContentPane().add(txtpass_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 130, 30));

        ckb_Recuerdame.setBackground(new java.awt.Color(153, 204, 255));
        ckb_Recuerdame.setText("Recuérdame");
        ckb_Recuerdame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ckb_RecuerdameMouseClicked(evt);
            }
        });
        getContentPane().add(ckb_Recuerdame, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 100, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Inicio P.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        ingresarEmpleado();
    }//GEN-LAST:event_btn_AceptarActionPerformed
    
    static boolean valido = false;
    
    private void ingresarEmpleado(){
        Empleado emp = new Empleado();
        Validar v = new Validar();
        
        emp = emp.buscarEmpleado(this.txt_CodigoEmpleado.getText(),txtpass_Contraseña.getText());

        if(emp == null){
            JOptionPane.showMessageDialog(null, "El empleado no está registrado.","Empleado no válido",JOptionPane.WARNING_MESSAGE);
            valido = false;
        }else{
            if (!v.empleadoHabilitado(this.txt_CodigoEmpleado.getText(), txtpass_Contraseña.getText())) {
                valido = true;
            
                recordar(ckb_Recuerdame.isSelected());
                
//                if (ckb_Recuerdame.isSelected())
//                    recordar(true);
//                else
//                    recordar(false);

                Seleccion select = new Seleccion(emp);
                this.setVisible(false);
                select.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(null, "El empleado está inhabilitado, imposible iniciar sesión.","Empleado inhabilitado",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void recordar(boolean cheked){
        Configurar conf = new Configurar();
        Validar v = new Validar();
        
        if (valido) {
            conf.setId(1);
            conf.setStockMinimo(v.cargaStockMinimo());
            conf.setStockMaximo(v.cargaStockMaximo());

            int permitir = 0;

            if (v.permitirEmpleado()) 
                permitir = 1;

            conf.setPermisoEmpleado(permitir);
        
            if (cheked) {
                conf.setIniciarSesion(1);
                conf.setIdEmpleado((txt_CodigoEmpleado.getText()));
                conf.setContraseña(txtpass_Contraseña.getText());  
            }
            else{
                conf.setIniciarSesion(0);
                conf.setIdEmpleado("");
                conf.setContraseña("");
            }
            
            int ventana = 0;
        
            if (v.ventana()) 
                ventana = 1;

            conf.setVentana(ventana);

            conf.actualizarConfiguracion();
        } 
    }
    
    private void txtpass_ContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraseñaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            ingresarEmpleado();
    }//GEN-LAST:event_txtpass_ContraseñaKeyPressed

    private void txt_CodigoEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoEmpleadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            ingresarEmpleado();
    }//GEN-LAST:event_txt_CodigoEmpleadoKeyPressed

    private void ckb_RecuerdameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ckb_RecuerdameMouseClicked
        if (valido) {
            if (ckb_Recuerdame.isSelected())
                recordar(true);
            else
                recordar(false);
        }   
    }//GEN-LAST:event_ckb_RecuerdameMouseClicked

    private void txt_CodigoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoEmpleadoKeyTyped
        Validar v = new Validar();
        
        if (!v.maximoLargo(txt_CodigoEmpleado.getText(), 8))
            evt.consume();
    }//GEN-LAST:event_txt_CodigoEmpleadoKeyTyped

    private void txtpass_ContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraseñaKeyTyped
         Validar v = new Validar();       
        if (!v.maximoLargo(txt_CodigoEmpleado.getText(), 20))
            evt.consume();
    }//GEN-LAST:event_txtpass_ContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JCheckBox ckb_Recuerdame;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_CodigoEmpleado;
    private javax.swing.JPasswordField txtpass_Contraseña;
    // End of variables declaration//GEN-END:variables
}
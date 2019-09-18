package Interfaz;

import Clases.Empleado;
import Clases.Validar;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class JDialog_Contraseña extends javax.swing.JDialog {

    private void iniciarComponentes(){
        setTitle("Modificar Contraseña - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        this.setResizable(false);
        setSize(566, 405);
    }
    
    public Empleado empl;
    
    private Empleado cargarDatos(){
        empl.setContraseña(txtpass_ContraNueva1.getText());
        
        return empl;
    }
    
    static boolean cam = false;
    
    public boolean cambio(){
        return cam;
    }
    
    private void buscarDatos(){
        empl = empl.buscarEmpleado(empl.getIdEmpleado(),txtpass_ContraActual.getText());

        if(empl == null)
            JOptionPane.showMessageDialog(null, "Favor ingresar contraseña correcta.","Contraseña inválida!",JOptionPane.WARNING_MESSAGE);
        else{
            if (!txtpass_ContraNueva1.getText().isEmpty() && !txtpass_ContraNueva2.getText().isEmpty()) {
                if (txtpass_ContraNueva1.getText().length() >= 7 && txtpass_ContraNueva2.getText().length() >= 7) {
                    if (txtpass_ContraNueva1.getText().equals(txtpass_ContraNueva2.getText())) {
                    empl = cargarDatos();

                    if (empl.actualizarEmpleado()){ 
                        cam = true;
                        cambio();
                        this.setVisible(false);
                        }         
                    }
                    else{
                        cam = false;
                        JOptionPane.showMessageDialog(null, "Contraseñas no coinsiden.","Cuidado!",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Ingresar un mínimo de 7 dígitos.","Cuidado!",JOptionPane.WARNING_MESSAGE);
               
            }
            else
                JOptionPane.showMessageDialog(null, "Ingresa una contraseña válida.","Cuidado!",JOptionPane.WARNING_MESSAGE);
        } 
    }
    
    public JDialog_Contraseña(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarComponentes();
    }
    
    public JDialog_Contraseña(java.awt.Frame parent, boolean modal, Empleado emp) {
        super(parent, modal);
        initComponents();
        iniciarComponentes();
        empl = emp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Titulo = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        txtpass_ContraActual = new javax.swing.JPasswordField();
        txtpass_ContraNueva1 = new javax.swing.JPasswordField();
        txtpass_ContraNueva2 = new javax.swing.JPasswordField();
        lbl_ContraA = new javax.swing.JLabel();
        lbl_NuevaContra = new javax.swing.JLabel();
        lbl_NuevaContra2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_Volver = new javax.swing.JButton();
        btn_Acep = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Cambiar Contraseña.png"))); // NOI18N
        getContentPane().add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtpass_ContraActual.setForeground(new java.awt.Color(0, 153, 153));
        txtpass_ContraActual.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtpass_ContraActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass_ContraActualKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass_ContraActualKeyTyped(evt);
            }
        });

        txtpass_ContraNueva1.setForeground(new java.awt.Color(0, 153, 153));
        txtpass_ContraNueva1.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtpass_ContraNueva1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass_ContraNueva1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass_ContraNueva1KeyTyped(evt);
            }
        });

        txtpass_ContraNueva2.setForeground(new java.awt.Color(0, 153, 153));
        txtpass_ContraNueva2.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtpass_ContraNueva2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass_ContraNueva2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpass_ContraNueva2KeyTyped(evt);
            }
        });

        lbl_ContraA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Contraseña Actual.png"))); // NOI18N

        lbl_NuevaContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Nueva Contraseña.png"))); // NOI18N

        lbl_NuevaContra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Confirmar Contraseña.png"))); // NOI18N

        jLayeredPane2.setLayer(txtpass_ContraActual, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtpass_ContraNueva1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtpass_ContraNueva2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_ContraA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_NuevaContra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_NuevaContra2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_ContraA)
                        .addComponent(lbl_NuevaContra))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(lbl_NuevaContra2)
                        .addGap(9, 9, 9)))
                .addGap(28, 28, 28)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpass_ContraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass_ContraNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass_ContraNueva2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ContraA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass_ContraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_NuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass_ContraNueva1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpass_ContraNueva2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_NuevaContra2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 60));

        btn_Volver.setForeground(new java.awt.Color(255, 51, 51));
        btn_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver.png"))); // NOI18N
        btn_Volver.setBorderPainted(false);
        btn_Volver.setContentAreaFilled(false);
        btn_Volver.setFocusPainted(false);
        btn_Volver.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Press.png"))); // NOI18N
        btn_Volver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Mouse.png"))); // NOI18N
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 70, 60));

        btn_Acep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar.png"))); // NOI18N
        btn_Acep.setBorderPainted(false);
        btn_Acep.setContentAreaFilled(false);
        btn_Acep.setFocusPainted(false);
        btn_Acep.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar Press2.png"))); // NOI18N
        btn_Acep.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar Mouse.png"))); // NOI18N
        btn_Acep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AcepActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Acep, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 170, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        cam = false;
        this.setVisible(false);
    }//GEN-LAST:event_btn_VolverActionPerformed

    private void btn_AcepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AcepActionPerformed
        buscarDatos();
    }//GEN-LAST:event_btn_AcepActionPerformed

    private void txtpass_ContraActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraActualKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            buscarDatos();
    }//GEN-LAST:event_txtpass_ContraActualKeyPressed

    private void txtpass_ContraNueva1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraNueva1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            buscarDatos();
    }//GEN-LAST:event_txtpass_ContraNueva1KeyPressed

    private void txtpass_ContraNueva2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraNueva2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            buscarDatos();
    }//GEN-LAST:event_txtpass_ContraNueva2KeyPressed

    private void txtpass_ContraActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraActualKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txtpass_ContraActual.getText(), 20))
            evt.consume();
    }//GEN-LAST:event_txtpass_ContraActualKeyTyped

    private void txtpass_ContraNueva1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraNueva1KeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txtpass_ContraNueva1.getText(), 20))
            evt.consume();
    }//GEN-LAST:event_txtpass_ContraNueva1KeyTyped

    private void txtpass_ContraNueva2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass_ContraNueva2KeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txtpass_ContraNueva2.getText(), 20))
            evt.consume();
    }//GEN-LAST:event_txtpass_ContraNueva2KeyTyped

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
            java.util.logging.Logger.getLogger(JDialog_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_Contraseña dialog = new JDialog_Contraseña(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_Acep;
    private javax.swing.JButton btn_Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel lbl_ContraA;
    private javax.swing.JLabel lbl_NuevaContra;
    private javax.swing.JLabel lbl_NuevaContra2;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JPasswordField txtpass_ContraActual;
    private javax.swing.JPasswordField txtpass_ContraNueva1;
    private javax.swing.JPasswordField txtpass_ContraNueva2;
    // End of variables declaration//GEN-END:variables
}

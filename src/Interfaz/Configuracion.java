package Interfaz;

import javax.swing.ImageIcon;
import Clases.Configurar;
import Clases.Validar;
import java.awt.event.KeyEvent;

/**
 * @author keiss
 */
public class Configuracion extends javax.swing.JDialog {

    private void iniciarComponentes(){
        setTitle("Configuración - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        this.setResizable(false); //No permite modificar el tamaño
        setSize(530, 380); //Tamaño por defecto
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); //Icono de la app
    }
    
    public Configuracion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarComponentes();
        Validar v = new Validar();

        txt_StockMinimo.setText(String.valueOf(v.cargaStockMinimo()));
        txt_StockMaximo.setText(String.valueOf(v.cargaStockMaximo()));
        
        if (v.permitirEmpleado())
            ckb_Empleado.setSelected(true);
        
        if (v.ventana())
            ckb_Permitir1.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        txt_StockMinimo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_StockMaximo = new javax.swing.JTextField();
        ckb_Empleado = new javax.swing.JCheckBox();
        ckb_Permitir1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btn_Aceptar = new javax.swing.JButton();
        btn_Volver1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Stock Minimo.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 30));

        txt_StockMinimo.setForeground(new java.awt.Color(0, 153, 153));
        txt_StockMinimo.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_StockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_StockMinimoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_StockMinimoKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_StockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 95, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Stock Maximo.png"))); // NOI18N
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));

        txt_StockMaximo.setForeground(new java.awt.Color(0, 153, 153));
        txt_StockMaximo.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_StockMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_StockMaximoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_StockMaximoKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_StockMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 95, 30));

        ckb_Empleado.setForeground(new java.awt.Color(0, 204, 204));
        ckb_Empleado.setText("Permitir al empleado exceso a todo");
        jLayeredPane1.add(ckb_Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        ckb_Permitir1.setForeground(new java.awt.Color(0, 204, 204));
        ckb_Permitir1.setText("Permitir aviso en ventana");
        jLayeredPane1.add(ckb_Permitir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, 30));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 470, 190));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Configuracion.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

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
        getContentPane().add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 170, 40));

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
        getContentPane().add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 70, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Configurar cargarConfiguracion(){
        Configurar conf = new Configurar();
        
        conf.setId(1);
        
        conf.setStockMinimo(Integer.valueOf(txt_StockMinimo.getText()));
        conf.setStockMaximo(Integer.valueOf(txt_StockMaximo.getText()));
        
        conf.setIniciarSesion(conf.buscarConfiguracion().getIniciarSesion());
        conf.setIdEmpleado(conf.buscarConfiguracion().getIdEmpleado());
        conf.setContraseña(conf.buscarConfiguracion().getContraseña());
        
        
        int empleado = 0, ventana = 0;
        
        if (ckb_Empleado.isSelected())
            empleado = 1;
        
        if (ckb_Permitir1.isSelected())
            ventana = 1;
        
        conf.setPermisoEmpleado(empleado);
        
        conf.setVentana(ventana);
        
        return conf;
    }
    
    private void listo(){
        Validar v = new Validar();
        if (!v.campoVacio(txt_StockMinimo.getText()) && !v.campoVacio(txt_StockMaximo.getText())) {
             Configurar conf;
        
            conf = cargarConfiguracion();

            conf.actualizarConfiguracion();

            this.setVisible(false);
        }
    }
    
    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        listo();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void txt_StockMinimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockMinimoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            listo();
    }//GEN-LAST:event_txt_StockMinimoKeyPressed

    private void txt_StockMaximoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockMaximoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            listo();
    }//GEN-LAST:event_txt_StockMaximoKeyPressed

    private void txt_StockMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockMinimoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_StockMinimo.getText(), 4))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_StockMinimoKeyTyped

    private void txt_StockMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockMaximoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_StockMaximo.getText(), 4))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_StockMaximoKeyTyped

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Configuracion dialog = new Configuracion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JCheckBox ckb_Empleado;
    private javax.swing.JCheckBox ckb_Permitir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField txt_StockMaximo;
    private javax.swing.JTextField txt_StockMinimo;
    // End of variables declaration//GEN-END:variables
}

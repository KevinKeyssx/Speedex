package Interfaz;

import Clases.Conductor;
import Clases.Despacho;
import Clases.Pedido;
import Clases.Validar;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author keiss
 */
public class JDespachos extends javax.swing.JDialog {

    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    static boolean busqueda = false, busqueda2 = false;
    
    public JDespachos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        btn_EnRuta.setVisible(false);
        btn_Entregado.setVisible(false);
       
        setTitle("Despacho - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        this.setResizable(false);
        setSize(860, 560); 
        
        cmb_Pedido.removeAllItems();
        cmb_Pedido.addItem("Código");
        cmb_Pedido.addItem("Rut");
        cmb_Pedido.addItem("Productos");
        cmb_Pedido.addItem("Fecha entrega");
        cmb_Pedido.addItem("Estado");
        
        cmb_Despacho.removeAllItems();
        cmb_Despacho.addItem("Id");
        cmb_Despacho.addItem("Pedido");
        cmb_Despacho.addItem("Conductor");
        
        tablaPedido();
        tablaDespacho();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Pedido = new javax.swing.JTable();
        btn_Revisar = new javax.swing.JButton();
        btn_Aceptar = new javax.swing.JButton();
        btn_EnRuta = new javax.swing.JButton();
        btn_Entregado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        txt_Buscar = new javax.swing.JTextField();
        cmb_Pedido = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_Despacho = new javax.swing.JTable();
        cmb_Despacho = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_BuscarDespacho = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_Volver2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setForeground(new java.awt.Color(0, 204, 204));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Pedido.setBackground(new java.awt.Color(204, 204, 255));
        tb_Pedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_Pedido.setForeground(new java.awt.Color(0, 153, 153));
        tb_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Rut", "Productos", "Destino", "Fecha Entrega", "Ob. Cliente", "Ob. Despacho", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Pedido.setGridColor(new java.awt.Color(0, 51, 51));
        tb_Pedido.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_Pedido.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_PedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Pedido);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 700, 170));

        btn_Revisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Revisar.png"))); // NOI18N
        btn_Revisar.setText("Revisar");
        btn_Revisar.setFocusPainted(false);
        btn_Revisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RevisarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Revisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 110, 40));

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Revisado.png"))); // NOI18N
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.setFocusPainted(false);
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 120, 40));

        btn_EnRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Ruta.png"))); // NOI18N
        btn_EnRuta.setText("En Ruta");
        btn_EnRuta.setFocusPainted(false);
        btn_EnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnRutaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_EnRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 120, 40));

        btn_Entregado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Habilitar.png"))); // NOI18N
        btn_Entregado.setText("Realizado");
        btn_Entregado.setFocusPainted(false);
        btn_Entregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EntregadoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Entregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 120, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

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
        jPanel1.add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 70, 60));

        txt_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 330, 30));

        cmb_Pedido.setForeground(new java.awt.Color(0, 204, 204));
        cmb_Pedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_PedidoActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("=");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Buscar.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 390));

        jTabbedPane1.addTab("Pedidos", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Despacho.setBackground(new java.awt.Color(204, 204, 255));
        tb_Despacho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_Despacho.setForeground(new java.awt.Color(0, 153, 153));
        tb_Despacho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Id Pedido", "Id Conducto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Despacho.setGridColor(new java.awt.Color(0, 51, 51));
        tb_Despacho.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_Despacho.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_Despacho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_DespachoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_Despacho);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 700, 170));

        cmb_Despacho.setForeground(new java.awt.Color(0, 204, 204));
        cmb_Despacho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Despacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_DespachoActionPerformed(evt);
            }
        });
        jPanel3.add(cmb_Despacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 140, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Buscar.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 204));
        jLabel9.setText("=");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 30));

        txt_BuscarDespacho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarDespachoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarDespachoKeyReleased(evt);
            }
        });
        jPanel3.add(txt_BuscarDespacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 330, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        btn_Volver2.setForeground(new java.awt.Color(255, 51, 51));
        btn_Volver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver.png"))); // NOI18N
        btn_Volver2.setBorderPainted(false);
        btn_Volver2.setContentAreaFilled(false);
        btn_Volver2.setFocusPainted(false);
        btn_Volver2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Press.png"))); // NOI18N
        btn_Volver2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Mouse.png"))); // NOI18N
        btn_Volver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Volver2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Volver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 70, 60));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        jLabel11.setText("jLabel3");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 390));

        jTabbedPane1.addTab("Despachos", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 800, 410));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Pedidos y Despachos.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_PedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PedidoMouseClicked
        if (evt.getClickCount() == 2) 
            revisar();
        
        else if (evt.getClickCount() == 1){
            int filaseleccionada = tb_Pedido.getSelectedRow();
            
            switch (tb_Pedido.getValueAt(filaseleccionada, 7).toString()) {
                case "Pendiente":
                    ocultarBotones();
                    btn_Aceptar.setVisible(true);
                break;
                case "Revisado":
                    ocultarBotones();
                    btn_EnRuta.setVisible(true);
                break;
                case "En ruta":
                    ocultarBotones();
                    btn_Entregado.setVisible(true);
                    btn_Entregado.setEnabled(true);
                break;
                case "Entregado":
                    ocultarBotones();
                    btn_Entregado.setVisible(true);
                    btn_Entregado.setEnabled(false);
                break;
                
            }
        }
    }//GEN-LAST:event_tb_PedidoMouseClicked

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        aceptar();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_EntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EntregadoActionPerformed
       entregado();
    }//GEN-LAST:event_btn_EntregadoActionPerformed

    private void btn_EnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnRutaActionPerformed
        enRuta();
    }//GEN-LAST:event_btn_EnRutaActionPerformed

    private void tb_DespachoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DespachoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_DespachoMouseClicked

    private void cmb_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_PedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_PedidoActionPerformed

    private void btn_RevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RevisarActionPerformed
        revisar();
    }//GEN-LAST:event_btn_RevisarActionPerformed

    private void txt_BuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            tablaPedido();
    }//GEN-LAST:event_txt_BuscarKeyPressed

    private void txt_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyReleased
        busqueda = true;
        tablaPedido();
    }//GEN-LAST:event_txt_BuscarKeyReleased

    private void cmb_DespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_DespachoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_DespachoActionPerformed

    private void txt_BuscarDespachoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarDespachoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarDespachoKeyPressed

    private void txt_BuscarDespachoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarDespachoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BuscarDespachoKeyReleased

    private void btn_Volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Volver2ActionPerformed

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
            java.util.logging.Logger.getLogger(JDespachos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDespachos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDespachos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDespachos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDespachos dialog = new JDespachos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_EnRuta;
    private javax.swing.JButton btn_Entregado;
    private javax.swing.JButton btn_Revisar;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JButton btn_Volver2;
    private javax.swing.JComboBox<String> cmb_Despacho;
    private javax.swing.JComboBox<String> cmb_Pedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tb_Despacho;
    private javax.swing.JTable tb_Pedido;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_BuscarDespacho;
    // End of variables declaration//GEN-END:variables

    private void aceptar() {
        int filaseleccionada = tb_Pedido.getSelectedRow();

        if (filaseleccionada >= 0) {
            if(JOptionPane.showConfirmDialog(null, "¿Pasar al estado revisado?", "Revisar", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION){
                
                Pedido ped = new Pedido();
                ped.setId((int) tb_Pedido.getValueAt(filaseleccionada, 0));
                ped.setEstado("Revisado");
                
                if (ped.cambiarEstado()) {
                    btn_Aceptar.setVisible(false);
                    btn_EnRuta.setVisible(true);

                    for (int i = tb_Pedido.getRowCount() - 1; i >=0 ; i--)
                        modelo.removeRow(i); // El modelo limpia la tabla

                    tablaPedido(); // Volvemos a cargar la tabla}
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún pedido.","Seleccione pedido",JOptionPane.INFORMATION_MESSAGE);
    }

    private void enRuta() {
        int filaseleccionada = tb_Pedido.getSelectedRow();

        if (filaseleccionada >= 0) {
        
            if(JOptionPane.showConfirmDialog(null, "¿Pasar al estado en ruta?", "En ruta", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION){
                Pedido ped = new Pedido();
                ped.setId((int) tb_Pedido.getValueAt(filaseleccionada, 0));
                ped.setEstado("En ruta");
                
                if (ped.cambiarEstado()) {
                    btn_EnRuta.setVisible(false);
                    btn_Entregado.setVisible(true);
                    for (int i = tb_Pedido.getRowCount() - 1; i >=0 ; i--)
                        modelo.removeRow(i); // El modelo limpia la tabla

                    tablaPedido(); // Volvemos a cargar la tabla}
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún pedido.","Seleccione pedido",JOptionPane.INFORMATION_MESSAGE);
    }

    private void entregado() {
        int filaseleccionada = tb_Pedido.getSelectedRow();

        if (filaseleccionada >= 0) {
            if(JOptionPane.showConfirmDialog(null, "¿El despacho fue realizado? , una vez realizado ya no se puede cancelar.", "Despacho realizado", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
                Pedido ped = new Pedido();
                ped.setId((int) tb_Pedido.getValueAt(filaseleccionada, 0));
                ped.setEstado("Entregado");
                
                if (ped.cambiarEstado()) {
                    btn_Entregado.setEnabled(false);
                    for (int i = tb_Pedido.getRowCount() - 1; i >=0 ; i--)
                        modelo.removeRow(i); // El modelo limpia la tabla

                    tablaPedido(); // Volvemos a cargar la tabla}
                    ida  = Integer.valueOf(tb_Pedido.getValueAt(filaseleccionada, 0).toString());
                    generarDespacho();
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún pedido.","Seleccione pedido",JOptionPane.INFORMATION_MESSAGE);
    }

    private void tablaPedido() {
        Pedido pedido = new Pedido();
        Validar v = new Validar();

        modelo = (DefaultTableModel)tb_Pedido.getModel();

        String comboProducto = v.obtenerColPedido(cmb_Pedido.getSelectedItem().toString());         
        
        ArrayList <Pedido> cargarDatosPedido = pedido.buscarDatosPedido(busqueda, txt_Buscar.getText(), comboProducto);
        
        if (cargarDatosPedido == null || cargarDatosPedido.isEmpty()){ 
            for (int i = tb_Pedido.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
        }
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_Pedido.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
            
            for (int i = 0; i < 8; i++) 
                tb_Pedido.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo.getColumnCount()];   
            
            for (int i = 0; i < cargarDatosPedido.size(); i++) {

                fila[0]=cargarDatosPedido.get(i).getId();            
                fila[1]=cargarDatosPedido.get(i).getRut();
                fila[2]=cargarDatosPedido.get(i).getCantidad();
                fila[3]=cargarDatosPedido.get(i).getDestino();
                fila[4]=cargarDatosPedido.get(i).getFecha_Entrega();
                fila[5]=cargarDatosPedido.get(i).getOb_Cliente();
                fila[6]=cargarDatosPedido.get(i).getOb_Despacho();
                fila[7]=cargarDatosPedido.get(i).getEstado();

                modelo.addRow(fila);
            } 
            
            tb_Pedido.setModel(modelo);
        }
    }

    private Pedido cargarPedido() {
        Pedido ped = new Pedido();
        return ped;
    }
    
    static int ida;
    
    private void revisar() {
        Pedido pedido;
        int filaseleccionada = tb_Pedido.getSelectedRow();

        if (filaseleccionada >= 0) {

            pedido = cargarPedido();
            int id = Integer.valueOf(tb_Pedido.getValueAt(filaseleccionada, 0).toString());
            //JOptionPane.showMessageDialog(null, "ID: " + tb_Pedido.getValueAt(filaseleccionada, 0),"Seleccione pedido",JOptionPane.INFORMATION_MESSAGE);
            Revisar rev = new Revisar(this, true, id);
            rev.setVisible(true);

            for (int i = tb_Pedido.getRowCount() - 1; i >=0 ; i--)
                modelo.removeRow(i); // El modelo limpia la tabla

            tablaPedido(); // Volvemos a cargar la tabla
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún pedido.","Seleccione pedido",JOptionPane.INFORMATION_MESSAGE);
    }

    private void ocultarBotones() {
        btn_Aceptar.setVisible(false);
        btn_EnRuta.setVisible(false);
        btn_Entregado.setVisible(false);
    }  
        
    private void generarDespacho(){
        Despacho despacho = new Despacho();
         Random rn = new Random();
        Conductor con = new Conductor();
        despacho.setPedido(ida);
        despacho.setConductor(rn.nextInt(con.calculoConductor("COUNT", "Id_Conductor").getId()) + 1);
        
        if (despacho.insertarDespacho())
            tablaDespacho();
    }

    private void tablaDespacho() {
        Despacho despacho = new Despacho();
        Validar v = new Validar();

        modelo1 = (DefaultTableModel)tb_Despacho.getModel();

        String cmb_despacho = v.cargarCMBDespacho(cmb_Despacho.getSelectedItem().toString());         
        
        ArrayList <Despacho> cargarDatosDespacho = despacho.buscarDatosDespacho(busqueda2, txt_BuscarDespacho.getText(), cmb_despacho);
        
        if (cargarDatosDespacho == null || cargarDatosDespacho.isEmpty()){ 
            for (int i = tb_Despacho.getRowCount() -1; i >= 0; i--)
                modelo1.removeRow(i); 
        }
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_Despacho.getRowCount() -1; i >= 0; i--)
                modelo1.removeRow(i); 
            
            for (int i = 0; i < tb_Despacho.getColumnCount(); i++) 
                tb_Despacho.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo1.getColumnCount()];   
            
            for (int i = 0; i < cargarDatosDespacho.size(); i++) {

                fila[0]=cargarDatosDespacho.get(i).getId();            
                fila[1]=cargarDatosDespacho.get(i).getPedido();
                fila[2]=cargarDatosDespacho.get(i).getConductor();
//                fila[3]=cargarDatosPedido.get(i).getDestino();
//                fila[4]=cargarDatosPedido.get(i).getFecha_Entrega();
//                fila[5]=cargarDatosPedido.get(i).getOb_Cliente();
//                fila[6]=cargarDatosPedido.get(i).getOb_Despacho();
//                fila[7]=cargarDatosPedido.get(i).getEstado();

                modelo1.addRow(fila);
            } 
            
            tb_Despacho.setModel(modelo1);
        }
    }
}
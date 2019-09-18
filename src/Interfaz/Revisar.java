package Interfaz;

import Clases.DetallePedido;
import Clases.Pedido;
import Clases.Validar;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author keiss
 */
public class Revisar extends javax.swing.JDialog {

    DefaultTableModel modelo;
    DetallePedido pd;
    
    private void iniciarComponentes(){
        setTitle("Revisión - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        this.setResizable(false);
        setSize(800, 480); 
    
    }
    
    public Revisar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarComponentes();
    }
    
    public Revisar(javax.swing.JDialog parent, boolean modal,int id) {
        super(parent, modal);
        initComponents();
        iniciarComponentes();
        
        tablaDetalle(id);
        fechaEntrega(id);
        fechaPedido(id);
        tipoTarjeta(id);
        destino(id);
        recomendacion(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Detalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Recomendacion = new javax.swing.JLabel();
        lbl_Entrega = new javax.swing.JLabel();
        lbl_Pedido = new javax.swing.JLabel();
        lbl_Tarjeta = new javax.swing.JLabel();
        lbl_Destino = new javax.swing.JLabel();
        lbl_Titulo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Detalle.setBackground(new java.awt.Color(204, 204, 255));
        tb_Detalle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_Detalle.setForeground(new java.awt.Color(0, 153, 153));
        tb_Detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Pedido", "Codigo", "Cantidad", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Detalle.setGridColor(new java.awt.Color(0, 51, 51));
        tb_Detalle.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_Detalle.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_Detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_DetalleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Detalle);

        jLayeredPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 680, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Destino.png"))); // NOI18N
        jLabel1.setText("Destino:");
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Tipo tarjeta.png"))); // NOI18N
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Fecha Pedido.png"))); // NOI18N
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 110, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Fecha entrega.png"))); // NOI18N
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Recomendacion.png"))); // NOI18N
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, 30));

        lbl_Recomendacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Recomendacion.setForeground(new java.awt.Color(255, 102, 102));
        lbl_Recomendacion.setText("jLabel6");
        jLayeredPane1.add(lbl_Recomendacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 90, 30));

        lbl_Entrega.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_Entrega.setForeground(new java.awt.Color(0, 153, 153));
        lbl_Entrega.setText("jLabel7");
        jLayeredPane1.add(lbl_Entrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, 30));

        lbl_Pedido.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_Pedido.setForeground(new java.awt.Color(0, 153, 153));
        lbl_Pedido.setText("jLabel7");
        jLayeredPane1.add(lbl_Pedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, 30));

        lbl_Tarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Tarjeta.setForeground(new java.awt.Color(0, 153, 153));
        lbl_Tarjeta.setText("jLabel7");
        jLayeredPane1.add(lbl_Tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, 30));

        lbl_Destino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Destino.setForeground(new java.awt.Color(0, 153, 153));
        lbl_Destino.setText("jLabel7");
        jLayeredPane1.add(lbl_Destino, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, 30));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 740, 290));

        lbl_Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Revision.png"))); // NOI18N
        getContentPane().add(lbl_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 60));

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
        getContentPane().add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 70, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_DetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DetalleMouseClicked
  
    }//GEN-LAST:event_tb_DetalleMouseClicked

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

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
            java.util.logging.Logger.getLogger(Revisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Revisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Revisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Revisar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Revisar dialog = new Revisar(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Destino;
    private javax.swing.JLabel lbl_Entrega;
    private javax.swing.JLabel lbl_Pedido;
    private javax.swing.JLabel lbl_Recomendacion;
    private javax.swing.JLabel lbl_Tarjeta;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTable tb_Detalle;
    // End of variables declaration//GEN-END:variables

    private void tablaDetalle(int id) {
        DetallePedido dpedido = new DetallePedido();
        Validar v = new Validar();
        
        dpedido.setId_Pedido(id); 
        modelo = (DefaultTableModel)tb_Detalle.getModel();

        //String comboProducto = v.cargarCMBProducto(cmb_BusquedaProducto.getSelectedItem().toString());         
        
        ArrayList <DetallePedido> cargarDatosPedido = dpedido.buscarDatosPedido();
        
        if (cargarDatosPedido == null || cargarDatosPedido.isEmpty()){ 
            for (int i = tb_Detalle.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
        }
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_Detalle.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
            
            for (int i = 0; i < 4; i++) 
                tb_Detalle.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo.getColumnCount()];   
            
            for (int i = 0; i < cargarDatosPedido.size(); i++) {

                fila[0]=cargarDatosPedido.get(i).getId_Pedido();            
                fila[1]=cargarDatosPedido.get(i).getCodigo();
                fila[2]=cargarDatosPedido.get(i).getCantidad();
                fila[3]=v.numerosConPuntos(cargarDatosPedido.get(i).getSubTotal()) ;

                modelo.addRow(fila);
            } 
            
            tb_Detalle.setModel(modelo);
        }
    }

    private void fechaEntrega(int id) {
        Pedido ped = new Pedido();
        lbl_Entrega.setText(" "+ped.buscarPedido(id).getFecha_Entrega());
    }

    private void fechaPedido(int id) {
        Pedido ped = new Pedido();
        lbl_Pedido.setText(" "+ped.buscarPedido(id).getFecha_Pedido());
    }

    private void tipoTarjeta(int id) {
        Pedido ped = new Pedido();
        lbl_Tarjeta.setText(" "+ped.buscarPedido(id).getTarjeta());
    }

    private void destino(int id) {
        Pedido ped = new Pedido();
        lbl_Destino.setText(" "+ped.buscarPedido(id).getDestino());
    }

    private void recomendacion(int id) {
        Validar v = new Validar();
        DetallePedido dpedido = new DetallePedido();
        
        dpedido.setId_Pedido(id); 
        
        double ancho = 0, largo = 0, alto = v.obtenerDimProd(tb_Detalle.getValueAt(0, 1).toString(), "Alto"), peso = v.obtenerDimProd(tb_Detalle.getValueAt(0, 1).toString(), "Peso");
        int moto = 1, movil = 0;
        
        ArrayList<DetallePedido> buscarPedido = dpedido.buscarDatosPedido();

        for (int i = 0; i < modelo.getRowCount(); i++){ 
            ancho = ancho + v.formulaDimension("SUM", "Ancho", buscarPedido.get(0).getId());
            largo = largo + v.formulaDimension("SUM", "Largo", buscarPedido.get(0).getId());
        }
      
        //double anchomovil = 0, largomovil = 0, altomovil = 0;
        
        double espacioProducto = ancho * largo * alto;
        double espacioMoto = v.obtenerAnchoMovil(1) * v.obtenerLargoMovil(1) * v.obtenerAltoMovil(1);
        double espacioMovil = v.obtenerAnchoMovil(2) * v.obtenerLargoMovil(2) * v.obtenerAltoMovil(2);
        
        double porcentaje = espacioProducto * 1.05; // Un 105% mas

        if (porcentaje >= espacioMoto) {
            movil++;
            if (porcentaje >= espacioMovil) 
                movil++;
        }
        
        if (movil > 0) {
            lbl_Recomendacion.setText(movil + " Móviles");
            if (movil == 1) 
                lbl_Recomendacion.setText(movil + " Móvil");
        }
        else {
            if (moto == 1)
                lbl_Recomendacion.setText(moto + " Moto");
            else
                lbl_Recomendacion.setText(moto + " Motos");
        }
    }
}
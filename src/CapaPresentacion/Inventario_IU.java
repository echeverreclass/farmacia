/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaNegocio.ColorearColumnasJTable;
import CapaNegocio.EntradaProductoBD;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class Inventario_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form Inventario_IU
     */
    public Inventario_IU() {
        initComponents();
        reportar();
         ColorearColumnasJTable co15=new ColorearColumnasJTable(9, Color.YELLOW);
        ColorearColumnasJTable co17=new ColorearColumnasJTable(11, Color.PINK);
        
        tabla_reporte_inventario.getColumnModel().getColumn(9).setCellRenderer(co15);
        tabla_reporte_inventario.getColumnModel().getColumn(11).setCellRenderer(co17);
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_inventario_temporal = (DefaultTableModel) tabla_reporte_inventario.getModel();
        tabla_temporal_inventario_temporal.setRowCount(0);
    }

    private void reportar() {
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        limpiar_tabla_formulario();
        DefaultTableModel tabla_temporal_inventario = (DefaultTableModel) this.tabla_reporte_inventario.getModel();
        DefaultTableModel tabla_temporal;
        EntradaProductoBD oEntradaProductoBD = new EntradaProductoBD();
        tabla_temporal = oEntradaProductoBD.inventario();
        int cantProducto = tabla_temporal.getRowCount();
        String medidaFinal;
        String stockFinal;
        double precioCompraFinal = 0;
        double dineroVendiendoMayor = 0;
        double dineroVendiendoUnidades = 0;
        double dineroVentaMedida = 0;
        double dineroInvertido = 0;

        for (int i = 0; i < cantProducto; i++) {
            int idep = Integer.parseInt(tabla_temporal.getValueAt(i, 0).toString());
            String presentacion = tabla_temporal.getValueAt(i, 4).toString();
            String equivalencia = tabla_temporal.getValueAt(i, 5).toString();
            if (presentacion.equals(equivalencia)) {
                medidaFinal = equivalencia;
                precioCompraFinal = Double.parseDouble(tabla_temporal.getValueAt(i, 13).toString());
                stockFinal = tabla_temporal.getValueAt(i, 11).toString();
                dineroVentaMedida = Double.parseDouble(tabla_temporal.getValueAt(i, 15).toString());

            } else {
                medidaFinal = presentacion;
                precioCompraFinal = Double.parseDouble(tabla_temporal.getValueAt(i, 12).toString());
                stockFinal = tabla_temporal.getValueAt(i, 10).toString();
                dineroVentaMedida = Double.parseDouble(tabla_temporal.getValueAt(i, 14).toString());

            }
            dineroVendiendoMayor += Double.parseDouble(tabla_temporal.getValueAt(i, 14).toString());
            dineroVendiendoUnidades += Double.parseDouble(tabla_temporal.getValueAt(i, 15).toString());
            dineroInvertido = dineroInvertido + precioCompraFinal;
            String ingreso = tabla_temporal.getValueAt(i, 1).toString();
            String serie = tabla_temporal.getValueAt(i, 2).toString();
            String producto = tabla_temporal.getValueAt(i, 3).toString();
            String marca = tabla_temporal.getValueAt(i, 6).toString();
            String categoria = tabla_temporal.getValueAt(i, 7).toString();
            String lote = tabla_temporal.getValueAt(i, 8).toString();
            String fechaVcto = tabla_temporal.getValueAt(i, 9).toString();
            String tienda = tabla_temporal.getValueAt(i, 16).toString();

            Object[] data = {idep, ingreso, serie, producto, medidaFinal, marca, categoria, lote, fechaVcto, stockFinal, precioCompraFinal, dineroVentaMedida, tienda};
            tabla_temporal_inventario.addRow(data);

        }
        BigDecimal numero = new BigDecimal(dineroInvertido);
        BigDecimal dineroCompra = numero.setScale(2, RoundingMode.DOWN);

        BigDecimal numero1 = new BigDecimal(dineroVendiendoMayor);
        BigDecimal dineroGananciaMayor = numero1.setScale(1, RoundingMode.DOWN);

        BigDecimal numero2 = new BigDecimal(dineroVendiendoUnidades);
        BigDecimal dineroGananciaMenor = numero2.setScale(1, RoundingMode.DOWN);

        txtCantidad.setText("" + cantProducto);
        txtDineroInvertido.setText("" + dineroCompra);
        txtVendiendoMayor.setText("" + dineroGananciaMayor);
        txtVendiendoMenor.setText("" + dineroGananciaMenor);

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_inventario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtDineroInvertido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnImprimir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtVendiendoMenor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVendiendoMayor = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INVENTARIO");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("+ Solo muestra los productos que tienen stock");

        tabla_reporte_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "INGRESO", "SERIE", "PRODUCTO", "MEDIDA", "MARCA", "CATEGORIA", "LOTE", "FECHAVCTO", "STOCK", "PCOMPRA", "PVENTA", "TIENDA"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_inventario);
        if (tabla_reporte_inventario.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_inventario.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla_reporte_inventario.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla_reporte_inventario.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla_reporte_inventario.getColumnModel().getColumn(3).setPreferredWidth(500);
        }

        jLabel2.setText("DINERO INVERTIDO");

        txtDineroInvertido.setEnabled(false);

        jLabel3.setText("CANT. PRODUCTOS");

        txtCantidad.setEnabled(false);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora1.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");

        jLabel4.setText("DINERO VENDIDO X MENOR");

        txtVendiendoMenor.setEnabled(false);

        jLabel5.setText("DINERO VENDIENDO X MAYOR");

        txtVendiendoMayor.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDineroInvertido, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVendiendoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVendiendoMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDineroInvertido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtVendiendoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtVendiendoMayor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImprimir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_inventario;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDineroInvertido;
    private javax.swing.JTextField txtVendiendoMayor;
    private javax.swing.JTextField txtVendiendoMenor;
    // End of variables declaration//GEN-END:variables
}

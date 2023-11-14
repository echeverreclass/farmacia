/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Compra;
import CapaDatos.DetalleCompra;
import CapaDatos.Medida;
import CapaNegocio.ColorearColumnasJTable;
import CapaNegocio.CompraBD;
import CapaNegocio.DetalleCompraBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import CapaNegocio.ProveedorBD;
import static CapaPresentacion.Menuu_IU.escritorioo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class Compra_IU extends javax.swing.JInternalFrame {

    List<Medida> lista_medida;

    /**
     * Creates new form Compra_IU
     */
    public Compra_IU() {
        initComponents();
        cargarMedida();
        
         ColorearColumnasJTable co15=new ColorearColumnasJTable(6, Color.YELLOW);
        ColorearColumnasJTable co17=new ColorearColumnasJTable(5, Color.PINK);
        
        tabla_reporte_detalle_productos.getColumnModel().getColumn(6).setCellRenderer(co15);
        tabla_reporte_detalle_productos.getColumnModel().getColumn(5).setCellRenderer(co17);
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        tabla_temporal_compras.setRowCount(0);
    }

    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }

    private void cargarMedida() {
        try {
            cmbMedida.removeAllItems();
            MedidaBD oMedidaBD = new MedidaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oMedidaBD.reportarMedida();
            lista_medida = new ArrayList<>();
            cmbMedida.addItem("Seleccionar");
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {

                int idmedida = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String presentacion = String.valueOf(tabla_temporal.getValueAt(i, 1));

                lista_medida.add(new Medida(idmedida, presentacion, ""));
                cmbMedida.addItem(presentacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error al cargar Medida", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarAgregar() {
        txtBarras.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtLote.setText("");
        txtImporte.setText("");
        cmbMedida.setSelectedIndex(0);
    }

    private void calculaTotal() {
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        int maxCompras = tabla_temporal_compras.getRowCount();
        double total = 0;
        for (int i = 0; i < maxCompras; i++) {
            total = total + (Double) tabla_temporal_compras.getValueAt(i, 6);
        }
        BigDecimal numero = new BigDecimal(total);
        BigDecimal decimal_total = numero.setScale(2, RoundingMode.DOWN);
        txtSubTotal.setText("" + decimal_total);
        txtTotalPagar.setText("" + decimal_total);
    }
    public void registrarDetalleCompra(int idcompra) {
        DefaultTableModel tabla_temporal_pedidos = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
        int cantCompras = tabla_temporal_pedidos.getRowCount();
        DetalleCompra oDetalleCompra = new DetalleCompra();
        DetalleCompraBD oDetalleCompraBD = new DetalleCompraBD();

        for (int i = 0; i < cantCompras; i++) {
            oDetalleCompra.setIdcompra(idcompra);
            oDetalleCompra.setpSerie(tabla_temporal_pedidos.getValueAt(i, 0).toString());
            oDetalleCompra.setDeCantidad((Double) tabla_temporal_pedidos.getValueAt(i, 4));
            oDetalleCompra.setDePrecio((Double) tabla_temporal_pedidos.getValueAt(i, 5));
            oDetalleCompra.setDeImporte((Double) tabla_temporal_pedidos.getValueAt(i, 6));
            oDetalleCompra.setDclote(tabla_temporal_pedidos.getValueAt(i, 2).toString());
            oDetalleCompra.setDcPresentacion(tabla_temporal_pedidos.getValueAt(i, 3).toString());
            oDetalleCompraBD.registrarDetalleCompra(oDetalleCompra);

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox<>();
        cmbFormaPago = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroComprobante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dcFechaCompra = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cmbMoneda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbTienda = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBarras = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_productos = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSubTotalDscto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtFlete = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("COMPRA");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA COMPRA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("TIPO COMPROBANTE");

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTURA", "BOLETA" }));

        cmbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO" }));

        jLabel2.setText("FORMA DE PAGO");

        jLabel3.setText("NRO COMPROBANTE");

        txtNroComprobante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNroComprobanteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroComprobanteFocusLost(evt);
            }
        });
        txtNroComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNroComprobanteKeyPressed(evt);
            }
        });

        jLabel4.setText("FECHA DE COMPRA");

        dcFechaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dcFechaCompraKeyPressed(evt);
            }
        });

        jLabel5.setText("MONEDA");

        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLES", "DOLAR" }));

        jLabel6.setText("TIENDA");

        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));

        jLabel7.setText("TIPO DE PAGO");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(cmbFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(dcFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroComprobante)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dcFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel8.setText("RUC");

        txtRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRucFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRucFocusLost(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRucKeyPressed(evt);
            }
        });

        txtRazonSocial.setEnabled(false);

        jLabel9.setText("RAZON SOCIAL");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar_proveedor.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 250, Short.MAX_VALUE))
                    .addComponent(txtRazonSocial))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("BARRAS");

        txtBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBarrasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBarrasFocusLost(evt);
            }
        });
        txtBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarrasActionPerformed(evt);
            }
        });
        txtBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarrasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBarrasKeyTyped(evt);
            }
        });

        jLabel11.setText("PRODUCTO");

        txtProducto.setEnabled(false);

        jLabel12.setText("PRESENTACION");

        jLabel13.setText("LOTE");

        txtLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoteFocusLost(evt);
            }
        });
        txtLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLoteKeyTyped(evt);
            }
        });

        jLabel14.setText("CANT");

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioFocusLost(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel15.setText("PRECIO");

        txtImporte.setEnabled(false);
        txtImporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImporteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImporteFocusLost(evt);
            }
        });
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImporteKeyPressed(evt);
            }
        });

        jLabel16.setText("IMPORTE");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/venta2.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jButton1.setText("..");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_reporte_detalle_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BARRAS", "PRODUCTO", "LOTE", "PRESENTACION", "CANT", "PRECIO", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_detalle_productos);
        if (tabla_reporte_detalle_productos.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_detalle_productos.getColumnModel().getColumn(1).setPreferredWidth(800);
        }

        jLabel17.setText("SUBTOTAL");

        txtSubTotal.setEnabled(false);

        txtDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusLost(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
        });

        jLabel18.setText("DESCUENTO");

        jLabel19.setText("SUBTOTAL CON DSCTO");

        txtSubTotalDscto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSubTotalDsctoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotalDsctoFocusLost(evt);
            }
        });
        txtSubTotalDscto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubTotalDsctoKeyPressed(evt);
            }
        });

        jLabel20.setText("FLETE");

        txtFlete.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFleteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFleteFocusLost(evt);
            }
        });
        txtFlete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFleteActionPerformed(evt);
            }
        });
        txtFlete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFleteKeyPressed(evt);
            }
        });

        jLabel21.setText("IGV");

        txtIgv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIgvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIgvFocusLost(evt);
            }
        });
        txtIgv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIgvKeyPressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel22.setText("TOTAL A PAGAR");

        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalPagar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtSubTotalDscto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubTotalDscto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFlete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (txtRuc.getText().length() > 0) {
            DefaultTableModel tabla_temporal;
            ProveedorBD oProveedorBD = new ProveedorBD();
            tabla_temporal = oProveedorBD.buscarProveedor(txtRuc.getText().trim());

            if (tabla_temporal.getRowCount() > 0) {
                txtRazonSocial.setText(tabla_temporal.getValueAt(0, 1).toString());

            } else {
                error("No se encontro, tienes que registrarlo primero al proveedor");
                txtRuc.requestFocus();
                txtRazonSocial.setText("");
            }
        } else {
            advertencia("Ingrese el ruc para buscar al proveedor");
            txtRuc.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        int cant_producto = tabla_reporte_detalle_productos.getRowCount();
        if (cant_producto > 0) {
            if (txtNroComprobante.getText().length() > 0) {
                if (txtRuc.getText().length() > 0) {
                    if (txtRazonSocial.getText().length() > 0) {
                        if (txtSubTotal.getText().length() > 0) {
                            if (txtDescuento.getText().length() > 0) {
                                if (txtSubTotalDscto.getText().length() > 0) {
                                    if (txtFlete.getText().length() > 0) {
                                        if (txtIgv.getText().length() > 0) {
                                            if (dcFechaCompra.getDate() != null) {
                                                // ATRIBUTOS
                                                Compra oCompra = new Compra();
                                                //METODOS
                                                CompraBD oCompraBD = new CompraBD();

                                                SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                                                String fecha=dcn.format(dcFechaCompra.getDate());
                                                oCompra.setCoFecha(fecha);
                                                oCompra.setCoTipoDoc(cmbTipoComprobante.getSelectedItem().toString());
                                                oCompra.setConNro(txtNroComprobante.getText().toUpperCase());
                                                oCompra.setCoTipoPago(cmbTipoPago.getSelectedItem().toString());
                                                oCompra.setCoFormaPago(cmbFormaPago.getSelectedItem().toString());
                                                oCompra.setCoMoneda(cmbMoneda.getSelectedItem().toString());
                                                oCompra.setCoSubTotal(Double.parseDouble(txtSubTotal.getText().trim()));
                                                oCompra.setCoFlete(Double.parseDouble(txtFlete.getText().trim()));
                                                oCompra.setCoIgv(Double.parseDouble(txtIgv.getText().trim()));
                                                oCompra.setCoTotal(Double.parseDouble(txtTotalPagar.getText().trim()));
                                                oCompra.setProvRuc(txtRuc.getText().trim());
                                                oCompra.setuDni(Login_IU.dni_publico);
                                                oCompra.setTienda(cmbTienda.getSelectedItem().toString());

                                                int rpta = oCompraBD.registrarCompra(oCompra);
                                                if (rpta>-1) {
                                                    registrarDetalleCompra(rpta);

                                                    exito("Se registro con exito");
                                                    limpiarAgregar();
                                                    limpiar_tabla_formulario();
                                                } else {
                                                    error("No se pudo realizar la compra");
                                                }
                                            } else {
                                                advertencia("Seleccione una fecha");
                                                dcFechaCompra.requestFocus();
                                            }
                                        } else {
                                            advertencia("Ingrese el igv de la compra sino hubiera coloque 0 ...");
                                            txtIgv.requestFocus();
                                        }
                                    } else {
                                        advertencia("Ingrese el flete de la compra. Sino hubiera coloque 0...");
                                        txtFlete.requestFocus();
                                    }
                                } else {
                                    advertencia("Ingrese el subtotal con descuento de la compra. Sino no hubiera coloque 0...");
                                    txtSubTotalDscto.requestFocus();
                                }
                            } else {
                                advertencia("Ingrese el descuento de la compra. Sino no hubiera coloque 0...");
                                txtDescuento.requestFocus();
                            }
                        } else {
                            advertencia("Ingrese el subtotal de la compra");
                            txtSubTotal.requestFocus();
                        }
                    } else {
                        advertencia("Coloque un Ruc valido");
                        txtRuc.requestFocus();
                    }
                } else {
                    advertencia("Coloque el Ruc del proveedor");
                    txtRuc.requestFocus();
                }
            } else {
                advertencia("INgrese el nro de comprobante de la compra");
                txtNroComprobante.requestFocus();
            }
        } else {
            advertencia("No hay productos en la lista");
            txtBarras.requestFocus();
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        // TODO add your handling code here:}
        try {
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            double cant = Double.parseDouble(txtCantidad.getText().trim());

            double resultado = precio * cant;

            BigDecimal numero = new BigDecimal(resultado);
            BigDecimal decimales = numero.setScale(2, RoundingMode.DOWN);
            txtImporte.setText("" + decimales);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtProducto.getText().length() > 0) {
            if (txtImporte.getText().length() > 0) {
                if (txtPrecio.getText().length() > 0) {
                    if (txtLote.getText().length() > 0) {
                        if (!cmbMedida.getSelectedItem().equals("Seleccionar")) {
                            String barras = txtBarras.getText().trim();
                            String producto = txtProducto.getText().trim();
                            String lote = txtLote.getText().trim().toUpperCase();
                            String presentacion = cmbMedida.getSelectedItem().toString();
                            double precio = Double.parseDouble(txtPrecio.getText().trim());
                            double cant = Double.parseDouble(txtCantidad.getText().trim());
                            double importe = Double.parseDouble(txtImporte.getText().trim());

                            DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
                            Object[] data = {barras, producto, lote, presentacion, cant, precio, importe};
                            tabla_temporal_compras.addRow(data);
                            limpiarAgregar();
                            calculaTotal();

                        } else {
                            advertencia("Selecciona una medida");
                            txtBarras.requestFocus();
                        }
                    } else {
                        advertencia("Ingrese lote de la compra");
                        txtLote.requestFocus();
                    }
                } else {
                    advertencia("Ingrese el precio del producto");
                    txtPrecio.requestFocus();
                }
            } else {
                advertencia("Calcular el importe");
                txtImporte.requestFocus();
            }
        } else {
            advertencia("Ingrese un producto");
            txtProducto.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarrasActionPerformed
        // TODO add your handling code here:
        if (txtBarras.getText().length() > 0) {
            DefaultTableModel tabla_temporal;
            ProductoBD oProductoBD = new ProductoBD();
            tabla_temporal = oProductoBD.buscarProducto(txtBarras.getText().trim());
            if (tabla_temporal.getRowCount() > 0) {
                txtProducto.setText(tabla_temporal.getValueAt(0, 1).toString());
            } else {
                error("No se encontro el producto con ese codigo de barras");
                txtBarras.requestFocus();
                txtProducto.setText("");
            }
        } else {
            advertencia("Ingrese codigo de barras");
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_txtBarrasActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_reporte_detalle_productos.getSelectedRow();
        try {
            DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_detalle_productos.getModel();
            tabla_temporal_compras.removeRow(filaSeleccionada);
            tabla_reporte_detalle_productos.setModel(tabla_temporal_compras);
            calculaTotal();
        } catch (Exception e) {
            error("Error al quitar");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtNroComprobanteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroComprobanteFocusGained
        // TODO add your handling code here:
        
        txtNroComprobante.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNroComprobanteFocusGained

    private void txtNroComprobanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroComprobanteFocusLost
        // TODO add your handling code here:
        txtNroComprobante.setBackground(Color.white);
    }//GEN-LAST:event_txtNroComprobanteFocusLost

    private void txtRucFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusGained
        // TODO add your handling code here:
        
        txtRuc.setBackground(Color.yellow);
    }//GEN-LAST:event_txtRucFocusGained

    private void txtRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusLost
        // TODO add your handling code here:
        txtRuc.setBackground(Color.white);
    }//GEN-LAST:event_txtRucFocusLost

    private void txtBarrasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarrasFocusGained
        // TODO add your handling code here:
        txtBarras.setBackground(Color.yellow);
    }//GEN-LAST:event_txtBarrasFocusGained

    private void txtBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBarrasFocusLost
        // TODO add your handling code here:
        txtBarras.setBackground(Color.white);
    }//GEN-LAST:event_txtBarrasFocusLost

    private void txtLoteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoteFocusGained
        // TODO add your handling code here:
        
        txtLote.setBackground(Color.yellow);
    }//GEN-LAST:event_txtLoteFocusGained

    private void txtLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoteFocusLost
        // TODO add your handling code here:
        txtLote.setBackground(Color.white);
    }//GEN-LAST:event_txtLoteFocusLost

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
        txtCantidad.setBackground(Color.yellow);
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
        
        txtCantidad.setBackground(Color.white);
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        // TODO add your handling code here:
        txtPrecio.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusLost
        // TODO add your handling code here:
        txtPrecio.setBackground(Color.white);
    }//GEN-LAST:event_txtPrecioFocusLost

    private void txtImporteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImporteFocusGained
        // TODO add your handling code here:
        
        txtImporte.setBackground(Color.yellow);
    }//GEN-LAST:event_txtImporteFocusGained

    private void txtImporteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImporteFocusLost
        // TODO add your handling code here:
        txtImporte.setBackground(Color.white);
    }//GEN-LAST:event_txtImporteFocusLost

    private void txtDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusGained
        // TODO add your handling code here:
        txtDescuento.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDescuentoFocusGained

    private void txtDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusLost
        // TODO add your handling code here:
        txtDescuento.setBackground(Color.white);
    }//GEN-LAST:event_txtDescuentoFocusLost

    private void txtFleteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFleteFocusGained
        // TODO add your handling code here:
        txtFlete.setBackground(Color.yellow);
    }//GEN-LAST:event_txtFleteFocusGained

    private void txtFleteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFleteFocusLost
        // TODO add your handling code here:
        txtFlete.setBackground(Color.white);
    }//GEN-LAST:event_txtFleteFocusLost

    private void txtIgvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIgvFocusGained
        // TODO add your handling code here:
        
        txtIgv.setBackground(Color.yellow);
    }//GEN-LAST:event_txtIgvFocusGained

    private void txtIgvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIgvFocusLost
        // TODO add your handling code here:
        txtIgv.setBackground(Color.white);
    }//GEN-LAST:event_txtIgvFocusLost

    private void txtNroComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroComprobanteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dcFechaCompra.requestFocus();
        }
    }//GEN-LAST:event_txtNroComprobanteKeyPressed

    private void dcFechaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dcFechaCompraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRuc.requestFocus();
        }
    }//GEN-LAST:event_dcFechaCompraKeyPressed

    private void txtRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.doClick();
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_txtRucKeyPressed

    private void txtBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbMedida.requestFocus();
        }
    }//GEN-LAST:event_txtBarrasKeyPressed

    private void txtLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCantidad.requestFocus();
        }
    }//GEN-LAST:event_txtLoteKeyPressed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPrecio.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregar.doClick();
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtImporteKeyPressed

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSubTotalDscto.requestFocus();
        }
    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtFleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFleteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtIgv.requestFocus();
        }
    }//GEN-LAST:event_txtFleteKeyPressed

    private void txtIgvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgvKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.doClick();
            btnRegistrar.requestFocus();
        }
    }//GEN-LAST:event_txtIgvKeyPressed

    private void txtBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBarrasKeyTyped

    private void txtLoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtLoteKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtSubTotalDsctoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFlete.requestFocus();
        }
    }//GEN-LAST:event_txtSubTotalDsctoKeyPressed

    private void txtFleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Producto_IU frame = new Producto_IU();
        escritorioo.add(frame);
        Dimension a = escritorioo.getSize();
        Dimension b = frame.getSize();
        frame.setLocation((a.width - b.width) / 2, (a.height - b.height) / 2);
        frame.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSubTotalDsctoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoFocusGained
        // TODO add your handling code here:
        txtSubTotalDscto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtSubTotalDsctoFocusGained

    private void txtSubTotalDsctoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalDsctoFocusLost
        // TODO add your handling code here:
        
        txtSubTotalDscto.setBackground(Color.white);
    }//GEN-LAST:event_txtSubTotalDsctoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbFormaPago;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JComboBox<String> cmbMoneda;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JComboBox<String> cmbTipoComprobante;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private com.toedter.calendar.JDateChooser dcFechaCompra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_detalle_productos;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFlete;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNroComprobante;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSubTotalDscto;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}

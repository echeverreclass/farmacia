/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.EntradaProducto;
import CapaDatos.Kardex;
import CapaDatos.Medida;
import CapaNegocio.ColorearColumnasJTable;
import CapaNegocio.EntradaProductoBD;
import CapaNegocio.KardexBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class EntradaProductos_IU extends javax.swing.JInternalFrame {

    List<Medida> lista_medida;

    /**
     * Creates new form EntradaProductos_IU
     */
    public EntradaProductos_IU() {
        initComponents();
        cargarMedida();
        sacarFecha();
        sacarHora();

         ColorearColumnasJTable co15=new ColorearColumnasJTable(1, Color.YELLOW);
        ColorearColumnasJTable co17=new ColorearColumnasJTable(11, Color.PINK);
        ColorearColumnasJTable co18=new ColorearColumnasJTable(12, Color.ORANGE);
        
        tabla_entrada_productos.getColumnModel().getColumn(2).setCellRenderer(co15);
        tabla_entrada_productos.getColumnModel().getColumn(11).setCellRenderer(co17);
        tabla_entrada_productos.getColumnModel().getColumn(12).setCellRenderer(co18);
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
                String equivalencia = String.valueOf(tabla_temporal.getValueAt(i, 2));

                lista_medida.add(new Medida(idmedida, presentacion, equivalencia));
                cmbMedida.addItem(presentacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error al cargar Medida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sacarHora() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        String tiempo = hora + ":" + minutos + ":" + segundos;
        txtHora.setText(tiempo);
    }

    private void sacarFecha() {

        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;
        txtFecha.setText(fecha);
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

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_productos_temporal = (DefaultTableModel) tabla_entrada_productos.getModel();
        tabla_temporal_productos_temporal.setRowCount(0);
    }

    public void limpiarCajasPrecios() {
        txtCantidadEquivalencia.setText("");
        txtCantidadPresentacion.setText("");
        txtMargenGananciaEquivalencia.setText("0");
        txtMargenGananciaPresentacion.setText("0");
        txtPrecioCompraPresentacion.setText("");
        txtPrecioCompraUnidades.setText("");
        txtPrecioVentaPresentacion.setText("");
        txtPrecioVentaUnidades.setText("");
    }

    public void limpiarProducto() {
        txtBarras.setText("");
        txtProducto.setText("");
        txtEquivalencia.setText("");
        txtLote.setText("");
        dcFechaVcto.setDate(null);
        cargarMedida();
    }

    private void limpiarEntrada() {
        txtNroDocumento.setText("");
        cargarMedida();
        limpiar_tabla_formulario();
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
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        cmbProceso = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBarras = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCantidadPresentacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEquivalencia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCantidadEquivalencia = new javax.swing.JTextField();
        txtPrecioCompraPresentacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPrecioCompraUnidades = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMargenGananciaPresentacion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMargenGananciaEquivalencia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPrecioVentaPresentacion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPrecioVentaUnidades = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        dcFechaVcto = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_entrada_productos = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        cmbTienda = new javax.swing.JComboBox<>();
        btnRegistrar2 = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ENTRADA PRODUCTOS");

        jLabel1.setText("TIPO DOCUMENTO");

        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FACTURA", "BOLETA" }));

        cmbProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPRA", "INVENTARIO INICIAL", "OTROS" }));

        jLabel2.setText("PROCESO");

        jLabel3.setText("NRO DOCUMENTO");

        txtNroDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNroDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroDocumentoFocusLost(evt);
            }
        });
        txtNroDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNroDocumentoKeyPressed(evt);
            }
        });

        jLabel4.setText("HORA");

        txtHora.setEnabled(false);

        jLabel5.setText("FECHA");

        txtFecha.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("BARRAS");

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

        jLabel7.setText("PRESENTACION");

        cmbMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cmbMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedidaItemStateChanged(evt);
            }
        });
        cmbMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMedidaKeyPressed(evt);
            }
        });

        jLabel8.setText("PRODUCTO");

        txtProducto.setEnabled(false);

        jLabel9.setText("CANT. PRES");

        txtCantidadPresentacion.setEnabled(false);
        txtCantidadPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadPresentacionFocusLost(evt);
            }
        });
        txtCantidadPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadPresentacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadPresentacionKeyTyped(evt);
            }
        });

        jLabel10.setText("EQUIVALENCIA");

        txtEquivalencia.setEnabled(false);
        txtEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusLost(evt);
            }
        });

        jLabel11.setText("CANT. EQV");

        txtCantidadEquivalencia.setEnabled(false);
        txtCantidadEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadEquivalenciaFocusLost(evt);
            }
        });
        txtCantidadEquivalencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadEquivalenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadEquivalenciaKeyTyped(evt);
            }
        });

        txtPrecioCompraPresentacion.setEnabled(false);
        txtPrecioCompraPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioCompraPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioCompraPresentacionFocusLost(evt);
            }
        });
        txtPrecioCompraPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioCompraPresentacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioCompraPresentacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraPresentacionKeyTyped(evt);
            }
        });

        jLabel12.setText("PCP");

        jLabel13.setText("PCU");

        txtPrecioCompraUnidades.setEnabled(false);
        txtPrecioCompraUnidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioCompraUnidadesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioCompraUnidadesFocusLost(evt);
            }
        });
        txtPrecioCompraUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioCompraUnidadesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraUnidadesKeyTyped(evt);
            }
        });

        jLabel14.setText("MARGEN G. PRES.");

        txtMargenGananciaPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMargenGananciaPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMargenGananciaPresentacionFocusLost(evt);
            }
        });
        txtMargenGananciaPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMargenGananciaPresentacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMargenGananciaPresentacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMargenGananciaPresentacionKeyTyped(evt);
            }
        });

        jLabel15.setText("MARGEN G. EQUI");

        txtMargenGananciaEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMargenGananciaEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMargenGananciaEquivalenciaFocusLost(evt);
            }
        });
        txtMargenGananciaEquivalencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMargenGananciaEquivalenciaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMargenGananciaEquivalenciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMargenGananciaEquivalenciaKeyTyped(evt);
            }
        });

        jLabel16.setText("PVP");

        txtPrecioVentaPresentacion.setEnabled(false);
        txtPrecioVentaPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioVentaPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVentaPresentacionFocusLost(evt);
            }
        });

        jLabel17.setText("PVU");

        txtPrecioVentaUnidades.setEnabled(false);
        txtPrecioVentaUnidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioVentaUnidadesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVentaUnidadesFocusLost(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel18.setText("FECHA VCTO");

        jLabel19.setText("LOTE");

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
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCantidadPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel11))
                                    .addComponent(txtCantidadEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtPrecioCompraPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtPrecioCompraUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMargenGananciaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProducto)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMargenGananciaEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtPrecioVentaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPrecioVentaUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFechaVcto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnQuitar)
                    .addComponent(btnAgregar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(dcFechaVcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel17))
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrecioCompraPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioCompraUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMargenGananciaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMargenGananciaEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioVentaPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioVentaUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(16, 16, 16))
        );

        tabla_entrada_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SERIE", "PRODUCTO", "LOTE", "FECHAVCTO", "SP", "SEQV", "PCPRES", "PCEQV", "IMPORTE", "MARGEN_PRESENTACION", "MARGEN_EQUIVALENCIA", "PVPRESMayor", "PVEQVMayor", "PRESENTACION", "EQUIVALENCIA", "REF", "PVPMenor", "PVEQVMenor"
            }
        ));
        jScrollPane1.setViewportView(tabla_entrada_productos);
        if (tabla_entrada_productos.getColumnModel().getColumnCount() > 0) {
            tabla_entrada_productos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla_entrada_productos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabla_entrada_productos.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabla_entrada_productos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla_entrada_productos.getColumnModel().getColumn(4).setMinWidth(0);
            tabla_entrada_productos.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla_entrada_productos.getColumnModel().getColumn(5).setPreferredWidth(10);
            tabla_entrada_productos.getColumnModel().getColumn(6).setPreferredWidth(10);
            tabla_entrada_productos.getColumnModel().getColumn(7).setPreferredWidth(10);
            tabla_entrada_productos.getColumnModel().getColumn(8).setPreferredWidth(10);
            tabla_entrada_productos.getColumnModel().getColumn(9).setPreferredWidth(50);
            tabla_entrada_productos.getColumnModel().getColumn(11).setPreferredWidth(50);
            tabla_entrada_productos.getColumnModel().getColumn(12).setPreferredWidth(50);
            tabla_entrada_productos.getColumnModel().getColumn(13).setPreferredWidth(60);
            tabla_entrada_productos.getColumnModel().getColumn(14).setPreferredWidth(60);
            tabla_entrada_productos.getColumnModel().getColumn(15).setPreferredWidth(20);
        }

        jLabel20.setText("TIENDA");

        cmbTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRINCIPAL" }));

        btnRegistrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disk.png"))); // NOI18N
        btnRegistrar2.setText("REGISTRAR");
        btnRegistrar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar2ActionPerformed(evt);
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
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNroDocumento))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHora)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar2)
                        .addGap(1246, 1246, 1246)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cmbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar2ActionPerformed
        // TODO add your handling code here:
        int cantProductos = tabla_entrada_productos.getRowCount();
        if (cantProductos > 0) {
            if (txtNroDocumento.getText().length() > 0) {
                EntradaProducto oEntradaProducto = new EntradaProducto();
                EntradaProductoBD oEntradaProductoBD = new EntradaProductoBD();
                Kardex oKardex = new Kardex();
                KardexBD oKardexBD = new KardexBD();
                String tipoDocumento = cmbTipoDocumento.getSelectedItem().toString();
                String proceso = cmbProceso.getSelectedItem().toString();
                String hora = txtHora.getText().trim();
                String fecha = txtFecha.getText().trim();
                String nroDocumento = txtNroDocumento.getText().trim();
                String tienda = cmbTienda.getSelectedItem().toString();
                DefaultTableModel tabla_temporal_entradas = (DefaultTableModel) tabla_entrada_productos.getModel();
                for (int i = 0; i < cantProductos; i++) {
                    String serie = tabla_temporal_entradas.getValueAt(i, 0).toString();
                    String producto = tabla_temporal_entradas.getValueAt(i, 1).toString();
                    String lote = tabla_temporal_entradas.getValueAt(i, 2).toString();
                    String fechaVcto = tabla_temporal_entradas.getValueAt(i, 3).toString();
                    int stockPresentacion = Integer.parseInt(tabla_temporal_entradas.getValueAt(i, 4).toString());
                    int stockEquivalencia = Integer.parseInt(tabla_temporal_entradas.getValueAt(i, 5).toString());
                    double precioCompraPresentacion = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 6).toString());
                    double precioCompraEquivalencia = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 7).toString());
                    double importe = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 8).toString());
                    int margenPresentacion = Integer.parseInt(tabla_temporal_entradas.getValueAt(i, 9).toString());
                    int margenEquivalencia = Integer.parseInt(tabla_temporal_entradas.getValueAt(i, 10).toString());
                    double precioVentaPresentacionMayor = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 11).toString());
                    double precioVentaPresentacionMenor = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 16).toString());
                    double precioVentaEquivalenciaMayor = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 12).toString());
                    double precioVentaEquivalenciaMenor = Double.parseDouble(tabla_temporal_entradas.getValueAt(i, 17).toString());
                    String presentacion = tabla_temporal_entradas.getValueAt(i, 13).toString();
                    String equivalencia = tabla_temporal_entradas.getValueAt(i, 14).toString();
                    int cantref = Integer.parseInt(tabla_temporal_entradas.getValueAt(i, 15).toString());

                    oEntradaProducto.setpSerie(serie);
                    oEntradaProducto.setLote(lote);
                    oEntradaProducto.setPresentacion(presentacion);
                    oEntradaProducto.setEquivalencia(equivalencia);
                    oEntradaProducto.setFechaVcto(fechaVcto);
                    oEntradaProducto.setStockPresentacion(stockPresentacion);
                    oEntradaProducto.setStockEquivalencia(stockEquivalencia);
                    oEntradaProducto.setPrecioCompraPresentacion(precioCompraPresentacion);
                    oEntradaProducto.setPrecioCompraEquivalencia(precioCompraEquivalencia);
                    oEntradaProducto.setMargenGananciaPresentacion(margenPresentacion);
                    oEntradaProducto.setMargenGananciaEquivalencia(margenEquivalencia);
                    oEntradaProducto.setPrecioVentaPresentacionMayor(precioVentaPresentacionMayor);
                    oEntradaProducto.setPrecioVentaPresentacionMenor(precioVentaPresentacionMenor);
                    oEntradaProducto.setPrecioVentaEquivalenciaMayor(precioVentaEquivalenciaMayor);
                    oEntradaProducto.setPrecioVentaEquivalenciaMenor(precioVentaEquivalenciaMenor);
                    oEntradaProducto.setRef(cantref);
                    oEntradaProducto.setTienda(tienda);

                    oKardex.setFecha(fecha);
                    oKardex.setHora(hora);
                    oKardex.setTipoOPeracion("ENTRADA");
                    oKardex.setkDescripcion(proceso + " " + producto + " - " + tipoDocumento + ": " + nroDocumento);
                    oKardex.setpSerie(serie);
                    oKardex.setLote(lote);
                    int stockMedida;
                    double precioMedida;
                    String medida;
                    if (presentacion.equals(equivalencia)) {
                        stockMedida = stockEquivalencia;
                        precioMedida = precioCompraEquivalencia;
                        medida = equivalencia;
                    } else {
                        stockMedida = stockPresentacion;
                        precioMedida = precioCompraPresentacion;
                        medida = presentacion;
                    }
                    oKardex.setPresentacion(medida);
                    oKardex.setkCantidad(stockMedida);
                    oKardex.setkPrecio(precioMedida);
                    oKardex.setkImporte(importe);
                    oKardex.setTienda(tienda);
                    oEntradaProductoBD.registrarEntradaProducto(oEntradaProducto);
                    oKardexBD.registrarEntradaProducto(oKardex);
                }

                exito("Se registraron los productos con exito");
                limpiarCajasPrecios();
                limpiarProducto();
                limpiarEntrada();
                limpiar_tabla_formulario();
            } else {
                advertencia("Ingrese el nro de documento");
                txtNroDocumento.requestFocus();
            }
        } else {
            advertencia("No hay productos a guardar");
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrar2ActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

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

    private void cmbMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedidaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            String textoSeleccionado = cmbMedida.getSelectedItem().toString();
            if (textoSeleccionado.equals("Seleccionar")) {
                txtEquivalencia.setText("");
                txtCantidadEquivalencia.setEnabled(false);
                txtPrecioCompraPresentacion.setEnabled(false);
                txtPrecioCompraUnidades.setEnabled(false);
                txtCantidadPresentacion.setEnabled(false);
                limpiarCajasPrecios();
            } else {
                int i = cmbMedida.getSelectedIndex() - 1;
                txtEquivalencia.setText("" + lista_medida.get(i).getmEquivalencia());
                String presentacion = cmbMedida.getSelectedItem().toString();
                String equivalencia = txtEquivalencia.getText();
                if (presentacion.equals(equivalencia)) {

                    txtCantidadPresentacion.setEnabled(false);
                    txtPrecioCompraPresentacion.setEnabled(false);
                    txtPrecioCompraUnidades.setEnabled(true);
                    txtCantidadEquivalencia.setEnabled(true);
                    txtMargenGananciaPresentacion.setEnabled(false);

                    txtCantidadEquivalencia.requestFocus();
                    limpiarCajasPrecios();
                } else {
                    txtCantidadPresentacion.setEnabled(true);
                    txtPrecioCompraPresentacion.setEnabled(true);
                    txtPrecioCompraUnidades.setEnabled(false);
                    txtCantidadEquivalencia.setEnabled(true);
                    txtMargenGananciaPresentacion.setEnabled(true);

                    txtCantidadPresentacion.requestFocus();
                    limpiarCajasPrecios();
                }
            }
        }
    }//GEN-LAST:event_cmbMedidaItemStateChanged

    private void txtPrecioCompraPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraPresentacionKeyReleased
        // TODO add your handling code here:
        try {
            if (txtCantidadEquivalencia.getText().length() > 0) {
                int canEquivalencia = Integer.parseInt(txtCantidadEquivalencia.getText().trim());
                double precio_compra = Double.parseDouble(txtPrecioCompraPresentacion.getText().trim());
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
                DecimalFormat df = new DecimalFormat("#.#", symbols);
                double precio_compra_unidades = precio_compra / canEquivalencia;
                txtPrecioCompraUnidades.setText("" + df.format(precio_compra_unidades));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtPrecioCompraPresentacionKeyReleased

    private void txtMargenGananciaEquivalenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenGananciaEquivalenciaKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            DecimalFormat df = new DecimalFormat("#.#", symbols);
            double precioCompraEquivalencia = Double.parseDouble(txtPrecioCompraUnidades.getText().trim());
            double margen = Integer.parseInt(txtMargenGananciaEquivalencia.getText().trim());

            double gananciaEquivalencia = precioCompraEquivalencia * (margen / 100);

            double precioVentEquivalencia = precioCompraEquivalencia + gananciaEquivalencia;
            String redondeadoEquivalencia = df.format(precioVentEquivalencia);
            txtPrecioVentaUnidades.setText(redondeadoEquivalencia);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtMargenGananciaEquivalenciaKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtProducto.getText().length() > 0) {
            if (cmbMedida.getSelectedIndex() != 0) {
                if (txtMargenGananciaPresentacion.getText().length() > 0) {
                    String presentacion = cmbMedida.getSelectedItem().toString();
                    String equivalencia = txtEquivalencia.getText();
                    String serie = txtBarras.getText();
                    String producto = txtProducto.getText();
                    String lote = txtLote.getText();
                    SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                    String fechavcto = dcn.format(dcFechaVcto.getDate());
                    int ref = Integer.parseInt(txtCantidadEquivalencia.getText().trim());
                    int margenPresentacion = Integer.parseInt(txtMargenGananciaPresentacion.getText().trim());
                    int margenEquivalencia = Integer.parseInt(txtMargenGananciaEquivalencia.getText().trim());
                    if (presentacion.equals(equivalencia)) {
                        int cantEquivalencia = Integer.parseInt(txtCantidadEquivalencia.getText().trim());
                        double precioCompraUnidades = Double.parseDouble(txtPrecioCompraUnidades.getText().trim());
                        double precioVentaUnidadesMayor = Double.parseDouble(txtPrecioVentaUnidades.getText().trim());
                        double importe = precioCompraUnidades * cantEquivalencia;
                        DefaultTableModel tabla_entrada_productos_temporal = (DefaultTableModel) tabla_entrada_productos.getModel();
                        int cantPresentacion = 0;
                        double precioCompraPresentacion = 0;
                        double precioVentaPresentacionMayor = 0;
                        ref = 0;
                        double precioVentaPresentacionMenor = 0;
                        double precioVentaUnidadesMenor = precioCompraUnidades + (precioCompraUnidades * 0.20);
                        Object[] data = {serie, producto, lote, fechavcto, cantPresentacion, cantEquivalencia, precioCompraPresentacion, precioCompraUnidades,
                            importe, margenPresentacion, margenEquivalencia, precioVentaPresentacionMayor, precioVentaUnidadesMayor, presentacion, equivalencia, ref,
                            precioVentaPresentacionMenor, precioVentaUnidadesMenor};
                        tabla_entrada_productos_temporal.addRow(data);

                    } else {
                        int cantPresentacion = Integer.parseInt(txtCantidadPresentacion.getText().trim());
                        int cantUnidades = Integer.parseInt(txtCantidadEquivalencia.getText().trim());
                        int cantEquivalencia = cantPresentacion * cantUnidades;
                        double precioCompraUnidades = Double.parseDouble(txtPrecioCompraUnidades.getText().trim());
                        double precioVentaUnidadesMayor = Double.parseDouble(txtPrecioVentaUnidades.getText().trim());
                        double precioCompraPresentacion = Double.parseDouble(txtPrecioCompraPresentacion.getText().trim());
                        double precioVentaPresentacionMayor = Double.parseDouble(txtPrecioVentaPresentacion.getText().trim());
                        double importe = precioCompraPresentacion * cantPresentacion;
                        DefaultTableModel tabla_entrada_productos_temporal = (DefaultTableModel) tabla_entrada_productos.getModel();
                        double precioVentaPresentacionMenor = precioCompraPresentacion + (precioCompraPresentacion * 0.20);
                        double precioVentaUnidadesMenor = precioCompraUnidades + (precioCompraUnidades * 0.20);
                        Object[] data = {serie, producto, lote, fechavcto, cantPresentacion, cantEquivalencia, precioCompraPresentacion, precioCompraUnidades, importe, margenPresentacion, margenEquivalencia, precioVentaPresentacionMayor, precioVentaUnidadesMayor, presentacion, equivalencia, ref, precioVentaPresentacionMenor, precioVentaUnidadesMenor};
                        tabla_entrada_productos_temporal.addRow(data);
                    }
                    limpiarCajasPrecios();
                    limpiarProducto();
                    txtBarras.requestFocus();
                } else {
                    advertencia("Tiene que colocar un margen de ganancia");
                    txtMargenGananciaPresentacion.requestFocus();
                }
            } else {
                advertencia("Tiene que seleccionar una medida del producto");
                cmbMedida.requestFocus();
            }
        } else {
            advertencia("Tiene que buscar un producto");
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_entrada_productos.getSelectedRow();
        try {
            DefaultTableModel tabla_temporal_entradas = (DefaultTableModel) tabla_entrada_productos.getModel();
            tabla_temporal_entradas.removeRow(filaSeleccionada);
            tabla_entrada_productos.setModel(tabla_temporal_entradas);
        } catch (Exception e) {
            error("Error al quitar");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtMargenGananciaPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenGananciaPresentacionKeyReleased
        // TODO add your handling code here:
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
            DecimalFormat df = new DecimalFormat("#.#", symbols);
            double precioCompraPresentacion = Double.parseDouble(txtPrecioCompraPresentacion.getText().trim());
            double margen = Integer.parseInt(txtMargenGananciaPresentacion.getText().trim());

            double gananciaPresentacion = precioCompraPresentacion * (margen / 100);

            double precioVentEquivalencia = precioCompraPresentacion + gananciaPresentacion;
            double redondeadoEquivalencia = Math.round(precioVentEquivalencia);
            txtPrecioVentaPresentacion.setText("" + df.format(redondeadoEquivalencia));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtMargenGananciaPresentacionKeyReleased

    private void txtNroDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroDocumentoFocusGained
        // TODO add your handling code here:
        txtNroDocumento.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNroDocumentoFocusGained

    private void txtNroDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroDocumentoFocusLost
        // TODO add your handling code here:
        txtNroDocumento.setBackground(Color.white);
    }//GEN-LAST:event_txtNroDocumentoFocusLost

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

    private void txtCantidadPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadPresentacionFocusGained
        // TODO add your handling code here:
        txtCantidadPresentacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtCantidadPresentacionFocusGained

    private void txtCantidadPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadPresentacionFocusLost
        // TODO add your handling code here:

        txtCantidadPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtCantidadPresentacionFocusLost

    private void txtEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusGained
        // TODO add your handling code here:
        txtEquivalencia.setBackground(Color.yellow);
    }//GEN-LAST:event_txtEquivalenciaFocusGained

    private void txtEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusLost
        // TODO add your handling code here:
        txtEquivalencia.setBackground(Color.white);
    }//GEN-LAST:event_txtEquivalenciaFocusLost

    private void txtCantidadEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadEquivalenciaFocusGained
        // TODO add your handling code here:
        txtCantidadEquivalencia.setBackground(Color.yellow);
    }//GEN-LAST:event_txtCantidadEquivalenciaFocusGained

    private void txtCantidadEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadEquivalenciaFocusLost
        // TODO add your handling code here:
        txtCantidadEquivalencia.setBackground(Color.white);
    }//GEN-LAST:event_txtCantidadEquivalenciaFocusLost

    private void txtPrecioCompraPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCompraPresentacionFocusGained
        // TODO add your handling code here:
        txtPrecioCompraPresentacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPrecioCompraPresentacionFocusGained

    private void txtPrecioCompraPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCompraPresentacionFocusLost
        // TODO add your handling code here:
        txtPrecioCompraPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtPrecioCompraPresentacionFocusLost

    private void txtPrecioCompraUnidadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCompraUnidadesFocusGained
        // TODO add your handling code here:
        txtPrecioCompraUnidades.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPrecioCompraUnidadesFocusGained

    private void txtPrecioCompraUnidadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioCompraUnidadesFocusLost
        // TODO add your handling code here:
        txtPrecioCompraUnidades.setBackground(Color.white);
    }//GEN-LAST:event_txtPrecioCompraUnidadesFocusLost

    private void txtMargenGananciaPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenGananciaPresentacionFocusGained
        // TODO add your handling code here:
        txtMargenGananciaPresentacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtMargenGananciaPresentacionFocusGained

    private void txtMargenGananciaEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenGananciaEquivalenciaFocusGained
        // TODO add your handling code here:

        txtMargenGananciaEquivalencia.setBackground(Color.yellow);
    }//GEN-LAST:event_txtMargenGananciaEquivalenciaFocusGained

    private void txtMargenGananciaEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenGananciaEquivalenciaFocusLost
        // TODO add your handling code here:

        txtMargenGananciaEquivalencia.setBackground(Color.white);
    }//GEN-LAST:event_txtMargenGananciaEquivalenciaFocusLost

    private void txtPrecioVentaPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaPresentacionFocusGained
        // TODO add your handling code here:
        txtPrecioVentaPresentacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPrecioVentaPresentacionFocusGained

    private void txtPrecioVentaPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaPresentacionFocusLost
        // TODO add your handling code here:
        txtPrecioVentaPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtPrecioVentaPresentacionFocusLost

    private void txtPrecioVentaUnidadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaUnidadesFocusGained
        // TODO add your handling code here:
        txtPrecioVentaUnidades.setBackground(Color.yellow);
    }//GEN-LAST:event_txtPrecioVentaUnidadesFocusGained

    private void txtPrecioVentaUnidadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaUnidadesFocusLost
        // TODO add your handling code here:
        txtPrecioVentaUnidades.setBackground(Color.white);
    }//GEN-LAST:event_txtPrecioVentaUnidadesFocusLost

    private void txtNroDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroDocumentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtBarras.requestFocus();
        }
    }//GEN-LAST:event_txtNroDocumentoKeyPressed

    private void txtBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFecha.requestFocus();

        }
    }//GEN-LAST:event_txtBarrasKeyPressed

    private void txtLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoteKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbMedida.requestFocus();
        }
    }//GEN-LAST:event_txtLoteKeyPressed

    private void cmbMedidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMedidaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbMedidaKeyPressed

    private void txtCantidadPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadPresentacionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCantidadEquivalencia.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadPresentacionKeyPressed

    private void txtCantidadEquivalenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadEquivalenciaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cmbMedida.getSelectedItem().equals("UNIDADES")) {
                txtPrecioCompraUnidades.requestFocus();

                txtCantidadPresentacion.setEnabled(false);
                txtPrecioCompraPresentacion.setEnabled(false);
                txtPrecioCompraUnidades.setEnabled(true);
                txtCantidadEquivalencia.setEnabled(true);
                txtMargenGananciaPresentacion.setEnabled(false);
            } else {
                txtPrecioCompraPresentacion.requestFocus();

                txtCantidadPresentacion.setEnabled(true);
                txtPrecioCompraPresentacion.setEnabled(true);
                txtPrecioCompraUnidades.setEnabled(false);
                txtCantidadEquivalencia.setEnabled(true);
                txtMargenGananciaPresentacion.setEnabled(true);
            }
        }

    }//GEN-LAST:event_txtCantidadEquivalenciaKeyPressed

    private void txtMargenGananciaPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenGananciaPresentacionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMargenGananciaEquivalencia.requestFocus();
        }
    }//GEN-LAST:event_txtMargenGananciaPresentacionKeyPressed

    private void txtMargenGananciaEquivalenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenGananciaEquivalenciaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregar.requestFocus();
            btnAgregar.doClick();
        }
    }//GEN-LAST:event_txtMargenGananciaEquivalenciaKeyPressed

    private void txtPrecioCompraUnidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraUnidadesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMargenGananciaEquivalencia.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioCompraUnidadesKeyPressed

    private void txtBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBarrasKeyTyped

    private void txtMargenGananciaPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMargenGananciaPresentacionFocusLost
        // TODO add your handling code here:
        txtMargenGananciaPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtMargenGananciaPresentacionFocusLost

    private void txtPrecioCompraPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraPresentacionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMargenGananciaPresentacion.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioCompraPresentacionKeyPressed

    private void txtCantidadPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadPresentacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadPresentacionKeyTyped

    private void txtPrecioCompraUnidadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraUnidadesKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioCompraUnidadesKeyTyped

    private void txtPrecioCompraPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraPresentacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioCompraPresentacionKeyTyped

    private void txtMargenGananciaPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenGananciaPresentacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMargenGananciaPresentacionKeyTyped

    private void txtMargenGananciaEquivalenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenGananciaEquivalenciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMargenGananciaEquivalenciaKeyTyped

    private void txtCantidadEquivalenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadEquivalenciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadEquivalenciaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrar2;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JComboBox<String> cmbProceso;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private com.toedter.calendar.JDateChooser dcFechaVcto;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_entrada_productos;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtCantidadEquivalencia;
    private javax.swing.JTextField txtCantidadPresentacion;
    private javax.swing.JTextField txtEquivalencia;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtMargenGananciaEquivalencia;
    private javax.swing.JTextField txtMargenGananciaPresentacion;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JTextField txtPrecioCompraPresentacion;
    private javax.swing.JTextField txtPrecioCompraUnidades;
    private javax.swing.JTextField txtPrecioVentaPresentacion;
    private javax.swing.JTextField txtPrecioVentaUnidades;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}

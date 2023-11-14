/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Correlativo;
import CapaDatos.DetalleCaja;
import CapaNegocio.ColorearColumnasJTable;
import CapaNegocio.CorrelativoBD;
import CapaNegocio.DetalleCajaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class Ingresos_IU extends javax.swing.JInternalFrame {

    String documento = "";
    String serie = "";
    String numeracion_actual = "";
    String nueva_Numeracion = "";
    String tienda = "";
    String uDni = "";

    /**
     * Creates new form Ingresos_IU
     */
    public Ingresos_IU() {
        initComponents();
        sacarFecha();
        sacarHora();
        sacarNro();
        reportar();
        calculaTotal();
         ColorearColumnasJTable co15=new ColorearColumnasJTable(5, Color.YELLOW);
        ColorearColumnasJTable co17=new ColorearColumnasJTable(6, Color.PINK);
        
        tabla_reporte_INGRESO.getColumnModel().getColumn(5).setCellRenderer(co15);
        tabla_reporte_INGRESO.getColumnModel().getColumn(6).setCellRenderer(co17);
    }

    private void limpiar() {
        txtDetalleEgreso.setText("");
        txtMonto.setText("");
        txtDetalleEgreso.requestFocus();
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
        txtFechaEgreso.setText(fecha);
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
        DefaultTableModel tabla_temporal_productos_temporal = (DefaultTableModel) tabla_reporte_INGRESO.getModel();
        tabla_temporal_productos_temporal.setRowCount(0);
    }

    private String correlativo(int antiguoNro) {
        String nuevoNro;
        String codTemporal = String.valueOf(antiguoNro);
        if (codTemporal.length() == 1) {
            nuevoNro = "00000" + antiguoNro;
        } else if (codTemporal.length() == 2) {
            nuevoNro = "0000" + antiguoNro;
        } else if (codTemporal.length() == 3) {
            nuevoNro = "000" + antiguoNro;
        } else if (codTemporal.length() == 4) {
            nuevoNro = "00" + antiguoNro;
        } else if (codTemporal.length() == 5) {
            nuevoNro = "0" + antiguoNro;
        } else {
            nuevoNro = "" + antiguoNro;
        }
        return nuevoNro;
    }

    private void sacarNro() {
        CorrelativoBD oCorrelativoBD = new CorrelativoBD();
        documento = "INGRESO";
        tienda = Login_IU.tienda;
        List<Correlativo> listaCorrelativos = oCorrelativoBD.sacarNumeracion(documento, tienda);
        serie = listaCorrelativos.get(0).getCoSerie();
        numeracion_actual = listaCorrelativos.get(0).getCoNumeracion();
        int antiguoNro = Integer.valueOf(numeracion_actual) + 1;
        nueva_Numeracion = correlativo(antiguoNro);
        txtCorrelativo.setText(serie + "-" + nueva_Numeracion);
    }

    private void reportar() {
        limpiar_tabla_formulario();
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        DefaultTableModel tablaTemporal = (DefaultTableModel) this.tabla_reporte_INGRESO.getModel();
        String correlativo = txtBuscarCorrelativo.getText().trim();
        String fecha = txtFechaEgreso.getText();
        tienda = Login_IU.tienda;
        String opcion = "INGRESO";
        uDni = Login_IU.dni_publico;
        List<DetalleCaja> lista_detalle = oDetalleCajaBD.buscarDetalleCajaUsuario(uDni, fecha, tienda, opcion);
        for (int i = 0; i < lista_detalle.size(); i++) {
            int iddetallecaja = lista_detalle.get(i).getIddetallecaja();
            String hora = lista_detalle.get(i).getDcHora();
            correlativo = lista_detalle.get(i).getDcCorrelativo();
            String motivo = lista_detalle.get(i).getDcMotivo();
            double monto = lista_detalle.get(i).getDcMonto();
            String estado = lista_detalle.get(i).getDcEstado();

            Object[] data = {iddetallecaja, fecha, hora, correlativo, opcion, motivo, monto, estado};
            tablaTemporal.addRow(data);
        }
        tabla_reporte_INGRESO.setModel(tablaTemporal);
    }

    private void actualizarCorrelativo(String documento) {
        Correlativo oCorrelativo = new Correlativo();
        CorrelativoBD oCorrelativoBD = new CorrelativoBD();
        tienda = Login_IU.tienda;
        oCorrelativo.setCoNumeracion(nueva_Numeracion);
        oCorrelativo.setCoDocumento(documento);
        oCorrelativo.setTienda(tienda);
        oCorrelativoBD.actualizarCorrelativo(oCorrelativo);
    }
    
    private void calculaTotal() {
        DefaultTableModel tabla_temporal_compras = (DefaultTableModel) tabla_reporte_INGRESO.getModel();
        int canttabla = tabla_temporal_compras.getRowCount();
        double total = 0;

        for (int i = 0; i < canttabla; i++) {
            total = total + (Double) tabla_temporal_compras.getValueAt(i, 6);

            txtTotal.setText("" + total);

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

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtFechaEgreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        cmbNroCaja = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_INGRESO = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDetalleEgreso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarCorrelativo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INGRESOS");

        jLabel11.setText("TOTAL S/.");

        jLabel1.setText("FECHA DEL INGRESO");

        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtFechaEgreso.setEnabled(false);

        jLabel2.setText("NRO DE CAJA");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/page_delete.png"))); // NOI18N
        btnAnular.setText("ANULAR");
        btnAnular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cmbNroCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAJA NRO 1" }));

        jLabel3.setText("CORRELATIVO");

        txtCorrelativo.setEnabled(false);

        tabla_reporte_INGRESO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FECHA", "HORA", "CORRELATIVO", "OPCION", "MOTIVO", "MONTO", "ESTADO"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_INGRESO);

        jLabel4.setText("HORA");

        txtHora.setEnabled(false);

        jLabel5.setText("DETALLE DEL INGRESO");

        txtDetalleEgreso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDetalleEgresoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDetalleEgresoFocusLost(evt);
            }
        });
        txtDetalleEgreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDetalleEgresoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDetalleEgresoKeyTyped(evt);
            }
        });

        jLabel6.setText("MONTO S/.");

        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoFocusLost(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Documento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel7.setText("CORRELATIVO");

        txtBuscarCorrelativo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCorrelativoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCorrelativoFocusLost(evt);
            }
        });
        txtBuscarCorrelativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCorrelativoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCorrelativoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscarCorrelativo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscarCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDetalleEgreso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorrelativo)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 575, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtCorrelativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbNroCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDetalleEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txtDetalleEgreso.getText().length() > 0) {
            if (txtMonto.getText().length() > 0) {
                // ATRIBUTOS
                DetalleCaja oDetalleCaja = new DetalleCaja();
                //METODOS
                DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();

                uDni = Login_IU.dni_publico;
                tienda = Login_IU.tienda;
                oDetalleCaja.setDcFecha(txtFechaEgreso.getText());
                oDetalleCaja.setDcHora(txtHora.getText());
                oDetalleCaja.setDcCaja(cmbNroCaja.getSelectedItem().toString());
                oDetalleCaja.setOpcion("INGRESO");
                oDetalleCaja.setDcCorrelativo(txtCorrelativo.getText());
                oDetalleCaja.setDcMotivo(txtDetalleEgreso.getText().toUpperCase());
                oDetalleCaja.setDcMonto(Double.parseDouble(txtMonto.getText()));
                oDetalleCaja.setDcEstado("ABIERTO");
                oDetalleCaja.setuDni(uDni);
                oDetalleCaja.setTienda(tienda);

                boolean rpta = oDetalleCajaBD.registrarDetalleCaja(oDetalleCaja);
                if (rpta) {

                    exito("Se registro con exito");
                    actualizarCorrelativo("INGRESO");
                    sacarNro();
                    reportar();
                    limpiar();
                    calculaTotal();
                } else {
                    error("Tienes problemas al registrar");
                }
            } else {
                advertencia("Ingresa un monto");
                txtMonto.requestFocus();
            }
        } else {
            advertencia("Ingresa un motivo");
            txtDetalleEgreso.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tabla_reporte_INGRESO.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar ?");
            if (aviso == 0) {
                int iddetallecaja = Integer.parseInt(tabla_reporte_INGRESO.getValueAt(filaSeleccionada, 0).toString());
                String estado = "ANULADO";
                DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
                boolean rpta = oDetalleCajaBD.anularDocumento(iddetallecaja, estado);
                if (rpta) {
                    exito("Se anulo con exito");
                    reportar();
                } else {
                    error("Tienes problemas al anular");
                }
            }
        } else {
            advertencia("Tiene que seleccionar una fila para poder ANULAR .. ");
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void txtBuscarCorrelativoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCorrelativoKeyReleased
        // TODO add your handling code here:
        limpiar_tabla_formulario();
        DetalleCajaBD oDetalleCajaBD = new DetalleCajaBD();
        DefaultTableModel tablaTemporal = (DefaultTableModel) this.tabla_reporte_INGRESO.getModel();
        String correlativo = txtBuscarCorrelativo.getText().trim();
        String fecha = txtFechaEgreso.getText();
        tienda = Login_IU.tienda;
        String opcion = "INGRESO";

        List<DetalleCaja> lista_detalle = oDetalleCajaBD.buscarDetalleCajaCorrelativo(correlativo, fecha, tienda, opcion);
        for (int i = 0; i < lista_detalle.size(); i++) {
            int iddetallecaja = lista_detalle.get(i).getIddetallecaja();
            String hora = lista_detalle.get(i).getDcHora();
            correlativo = lista_detalle.get(i).getDcCorrelativo();
            String motivo = lista_detalle.get(i).getDcMotivo();
            double monto = lista_detalle.get(i).getDcMonto();
            String estado = lista_detalle.get(i).getDcEstado();

            Object[] data = {iddetallecaja, fecha, hora, correlativo, opcion, motivo, monto, estado};
            tablaTemporal.addRow(data);
        }
        tabla_reporte_INGRESO.setModel(tablaTemporal);
    }//GEN-LAST:event_txtBuscarCorrelativoKeyReleased

    private void txtDetalleEgresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleEgresoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMonto.requestFocus();
        }
    }//GEN-LAST:event_txtDetalleEgresoKeyPressed

    private void txtMontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_txtMontoKeyPressed

    private void txtDetalleEgresoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetalleEgresoFocusGained
        // TODO add your handling code here:
        
        txtDetalleEgreso.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDetalleEgresoFocusGained

    private void txtDetalleEgresoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetalleEgresoFocusLost
        // TODO add your handling code here:
        
        txtDetalleEgreso.setBackground(Color.white);
    }//GEN-LAST:event_txtDetalleEgresoFocusLost

    private void txtMontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusGained
        // TODO add your handling code here:
        
        txtMonto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtMontoFocusGained

    private void txtMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusLost
        // TODO add your handling code here:
        
        txtMonto.setBackground(Color.white);
    }//GEN-LAST:event_txtMontoFocusLost

    private void txtBuscarCorrelativoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCorrelativoFocusGained
        // TODO add your handling code here:
        
        txtBuscarCorrelativo.setBackground(Color.yellow);
    }//GEN-LAST:event_txtBuscarCorrelativoFocusGained

    private void txtBuscarCorrelativoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCorrelativoFocusLost
        // TODO add your handling code here:
        
        txtBuscarCorrelativo.setBackground(Color.white);
    }//GEN-LAST:event_txtBuscarCorrelativoFocusLost

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtBuscarCorrelativoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCorrelativoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == '-')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarCorrelativoKeyTyped

    private void txtDetalleEgresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleEgresoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDetalleEgresoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbNroCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_INGRESO;
    private javax.swing.JTextField txtBuscarCorrelativo;
    private javax.swing.JTextField txtCorrelativo;
    private javax.swing.JTextField txtDetalleEgreso;
    private javax.swing.JTextField txtFechaEgreso;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

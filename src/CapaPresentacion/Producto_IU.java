/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Categoria;
import CapaDatos.Marca;
import CapaDatos.Medida;
import CapaDatos.Producto;
import CapaNegocio.CategoriaBD;
import CapaNegocio.MarcaBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import static CapaPresentacion.Menuu_IU.escritorioo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class Producto_IU extends javax.swing.JInternalFrame {

    List<Marca> lista_marca;
    List<Categoria> lista_categoria;
    List<Medida> lista_medida;

    /**
     * Creates new form Producto_IU
     */
    public Producto_IU() {
        initComponents();
        reportar();
        cargarCategoria();
        cargarMarca();
        cargarMedida();
    }

    private void habilitar() {
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnRegistrar.setEnabled(true);
        btnLimpiar.setEnabled(true);
    }

    private void deshabilitar() {
        btnBuscar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnRegistrar.setEnabled(false);
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_turno = (DefaultTableModel) tabla_reporte_producto.getModel();
        tabla_temporal_turno.setRowCount(0);
    }

    private void limpiar() {
        cmbCategoria.setSelectedIndex(0);
        cmbCondicion.setSelectedIndex(0);
        cmbMarca.setSelectedIndex(0);
        cmbMedida.setSelectedIndex(0);
        txtSerie.setText("");
        txtDescripcion.setText("");
        txtObservacion.setText("");
        txtDigemi.setText("");
        txtCodigoCategoria.setText("");
        txtCodigoMarca.setText("");
        txtCodigoMedida.setText("");
        txtProducto.setText("");
        txtSerie.requestFocus();

    }

    private void cargarMarca() {
        try {
            cmbMarca.removeAllItems();
            MarcaBD oMarcaBD = new MarcaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oMarcaBD.reportarMarca();
            lista_marca = new ArrayList<>();
            cmbMarca.addItem("Seleccionar");
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                int idmarca = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1).toString());

                lista_marca.add(new Marca(idmarca, nombre));
                cmbMarca.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error al cargar marca", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCategoria() {
        try {
            cmbCategoria.removeAllItems();
            CategoriaBD oCategoriaBD = new CategoriaBD();
            lista_categoria = oCategoriaBD.reportarCategoria();
            cmbCategoria.addItem("Seleccionar");
            for (int i = 0; i < lista_categoria.size(); i++) {
                int idcategoria = lista_categoria.get(i).getIdcategoria();
                String nombre = lista_categoria.get(i).getCatNombre();

                cmbCategoria.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error al cargar Categoria", JOptionPane.ERROR_MESSAGE);
        }
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

    private void reportar() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal;
            DefaultTableModel tabla_temporal_producto = (DefaultTableModel) this.tabla_reporte_producto.getModel();
            ProductoBD oProductoBD = new ProductoBD();
            tabla_temporal = oProductoBD.reportarProducto();
            int cantidad_productos = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad_productos);
            for (int i = 0; i < cantidad_productos; i++) {
                String serie = tabla_temporal.getValueAt(i, 0).toString();
                String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                String observacion = tabla_temporal.getValueAt(i, 2).toString();
                String digemi = tabla_temporal.getValueAt(i, 3).toString();
                String condicion = tabla_temporal.getValueAt(i, 4).toString();
                String categoria = tabla_temporal.getValueAt(i, 5).toString();
                String marca = tabla_temporal.getValueAt(i, 6).toString();
                String medida = tabla_temporal.getValueAt(i, 7).toString();
                Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
                tabla_temporal_producto.addRow(data);
            }
            tabla_reporte_producto.setModel(tabla_temporal_producto);

            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception ex) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

            ex.printStackTrace();
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDigemi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox<>();
        txtCodigoMarca = new javax.swing.JTextField();
        txtCodigoCategoria = new javax.swing.JTextField();
        txtCodigoMedida = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_producto = new javax.swing.JTable();
        btnComposicion = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("PRODUCTO");

        jLabel1.setText("SERIE");

        txtSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSerieFocusLost(evt);
            }
        });
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        jLabel2.setText("DESCRIPCION");

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        jLabel8.setText("CATEGORIA");

        jLabel7.setText("LABORATORIO");

        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });

        jLabel3.setText("MEDIDA");

        cmbMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedidaItemStateChanged(evt);
            }
        });

        jLabel6.setText("OBSERVACION");

        txtObservacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtObservacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtObservacionFocusLost(evt);
            }
        });
        txtObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtObservacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionKeyTyped(evt);
            }
        });

        jLabel9.setText("DIGEMI");

        txtDigemi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDigemiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDigemiFocusLost(evt);
            }
        });
        txtDigemi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDigemiKeyPressed(evt);
            }
        });

        jLabel10.setText("CONDICION");

        cmbCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORMAL", "RECETA MEDICA" }));

        txtCodigoMarca.setEnabled(false);
        txtCodigoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoMarcaActionPerformed(evt);
            }
        });

        txtCodigoCategoria.setEnabled(false);

        txtCodigoMedida.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel4.setText("PRODUCTO");

        txtProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductoFocusLost(evt);
            }
        });
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProducto)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_reporte_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORA", "MARCA", "MEDIDA"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_producto);
        if (tabla_reporte_producto.getColumnModel().getColumnCount() > 0) {
            tabla_reporte_producto.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla_reporte_producto.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla_reporte_producto.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabla_reporte_producto.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btnComposicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/application_2.png"))); // NOI18N
        btnComposicion.setText("COMPOSICION");
        btnComposicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComposicionActionPerformed(evt);
            }
        });

        jLabel11.setText("CANTIDAD");

        txtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCantidad.setEnabled(false);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/application.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setEnabled(false);
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report_magnify.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setEnabled(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report_edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bin_empty.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actions_edit_clear_15784 (1).png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setEnabled(false);
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnComposicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigoMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDigemi, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(311, 311, 311))
                            .addComponent(txtObservacion)
                            .addComponent(txtDescripcion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDigemi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnComposicion)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusGained
        // TODO add your handling code here:
        txtSerie.setBackground(Color.yellow);
    }//GEN-LAST:event_txtSerieFocusGained

    private void txtSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSerieFocusLost
        // TODO add your handling code here:
        txtSerie.setBackground(Color.white);
    }//GEN-LAST:event_txtSerieFocusLost

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtSerieKeyPressed

    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtSerie.getText().length() >= 15) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSerieKeyTyped

    private void cmbMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedidaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbMedida.getSelectedItem();
            if (textoSeleccionado.equals("Seleccionar")) {
                txtCodigoMedida.setText("");
            } else {
                int i = cmbMedida.getSelectedIndex() - 1;
                txtCodigoMedida.setText("" + lista_medida.get(i).getIdmedida());

            }
        }
    }//GEN-LAST:event_cmbMedidaItemStateChanged

    private void txtDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusGained
        // TODO add your handling code here:
        txtDescripcion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDescripcionFocusGained

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        // TODO add your handling code here:
        txtDescripcion.setBackground(Color.white);
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtObservacion.requestFocus();
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbCategoria.getSelectedItem();
            if (textoSeleccionado.equals("Seleccionar")) {
                txtCodigoCategoria.setText("");
            } else {
                int i = cmbCategoria.getSelectedIndex() - 1;
                txtCodigoCategoria.setText("" + lista_categoria.get(i).getIdcategoria());

            }
        }
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String textoSeleccionado = (String) cmbMarca.getSelectedItem();
            if (textoSeleccionado.equals("Seleccionar")) {
                txtCodigoMarca.setText("");
            } else {
                int i = cmbMarca.getSelectedIndex() - 1;
                txtCodigoMarca.setText("" + lista_marca.get(i).getIdmarca());

            }
        }
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void txtCodigoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoMarcaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (txtSerie.getText().length() > 0) {
            if (txtDescripcion.getText().length() > 0) {
                if (txtCodigoCategoria.getText().length() > 0) {
                    if (txtCodigoMarca.getText().length() > 0) {
                        if (txtCodigoMedida.getText().length() > 0) {
                            // ATRIBUTOS
                            Producto oProducto = new Producto();
                            //METODOS
                            ProductoBD oProductoBD = new ProductoBD();

                            oProducto.setpSerie(txtSerie.getText().toUpperCase());
                            oProducto.setpDescripcion(txtDescripcion.getText().toUpperCase());
                            oProducto.setpObservacion(txtObservacion.getText());
                            oProducto.setDigemi(txtDigemi.getText());
                            oProducto.setpCondicion(cmbCondicion.getSelectedItem().toString());
                            oProducto.setIdmedida(Integer.parseInt(txtCodigoMedida.getText()));
                            oProducto.setIdcategoria(Integer.parseInt(txtCodigoCategoria.getText()));
                            oProducto.setIdmarca(Integer.parseInt(txtCodigoMarca.getText()));

                            boolean rpta = oProductoBD.registrarProducto(oProducto);
                            if (rpta) {

                                exito("Se registro con exito");
                                reportar();
                                limpiar();
                                deshabilitar();
                            } else {
                                error("Tienes problemas al registrar");
                            }
                        } else {
                            error("Selecciona una medida");
                        }
                    } else {
                        error("Selecciona un laboratorio");
                    }
                } else {
                    error("Selecciona una categoria");
                }
            } else {
                error("Ingrese la descripcion del producto");
                txtDescripcion.requestFocus();
            }
        } else {
            error("Ingrese el codigo del producto");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (txtSerie.getText().length() > 0) {
            String serie = txtSerie.getText();
            ProductoBD oProductoBD = new ProductoBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oProductoBD.buscarProducto(serie);

            int cantidad_productos = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad_productos);
            limpiar_tabla_formulario();
            if (cantidad_productos > 0) {
                txtDescripcion.setText(tabla_temporal.getValueAt(0, 1).toString());
                txtObservacion.setText(tabla_temporal.getValueAt(0, 2).toString());
                txtDigemi.setText(tabla_temporal.getValueAt(0, 3).toString());
                cmbCondicion.setSelectedItem(tabla_temporal.getValueAt(0, 4).toString());
                cmbMedida.setSelectedItem(tabla_temporal.getValueAt(0, 7).toString());
                cmbMarca.setSelectedItem(tabla_temporal.getValueAt(0, 6).toString());
                cmbCategoria.setSelectedItem(tabla_temporal.getValueAt(0, 5).toString());
                txtCodigoMedida.setText(tabla_temporal.getValueAt(0, 10).toString());
                txtCodigoCategoria.setText(tabla_temporal.getValueAt(0, 8).toString());
                txtCodigoMarca.setText(tabla_temporal.getValueAt(0, 9).toString());
                DefaultTableModel tabla_temporal_producto = (DefaultTableModel) this.tabla_reporte_producto.getModel();

                for (int i = 0; i < cantidad_productos; i++) {
                    serie = tabla_temporal.getValueAt(i, 0).toString();
                    String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                    String observacion = tabla_temporal.getValueAt(i, 2).toString();
                    String digemi = tabla_temporal.getValueAt(i, 3).toString();
                    String condicion = tabla_temporal.getValueAt(i, 4).toString();
                    String categoria = tabla_temporal.getValueAt(i, 5).toString();
                    String marca = tabla_temporal.getValueAt(i, 6).toString();
                    String medida = tabla_temporal.getValueAt(i, 7).toString();
                    Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
                    tabla_temporal_producto.addRow(data);
                }

                tabla_reporte_producto.setModel(tabla_temporal_producto);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro datos..");
                txtSerie.requestFocus();
                txtSerie.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese serie");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txtSerie.getText().length() > 0) {
            if (txtDescripcion.getText().length() > 0) {
                if (txtCodigoCategoria.getText().length() > 0) {
                    if (txtCodigoMarca.getText().length() > 0) {
                        if (txtCodigoMedida.getText().length() > 0) {
                            // ATRIBUTOS
                            Producto oProducto = new Producto();
                            //METODOS
                            ProductoBD oProductoBD = new ProductoBD();

                            oProducto.setpSerie(txtSerie.getText().toUpperCase());
                            oProducto.setpDescripcion(txtDescripcion.getText().toUpperCase());
                            oProducto.setpObservacion(txtObservacion.getText());
                            oProducto.setDigemi(txtDigemi.getText());
                            oProducto.setpCondicion(cmbCondicion.getSelectedItem().toString());
                            oProducto.setIdmedida(Integer.parseInt(txtCodigoMedida.getText()));
                            oProducto.setIdcategoria(Integer.parseInt(txtCodigoCategoria.getText()));
                            oProducto.setIdmarca(Integer.parseInt(txtCodigoMarca.getText()));

                            boolean rpta = oProductoBD.modificarProducto(oProducto);
                            if (rpta) {

                                exito("Se modifico con exito");
                                reportar();
                                limpiar();
                                deshabilitar();
                            } else {
                                error("Tienes problemas al modificar");
                            }
                        } else {
                            error("Selecciona una medida");
                        }
                    } else {
                        error("Selecciona un laboratorio");
                    }
                } else {
                    error("Selecciona una categoria");
                }
            } else {
                error("Ingrese la descripcion del producto");
                txtDescripcion.requestFocus();
            }
        } else {
            error("Ingrese el codigo del producto");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtSerie.getText().length() > 0) {
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar?", "MENSAJE", JOptionPane.YES_OPTION);
                if (aviso == 0) {
                    String serie = txtSerie.getText().trim();
                    ProductoBD oProductoBD = new ProductoBD();

                    boolean rpt = oProductoBD.eliminarProducto(serie);
                    if (rpt) {
                        exito("Se elimino correctamente");
                        reportar();
                        limpiar();
                        deshabilitar();
                        txtSerie.requestFocus();
                    } else {
                        error("Tienes problemas al eliminar producto");
                    }
                }
            } else {
                error("Falta codigo");
                txtSerie.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        habilitar();
        reportar();
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed
        // TODO add your handling code here:

        limpiar_tabla_formulario();
        String descripcion = txtProducto.getText();
        DefaultTableModel tabla_temporal;
        DefaultTableModel tabla_temporal_producto = (DefaultTableModel) tabla_reporte_producto.getModel();
        ProductoBD oProductoBD = new ProductoBD();
        tabla_temporal = oProductoBD.buscarProductoDescripcion(descripcion);

        int cantidad_productos = tabla_temporal.getRowCount();
        for (int i = 0; i < cantidad_productos; i++) {
            String serie = tabla_temporal.getValueAt(i, 0).toString();
            descripcion = tabla_temporal.getValueAt(i, 1).toString();
            String observacion = tabla_temporal.getValueAt(i, 2).toString();
            String digemi = tabla_temporal.getValueAt(i, 3).toString();
            String condicion = tabla_temporal.getValueAt(i, 4).toString();
            String categoria = tabla_temporal.getValueAt(i, 5).toString();
            String marca = tabla_temporal.getValueAt(i, 6).toString();
            String medida = tabla_temporal.getValueAt(i, 7).toString();
            Object[] data = {serie, descripcion, observacion, digemi, condicion, categoria, marca, medida};
            tabla_temporal_producto.addRow(data);
        }

        tabla_reporte_producto.setModel(tabla_temporal_producto);
        txtCantidad.setText("" + cantidad_productos);
    }//GEN-LAST:event_txtProductoKeyPressed

    private void btnComposicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComposicionActionPerformed
        // TODO add your handling code here:
        Composicion_IU frame = new Composicion_IU();
        escritorioo.add(frame);
        Dimension a = escritorioo.getSize();
        Dimension b = frame.getSize();
        frame.setLocation((a.width - b.width) / 2, (a.height - b.height) / 2);
        frame.show();
    }//GEN-LAST:event_btnComposicionActionPerformed

    private void txtObservacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionFocusGained
        // TODO add your handling code here:
        txtObservacion.setBackground(Color.yellow);
    }//GEN-LAST:event_txtObservacionFocusGained

    private void txtObservacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservacionFocusLost
        // TODO add your handling code here:
        txtObservacion.setBackground(Color.white);
    }//GEN-LAST:event_txtObservacionFocusLost

    private void txtDigemiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDigemiFocusGained
        // TODO add your handling code here:
        txtDigemi.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDigemiFocusGained

    private void txtDigemiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDigemiFocusLost
        // TODO add your handling code here:
        txtDigemi.setBackground(Color.white);
    }//GEN-LAST:event_txtDigemiFocusLost

    private void txtProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusGained
        // TODO add your handling code here:
        txtProducto.setBackground(Color.yellow);
    }//GEN-LAST:event_txtProductoFocusGained

    private void txtProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductoFocusLost
        // TODO add your handling code here:
        txtProducto.setBackground(Color.white);
    }//GEN-LAST:event_txtProductoFocusLost

    private void txtObservacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDigemi.requestFocus();
        }
    }//GEN-LAST:event_txtObservacionKeyPressed

    private void txtDigemiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDigemiKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbCondicion.requestFocus();
        }
    }//GEN-LAST:event_txtDigemiKeyPressed

    private void txtObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtObservacionKeyTyped

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProductoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnComposicion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_producto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoCategoria;
    private javax.swing.JTextField txtCodigoMarca;
    private javax.swing.JTextField txtCodigoMedida;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDigemi;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}

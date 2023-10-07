/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class CompraBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public int registrarCompra(Compra c) {
        int idventa = 0;
        sql = "INSERT INTO compra(idcompra,coFecha,coTipoDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,provRuc,uDni,tienda) VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getCoFecha());
            pst.setString(2, c.getCoTipoDoc());
            pst.setString(3, c.getConNro());
            pst.setString(4, c.getCoTipoPago());
            pst.setString(5, c.getCoFormaPago());
            pst.setString(6, c.getCoMoneda());
            pst.setDouble(7, c.getCoSubTotal());
            pst.setDouble(8, c.getCoFlete());
            pst.setDouble(9, c.getCoIgv());
            pst.setDouble(10, c.getCoTotal());
            pst.setString(11, c.getProvRuc());
            pst.setString(12, c.getuDni());
            pst.setString(13, c.getTienda());

            pst.executeUpdate();

            ResultSet resultado = (ResultSet) pst.getGeneratedKeys();
            if (resultado.next()) {
                idventa = resultado.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar compra BD", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return -1;
        }
        return idventa;
    }

    public DefaultTableModel reportarComprasFechas(String fechaInicio, String fechaFinal) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"ID", "FECHA", "PROVEEDOR", "TIPODOC", "NRODOC", "TIPOPAGO", "FORMAPAGO", "MONEDA", "SUBTOTAL", "FLETE", "IGV", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idcompra,coFecha,provRazonSocial,coTipoDoc,coNroDoc,coTipopago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.provRuc,uDni,tienda FROM compra AS c "
                + "INNER JOIN proveedor AS p ON c.provRuc=p.provRuc "
                + "WHERE coFecha BETWEEN ? AND ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipoDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipopago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("provRuc");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");
                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al reportar compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public DefaultTableModel reportarComprasDocumentos(String fechaInicio, String fechaFinal, String documento) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"ID", "FECHA", "PROVEEDOR", "TIPODOC", "NRODOC", "TIPOPAGO", "FORMAPAGO", "MONEDA", "SUBTOTAL", "FLETE", "IGV", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idcompra,coFecha,provRazonSocial,coTipoDoc,coNroDoc,coTipopago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.provRuc,uDni,tienda FROM compra AS c "
                + "INNER JOIN proveedor AS p ON c.provRuc=p.provRuc "
                + "WHERE (coFecha BETWEEN ? AND ?) AND coTipoDoc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, documento);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipoDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipopago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("provRuc");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");
                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al reportar compra documentos BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public DefaultTableModel reportarComprasProveedor(String fechaInicio, String fechaFinal, String proveedor) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"ID", "FECHA", "PROVEEDOR", "TIPODOC", "NRODOC", "TIPOPAGO", "FORMAPAGO", "MONEDA", "SUBTOTAL", "FLETE", "IGV", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idcompra,coFecha,provRazonSocial,coTipoDoc,coNroDoc,coTipopago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.provRuc,uDni,tienda FROM compra AS c "
                + "INNER JOIN proveedor AS p ON c.provRuc=p.provRuc "
                + "WHERE (coFecha BETWEEN ? AND ?) AND provRazonSocial=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, proveedor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipoDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipopago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("provRuc");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");
                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al reportar compra proveedor BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean eliminarCompra(int idcompra) {
        boolean rpta = false;
        try {
            sql = "DELETE FROM compra WHERE idcompra=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar compra BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}

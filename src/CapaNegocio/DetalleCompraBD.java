/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class DetalleCompraBD {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleCompra(DetalleCompra d) {
     
        sql = "INSERT INTO detallecompra(idcompra,pSerie,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, d.getIdcompra());
            pst.setString(2, d.getpSerie());
            pst.setDouble(3, d.getDeCantidad());
            pst.setDouble(4, d.getDePrecio());
            pst.setDouble(5, d.getDeImporte());
            pst.setString(6, d.getDclote());
            pst.setString(7, d.getDcPresentacion());
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Detalle compra BD", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public DefaultTableModel buscarDetallesCompra(int idcompra) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"ID", "SERIE", "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE", "LOTE", "PRESENTACION"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idcompra, dc.pSerie,pDescripcion,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion FROM detallecompra AS dc "
                + "INNER JOIN producto AS p ON dc.pSerie=p.pSerie "
                + "WHERE idcompra=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("pSerie");
                registros[2] = rs.getString("pDescripcion");
                registros[3] = rs.getString("dcCantidad");
                registros[4] = rs.getString("dcPrecio");
                registros[5] = rs.getString("dcImporte");
                registros[6] = rs.getString("dcLote");
                registros[7] = rs.getString("dcPresentacion");

                tabla_temporal.addRow(registros);
            }
            pst.close();
            cn.close();
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar detalle compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean eliminarDetalleCompra(int idcompra) {
        boolean rpta = false;
        try {
            sql = "DELETE FROM detallecompra WHERE idcompra=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar detallecompra BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}

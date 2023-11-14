/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class DetalleVentaBD {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleVenta(DetalleVenta d) {
        boolean rpta = false;

        sql = "INSERT INTO detalleventa (pSerie,cant,medida,precio,descuento,importe,idventa,idep)VALUES (?,?,?,?,?,?,?,?)";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, d.getpSerie());
            pst.setDouble(2, d.getCant());
            pst.setString(3, d.getMedida());
            pst.setDouble(4, d.getPrecio());
            pst.setDouble(5, d.getDescuento());
            pst.setDouble(6, d.getImporte());
            pst.setInt(7, d.getIdventa());
            pst.setInt(8, d.getIdep());
            

            rpta = pst.executeUpdate() == 1 ? true : false;
            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar DetalleVenta....", JOptionPane.ERROR_MESSAGE);

            return rpta;
        }
        return rpta;
    }
    
     public DefaultTableModel buscarDetalleVenta(int idventa) {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "SERIE", "PRODUCTO", "CANT", "MEDIDA", "PRECIO", "DESCUENTO", "IMPORTE","IDEP"};
        String[] registros = new String[9];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idventa,dv.pSerie,pDescripcion,cant,medida,precio,descuento,importe,idep FROM detalleventa AS dv "
                + "INNER JOIN producto AS P ON dv.pSerie=p.pSerie "
                + "WHERE idventa=?";

        try {
            cn = mysql.conectar();
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idventa);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("idventa");
                registros[1] = rs.getString("pSerie");
                registros[2] = rs.getString("pDescripcion");
                registros[3] = rs.getString("cant");
                registros[4] = rs.getString("medida");
                registros[5] = rs.getString("precio");
                registros[6] = rs.getString("descuento");
                registros[7] = rs.getString("importe");
                registros[8] = rs.getString("idep");

                modelo.addRow(registros);
            }
            pst.close();
            cn.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al buscar detalle venta BD....", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
     }
}

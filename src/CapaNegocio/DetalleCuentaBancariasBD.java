/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleCuentasBancarias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class DetalleCuentaBancariasBD {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel buscarDetallesCuentasBancarias(String ruc) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"ID", "BANCO", "CUENTA", "NROCUENTA", "RUC"};
        String[] registros = new String[5];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idcuentas, banco,cuenta,nroCuenta,provRuc FROM detallecuentasbancarias "
                + "WHERE provRuc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ruc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idcuentas");
                registros[1] = rs.getString("banco");
                registros[2] = rs.getString("cuenta");
                registros[3] = rs.getString("nroCuenta");
                registros[4] = rs.getString("provRuc");

                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar detallecuentabancaria BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean registrarDetalleCuentasBancarias(DetalleCuentasBancarias d){
        boolean rpta=false;
        sql = "INSERT INTO detallecuentasbancarias (idcuentas,banco,cuenta,nroCuenta,provRuc) VALUES (0,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, d.getBanco());
            pst.setString(2, d.getCuenta());
            pst.setString(3, d.getNroCuenta());
            pst.setString(4, d.getProvRuc());
            
            rpta=pst.executeUpdate() ==1 ? true : false ;
            pst.close();
            cn.close();
            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar detallecuentabancarias bd", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }
    public boolean eliminarDetalleCuentasBancarias(int idcuentas) {
        boolean rpta=false;
        sql = "DELETE FROM detallecuentasbancarias WHERE idcuentas=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcuentas);
            
            rpta=pst.executeUpdate() ==1 ? true : false ;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar DetalleCuentasBancarias BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}

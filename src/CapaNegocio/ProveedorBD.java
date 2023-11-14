/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class ProveedorBD {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;
    
    public DefaultTableModel reportarProveedor() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"RUC", "RAZON_SOCIAL", "REPRESENTANTE", "DIRECCION", "CORREO", "WEB", "CELULAR"};
        String[] registros = new String[7];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT provRuc,provRazonSocial,provRepresentante,provDireccion,provCorreo,provCorreo,provWeb,provCelular FROM proveedor ";
              
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("provRuc");
                registros[1] = rs.getString("provRazonSocial");
                registros[2] = rs.getString("provRepresentante");
                registros[3] = rs.getString("provDireccion");
                registros[4] = rs.getString("provCorreo");
                registros[5] = rs.getString("provWeb");
                registros[6] = rs.getString("provCelular");
                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al reportar Proveedor", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean registrarProveedor(Proveedor p){
        boolean rpta=false;
        sql = "INSERT INTO proveedor (provRuc,provRazonSocial,provRepresentante,provDireccion,provCorreo,provWeb,provCelular) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, p.getProRuc());
            pst.setString(2, p.getProRazonSocial());
            pst.setString(3, p.getProvRepresentante());
            pst.setString(4, p.getProvDireccion());
            pst.setString(5, p.getProvCorreo());
            pst.setString(6, p.getProvWeb());
            pst.setString(7, p.getProvCelular());
            
            rpta=pst.executeUpdate() ==1 ? true : false ;
            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar proveedor bd", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }
    
    public DefaultTableModel buscarProveedor(String ruc) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"RUC", "RAZON_SOCIAL", "REPRESENTANTE", "DIRECCION", "CORREO", "WEB", "CELULAR"};
        String[] registros = new String[7];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT provRuc,provRazonSocial,provRepresentante,provDireccion,provCorreo,provCorreo,provWeb,provCelular FROM proveedor "
                + "WHERE provRuc=?";
              
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ruc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("provRuc");
                registros[1] = rs.getString("provRazonSocial");
                registros[2] = rs.getString("provRepresentante");
                registros[3] = rs.getString("provDireccion");
                registros[4] = rs.getString("provCorreo");
                registros[5] = rs.getString("provWeb");
                registros[6] = rs.getString("provCelular");
                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al buscar ProductoBD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean modificarProveedor(Proveedor p){
        boolean rpta=false;
        sql = "UPDATE proveedor SET provRazonSocial=?,provRepresentante=?,provDireccion=?,provCorreo=?,provWeb=?,provCelular=? WHERE provRuc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, p.getProRazonSocial());
            pst.setString(2, p.getProvRepresentante());
            pst.setString(3, p.getProvDireccion());
            pst.setString(4, p.getProvCorreo());
            pst.setString(5, p.getProvWeb());
            pst.setString(6, p.getProvCelular());
            pst.setString(7, p.getProRuc());
            rpta=pst.executeUpdate() ==1 ? true : false ;
            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al modificar proveedor bd", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }
    public boolean eliminarProveedor(String provRuc) {
        boolean rpta=false;

        try {
        sql = "DELETE FROM proveedor WHERE provRuc=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, provRuc);
            rpta=pst.executeUpdate() ==1 ? true : false ;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar proveedor", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}

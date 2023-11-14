/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Medida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class MedidaBD {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;
    
    public DefaultTableModel reportarMedida() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "PRESENTACION","EQUIVALENCIA"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idmedida,mPresentacion,mEquivalencia FROM medida";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idmedida");
                registros[1] = rs.getString("mPresentacion");
                registros[2] = rs.getString("mEquivalencia");
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al reportar Medida", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean registrarMedida(Medida m) {
        sql = "INSERT INTO medida(idmedida,mPresentacion,mEquivalencia) VALUES(NULL,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Medida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public boolean modificarMedida(Medida m) {
        sql = "UPDATE medida SET mPresentacion=?,mEquivalencia=? WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());
            pst.setInt(3, m.getIdmedida());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al modificar Medida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean eliminarMedida(int id) {
        sql = "DELETE FROM medida WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar Medida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

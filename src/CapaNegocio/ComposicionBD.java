/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Composicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Est.Invitado_04
 */
public class ComposicionBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Composicion> reportarComposicion() {
        List<Composicion> lista = new ArrayList<>();
        sql = "SELECT idcomposicion,coNombre,pSerie FROM composicion ORDER BY idcomposicion ASC";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Composicion oComposicion = new Composicion();

                oComposicion.setIdcomposicion(rs.getInt(1));
                oComposicion.setCoNombre(rs.getString(2));
                oComposicion.setpSerie(rs.getString(3));
                lista.add(oComposicion);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar composicion BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean registrarComposicion(Composicion co) {
        boolean rpta = false;
        sql = "INSERT INTO composicion (idcomposicion,coNombre,pSerie) VALUES (0,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, co.getCoNombre());
            pst.setString(2, co.getpSerie());

            rpta = pst.executeUpdate() == 1 ? true : false;
            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar composicion BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }

    public boolean eliminarComposicion(int idcomposicion) {
        boolean rpta = false;
        sql = "DELETE FROM composicion WHERE idcomposicion=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, idcomposicion);
            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar categoria", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}

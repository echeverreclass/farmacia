/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Categoria;
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
public class CategoriaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Categoria> reportarCategoria() {
        List<Categoria> lista = new ArrayList<>();
        sql = "SELECT idcategoria,catNombre FROM categoria";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categoria oCategoria = new Categoria();
                oCategoria.setIdcategoria(rs.getInt(1));
                oCategoria.setCatNombre(rs.getString(2));
                lista.add(oCategoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al reportar categoria BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public boolean registrarCategoria(Categoria ca) {
        boolean rpta = false;
        sql = "INSERT INTO categoria(idcategoria,catNombre) VALUES (0,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ca.getCatNombre());

            rpta = pst.executeUpdate() == 1 ? true : false;
            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar categoria BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }

    public boolean modificarCategoria(Categoria ca) {
        boolean rpta = false;
        sql = "UPDATE categoria SET catNombre=? WHERE idcategoria=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ca.getCatNombre());
            pst.setInt(2, ca.getIdcategoria());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al modificar categoria", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarCategoria(Categoria ca) {
        boolean rpta = false;
        sql = "DELETE FROM categoria WHERE idcategoria=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, ca.getIdcategoria());
            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar categoria", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public List<Categoria> BuscarCategorias(String valor) {
        List<Categoria> lista = new ArrayList<>();
        sql = "SELECT idcategoria,catNombre FROM categoria WHERE catNombre LIKE ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + valor + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categoria oCategoria = new Categoria();

                oCategoria.setIdcategoria(rs.getInt(1));
                oCategoria.setCatNombre(rs.getString(2));
                lista.add(oCategoria);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al buscar categoria", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

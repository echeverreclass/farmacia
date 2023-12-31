/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleCaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class DetalleCajaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<DetalleCaja> buscarDetalleCajaUsuario(String uDni, String fecha, String tienda, String opcion) {
        List<DetalleCaja> lista = new ArrayList<>();
        sql = "SELECT iddetallecaja,dcFecha,dcHora,dcCaja,opcion,dcCorrelativo,dcMotivo,dcMonto,dcEstado,uDni,tienda FROM detallecaja WHERE uDni=? AND dcFecha=? AND tienda=? AND opcion=?";
        try {
            cn = mysql.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, uDni);
            pst.setString(2, fecha);
            pst.setString(3, tienda);
            pst.setString(4, opcion);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DetalleCaja oDetalleCaja = new DetalleCaja();
                oDetalleCaja.setIddetallecaja(rs.getInt(1));
                oDetalleCaja.setDcFecha(rs.getString(2));
                oDetalleCaja.setDcHora(rs.getString(3));
                oDetalleCaja.setDcCaja(rs.getString(4));
                oDetalleCaja.setOpcion(rs.getString(5));
                oDetalleCaja.setDcCorrelativo(rs.getString(6));
                oDetalleCaja.setDcMotivo(rs.getString(7));
                oDetalleCaja.setDcMonto(rs.getDouble(8));
                oDetalleCaja.setDcEstado(rs.getString(9));
                oDetalleCaja.setuDni(rs.getString(10));
                oDetalleCaja.setTienda(rs.getString(11));

                lista.add(oDetalleCaja);
            }

            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar detalle..");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public boolean registrarDetalleCaja(DetalleCaja dc) {
        boolean rpta = false;
        sql = "INSERT INTO detallecaja (iddetallecaja,dcFecha,dcHora,dcCaja,opcion,dcCorrelativo,dcMotivo,dcMonto,dcEstado,uDni,tienda,idventa) VALUES (0,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dc.getDcFecha());
            pst.setString(2, dc.getDcHora());
            pst.setString(3, dc.getDcCaja());
            pst.setString(4, dc.getOpcion());
            pst.setString(5, dc.getDcCorrelativo());
            pst.setString(6, dc.getDcMotivo());
            pst.setDouble(7, dc.getDcMonto());
            pst.setString(8, dc.getDcEstado());
            pst.setString(9, dc.getuDni());
            pst.setString(10, dc.getTienda());
            pst.setInt(11, dc.getIdventa());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar detalle caja..");
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }

    public boolean anularDocumento(int iddetallecaja, String estado) {
        boolean rpta = false;
        sql = "UPDATE detallecaja SET dcEstado=? WHERE iddetallecaja=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, estado);
            pst.setInt(2, iddetallecaja);

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al anular", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }

    public List<DetalleCaja> buscarDetalleCajaCorrelativo(String correlativo, String fecha, String tienda, String opcion) {
        List<DetalleCaja> lista = new ArrayList<>();
        sql = "SELECT iddetallecaja,dcFecha,dcHora,dcCaja,opcion,dcCorrelativo,dcMotivo,dcMonto,dcEstado,uDni,tienda FROM detallecaja WHERE dcCorrelativo LIKE ? AND dcFecha=? AND tienda=? AND opcion=?";
        try {
            cn = mysql.conectar();

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + correlativo + "%");
            pst.setString(2, fecha);
            pst.setString(3, tienda);
            pst.setString(4, opcion);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DetalleCaja oDetalleCaja = new DetalleCaja();
                oDetalleCaja.setIddetallecaja(rs.getInt(1));
                oDetalleCaja.setDcFecha(rs.getString(2));
                oDetalleCaja.setDcHora(rs.getString(3));
                oDetalleCaja.setDcCaja(rs.getString(4));
                oDetalleCaja.setOpcion(rs.getString(5));
                oDetalleCaja.setDcCorrelativo(rs.getString(6));
                oDetalleCaja.setDcMotivo(rs.getString(7));
                oDetalleCaja.setDcMonto(rs.getDouble(8));
                oDetalleCaja.setDcEstado(rs.getString(9));
                oDetalleCaja.setuDni(rs.getString(10));
                oDetalleCaja.setTienda(rs.getString(11));

                lista.add(oDetalleCaja);
            }

            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar buscarDetalleCajaCorrelativo..");
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public DefaultTableModel mostrarTotalDineroXTipo(String tipo, String estado, String tienda, String usuario, String caja) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"TOTAL"};
        String[] registros = new String[1];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT SUM(dcMonto) AS total FROM detalleCaja WHERE opcion=? AND dcEstado=? AND tienda=? AND uDni=? AND dcCaja=? ";

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, estado);
            pst.setString(3, tienda);
            pst.setString(4, usuario);
            pst.setString(5, caja);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                registros[0] = rs.getString("total");

                tabla_temporal.addRow(registros);
            }

            pst.close();
            cn.close();
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al mostrar dinero..", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean actualizarEstado(String estado, String uDni,String tienda,String caja) {
        boolean rpta = false;
        sql = "UPDATE detallecaja SET dcEstado=? WHERE uDni=? AND tienda=? AND dcCaja=?";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, estado);
            pst.setString(2, uDni);
            pst.setString(3, tienda);
            pst.setString(4, caja);

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

            return rpta;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al actualizar estado de detalle caja BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
    }
}

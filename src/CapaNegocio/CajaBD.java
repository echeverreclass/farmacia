/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Caja;
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
public class CajaBD {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Caja> obtenerSaldoAnterior() {
        List<Caja> lista = new ArrayList<>();
        sql = "SELECT idcaja,caFecha,hora,total_ingreso,total_egreso,saldo_final,nroCaja,caEstado,uDni,tienda FROM caja ORDER BY idcaja DESC LIMIT 0,1";
        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Caja oCaja = new Caja();
                oCaja.setIdcaja(rs.getInt(1));
                oCaja.setCaFecha(rs.getString(2));
                oCaja.setHora(rs.getString(3));
                oCaja.setTotal_ingreso(rs.getDouble(4));
                oCaja.setTotal_egreso(rs.getDouble(5));
                oCaja.setSaldo_final(rs.getDouble(6));
                oCaja.setNroCaja(rs.getString(7));
                oCaja.setCaEstado(rs.getString(8));
                oCaja.setuDni(rs.getString(9));
                oCaja.setTienda(rs.getString(10));

                lista.add(oCaja);
            }

            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar saldo..");
            e.printStackTrace();
            return null;
        }
        return lista;
    }
    
    public boolean registrarCaja(Caja c) {
        boolean rpta = false;
        sql = "INSERT INTO caja (idcaja,caFecha,hora,total_ingreso,total_egreso,saldo_final,nroCaja,caEstado,uDni,tienda) VALUES (0,?,?,?,?,?,?,?,?,?)";
        try {

            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, c.getCaFecha());
            pst.setString(2, c.getHora());
            pst.setDouble(3, c.getTotal_ingreso());
            pst.setDouble(4, c.getTotal_egreso());
            pst.setDouble(5, c.getSaldo_final());
            pst.setString(6, c.getNroCaja());
            pst.setString(7, c.getCaEstado());
            pst.setString(8, c.getuDni());
            pst.setString(9, c.getTienda());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar caja..");
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }
}

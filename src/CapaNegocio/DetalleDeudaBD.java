/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleDeuda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Est.Invitado_04
 */
public class DetalleDeudaBD {
        private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleDuda(DetalleDeuda dd) {

        sql = "INSERT INTO detalledeuda(iddeuda,idventa) VALUES(?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dd.getIddeuda());
            pst.setInt(2, dd.getIdventa());
            
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar deuda ....", JOptionPane.ERROR_MESSAGE);

            return false;
        }
        return true;
    }
}

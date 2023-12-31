/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Turno;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Est.Invitado_04
 */
public class TurnoBD {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTurno() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"ID", "DESCRIPCION", "INICIO", "FIN", "USUARIO"};
        String[] registros = new String[5];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT idturno, descripcion,inicio,fin, CONCAT(uApellidos,' ',uNombre) AS usuario FROM turno AS t"
                + " INNER JOIN usuario AS u ON t.uDni=u.uDni";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idturno");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("inicio");
                registros[3] = rs.getString("fin");
                registros[4] = rs.getString("usuario");

                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Turno BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean registrarTurno(Turno t) {
        boolean rpta=false;
        sql = "INSERT INTO turno(idturno,descripcion,inicio,fin,uDni) VALUES(0,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, t.getDescripcion());
            pst.setString(2, t.getInicio());
            pst.setString(3, t.getFin());
            pst.setString(4, t.getuDni());
            rpta=pst.executeUpdate() ==1 ? true : false ;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Turno BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    public boolean eliminarTurno(int idturno) {
        boolean rpta=false;
        sql = "DELETE FROM turno WHERE idturno=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idturno);
            
            rpta=pst.executeUpdate() ==1 ? true : false ;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar turno BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    public List<Turno> buscarTurno (String inicio,String fin,String uDni){
        List<Turno> lista= new ArrayList<>();
        sql="SELECT idturno,descripcion,inicio,fin,uDni FROM turno WHERE (inicio<? AND fin>?) AND uDni=? ";
        try {
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, inicio);
            pst.setString(2, fin);
            pst.setString(3, uDni);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Turno oTurno = new Turno();
                oTurno.setIdturno(rs.getInt(1));
                oTurno.setDescripcion(rs.getString(2));
                oTurno.setInicio(rs.getString(3));
                oTurno.setFin(rs.getString(4));
                oTurno.setuDni(rs.getString(5));
                
                lista.add(oTurno);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar turno BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }
    
    public List<Turno> verificarHorario (String fin,String uDni){
        List<Turno> lista= new ArrayList<>();
        sql="SELECT idturno,descripcion,inicio,fin,uDni FROM turno WHERE fin>? AND uDni=? ";
        try {
            cn = mysql.conectar();
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, fin);
            pst.setString(2, uDni);
            ResultSet rs= pst.executeQuery();
            while (rs.next()) {
                Turno oTurno = new Turno();
                oTurno.setIdturno(rs.getInt(1));
                oTurno.setDescripcion(rs.getString(2));
                oTurno.setInicio(rs.getString(3));
                oTurno.setFin(rs.getString(4));
                oTurno.setuDni(rs.getString(5));
                
                lista.add(oTurno);
            }
            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar turno !..", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }
}

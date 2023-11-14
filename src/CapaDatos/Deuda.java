/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;

/**
 *
 * @author Est.Invitado_04
 */
public class Deuda {
    int iddeuda;
    String cliRuc_Dni;
    double totalDeuda;
    double saldo;
    String fechaApertura;
    String fechaCierre;
    String estado;
    String tienda;

    public Deuda() {
    }

    public Deuda(int iddeuda, String cliRuc_Dni, double totalDeuda, double saldo, String fechaApertura, String fechaCierre, String estado, String tienda) {
        this.iddeuda = iddeuda;
        this.cliRuc_Dni = cliRuc_Dni;
        this.totalDeuda = totalDeuda;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.tienda = tienda;
    }

    public int getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(int iddeuda) {
        this.iddeuda = iddeuda;
    }

    public String getCliRuc_Dni() {
        return cliRuc_Dni;
    }

    public void setCliRuc_Dni(String cliRuc_Dni) {
        this.cliRuc_Dni = cliRuc_Dni;
    }

    public double getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(double totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
    
}

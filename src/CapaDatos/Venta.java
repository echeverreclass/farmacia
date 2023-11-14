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
public class Venta {
    private int idventa;
    private String vFecha;
    private String vHora;
    private double vsubTotal;
    private String vDocumento;
    private String vCorrelativo;
    private String vTipoPago;
    private String vFormapago;
    private String vEstado;
    private String vMoneda;
    private int vIgv;
    private double vTotalPagar;
    private double vPagoCon;
    private double vVuelto;
    private String cliRuc_Dni;
    private String uDni;
    private String tienda;

    public Venta() {
    }

    public Venta(int idventa, String vFecha, String vHora, double vsubTotal, String vDocumento, String vCorrelativo, String vTipoPago, String vFormapago, String vEstado, String vMoneda, int vIgv, double vTotalPagar, double vPagoCon, double vVuelto, String cliRuc_Dni, String uDni, String tienda) {
        this.idventa = idventa;
        this.vFecha = vFecha;
        this.vHora = vHora;
        this.vsubTotal = vsubTotal;
        this.vDocumento = vDocumento;
        this.vCorrelativo = vCorrelativo;
        this.vTipoPago = vTipoPago;
        this.vFormapago = vFormapago;
        this.vEstado = vEstado;
        this.vMoneda = vMoneda;
        this.vIgv = vIgv;
        this.vTotalPagar = vTotalPagar;
        this.vPagoCon = vPagoCon;
        this.vVuelto = vVuelto;
        this.cliRuc_Dni = cliRuc_Dni;
        this.uDni = uDni;
        this.tienda = tienda;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getvFecha() {
        return vFecha;
    }

    public void setvFecha(String vFecha) {
        this.vFecha = vFecha;
    }

    public String getvHora() {
        return vHora;
    }

    public void setvHora(String vHora) {
        this.vHora = vHora;
    }

    public double getVsubTotal() {
        return vsubTotal;
    }

    public void setVsubTotal(double vsubTotal) {
        this.vsubTotal = vsubTotal;
    }

    public String getvDocumento() {
        return vDocumento;
    }

    public void setvDocumento(String vDocumento) {
        this.vDocumento = vDocumento;
    }

    public String getvCorrelativo() {
        return vCorrelativo;
    }

    public void setvCorrelativo(String vCorrelativo) {
        this.vCorrelativo = vCorrelativo;
    }

    public String getvTipoPago() {
        return vTipoPago;
    }

    public void setvTipoPago(String vTipoPago) {
        this.vTipoPago = vTipoPago;
    }

    public String getvFormapago() {
        return vFormapago;
    }

    public void setvFormapago(String vFormapago) {
        this.vFormapago = vFormapago;
    }

    public String getvEstado() {
        return vEstado;
    }

    public void setvEstado(String vEstado) {
        this.vEstado = vEstado;
    }

    public String getvMoneda() {
        return vMoneda;
    }

    public void setvMoneda(String vMoneda) {
        this.vMoneda = vMoneda;
    }

    public int getvIgv() {
        return vIgv;
    }

    public void setvIgv(int vIgv) {
        this.vIgv = vIgv;
    }

    public double getvTotalPagar() {
        return vTotalPagar;
    }

    public void setvTotalPagar(double vTotalPagar) {
        this.vTotalPagar = vTotalPagar;
    }

    public double getvPagoCon() {
        return vPagoCon;
    }

    public void setvPagoCon(double vPagoCon) {
        this.vPagoCon = vPagoCon;
    }

    public double getvVuelto() {
        return vVuelto;
    }

    public void setvVuelto(double vVuelto) {
        this.vVuelto = vVuelto;
    }

    public String getCliRuc_Dni() {
        return cliRuc_Dni;
    }

    public void setCliRuc_Dni(String cliRuc_Dni) {
        this.cliRuc_Dni = cliRuc_Dni;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

   
}

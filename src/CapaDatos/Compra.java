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
public class Compra {
    private int idCompra;
    private String coFecha;
    private String coTipoDoc;
    private String conNro;
    private String coTipoPago;
    private String coFormaPago;
    private String coMoneda;
    private double coSubTotal;
    private double coFlete;
    private double coIgv;
    private double coTotal;
    private String provRuc;
    private String uDni;
    private String tienda;

    public Compra() {
    }

    public Compra(int idCompra, String coFecha, String coTipoDoc, String conNro, String coTipoPago, String coFormaPago, String coMoneda, double coSubTotal, double coFlete, double coIgv, double coTotal, String provRuc, String uDni, String tienda) {
        this.idCompra = idCompra;
        this.coFecha = coFecha;
        this.coTipoDoc = coTipoDoc;
        this.conNro = conNro;
        this.coTipoPago = coTipoPago;
        this.coFormaPago = coFormaPago;
        this.coMoneda = coMoneda;
        this.coSubTotal = coSubTotal;
        this.coFlete = coFlete;
        this.coIgv = coIgv;
        this.coTotal = coTotal;
        this.provRuc = provRuc;
        this.uDni = uDni;
        this.tienda = tienda;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getCoFecha() {
        return coFecha;
    }

    public void setCoFecha(String coFecha) {
        this.coFecha = coFecha;
    }

    public String getCoTipoDoc() {
        return coTipoDoc;
    }

    public void setCoTipoDoc(String coTipoDoc) {
        this.coTipoDoc = coTipoDoc;
    }

    public String getConNro() {
        return conNro;
    }

    public void setConNro(String conNro) {
        this.conNro = conNro;
    }

    public String getCoTipoPago() {
        return coTipoPago;
    }

    public void setCoTipoPago(String coTipoPago) {
        this.coTipoPago = coTipoPago;
    }

    public String getCoFormaPago() {
        return coFormaPago;
    }

    public void setCoFormaPago(String coFormaPago) {
        this.coFormaPago = coFormaPago;
    }

    public String getCoMoneda() {
        return coMoneda;
    }

    public void setCoMoneda(String coMoneda) {
        this.coMoneda = coMoneda;
    }

    public double getCoSubTotal() {
        return coSubTotal;
    }

    public void setCoSubTotal(double coSubTotal) {
        this.coSubTotal = coSubTotal;
    }

    public double getCoFlete() {
        return coFlete;
    }

    public void setCoFlete(double coFlete) {
        this.coFlete = coFlete;
    }

    public double getCoIgv() {
        return coIgv;
    }

    public void setCoIgv(double coIgv) {
        this.coIgv = coIgv;
    }

    public double getCoTotal() {
        return coTotal;
    }

    public void setCoTotal(double coTotal) {
        this.coTotal = coTotal;
    }

    public String getProvRuc() {
        return provRuc;
    }

    public void setProvRuc(String provRuc) {
        this.provRuc = provRuc;
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

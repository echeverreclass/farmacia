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
public class DetalleCaja {
    private int iddetallecaja;
    private String dcFecha;
    private String dcHora;
    private String dcCaja;
    private String opcion;
    private String dcCorrelativo;
    private String dcMotivo;
    private double dcMonto;
    private String dcEstado;
    private String uDni;
    private String tienda;
    private int idventa;

    public DetalleCaja() {
    }

    public DetalleCaja(int iddetallecaja, String dcFecha, String dcHora, String dcCaja, String opcion, String dcCorrelativo, String dcMotivo, double dcMonto, String dcEstado, String uDni, String tienda, int idventa) {
        this.iddetallecaja = iddetallecaja;
        this.dcFecha = dcFecha;
        this.dcHora = dcHora;
        this.dcCaja = dcCaja;
        this.opcion = opcion;
        this.dcCorrelativo = dcCorrelativo;
        this.dcMotivo = dcMotivo;
        this.dcMonto = dcMonto;
        this.dcEstado = dcEstado;
        this.uDni = uDni;
        this.tienda = tienda;
        this.idventa = idventa;
    }

    public int getIddetallecaja() {
        return iddetallecaja;
    }

    public void setIddetallecaja(int iddetallecaja) {
        this.iddetallecaja = iddetallecaja;
    }

    public String getDcFecha() {
        return dcFecha;
    }

    public void setDcFecha(String dcFecha) {
        this.dcFecha = dcFecha;
    }

    public String getDcHora() {
        return dcHora;
    }

    public void setDcHora(String dcHora) {
        this.dcHora = dcHora;
    }

    public String getDcCaja() {
        return dcCaja;
    }

    public void setDcCaja(String dcCaja) {
        this.dcCaja = dcCaja;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getDcCorrelativo() {
        return dcCorrelativo;
    }

    public void setDcCorrelativo(String dcCorrelativo) {
        this.dcCorrelativo = dcCorrelativo;
    }

    public String getDcMotivo() {
        return dcMotivo;
    }

    public void setDcMotivo(String dcMotivo) {
        this.dcMotivo = dcMotivo;
    }

    public double getDcMonto() {
        return dcMonto;
    }

    public void setDcMonto(double dcMonto) {
        this.dcMonto = dcMonto;
    }

    public String getDcEstado() {
        return dcEstado;
    }

    public void setDcEstado(String dcEstado) {
        this.dcEstado = dcEstado;
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

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    
    
}

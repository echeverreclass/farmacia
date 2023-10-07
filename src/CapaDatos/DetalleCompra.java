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
public class DetalleCompra {
    private int idcompra;
    private String pSerie;
    private double deCantidad;
    private double dePrecio;
    private double deImporte;
    private String dclote;
    private String dcPresentacion;

    public DetalleCompra() {
    }

    public DetalleCompra(int idcompra, String pSerie, double deCantidad, double dePrecio, double deImporte, String dclote, String dcPresentacion) {
        this.idcompra = idcompra;
        this.pSerie = pSerie;
        this.deCantidad = deCantidad;
        this.dePrecio = dePrecio;
        this.deImporte = deImporte;
        this.dclote = dclote;
        this.dcPresentacion = dcPresentacion;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public double getDeCantidad() {
        return deCantidad;
    }

    public void setDeCantidad(double deCantidad) {
        this.deCantidad = deCantidad;
    }

    public double getDePrecio() {
        return dePrecio;
    }

    public void setDePrecio(double dePrecio) {
        this.dePrecio = dePrecio;
    }

    public double getDeImporte() {
        return deImporte;
    }

    public void setDeImporte(double deImporte) {
        this.deImporte = deImporte;
    }

    public String getDclote() {
        return dclote;
    }

    public void setDclote(String dclote) {
        this.dclote = dclote;
    }

    public String getDcPresentacion() {
        return dcPresentacion;
    }

    public void setDcPresentacion(String dcPresentacion) {
        this.dcPresentacion = dcPresentacion;
    }
    
    
}

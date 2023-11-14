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
public class Kardex {
    private int idkardex;
    private String fecha;
    private String hora;
    private String tipoOPeracion;
    private String kDescripcion;
    private String pSerie;
    private String lote;
    private String presentacion;
    private double kCantidad;
    private double kPrecio;
    private double kImporte;
    private String tienda;
    private int idventa;

    public Kardex() {
    }

    public Kardex(int idkardex, String fecha, String hora, String tipoOPeracion, String kDescripcion, String pSerie, String lote, String presentacion, double kCantidad, double kPrecio, double kImporte, String tienda, int idventa) {
        this.idkardex = idkardex;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoOPeracion = tipoOPeracion;
        this.kDescripcion = kDescripcion;
        this.pSerie = pSerie;
        this.lote = lote;
        this.presentacion = presentacion;
        this.kCantidad = kCantidad;
        this.kPrecio = kPrecio;
        this.kImporte = kImporte;
        this.tienda = tienda;
        this.idventa = idventa;
    }

    public int getIdkardex() {
        return idkardex;
    }

    public void setIdkardex(int idkardex) {
        this.idkardex = idkardex;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoOPeracion() {
        return tipoOPeracion;
    }

    public void setTipoOPeracion(String tipoOPeracion) {
        this.tipoOPeracion = tipoOPeracion;
    }

    public String getkDescripcion() {
        return kDescripcion;
    }

    public void setkDescripcion(String kDescripcion) {
        this.kDescripcion = kDescripcion;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getkCantidad() {
        return kCantidad;
    }

    public void setkCantidad(double kCantidad) {
        this.kCantidad = kCantidad;
    }

    public double getkPrecio() {
        return kPrecio;
    }

    public void setkPrecio(double kPrecio) {
        this.kPrecio = kPrecio;
    }

    public double getkImporte() {
        return kImporte;
    }

    public void setkImporte(double kImporte) {
        this.kImporte = kImporte;
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

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
public class EntradaProducto {
    private int idep;
    private String fecha_hora_ingreso;
    private String pSerie;
    private String lote;
    private String presentacion;
    private String equivalencia;
    private String fechaVcto;
    private double stockPresentacion;
    private int stockEquivalencia;
    private double PrecioCompraPresentacion;
    private double PrecioCompraEquivalencia;
    private int margenGananciaPresentacion;
    private int margenGananciaEquivalencia;
    private double PrecioVentaPresentacionMayor;
    private double PrecioVentaPresentacionMenor;
    private double PrecioVentaEquivalenciaMayor;
    private double PrecioVentaEquivalenciaMenor;
    private int ref;
    private String tienda;

    public EntradaProducto() {
    }

    public EntradaProducto(int idep, String fecha_hora_ingreso, String pSerie, String lote, String presentacion, String equivalencia, String fechaVcto, double stockPresentacion, int stockEquivalencia, double PrecioCompraPresentacion, double PrecioCompraEquivalencia, int margenGananciaPresentacion, int margenGananciaEquivalencia, double PrecioVentaPresentacionMayor, double PrecioVentaPresentacionMenor, double PrecioVentaEquivalenciaMayor, double PrecioVentaEquivalenciaMenor, int ref, String tienda) {
        this.idep = idep;
        this.fecha_hora_ingreso = fecha_hora_ingreso;
        this.pSerie = pSerie;
        this.lote = lote;
        this.presentacion = presentacion;
        this.equivalencia = equivalencia;
        this.fechaVcto = fechaVcto;
        this.stockPresentacion = stockPresentacion;
        this.stockEquivalencia = stockEquivalencia;
        this.PrecioCompraPresentacion = PrecioCompraPresentacion;
        this.PrecioCompraEquivalencia = PrecioCompraEquivalencia;
        this.margenGananciaPresentacion = margenGananciaPresentacion;
        this.margenGananciaEquivalencia = margenGananciaEquivalencia;
        this.PrecioVentaPresentacionMayor = PrecioVentaPresentacionMayor;
        this.PrecioVentaPresentacionMenor = PrecioVentaPresentacionMenor;
        this.PrecioVentaEquivalenciaMayor = PrecioVentaEquivalenciaMayor;
        this.PrecioVentaEquivalenciaMenor = PrecioVentaEquivalenciaMenor;
        this.ref = ref;
        this.tienda = tienda;
    }

    public int getIdep() {
        return idep;
    }

    public void setIdep(int idep) {
        this.idep = idep;
    }

    public String getFecha_hora_ingreso() {
        return fecha_hora_ingreso;
    }

    public void setFecha_hora_ingreso(String fecha_hora_ingreso) {
        this.fecha_hora_ingreso = fecha_hora_ingreso;
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

    public String getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(String equivalencia) {
        this.equivalencia = equivalencia;
    }

    public String getFechaVcto() {
        return fechaVcto;
    }

    public void setFechaVcto(String fechaVcto) {
        this.fechaVcto = fechaVcto;
    }

    public double getStockPresentacion() {
        return stockPresentacion;
    }

    public void setStockPresentacion(double stockPresentacion) {
        this.stockPresentacion = stockPresentacion;
    }

    public int getStockEquivalencia() {
        return stockEquivalencia;
    }

    public void setStockEquivalencia(int stockEquivalencia) {
        this.stockEquivalencia = stockEquivalencia;
    }

    public double getPrecioCompraPresentacion() {
        return PrecioCompraPresentacion;
    }

    public void setPrecioCompraPresentacion(double PrecioCompraPresentacion) {
        this.PrecioCompraPresentacion = PrecioCompraPresentacion;
    }

    public double getPrecioCompraEquivalencia() {
        return PrecioCompraEquivalencia;
    }

    public void setPrecioCompraEquivalencia(double PrecioCompraEquivalencia) {
        this.PrecioCompraEquivalencia = PrecioCompraEquivalencia;
    }

    public int getMargenGananciaPresentacion() {
        return margenGananciaPresentacion;
    }

    public void setMargenGananciaPresentacion(int margenGananciaPresentacion) {
        this.margenGananciaPresentacion = margenGananciaPresentacion;
    }

    public int getMargenGananciaEquivalencia() {
        return margenGananciaEquivalencia;
    }

    public void setMargenGananciaEquivalencia(int margenGananciaEquivalencia) {
        this.margenGananciaEquivalencia = margenGananciaEquivalencia;
    }

    public double getPrecioVentaPresentacionMayor() {
        return PrecioVentaPresentacionMayor;
    }

    public void setPrecioVentaPresentacionMayor(double PrecioVentaPresentacionMayor) {
        this.PrecioVentaPresentacionMayor = PrecioVentaPresentacionMayor;
    }

    public double getPrecioVentaPresentacionMenor() {
        return PrecioVentaPresentacionMenor;
    }

    public void setPrecioVentaPresentacionMenor(double PrecioVentaPresentacionMenor) {
        this.PrecioVentaPresentacionMenor = PrecioVentaPresentacionMenor;
    }

    public double getPrecioVentaEquivalenciaMayor() {
        return PrecioVentaEquivalenciaMayor;
    }

    public void setPrecioVentaEquivalenciaMayor(double PrecioVentaEquivalenciaMayor) {
        this.PrecioVentaEquivalenciaMayor = PrecioVentaEquivalenciaMayor;
    }

    public double getPrecioVentaEquivalenciaMenor() {
        return PrecioVentaEquivalenciaMenor;
    }

    public void setPrecioVentaEquivalenciaMenor(double PrecioVentaEquivalenciaMenor) {
        this.PrecioVentaEquivalenciaMenor = PrecioVentaEquivalenciaMenor;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    
}
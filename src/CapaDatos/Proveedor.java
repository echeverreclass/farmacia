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
public class Proveedor {
    private String proRuc;
    private String proRazonSocial;
    private String provRepresentante;
    private String provDireccion;
    private String provCorreo;
    private String provWeb;
    private String provCelular;

    public Proveedor() {
    }

    public Proveedor(String proRuc, String proRazonSocial, String provRepresentante, String provDireccion, String provCorreo, String provWeb, String provCelular) {
        this.proRuc = proRuc;
        this.proRazonSocial = proRazonSocial;
        this.provRepresentante = provRepresentante;
        this.provDireccion = provDireccion;
        this.provCorreo = provCorreo;
        this.provWeb = provWeb;
        this.provCelular = provCelular;
    }

    public String getProRuc() {
        return proRuc;
    }

    public void setProRuc(String proRuc) {
        this.proRuc = proRuc;
    }

    public String getProRazonSocial() {
        return proRazonSocial;
    }

    public void setProRazonSocial(String proRazonSocial) {
        this.proRazonSocial = proRazonSocial;
    }

    public String getProvRepresentante() {
        return provRepresentante;
    }

    public void setProvRepresentante(String provRepresentante) {
        this.provRepresentante = provRepresentante;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public String getProvCorreo() {
        return provCorreo;
    }

    public void setProvCorreo(String provCorreo) {
        this.provCorreo = provCorreo;
    }

    public String getProvWeb() {
        return provWeb;
    }

    public void setProvWeb(String provWeb) {
        this.provWeb = provWeb;
    }

    public String getProvCelular() {
        return provCelular;
    }

    public void setProvCelular(String provCelular) {
        this.provCelular = provCelular;
    }
    
    
}

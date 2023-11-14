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
public class Cliente {
    private String cliRuc_Dni;
    private String cliDatos;
    private String cliDireccion;
    private String cliCelular;
    private String cliCorreo;

    public Cliente() {
    }

    public Cliente(String cliRuc_Dni, String cliDatos, String cliDireccion, String cliCelular, String cliCorreo) {
        this.cliRuc_Dni = cliRuc_Dni;
        this.cliDatos = cliDatos;
        this.cliDireccion = cliDireccion;
        this.cliCelular = cliCelular;
        this.cliCorreo = cliCorreo;
    }

    public String getCliRuc_Dni() {
        return cliRuc_Dni;
    }

    public void setCliRuc_Dni(String cliRuc_Dni) {
        this.cliRuc_Dni = cliRuc_Dni;
    }

    public String getCliDatos() {
        return cliDatos;
    }

    public void setCliDatos(String cliDatos) {
        this.cliDatos = cliDatos;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliCelular() {
        return cliCelular;
    }

    public void setCliCelular(String cliCelular) {
        this.cliCelular = cliCelular;
    }

    public String getCliCorreo() {
        return cliCorreo;
    }

    public void setCliCorreo(String cliCorreo) {
        this.cliCorreo = cliCorreo;
    }
    
    
}

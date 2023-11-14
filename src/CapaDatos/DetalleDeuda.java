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
public class DetalleDeuda {
    int iddeuda;
    int idventa;

    public DetalleDeuda() {
    }

    public DetalleDeuda(int iddeuda, int idventa) {
        this.iddeuda = iddeuda;
        this.idventa = idventa;
    }

    public int getIddeuda() {
        return iddeuda;
    }

    public void setIddeuda(int iddeuda) {
        this.iddeuda = iddeuda;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    
    
}

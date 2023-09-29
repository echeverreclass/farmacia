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
public class Asistencia {
    private int idasistencia;
    private String aFechaE;
    private String aHoraE;
    private String aHoraS;
    private String uDni;
    private String aTurno;
    private String aEstado;
    private String tienda;

    public Asistencia() {
    }

    public Asistencia(int idasistencia, String aFechaE, String aHoraE, String aHoraS, String uDni, String aTurno, String aEstado, String tienda) {
        this.idasistencia = idasistencia;
        this.aFechaE = aFechaE;
        this.aHoraE = aHoraE;
        this.aHoraS = aHoraS;
        this.uDni = uDni;
        this.aTurno = aTurno;
        this.aEstado = aEstado;
        this.tienda = tienda;
    }

    public int getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(int idasistencia) {
        this.idasistencia = idasistencia;
    }

    public String getaFechaE() {
        return aFechaE;
    }

    public void setaFechaE(String aFechaE) {
        this.aFechaE = aFechaE;
    }

    public String getaHoraE() {
        return aHoraE;
    }

    public void setaHoraE(String aHoraE) {
        this.aHoraE = aHoraE;
    }

    public String getaHoraS() {
        return aHoraS;
    }

    public void setaHoraS(String aHoraS) {
        this.aHoraS = aHoraS;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getaTurno() {
        return aTurno;
    }

    public void setaTurno(String aTurno) {
        this.aTurno = aTurno;
    }

    public String getaEstado() {
        return aEstado;
    }

    public void setaEstado(String aEstado) {
        this.aEstado = aEstado;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
    
    
}

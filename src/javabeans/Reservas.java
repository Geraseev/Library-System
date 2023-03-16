/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

/**
 *
 * @author lgera
 */
public class Reservas {
    private String dataR;
    private String dataE;
    private int idreserva;
    private String tit;
    private int idliv;

    public int getIdliv() {
        return idliv;
    }

    public void setIdliv(int idliv) {
        this.idliv = idliv;
    }


    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getDataR() {
        return dataR;
    }

    public void setDataR(String dataR) {
        this.dataR = dataR;
    }

    public String getDataE() {
        return dataE;
    }

    public void setDataE(String dataE) {
        this.dataE = dataE;
    }
}

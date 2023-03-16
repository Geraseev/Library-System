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
public class Emprestimos {
    private String dataRet;
    private String dataEm;
    private int idliv;
    private String tit;
    private String user;
    private String cpf;
    private int idemp;

    public int getIdliv() {
        return idliv;
    }

    public void setIdliv(int idliv) {
        this.idliv = idliv;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public String getDataRet() {
        return dataRet;
    }

    public void setDataRet(String dataRet) {
        this.dataRet = dataRet;
    }

    public String getDataEm() {
        return dataEm;
    }

    public void setDataEm(String dataEm) {
        this.dataEm = dataEm;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.bean;

import java.io.Serializable;

public class Opcoes implements Serializable {
    private static final long serialVersionUID = 1L;
    private String chave;
    private String valor;

    public Opcoes() {
    }

    public Opcoes(String chave) {
        this.chave = chave;
    }

    public Opcoes(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chave != null ? chave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcoes)) {
            return false;
        }
        Opcoes other = (Opcoes) object;
        if ((this.chave == null && other.chave != null) || (this.chave != null && !this.chave.equals(other.chave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.Opcoes[ chave=" + chave + " ]";
    }
    
}

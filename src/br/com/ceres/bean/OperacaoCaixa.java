/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.bean;

import java.io.Serializable;

public class OperacaoCaixa implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long id;
    private String formaPagamento;
    private String tipoOperacao;
    private float valor;
    private String observacao;
    private Caixa caixa;

    public OperacaoCaixa() {
    }

    public OperacaoCaixa(Long id) {
        this.id = id;
    }

    public OperacaoCaixa(Long id, String formaPagamento, String tipoOperacao, float valor) {
        this.id = id;
        this.formaPagamento = formaPagamento;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacaoCaixa)) {
            return false;
        }
        OperacaoCaixa other = (OperacaoCaixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.OperacaoCaixa[ id=" + id + " ]";
    }
    
}

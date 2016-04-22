/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Caixa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date abertoEm;
    private Date fechadoEm;
    private Float entradaDinheiro;
    private Float entradaCartaoDebito;
    private Float entradaCartaoCredito;
    private Float entradaCheque;
    private Float totalEntrada;
    private Float saidaDinheiro;
    private Float saidaCheque;
    private float saldoInicial;
    private Float saldoFinal;
    private String observacao;
    private Funcionario funcionario;
    private Collection<OperacaoCaixa> operacaoCaixaCollection;

    public Caixa() {
    }

    public Caixa(Long id) {
        this.id = id;
    }

    public Caixa(Long id, float saldoInicial) {
        this.id = id;
        this.saldoInicial = saldoInicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAbertoEm() {
        return abertoEm;
    }

    public void setAbertoEm(Date abertoEm) {
        this.abertoEm = abertoEm;
    }

    public Date getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(Date fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public Float getEntradaDinheiro() {
        return entradaDinheiro;
    }

    public void setEntradaDinheiro(Float entradaDinheiro) {
        this.entradaDinheiro = entradaDinheiro;
    }

    public Float getEntradaCartaoDebito() {
        return entradaCartaoDebito;
    }

    public void setEntradaCartaoDebito(Float entradaCartaoDebito) {
        this.entradaCartaoDebito = entradaCartaoDebito;
    }

    public Float getEntradaCartaoCredito() {
        return entradaCartaoCredito;
    }

    public void setEntradaCartaoCredito(Float entradaCartaoCredito) {
        this.entradaCartaoCredito = entradaCartaoCredito;
    }

    public Float getEntradaCheque() {
        return entradaCheque;
    }

    public void setEntradaCheque(Float entradaCheque) {
        this.entradaCheque = entradaCheque;
    }

    public Float getTotalEntrada() {
        return totalEntrada;
    }

    public void setTotalEntrada(Float totalEntrada) {
        this.totalEntrada = totalEntrada;
    }

    public Float getSaidaDinheiro() {
        return saidaDinheiro;
    }

    public void setSaidaDinheiro(Float saidaDinheiro) {
        this.saidaDinheiro = saidaDinheiro;
    }

    public Float getSaidaCheque() {
        return saidaCheque;
    }

    public void setSaidaCheque(Float saidaCheque) {
        this.saidaCheque = saidaCheque;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Float getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Float saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Collection<OperacaoCaixa> getOperacaoCaixaCollection() {
        return operacaoCaixaCollection;
    }

    public void setOperacaoCaixaCollection(Collection<OperacaoCaixa> operacaoCaixaCollection) {
        this.operacaoCaixaCollection = operacaoCaixaCollection;
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
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.Caixa[ id=" + id + " ]";
    }
    
}

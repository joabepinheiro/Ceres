/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private float valorTotalProdutos;
    private Float valorEntrega;
    private Float valorTotal;
    private Float totalPago;
    private Float troco;
    private String tipo;
    private String formaDePagamento;
    private String status;
    private Date abertoEm;
    private Date fechadoEm;
    private Endereco endereco;
    private Mesa mesa;
    private Cliente cliente;
    private Funcionario funcionario;
    private Collection<PedidoHasProduto> pedidoHasProdutoCollection;

    public Pedido() {
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Pedido(Long id, float valorTotalProdutos, String formaDePagamento) {
        this.id = id;
        this.valorTotalProdutos = valorTotalProdutos;
        this.formaDePagamento = formaDePagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(float valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    public Float getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(Float valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Float getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Float totalPago) {
        this.totalPago = totalPago;
    }

    public Float getTroco() {
        return troco;
    }

    public void setTroco(Float troco) {
        this.troco = troco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAbertoEm() {
        return abertoEm;
    }
    
    public java.sql.Date getSqlDateAbertoEm() {
        return new java.sql.Date(abertoEm.getTime());
    }

    public void setAbertoEm(Date abertoEm) {
        this.abertoEm = abertoEm;
    }

    public Date getFechadoEm() {
        return fechadoEm;
    }
    
    public java.sql.Date getSqlDateFechadoEm() {
        return new java.sql.Date(fechadoEm.getTime());
    }

    public void setFechadoEm(Date fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Collection<PedidoHasProduto> getPedidoHasProdutoCollection() {
        return pedidoHasProdutoCollection;
    }

    public void setPedidoHasProdutoCollection(Collection<PedidoHasProduto> pedidoHasProdutoCollection) {
        this.pedidoHasProdutoCollection = pedidoHasProdutoCollection;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.Pedido[ id=" + id + " ]";
    }
    
}

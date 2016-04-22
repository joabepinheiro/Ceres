/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.bean;

import java.io.Serializable;

public class PedidoHasProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    protected PedidoHasProdutoPK pedidoHasProdutoPK;
    private int quantidade;
    private String serializeProduto;
    private Produto produto;
    private Pedido pedido;

    public PedidoHasProduto() {
    }

    public PedidoHasProduto(PedidoHasProdutoPK pedidoHasProdutoPK) {
        this.pedidoHasProdutoPK = pedidoHasProdutoPK;
    }

    public PedidoHasProduto(PedidoHasProdutoPK pedidoHasProdutoPK, int quantidade, String serializeProduto) {
        this.pedidoHasProdutoPK = pedidoHasProdutoPK;
        this.quantidade = quantidade;
        this.serializeProduto = serializeProduto;
    }

    public PedidoHasProduto(long pedidoId, long produtoId) {
        this.pedidoHasProdutoPK = new PedidoHasProdutoPK(pedidoId, produtoId);
    }

    public PedidoHasProdutoPK getPedidoHasProdutoPK() {
        return pedidoHasProdutoPK;
    }

    public void setPedidoHasProdutoPK(PedidoHasProdutoPK pedidoHasProdutoPK) {
        this.pedidoHasProdutoPK = pedidoHasProdutoPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getSerializeProduto() {
        return serializeProduto;
    }

    public void setSerializeProduto(String serializeProduto) {
        this.serializeProduto = serializeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoHasProdutoPK != null ? pedidoHasProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoHasProduto)) {
            return false;
        }
        PedidoHasProduto other = (PedidoHasProduto) object;
        if ((this.pedidoHasProdutoPK == null && other.pedidoHasProdutoPK != null) || (this.pedidoHasProdutoPK != null && !this.pedidoHasProdutoPK.equals(other.pedidoHasProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.PedidoHasProduto[ pedidoHasProdutoPK=" + pedidoHasProdutoPK + " ]";
    }
    
}

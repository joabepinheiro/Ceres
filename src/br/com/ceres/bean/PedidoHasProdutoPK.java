package br.com.ceres.bean;
import java.io.Serializable;

public class PedidoHasProdutoPK implements Serializable {
    private long pedidoId;
    private long produtoId;

    public PedidoHasProdutoPK() {
    }

    public PedidoHasProdutoPK(long pedidoId, long produtoId) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
    }

    public long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedidoId;
        hash += (int) produtoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoHasProdutoPK)) {
            return false;
        }
        PedidoHasProdutoPK other = (PedidoHasProdutoPK) object;
        if (this.pedidoId != other.pedidoId) {
            return false;
        }
        if (this.produtoId != other.produtoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.PedidoHasProdutoPK[ pedidoId=" + pedidoId + ", produtoId=" + produtoId + " ]";
    }
    
}

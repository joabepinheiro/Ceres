package br.com.ceres.bean;

import java.io.Serializable;
import java.util.Collection;


public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer id;
    private String nome;
    private boolean ocupado;
    private Collection<Pedido> pedidoCollection;

    public Mesa() {
    }

    public Mesa(Integer id) {
        this.id = id;
    }

    public Mesa(Integer id, String nome, boolean ocupado) {
        this.id = id;
        this.nome = nome;
        this.ocupado = ocupado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
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
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.Mesa[ id=" + id + " ]";
    }
    
}

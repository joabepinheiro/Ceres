package br.com.ceres.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private float preco;
    private String descricao;
    private String codigo;
    private Date dataCadastro;
    private Date ultimaAtualizacao;
    private boolean ativo;
    private Collection<Fornecedor> fornecedorCollection;
    private Categoria categoria;
    private Funcionario funcionario;
    private Collection<PedidoHasProduto> pedidoHasProdutoCollection;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, String nome, float preco, Date dataCadastro, Date ultimaAtualizacao, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public Long getFuncionarioId() {
        return funcionario.getId();
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ceres.bean.Produto[ id=" + id + " ]";
    }
    
}

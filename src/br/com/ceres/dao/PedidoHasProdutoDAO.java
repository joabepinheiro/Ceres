package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.PedidoHasProduto;
import br.com.ceres.bean.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PedidoHasProdutoDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM pedido_has_produto WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM pedido_has_produto WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM pedido_has_produto ORDER BY id";
    private static final String INSERT = "INSERT INTO pedido_has_produto (pedido_id, produto_id, quantidade, serialize_produto) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pedido_has_produto SET pedido_id=?, produto_id=?, quantidade=?, serialize_produto=? WHERE id=?";
 
    public void inserir(PedidoHasProduto pedido_has_produto ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setObject(1, pedido_has_produto.getPedido().getId());
                ps.setObject(2, pedido_has_produto.getProduto().getId());
                ps.setInt(3, pedido_has_produto.getQuantidade());
                ps.setString(4, pedido_has_produto.getSerializeProduto());

                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(PedidoHasProduto pedido_has_produto){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setObject(1, pedido_has_produto.getPedido().getId());
                ps.setObject(2, pedido_has_produto.getProduto().getId());
                ps.setInt(3, pedido_has_produto.getQuantidade());
                ps.setString(4, pedido_has_produto.getSerializeProduto());
                
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<PedidoHasProduto> listar(){
        List<PedidoHasProduto> pedido_has_produtos = new ArrayList<>();

        try {
            ResultSet resultado;
            try (
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                resultado = ps.executeQuery();
                
                while (resultado.next()) {
                    PedidoHasProduto pedido_has_produto = new PedidoHasProduto();
                    pedido_has_produto.setPedido(new PedidoDAO().buscar(resultado.getLong("pedido_id")));
                    pedido_has_produto.setProduto(new ProdutoDAO().buscar(resultado.getLong("produto_id")));
                    pedido_has_produto.setQuantidade(resultado.getInt("quantidade"));
                    pedido_has_produto.setSerializeProduto(resultado.getString("serialize_produto"));
             
                    pedido_has_produtos.add(pedido_has_produto);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return pedido_has_produtos;
    }
    
     public PedidoHasProduto buscar(Long id){
        PedidoHasProduto pedido_has_produto = null;

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                resultado = ps.executeQuery();
                
                while (resultado.next()) {
                    pedido_has_produto.setPedido(new PedidoDAO().buscar(resultado.getLong("pedido_id")));
                    pedido_has_produto.setProduto(new ProdutoDAO().buscar(resultado.getLong("produto_id")));
                    pedido_has_produto.setQuantidade(resultado.getInt("quantidade"));
                    pedido_has_produto.setSerializeProduto(resultado.getString("serialize_produto"));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return pedido_has_produto;
    }
}

package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM produto WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM produto WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM produto ORDER BY id";
    private static final String AUTHENTICATE = "SELECT * FROM produto WHERE email=? AND senha= MD5(?)";
    private static final String INSERT = "INSERT INTO produto (nome, preco, descricao, codigo, ativo, funcionario_id, categoria_id) VALUES (?, ?, ?, ?, 1, ?, ?)";
    private static final String UPDATE = "UPDATE produto SET nome=?, preco=?, descricao=?, codigo=?, ativo=?, funcionario_id = ?,  categoria_id =? WHERE id=?";
 
    public void inserir(Produto produto ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, produto.getNome());
                ps.setFloat(2, produto.getPreco());
                ps.setString(3, produto.getDescricao());
                ps.setString(4, produto.getCodigo());
                ps.setObject(5, produto.getFuncionario().getId());
                ps.setObject(6, produto.getCategoria().getId());
                
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Produto produto){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, produto.getNome());
                ps.setFloat(2, produto.getPreco());
                ps.setString(3, produto.getDescricao());
                ps.setString(4, produto.getCodigo());
                ps.setObject(5, produto.getFuncionario());
                ps.setObject(6, produto.getCategoria());
                
                ps.executeUpdate();
            }
            System.out.println("Produto com id " + produto.getId() + " foi atualizado com sucesso: " + produto.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Produto> listar(){
        List<Produto> produtos = new ArrayList<>();

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                    PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    
                    Produto produto = new Produto();
                    
                    produto.setId(resultado.getLong("id"));
                    produto.setPreco(resultado.getFloat("preco"));
                    produto.setDescricao(resultado.getString("descricao"));
                    produto.setCodigo(resultado.getString("codigo"));
                    produto.setFuncionario(new FuncionarioDAO().buscar(resultado.getLong("funcionario_id")));
                    produto.setCategoria(new CategoriaDAO().buscar(resultado.getInt("categoria_id")));
                    
                    produtos.add(produto);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return produtos;
    }
    
}

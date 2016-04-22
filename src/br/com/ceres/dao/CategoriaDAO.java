package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM categoria WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM categoria WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM categoria ORDER BY id";
    private static final String INSERT = "INSERT INTO categoria (nome, pai) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE categoria SET nome=?, pai=? WHERE id=?";
 
    public void inserir(Categoria categoria ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, categoria.getNome());
                ps.setObject(2, categoria.getCategoria());
                
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Categoria categoria){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, categoria.getNome());
                ps.setObject(2, categoria.getCategoria());
                
                ps.executeUpdate();
            }
            System.out.println("Categoria com id " + categoria.getId() + " foi atualizado com sucesso: " + categoria.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Categoria> listar(){
        List<Categoria> categorias = new ArrayList<>();

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                    PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    
                    Categoria categoria = new Categoria();
                    
                    categoria.setId(resultado.getInt("id"));
                    categoria.setNome(resultado.getString("nome"));
                    categoria.setCategoria((Categoria) resultado.getObject("pai"));
                    
                    categorias.add(categoria);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return categorias;
    }
    
    public Categoria buscar(Integer id){
        Categoria categoria = null;

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setInt(1, id);
                
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    categoria = new Categoria();  
                    categoria.setId(resultado.getInt("id"));
                    categoria.setNome(resultado.getString("nome"));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return categoria;
    }
    
}

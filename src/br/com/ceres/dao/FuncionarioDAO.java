package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Produto;
import br.com.ceres.bean.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM funcionario WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM funcionario WHERE id=?";
    private static final String FIND_BY_USUARIO = "SELECT * FROM funcionario WHERE usuario_id=?";
    private static final String FIND_ALL = "SELECT * FROM funcionario ORDER BY id";
    private static final String AUTHENTICATE = "SELECT * FROM funcionario WHERE email=? AND senha= MD5(?)";
    private static final String INSERT = "INSERT INTO funcionario (nome, preco, descricao, codigo, ativo, funcionario_id, categoria_id) VALUES (?, ?, ?, ?, 1, ?, ?)";
    private static final String UPDATE = "UPDATE funcionario SET nome=?, preco=?, descricao=?, codigo=?, ativo=?, funcionario_id = ?,  categoria_id =? WHERE id=?";
 
    public void inserir(Produto funcionario ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, funcionario.getNome());
                ps.setFloat(2, funcionario.getPreco());
                ps.setString(3, funcionario.getDescricao());
                ps.setString(4, funcionario.getCodigo());
                ps.setObject(5, funcionario.getFuncionario());
                ps.setObject(6, funcionario.getCategoria());
                
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Produto funcionario){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, funcionario.getNome());
                ps.setFloat(2, funcionario.getPreco());
                ps.setString(3, funcionario.getDescricao());
                ps.setString(4, funcionario.getCodigo());
                ps.setObject(5, funcionario.getFuncionario());
                ps.setObject(6, funcionario.getCategoria());
                
                ps.executeUpdate();
            }
            System.out.println("Produto com id " + funcionario.getId() + " foi atualizado com sucesso: " + funcionario.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Produto> listar(){
        List<Produto> funcionarios = new ArrayList<>();

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    
                    Produto funcionario = new Produto();
                    
                    funcionario.setId(resultado.getLong("id"));
                    funcionario.setPreco(resultado.getFloat("usuario"));
                    funcionario.setDescricao(resultado.getString("email"));
                    funcionario.setCodigo(resultado.getString("senha"));
                    funcionario.setFuncionario((Funcionario) resultado.getObject("funcionario"));
                    funcionario.setCategoria((Categoria) resultado.getObject("categoria"));
                    
                    funcionarios.add(funcionario);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return funcionarios;
    }
    
    public Funcionario buscar(Long id){
        Funcionario funcionario = null;

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    funcionario = new Funcionario();  
                    funcionario.setId(resultado.getLong("id"));
                    funcionario.setNome(resultado.getString("nome"));
                    funcionario.setSobrenome(resultado.getString("sobrenome"));
                    funcionario.setTelefone1(resultado.getString("telefone1"));
                    funcionario.setTelefone2(resultado.getString("telefone2"));
                    funcionario.setTelefone3(resultado.getString("telefone3")); 
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return funcionario;
    }
    
    
    public Funcionario findByUsuario(Long id){
        Funcionario funcionario = null;

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_USUARIO)) {
                ps.setLong(1, id);
                
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    funcionario = new Funcionario();  
                    funcionario.setId(resultado.getLong("id"));
                    funcionario.setNome(resultado.getString("nome"));
                    funcionario.setSobrenome(resultado.getString("sobrenome"));
                    funcionario.setTelefone1(resultado.getString("telefone1"));
                    funcionario.setTelefone2(resultado.getString("telefone2"));
                    funcionario.setTelefone3(resultado.getString("telefone3")); 
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return funcionario;
   
    }
}

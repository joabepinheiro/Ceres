package br.com.ceres.dao;

import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Usuario;
import br.com.ceres.gui.Painel;
import br.com.ceres.sessao.Sessao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM usuario WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM usuario WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM usuario ORDER BY id";
    private static final String AUTHENTICATE = "SELECT * FROM usuario WHERE email=? AND senha= MD5(?)";
    private static final String INSERT = "INSERT INTO usuario (usuario, email, senha, ativo, tipo) VALUES (?, ?, MD5(?), ?, ?)";
    private static final String UPDATE = "UPDATE usuario SET usuario=?, email=?, senha=?, ativo=?, tipo=? WHERE id=?";
 
    public void inserir(Usuario usuario ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, usuario.getUsuario());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getAtivo());
                ps.setString(5, usuario.getTipo());
                
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Usuario usuario){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, usuario.getUsuario());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getSenha());
                ps.setString(4, usuario.getAtivo());
                ps.setString(5, usuario.getTipo());
                ps.setLong(6, usuario.getId());
                
                ps.executeUpdate();
            }
            System.out.println("Usuario com id " + usuario.getId() + " foi atualizado com sucesso: " + usuario.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> listar(){
        List<Usuario> usuarios = new ArrayList<>();

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {

                resultado = ps.executeQuery();
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    
                    usuario.setId(resultado.getLong("id"));
                    usuario.setUsuario(resultado.getString("usuario"));
                    usuario.setEmail(resultado.getString("email"));
                    usuario.setSenha(resultado.getString("senha"));
                    usuario.setAtivo(resultado.getString("ativo"));
                    usuario.setTipo(resultado.getString("tipo"));
                    
                    usuarios.add(usuario);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return usuarios;
    }
    
    public boolean autenticar(String email, String senha){
        Boolean result = false; 

        try {
 
            PreparedStatement ps = conexao.prepareStatement(AUTHENTICATE);
            ps.setString(1, email); 
            ps.setString(2, senha); 
 
            ResultSet resultado = ps.executeQuery();

            result = !(!resultado.next() && resultado.getRow() == 0);
            
            if(result == true){
                new Painel().setVisible(true);
                Sessao sessao = Sessao.getInstance();

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionario = funcionarioDAO.findByUsuario(resultado.getLong("id"));
                sessao.setFuncionario(funcionario);
               
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

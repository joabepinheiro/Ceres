package br.com.ceres.dao;

import br.com.ceres.bean.Endereco;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Usuario;
import br.com.ceres.gui.Painel;
import br.com.ceres.sessao.Sessao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EnderecoDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM endereco WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM endereco WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM endereco ORDER BY id";
    private static final String INSERT = "INSERT INTO endereco(logradouro, bairro, cidade, estado) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE endereco SET logradouro=?, bairro=?, cidade=?, estado=? WHERE id=?";
 
    public void inserir(Endereco endereco ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, endereco.getLogradouro());
                ps.setString(2, endereco.getBairro());
                ps.setString(3, endereco.getCidade());
                ps.setString(4, endereco.getEstado());

                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Endereco endereco){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, endereco.getLogradouro());
                ps.setString(2, endereco.getBairro());
                ps.setString(3, endereco.getCidade());
                ps.setString(4, endereco.getEstado());
                ps.setLong(5, endereco.getId());
                
                ps.executeUpdate();
            }
            System.out.println("Endereço com id " + endereco.getId() + " foi atualizado com sucesso: " + endereco.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Endereco> listar(){
        List<Endereco> enderecos = new ArrayList<>();

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {

                resultado = ps.executeQuery();
                while (resultado.next()) {
                    Endereco endereco = new Endereco();
                    
                    endereco.setId(resultado.getLong("id"));
                    endereco.setLogradouro(resultado.getString("logradouro"));
                    endereco.setBairro(resultado.getString("bairro"));
                    endereco.setCidade(resultado.getString("cidade"));
                    endereco.setEstado(resultado.getString("estado"));
                    
                    enderecos.add(endereco);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return enderecos;
    }
    
    public Endereco buscar(Long id){
        Endereco endereco = null;
        
        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    endereco = new Endereco();  
                    endereco.setId(resultado.getLong("id"));
                    endereco.setLogradouro(resultado.getString("logradouro"));
                    endereco.setBairro(resultado.getString("bairro"));
                    endereco.setCidade(resultado.getString("cidade"));
                    endereco.setEstado(resultado.getString("estado"));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }
    
}

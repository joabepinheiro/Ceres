package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Opcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OpcoesDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM opcoes WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM opcoes WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM opcoes ORDER BY id";
    private static final String INSERT = "INSERT INTO opcoes (chave, valor) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE opcoes SET chave=?, valor=?, WHERE id=?";
 
    public void inserir(Opcoes opcoes ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, opcoes.getChave());
                ps.setString(3, opcoes.getValor());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Opcoes opcao){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, opcao.getChave());
                ps.setString(3, opcao.getValor());
                ps.executeUpdate();
            }
            System.out.println("Opcoes com id " + opcao.getChave() + " foi atualizado com sucesso: " + opcao.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Opcoes> listar(){
        List<Opcoes> opcoes = new ArrayList<>();

        try {
            ResultSet resultado;
            try (
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    Opcoes opcao = new Opcoes();
                    opcao.setChave(resultado.getString("chave"));
                    opcao.setValor(resultado.getString("valor"));
                    opcoes.add(opcao);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return opcoes;
    }
    
     public Opcoes buscar(Long id){
        Opcoes opcao = null;

        try {
            ResultSet resultado;

            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                resultado = ps.executeQuery();
                
                while (resultado.next()) {
                    opcao = new Opcoes();  
                    ps.setString(1, opcao.getChave());
                    ps.setString(3, opcao.getValor());
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return opcao;
    }
}

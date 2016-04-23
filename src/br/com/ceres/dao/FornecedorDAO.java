package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FornecedorDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM fornecedor WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM fornecedor WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM fornecedor ORDER BY id";
    private static final String INSERT = "INSERT INTO fornecedor (razao_social, cpnj, nome_fantasia, responsavel, observacoes) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE fornecedor SET razao_social=?, cpnj=?, nome_fantasia=?, responsavel=?, observacoes=? WHERE id=?";
 
    public void inserir(Fornecedor fornecedor ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, fornecedor.getRazaoSocial());
                ps.setString(3, fornecedor.getCpnj());
                ps.setString(4, fornecedor.getNomeFantasia());
                ps.setString(5, fornecedor.getResponsavel());
                ps.setString(6, fornecedor.getObservacoes());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Fornecedor fornecedor){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, fornecedor.getRazaoSocial());
                ps.setString(3, fornecedor.getCpnj());
                ps.setString(4, fornecedor.getNomeFantasia());
                ps.setString(5, fornecedor.getResponsavel());
                ps.setString(6, fornecedor.getObservacoes());
                ps.executeUpdate();
            }
            System.out.println("Fornecedor com id " + fornecedor.getId() + " foi atualizado com sucesso: " + fornecedor.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Fornecedor> listar(){
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            ResultSet resultado;
            //executa
            try ( // prepared statement para inserção
                    PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                //executa
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    
                    Fornecedor fornecedor = new Fornecedor();
                    
                    fornecedor.setId(resultado.getLong("id"));
                    fornecedor.setRazaoSocial(resultado.getString("razao_social"));
                    fornecedor.setCpnj(resultado.getString("cpnj"));
                    fornecedor.setNomeFantasia(resultado.getString("nome_fantasia"));
                    fornecedor.setResponsavel(resultado.getString("responsavel"));
                    fornecedor.setObservacoes(resultado.getString("observacoes"));
                    
                    fornecedores.add(fornecedor);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return fornecedores;
    }
    
     public Fornecedor buscar(Long id){
        Fornecedor fornecedor = null;

        try {
            ResultSet resultado;

            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    fornecedor.setId(resultado.getLong("id"));
                    fornecedor.setRazaoSocial(resultado.getString("razao_social"));
                    fornecedor.setCpnj(resultado.getString("cpnj"));
                    fornecedor.setNomeFantasia(resultado.getString("nome_fantasia"));
                    fornecedor.setResponsavel(resultado.getString("responsavel"));
                    fornecedor.setObservacoes(resultado.getString("observacoes"));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return fornecedor;
    }
}

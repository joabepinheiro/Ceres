package br.com.ceres.dao;

import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Mesa;
import br.com.ceres.bean.Usuario;
import br.com.ceres.gui.Painel;
import br.com.ceres.sessao.Sessao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MesaDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM mesa WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM mesa WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM mesa ORDER BY id";
    private static final String INSERT = "INSERT INTO mesa (nome, ocupado) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE mesa SET nome=?, ocupado=? WHERE id=?";
 
    public void inserir(Mesa mesa ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, mesa.getNome());
                ps.setBoolean(2, mesa.getOcupado());
  
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Mesa mesa){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, mesa.getNome());
                ps.setBoolean(2, mesa.getOcupado());
                ps.setLong(3, mesa.getId());
                
                ps.executeUpdate();
            }
            System.out.println("Mesa com id " + mesa.getId() + " foi atualizado com sucesso: " + mesa.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Mesa> listar(){
        List<Mesa> mesas = new ArrayList<>();

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {

                resultado = ps.executeQuery();
                while (resultado.next()) {
                    Mesa mesa = new Mesa(); 
                    mesa.setId(resultado.getInt("id"));
                    mesa.setNome(resultado.getString("nome"));
                    mesa.setOcupado(resultado.getBoolean("ocupado"));
                    mesas.add(mesa);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mesas;
    }
    

    public Mesa buscar(int id){
        Mesa mesa = null;
        
        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    mesa = new Mesa();  
                    mesa.setId(resultado.getInt("id"));
                    mesa.setNome(resultado.getString("nome"));
                    mesa.setOcupado(resultado.getBoolean("ocupado"));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mesa;
    }
    
}

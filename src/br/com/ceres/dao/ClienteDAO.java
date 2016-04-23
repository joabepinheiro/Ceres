package br.com.ceres.dao;

import br.com.ceres.bean.Categoria;
import br.com.ceres.bean.Cliente;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Produto;
import br.com.ceres.bean.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ClienteDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM cliente WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM cliente WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM cliente ORDER BY id";
    private static final String INSERT = "INSERT INTO cliente (nome, sobrenome, cpf, rg, data_de_nascimento, observacoes, telefone1, telefone2, telefone3, usuario_id, endereco_id, endereco_complemento, endereco_referencia, endereco_numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE cliente SET nome=?, sobrenome=?, cpf=?, rg=?, data_de_nascimento=?, observacoes=?, telefone1=?, telefone2=?, telefone3=?, usuario_id=?, endereco_id=?, endereco_complemento=?, endereco_referencia=?, endereco_numero=? WHERE id=?";
 
    public void inserir(Cliente cliente ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getSobrenome());
                ps.setString(3, cliente.getCpf());
                ps.setString(4, cliente.getRg());
                ps.setDate(5, cliente.getSqlDateDataDeNascimento());
                ps.setString(6, cliente.getObservacoes());
                ps.setString(7, cliente.getTelefone1());
                ps.setString(8, cliente.getTelefone2());
                ps.setString(9, cliente.getTelefone1());
                ps.setObject(10, cliente.getUsuarioId().getId());
                ps.setObject(11, cliente.getEnderecoId().getId());
                
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Cliente cliente){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getSobrenome());
                ps.setString(3, cliente.getCpf());
                ps.setString(4, cliente.getRg());
                ps.setDate(5, cliente.getSqlDateDataDeNascimento());
                ps.setString(6, cliente.getObservacoes());
                ps.setString(7, cliente.getTelefone1());
                ps.setString(8, cliente.getTelefone2());
                ps.setString(9, cliente.getTelefone1());
                ps.setObject(10, cliente.getUsuarioId().getId());
                ps.setObject(11, cliente.getEnderecoId().getId());
                ps.setString(12, cliente.getEnderecoComplemento());
                ps.setString(13, cliente.getEnderecoReferencia());
                ps.setString(14, cliente.getEnderecoNumero());
                
                ps.executeUpdate();
            }
            System.out.println("Cliente com id " + cliente.getId() + " foi atualizado com sucesso: " + cliente.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Cliente> listar(){
        List<Cliente> clientes = new ArrayList<>();

        try {
            ResultSet resultado;
            try (
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {   
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    
                    Cliente cliente = new Cliente();
                   
                    cliente.setId(resultado.getLong("id"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setSobrenome(resultado.getString("sobrenome"));
                    cliente.setCpf(resultado.getString("cpf"));
                    cliente.setRg(resultado.getString("rg"));
                    cliente.setDataDeNascimento(resultado.getDate("data_de_nascimento"));
                    cliente.setObservacoes(resultado.getString("observacoes"));
                    cliente.setTelefone1(resultado.getString("telefone1"));
                    cliente.setTelefone2(resultado.getString("telefone2"));
                    cliente.setTelefone3(resultado.getString("telefone3"));
                    cliente.setUsuarioId(new UsuarioDAO().buscar(resultado.getLong("usuario_id")));
                    cliente.setEnderecoId(new EnderecoDAO().buscar(resultado.getLong("endereco_id")));
                    cliente.setEnderecoComplemento(resultado.getString("endereco_complemento"));
                    cliente.setEnderecoReferencia(resultado.getString("endereco_referencia"));
                    cliente.setEnderecoNumero(resultado.getString("endereco_numero"));
                    clientes.add(cliente);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return clientes;
    }
    
    public Cliente buscar(Long id){
        Cliente cliente = null;

        try {
            ResultSet resultado;
            try (
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    cliente = new Cliente();  
                    cliente.setId(resultado.getLong("id"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setSobrenome(resultado.getString("sobrenome"));
                    cliente.setCpf(resultado.getString("cpf"));
                    cliente.setRg(resultado.getString("rg"));
                    cliente.setDataDeNascimento(resultado.getDate("data_de_nascimento"));
                    cliente.setObservacoes(resultado.getString("observacoes"));
                    cliente.setTelefone1(resultado.getString("telefone1"));
                    cliente.setTelefone2(resultado.getString("telefone2"));
                    cliente.setTelefone3(resultado.getString("telefone3"));
                    cliente.setUsuarioId(new UsuarioDAO().buscar(resultado.getLong("usuario_id")));
                    cliente.setEnderecoId(new EnderecoDAO().buscar(resultado.getLong("endereco_id")));
                    cliente.setEnderecoComplemento(resultado.getString("endereco_complemento"));
                    cliente.setEnderecoReferencia(resultado.getString("endereco_referencia"));
                    cliente.setEnderecoNumero(resultado.getString("endereco_numero"));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return cliente;
    }
}

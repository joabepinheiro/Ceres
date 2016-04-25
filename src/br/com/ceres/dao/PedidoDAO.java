package br.com.ceres.dao;

import br.com.ceres.bean.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO extends AbstractDAO{
    
    private static final String DELETE      = "DELETE FROM pedido WHERE id=?";
    private static final String FIND_BY_ID  = "SELECT * FROM pedido WHERE id=?";
    private static final String FIND_ALL    = "SELECT * FROM pedido ORDER BY id";
    private static final String INSERT      = "INSERT INTO pedido (valor_total_produtos, valor_entrega, valor_total, total_pago, troco, tipo, forma_de_pagamento, status, funcionario_id, cliente_id, aberto_em, fechado_em, mesa_id, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE      = "UPDATE pedido SET valor_total_produtos=?, valor_entrega=?, valor_total=?, total_pago=?, troco=?, tipo=?, forma_de_pagamento=?, status=?, funcionario_id=?, cliente_id=?, aberto_em=?, fechado_em=?, mesa_id=?, endereco_id=? WHERE id=?";
 
    public Long inserir(Pedido pedido ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT,  Statement.RETURN_GENERATED_KEYS)) {
     
                ps.setFloat(1, pedido.getValorTotalProdutos());
                ps.setFloat(2, pedido.getValorEntrega());
                ps.setFloat(3, pedido.getValorTotal());
                ps.setFloat(4, pedido.getTotalPago());
                ps.setFloat(5, pedido.getTroco());
                ps.setString(6, pedido.getTipo());
                ps.setString(7, pedido.getFormaDePagamento());
                ps.setString(8, pedido.getStatus());
                ps.setObject(9, pedido.getFuncionario().getId());
                ps.setObject(10, pedido.getCliente());
                ps.setObject(11, pedido.getStringDateAbertoEm());
                ps.setObject(12, pedido.getStringDateFechadoEm());
                ps.setObject(13, pedido.getMesa());
                ps.setObject(14, pedido.getEndereco());
                
       
                // executa
                ps.executeUpdate();
                ResultSet resultSet = ps.getGeneratedKeys();
                int id = 0;

                if(resultSet.next()){
                    id = resultSet.getInt(1);
                }

                ps.close();

                return (long) id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Pedido pedido){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setFloat(1, pedido.getValorTotalProdutos());
                ps.setFloat(2, pedido.getValorEntrega());
                ps.setFloat(3, pedido.getValorTotal());
                ps.setFloat(4, pedido.getTotalPago());
                ps.setFloat(5, pedido.getTroco());
                ps.setString(6, pedido.getTipo());
                ps.setString(7, pedido.getFormaDePagamento());
                ps.setString(8, pedido.getStatus());
                ps.setObject(9, pedido.getFuncionario().getId());
                ps.setObject(10, pedido.getCliente());
                ps.setObject(11, pedido.getStringDateAbertoEm());
                ps.setObject(12, pedido.getStringDateFechadoEm());
                ps.setObject(13, pedido.getMesa());
                ps.setObject(14, pedido.getEndereco().getId());
                ps.setLong(15, pedido.getId());
                
                ps.executeUpdate();
            }
            System.out.println("pedido com id " + pedido.getId() + " foi atualizado com sucesso: " + pedido.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pedido> listar(){
        List<Pedido> pedidos = new ArrayList<>();

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                resultado = ps.executeQuery();
                
                while (resultado.next()) {
                    Pedido pedido = new Pedido();
                    
                    pedido.setId(resultado.getLong("id"));
                    pedido.setValorTotalProdutos(resultado.getFloat("valor_total_produtos"));
                    pedido.setValorEntrega(resultado.getFloat("valor_entrega"));
                    pedido.setValorTotal(resultado.getFloat("valor_total"));
                    pedido.setTotalPago(resultado.getFloat("total_pago"));
                    pedido.setTroco(resultado.getFloat("troco"));
                    pedido.setTipo(resultado.getString("tipo"));
                    pedido.setFormaDePagamento(resultado.getString("forma_de_pagamento"));
                    pedido.setStatus(resultado.getString("status"));
                    pedido.setFuncionario(new FuncionarioDAO().buscar(resultado.getLong("funcionario_id")));
                    pedido.setCliente(new ClienteDAO().buscar(resultado.getLong("cliente_id")));
                    pedido.setAbertoEm(resultado.getTimestamp("aberto_em"));
                    pedido.setFechadoEm(resultado.getTimestamp("fechado_em"));
                    pedido.setMesa(new MesaDAO().buscar(resultado.getInt("mesa_id")));
                    pedido.setEndereco(new EnderecoDAO().buscar(resultado.getLong("endereco_id")));
                     
                    pedidos.add(pedido);
                    
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return pedidos;
    }

    public Pedido buscar(Long id){
        Pedido pedido = null;

        try {
            ResultSet resultado;

            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    pedido = new Pedido();  

                    pedido.setId(resultado.getLong("id"));
                    pedido.setValorTotalProdutos(resultado.getFloat("valor_total_produtos"));
                    pedido.setValorEntrega(resultado.getFloat("valor_entrega"));
                    pedido.setValorTotal(resultado.getFloat("valor_total"));
                    pedido.setTotalPago(resultado.getFloat("total_pago"));
                    pedido.setTroco(resultado.getFloat("troco"));
                    pedido.setTipo(resultado.getString("tipo"));
                    pedido.setFormaDePagamento(resultado.getString("forma_de_pagamento"));
                    pedido.setStatus(resultado.getString("status"));
                    pedido.setFuncionario(new FuncionarioDAO().buscar(resultado.getLong("funcionario_id")));
                    pedido.setCliente(new ClienteDAO().buscar(resultado.getLong("cliente_id")));
                    pedido.setAbertoEm(resultado.getTimestamp("aberto_em"));
                    pedido.setFechadoEm(resultado.getTimestamp("fechado_em"));
                    pedido.setMesa(new MesaDAO().buscar(resultado.getInt("mesa_id")));
                    pedido.setEndereco(new EnderecoDAO().buscar(resultado.getLong("endereco_id")));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return pedido;
    }
    
    public void deletar(Long id){
          try {
            try ( 
                PreparedStatement ps = conexao.prepareStatement(DELETE)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
          }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

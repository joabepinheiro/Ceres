package br.com.ceres.dao;

import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.OperacaoCaixa;
import br.com.ceres.bean.Usuario;
import br.com.ceres.gui.Painel;
import br.com.ceres.sessao.Sessao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OperacaoCaixaDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM operacao_caixa WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM operacao_caixa WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM operacao_caixa ORDER BY id";
    private static final String INSERT = "INSERT INTO operacao_caixa (forma_pagamento, tipo_operacao, valor, observacao, caixa_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE operacao_caixa SET forma_pagamento=?, tipo_operacao=?, valor=?, observacao=?, caixa_id=? WHERE id=?";
 
    public void inserir(OperacaoCaixa operacaoCaixa ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setString(1, operacaoCaixa.getFormaPagamento());
                ps.setString(2, operacaoCaixa.getTipoOperacao());
                ps.setFloat(3, operacaoCaixa.getValor());
                ps.setString(4, operacaoCaixa.getObservacao());
                ps.setObject(5, operacaoCaixa.getCaixa().getId());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(OperacaoCaixa operacaoCaixa){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setString(1, operacaoCaixa.getFormaPagamento());
                ps.setString(2, operacaoCaixa.getTipoOperacao());
                ps.setFloat(3, operacaoCaixa.getValor());
                ps.setString(4, operacaoCaixa.getObservacao());
                ps.setObject(5, operacaoCaixa.getCaixa().getId());
                ps.setLong(6, operacaoCaixa.getId());
                
                ps.executeUpdate();
            }
            System.out.println("Operacao Caixa com id " + operacaoCaixa.getId() + " foi atualizado com sucesso: " + operacaoCaixa.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<OperacaoCaixa> listar(){
        List<OperacaoCaixa> operacao_caixas = new ArrayList<>();

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {

                resultado = ps.executeQuery();
                while (resultado.next()) {
                    OperacaoCaixa operacao_caixa = new OperacaoCaixa();
                    operacao_caixa.setId(resultado.getLong("id"));
                    operacao_caixa.setFormaPagamento(resultado.getString("forma_pagamento"));
                    operacao_caixa.setTipoOperacao(resultado.getString("tipo_operacao"));
                    operacao_caixa.setValor(resultado.getFloat("valor"));
                    operacao_caixa.setObservacao(resultado.getString("observacao"));
                    operacao_caixa.setCaixa(new CaixaDAO().buscar(resultado.getLong("caixa_id")));
                    operacao_caixas.add(operacao_caixa);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return operacao_caixas;
    }
   
    public OperacaoCaixa buscar(Long id){
        OperacaoCaixa operacao_caixa = null;
        try {
            ResultSet resultado;

            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    operacao_caixa = new OperacaoCaixa();  
                    operacao_caixa.setId(resultado.getLong("id"));
                    operacao_caixa.setFormaPagamento(resultado.getString("forma_pagamento"));
                    operacao_caixa.setTipoOperacao(resultado.getString("tipo_operacao"));
                    operacao_caixa.setValor(resultado.getFloat("valor"));
                    operacao_caixa.setObservacao(resultado.getString("observacao"));
                    operacao_caixa.setCaixa(new CaixaDAO().buscar(resultado.getLong("caixa_id")));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return operacao_caixa;
    }
    
}

package br.com.ceres.dao;

import br.com.ceres.bean.Caixa;
import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Usuario;
import br.com.ceres.gui.Painel;
import br.com.ceres.sessao.Sessao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CaixaDAO extends AbstractDAO{
    
    private static final String DELETE = "DELETE FROM caixa WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM caixa WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM caixa ORDER BY id";
    private static final String INSERT = "INSERT INTO caixa (aberto_em, fechado_em, entrada_dinheiro, entrada_cartao_debito, entrada_cartao_credito, entrada_cheque, total_entrada, saida_dinheiro, saida_cheque, saldo_inicial, saldo_final, observacao, funcionario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE caixa SET aberto_em=?, fechado_em=?, entrada_dinheiro=?, entrada_cartao_debito=?, entrada_cartao_credito=?, entrada_cheque=?, total_entrada=?, saida_dinheiro=?, saida_cheque=?, saldo_inicial=?, saldo_final=?, observacao=?, funcionario_id=? WHERE id=?";
 
    public void inserir(Caixa caixa ){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(INSERT)) {
                ps.setDate(1, new java.sql.Date(caixa.getAbertoEm().getTime()));
                ps.setDate(2, new java.sql.Date(caixa.getFechadoEm().getTime()));
                ps.setFloat(3, caixa.getEntradaDinheiro());
                ps.setFloat(4, caixa.getEntradaCartaoDebito());
                ps.setFloat(5, caixa.getEntradaCartaoCredito());
                ps.setFloat(6, caixa.getEntradaCheque());
                ps.setFloat(7, caixa.getTotalEntrada());
                ps.setFloat(8, caixa.getSaidaDinheiro());
                ps.setFloat(9, caixa.getSaidaCheque());
                ps.setFloat(10, caixa.getSaldoInicial());
                ps.setFloat(11, caixa.getSaldoFinal());
                ps.setString(12, caixa.getObservacao());
                ps.setObject(13, caixa.getFuncionario());
                
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void atualizar(Caixa caixa){
        try {
            try (PreparedStatement ps = conexao.prepareStatement(UPDATE)) {
                ps.setDate(1, new java.sql.Date(caixa.getAbertoEm().getTime()));
                ps.setDate(2, new java.sql.Date(caixa.getFechadoEm().getTime()));
                ps.setFloat(3, caixa.getEntradaDinheiro());
                ps.setFloat(4, caixa.getEntradaCartaoDebito());
                ps.setFloat(5, caixa.getEntradaCartaoCredito());
                ps.setFloat(6, caixa.getEntradaCheque());
                ps.setFloat(7, caixa.getTotalEntrada());
                ps.setFloat(8, caixa.getSaidaDinheiro());
                ps.setFloat(9, caixa.getSaidaCheque());
                ps.setFloat(10, caixa.getSaldoInicial());
                ps.setFloat(11, caixa.getSaldoFinal());
                ps.setString(12, caixa.getObservacao());
                ps.setObject(13, caixa.getFuncionario());
                
                ps.executeUpdate();
            }
            System.out.println("Caixa com id " + caixa.getId() + " foi atualizado com sucesso: " + caixa.toString());
 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Caixa> listar(){
        List<Caixa> caixas = new ArrayList<>();

        try {
            ResultSet resultado;
            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_ALL)) {
                resultado = ps.executeQuery();
                
                while (resultado.next()) {
                    Caixa caixa = new Caixa();
                    
                    caixa.setId(resultado.getLong("id"));
                    caixa.setAbertoEm(resultado.getDate("aberto_em"));
                    caixa.setFechadoEm(resultado.getDate("fechado_em"));
                    caixa.setEntradaDinheiro(resultado.getFloat("entrada_dinheiro"));
                    caixa.setEntradaCartaoDebito(resultado.getFloat("entrada_cartao_debito"));
                    caixa.setEntradaCartaoCredito(resultado.getFloat("entrada_cartao_credito"));
                    caixa.setEntradaCheque(resultado.getFloat("entrada_cheque"));
                    caixa.setTotalEntrada(resultado.getFloat("total_entrada"));
                    caixa.setSaidaDinheiro(resultado.getFloat("saida_dinheiro"));
                    caixa.setSaidaCheque(resultado.getFloat("saida_cheque"));
                    caixa.setSaldoInicial(resultado.getFloat("saldo_inicial"));
                    caixa.setSaldoFinal(resultado.getFloat("saldo_final"));
                    caixa.setObservacao(resultado.getString("observacao"));
                    caixa.setFuncionario(new FuncionarioDAO().buscar(resultado.getLong("funcionario_id")));
                    caixas.add(caixa);
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return caixas;
    }

    
    public Caixa buscar(Long id){
        Caixa caixa = null;

        try {
            ResultSet resultado;

            try ( 
                PreparedStatement ps = conexao.prepareStatement(FIND_BY_ID)) {
                ps.setLong(1, id);
                
                resultado = ps.executeQuery();
                while (resultado.next()) {
                    caixa = new Caixa();  

                    caixa.setId(resultado.getLong("id"));
                    caixa.setAbertoEm(resultado.getDate("aberto_em"));
                    caixa.setFechadoEm(resultado.getDate("fechado_em"));
                    caixa.setEntradaDinheiro(resultado.getFloat("entrada_dinheiro"));
                    caixa.setEntradaCartaoDebito(resultado.getFloat("entrada_cartao_debito"));
                    caixa.setEntradaCartaoCredito(resultado.getFloat("entrada_cartao_credito"));
                    caixa.setEntradaCheque(resultado.getFloat("entrada_cheque"));
                    caixa.setTotalEntrada(resultado.getFloat("total_entrada"));
                    caixa.setSaidaDinheiro(resultado.getFloat("saida_dinheiro"));
                    caixa.setSaidaCheque(resultado.getFloat("saida_cheque"));
                    caixa.setSaldoInicial(resultado.getFloat("saldo_inicial"));
                    caixa.setSaldoFinal(resultado.getFloat("saldo_final"));
                    caixa.setObservacao(resultado.getString("observacao"));
                    caixa.setFuncionario(new FuncionarioDAO().buscar(resultado.getLong("funcionario_id")));
                }
            }
            resultado.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return caixa;
    }
}

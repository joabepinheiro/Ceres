/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.dao;

import br.com.ceres.jdbc.Conexao;
import java.sql.Connection;

/**
 *
 * @author joabe_000
 */
public class AbstractDAO {
    
    protected Connection conexao;
    
    public AbstractDAO() {
        this.conexao = Conexao.getConexao();
    }
}

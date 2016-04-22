
package br.com.ceres.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(
            "jdbc:mysql://localhost/ceres", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

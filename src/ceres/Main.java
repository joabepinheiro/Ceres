/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceres;

import br.com.ceres.dao.UsuarioDAO;
import br.com.ceres.bean.Usuario;
import br.com.ceres.gui.Login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author joabe_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        /**
        
        Usuario usuario = new Usuario();
  
        usuario.setId(Long.valueOf(1));
        usuario.setEmail("joabepineheirhkkfkfkfgko@live.com");
        usuario.setUsuario("joabeepiheiro");
        usuario.setSenha("123456");
        usuario.setAtivo("1");
        usuario.setTipo("funcionario");
        
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
        **/
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    new Login().setVisible(true);
            }
        });
        
        
      
    }
    
}

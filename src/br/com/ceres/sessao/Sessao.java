/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.sessao;

import br.com.ceres.bean.Funcionario;
import br.com.ceres.bean.Usuario;

/**
 *
 * @author joabe_000
 */
public class Sessao{
   private static Sessao instance = null;
   private Funcionario funcionario;
   private Sessao(){
   }
   public void setFuncionario(Funcionario funcionario){
      this.funcionario = funcionario;
   }
   public Funcionario getFuncionario(){
       return funcionario;
   }
   public static Sessao getInstance(){
         if(instance == null){
               instance = new Sessao();
         }
        return instance;
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.util;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author joabe_000
 * 
 * NotEmpty
 */
public class Validador {

    private JComponent jComponent[];
    private JLabel jLabel[];
    private  String validadores[];
    private boolean formValido  = true;
    
    public Validador(JComponent jComponent[], JLabel  jLabel[], String validadores[] ) {
        this.jComponent = jComponent;
        this.jLabel = jLabel;
        this.validadores = validadores;
        
    }
    public boolean validar(){
        for (int i = 0; jComponent.length > i; i++) {
            if(validadores[i].contains("Empty")){
                this.Empty(jComponent[i], jLabel[i]);
            }
        }
        return formValido;
    }
    
  
    
    public void Empty(JComponent jComponent,  JLabel  jLabel ){
         if(jComponent instanceof JTextField){
            
             JTextField jTextField = (JTextField) jComponent;
            
            if(jTextField.getText().isEmpty()){
                jTextField.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel.setForeground (Color.red);
                jLabel.setText("Esse campo é obrigatório");
                formValido = false;
            }else{
                jTextField.setBorder(UIManager.getBorder("TextField.border"));
                jLabel.setText("");
            }
         }
         
         
          if(jComponent instanceof JComboBox){
            
             JComboBox jComboBox = (JComboBox) jComponent;

            if(jComboBox.getSelectedItem() == null){
                jComboBox.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel.setForeground (Color.red);
                jLabel.setText("Esse campo é obrigatório");
                formValido = false;
            }else{
                jComboBox.setBorder(null);
                jLabel.setText("");
            }
         }
          
          if(jComponent instanceof JList){
            
             JList jList = (JList) jComponent;

            if(jList.getSelectedValue() == null){
                jList.setBorder(BorderFactory.createLineBorder(Color.red));
                jLabel.setForeground (Color.red);
                jLabel.setText("Esse campo é obrigatório");
                formValido = false;
            }else{
                jList.setBorder(null);
                jLabel.setText("");
            }
         }
          
    }
    
    
}

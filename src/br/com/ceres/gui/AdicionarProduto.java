/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ceres.gui;

import br.com.ceres.bean.Pedido;
import br.com.ceres.bean.PedidoHasProduto;
import br.com.ceres.bean.Produto;
import br.com.ceres.dao.ProdutoDAO;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joabe_000
 */
public class AdicionarProduto extends javax.swing.JFrame {

    Pedido pedido;
    JTable tabelaPordutosDoPedido;
    JLabel jLabelValortotal;
    /**
     * Creates new form AdicionarProduto
     * @param jTable
     * @param pedido
     * @param jLabelValortotal
     */
    public AdicionarProduto(JTable jTable, Pedido pedido, JLabel jLabelValortotal) {
        initComponents();
        this.jLabelValortotal = jLabelValortotal;
        this.pedido = pedido;
        this.tabelaPordutosDoPedido = jTable;
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listar();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); 
        
        for (Produto produto : produtos) {
            Object[] linha = new Object[5];
            linha[0] = produto.getId();
            linha[1] = produto.getCodigo();
            linha[2] = produto.getCategoria();
            linha[3] = produto.getNome();
            linha[4] = produto.getPreco();
            model.addRow(linha);  
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCampoDeBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCampoDeBusca = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar produto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Categoria", "Produto", "Preço"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar");

        jTextFieldCampoDeBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCampoDeBuscaActionPerformed(evt);
            }
        });
        jTextFieldCampoDeBusca.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldCampoDeBuscaInputMethodTextChanged(evt);
            }
        });
        jTextFieldCampoDeBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCampoDeBuscaKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("por");

        jComboBoxCampoDeBusca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nome", "codigo", "preco" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCampoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCampoDeBusca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCampoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxCampoDeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCampoDeBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCampoDeBuscaActionPerformed

    }//GEN-LAST:event_jTextFieldCampoDeBuscaActionPerformed

    private void jTextFieldCampoDeBuscaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldCampoDeBuscaInputMethodTextChanged

    }//GEN-LAST:event_jTextFieldCampoDeBuscaInputMethodTextChanged

    private void jTextFieldCampoDeBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCampoDeBuscaKeyReleased
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.buscarPor(jComboBoxCampoDeBusca.getSelectedItem().toString(), jTextFieldCampoDeBusca.getText());
        System.out.println(produtos.size());

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Produto produto : produtos) {
            Object[] linha = new Object[5];
            linha[0] = produto.getId();
            linha[1] = produto.getCodigo();
            linha[2] = produto.getCategoria();
            linha[3] = produto.getNome();
            linha[4] = produto.getPreco();
            model.addRow(linha);
        }
    }//GEN-LAST:event_jTextFieldCampoDeBuscaKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          if(jTable1.getSelectedRow() != -1){
            Long id = (Long) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            Produto produto = new ProdutoDAO().buscar(id);
            new QuantidadeProdutoPedido(produto, pedido, this.tabelaPordutosDoPedido, jLabelValortotal ).setVisible(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxCampoDeBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCampoDeBusca;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telas;

import DAO.EmprestimoDAO;
import DAO.LivrosDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import collections.ConnectionMod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javabeans.Livros;
import javabeans.User;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javabeans.Emprestimos;
import javabeans.Reservas;

/**
 *
 * @author lgera
 */
public class Emprestimo extends javax.swing.JFrame {
    Connection conecta;
    ResultSet rs;
    PreparedStatement stmt;

    /** Creates new form Emprestimo */
    public void ListarL(){
        try {
            LivrosDAO dao = new LivrosDAO();
            List<Livros> listaU = dao.listarLivros();
            DefaultTableModel modelo = (DefaultTableModel)tabelaB.getModel();
            modelo.setNumRows(0);
            
            for(Livros v : listaU){
                modelo.addRow(new Object[]{
                v.getIdlivro(),
                v.getTitulo(),
                v.getAutor(),
                v.getEditora()
                });
            }
        } catch (Exception e) {
        }
    }
    
    public void ListarU(){
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<User> listaU = dao.listarUser();
            DefaultTableModel modelo = (DefaultTableModel)tabelaU.getModel();
            modelo.setNumRows(0);
            
            for(User v : listaU){
                modelo.addRow(new Object[]{
                v.getIduser(),
                v.getNome(),
                v.getCpf(),
                v.getTel()
                });
            }
        } catch (Exception e) {
        }
    }
    
    public void ListarE(){
        try {
            
            EmprestimoDAO dao = new EmprestimoDAO();
            List<Emprestimos> listaU = dao.listarEmprestimo();
            DefaultTableModel modelo = (DefaultTableModel)tabelaE.getModel();
            modelo.setNumRows(0);
            
            for(Emprestimos v : listaU){
                modelo.addRow(new Object[]{
                
                v.getIdemp(),
                v.getUser(),
                v.getCpf(),
                v.getTit(),
                v.getIdliv(),
                v.getDataEm(),
                v.getDataRet()
                });
            }
        } catch (Exception e) {
        }
    }
    
    
    public Emprestimo() {
        conecta = new ConnectionMod().conecta();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaE = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaB = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtDataEm = new com.toedter.calendar.JDateChooser();
        txtDataRet = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUs = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtTit = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaU = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtCod = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Área de empréstimo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("Código: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        tabelaE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID empréstimo", "Usuário", "CPF", "Titulo do livro", "Código", "Data de empréstimo", "Data de retorno"
            }
        ));
        tabelaE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaE);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 500, 92));

        tabelaB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Titulo", "Autor", "Editora"
            }
        ));
        tabelaB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaBMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaB);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 90));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Titulo: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));
        getContentPane().add(txtDataEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 130, -1));
        getContentPane().add(txtDataRet, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 130, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Data de empréstimo: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Data de retorno: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Usuário: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("CPF: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        txtUs.setEditable(false);
        txtUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsActionPerformed(evt);
            }
        });
        getContentPane().add(txtUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 120, -1));

        txtCpf.setEditable(false);
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 120, -1));

        jButton2.setText("EMPRESTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, -1, -1));

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 130, -1));

        txtTit.setEditable(false);
        getContentPane().add(txtTit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 130, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 550, 10));

        tabelaU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Usuário", "CPF", "Telefone"
            }
        ));
        tabelaU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaU);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 90));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("Tabela de usuários");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Tabela de livros");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jButton1.setText("EXCLUIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        txtCod.setEditable(false);
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        getContentPane().add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 130, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setText("ID: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ListarL();
        ListarU();
        ListarE();
    }//GEN-LAST:event_formWindowActivated

    private void tabelaBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaBMouseClicked
        txtID.setText(tabelaB.getValueAt(tabelaB.getSelectedRow(), 0).toString());
        txtTit.setText(tabelaB.getValueAt(tabelaB.getSelectedRow(), 1).toString());
        txtCod.setText(tabelaB.getValueAt(tabelaB.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tabelaBMouseClicked

    private void tabelaUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUMouseClicked
        txtUs.setText(tabelaU.getValueAt(tabelaU.getSelectedRow(), 1).toString());
        txtCpf.setText(tabelaU.getValueAt(tabelaU.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tabelaUMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String cmdsql = "insert into emprestimo(user,cpf,titulo,idliv,dataEm,dataRet) values(?,?,?,?,?,?)";
        
        try {
            
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, txtUs.getText());
            stmt.setString(2, txtCpf.getText());
            stmt.setString(3, txtTit.getText());
            stmt.setInt(4, Integer.parseInt(txtID.getText()));
            stmt.setString(5, ((JTextField)txtDataEm.getDateEditor().getUiComponent()).getText());
            stmt.setString(6, ((JTextField)txtDataRet.getDateEditor().getUiComponent()).getText());
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "emprestado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro no empréstimo " +e);
        }
        ListarE();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEMouseClicked
        txtID.setText(tabelaE.getValueAt(tabelaE.getSelectedRow(), 0).toString());
        txtUs.setText(tabelaE.getValueAt(tabelaE.getSelectedRow(), 1).toString());
        txtCpf.setText(tabelaE.getValueAt(tabelaE.getSelectedRow(), 2).toString());
        txtTit.setText(tabelaE.getValueAt(tabelaE.getSelectedRow(), 3).toString());
        txtCod.setText(tabelaE.getValueAt(tabelaE.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tabelaEMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Emprestimos obj = new Emprestimos();
            
            obj.setIdemp(Integer.parseInt(txtID.getText()));

            EmprestimoDAO dao = new EmprestimoDAO();
            dao.excluirEmprestimo(obj);

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            ListarE();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "falha" + e); 
        }
        limpar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

        public void limpar(){
        txtID.setText("");
        txtCod.setText("");
        txtCpf.setText("");
        txtTit.setText("");
        txtUs.setText("");
        txtDataEm.requestFocus();   
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabelaB;
    private javax.swing.JTable tabelaE;
    private javax.swing.JTable tabelaU;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCpf;
    private com.toedter.calendar.JDateChooser txtDataEm;
    private com.toedter.calendar.JDateChooser txtDataRet;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTit;
    private javax.swing.JTextField txtUs;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.interfaces.medico;

import triagemeletronica.conexao.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import triagemeletronica.modelos.Medico;
import triagemeletronica.modelos.Validar;

/**
 *
 * @author Fabricio Sousa
 */
public class Tela_Medico_Alterar_Dados extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    ResultSet rs = null;
    Medico medico = new Medico();
    /**
     * Creates new form Tela_Agenda_Adicionar
     */
    public Tela_Medico_Alterar_Dados() {
        initComponents();
        conexao = Conexao.getConnection();
    }
        
        public void alterar_dados_Medico(Medico medico) throws Exception{
       
        String sql2 = "update Usuarios set nome=?,login=?,senha=? where id=?";
      
        Validar validar = new Validar();
        boolean nomeValido = validar.checkName(medico.getNome());
        boolean camposNulos = validar.camposNulosAlterarMed(medico);
        boolean senhaValida = validar.checkSenha(medico.getSenha());
        
        try {
            pst = conexao.prepareStatement(sql2);
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getCrm());
            pst.setString(3, medico.getSenha());
            pst.setInt(4, medico.getId());

            if (nomeValido == true && camposNulos == true && senhaValida == true) {
                int add = pst.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Dados de usuário do médico cadastrados com sucesso!");
            } else {
                throw new Exception();
            }

        } catch (SQLException e) {
            
        }catch (Exception ex){
            //JOptionPane.showMessageDialog(null, ex);
            throw ex;
        }
        
    }
        
    public Medico buscaMedico(Medico medico){
         String sql = "select * from Usuarios where login = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, medico.getCrm());
            rs = pst.executeQuery();
            if(rs.next()){
                medico.setNome(rs.getString("Nome"));
                medico.setCrm(rs.getString("login"));
                medico.setSenha(rs.getString("senha"));
                medico.setPerfil(rs.getString("perfil"));
            }
        } catch (SQLException ex) {
        
        }
         
         return medico;
     }
        
    private void pesquisar() {

        String sql = "select  *from Usuarios where login =? And Id=?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtBuscarMed.getText());
            pst.setString(2, Tela_Do_Medico.txtNumID.getText());
            rs = pst.executeQuery();
            
            if (rs.next()){     
                txtNomeMed.setText(rs.getString(2));
                txtLoginMed.setText(rs.getString(3));
                txtSenhaMed.setText(rs.getString(4));
 
            }
//            tblContatos.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
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

        jLabel7 = new javax.swing.JLabel();
        txtBuscarMed = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNomeMed = new javax.swing.JTextField();
        txtLoginMed = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSenhaMed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Opções do Enfermeiro");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Digite o CRM: ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triagemeletronica/icones/deletar.png"))); // NOI18N
        jButton2.setToolTipText("Cancelar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("*Nome: ");

        txtNomeMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMedActionPerformed(evt);
            }
        });

        txtLoginMed.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("*Senha: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("*Login");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triagemeletronica/icones/alterar.png"))); // NOI18N
        jButton1.setToolTipText("Alterar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("* Campos Obrigatórios");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triagemeletronica/icones/pesquisar 2.0.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(585, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscarMed, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLoginMed, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSenhaMed, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLoginMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSenhaMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        setBounds(0, 0, 840, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtNomeMed.setText(null);
        txtLoginMed.setText(null);
        txtSenhaMed.setText(null);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNomeMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeMedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        medico.setId(Integer.parseInt(Tela_Do_Medico.txtNumID.getText()));
        medico.setNome(txtNomeMed.getText());
        medico.setCrm(txtLoginMed.getText());
        medico.setSenha(txtSenhaMed.getText());
        
        Validar validar = new Validar();
        boolean nomeValido = validar.checkName(medico.getNome());
        boolean camposNulos = validar.camposNulosAlterarMed(medico);
        boolean senhaValida = validar.checkSenha(medico.getSenha());
        
        if (nomeValido == true && camposNulos == true && senhaValida == true) {
            try {
                int confirma = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Alterar os Dados do Usuario ", "Atenção", JOptionPane.YES_NO_OPTION);

                if (confirma == JOptionPane.YES_OPTION) {
                    alterar_dados_Medico(medico);
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(Tela_Medico_Alterar_Dados.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            pesquisar();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBuscarMed;
    private javax.swing.JTextField txtLoginMed;
    private javax.swing.JTextField txtNomeMed;
    private javax.swing.JTextField txtSenhaMed;
    // End of variables declaration//GEN-END:variables

    private void adicionando() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

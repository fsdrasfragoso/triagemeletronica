/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.interfaces.administrador;

import triagemeletronica.conexao.Conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import triagemeletronica.modelos.Enfermeiro;
import triagemeletronica.modelos.Validar;

/**
 *
 * @author Márcio Sousa
 */
public class Tela_Administrador_Alterar_Enfermeiro extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    ResultSet rs = null;
    Enfermeiro enfermeiro = new Enfermeiro();

    /**
     * Creates new form Tela_Agenda_Adicionar
     */
    public Tela_Administrador_Alterar_Enfermeiro() {
        initComponents();
        conexao = Conexao.getConnection();
    }
        
        public void alterar_endereco(Enfermeiro enfermeiro) throws Exception{
       
        String sql2 = "update Enfermeiro set Telefone_Fixo=?,Telefone_Celular=?,Endereco=? where id=?";

        
         
        
            Validar validar = new Validar();
            boolean nulosEnd = validar.camposNulosEnfEnd(enfermeiro);
            boolean fone10Digitos = validar.checkFone_FixoEnf10DigitosOuNulo(enfermeiro.getFone_fixo());
            boolean fone_fixoValido = validar.checkFone_FixoEnf_valido(enfermeiro.getFone_fixo());
            boolean celular11Digitos = validar.checkCelularEnf11Digitos(enfermeiro.getFone_celular());
            boolean celularValido = validar.checkCelularEnf_valido(enfermeiro.getFone_celular());
        
            try {
            
                pst2 = conexao.prepareStatement(sql2);
                pst2.setString(1, enfermeiro.getFone_fixo());
                pst2.setString(2, enfermeiro.getFone_celular());
                pst2.setString(3, enfermeiro.getEndereco()); 
                pst2.setInt(4, enfermeiro.getId());
            
                if(nulosEnd == true && fone10Digitos == true && fone_fixoValido == false && celular11Digitos == true && celularValido == false){
                    pst2.executeUpdate();
                    //JOptionPane.showMessageDialog(null, "Dados do enfermeiro alterados com sucesso!"); 
            
                }else{
                    throw new Exception();
                }
            
            
            
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }catch (Exception ex){
                //JOptionPane.showMessageDialog(null, ex);
                throw ex;
            }
        
    }
        
    public Enfermeiro buscaEndEnfermeiro(Enfermeiro enfermeiro){
         String sql = "select * from Enfermeiro where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, enfermeiro.getId());
            rs = pst.executeQuery();
            if(rs.next()){
                enfermeiro.setFone_fixo(rs.getString("TELEFONE_FIXO"));
                enfermeiro.setFone_celular(rs.getString("TELEFONE_CELULAR"));
                enfermeiro.setEndereco(rs.getString("ENDERECO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Administrador_Adicionar_Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return enfermeiro;
     }
        
    private void pesquisar() {

        String sql = "select  u.id, u.nome, u.login, u.senha,e.TELEFONE_FIXO,e.TELEFONE_CELULAR,e.ENDERECO\n"
                + "from Usuarios as u"
                + " inner join Enfermeiro as e on u.id = e.id where login =?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtBuscarEnf.getText());

            rs = pst.executeQuery();
            
            if (rs.next()){
                txtNumIDEnf.setText(rs.getString(1));
                txtNomeEnf.setText(rs.getString(2));
                txtCorenEnf.setText(rs.getString(3));
                txtSenhaEnf.setText(rs.getString(4));
                txtEndEnf.setText(rs.getString(7));
                txtTelFixEnf.setText(rs.getString(5));
                txtTelCelEnf1.setText(rs.getString(6));
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
        txtBuscarEnf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTelCelEnf1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomeEnf = new javax.swing.JTextField();
        txtCorenEnf = new javax.swing.JTextField();
        txtEndEnf = new javax.swing.JTextField();
        txtTelFixEnf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSenhaEnf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNumIDEnf = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Enfermeiro");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Digite o Coren do Enfermeiro: ");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("*Endereço: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Fixo: ");

        txtNomeEnf.setEnabled(false);
        txtNomeEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeEnfActionPerformed(evt);
            }
        });

        txtCorenEnf.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("*Senha: ");

        txtSenhaEnf.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("*Coren: ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triagemeletronica/icones/alterar.png"))); // NOI18N
        jButton1.setToolTipText("Alterar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("*Celular: ");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(txtBuscarEnf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)))
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTelFixEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtTelCelEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNumIDEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtEndEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSenhaEnf, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                            .addComponent(txtCorenEnf))
                                        .addComponent(txtNomeEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorenEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSenhaEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelFixEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelCelEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumIDEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        txtNumIDEnf.setVisible(false);

        setBounds(0, 0, 840, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtNomeEnf.setText(null);
        txtCorenEnf.setText(null);
        txtSenhaEnf.setText(null);
        txtTelFixEnf.setText(null);
        txtTelCelEnf1.setText(null);
        txtEndEnf.setText(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNomeEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeEnfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        enfermeiro.setId(Integer.parseInt(txtNumIDEnf.getText()));
        enfermeiro.setFone_fixo(txtTelFixEnf.getText());
        enfermeiro.setFone_celular(txtTelCelEnf1.getText());
        enfermeiro.setEndereco(txtEndEnf.getText());
        
        Validar validar = new Validar();
        boolean nulosEnd = validar.camposNulosEnfEnd(enfermeiro);
        boolean fone10Digitos = validar.checkFone_FixoEnf10DigitosOuNulo(txtTelFixEnf.getText());
        boolean fone_fixoValido = validar.checkFone_FixoEnf_valido(txtTelFixEnf.getText());
        boolean celular11Digitos = validar.checkCelularEnf11Digitos(txtTelCelEnf1.getText());
        boolean celularValido = validar.checkCelularEnf_valido(txtTelCelEnf1.getText());
        
        if(nulosEnd == true && fone10Digitos == true && fone_fixoValido == false && celular11Digitos == true && celularValido == false) {
            try {
                int confirma = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Alterar esse Contato", "Atenção", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    alterar_endereco(enfermeiro);
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                }        
            } catch (Exception ex) {
                Logger.getLogger(Tela_Administrador_Adicionar_Enfermeiro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados");
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBuscarEnf;
    private javax.swing.JTextField txtCorenEnf;
    private javax.swing.JTextField txtEndEnf;
    private javax.swing.JTextField txtNomeEnf;
    public static javax.swing.JTextField txtNumIDEnf;
    private javax.swing.JTextField txtSenhaEnf;
    private javax.swing.JTextField txtTelCelEnf1;
    private javax.swing.JTextField txtTelFixEnf;
    // End of variables declaration//GEN-END:variables

    private void adicionando() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

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
import static triagemeletronica.interfaces.administrador.Tela_Administrador_Adicionar_Enfermeiro.txtNumIDEnf;
import triagemeletronica.modelos.Medico;
import triagemeletronica.modelos.Validar;

/**
 *
 * @author Esdras Fragoso
 */
public class Tela_Administrador_Adicionar_Medico extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    PreparedStatement pst4 = null;
    ResultSet rs = null;
    Medico medico = new Medico();
    
    /**
     * Creates new form Tela_Agenda_Adicionar
     */
    public Tela_Administrador_Adicionar_Medico() {
        initComponents();
        conexao = Conexao.getConnection();
    }
    
   public void adicionar_usuario(Medico medico) throws Exception{
        
       String sql = "insert into Usuarios(nome,login,senha,perfil) values (?,?,?,?)";
        
       Validar validar = new Validar();
        boolean nomeValido = validar.checkName(medico.getNome());
        boolean crmValido = validar.checkCRM(medico.getCrm());
        boolean camposNulos = validar.camposNulosMed(medico);
        boolean senhaValida = validar.checkSenha(medico.getSenha());
        boolean perfil = validar.checkPerfilMed(medico.getPerfil());
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getCrm());
            pst.setString(3, medico.getSenha());
            pst.setString(4, medico.getPerfil());

            if (nomeValido == true && crmValido == false && camposNulos == true && senhaValida == true && perfil == true) {
                int add = pst.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Dados de usuário do médico cadastrados com sucesso!");
            } else {
                throw new Exception();
            }

        } catch (SQLException e) {
            throw new Exception();
        }catch (Exception ex){
            //JOptionPane.showMessageDialog(null, ex);
            throw ex;
        }
    }
       
       
       private void adicionando () throws SQLException, Exception{
           adicionar_usuario(medico);
           pesquisar();
       }
       
       public void pesquisar () throws SQLException, Exception{
           
           String sql3 = "select *from Usuarios where login=?";
           
         //   pst = conexao.prepareStatement(sql);
            
            pst3 = conexao.prepareStatement(sql3);
            pst3.setString(1,medico.getCrm());
            rs=pst3.executeQuery();
            
            if (rs.next()){
                txtNumIDMed.setText(rs.getString(1));
                medico.setId(rs.getInt(1));
            }
            
            if(txtNumIDMed.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar as Informações");
            }else{
                adicionar_endereco(medico);
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
            Logger.getLogger(Tela_Administrador_Adicionar_Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return medico;
     }
       
     public Medico buscaEndMedico(Medico medico){
         String sql = "select * from Medico where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, medico.getId());
            rs = pst.executeQuery();
            if(rs.next()){
                medico.setFone_fixo(rs.getString("TELEFONE_FIXO"));
                medico.setFone_celular(rs.getString("TELEFONE_CELULAR"));
                medico.setEndereco(rs.getString("ENDERECO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Administrador_Adicionar_Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return medico;
     }
     
      public void adicionar_endereco(Medico medico) throws Exception {
        
        String sql2 = "insert into Medico(ID,Telefone_Fixo,Telefone_Celular,Endereco) values (?,?,?,?)";
        
        Validar validar = new Validar();
        boolean nulos = validar.camposNulosMedEnd(medico);
        boolean fone_fixo10Digitos = validar.checkFone_FixoMed10DigitosOuNulo(medico.getFone_fixo());
        boolean fone_fixoValido = validar.checkFone_FixoMed_valido(medico.getFone_fixo());
        boolean celular11Digitos = validar.checkCelularMed11Digitos(medico.getFone_celular());
        boolean celularValido = validar.checkCelularMed_valido(medico.getFone_celular());
        
        try {
            
            pst2 = conexao.prepareStatement(sql2);
            pst2.setInt(1, medico.getId());
            pst2.setString(2, medico.getFone_fixo());
            pst2.setString(3, medico.getFone_celular());
            pst2.setString(4, medico.getEndereco());        
                
            if(nulos == true && fone_fixoValido == false && fone_fixo10Digitos == true && celular11Digitos == true && celularValido == false){
                pst2.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Dados de endereço e telefone do médico cadastrados com sucesso!"); 
            
            }else{
                deletando_usuario();
                throw new Exception();
            }
            

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }catch (Exception ex){
            //JOptionPane.showMessageDialog(null, ex);
            throw ex;
        }
        
      }    
      
    public void deletando_usuario (){
               
        String sql = "delete from Usuarios where login=?";
                
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, medico.getCrm());
                int del = pst.executeUpdate();
                                          
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null,e);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeMed = new javax.swing.JTextField();
        txtCrmMed = new javax.swing.JTextField();
        txtEndMed = new javax.swing.JTextField();
        txtTelFixMed = new javax.swing.JTextField();
        txtTelCelMed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenhaMed = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtPerfilMed = new javax.swing.JTextField();
        txtNumIDMed = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar Medico");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("*Endereço: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText(" Fixo: ");

        txtNomeMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("*Crm: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("*Senha: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("*Celular: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("*Nome: ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triagemeletronica/icones/adicionar.png"))); // NOI18N
        jButton1.setToolTipText("Cadastrar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/triagemeletronica/icones/deletar.png"))); // NOI18N
        jButton2.setToolTipText("Cancelar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPerfilMed.setText("Medico");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtSenhaMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                            .addComponent(txtCrmMed, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 232, Short.MAX_VALUE))
                                    .addComponent(txtNomeMed)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTelFixMed)
                                            .addComponent(txtTelCelMed, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPerfilMed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEndMed, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(txtNumIDMed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(149, 149, 149))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCrmMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSenhaMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelFixMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTelCelMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPerfilMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumIDMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        txtPerfilMed.setVisible(false);
        txtNumIDMed.setVisible(false);

        setBounds(0, 0, 840, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeMedActionPerformed

    private void txtNumIDEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumIDEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumIDEnfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        medico.setNome(txtNomeMed.getText());
        medico.setCrm(txtCrmMed.getText());
        medico.setSenha(txtSenhaMed.getText());
        medico.setPerfil(txtPerfilMed.getText());
        medico.setEndereco(txtEndMed.getText());
        medico.setFone_fixo(txtTelFixMed.getText());
        medico.setFone_celular(txtTelCelMed.getText());
        
        Validar validar = new Validar();
        boolean nomeValido = validar.checkName(txtNomeMed.getText());
        boolean crmValido = validar.checkCRM(txtCrmMed.getText());
        boolean camposNulos = validar.camposNulosMed(medico);
        boolean senhaValida = validar.checkSenha(txtSenhaMed.getText());
        boolean perfil = validar.checkPerfilMed(txtPerfilMed.getText());
        boolean nulos = validar.camposNulosMedEnd(medico);
        boolean fone_fixo10Digitos = validar.checkFone_FixoMed10DigitosOuNulo(medico.getFone_fixo());
        boolean fone_fixoValido = validar.checkFone_FixoMed_valido(medico.getFone_fixo());
        boolean celular11Digitos = validar.checkCelularMed11Digitos(medico.getFone_celular());
        boolean celularValido = validar.checkCelularMed_valido(medico.getFone_celular());
        
        if (nomeValido == true && crmValido == false && camposNulos == true && senhaValida == true && perfil == true && nulos == true && fone_fixoValido == false && fone_fixo10Digitos == true && celular11Digitos == true && celularValido == false) {
            try {
                adicionando();
                JOptionPane.showMessageDialog(null, "Dados do médico cadastrados com sucesso!");
            }catch (Exception ex) {
                Logger.getLogger(Tela_Administrador_Adicionar_Medico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Dados inválidos!");
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                    txtNomeMed.setText(null);
                    txtCrmMed.setText(null);
                    txtSenhaMed.setText(null);
                    txtTelFixMed.setText(null);
                    txtTelCelMed.setText(null);
                    txtEndMed.setText(null);
                    txtNumIDMed.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCrmMed;
    private javax.swing.JTextField txtEndMed;
    private javax.swing.JTextField txtNomeMed;
    public static javax.swing.JTextField txtNumIDMed;
    public static javax.swing.JTextField txtPerfilMed;
    private javax.swing.JTextField txtSenhaMed;
    private javax.swing.JTextField txtTelCelMed;
    private javax.swing.JTextField txtTelFixMed;
    // End of variables declaration//GEN-END:variables
}

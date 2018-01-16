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
import triagemeletronica.interfaces.administrador.Tela_Administrador_Adicionar_Medico;
import triagemeletronica.modelos.Enfermeiro;
import triagemeletronica.modelos.Validar;

/**
 *
 * @author Fabricio Sousa
 */
public class Tela_Administrador_Adicionar_Enfermeiro extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    PreparedStatement pst3 = null;
    ResultSet rs = null;
    Enfermeiro enfermeiro = new Enfermeiro();

    /**
     * Creates new form Tela_Agenda_Adicionar
     */
    public Tela_Administrador_Adicionar_Enfermeiro() {
        initComponents();
        conexao = Conexao.getConnection();
    }
    
       public void adicionar_usuario(Enfermeiro enfermeiro) throws Exception{
        
           String sql = "insert into Usuarios(nome,login,senha,perfil) values (?,?,?,?)";
        
            Validar validar = new Validar();
            boolean nomeValido = validar.checkName(enfermeiro.getNome());
            boolean corenValido = validar.checkCoren(enfermeiro.getCoren());
            boolean perfilValido = validar.checkPerfilEnf(enfermeiro.getPerfil());
            boolean senhaValida = validar.checkSenha(enfermeiro.getSenha());
            boolean nulos = validar.camposNulosEnf(enfermeiro);
        
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, enfermeiro.getNome());
                pst.setString(2, enfermeiro.getCoren());
                pst.setString(3, enfermeiro.getSenha());
                pst.setString(4, enfermeiro.getPerfil());

                if(nulos == true && nomeValido == false && perfilValido == true && senhaValida == true && corenValido == false){
                    int add = pst.executeUpdate();
                    //JOptionPane.showMessageDialog(null, "Dados de usuário do enfermeiro cadastrados com sucesso!");
                }else{
                    throw new Exception();
                }    
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            } catch (Exception ex){
                //JOptionPane.showMessageDialog(null, ex);
                throw ex;
            }
    }
       
       
       private void adicionando () throws SQLException, Exception{
           adicionar_usuario(enfermeiro);
           pesquisar();
       }
       
       public Enfermeiro buscaEnfermeiro(Enfermeiro enfermeiro){
         String sql = "select * from Usuarios where login = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, enfermeiro.getCoren());
            rs = pst.executeQuery();
            if(rs.next()){
                enfermeiro.setNome(rs.getString("Nome"));
                enfermeiro.setCoren(rs.getString("login"));
                enfermeiro.setSenha(rs.getString("senha"));
                enfermeiro.setPerfil(rs.getString("perfil"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Administrador_Adicionar_Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return enfermeiro;
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
       
       private void pesquisar () throws SQLException, Exception{
           
           String sql3 = "select *from Usuarios where login=?";
          
         //   pst = conexao.prepareStatement(sql);
            
            pst3 = conexao.prepareStatement(sql3);
            pst3.setString(1,enfermeiro.getCoren());
            rs=pst3.executeQuery();
            
            if (rs.next()){
                txtNumIDEnf.setText(rs.getString(1));
                enfermeiro.setId(rs.getInt(1));
            }
            
            if(txtNumIDEnf.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar as Informações");
                
            }else{
                adicionar_endereco(enfermeiro);
            }
       }

       public void adicionar_endereco(Enfermeiro enfermeiro) throws Exception{
       
            String sql2 = "insert into Enfermeiro(ID,Telefone_Fixo,Telefone_Celular,Endereco) values (?,?,?,?)";
        
            Validar validar = new Validar();
            boolean nulos = validar.camposNulosEnfEnd(enfermeiro);
            boolean fone10Digitos = validar.checkFone_FixoEnf10DigitosOuNulo(enfermeiro.getFone_fixo());
            boolean celular11Digitos = validar.checkCelularEnf11Digitos(enfermeiro.getFone_celular());
        
            try {
            
                pst2 = conexao.prepareStatement(sql2);
                pst2.setInt(1, enfermeiro.getId());
                pst2.setString(2, enfermeiro.getFone_fixo());
                pst2.setString(3, enfermeiro.getFone_celular());
                pst2.setString(4, enfermeiro.getEndereco());        
            
                if(nulos == true && fone10Digitos == true && celular11Digitos == true){
                    pst2.executeUpdate();
                    //JOptionPane.showMessageDialog(null, "Dados de endereço e telefone do enfermeiro cadastrados com sucesso!"); 
            
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
       
           private void deletando_usuario (){
               String sql = "delete from Usuarios where login=?";
                
                try {
                     pst = conexao.prepareStatement(sql);
                     pst.setString(1, txtCorenEnf.getText());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeEnf = new javax.swing.JTextField();
        txtCorenEnf = new javax.swing.JTextField();
        txtEndEnf = new javax.swing.JTextField();
        txtTelFixEnf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSenhaEnf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTelCelEnf1 = new javax.swing.JTextField();
        txtPerfilEnf = new javax.swing.JTextField();
        txtNumIDEnf = new javax.swing.JTextField();

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar Enfermeiro");
        setPreferredSize(new java.awt.Dimension(840, 744));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("*Coren: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("*Celular: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("*Nome: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("*Endereço: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Fixo: ");

        txtNomeEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeEnfActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("*Senha: ");

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
        jButton2.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setText("* Campos Obrigatórios");

        txtPerfilEnf.setText("Enfermeiro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSenhaEnf, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(txtCorenEnf))
                                .addGap(383, 383, 383))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNomeEnf)
                                .addGap(151, 151, 151))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelCelEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                        .addComponent(txtPerfilEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelFixEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtEndEnf))))
                        .addGap(36, 36, 36)
                        .addComponent(txtNumIDEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTelCelEnf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPerfilEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumIDEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        txtPerfilEnf.setVisible(false);
        txtNumIDEnf.setVisible(false);

        setBounds(0, 0, 840, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeEnfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        enfermeiro.setNome(txtNomeEnf.getText());
        enfermeiro.setCoren(txtCorenEnf.getText());
        enfermeiro.setSenha(txtSenhaEnf.getText());
        enfermeiro.setPerfil(txtPerfilEnf.getText());
        enfermeiro.setFone_fixo(txtTelFixEnf.getText());
        enfermeiro.setFone_celular(txtTelCelEnf1.getText());
        enfermeiro.setEndereco(txtEndEnf.getText());
        
        try {
            adicionando();
        } catch (Exception ex) {
            Logger.getLogger(Tela_Administrador_Adicionar_Enfermeiro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtNomeEnf.setText(null);
        txtCorenEnf.setText(null);
        txtSenhaEnf.setText(null);  
        txtTelFixEnf.setText(null);
        txtTelCelEnf1.setText(null);
        txtEndEnf.setText(null);
        txtNumIDEnf.setText(null);
        // TODO add your handling code here:
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCorenEnf;
    private javax.swing.JTextField txtEndEnf;
    private javax.swing.JTextField txtNomeEnf;
    public static javax.swing.JTextField txtNumIDEnf;
    public static javax.swing.JTextField txtPerfilEnf;
    private javax.swing.JTextField txtSenhaEnf;
    private javax.swing.JTextField txtTelCelEnf1;
    private javax.swing.JTextField txtTelFixEnf;
    // End of variables declaration//GEN-END:variables
}

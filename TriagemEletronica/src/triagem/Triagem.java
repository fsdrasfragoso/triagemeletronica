/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.BindingGroup;
import triagemeletronica.array.ArrayPacientes;
import triagemeletronica.conexao.Conexao;
import triagemeletronica.paciente.Paciente;

/**
 *
 * @author Esdras Fragoso
 */
public class Triagem  extends JFrame{
    public javax.swing.JTextField Sistole;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField diastola;

    
    private javax.swing.JToggleButton jBVerificar;
    private javax.swing.JButton jButtonTriagem;
    private javax.swing.JCheckBox jCheckBoxAlergia;
    private javax.swing.JCheckBox jCheckBoxDores;
    private javax.swing.JComboBox<String> jComboBoxBairro;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JComboBox<String> jComboBoxCor;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JComboBox<String> jComboBoxMotivoDaVienda;
    private javax.swing.JComboBox<String> jComboBoxProcedencia;
    private javax.swing.JComboBox<String> jComboBoxRegiao;
    private javax.swing.JComboBox<String> jComboBoxRua;
    private javax.swing.JComboBox<String> jComboBoxZona;
    private javax.swing.JLabel jLBairro;
    private javax.swing.JLabel jLCEP;
    private javax.swing.JLabel jLCartaoSUS;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLQual;
    private javax.swing.JLabel jLRG;
    private javax.swing.JLabel jLZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCEP;
    public javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFQual;
    private javax.swing.JTextField jTFRG;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldProcedencia;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldTemperatura;
    private javax.swing.JTextField jTextNumeroCartaoSUS;
    private javax.swing.JTextPane jTextPaneMotivoDaVinda;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jLabelVomitou;
    private javax.swing.JLabel jLabelDiarreia;
    private javax.swing.JLabel jLabelVezesVomitou;
    private javax.swing.JTextField jTextFieldVomitou;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldDefecou;
    private javax.swing.JCheckBox jCheckBoxVomito;
    private javax.swing.JCheckBox jCheckBoxDedecou;
    private javax.swing.JLabel jLabelDefecou;
    private javax.swing.JLabel jLabelAltura; 
    private javax.swing.JCheckBox jCheckBoxSangrando;
    private javax.swing.JCheckBox jCheckBoxTrauma;
    private javax.swing.JLabel jLabelSangrando;
    private javax.swing.JLabel jLabelTrauma;
    private javax.swing.JCheckBox jCheckBoxMedicamento;
    private javax.swing.JComboBox<String> jComboBoxSEXO;
    private javax.swing.JLabel jLabelMedicacao;
    private javax.swing.JLabel jLabelMedicamento;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JTextArea jTextAreaMedicamento;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jLPESO;
    private javax.swing.JTextField jTPESO;
    public  ArrayPacientes a = new ArrayPacientes();
    private boolean tria; 

    public boolean getTria() {
        return tria;
    }

    public void setTria(boolean tria) {
        this.tria = tria;
    }
    


public Triagem() {
     
      //  Connection conexao = Conexao.getConnection();
        BindingGroup bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
       
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLCartaoSUS = new javax.swing.JLabel();
        jTextNumeroCartaoSUS = new javax.swing.JTextField();
        jBVerificar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jLEndereco = new javax.swing.JLabel();
        jLBairro = new javax.swing.JLabel();
        jTFBairro = new javax.swing.JTextField();
        jLCEP = new javax.swing.JLabel();
        jTFCEP = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLCidade = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jLRG = new javax.swing.JLabel();
        jTFRG = new javax.swing.JTextField();
        jLZona = new javax.swing.JLabel();
        jComboBoxZona = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxAlergia = new javax.swing.JCheckBox();
        jLQual = new javax.swing.JLabel();
        jTFQual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldProcedencia = new javax.swing.JTextField();
        jComboBoxProcedencia = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxMotivoDaVienda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTemperatura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBoxDores = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Sistole = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        diastola = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneMotivoDaVinda = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxCor = new javax.swing.JComboBox<>();
        jButtonTriagem = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxRegiao = new javax.swing.JComboBox<>();
        jComboBoxBairro = new javax.swing.JComboBox<>();
        jComboBoxRua = new javax.swing.JComboBox<>();
        jTextFieldRua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField(); 
        jTextFieldDefecou = new javax.swing.JTextField();
        jCheckBoxDedecou = new javax.swing.JCheckBox();
        jTextFieldAltura = new javax.swing.JTextField();
        jLabelVomitou = new javax.swing.JLabel();
        jCheckBoxVomito = new javax.swing.JCheckBox();
        jLabelVezesVomitou = new javax.swing.JLabel();
        jTextFieldVomitou = new javax.swing.JTextField();
        jLabelDiarreia = new javax.swing.JLabel();
        jCheckBoxDedecou = new javax.swing.JCheckBox();
        jLabelDefecou = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel(); 
        jLabelSangrando = new javax.swing.JLabel();
        jCheckBoxSangrando = new javax.swing.JCheckBox();
        jLabelTrauma = new javax.swing.JLabel();
        jCheckBoxTrauma = new javax.swing.JCheckBox();
        jLabelSexo = new javax.swing.JLabel();
        jComboBoxSEXO = new javax.swing.JComboBox<>();
        jLabelMedicacao = new javax.swing.JLabel();
        jCheckBoxMedicamento = new javax.swing.JCheckBox();
        jLabelMedicamento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMedicamento = new javax.swing.JTextArea();
         jLPESO = new javax.swing.JLabel();
        jTPESO = new javax.swing.JTextField();
        
        
        
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLCartaoSUS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLCartaoSUS.setText("Informe o numero do cartão do SUS:");

        jBVerificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBVerificar.setText("Verificar");

        
        
        
        
        
            jButtonTriagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getTria()){
                   // System.err.println("adiciona");
        
          setTria(false);          
        
        if(!jTextNumeroCartaoSUS.getText().trim().equals("")){  
        if(!jTextFieldProcedencia.getText().trim().equals("") && !jTextPaneMotivoDaVinda.getText().trim().equals("")){
            try {
                atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else    
        if(jTextFieldProcedencia.getText().trim().equals("") ) {
        if(jTextPaneMotivoDaVinda.getText().trim().equals("")){
                     
        
            try {
                atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), proce((String)jComboBoxProcedencia.getSelectedItem()), motivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), proce((String)jComboBoxProcedencia.getSelectedItem()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
            }
  
        }
        }else{
            try {
                atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), motivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        }else{
            JOptionPane.showMessageDialog(null, "Informe o Numero do Cartão do SUS");
        }
        }else{
         
            if(!jTextNumeroCartaoSUS.getText().trim().equals("")){  
               if(!jTFNome.getText().trim().equals("")){
                if(!jTFCEP.getText().trim().equals("")){
                 if(!jTFRG.getText().trim().equals("")){
                  if(!jTPESO.getText().trim().equals("")){
                   if(!jTextFieldAltura.getText().trim().equals("")){
                    if(!jTextFieldNumero.getText().trim().equals("")){
   if(!jTextFieldProcedencia.getText().trim().equals("") && !jTextPaneMotivoDaVinda.getText().trim().equals("")){
     if(jTextFieldRua.getText().trim().equals("")){
      if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }   
     }else{
       
         if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }
         
         
         
         
     }                
   }else if(jTextFieldProcedencia.getText().trim().equals("") && jTextPaneMotivoDaVinda.getText().trim().equals("")){
       if(jTextFieldRua.getText().trim().equals("")){
      if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), idProce((String)jComboBoxProcedencia.getSelectedItem()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), idProce((String)jComboBoxProcedencia.getSelectedItem()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }   
     }else{
       
         if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), idProce((String)jComboBoxProcedencia.getSelectedItem()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }
         
         
         
         
     }
       
   }else if(!jTextFieldProcedencia.getText().trim().equals("") && jTextPaneMotivoDaVinda.getText().trim().equals("")){
       if(jTextFieldRua.getText().trim().equals("")){
      if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }   
     }else{
       
         if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }
         
         
         
         
     }
       
       
   }else{
      
       
       
         if(jTextFieldRua.getText().trim().equals("")){
      if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua((String)jComboBoxRua.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }   
     }else{
       
         if(jTFBairro.getText().equals("")){
          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro((String)jComboBoxBairro.getSelectedItem(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
              
              // atualiza(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(), (String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), cadMotivo(jTextPaneMotivoDaVinda.getText()), jTextNumeroCartaoSUS.getText());
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{

          try {
              cadastrar(jTFNome.getText(),(String)jComboBoxSEXO.getSelectedItem(), jTFRG.getText(), jTextFieldAltura.getText(), jTPESO.getText(),(String)jComboBoxZona.getSelectedItem(), jTFCEP.getText(), jTextFieldNumero.getText(), cadProce(jTextFieldProcedencia.getText()), idMotivo((String)jComboBoxMotivoDaVienda.getSelectedItem()), jTextNumeroCartaoSUS.getText(), id_rua_has_bairro(idBairro(jTFBairro.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(),UfEstado((String)jComboBoxEstado.getSelectedItem()))), idRua(jTextFieldRua.getText(), idMunicipio((String)jComboBoxCidade.getSelectedItem(), UfEstado((String)jComboBoxEstado.getSelectedItem())))));
          } catch (SQLException ex) {
              Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
          }

          
      }
         
         
         
         
     }
       
       
       
       
       
       
       
       
   }                              
                    }else{
                        JOptionPane.showMessageDialog(null, "Informe o numero da residencia do paciente. Caso a residencia dela não tenha numero preencha com 0");
                    }   
                   }else{
                       JOptionPane.showMessageDialog(null, "Informe a altura do paciente. Cuidado Lembre-se que o Sistema considera , o . na notação dos numeros decimais");
                   }   
                  }else{
                     JOptionPane.showMessageDialog(null, "Informe o peso do paciente"); 
                  }   
                 }else{
                     JOptionPane.showMessageDialog(null, "Informe o numero do RG do paceinte");
                 }   
                }else{
                    JOptionPane.showMessageDialog(null, "Informe o numero do CEP do Paciente");
                }   
               }else{
                   JOptionPane.showMessageDialog(null, "Informe o Nome completo do paciente");
               }              
                }else{
                     JOptionPane.showMessageDialog(null, "Informe o numero do cartão do SUS");
                }
                    
                
        
                }
                
             }
        });
        
        
        
        
         jBVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        
        String sql = "SELECT * FROM `paciente` WHERE cartao_sus='"+jTextNumeroCartaoSUS.getText()+"'";
        System.err.println(jTextNumeroCartaoSUS.getText());
        try {
             Conexao c = new Conexao();
       Connection con = c.getConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(sql);
            String sus = jTextNumeroCartaoSUS.getText(); 
           
            if(rs.next()!=false){
       
                setTria(true);
                
        jComboBoxSEXO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSEXO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMININO" }));

        jLabelMedicacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMedicacao.setText("O Paciente  esta tomando alguma medicação: ");

        jCheckBoxMedicamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxMedicamento.setText("SIM");

        jLabelMedicamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMedicamento.setText("Caso a Resposta seja sim, informa quais abaixo:");

        jTextAreaMedicamento.setColumns(20);
        jTextAreaMedicamento.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMedicamento);

                
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jLEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLEndereco.setText("Rua:");

        jLBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLBairro.setText("Bairro");

        jLPESO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPESO.setText("Informe o Peso do Paciente");

        jLCEP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCEP.setText("CEP:");

        jlEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlEstado.setText("Estado");

       
        jLCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCidade.setText("Cidade");


        jLRG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLRG.setText("RG");

      
        jLZona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLZona.setText("Zona:");

        jComboBoxZona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "URBANA", "RURAL" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("O paciente tem diabetes:");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1.setText("SIM");

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton2.setText("NÂO");
        

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Alergia a algum medicamento?");

        jCheckBoxAlergia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAlergia.setText("SIM");

        jLQual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLQual.setText("Qual:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Procedencia:");

        jTextFieldProcedencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jComboBoxProcedencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProcedencia.setModel(new javax.swing.DefaultComboBoxModel<>(Procedencia()));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Motivo da Vinda:");

        jComboBoxMotivoDaVienda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMotivoDaVienda.setModel(new javax.swing.DefaultComboBoxModel<>(motivo_da_vinda()));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Temperatura:");

       
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Paciente esta com fortes dores?");

        jCheckBoxDores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDores.setText("SIM");
        

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Resultado do teste de clicemia:");

       

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Resultado da pressão sístole:");

        

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Resultado da pressão diastóla:");

        jScrollPane1.setViewportView(jTextPaneMotivoDaVinda);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Selecione a cor:");

        jComboBoxCor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vermelho", "Laranja", "Amarelo", "Verde", "Azual" }));

        jButtonTriagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonTriagem.setText("Realizar Triagem");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Região:");

        jComboBoxRegiao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegiao.setModel(new javax.swing.DefaultComboBoxModel<>(Regiao()));

        jComboBoxBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jComboBoxRua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Nº:");
           
        jTFNome.setText(rs.getString("nome"));
        jTFCEP.setText(rs.getString("cep"));
        jTFRG.setText(rs.getString("rg"));
        jTPESO.setText(rs.getString("Peso"));
        jTextFieldAltura.setText(rs.getString("Altura"));
        jTextFieldNumero.setText(rs.getString("numero"));
        
        jTextFieldRua.setText(Rua_has_bairro(rs.getString("rua_has_bairro_id"), 1));
        jTFBairro.setText(Rua_has_bairro(rs.getString("rua_has_bairro_id"), 0));
        jComboBoxEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        
        
        jLabelAltura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAltura.setText("Informe a Altura do Paciente:");

        jTextFieldAltura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabelVomitou.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelVomitou.setText("O paciente Vomitou:");

        jCheckBoxVomito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxVomito.setText("SIM");

        jLabelVezesVomitou.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelVezesVomitou.setText("informe ao lado quantas vezes o paciente vomitou: ");

        jLabelDiarreia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDiarreia.setText("O paciente esta com diarreia:");

        jCheckBoxDedecou.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDedecou.setText("SIM");

        jLabelDefecou.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDefecou.setText(" Informe quantas vezes o paciente defecou:");
                      
        jLabelSangrando.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSangrando.setText("O Paciente esta sangrando");

        jCheckBoxSangrando.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxSangrando.setText("SIM");

        jLabelTrauma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTrauma.setText("O Paciente tem trauma?");

        jCheckBoxTrauma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxTrauma.setText("SIM");
        jLabelSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSexo.setText("Sexo:");         
        
        
            stmt.close();
            rs.close();
            
            }else{
                setTria(false);
             jButtonTriagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
             jButtonTriagem.setText("Realizar Triagem");    
        jComboBoxSEXO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSEXO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMININO" }));

        jLabelMedicacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMedicacao.setText("O Paciente  esta tomando alguma medicação: ");

        jCheckBoxMedicamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxMedicamento.setText("SIM");

        jLabelMedicamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMedicamento.setText("Caso a Resposta seja sim, informa quais abaixo:");

        jTextAreaMedicamento.setColumns(20);
        jTextAreaMedicamento.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMedicamento);

        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jLEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLEndereco.setText("Rua:");

        jLBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLBairro.setText("Bairro");

        jLPESO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLPESO.setText("Informe o Peso do Paciente");
        
        

        jLCEP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCEP.setText("CEP:");

        jlEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlEstado.setText("Estado");

       
        jLCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCidade.setText("Cidade");


        jLRG.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLRG.setText("RG");

      
        jLZona.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLZona.setText("Zona:");

        jComboBoxZona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "URBANA", "RURAL" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("O paciente tem diabetes:");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1.setText("SIM");

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton2.setText("NÂO");
        

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Alergia a algum medicamento?");

        jCheckBoxAlergia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBoxAlergia.setText("SIM");

        jLQual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLQual.setText("Qual:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Procedencia:");

        jTextFieldProcedencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jComboBoxProcedencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxProcedencia.setModel(new javax.swing.DefaultComboBoxModel<>(Procedencia()));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Motivo da Vinda:");

        jComboBoxMotivoDaVienda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxMotivoDaVienda.setModel(new javax.swing.DefaultComboBoxModel<>(motivo_da_vinda()));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Temperatura:");

       
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Paciente esta com fortes dores?");

        jCheckBoxDores.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDores.setText("SIM");
        

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Resultado do teste de clicemia:");

       

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Resultado da pressão sístole:");

        

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Resultado da pressão diastóla:");

        jScrollPane1.setViewportView(jTextPaneMotivoDaVinda);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Selecione a cor:");

        jComboBoxCor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vermelho", "Laranja", "Amarelo", "Verde", "Azual" }));

        jButtonTriagem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonTriagem.setText("Realizar Triagem");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Região:");

        jComboBoxRegiao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegiao.setModel(new javax.swing.DefaultComboBoxModel<>(Regiao()));

        jComboBoxBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jComboBoxRua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Nº:");
           
        jTFNome.setText("");
        jTFCEP.setText("");
        jTFRG.setText("");
        
        jTextFieldNumero.setText("");
        
        jTextAreaMedicamento.setText("");
        jTextFieldVomitou.setText("");
        jTFQual.setText("");
        jTextFieldRua.setText("");
        jTFBairro.setText("");
        jTextField4.setText("");
        jTextFieldRua.setText("");
        jTextFieldAltura.setText("");
        jTextFieldDefecou.setText("");
        jTextFieldProcedencia.setText("");
        jTextPaneMotivoDaVinda.setText("");
        
        jComboBoxEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        
        
        jLabelAltura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAltura.setText("Informe a Altura do Paciente:");

        jTextFieldAltura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabelVomitou.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelVomitou.setText("O paciente Vomitou:");

        jCheckBoxVomito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxVomito.setText("SIM");

        jLabelVezesVomitou.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelVezesVomitou.setText("informe ao lado quantas vezes o paciente vomitou: ");

        jLabelDiarreia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDiarreia.setText("O paciente esta com diarreia:");

        jCheckBoxDedecou.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxDedecou.setText("SIM");

        jLabelDefecou.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDefecou.setText(" Informe quantas vezes o paciente defecou:");
                      
        jLabelSangrando.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSangrando.setText("O Paciente esta sangrando");

        jCheckBoxSangrando.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxSangrando.setText("SIM");

        jLabelTrauma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTrauma.setText("O Paciente tem trauma?");

        jCheckBoxTrauma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBoxTrauma.setText("SIM");
        
        jLabelSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSexo.setText("Sexo:");
                
            }      
        
        } catch (SQLException ex) {
            Logger.getLogger(triagemeletronica.paciente.Triagem.class.getName()).log(Level.SEVERE, null, ex);
        
        }
                   
            }
        });
        
         jComboBoxEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noem = (String) jComboBoxEstado.getSelectedItem(); 
                 Conexao c = new Conexao();
       Connection con = c.getConnection();
            String sql = "SELECT Uf FROM `estado` WHERE Nome='"+noem+"';"; 
            PreparedStatement stmt;
                try {
                    stmt = con.prepareStatement(sql);
               
            ResultSet rs = stmt.executeQuery(sql);
            String sus = jTextNumeroCartaoSUS.getText(); 
           
            if(rs.next()!=false){
                            
                
        jComboBoxCidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCidade.setModel(new javax.swing.DefaultComboBoxModel<>(Cidade((String)rs.getString("Uf"))));
            }
            
            
             } catch (SQLException ex) {
                    Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
         jComboBoxRegiao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noem = (String) jComboBoxRegiao.getSelectedItem(); 
                 Conexao c = new Conexao();
       Connection con = c.getConnection();
            String sql = "SELECT id FROM `regiao` WHERE Nome='"+noem+"';"; 
            PreparedStatement stmt;
                try {
                    stmt = con.prepareStatement(sql);
               
            ResultSet rs = stmt.executeQuery(sql);
            String sus = jTextNumeroCartaoSUS.getText(); 
           
            if(rs.next()!=false){
                            
                
        jComboBoxEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(Estado((String)rs.getString("Id"))));
            }
            
            
             } catch (SQLException ex) {
                    Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
         
        jComboBoxCidade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noem = (String) jComboBoxCidade.getSelectedItem(); 
                 Conexao c = new Conexao();
       Connection con = c.getConnection();
            String sql = "SELECT Id FROM `municipio` WHERE Nome='"+noem+"'; "; 
            PreparedStatement stmt;
                try {
                    stmt = con.prepareStatement(sql);
               
            ResultSet rs = stmt.executeQuery(sql);
            
           
            if(rs.next()!=false){
                            
              //  System.err.println(rs.getString("Id"));    
        jComboBoxRua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRua.setModel(new javax.swing.DefaultComboBoxModel<>(Rua((String)rs.getString("Id"))));
        jComboBoxBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBairro.setModel(new javax.swing.DefaultComboBoxModel<>(Bairro((String)rs.getString("Id"))));
        
            }
            
            
             } catch (SQLException ex) {
                    Logger.getLogger(Triagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
        
             javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLBairro)
                                    .addComponent(jLRG))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(jLZona)
                                        .addGap(10, 10, 10)
                                        .addComponent(jComboBoxZona, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBoxBairro, 0, 232, Short.MAX_VALUE)
                                            .addComponent(jTFRG))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumero))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLCidade)
                                    .addComponent(jLEndereco))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxRua, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldRua)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMotivoDaVienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBoxAlergia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLQual))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldProcedencia)
                                    .addComponent(jTFQual)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAltura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLPESO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTPESO))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonTriagem)
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel9)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Sistole, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(diastola, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelSangrando)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBoxSangrando)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelTrauma)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jCheckBoxTrauma))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelMedicacao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckBoxMedicamento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelMedicamento)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBoxDores)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelSexo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxSEXO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDiarreia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxDedecou)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDefecou)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDefecou))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelVomitou)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBoxVomito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelVezesVomitou)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVomitou)))
                        .addGap(95, 95, 95))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLCartaoSUS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextNumeroCartaoSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBVerificar)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCartaoSUS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextNumeroCartaoSUS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVerificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEstado)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCidade)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCEP)
                    .addComponent(jTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLEndereco)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBairro)
                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRG)
                    .addComponent(jTFRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLZona)
                    .addComponent(jComboBoxZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBoxAlergia)
                    .addComponent(jLQual)
                    .addComponent(jTFQual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxMotivoDaVienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAltura)
                    .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPESO)
                    .addComponent(jTPESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVomitou)
                    .addComponent(jCheckBoxVomito)
                    .addComponent(jLabelVezesVomitou)
                    .addComponent(jTextFieldVomitou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDiarreia)
                    .addComponent(jCheckBoxDedecou)
                    .addComponent(jLabelDefecou)
                    .addComponent(jTextFieldDefecou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSangrando)
                    .addComponent(jCheckBoxSangrando)
                    .addComponent(jLabelTrauma)
                    .addComponent(jCheckBoxTrauma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBoxDores)
                    .addComponent(jLabelSexo)
                    .addComponent(jComboBoxSEXO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Sistole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(diastola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMedicacao)
                    .addComponent(jCheckBoxMedicamento)
                    .addComponent(jLabelMedicamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTriagem))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        
        bindingGroup.bind();
         pack();
        setVisible(true);
        this.setResizable(false);
    }// </editor-fold>      



 public static String [] Regiao() throws SQLException{
       String sql = "SELECT Nome FROM `regiao`";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
       String[] r = new  String[5]; 
      // rs.last();
      // int totalOfRecords = rs.getRow();
      // rs.beforeFirst();
      // System.err.println(totalOfRecords);
      
      int i =0;
       while (rs.next()) {            
                r[i] = rs.getString("Nome");
                i++;

        }
        
        return r; 
    }

 
 public static String [] Procedencia() throws SQLException{
       String sql = "SELECT Procedencia FROM `procedencia`;";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
       
       rs.last();
       int totalOfRecords = rs.getRow();
       rs.beforeFirst();
      // System.err.println(totalOfRecords);
      String[] r = new  String[totalOfRecords+1]; 
      r[0] = "Selecione a Procedencia ou Informe ao Lado!"; 
      int i =1;
        while (rs.next()) {            
                r[i] = rs.getString("Procedencia");
                i++;

        }
        
        return r; 
    }
 
 
 
 public static String [] motivo_da_vinda() throws SQLException{
       String sql = "SELECT motivo_da_vinda FROM `motivo_da_vinda`;";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
       
       rs.last();
       int totalOfRecords = rs.getRow();
       rs.beforeFirst();
      // System.err.println(totalOfRecords);
      String[] r = new  String[totalOfRecords+1]; 
      r[0] = "Selecione a Procedencia ou Informe Abaixo!"; 
      int i =1;
        while (rs.next()) {            
                r[i] = rs.getString("motivo_da_vinda");
                i++;

        }
        
        return r; 
    }
 



 
public static String [] Cidade(String uf) throws SQLException{
    String sql = "SELECT Nome FROM `municipio` WHERE Uf='"+uf+"'; ";
    Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
       
       rs.last();
       int totalOfRecords = rs.getRow();
       rs.beforeFirst();
       System.err.println(totalOfRecords);
      String[] r = new  String[totalOfRecords]; 
      int i =0;
       while (rs.next()) {            
                r[i] = rs.getString("Nome");
                i++;

        }
        
        return r; 
    
}



public static String idRua(String nome, String idMunicipio) throws SQLException{
     String sql = "SELECT Id FROM `rua` WHERE Nome='"+nome+"'AND municipio_Id='"+idMunicipio+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
           String r = null;
       if (rs.next()) {            
           r = rs.getString("Id");
           return r;    

        }else{
           return cadastraRUA(nome, idMunicipio);
       }
    
}

public static String cadastraRUA(String nome, String idMunicipio) throws SQLException{
    String sql = "INSERT INTO `rua` (`Id`, `Nome`, `municipio_Id`) VALUES (NULL, '26 de Junho', '921');";

    Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
        stmt.execute();
        stmt.close();
        
        return idRua(nome, idMunicipio);
           

}



public static String idBairro(String nome, String idMunicipio) throws SQLException{
     String sql = "SELECT Id FROM `bairro` WHERE Nome='"+nome+"' AND municipio_Id='"+idMunicipio+"'; ";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
           String r = null;
       if (rs.next()) {            
           r = rs.getString("Id");
           return r;    

        }else{
           return cadastrarBairro(nome, idMunicipio);
       }
        
    
}

 public static String cadastrarBairro(String nome, String idMunicipio)throws SQLException{
          String sql = "INSERT INTO `bairro` (`Id`, `Nome`, `municipio_Id`) VALUES (NULL, '"+nome+"', '"+idMunicipio+"');";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
        stmt.execute();
        stmt.close();
        
        return idBairro(nome, idMunicipio);
        
        }
    
 public static String UfEstado(String nome) throws SQLException{
     String sql = "SELECT Uf FROM `estado` WHERE Nome='"+nome+"';";
     
     Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      
      String r = null;
       while (rs.next()) {            
                r = rs.getString("Uf");
               

        }
        
        return r;
 }
 

public static String idMunicipio(String nome, String Uf ) throws SQLException{
   String sql = "SELECT id FROM `municipio` WHERE Nome='"+nome+"' AND Uf='"+Uf+"';"; 
     Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      
      String r = null;
       while (rs.next()) {            
                r = rs.getString("id");
               

        }
        
        return r;
    
    
}

 
 
 

public static String rua(String id) throws SQLException{
    String sql = "SELECT Nome FROM `rua` WHERE id='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("Nome");
                i++;

        }
        
        return r;
}


public static String id_rua_has_bairro(String idBairr, String idRua) throws SQLException{
   String sql = "SELECT id FROM `rua_has_bairro` WHERE id_rua='"+idRua+"' AND id_bairro='"+idBairr+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      
      String r = null;
       if(rs.next()) {            
                r = rs.getString("id");
                return r;   
       }else{
           return cadastra_rua_has_bairro(idBairr, idRua); 
       }
        
        
}   
    
public static String cadastra_rua_has_bairro(String idBairr, String idRua) throws SQLException{
        String sql = "INSERT INTO `rua_has_bairro` (`id`, `id_rua`, `id_bairro`) VALUES (NULL, '"+idRua+"', '"+idBairr+"');";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
        stmt.execute();
        stmt.close();
        
        return id_rua_has_bairro(idBairr,idRua);
    
    
    
}


public String motivo(String nome) throws SQLException{
  String sql = "SELECT Id FROM `motivo_da_vinda` WHERE motivo_da_vinda='"+nome+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("Id");
                i++;

        }
        
        return r;
    
    
}

public String cadMotivo(String nome) throws SQLException{
    String sql = "INSERT INTO `motivo_da_vinda` (`Id`, `motivo_da_vinda`) VALUES (NULL, '"+nome+"');";
    Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       stmt.execute();
       stmt.close();
       
    return idMotivo(nome); 
}


public String cadProce(String nome) throws SQLException{
    String sql = "INSERT INTO `procedencia` (`id`, `Procedencia`) VALUES (NULL, '"+nome+"');";
    Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       stmt.execute();
       stmt.close();
       
    return idProce(nome); 
}

public String idProce(String nome) throws SQLException{
    String sql = "SELECT id FROM `procedencia` WHERE Procedencia='"+nome+"';";
    
     Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      
      String r = null;
       while (rs.next()) {            
                r = rs.getString("id");
                
        }
        
        return r;
    
    
}





public String idMotivo(String nome) throws SQLException{
    String sql = "SELECT Id FROM `motivo_da_vinda` WHERE motivo_da_vinda='"+nome+"';";
    
     Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("id");
                i++;

        }
        
        return r;
    
    
}



public String proce(String nome) throws SQLException{
  String sql = "SELECT id FROM `procedencia` WHERE Procedencia='"+nome+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("id");
                i++;

        }
        
        return r;
    
    
}


public static String bairro(String id) throws SQLException{
    String sql = "SELECT Nome FROM `bairro` WHERE id='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("Nome");
                i++;

        }
        
        return r;
}

public static void cadastrar(String nome, String sexo, String rg, String altura, String peso, String zona, String cep, String n, String procedencia, String motivo, String cartaoSUS, String rua_has_bairro) throws SQLException{

 Triagem t = new Triagem();
    double p = Double.parseDouble(peso);
 //   String sql = "UPDATE `paciente` SET `nome` = 'Joice Barbosa Fragoso', `sexo` = 'FEMININO', `rg` = '2005', `Altura` = '1.60', `Peso` = '66', `zona` = 'URBANA', `cep` = '63870000', `numero` = '10' WHERE `paciente`.`cartao_sus` = '2' AND `paciente`.`procedencia_id` = 1 AND `paciente`.`motivo_da_vinda_Id` = 1; ";
   String sql = "INSERT INTO `paciente` (`cartao_sus`, `nome`, `sexo`, `rg`, `Altura`, `Peso`, `zona`, `cep`, `numero`, `procedencia_id`, `motivo_da_vinda_Id`, `rua_has_bairro_id`) VALUES ('"+cartaoSUS+"', '"+nome+"', '"+sexo+"', '"+rg+"', '"+altura+"', '"+peso+"', '"+zona+"', '"+cep+"', '"+n+"', '"+procedencia+"', '"+motivo+"', '"+rua_has_bairro+"');"; 

       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       stmt.execute();
       stmt.close();
        
        
        
        
        
        
        t.jTFNome.setText("");
        t.jTFCEP.setText("");
        t.jTFRG.setText("");
        t.jTextFieldNumero.setText("");
        t.jTextAreaMedicamento.setText("");
        t.jTextFieldVomitou.setText("");
        t.jTFQual.setText("");
        t.jTextFieldRua.setText("");
        t.jTFBairro.setText("");
        t.jTextField4.setText("");
        t.jTextFieldRua.setText("");
        t.jTextFieldAltura.setText("");
        t.jTextFieldDefecou.setText("");
        t.jTextFieldProcedencia.setText("");
        t.jTPESO.setText("");
        t.jTextPaneMotivoDaVinda.setText("");
   

    
    
    
}

  public Paciente p (){
      Paciente p = new Paciente();
      return p; 
  }  

public static String selectIdBairro(String id) throws SQLException{
   String sql = "SELECT id_bairro FROM `rua_has_bairro` WHERE id='"+id+"';";
    Conexao c = new Conexao();
       Connection con = c.getConnection();
        
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
     
      String r = null;
       while (rs.next()) {            
                r = rs.getString("Nome");
                

        }
        
        return NomeBairro(r);

    
}  
  
  
public static String NomeBairro(String id) throws SQLException{
   String sql = "SELECT Nome FROM `bairro` WHERE Id='"+id+"';"; 
          Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
     
      String r = null;
       while (rs.next()) {            
                r = rs.getString("Nome");
                

        }
        
        return r;


}


public void atualiza(String nome, String sexo, String rg, String altura, String peso, String zona, String cep, String n, String procedencia, String motivo, String cartaoSUS) throws SQLException{
    Triagem t = new Triagem();
    double p = Double.parseDouble(peso);
 //   String sql = "UPDATE `paciente` SET `nome` = 'Joice Barbosa Fragoso', `sexo` = 'FEMININO', `rg` = '2005', `Altura` = '1.60', `Peso` = '66', `zona` = 'URBANA', `cep` = '63870000', `numero` = '10' WHERE `paciente`.`cartao_sus` = '2' AND `paciente`.`procedencia_id` = 1 AND `paciente`.`motivo_da_vinda_Id` = 1; ";
   String sql = "UPDATE `paciente` SET `nome` = '"+nome+"', `sexo` = '"+sexo+"', `rg` = '"+rg+"', `Altura` = '"+altura+"', `Peso` = '"+p+"', `zona` = '"+zona+"', `cep` = '"+cep+"', `numero` = '"+n+"', `procedencia_id` = '"+procedencia+"', `motivo_da_vinda_Id` = '"+motivo+"' WHERE `paciente`.`cartao_sus` = '"+cartaoSUS+"';  "; 

       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       stmt.execute();
       stmt.close();
       
       t.p().setNome(nome);
       t.p().setCartao_sus(cartaoSUS);
       t.p().setCidade("Boa Viagem");
       t.p().setCep(cep);
       int cor = 7;
      String orc = (String) t.jComboBoxCor.getSelectedItem(); ;
             //"Vermelho", "Laranja", "Amarelo", "Verde", "Azual"
       if(orc.equals("Vermelho")){
           Math.pow(cor,5); 
       }else if(orc.equals("Laranja")){
           Math.pow(cor, 4);
       }else if(orc.equals("Amarelo")){
           Math.pow(cor,3);
       }else if(orc.equals("Verde")){
           Math.pow(cor, 1);
       }else{
           cor = 5; 
       }
       t.p().setCor(cor);
       t.p().setDiabetico(true);
        t.jTFNome.setText("");
        t.jTFCEP.setText("");
       t.jTFRG.setText("");
        
        t.jTextFieldNumero.setText("");
        
        t.jTextAreaMedicamento.setText("");
        t.jTextFieldVomitou.setText("");
        t.jTFQual.setText("");
        t.jTextFieldRua.setText("");
        t.jTFBairro.setText("");
        t.jTextField4.setText("");
        t.jTextFieldRua.setText("");
        t.jTextFieldAltura.setText("");
        t.jTextFieldDefecou.setText("");
        t.jTextFieldProcedencia.setText("");
        t.jTPESO.setText("");
        t.jTextPaneMotivoDaVinda.setText("");
           
      
        
        
   
}




public static String Rua_has_bairro(String id, int e) throws SQLException{
       if(e==1){
       String sql = "SELECT id_rua FROM `rua_has_bairro` WHERE id='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
      
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("id_rua");
                i++;

        }
        
        return rua(r);
       }else{
         
           
       String sql = "SELECT id_bairro FROM `rua_has_bairro` WHERE id='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
        
      int i =1;
      String r = null;
       while (rs.next()) {            
                r = rs.getString("id_bairro");
                i++;

        }
        
        return bairro(r);
       }
    }




public static String [] Rua(String id) throws SQLException{
       String sql = "SELECT Nome FROM `rua` WHERE municipio_Id='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
        
       rs.last();
       int totalOfRecords = rs.getRow();
       rs.beforeFirst();
       System.err.println(totalOfRecords+1);
      String[] r = new  String[totalOfRecords+1];
      int i =1;
      r[0] = "Selecione a rua!";
       while (rs.next()) {            
                r[i] = rs.getString("Nome");
                i++;

        }
        
        return r; 
    }
public static String [] Bairro(String id) throws SQLException{
       String sql = "SELECT Nome FROM `bairro` WHERE municipio_Id='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
        
       rs.last();
       int totalOfRecords = rs.getRow();
       rs.beforeFirst();
       System.err.println(totalOfRecords);
      String[] r = new  String[totalOfRecords+1];
      int i =1;
      r[0]= "Selecione o Bairro!";
       while (rs.next()) {            
                r[i] = rs.getString("Nome");
                i++;

        }
        
        return r; 
    }
    





public static String [] Estado(String id) throws SQLException{
       String sql = "SELECT Nome FROM `estado` WHERE Regiao='"+id+"';";
       Conexao c = new Conexao();
       Connection con = c.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql); 
       ResultSet rs = stmt.executeQuery(sql);
        
       rs.last();
       int totalOfRecords = rs.getRow();
       rs.beforeFirst();
       System.err.println(totalOfRecords);
      String[] r = new  String[totalOfRecords];
      int i =0;
       while (rs.next()) {            
                r[i] = rs.getString("Nome");
                i++;

        }
        
        return r; 
    }
    
 public static void main(String[] args) throws Exception {    
   new Triagem();

 }    



}

    




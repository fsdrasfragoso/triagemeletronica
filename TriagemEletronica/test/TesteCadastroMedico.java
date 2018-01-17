



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import triagemeletronica.interfaces.administrador.Tela_Administrador_Adicionar_Enfermeiro;
import triagemeletronica.interfaces.administrador.Tela_Administrador_Adicionar_Medico;
import triagemeletronica.interfaces.administrador.Tela_Administrador_Alterar_Medico;
import triagemeletronica.modelos.Enfermeiro;
import triagemeletronica.modelos.Medico;

/**
 *
 * @author lenovo user
 */
public class TesteCadastroMedico {
    
    public TesteCadastroMedico() {
        
    }
           
    @Test
    public void testeNomeValido() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Marcio Sousa");
        medico.setCrm("0321");
        medico.setSenha("Abcd#1234");
        medico.setPerfil("Medico");
 
        try {
            adicionar.adicionar_usuario(medico);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nomeMed = "Marcio Sousa";
        
        String nomeMedico = adicionar.buscaMedico(medico).getNome();
                
        assertEquals(nomeMedico, nomeMed);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNome() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio");
        medico.setCrm("1508");
        medico.setSenha("Abcd#$123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNomeComNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio123");
        medico.setCrm("6490");
        medico.setSenha("Abcd#$%123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio%$#");
        medico.setCrm("856734");
        medico.setSenha("Aabcd#$@123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNomeComCaracteresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio%$#123");
        medico.setCrm("1239865");
        medico.setSenha("Abcd!@#123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeComNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio123 Sousa");
        medico.setCrm("89654");
        medico.setSenha("Abcd!@#123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio#$@ Sousa");
        medico.setCrm("239856");
        medico.setSenha("Abcd!@123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio@#$123 Sousa");
        medico.setCrm("9821");
        medico.setSenha("Abcd@#123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeSobreNomeComNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio Sousa123");
        medico.setCrm("1890");
        medico.setSenha("Abcd@#123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeSobreNomeComCaractresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio Sousa@#$");
        medico.setCrm("8509");
        medico.setSenha("Abcd@#123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeSobreNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Márcio Sousa@#123");
        medico.setCrm("0367");
        medico.setSenha("Abcd#@123");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("");
        medico.setCrm("8512");
        medico.setSenha("Abcd%1234");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test
    public void testeCRMValido() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("Abcd$%345");
        medico.setPerfil("Medico");
        
        try {
            adicionar.adicionar_usuario(medico);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String crmMed = "12345";
        
        String crmMedico = adicionar.buscaMedico(medico).getCrm();
        
        assertEquals(crmMedico, crmMed);

    }
    
    @Test(expected = Exception.class)
    public void testeCRMComLetras() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("123456abc");
        medico.setSenha("Abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCRMComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("123456@#$");
        medico.setSenha("Abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCRMComLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("123456abc$%#");
        medico.setSenha("Abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCRMSomenteLetras() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("abcdefg");
        medico.setSenha("Abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCRMSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("#@!$%");
        medico.setSenha("Abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCRMSomenteLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("abcd#@!$%");
        medico.setSenha("Abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    /*@Test(expected = SQLException.class)
    public void testeCRMIgual() throws SQLException{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("abcd*&654");
        medico.setPerfil("Medico");
        
        try {
            adicionar.adicionar_usuario(medico);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
    @Test(expected = Exception.class)
    public void testeCRMNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
       
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("");
        medico.setSenha("Abcd*&6453");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }

    @Test
    public void testeSenhaValida() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("49632");
        medico.setSenha("Abc#45678");
        medico.setPerfil("Medico");
        
        try {
            adicionar.adicionar_usuario(medico);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String senhaMedico = "Abc#45678";
        
        String senhaMed = adicionar.buscaMedico(medico).getSenha();
        
        assertEquals(senhaMed, senhaMedico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaMenosDe8Caracteres() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("8765");
        medico.setSenha("ab#$12");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteLetras() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("6734");
        medico.setSenha("abcdefghij");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("6458");
        medico.setSenha("12345678");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("2470");
        medico.setSenha("@#$%&*!##");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("0189");
        medico.setSenha("abcde@#$");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteNumerosECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("4893");
        medico.setSenha("12345678@#$");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteLetrasENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("2956");
        medico.setSenha("12345678abcd");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSemLetraMinuscula() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("0548");
        medico.setSenha("ABC123@#$");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSemLetraMaiuscula() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("9056");
        medico.setSenha("ABC123@#$");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaNula() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("4906");
        medico.setSenha("");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test
    public void testePerfilValido() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("6804");
        medico.setSenha("Abcd%$#2134");
        medico.setPerfil("Medico");
        
        try {
            adicionar.adicionar_usuario(medico);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String perfilMed = "Medico";
        
        String perfilMedico = adicionar.buscaMedico(medico).getPerfil();
        
        assertEquals(perfilMedico, perfilMed);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilDiferente() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("0654");
        medico.setSenha("Abcd$%4567");
        medico.setPerfil("Administrador");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilComNumeroECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("946823");
        medico.setSenha("Abcd$%4567");
        medico.setPerfil("Medico123@#$");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilComNumero() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("7456");
        medico.setSenha("abcd$%4567");
        medico.setPerfil("Medico123");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("2378");
        medico.setSenha("Abcd$%4567");
        medico.setPerfil("Medico@#$");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("63902");
        medico.setSenha("Abc#$av123");
        medico.setPerfil("@#$!$%&");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilSomenteNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("684532");
        medico.setSenha("Aabcd$%4567");
        medico.setPerfil("1234567");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilSomenteNumerosECaraceresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("8365");
        medico.setSenha("Aabcd$%4567");
        medico.setPerfil("1234567#$@!");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno Alcântra");
        medico.setCrm("85648233");
        medico.setSenha("Abcd%$¨434");
        medico.setPerfil("");
        
        adicionar.adicionar_usuario(medico);
        
    }
     
    @Test
    public void testeFone_FixoValido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(2);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        
        adicionar.adicionar_endereco(medico);
        
        String fone_fixo_Med = "8934222433";
                
        String fone_fixo_Medico = adicionar.buscaEndMedico(medico).getFone_fixo();
        
        assertEquals(fone_fixo_Medico, fone_fixo_Med);
        
    }
    
     @Test(expected = Exception.class)
    public void testeFone_Fixo_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(3);
        medico.setFone_fixo("34228078156");
        medico.setFone_celular("89999426321");
        medico.setEndereco("Paraibinha");
        
        adicionar.adicionar_endereco(medico);
        
    }

    @Test(expected = Exception.class)
    public void testeFone_Fixo_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(4);
        medico.setFone_fixo("893422243");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(5);
        medico.setFone_fixo("893422abcd");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(6);
        medico.setFone_fixo("893422@#$%");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(7);
        medico.setFone_fixo("893422ab$%");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(8);
        medico.setFone_fixo("abcdefghij");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(9);
        medico.setFone_fixo("@#$%&*!@#$");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(10);
        medico.setFone_fixo("ab$%fg$%!@");
        medico.setFone_celular("89999424563");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test
    public void Celular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(11);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        
        adicionar.adicionar_endereco(medico);
        
        String fone_celu_Med = "89999999429";
                
        String fone_celu_Medico = adicionar.buscaEndMedico(medico).getFone_celular();
        
        assertEquals(fone_celu_Medico, fone_celu_Med);
        
    }
    
     @Test(expected = Exception.class)
    public void testeCelular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(12);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("899994668481");
        medico.setEndereco("Paraibinha");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(13);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("8999999942");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(14);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("8999942abcd");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(15);
        medico.setFone_fixo("8934222233");
        medico.setFone_celular("8999942@#!$");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(16);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999ab@#");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(17);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("abcdefghijk");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(18);
        medico.setFone_fixo("8934222@#!$");
        medico.setFone_celular("!@#$%&*!@#$");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(19);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("abcdefg!@#$");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(20);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(21);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999841001");
        medico.setEndereco("");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    

}
    

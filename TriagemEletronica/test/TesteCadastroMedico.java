



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
        medico.setSenha("abcd#1234");
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
    public void testeNomeInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("123");
        medico.setCrm("0321");
        medico.setSenha("abcd");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("");
        medico.setCrm("0321");
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
        medico.setSenha("abcd$%345");
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
    public void testeCRMInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("123abc!");
        medico.setSenha("abcd*&654");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCRMNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
       
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("");
        medico.setSenha("abcd*&6453");
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
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaInvalida() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("49632");
        medico.setSenha("Abc");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaNula() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("49632");
        medico.setSenha("");
        medico.setPerfil("Medico");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test
    public void testePerfilValido() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno");
        medico.setCrm("0987");
        medico.setSenha("abcd%$#2134");
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
    public void testePerfilInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno");
        medico.setCrm("3678");
        medico.setSenha("abcd$%4567");
        medico.setPerfil("Administrador");
        
        adicionar.adicionar_usuario(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setNome("Bruno");
        medico.setCrm("098765");
        medico.setSenha("abcd%$¨434");
        medico.setPerfil("");
        
        adicionar.adicionar_usuario(medico);
        
    }
     
    @Test
    public void testeFone_Fixo_e_Celular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(2);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        
        adicionar.adicionar_endereco(medico);
        
        String fone_fixo_Med = "8934222433";
        String fone_celu_Med = "89999999429";
                
        String fone_fixo_Medico = adicionar.buscaEndMedico(medico).getFone_fixo();
        String fone_celu_Medico = adicionar.buscaEndMedico(medico).getFone_celular();
        
        assertEquals(fone_fixo_Medico, fone_fixo_Med);
        assertEquals(fone_celu_Medico, fone_celu_Med);
        
    }
    
     @Test(expected = Exception.class)
    public void testeFone_Fixo_e_Celular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(4);
        medico.setFone_fixo("34228078156");
        medico.setFone_celular("899994668481");
        medico.setEndereco("Paraibinha");
        
        adicionar.adicionar_endereco(medico);
        
    }


    

    
    @Test(expected = Exception.class)
    public void testeFone_Fixo_e_Celular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(6);
        medico.setFone_fixo("893422243");
        medico.setFone_celular("8999999942");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(7);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("");
        medico.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        
        Medico medico = new Medico();
        
        medico.setId(8);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999841001");
        medico.setEndereco("");
        
        adicionar.adicionar_endereco(medico);
        
    }
    
    

}
    





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
public class TesteCadastro {
    
    public TesteCadastro() {
        
    }
           
    @Test
    public void testeNomeValido() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Marcio Sousa");
        medico.setCrm("0321");
        medico.setSenha("abcd#1234");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("João Sousa");
        enfermeiro.setCoren("9876");
        enfermeiro.setSenha("abcd#4356");
        enfermeiro.setPerfil("Enfermeiro");
 
        try {
            adicionar.adicionar_usuario(medico);
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nomeMed = "Marcio Sousa";
        String nomeEnf = "João Sousa";
        
        String nomeMedico = adicionar.buscaMedico(medico).getNome();
        String nomeEnfermeiro = adicionarEnf.buscaEnfermeiro(enfermeiro).getNome();
        
        assertEquals(nomeMedico, nomeMed);
        assertEquals(nomeEnfermeiro, nomeEnf);
        
    }
    
    @Test(expected = Exception.class)
    public void testeNomeInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("123");
        medico.setCrm("0321");
        medico.setSenha("abcd");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("123#@!");
        enfermeiro.setCoren("9876");
        enfermeiro.setSenha("abcd");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(medico);
        adicionarEnf.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("");
        medico.setCrm("0321");
        medico.setSenha("Abcd%1234");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("");
        enfermeiro.setCoren("9876");
        enfermeiro.setSenha("abcd*9876");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(medico);
        adicionarEnf.adicionar_usuario(enfermeiro);
        
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
            Logger.getLogger(TesteCadastro.class.getName()).log(Level.SEVERE, null, ex);
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
    public void testeCorenValido() {
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enferrmeiro = new Enfermeiro();
        
        enferrmeiro.setNome("Maria");
        enferrmeiro.setCoren("8965");
        enferrmeiro.setSenha("abcd%$2341");
        enferrmeiro.setPerfil("Enfermeiro");
        
        try {
            adicionar.adicionar_usuario(enferrmeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String corenEnf = "8965";
        
        String corenEnfermeiro = adicionar.buscaEnfermeiro(enferrmeiro).getCoren();
        
        assertEquals(corenEnfermeiro, corenEnf);
    
    }
    
    @Test(expected = Exception.class)
    public void testeCorenInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enferrmeiro = new Enfermeiro();
        
        enferrmeiro.setNome("Maria");
        enferrmeiro.setCoren("8abc3#1");
        enferrmeiro.setSenha("abcd@#$543");
        enferrmeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enferrmeiro);
        
    }

     @Test(expected = Exception.class)
    public void testeCorenNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enferrmeiro = new Enfermeiro();
        
        enferrmeiro.setNome("Maria");
        enferrmeiro.setCoren("");
        enferrmeiro.setSenha("abcd45678#$");
        enferrmeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enferrmeiro);
        
    }  
    
    @Test
    public void testeSenhaValida() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("49632");
        medico.setSenha("Abc#45678");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("Fabiano Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("Abc#45456");
        enfermeiro.setPerfil("Enfermeiro");
        
        try {
            adicionar.adicionar_usuario(medico);
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaInvalida() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("49632");
        medico.setSenha("Abc");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("Abc");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(medico);
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaNula() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Fabrício Sousa");
        medico.setCrm("49632");
        medico.setSenha("");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(medico);
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test
    public void testePerfilValido() {
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Bruno");
        medico.setCrm("0987");
        medico.setSenha("abcd%$#2134");
        medico.setPerfil("Medico");
        
        enfermeiro.setNome("Pedro");
        enfermeiro.setCoren("3456");
        enfermeiro.setSenha("abcd#$%1234");
        enfermeiro.setPerfil("Enfermeiro");
        
        try {
            adicionar.adicionar_usuario(medico);
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String perfilMed = "Medico";
        String perfilEnf = "Enfermeiro";
        
        String perfilMedico = adicionar.buscaMedico(medico).getPerfil();
        String perfilEnfermeiro = adicionarEnf.buscaEnfermeiro(enfermeiro).getPerfil();
        
        assertEquals(perfilMedico, perfilMed);
        assertEquals(perfilEnfermeiro, perfilEnf);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Bruno");
        medico.setCrm("3678");
        medico.setSenha("abcd$%4567");
        medico.setPerfil("Administrador");
        
        enfermeiro.setNome("Bruno");
        enfermeiro.setCoren("73546");
        medico.setSenha("abcd");
        medico.setPerfil("Administrador");
        
        adicionar.adicionar_usuario(medico);
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setNome("Bruno");
        medico.setCrm("098765");
        medico.setSenha("abcd%$¨434");
        medico.setPerfil("");
        
        enfermeiro.setNome("Bruno");
        enfermeiro.setCoren("4987");
        enfermeiro.setSenha("abcd");
        enfermeiro.setPerfil("");
        
        adicionar.adicionar_usuario(medico);
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
     
    @Test
    public void testeFone_Fixo_e_Celular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setId(2);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        
        enfermeiro.setId(3);
        enfermeiro.setFone_fixo("8934225678");
        enfermeiro.setFone_celular("89932199429");
        enfermeiro.setEndereco("Centro");
        
        adicionar.adicionar_endereco(medico);
        adicionarEnf.adicionar_endereco(enfermeiro);
        
        String fone_fixo_Med = "8934222433";
        String fone_fixo_Enf = "8934225678";
        String fone_celu_Med = "89999999429";
        String fone_celu_Enf = "89932199429";
                
        String fone_fixo_Medico = adicionar.buscaEndMedico(medico).getFone_fixo();
        String fone_fixo_Enfermeiro = adicionarEnf.buscaEndEnfermeiro(enfermeiro).getFone_fixo();
        String fone_celu_Medico = adicionar.buscaEndMedico(medico).getFone_celular();
        String fone_celu_Enfermeiro = adicionarEnf.buscaEndEnfermeiro(enfermeiro).getFone_celular();
        
        assertEquals(fone_fixo_Medico, fone_fixo_Med);
        assertEquals(fone_fixo_Enfermeiro, fone_fixo_Enf);
        assertEquals(fone_celu_Medico, fone_celu_Med);
        assertEquals(fone_celu_Enfermeiro, fone_celu_Enf);
        
    }
    
     @Test(expected = Exception.class)
    public void testeFone_Fixo_e_Celular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setId(4);
        medico.setFone_fixo("34228078156");
        medico.setFone_celular("899994668481");
        medico.setEndereco("Paraibinha");
        
        enfermeiro.setId(5);
        enfermeiro.setFone_fixo("89342287801");
        enfermeiro.setFone_celular("899995665451");
        enfermeiro.setEndereco("Cohab");
        
        adicionar.adicionar_endereco(medico);
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }


    

    
    @Test(expected = Exception.class)
    public void testeFone_Fixo_e_Celular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setId(6);
        medico.setFone_fixo("893422243");
        medico.setFone_celular("8999999942");
        medico.setEndereco("Mesquita");
        
        enfermeiro.setId(9);
        enfermeiro.setFone_fixo("893422156");
        enfermeiro.setFone_celular("8993214994");
        enfermeiro.setEndereco("Olavo Quadros");
        
        adicionar.adicionar_endereco(medico);
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setId(7);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("");
        medico.setEndereco("Mesquita");
        
        enfermeiro.setId(10);
        enfermeiro.setFone_fixo("34222433");
        enfermeiro.setFone_celular("");
        enfermeiro.setEndereco("Olavo Quadros");
        
        adicionar.adicionar_endereco(medico);
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Adicionar_Medico adicionar = new Tela_Administrador_Adicionar_Medico();
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        medico.setId(8);
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999841001");
        medico.setEndereco("");
        
        enfermeiro.setId(11);
        enfermeiro.setFone_fixo("34222433");
        enfermeiro.setFone_celular("89999841001");
        enfermeiro.setEndereco("");
        
        adicionar.adicionar_endereco(medico);
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }
    
    

}
    

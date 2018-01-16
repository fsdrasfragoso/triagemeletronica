/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import triagemeletronica.interfaces.administrador.Tela_Administrador_Adicionar_Enfermeiro;
import triagemeletronica.interfaces.administrador.Tela_Administrador_Adicionar_Medico;
import triagemeletronica.modelos.Enfermeiro;
import triagemeletronica.modelos.Medico;

/**
 *
 * @author marcio
 */
public class TesteCadastroEnfermeiro {
    
    public TesteCadastroEnfermeiro() {
    }
    
    @Test
    public void testeNomeValido() {
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Medico medico = new Medico();
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João Sousa");
        enfermeiro.setCoren("9876");
        enfermeiro.setSenha("abcd#4356");
        enfermeiro.setPerfil("Enfermeiro");
 
        try {
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nomeEnf = "João Sousa";
        
        String nomeEnfermeiro = adicionarEnf.buscaEnfermeiro(enfermeiro).getNome();
        
        assertEquals(nomeEnfermeiro, nomeEnf);
        
    }
    
    @Test(expected = Exception.class)
    public void testeNomeInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("123#@!");
        enfermeiro.setCoren("9876");
        enfermeiro.setSenha("abcd");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeNomeNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("");
        enfermeiro.setCoren("9876");
        enfermeiro.setSenha("abcd*9876");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
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
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
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
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabiano Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("Abc#45456");
        enfermeiro.setPerfil("Enfermeiro");
        
        try {
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaInvalida() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("Abc");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaNula() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test
    public void testePerfilValido() {
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Pedro");
        enfermeiro.setCoren("3456");
        enfermeiro.setSenha("abcd#$%1234");
        enfermeiro.setPerfil("Enfermeiro");
        
        try {
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String perfilEnf = "Enfermeiro";
        
        String perfilEnfermeiro = adicionarEnf.buscaEnfermeiro(enfermeiro).getPerfil();
        
        assertEquals(perfilEnfermeiro, perfilEnf);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilInvalido() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno");
        enfermeiro.setCoren("73546");
        enfermeiro.setSenha("abcd");
        enfermeiro.setPerfil("Administrador");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno");
        enfermeiro.setCoren("4987");
        enfermeiro.setSenha("abcd");
        enfermeiro.setPerfil("");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
     
    @Test
    public void testeFone_Fixo_e_Celular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(3);
        enfermeiro.setFone_fixo("8934225678");
        enfermeiro.setFone_celular("89932199429");
        enfermeiro.setEndereco("Centro");
        
        adicionarEnf.adicionar_endereco(enfermeiro);
        
        String fone_fixo_Enf = "8934225678";
        String fone_celu_Enf = "89932199429";
                
        String fone_fixo_Enfermeiro = adicionarEnf.buscaEndEnfermeiro(enfermeiro).getFone_fixo();
        String fone_celu_Enfermeiro = adicionarEnf.buscaEndEnfermeiro(enfermeiro).getFone_celular();
        
        assertEquals(fone_fixo_Enfermeiro, fone_fixo_Enf);
        assertEquals(fone_celu_Enfermeiro, fone_celu_Enf);
        
    }
    
     @Test(expected = Exception.class)
    public void testeFone_Fixo_e_Celular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(5);
        enfermeiro.setFone_fixo("89342287801");
        enfermeiro.setFone_celular("899995665451");
        enfermeiro.setEndereco("Cohab");
        
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }

    @Test(expected = Exception.class)
    public void testeFone_Fixo_e_Celular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(9);
        enfermeiro.setFone_fixo("893422156");
        enfermeiro.setFone_celular("8993214994");
        enfermeiro.setEndereco("Olavo Quadros");
        
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(10);
        enfermeiro.setFone_fixo("34222433");
        enfermeiro.setFone_celular("");
        enfermeiro.setEndereco("Olavo Quadros");
        
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(11);
        enfermeiro.setFone_fixo("34222433");
        enfermeiro.setFone_celular("89999841001");
        enfermeiro.setEndereco("");
        
        adicionarEnf.adicionar_endereco(enfermeiro);
        
    }
}

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
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João Sousa");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setPerfil("Enfermeiro");
 
        try {
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nomeEnf = "João Sousa";
        
        String nomeEnfermeiro = adicionarEnf.buscaEnfermeiro(enfermeiro).getNome();
        
        assertEquals(nomeEnf, nomeEnfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNome() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João");
        enfermeiro.setCoren("18902391");
        enfermeiro.setSenha("Abcd#@123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNomeComNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João123");
        enfermeiro.setCoren("67840983");
        enfermeiro.setSenha("Abcd#$123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João!@#$");
        enfermeiro.setCoren("8567346783");
        enfermeiro.setSenha("Aabcd#$@123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeSomentePrimeiroNomeComCaracteresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João%$#123");
        enfermeiro.setCoren("17683948");
        enfermeiro.setSenha("Abcd!@#123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeComNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João123 Sousa");
        enfermeiro.setCoren("8965489536");
        enfermeiro.setSenha("Abcd!@#123");
        enfermeiro.setPerfil("Medico");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João#$@ Sousa");
        enfermeiro.setCoren("90647392");
        enfermeiro.setSenha("Abcd!@123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João@#$123 Sousa");
        enfermeiro.setCoren("89034672");
        enfermeiro.setSenha("Abcd@#123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeSobreNomeComNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João Sousa123");
        enfermeiro.setCoren("679204");
        enfermeiro.setSenha("Abcd@#123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeSobreNomeComCaractresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João Sousa@#$");
        enfermeiro.setCoren("901273");
        enfermeiro.setSenha("Abcd@#123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeSobreNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("João Sousa@#123");
        enfermeiro.setCoren("465792340");
        enfermeiro.setSenha("Abcd#@123");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeNomeNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("");
        enfermeiro.setCoren("98765634");
        enfermeiro.setSenha("Abcd*9876");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }

    @Test
    public void testeCorenValido() {
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enferrmeiro = new Enfermeiro();
        
        enferrmeiro.setNome("Diego Sousa");
        enferrmeiro.setCoren("89657823");
        enferrmeiro.setSenha("Abcd%$2341");
        enferrmeiro.setPerfil("Enfermeiro");
        
        try {
            adicionar.adicionar_usuario(enferrmeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String corenEnf = "89657823";
        
        String corenEnfermeiro = adicionar.buscaEnfermeiro(enferrmeiro).getCoren();
        
        assertEquals(corenEnfermeiro, corenEnf);
    
    }
    
    @Test(expected = Exception.class)
    public void testeCorenComLetras() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Diego Sousa");
        enfermeiro.setCoren("123456abc");
        enfermeiro.setSenha("Abcd*&654");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCorenComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Diego Sousa");
        enfermeiro.setCoren("123456@#$");
        enfermeiro.setSenha("Abcd*&654");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCorenComLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Diego Sousa");
        enfermeiro.setCoren("123456abc$%#");
        enfermeiro.setSenha("Abcd*&654");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCorenSomenteLetras() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Diego Sousa");
        enfermeiro.setCoren("abcdefg");
        enfermeiro.setSenha("Abcd*&654");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCorenSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Diego Sousa");
        enfermeiro.setCoren("#@!$%");
        enfermeiro.setSenha("Abcd*&654");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCorenSomenteLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Diego Sousa");
        enfermeiro.setCoren("abcd#@!$%");
        enfermeiro.setSenha("Abcd*&654");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
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
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("Abc#45456");
        enfermeiro.setPerfil("Enfermeiro");
        
        try {
            adicionarEnf.adicionar_usuario(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String senhaEnfermeiro = "Abc#45456";
        
        String senhaEnf = adicionarEnf.buscaEnfermeiro(enfermeiro).getSenha();
        
        assertEquals(senhaEnf, senhaEnfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaMenosDe8Caracteres() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("87654876");
        enfermeiro.setSenha("ab#$12");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteLetras() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("67346543");
        enfermeiro.setSenha("abcdefghij");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("6458098223");
        enfermeiro.setSenha("12345678");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("24706754");
        enfermeiro.setSenha("@#$%&*!##");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("018987543");
        enfermeiro.setSenha("abcde@#$");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteNumerosECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("48938976");
        enfermeiro.setSenha("12345678@#$");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSomenteLetrasENumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("295687956");
        enfermeiro.setSenha("12345678Abcd");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSemLetraMinuscula() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("054789456");
        enfermeiro.setSenha("ABC123@#$");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaSemLetraMaiuscula() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("792304");
        enfermeiro.setSenha("abc123@#$");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeSenhaNula() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("932578934");
        enfermeiro.setSenha("");
        enfermeiro.setPerfil("Enfermeiro");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test
    public void testePerfilValido() {
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("3456876");
        enfermeiro.setSenha("Abcd#$%1234");
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
    public void testePerfilDiferente() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("06546534");
        enfermeiro.setSenha("Abcd$%4567");
        enfermeiro.setPerfil("Administrador");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilComNumeroECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("9468235398");
        enfermeiro.setSenha("Abcd$%4567");
        enfermeiro.setPerfil("Enfermeiro123@#$");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilComNumero() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("74567803");
        enfermeiro.setSenha("abcd$%4567");
        enfermeiro.setPerfil("Enfermeiro123");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("23789463");
        enfermeiro.setSenha("Abcd$%4567");
        enfermeiro.setPerfil("Enfermeiro@#$");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("639026709");
        enfermeiro.setSenha("Abc#$av123");
        enfermeiro.setPerfil("@#$!$%&");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilSomenteNumeros() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("684532765");
        enfermeiro.setSenha("Aabcd$%4567");
        enfermeiro.setPerfil("1234567");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilSomenteNumerosECaraceresEspeciais() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Joaquim Moura");
        enfermeiro.setCoren("836574232");
        enfermeiro.setSenha("Aabcd$%4567");
        enfermeiro.setPerfil("1234567#$@!");
        
        adicionar.adicionar_usuario(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testePerfilNulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionarEnf = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Bruno Alcântra");
        enfermeiro.setCoren("49879865");
        enfermeiro.setSenha("Abcd#$123");
        enfermeiro.setPerfil("");
        
        adicionarEnf.adicionar_usuario(enfermeiro);
        
    }
    
    @Test
    public void testeFone_FixoValido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(2);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999999429");
        enfermeiro.setEndereco("Bairro Junco");
        
        adicionar.adicionar_endereco(enfermeiro);
        
        String fone_fixo_Enf = "8934222433";
                
        String fone_fixo_Enfermeiro = adicionar.buscaEndEnfermeiro(enfermeiro).getFone_fixo();
        
        assertEquals(fone_fixo_Enfermeiro, fone_fixo_Enf);
        
    }
    
     @Test(expected = Exception.class)
    public void testeFone_Fixo_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(3);
        enfermeiro.setFone_fixo("34228078156");
        enfermeiro.setFone_celular("89999426321");
        enfermeiro.setEndereco("Paraibinha");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }

    @Test(expected = Exception.class)
    public void testeFone_Fixo_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(4);
        enfermeiro.setFone_fixo("893422243");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(5);
        enfermeiro.setFone_fixo("893422abcd");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(6);
        enfermeiro.setFone_fixo("893422@#$%");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(7);
        enfermeiro.setFone_fixo("893422ab$%");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(8);
        enfermeiro.setFone_fixo("abcdefghij");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(9);
        enfermeiro.setFone_fixo("@#$%&*!@#$");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(10);
        enfermeiro.setFone_fixo("ab$%fg$%!@");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test
    public void Celular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(11);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999999429");
        enfermeiro.setEndereco("Bairro Junco");
        
        adicionar.adicionar_endereco(enfermeiro);
        
        String fone_celu_Enf = "89999999429";
                
        String fone_celu_Enfermeiro = adicionar.buscaEndEnfermeiro(enfermeiro).getFone_celular();
        
        assertEquals(fone_celu_Enfermeiro, fone_celu_Enf);
        
    }
    
     @Test(expected = Exception.class)
    public void testeCelular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(12);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("899994668481");
        enfermeiro.setEndereco("Paraibinha");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(13);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("8999999942");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(14);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("8999942abcd");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(15);
        enfermeiro.setFone_fixo("8934222233");
        enfermeiro.setFone_celular("8999942@#!$");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(16);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999ab@#");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(17);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("abcdefghijk");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(18);
        enfermeiro.setFone_fixo("8934222@#!$");
        enfermeiro.setFone_celular("!@#$%&*!@#$");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelularSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(19);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("abcdefg!@#$");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(20);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("");
        enfermeiro.setEndereco("Mesquita");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Adicionar_Enfermeiro adicionar = new Tela_Administrador_Adicionar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(21);
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999841001");
        enfermeiro.setEndereco("");
        
        adicionar.adicionar_endereco(enfermeiro);
        
    }
   
}

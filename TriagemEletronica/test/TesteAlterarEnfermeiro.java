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
import triagemeletronica.interfaces.administrador.Tela_Administrador_Alterar_Enfermeiro;
import triagemeletronica.interfaces.administrador.Tela_Administrador_Alterar_Medico;
import triagemeletronica.interfaces.enfermeiro.Tela_Enfermeiro_Alterar_Dados;
import triagemeletronica.modelos.Enfermeiro;
import triagemeletronica.modelos.Medico;

/**
 *
 * @author marcio
 */
public class TesteAlterarEnfermeiro {
    
    public TesteAlterarEnfermeiro() {
    }
    
    @Test
    public void testeAlterarNomeValido() {
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco Sousa");
        enfermeiro.setCoren("8510854321");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        try {
            alterar.alterar_dados_Enfermeiro(enfermeiro);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nomeEnf = "Francisco Sousa";
        
        String nomeEnfermeiro = alterar.buscaEnfermeiro(enfermeiro).getNome();
        
        assertEquals(nomeEnfermeiro, nomeEnf);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNome() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComNumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco123");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco!@#$");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComCaracteresEspeciaisENumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco%$#123");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComNumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco123 Sousa");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco#$@ Sousa");
        enfermeiro.setCoren("90647392");
        enfermeiro.setSenha("Abcd!@123");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco@#$123 Sousa");
        enfermeiro.setCoren("89034672");
        enfermeiro.setSenha("Abcd@#123");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComNumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco Sousa123");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComCaractresEspeciais() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco Sousa@#$");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Francisco Sousa@#123");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeNulo() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("");
        enfermeiro.setCoren("85108543");
        enfermeiro.setSenha("Abcd#4356");
        enfermeiro.setId(274);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
    }
    
    @Test
    public void testeAlterarSenhaValida() {
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("Abc#4578#$");
        enfermeiro.setId(275);
        
        try {
            alterar.alterar_dados_Enfermeiro(enfermeiro);
        } catch (Exception ex) {
            
        }
        
        String senhaEnf = "Abc#4578#$";
        
        String senhaEnfermeiro = alterar.buscaEnfermeiro(enfermeiro).getSenha();
        
        assertEquals(senhaEnfermeiro, senhaEnf);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaMenosDe8Caracteres() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("ab#$12");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetras() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("abcdefghij");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteNumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("12345678");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("@#$%&*!##");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("abcde@#$");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteNumerosECaracteresEspeciais() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("12345678@#$");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetrasENumeros() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("12345678Abcd");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSemLetraMinuscula() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("ABC123@#$");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSemLetraMaiuscula() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("abc123@#$");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaNula() throws Exception{
        
        Tela_Enfermeiro_Alterar_Dados alterar = new Tela_Enfermeiro_Alterar_Dados();
       
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setNome("Fabrício Sousa");
        enfermeiro.setCoren("93257");
        enfermeiro.setSenha("");
        enfermeiro.setId(275);
        
        alterar.alterar_dados_Enfermeiro(enfermeiro);
        
    }
    
    @Test
    public void testeAlterarFone_FixoValido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        
        enfermeiro.setFone_fixo("8934228862");
        enfermeiro.setFone_celular("89999999429");
        enfermeiro.setEndereco("Bairro Junco");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
        
        String fone_fixo_Enf = "8934228862";
                
        String fone_fixo_Enfermeiro = alterar.buscaEndEnfermeiro(enfermeiro).getFone_fixo();
        
        assertEquals(fone_fixo_Enfermeiro, fone_fixo_Enf);
        
    }
    
     @Test(expected = Exception.class)
    public void testeAlterarFone_Fixo_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("34228078156");
        enfermeiro.setFone_celular("89999426321");
        enfermeiro.setEndereco("Paraibinha");
        enfermeiro.setId(2);        
        
        alterar.alterar_endereco(enfermeiro);
        
    }

    @Test(expected = Exception.class)
    public void testeAlterarFone_Fixo_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("893422243");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("893422abcd");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("893422@#$%");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("893422ab$%");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(8);
        enfermeiro.setFone_fixo("abcdefghij");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
    
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(9);
        enfermeiro.setFone_fixo("@#$%&*!@#$");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlteraFone_FixoSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setId(10);
        enfermeiro.setFone_fixo("ab$%fg$%!@");
        enfermeiro.setFone_celular("89999424563");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(2);
        
        alterar.alterar_endereco(enfermeiro);
     
    }
    
    @Test
    public void testeAlterarCelular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999841001");
        enfermeiro.setEndereco("Bairro Junco");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
        String fone_celu_Enf = "89999841001";
                
        String fone_celu_Enfermeiro = alterar.buscaEndEnfermeiro(enfermeiro).getFone_celular();
        
        assertEquals(fone_celu_Enfermeiro, fone_celu_Enf);
        
    }
    
     @Test(expected = Exception.class)
    public void testeAlterarCelular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("899994668481");
        enfermeiro.setEndereco("Paraibinha");
        enfermeiro.setId(11);

        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("8999999942");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("8999942abcd");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222233");
        enfermeiro.setFone_celular("8999942@#!$");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
    
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999ab@#");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("abcdefghijk");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222@#!$");
        enfermeiro.setFone_celular("!@#$%&*!@#$");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("abcdefg!@#$");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("");
        enfermeiro.setEndereco("Mesquita");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Alterar_Enfermeiro alterar = new Tela_Administrador_Alterar_Enfermeiro();
        
        Enfermeiro enfermeiro = new Enfermeiro();
        
        enfermeiro.setFone_fixo("8934222433");
        enfermeiro.setFone_celular("89999841001");
        enfermeiro.setEndereco("");
        enfermeiro.setId(11);
        
        alterar.alterar_endereco(enfermeiro);
        
    }
    
}

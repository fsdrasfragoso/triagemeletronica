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
import triagemeletronica.interfaces.administrador.Tela_Administrador_Alterar_Medico;
import triagemeletronica.interfaces.enfermeiro.Tela_Enfermeiro_Alterar_Dados;
import triagemeletronica.interfaces.medico.Tela_Medico_Alterar_Dados;
import triagemeletronica.modelos.Enfermeiro;
import triagemeletronica.modelos.Medico;

/**
 *
 * @author marcio
 */
public class TesteAlterarMedico {
    
    public TesteAlterarMedico() {
    }
    
    @Test
    public void testeAlterarNomeValido() {
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco Sousa");
        medico.setCrm("49632");
        medico.setSenha("Abc#45678");
        medico.setId(286);
        
        try {
            alterar.alterar_dados_Medico(medico);
        } catch (Exception ex) {
            Logger.getLogger(TesteCadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nomeMed = "Francisco Sousa";
        
        String nomeMedico = alterar.buscaMedico(medico).getNome();
        
        assertEquals(nomeMedico, nomeMed);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNome() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComNumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco123");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco!@#$");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComCaracteresEspeciaisENumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco%$#123");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComNumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco123 Sousa");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco#$@ Sousa");
        medico.setCrm("90647392");
        medico.setSenha("Abcd!@123");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco@#$123 Sousa");
        medico.setCrm("89034672");
        medico.setSenha("Abcd@#123");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComNumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco Sousa123");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComCaractresEspeciais() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();        
        
        
        medico.setNome("Francisco Sousa@#$");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Francisco Sousa@#123");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeNulo() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("");
        medico.setCrm("85108543");
        medico.setSenha("Abcd#4356");
        medico.setId(286);
        
        alterar.alterar_dados_Medico(medico);
    }
    
    @Test
    public void testeAlterarSenhaValida() {
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("Abcgh32!@");
        medico.setId(285);
        
        try {
            alterar.alterar_dados_Medico(medico);
        } catch (Exception ex) {
            
        }
        
        String senhaMed = "Abcgh32!@";
        
        String senhaMedico = alterar.buscaMedico(medico).getSenha();
        
        assertEquals(senhaMedico, senhaMed);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaMenosDe8Caracteres() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("Abcd#43");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetras() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("Abcdefghij");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteNumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("12345678");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("!@#$%&*@");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetrasECaracteresEspeciais() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("Abcdef@#!");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteNumerosECaracteresEspeciais() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("12345!@#");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetrasENumeros() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("Abcdef123");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSemLetraMinuscula() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("ABC123!@#");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSemLetraMaiuscula() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("abcd123!@#");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaNula() throws Exception{
        
        Tela_Medico_Alterar_Dados alterar = new Tela_Medico_Alterar_Dados();
        
        Medico medico = new Medico();
        
        medico.setNome("Diego Sousa");
        medico.setCrm("12345");
        medico.setSenha("");
        medico.setId(285);
        
        alterar.alterar_dados_Medico(medico);
        
    }
    
    @Test
    public void testeAlterarFone_FixoValido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("8934228862");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
        String fone_fixo_Med = "8934228862";
                
        String fone_fixo_Medico = alterar.buscaEndMedico(medico).getFone_fixo();
        
        assertEquals(fone_fixo_Medico, fone_fixo_Med);
        
    }
    
     @Test(expected = Exception.class)
    public void testeAlterarFone_Fixo_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("89342288623");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
    }

    @Test(expected = Exception.class)
    public void testeAlterarFone_Fixo_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("893422886");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeFone_FixoComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("89342288ab");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("89342288@#");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("893422ab@#");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("abcdefrtgf");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
    
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarFone_FixoSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("!@#$%&*!@#");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlteraFone_FixoSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        
        medico.setFone_fixo("abc!@#456@");
        medico.setFone_celular("89999999429");
        medico.setEndereco("Bairro Junco");
        medico.setId(2);
        
        alterar.alterar_endereco(medico);
     
    }
    
    @Test
    public void testeAlterarCelular_Valido() throws Exception {
        //teste de medico e enfermeiro validos (10 digitos fixo,11 digitos  celular)
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999841001");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
        String fone_celu_Med = "89999841001";
                
        String fone_celu_Medico = alterar.buscaEndMedico(medico).getFone_celular();
        
        assertEquals(fone_celu_Medico, fone_celu_Med);
        
    }
    
     @Test(expected = Exception.class)
    public void testeAlterarCelular_Invalido_1valoracima() throws Exception{
             //teste de medico e enfermeiro Invalidos (11 digitos fixo,12 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("899998410011");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelular_Invalido_1valorabaixo() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("8999984100");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularComLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("899998410ab");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularComCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("899998410@#");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
    
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularComLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("8999984ab@#");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularSomenteLetras() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("abcdefgmhns");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularSomenteCaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("!@#$%&*!@#$");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelularSomenteLetrasECaracteresEspeciais() throws Exception{
             //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("abcdfg!@#$%a");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarCelular_Nulo() throws Exception{
       //teste de medico e enfermeiro Invalidos (9 digitos fixo,10 digitos celular)estes testes de valores invalidos sao de limite para os dois
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("");
        medico.setEndereco("Bairro Junco");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarEndereco_Nulo() throws Exception{
        
        Tela_Administrador_Alterar_Medico alterar = new Tela_Administrador_Alterar_Medico();
        
        Medico medico = new Medico();
        
        medico.setFone_fixo("8934222433");
        medico.setFone_celular("89999841001");
        medico.setEndereco("");
        medico.setId(11);
        
        alterar.alterar_endereco(medico);
        
    }
    
}

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
import triagemeletronica.interfaces.administrador.Tela_Administrador_Alterar_Dados;
import triagemeletronica.interfaces.enfermeiro.Tela_Enfermeiro_Alterar_Dados;
import triagemeletronica.modelos.Administrador;
import triagemeletronica.modelos.Enfermeiro;

/**
 *
 * @author marcio
 */
public class TesteAlterarAdministrador {
    
    public TesteAlterarAdministrador() {
    }
    
    @Test
    public void testeAlterarNomeValido() {
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        try {
            alterar.alterar_dados_Administrador(administrador);
        } catch (Exception ex) {
        
        }
        
        String nomeAdm = "Renato Sousa";
        
        String nomeAdministrador = alterar.buscaAdministrador(administrador).getNome();
        
        assertEquals(nomeAdministrador, nomeAdm);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNome() throws Exception{
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComNumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato123");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato@#$");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSomentePrimeiroNomeComCaracteresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato123@#");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComNumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato123 Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato@#$% Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato@#$123 Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComNumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa123");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComCaractresEspeciais() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa!@#");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSobreNomeComCaractresEspeciaisENumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa!@123");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarNomeNulo() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
    }
    
    @Test
    public void testeAlterarSenhaValida() {
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Ab@!#4356");
        administrador.setId(1);
                
        try {
            alterar.alterar_dados_Administrador(administrador);
        } catch (Exception ex) {
            
        }
        
        String senhaAdm = "Ab@!#4356";
        
        String senhaAdministrador = alterar.buscaAdministrador(administrador).getSenha();
        
        assertEquals(senhaAdministrador, senhaAdm);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaMenosDe8Caracteres() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Ab@!#43");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetras() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcdefghi");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteNumeros() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("12435678");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteCaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("!@#$%&*!");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetrasECaracteresEspeciais() throws Exception{
        
       Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd@%!#");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteNumerosECaracteresEspeciais() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("$%@!#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSomenteLetrasENumeros() throws Exception{
        
       Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("Abcd4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSemLetraMinuscula() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("ABC@!#4356");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaSemLetraMaiuscula() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("abc123!@#");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
    @Test(expected = Exception.class)
    public void testeAlterarSenhaNula() throws Exception{
        
        Tela_Administrador_Alterar_Dados alterar = new Tela_Administrador_Alterar_Dados();
        
        Administrador administrador = new Administrador();
        
        administrador.setNome("Renato Sousa");
        administrador.setLogin("1234876");
        administrador.setSenha("");
        administrador.setId(1);
        
        alterar.alterar_dados_Administrador(administrador);
        
    }
    
}

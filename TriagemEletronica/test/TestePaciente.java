import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test
;import static org.junit.Assert.*;
import triagemeletronica.paciente.GerenciarPacienteTestes;
import triagemeletronica.paciente.Paciente;
import triagemeletronica.paciente.Triagem;

/**
 *
 * @author Jackness
 */
public class TestePaciente {
    
    public TestePaciente() {
    }
    Paciente paciente = new Paciente();
    GerenciarPacienteTestes gp = new GerenciarPacienteTestes();

    /*
        private String nome;
    private String rua;
    private int numero;
    private String motivo_da_vinda;

    private boolean dores;
    private float temperatura;
    private float sistole;
    private float diastola;
    private boolean diabetico;
    private float resultado_test_clicemia;
    private boolean alergia;
    private String resultado_alergia;
    private int cor; 
    private int diarreia; 
    private int vomito; 
    */
    
    @Test(expected = Exception.class)
    public void testeMotivoNula() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234574767456");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeMotivoValido(){
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("12345068584746");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeMotivo = "AIDS";
        
        String ZonaMotivo = gp.BuscaPaciente(paciente).get(12).getMotivo_da_vinda();
        
        assertEquals(ZonaMotivo, testeMotivo);
    }
    
    @Test(expected = Exception.class)
    public void testeZonaInvalidoNULL() throws Exception{

        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234563563374");
        paciente.setProcedencia("SAMU");
        paciente.setZona("");
        paciente.setMotivo_da_vinda("GONORREIA");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeZonaInvalido() throws Exception{

        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234563563374");
        paciente.setProcedencia("SAMU");
        paciente.setZona("256235%#$$%#");
        paciente.setMotivo_da_vinda("GONORREIA");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeZonaInvalidoNumeros() throws Exception{

        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234563563374");
        paciente.setProcedencia("SAMU");
        paciente.setZona("256235");
        paciente.setMotivo_da_vinda("GONORREIA");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeZonaInvalidoSimbolus() throws Exception{

        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234563563374");
        paciente.setProcedencia("SAMU");
        paciente.setZona("%$%%%$$");
        paciente.setMotivo_da_vinda("GONORREIA");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeZonaValido(){
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("12345123452786");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("HEMORROIDA");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeZona = "Zona Rural";
        
        String ZonaPaciente = gp.BuscaPaciente(paciente).get(0).getZona();
        
        assertEquals(ZonaPaciente, testeZona);
    }
    
    @Test(expected = Exception.class)
    public void testeCartaoInvalidoNULL() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("ESTRESSE POS NOTA ");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCartaoInvalido() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("%@#$%$@#%asdffgadfg");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("ESTRESSE POS NOTA ");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCartaoInvalidoSimbolus() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("%@#$%$@#%");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("ESTRESSE POS NOTA ");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCartaoInvalidoLetras() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("afasfa");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("ESTRESSE POS NOTA ");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeCartaoValido(){
        
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234567890");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("CAGANEIRA");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeCartao = "1234567890";
        
        String CartaoPaciente = gp.BuscaPaciente(paciente).get(3).getCartao_sus();
        
        assertEquals(CartaoPaciente, testeCartao);
    }
    
    @Test(expected = Exception.class)
    public void testeProcedenciaInvalidoNULL() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234548956846");
        paciente.setProcedencia("");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("CANCER");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeProcedenciaInvalido() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234548956846");
        paciente.setProcedencia("@%@56446");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("CANCER");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeProcedenciaValido(){
        
      
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("12345147858656");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("MAIN YASUO");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeProcedencia = "SAMU";
        
        String ProcedenciaPaciente = gp.BuscaPaciente(paciente).get(5).getProcedencia();
        
        assertEquals(ProcedenciaPaciente, testeProcedencia);
    }
    
    @Test(expected = Exception.class)
    public void testeCidadeInValidoNULL() throws Exception{
        
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("");
        paciente.setCartao_sus("1234144156");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("DONOVONOSE");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCidadeInValido() throws Exception{
        
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("@#$%3213254");
        paciente.setCartao_sus("1234144156");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("DONOVONOSE");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeCidadeValido(){
           
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234847855756");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("TRIPOMANIASE");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeCidade = "Picos";
        
        String CidadePaciente = gp.BuscaPaciente(paciente).get(0).getCidade();
        
        assertEquals(CidadePaciente, testeCidade);
    }
    
    @Test(expected = Exception.class)
    public void testeBairroInValidoNULL() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234356434756");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeBairroInValido() throws Exception{
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("@$%@$hndndf33545");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234356434756");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeBairroValido(){
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123364578456");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeBairro = "Junco";
        
        String BairroPaciente = gp.BuscaPaciente(paciente).get(0).getBairro();
        
        assertEquals(BairroPaciente, testeBairro);
    }
    
    @Test(expected = Exception.class)
    public void testeCepInvalidoMenosUM() throws Exception{
           
        paciente.setRg("2008190063");
        paciente.setCep("6300009");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456452");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 37.0);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.BuscaPaciente(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCepInvalidoMaisUM() throws Exception{
           
        paciente.setRg("2008190063");
        paciente.setCep("622300009");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456452");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 37.0);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.BuscaPaciente(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCepInvalidoNull() throws Exception{
           
        paciente.setRg("2008190063");
        paciente.setCep("fgsdhgfgh");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456452");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 37.0);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.BuscaPaciente(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCepInvalidoLetras() throws Exception{
           
        paciente.setRg("2008190063");
        paciente.setCep("fgsdhgfgh");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456452");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.BuscaPaciente(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeCepInvalidoSimbolos() throws Exception{
           
        paciente.setRg("2008190063");
        paciente.setCep("@#$@");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456452");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.BuscaPaciente(paciente);
    }
    
    @Test
    public void testeCepValido(){
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234569");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 37.0);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
        
        String testeCep = "62230000";
        
        String CepPaciente = gp.BuscaPaciente(paciente).get(1).getCep();
        
        assertEquals(CepPaciente, testeCep);
    }
    
    @Test(expected = Exception.class)
    public void testeRgInValido() throws Exception{

        paciente.setRg("000");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234567");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 37.0);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeRgNulo() throws Exception{
              
        paciente.setRg("");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234568");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        gp.cadastrar(paciente);
    }
    
    @Test
    public void testeRgValido(){
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 37.0);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 70.0);
        paciente.setAlergia(true);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        String testeRg = "2008190063";  
        gp.cadastrar(paciente);  
        String RgPaciente = gp.BuscaPaciente(paciente).get(0).getRg();
          
        assertEquals(testeRg, RgPaciente);
    }
    
    /*
    
    @Test
    public void testeDoresValidoTrue(){
 
        paciente.setDores(true);
        boolean DORES = true;
        gp.cadastrar(paciente);   
        boolean DORES_Paciente = gp.BuscaPaciente(paciente).get(14).getDores();
        assertEquals(DORES,DORES_Paciente);
    }
    @Test
    public void testeDoresValidoFalse(){
 
        paciente.setDores(false);
        boolean DORES = false;
        gp.cadastrar(paciente);   
        boolean DORES_Paciente = gp.BuscaPaciente(paciente).get(13).getDores();
        assertEquals(DORES,DORES_Paciente);
    }
    
    @Test
    public void testeDoresNulo(){
 
        paciente.setDores(true);
        boolean DORES = true;
        gp.cadastrar(paciente);   
        boolean DORES_Paciente = gp.BuscaPaciente(paciente).get(12).getDores();
        assertEquals(DORES,DORES_Paciente);
    }
    
    
    @Test
    public void testeDiabeticoNormalValido(){
        
        
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        gp.cadastrar(paciente); 
        if(gp.BuscaPaciente(paciente).get(11).getSistole() == 12.8){
            //presao normal
            boolean DIABETICO1 = false;
   
            boolean DIABETICO1_Paciente = gp.BuscaPaciente(paciente).get(11).getDiabetico();
            assertEquals(DIABETICO1,DIABETICO1_Paciente);
        } 
        
        if(gp.BuscaPaciente(paciente).get(11).getSistole() < 10.8){
           boolean DIABETICO2 = true;
           //presao baixa
   
           boolean DIABETICO2_Paciente = gp.BuscaPaciente(paciente).get(11).getDiabetico();
           assertEquals(DIABETICO2,DIABETICO2_Paciente);
        }
        if(gp.BuscaPaciente(paciente).get(11).getSistole() > 13.8){
            boolean DIABETICO3 = true;
            //presao acima
  
            boolean DIABETICO3_Paciente = gp.BuscaPaciente(paciente).get(11).getDiabetico();
            assertEquals(DIABETICO3,DIABETICO3_Paciente);
        }
    }
    
    @Test
    public void testeDiabeticoBaixoValido(){
         boolean DIABETICO;
        boolean DIABETICO_Paciente;
        paciente.setSistole((float) 10.8);
        paciente.setDiastola((float) 10.8);
        paciente.setDiabetico(true);
        gp.cadastrar(paciente); 
        if(gp.BuscaPaciente(paciente).get(10).getSistole() == 12.8){
            //presao normal
            DIABETICO = false;
   
            DIABETICO_Paciente = gp.BuscaPaciente(paciente).get(10).getDiabetico();
            assertEquals(DIABETICO,DIABETICO_Paciente);
        } 
        
        if(gp.BuscaPaciente(paciente).get(10).getSistole() < 11.8){
            DIABETICO = true;
           //presao baixa
   
           DIABETICO_Paciente = gp.BuscaPaciente(paciente).get(10).getDiabetico();
           assertEquals(DIABETICO,DIABETICO_Paciente);
        }
        if(gp.BuscaPaciente(paciente).get(10).getSistole() > 13.8){
            DIABETICO = true;
            //presao acima
   
            DIABETICO_Paciente = gp.BuscaPaciente(paciente).get(10).getDiabetico();
            assertEquals(DIABETICO,DIABETICO_Paciente);
        }
    }
    
    @Test
    public void testeDiabeticoAltoValido(){
        boolean DIABETICO;
        boolean DIABETICO_Paciente;
        paciente.setSistole((float) 14.8);
        paciente.setDiastola((float) 14.8);
        paciente.setDiabetico(true);
        gp.cadastrar(paciente); 
        if(gp.BuscaPaciente(paciente).get(9).getSistole() == 12.8){
            //presao normal
           DIABETICO = false;
 
           DIABETICO_Paciente = gp.BuscaPaciente(paciente).get(9).getDiabetico();
            assertEquals(DIABETICO,DIABETICO_Paciente);
        } 
        
        if(gp.BuscaPaciente(paciente).get(9).getSistole() < 11.8){
           DIABETICO = true;
           //presao baixa 
           DIABETICO_Paciente = gp.BuscaPaciente(paciente).get(9).getDiabetico();
           assertEquals(DIABETICO,DIABETICO_Paciente);
        }
        if(gp.BuscaPaciente(paciente).get(9).getSistole() > 13.8){
            DIABETICO = true;
            //presao acima
    
           DIABETICO_Paciente = gp.BuscaPaciente(paciente).get(9).getDiabetico();
            assertEquals(DIABETICO,DIABETICO_Paciente);
        }
    }
    
    @Test
    public void testeAlergiaValidoFalse(){
        

        paciente.setAlergia(false);       
        gp.cadastrar(paciente);
        boolean testeAlergia = false;
        boolean AlergiaPaciente = gp.BuscaPaciente(paciente).get(8).getAlergia();
        
        assertEquals(AlergiaPaciente, testeAlergia);
    }
    
        @Test
    public void testeAlergiaValidoTrue(){
 
        paciente.setAlergia(true);
        boolean testeAlergia = true;
        gp.cadastrar(paciente);
        boolean AlergiaPaciente = gp.BuscaPaciente(paciente).get(7).getAlergia();
        assertEquals(AlergiaPaciente, testeAlergia);
    }
    
    @Test
    public void testeResultadoAlergiaValida(){
 
        paciente.setResultado_alergia("DIPIRONA");
        String testeResultado = "DIPIRONA";
        gp.cadastrar(paciente);   
        String ResultadoAlergiaPaciente = gp.BuscaPaciente(paciente).get(6).getResultado_alergia();
        assertEquals(testeResultado,ResultadoAlergiaPaciente);
    }
    
    @Test(expected = Exception.class)
    public void testeResultadoAlergiaInValida()throws Exception{
 
        paciente.setResultado_alergia("DIPIRONA");
        String testeResultado = "DIPIRONA";
        gp.cadastrar(paciente);   
        String ResultadoAlergiaPaciente = gp.BuscaPaciente(paciente).get(5).getResultado_alergia();
        assertEquals(testeResultado,ResultadoAlergiaPaciente);
    }
    
        @Test(expected = Exception.class)
    public void testeResultadoAlergiaNull()throws Exception{
 
        paciente.setResultado_alergia("");
        String testeResultado = "";
        gp.cadastrar(paciente);   
        String ResultadoAlergiaPaciente = gp.BuscaPaciente(paciente).get(4).getResultado_alergia();
        assertEquals(testeResultado,ResultadoAlergiaPaciente);
    }
    
    
    @Test
    public void testeTemperaturaNormal(){
        //com febre
        paciente.setTemperatura((float) 37.0);
        float testeTemperatura = (float) 37.0;
        gp.cadastrar(paciente);
        
        if(gp.BuscaPaciente(paciente).get(3).getTemperatura() == (float) 37.0){
            //temperatura normal 
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(3).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        } 
        
        if(gp.BuscaPaciente(paciente).get(3).getTemperatura() < 36.0){
            //temperatura Hiportemia
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(3).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        }
        if(gp.BuscaPaciente(paciente).get(3).getTemperatura() > 38.0){
            //Temperatura Febre
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(3).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        }
       
    }
    
    public void testeTemperaturaHiportemia(){
        //com febre
        paciente.setTemperatura((float) 35.5);
        float testeTemperatura = (float) 35.5;
        gp.cadastrar(paciente);
        
        if(gp.BuscaPaciente(paciente).get(2).getTemperatura() == 37.0){
            //temperatura normal 
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(2).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        } 
        
        if(gp.BuscaPaciente(paciente).get(2).getTemperatura() < 36.0){
            //temperatura Hiportemia
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(2).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        }
        if(gp.BuscaPaciente(paciente).get(2).getTemperatura() > 38.0){
            //Temperatura Febre
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(2).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        }
       
    }
    
    public void testeTemperaturaFebre(){
        //com febre
        paciente.setTemperatura((float) 38.5);
        float testeTemperatura = (float) 38.5;
        gp.cadastrar(paciente);
        
        if(gp.BuscaPaciente(paciente).get(1).getTemperatura() == 37.0){
            //temperatura normal 
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(1).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        } 
        
        if(gp.BuscaPaciente(paciente).get(1).getTemperatura() < 36.0){
            //temperatura Hiportemia
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(1).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        }
        if(gp.BuscaPaciente(paciente).get(1).getTemperatura() > 38.0){
            //Temperatura Febre
            float TemperaturaPaciente = gp.BuscaPaciente(paciente).get(1).getTemperatura();
            assertEquals(testeTemperatura,TemperaturaPaciente,0.000001);
        }
       
    }
    */
    
    //FALTA FAZER 
    
    //CLICEMIA
    //RESULTADO ALERGIA
    //COR
   
 /**
 *
 * @author Jackness
 */

}


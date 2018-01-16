import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import triagemeletronica.paciente.Paciente;
import triagemeletronica.paciente.Triagem;

/**
 *
 * @author Jackness
 */
public class TestePaciente {
    
    public TestePaciente() {
    }
    // quando estivermos cadastro o paciente no bancode dados,
    // vamos implementar os testes do mesmo.
/*   
    @Test
    public void testeRgValido(){
        
        Triagem triagem = new Triagem();
        Paciente paciente = new Paciente();
        
        paciente.setRg("2008190063");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("123456");
        paciente.setProcedencia("SAMU");
        paciente.setZona("Zona Rural");
        paciente.setMotivo_da_vinda("AIDS");
        paciente.setDores(true);
        paciente.setTemperatura((float) 38.5);
        paciente.setSistole((float) 12.8);
        paciente.setDiastola((float) 12.8);
        paciente.setDiabetico(false);
        paciente.setResultado_test_clicemia((float) 66.6);
        paciente.setAlergia(false);
        paciente.setResultado_alergia("Dipirona");
        paciente.setCor(4);
        
        triagem.adicionar(paciente);
        
        String testeRg = "2008190063";
        
        String RgPaciente = adicionar.buscaPaciente(paciente).getRG();
        
        assertEquals(RgPaciente, testeRg);
    }
    
    @Test(expected = Exception.class)
    public void testeRgInValido() throws Exception{
        
        Triagem triagem = new Triagem();
        Paciente paciente = new Paciente();
        
        paciente.setRg("abc");
        paciente.setCep("62230000");
        paciente.setBairro("Junco");
        paciente.setCidade("Picos");
        paciente.setCartao_sus("1234567");
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
        
        triagem.adicionar(paciente);
    }
    
    @Test(expected = Exception.class)
    public void testeRgNulo() throws Exception{
        
        Triagem triagem = new Triagem();
        Paciente paciente = new Paciente();
        
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
        
        triagem.adicionar(paciente);
    }*/
}

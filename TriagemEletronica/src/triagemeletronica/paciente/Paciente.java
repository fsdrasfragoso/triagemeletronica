/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.paciente;

/**
 *
 * @author Esdras Fragoso
 */


// 
public class Paciente {
    private String nome;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String cartao_sus;
    private String rg;
    private String procedencia;
    private String motivo_da_vinda;
    private String zona;
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
 
    
    public Paciente() {
        
        
        
    }

    public Paciente(String nome, String rua, int numero, String bairro, String cidade, String cep, String cartao_sus, String rg, String procedencia, String motivo_da_vinda, String zona, boolean dores, float temperatura, float sistole, float diastola, boolean diabetico, float resultado_test_clicemia, boolean alergia, String resultado_alergia, int cor, int diarreia, int vomito) {
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.cartao_sus = cartao_sus;
        this.rg = rg;
        this.procedencia = procedencia;
        this.motivo_da_vinda = motivo_da_vinda;
        this.zona = zona;
        this.dores = dores;
        this.temperatura = temperatura;
        this.sistole = sistole;
        this.diastola = diastola;
        this.diabetico = diabetico;
        this.resultado_test_clicemia = resultado_test_clicemia;
        this.alergia = alergia;
        this.resultado_alergia = resultado_alergia;
        this.cor = cor;
        this.diarreia = diarreia;
        this.vomito = vomito;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int getDiarreia() {
        return diarreia;
    }

    public void setDiarreia(int diarreia) {
        this.diarreia = diarreia;
    }

    public int getVomito() {
        return vomito;
    }

    public void setVomito(int vomito) {
        this.vomito = vomito;
    }
  
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCartao_sus() {
        return cartao_sus;
    }

    public void setCartao_sus(String cartao_sus) {
        this.cartao_sus = cartao_sus;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getMotivo_da_vinda() {
        return motivo_da_vinda;
    }

    public void setMotivo_da_vinda(String motivo_da_vinda) {
        this.motivo_da_vinda = motivo_da_vinda;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isDores() {
        return dores;
    }

    public void setDores(boolean dores) {
        this.dores = dores;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getSistole() {
        return sistole;
    }

    public void setSistole(float sistole) {
        this.sistole = sistole;
    }

    public float getDiastola() {
        return diastola;
    }

    public void setDiastola(float diastola) {
        this.diastola = diastola;
    }

    public boolean isDiabetico() {
        return diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        this.diabetico = diabetico;
    }

    public float getResultado_test_clicemia() {
        return resultado_test_clicemia;
    }

    public void setResultado_test_clicemia(float resultado_test_clicemia) {
        this.resultado_test_clicemia = resultado_test_clicemia;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public String getResultado_alergia() {
        return resultado_alergia;
    }

    public void setResultado_alergia(String resultado_alergia) {
        this.resultado_alergia = resultado_alergia;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import triagemeletronica.modelos.Medico;
import triagemeletronica.modelos.Medico;
import triagemeletronica.modelos.Medico;

/**
 *
 * @author Márcio
 */
public class Validar {
    
    String nome;
    String crm;
    String coren;
    String senha;
    String perfilMed;
    String perfilEnf;
    String fone_fixoMed;
    String fone_fixoEnf;
    String celularMed;
    String celularEnf;
	
	public boolean checkName(String nome){
		
		this.nome = nome;
		
		Pattern p = Pattern.compile("^[a-zA-Z\\u00C0-\\u017F´]+\\s+[a-zA-Z\\u00C0-\\u017F´]{0,}$");
		Matcher m = p.matcher(nome);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean camposNulosMed(Medico medico) {
		
		if(!medico.getNome().equals("") && !medico.getCrm().equals("") && !medico.getSenha().equals("") && !medico.getPerfil().equals("")) {
			return true;
		}else {
			return false;
		}
		
	}
        
        public boolean camposNulosMedEnd(Medico medico) {
		
		if(!medico.getFone_celular().equals("") && !medico.getEndereco().equals("")) {
			return true;
		}else {
			return false;
		}
		
	}
        
        public boolean camposNulosEnf(Enfermeiro enfermeiro) {
		
		if(!enfermeiro.getNome().equals("") &&
                        !enfermeiro.getCoren().equals("") &&
                        !enfermeiro.getSenha().equals("") &&
                        !enfermeiro.getPerfil().equals("")) {
			return true;
		}else {
			return false;
		}
		
	}
        
        public boolean camposNulosEnfEnd(Enfermeiro enfermeiro) {
		
		if(!enfermeiro.getFone_celular().equals("") && !enfermeiro.getEndereco().equals("")) {
			return true;
		}else {
			return false;
		}
		
	}
        
        public boolean camposNulosAlterarEnf(Enfermeiro enfermeiro) {
		
		if(!enfermeiro.getNome().equals("") &&
                        !enfermeiro.getCoren().equals("") &&
                        !enfermeiro.getSenha().equals("")) {
			return true;
		}else {
			return false;
		}
		
	}
        
        public boolean checkCRM(String crm){
		
		this.crm = crm;
		
		Pattern p = Pattern.compile("[a-zA-Z!@#$%&*]");
		Matcher m = p.matcher(crm);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkCoren(String coren){
		
		this.coren = coren;
		
		Pattern p = Pattern.compile("[a-zA-Z!@#$%&*]");
		Matcher m = p.matcher(coren);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkPerfilMed(String perfilMed){
		
		this.perfilMed = perfilMed;
		
		if(perfilMed.equals("Medico")){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkPerfilEnf(String perfilEnf){
		
		this.perfilEnf = perfilEnf;
		
		if(perfilEnf.equals("Enfermeiro")){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkFone_FixoMed_valido(String fone_fixoMed){
		
		this.fone_fixoMed = fone_fixoMed;
		
		Pattern p = Pattern.compile("[A-Za-z!@#$%¨&*;.,-]");
		Matcher m = p.matcher(fone_fixoMed);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkFone_FixoMed10DigitosOuNulo(String fone_fixoMed){
		
		this.fone_fixoMed = fone_fixoMed;
                
		if(fone_fixoMed.length() == 10 || fone_fixoMed.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkFone_FixoEnf_valido(String fone_fixoEnf){
		
		this.fone_fixoEnf = fone_fixoEnf;
		
		Pattern p = Pattern.compile("[A-Za-z!@#$%¨&*;.,]");
		Matcher m = p.matcher(fone_fixoEnf);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkFone_FixoEnf10DigitosOuNulo(String fone_fixoEnf){
		
		this.fone_fixoEnf = fone_fixoEnf;
                
		if(fone_fixoEnf.length() == 10 || fone_fixoEnf.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkCelularMed_valido(String celularMed){
		
		this.celularMed = celularMed;
		
		Pattern p = Pattern.compile("[A-Za-z!@#$%¨&*;.,]");
		Matcher m = p.matcher(celularMed);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkCelularMed11Digitos(String celularMed){
		
		this.celularMed = celularMed;
                
		if(celularMed.length() == 11){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkCelularEnf_valido(String celularEnf){
		
		this.celularEnf = celularEnf;
		
		Pattern p = Pattern.compile("[A-Za-z!@#$%¨&*;.,]");
		Matcher m = p.matcher(celularEnf);
		
		if(m.find()){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkCelularEnf11Digitos(String celularEnf){
		
		this.celularEnf = celularEnf;
                
		if(celularEnf.length() == 11){
			return true;
		}else{
			return false;
		}
		
	}
        
        public boolean checkSenha(String senha){

            boolean achouNumero = false;
            boolean achouMaiuscula = false;
            boolean achouMinuscula = false;
            boolean achouSimbolo = false;
    
            for (char c : senha.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    achouNumero = true;
                } else if (c >= 'A' && c <= 'Z') {
                    achouMaiuscula = true;
                } else if (c >= 'a' && c <= 'z') {
                    achouMinuscula = true;
                } else {
                    achouSimbolo = true;
                }
            }
            
            if(achouNumero == true && achouMaiuscula == true && achouMinuscula == true && achouSimbolo && senha.length() >= 8){
                return true;
            }else{
                return false;
            }
            
        }
        
    }    
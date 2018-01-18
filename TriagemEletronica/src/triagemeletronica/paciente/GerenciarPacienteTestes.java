/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.paciente;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jackness
 */
public class GerenciarPacienteTestes {
    static ArrayList<Paciente> p = new ArrayList();
    
    public void cadastrar(Paciente cadastro){
       p.add(cadastro);   
    }
    
    public ArrayList<Paciente> BuscaPaciente(Paciente paciente){
        List<Paciente> result = new ArrayList<Paciente>();
            result = p;
        return (ArrayList<Paciente>) result;
    }
}

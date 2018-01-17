/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.array;

import java.util.ArrayList;
import java.util.Collections;
import javafx.print.Collation;
import javax.swing.JOptionPane;
import triagemeletronica.paciente.Paciente;
/**
 *
 * @author Esdras Fragoso 
 */
public class ArrayPacientes {
    ArrayList<Paciente> ListaDePaciente = new ArrayList<Paciente>();
    public void Cadastro(Paciente P){
        
        ListaDePaciente.add(P);
        
        
    }
    //Imprimer a ficha dos pacietnes que vão serem atendidos. 
    public void imprimirtodosprod(){
         for(int i=0;i<ListaDePaciente.size();i++){
            
   
         }
         
     
}
    // Imprimir a quantidade de pacientes a serem atendidos 
     public void ImprimirQauntidadePaciente(){
       JOptionPane.showMessageDialog(null, "Existem\t"+ListaDePaciente.size()+"\t na fila esperando para ser atendidos");
    } 
     /*
     
     // imprimir a ordem em que os pacientes vão ser atendidos 
     public void imprimirFila(){
         // auxilar para ciaração da fila
         //esta arrayList vai acumular todos os daos para serem ordenados pelo
         // pelo metodo bolha 
         ArrayList<Float> ListaPaciente = new ArrayList<Float>();
         float ficha = 0; 
         float imc; 
         for(int i=0;i<ListaDePaciente.size();i++){
             ficha = 0; 
             imc = ListaDePaciente.get(i).getPeso()/(ListaDePaciente.get(i).getAltura());
             //Mulher
             if(ListaDePaciente.get(i).getSexo().equals("Feminino")){
                  ficha = ficha + 1; 
                 //Mulher idosa
                  if(ListaDePaciente.get(i).getIdade()>60){
                   ficha = ficha  + 6; 
                 //Mulher não idosa
                  }else{
                     ficha = ficha + 0;
                 }
             }else{
                 ficha = ficha + 0;
                 if(ListaDePaciente.get(i).getIdade()>60){
                     ficha = ficha + 6;
                 }
             }
             
             if(imc > 32){
                 ficha = ficha + imc; 
             }
             if(imc < 18){
                 ficha = ficha + (3*imc);
             }
             ficha = ficha + ListaDePaciente.get(i).getVomito();
             ficha = ficha + ListaDePaciente.get(i).getDiarreia();
              if(ListaDePaciente.get(i).getPrecaoarterial() == ListaDePaciente.get(i).getPrecaoarterial2()){
                  ficha = 0; 
              }
              // pressão alta
              if(ListaDePaciente.get(i).getPrecaoarterial()>=14||ListaDePaciente.get(i).getPrecaoarterial2()>=9){
                  ficha = ficha + (2*ListaDePaciente.get(i).getPrecaoarterial()); 
              }
            // preção baixa
            if(ListaDePaciente.get(i).getPrecaoarterial()>=10||ListaDePaciente.get(i).getPrecaoarterial2()>=6){
                  ficha = ficha + (9*ListaDePaciente.get(i).getPrecaoarterial()); 
              }
               // System.out.println(ficha);
               ficha = ficha - i; 
             ListaPaciente.add(ficha);
         }
           // Ordenar fila de Pacientes para serem consultados por grau de necessidae
            Ordenar o = new Ordenar (); 
            o.insertionSort(ListaPaciente, ListaDePaciente); 
             for(int i = 0; i<ListaDePaciente.size();i++){
         //        JOptionPane.showMessageDialog(null,"Nome Paciente"+ListaDePaciente.get(i).getNome()+"\n Numero cartão SUS "+ListaDePaciente.get(i).getCartaosus()+"\n CPF do Paciente ->"+ListaDePaciente.get(i).getCpf()+"\n O RG do Paciente e:"+ListaDePaciente.get(i).getRg()+"\n a idade do paciente e:"+ ListaDePaciente.get(i).getIdade()+"\n O Sintoma do Paciente é"+ListaDePaciente.get(i).getSintomas()+"\n O PACIENTE VOMITOU?"+ListaDePaciente.get(i).getVomito()+"\n QUAL A TEMPERATURA DO PACIENTE?"+ListaDePaciente.get(i).getTemperatua() );
         
             }
     
             
     }
    */
     // Nessa parte o médifo visualiuza queme ele vai consultar e o sistema excluir da lista dos pacientes na fila 
     public void ConsultrPaciente(){
           // informações previs do paciente 
       //  JOptionPane.showMessageDialog(null, "O Paciente da vez é o senho: /t"+ ListaDePaciente.get(0).getNome()+"Que esta acintomatico: \n"+ListaDePaciente.get(0).getSintomas());
                     int resposta = JOptionPane.showConfirmDialog(null,"Deseja Consultar o pacietne agora?"); 
                         if(resposta == 0){
                        
                                ListaDePaciente.remove(0); 
      ///                  JOptionPane.showMessageDialog(null, "Boa Consulta");
              }else{
    //                    MENU m = new MENU();
      //                  m.munu();
                          
                          
              }  

     
     }
   
 // Buscar Pacientes     
     public void buscar(String palavra){
         for(int i = 0;i<ListaDePaciente.size();i++){
        //     if(ListaDePaciente.get(i).getNome().equals(palavra)||ListaDePaciente.get(i).getCpf().equals(palavra)||ListaDePaciente.get(i).getRg().equals(palavra)||ListaDePaciente.get(i).getCartaosus().equals(palavra)){
          //       JOptionPane.showMessageDialog(null,"Paciente nuemro: \t"+i+"\n O nome do Paciente é: \t"+ListaDePaciente.get(i).getNome()+"\n Sintoms: \t"+ListaDePaciente.get(i).getSintomas());
             }
         }
     }
     /*
     public void ALTERAR(String palavra){
         Alterar a = new Alterar();
         for(int i = 0;i<ListaDePaciente.size();i++){
             if(ListaDePaciente.get(i).getNome().equals(palavra)||ListaDePaciente.get(i).getCpf().equals(palavra)||ListaDePaciente.get(i).getRg().equals(palavra)||ListaDePaciente.get(i).getCartaosus().equals(palavra)){
                 JOptionPane.showMessageDialog(null,"Paciente nuemro: \t"+i+"\n O nome do Paciente é: \t"+ListaDePaciente.get(i).getNome()+"\n Sintoms: \t"+ListaDePaciente.get(i).getSintomas()+"Vai ser alterado");
                   a.AlerarPaciente(i, ListaDePaciente);
                        
             
             }
         }
     }
     
     public void remover(String palavra){
         for(int i = 0;i<ListaDePaciente.size();i++){
             if(ListaDePaciente.get(i).getNome().equals(palavra)||ListaDePaciente.get(i).getCpf().equals(palavra)||ListaDePaciente.get(i).getRg().equals(palavra)||ListaDePaciente.get(i).getCartaosus().equals(palavra)){
       //          JOptionPane.showMessageDialog(null,"Paciente nuemro: \t"+i+"\n O nome do Paciente é: \t"+ListaDePaciente.get(i).getNome()+"\n Sintoms: \t"+ListaDePaciente.get(i).getSintomas());
                   
                        ListaDePaciente.remove(i);
             
             }
         }
     }
}*/ 
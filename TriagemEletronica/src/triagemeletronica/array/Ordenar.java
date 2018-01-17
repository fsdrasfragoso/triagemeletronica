/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.array;


import java.util.ArrayList;
import triagemeletronica.paciente.Paciente;

/**
 *
 * @author Esdras 
 */
public class Ordenar implements Comparable{


     public ArrayList<Paciente> insertionSort(ArrayList<Float> list, ArrayList<Paciente> p){
        float key,temp;
        Paciente  TEMP;
        int i,j;
        for(i=1;i<list.size();i++){
            key = list.get(i);
            j=i-1;
            while(j>=0&&key>list.get(j)){
                temp = list.get(j);
                TEMP = p.get(j);
                
                list.set(j, list.get(j+1));
                p.set(j, p.get(j+1)); 
                list.set(j+1,temp);
                p.set(j+1,TEMP);
                j--;
            }
        }
        return p;
    }
    
}

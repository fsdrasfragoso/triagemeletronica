/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triagemeletronica.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabricio Sousa
 */

// testando repositório na class de conexão com banco de dados

 // Bruno executa teste do repositorio! 


// Diego testando repositório 
public class Conexao {

    public Conexao() {
    }
    
    public static Connection getConnection(){
        
        String db_url = "jdbc:mysql://localhost:3306/triagem";
        
        Connection con = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con=DriverManager.getConnection(db_url,"root","");
            
        }catch (ClassNotFoundException ex){
            System.out.println("Driver do MYSQL não Encontrado");
        }catch (SQLException ex){
            System.out.println("Erro ao tentar se conectar com o mysql");
        }
        return con;
    }
}

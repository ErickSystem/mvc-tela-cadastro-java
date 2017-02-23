
package crud.jsp.model;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class Conexao {
    private Connection con;
    private String url = "jdbc:derby://localhost:1527/RoupasSA";
    private String usuario ="erick"; 
    private String senha ="123";

    public Conexao(){
        try {
            openDatabase();
        } catch (Exception ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
        public Connection openDatabase() throws SQLException{
           con = null;
            try{
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                System.out.println("Conexão estabelecida com sucesso.");
                con = DriverManager.getConnection(url,usuario,senha);
           }
           catch (ClassNotFoundException e){
                System.err.println("Driver não encontrado:"+ e.getMessage());
            }
            return con;
        } 
         public void closeDatabase() throws Exception{ //Criamos um método para fechamento do banco
            if(con != null){
                 System.out.println("Conexão com banco de dados encerrado!.");
                con.close();
            }
         }

        public Connection getCon() {
            return con;
        }
         
         
    }
   
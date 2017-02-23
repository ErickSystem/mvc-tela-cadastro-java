package crud.jsp.model;

// Importações
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

// Declaração da classe
public class ClienteDAO extends Conexao{
 
  private Conexao con;
  private PreparedStatement select;
  private PreparedStatement update;
  private static ResultSet rs;

  public ClienteDAO(){
      con = new Conexao();
  }
  
  //Metedo utilizado para cadastrar 
  public int cadastrar(String nome,Integer manequim,String endereco,Integer telefone,String email) throws SQLException, Exception{
        if(con.getCon()==null)
        con.openDatabase();
      
        int res = 0;
        Cliente c = new Cliente();
      
        con.openDatabase();
        String sql = "insert into RoupasSA (nome,manequim,endereco,telefone,email) values (?,?,?,?,?)";
          
        update = con.getCon().prepareStatement(sql);
        update.setString(1, nome);
        update.setInt(2, manequim);
        update.setString(3, endereco);
        update.setInt(4, telefone);
        update.setString(5, email);
        //update.setDate(3, new java.sql.Date(cliente.getNascimento().getTime()));
        res = update.executeUpdate();
        update.close();
        con.closeDatabase();
      return res;
  }
  
  //metedo utilizado para listar os clientes cadastrados
  public ArrayList<Cliente> listarTodos() throws Exception{
           
      //se o retorno for diferente de null, abre o banco de dados
      if(con.getCon()==null)
          con.openDatabase();
       
          ArrayList<Cliente> clientes = new ArrayList<Cliente>();
          
          try{
              select = con.getCon().prepareStatement("SELECT * FROM RoupasSA order by nome");
              rs = select.executeQuery();
              
              while(rs.next()){
                 
                  Cliente c = new Cliente();
             
                  c.setId(rs.getInt("id"));
                  c.setNomeCliente(rs.getString("nome"));
                  c.setManequim(rs.getInt("manequim"));
                  c.setEndereco(rs.getString("endereco"));
                  c.setTelefone(rs.getInt("telefone"));
                  c.setEmail(rs.getString("email"));
                  //c.setNascimento(rs.getDate("data"));
                  
                  //adiciona o objeto a lista
                  clientes.add(c);
                  //fecha o banco de dados
              }
              select.close();
          }catch(SQLException sqle){
              System.out.println("Erro ao listar todos os Clientes: " + sqle.getMessage());
          }finally{
              con.closeDatabase();
          }
           return clientes;
      }
  
  public Cliente selecionaCliente(Integer id) throws SQLException, Exception{
      if(con.getCon()==null)
          con.openDatabase();
      
      Cliente c = null;
      String sql = "SELECT * FROM roupassa WHERE id=(?)";
      
      try{
          select = con.getCon().prepareStatement(sql);
          select.setInt(1, id);
          rs = select.executeQuery();
         
          while(rs.next()){
              c = new Cliente();
              c.setId(rs.getInt("id"));

              c.setNomeCliente(rs.getString("nome"));
              c.setManequim(rs.getInt("manequim"));
              c.setEmail(rs.getString("email"));
              c.setTelefone(rs.getInt("telefone"));
              c.setEndereco(rs.getString("endereco"));
          }
          select.close();
      }catch(SQLException sqle){
              System.out.println("Erro ao listar todos os Clientes: " + sqle.getMessage());
          }finally{
              con.closeDatabase();
     }
      return c;
 }

    public int atualizarCliente(Integer id, String nome, Integer manequim,String endereco,Integer telefone, String email) throws SQLException, Exception{
        
        if(con.getCon()==null)
            con.openDatabase();
        
        int res = 0;
        String sql = "UPDATE roupassa SET nome=(?), manequim=(?), endereco=(?), telefone=(?), email=(?) WHERE id=(?)";
        
        try{
          
              update = con.getCon().prepareStatement(sql);
              update.setString(1, nome);
              update.setInt(2, manequim);
              update.setString(3, endereco);
              update.setInt(4, telefone);
              update.setString(5, email);
              update.setInt(6, id);
           //update.setDate(3, new java.sql.Date(cliente.getNascimento().getTime()));
            res = update.executeUpdate();
            update.close();
              
        }catch(SQLException sqle){
              System.out.println("Erro ao atualizar Cadastro: " + sqle.getMessage());
          }finally{
              con.closeDatabase();
         }
        return res;
   }

    public int exceluirCliente(Integer id) throws Exception {
          if(con.getCon()==null)
            con.openDatabase();
        
        int res = 0;
        String sql = "DELETE FROM roupassa WHERE id=(?)";
        
        try{
          
            update = con.getCon().prepareStatement(sql);
            update.setInt(1, id);

           //update.setDate(3, new java.sql.Date(cliente.getNascimento().getTime()));
            res = update.executeUpdate();
            update.close();
              
        }catch(SQLException sqle){
              System.out.println("Erro ao excluir Cliente: " + sqle.getMessage());
          }finally{
              con.closeDatabase();
         }
        return res;
    }
    
}
  

/*  

  // Método que cria um objeto a partir de um registro
  private static Cliente popularCliente() throws SQLException {
    long id = rs.getLong("id");
    String nome = rs.getString("NomeCliente");
    byte manequim = rs.getByte("Manequim");
    Date nascimento = rs.getDate("Nascimento");
    Cliente cliente = new Cliente(id, nome, manequim, nascimento);
    return cliente;
  }
  
   // Método que calcula um novo valor para o campo Id
  private static long novoId() {
    long novo = 0;
    if (con.openDatabase()) {
      try {
        
        stmt = conexao.prepareStatement(sqlSelecaoMaiorId);
        rs = stmt.executeQuery();
        if (rs.next()) {
          novo = 1 + rs.getInt("mid");
        }
      } catch (SQLException sqle) {
      } finally {
        con.closeDatabase();
      }
    }
    return novo;
 */ 

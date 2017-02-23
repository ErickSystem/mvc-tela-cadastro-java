package crud.jsp.control;

import crud.jsp.model.Cliente;
import crud.jsp.model.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class Controle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
            String acao = null;
            Integer id = 0;
            
            acao = request.getParameter("acao");
            id = Integer.parseInt(request.getParameter("id"));
            
             System.out.println("acao: " + acao);
          
            if(acao.toUpperCase().equals("A")){
                
                 try {
                  Cliente c = new ClienteDAO().selecionaCliente(id);
                  
                   if(c==null || id==0){
                        request.setAttribute("resultado", "O Cliente do ID " + id + " Não foi encontrado");
                        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                   }
                   else{
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("alterarForm.jsp").forward(request, response);;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
           else if(acao.toUpperCase().equals("ABD")){
                                            
                try {
                    if(id==0 || (new ClienteDAO().selecionaCliente(id))==null){
                        request.setAttribute("resultado", "O Cliente do ID " + id + " Não foi encontrado");
                        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                        
                    }else{
                        String nome = null;
                        Integer manequim = 0;
                        String endereco = null;
                        Integer telefone = 0;
                        String email = null;
                        
                        nome = request.getParameter("nomeCliente");
                        manequim = Integer.parseInt(request.getParameter("manequim"));
                        endereco = request.getParameter("endereco");
                        telefone = Integer.parseInt(request.getParameter("telefone"));
                        email = request.getParameter("email");
                                              
                        if(nome == null || manequim == 0 || endereco == null || telefone == 0 || email == null ||
                            (new ClienteDAO().atualizarCliente(id, nome, manequim,endereco,telefone,email))<=0){
                            request.setAttribute("resultado", "O Cliente do ID: " + id + " não foi atualizado");
                            request.getRequestDispatcher("resultado.jsp").forward(request, response);
                        }else{
                              //  new ClienteDAO().atualizarCliente(id, nome, manequim,endereco,telefone,email);
                                request.setAttribute("resultado", "O Cliente do ID: " + id + " foi atualizado");
                                request.getRequestDispatcher("resultado.jsp").forward(request, response);
                             }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(acao.toUpperCase().equals("E")){
                try {
                    if(id==0 || (new ClienteDAO().exceluirCliente(id))<=0){
                        
                        request.setAttribute("resultado", "O Cliente do ID: " + id + " Não foi encontrado");
                        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                        
                    }else{
                        request.setAttribute("resultado", "O Cliente do ID: " + id + " Foi excluido do banco de dados");
                        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                        Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String nome = null;
          Integer manequim = 0;
          String endereco = null;
          Integer telefone = 0;
          String email = null;
          
        try{
          // if(request.getParameter("nome")!=null && !request.getParameter("nome").isEmpty()){
             nome = request.getParameter("nomeCliente");
             manequim = Integer.parseInt(request.getParameter("manequim"));
             endereco = request.getParameter("endereco");
             telefone = Integer.parseInt(request.getParameter("telefone"));
             email = request.getParameter("email");
             
            if (nome==null || manequim == 0 || endereco == null || telefone == 0 || email == null){
                request.setAttribute("resultado", "Todos os dados devem ser preenchidos");
                request.getRequestDispatcher("resultado.jsp").forward(request, response);
                
            }else{
                
                new ClienteDAO().cadastrar(nome, manequim, endereco, telefone, email);
                request.setAttribute("resultado", "Cadastro realizado com sucesso!");
                request.getRequestDispatcher("resultado.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
          
        }
   }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

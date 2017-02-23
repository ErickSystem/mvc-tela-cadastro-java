<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="crud.jsp.model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes cadastrados</title>
        
        <link rel="stylesheet" type="text/css" href="midia/css/style-tabela.css" />
        <link href="midia/css/jquery.modal.css" type="text/css" rel="stylesheet" />
        <link href="midia/css/jquery.modal.theme-xenon.css" type="text/css" rel="stylesheet" />
        <link href="midia/css/jquery.modal.theme-atlant.css" type="text/css" rel="stylesheet" />
       
        <script type="text/javascript" src="midia/js/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="midia/js/validarForm.js"></script>

        <!-- Chamando modal -->
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="midia/js/jquery.modal.js"></script>
        <script type="text/javascript" src="midia/js/modal.js"></script>
    
        
        
    </head>
    <body>
  
        <%
             ArrayList<Cliente> clientes;
             clientes = (ArrayList<Cliente>)request.getAttribute("listarTodos");
             
             if(clientes.size() <=0){
         %>
         <h1> Não há Clientes cadastrados</h1>
         <%
             }else{
         %>
           <table>
            <caption><b>LISTA DE CLIENTES</b></caption>
               <thead>
                   <tr>
                       <th>ID</th>
                       <th>NOME</th>
                        <th>MANEQUIM</th>
                        <th>ENDEREÇO</th>
                        <th>TELEFONE</th>
                        <th>EMAIL</th>
                        <th>ALTERAR</th>
                        <th>EXCLUIR</th>
                    </tr>
                </thead>
                <%
                 //DateFormat df =  DateFormat.getDateInstance(DateFormat.MEDIUM);
                    Iterator inter = clientes.iterator();
                    while(inter.hasNext()){
                        Cliente c = (Cliente) inter.next();
                    %> 
                <tbody id="tabela">
                    <tr>
                       <th><%=c.getId()%></th>
                        <th><%=c.getNomeCliente()%></th>
                        <th><%=c.getManequim()%></th>
                        <th> <%=c.getEndereco()%> </th>
                        <th> <%=c.getTelefone()%></th>
                         <th><%=c.getEmail()%></th>
                        <th><a href="Controle?id=<%=c.getId()%>&acao=A">Alterar</a></th>
                        <th><a href="Controle?id=<%=c.getId()%>&acao=E" id="excluir">Excluir</a></th>
                    </tr>
                </tbody>
         <% }
                        
         }%>
          </table>
         <br>
         <table>
            <tr>
                <td><a href="AtualizaLista">Atualizar</a></td>
                <td><a href="formulario.jsp">Novo cadastro</a></td>
            </tr>
        </table>
         <div class="home-buttom-comunity">
	    <a href="#"  id="confirm" class="hvr-fade"></a> 		
        </div>
   
    </body>
</html>

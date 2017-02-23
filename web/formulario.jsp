<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Clientes</title>
    
    <link rel="stylesheet" type="text/css" href="midia/css/formulario.css"/>
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
   
  		
    <form method="POST" action="Controle" name="Formulario"> 
					
        <h1>Cadastrar Cliente</h1>
		 
	<fieldset id="user-details">  
            
            <label for="nomeCliente">Nome do Cliente:</label>
            <input type="text" name="nomeCliente" value="" id="nomeCliente" placeholder="Digite aqui" maxlength="40"/>
            <small class="small-nome small-form"></small>
            <br><br> 
            <label for="email">E-mail:</label>
            <input type="text" name="email" value="" id="email" placeholder="Ex: nome@hotmail.com.br" maxlength="30"/> 
            <small class="small-email small-form"></small>
            <br><br>
            <label for="manequim">Manequim:</label>
            <input type="text" name="manequim" value="" id="manequim" placeholder="Digite aqui" maxlength="2" /> 
            <br>
            <label for="endereco">Endereço:</label>
            <input type="text" name="endereco" value="" id="endereco" placeholder="Digite aqui" /> 
            <br>
            <label for="telefone">Telefone:</label>
            <input type="text" name="telefone" value="" id="telefone" placeholder="Digite aqui" maxlength="09"/> 
            <br>
	</fieldset>
        <fieldset>
            <input type="submit" value="Gravar cliente" name="submit" id="enviar" class="Atualiza" />  
            <br> 
            <a href="AtualizaLista" class="listar">Listar clientes</a>
        </fieldset>    
    </form>
      
    <div class="container">
	 <div class="home-buttom-comunity">
	     <a href="#"  id="error" class="hvr-fade"  ></a> 		
	 </div>
     </div>
      
   </body>
</html>
$(function(){
	
    //Valida o nome
    $("#nomeCliente").focusin(function(){ 
	var v_nome = $("#nomeCliente").val();
	if(v_nome == ""){
             $(".small-nome").text("Campo nome é obrigatorio.");	   
	}
    });
    $("#nomeCliente").focusout(function(){
         var v_nome = $("#nomeCliente").val();
		    	
 	if(v_nome != ""){
            $(".small-nome").hide();
	}else{
            $(".small-nome").text("Preencha seu nome.").show();
	}
    });
    //valida o e-mail
    $("#email").focusin(function(){ 
	var v_email = $("#email").val();
	if(v_email == ""){
            $(".small-email").text("Campo E-mail é obrigatorio.");	   
	}
    });
    $("#email").focusout(function(){
         var v_email = $("#email").val();
	  		    	
	if(v_email != ""){
            $(".small-email").hide();
	}else{
            $(".small-email").text("Preencha seu E-mail.").show();
	}
    });

    //botao para enviar
    $("#enviar").click(function(){ 
            var v_nome = $("#nomeCliente").val();
            var v_email = $("#email").val();
            var v_manequim =$("#manequim").val();
            var v_endereco = $("#endereco").val();
            var v_telefone = $("#telefone").val();

            if (v_nome == ""){
                //error
                modal({
                   type: 'error',
                   title: 'Erro',
                   text: 'CAMPO NOME NÃO PREENCHIDO',
                   /* buttons: [{
                    text: 'OK', //Button Text
                    val: 'ok', //Button Value
                    eKey: true, //Enter Keypress
                    addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
                    onClick: function(argument) {

                    }
                    }, ],*/
                });
                $("#nomeCliente").focus();
                return false;
            }
            else if(v_email == ""){
                modal({
                    type: 'error',
                    title: 'Erro',
                    text: 'CAMPO E-MAIL NÃO PREENCHIDO',
                    /* buttons: [{
                    text: 'OK', //Button Text
                    val: 'ok', //Button Value
                    eKey: true, //Enter Keypress
                    addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
                    onClick: function(argument) {

                    }
                    }, ],*/
            });
                $("#email").focus();
                return false;
            }
            else if(v_manequim == "" || v_manequim == null){
                modal({
                    type: 'error',
                    title: 'Erro',
                    text: 'CAMPO MANEQUIM NÃO PREENCHIDO',
                    /* buttons: [{
                    text: 'OK', //Button Text
                    val: 'ok', //Button Value
                    eKey: true, //Enter Keypress
                    addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
                    onClick: function(argument) {

                    }
                    }, ],*/
                 });
                $("#manequim").focus();	
                return false;

        }
        else if(v_endereco == "" || v_endereco == null){
            modal({
                    type: 'error',
                    title: 'Erro',
                    text: 'CAMPO ENDEREÇO NÃO PREENCHIDO',
                    /* buttons: [{
                    text: 'OK', //Button Text
                    val: 'ok', //Button Value
                    eKey: true, //Enter Keypress
                    addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
                    onClick: function(argument) {

                    }
                    }, ],*/
                });
            $("#endereco").focus();	
            return false;
        }
        else if(v_telefone == "" || v_telefone == null){
            modal({
                type: 'error',
                title: 'Erro',
                text: 'CAMPO TELEFONE NÃO PREENCHIDO',
                /* buttons: [{
                text: 'OK', //Button Text
                val: 'ok', //Button Value
                eKey: true, //Enter Keypress
                addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
                onClick: function(argument) {

                }
                }, ],*/
            });
            $("#telefone").focus();	
            return false;
        }

        else{
            var res = validaEmail(v_email);

            if(res !== 0){
                    modal({
                        type: 'error',
                        title: 'Erro',
                        text: '[EMAIL INVALIDO] INFORME UM E-MAIL VÁLIDO ',
                        /* buttons: [{
                        text: 'OK', //Button Text
                        val: 'ok', //Button Value
                        eKey: true, //Enter Keypress
                        addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
                        onClick: function(argument) {

                        }
                        }, ],*/
                    });        
                return false;
                $("#email").focus();
            }
        }
    });
    
    /*$('a#excluir').click(function() {
        modal({
        type: 'confirm',
        title: 'Confirm',
        text: 'Deseja realmente excluir esse cliente?',
        callback: function(result) {
           // alert(result);    
            if(result == false){
                return false;
            }
        }
       });
    });*/
    
});

function validaEmail(email){
    var res = 0;
    if(email.indexOf("@") === -1 || email.indexOf(".com") === -1 ||
       email === null){
       res++;
    }
    return res;
}




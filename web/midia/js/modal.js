$(document).ready(function(e) {
		//alert
		$('a#alert').click(function() {
			modal({
				type: 'alert',
				title: 'Alert',
				text: "Simple Message!"
			});
		});
		//confirm
		$('a#confirm').click(function() {
			modal({
				type: 'confirm',
				title: 'Confirm',
				text: 'Are you sure you want to delete your brain?',
				callback: function(result) {
					alert(result);
				}
			});
		});
		//prompt
		$('a#prompt').click(function() {
			modal({
				type: 'prompt',
				title: 'Prompt',
				text: 'Type your name:',
				callback: function(result) {
					alert(result);
				}
			});
		});
		//success
		$('a#success').click(function() {
			modal({
				type: 'success',
				title: 'Sucesso',
				text: 'Escreva aqui a mensagem!',
			});
		});
		//warning
		$('a#warning').click(function() {
			modal({
				type: 'warning',
				title: 'Atenção',
				text: 'Escreva aqui a mensagem!',
				center: false,
			});
		});
		//info
		$('a#info').click(function() {
			modal({
				type: 'info',
				title: 'Informação',
				text: 'Escreva aqui a mensagem!',
				autoclose: true,
			});
		});
		//error
		$('a#error').click(function() {
			modal({
				type: 'error',
				title: 'Erro',
				text: 'Escreva aqui a mensagem!',
			});
		});
		//inverted
		$('a#inverted').click(function() {
			modal({
				type: 'inverted',
				title: 'Invertido',
				text: 'Escreva aqui a mensagem!',
			});
		});
		//primary
		$('a#primary').click(function() {
			modal({
				type: 'primary',
				title: 'Primeiro',
				text: 'Escreva aqui a mensagem!',
			});
		});
		//custom
		$('a#custom').click(function() {
			modal({
				type: 'primary', //Type of Modal Box (alert | confirm | prompt | success | warning | error | info | inverted | primary)
				title: 'Message', //Modal Title
				text: 'Principal mensagem simples com a opção personalizada <b>Xenon</b>.', //Modal HTML Content
				size: 'normal', //Modal Size (normal | large | small)
				buttons: [{
					text: 'OK', //Button Text
					val: 'ok', //Button Value
					eKey: true, //Enter Keypress
					addClass: 'btn-light-blue btn-square', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
					/*onClick: function(argument) {
						console.log(argument);
						alert('Look in console!');
					}*/
				}, ],
				center: true, //Center Modal Box?
				autoclose: false, //Auto Close Modal Box?
				callback: null, //Callback Function after close Modal (ex: function(result){alert(result);})
				onShow: function(r) {
					console.log(r);
				}, //After show Modal function
				closeClick: true, //Close Modal on click near the box
				closable: true, //If Modal is closable
				theme: 'xenon', //Modal Custom Theme
				animate: true, //Slide animation
				background: 'rgba(0,0,0,0.35)', //Background Color, it can be null
				zIndex: 1050, //z-index
				buttonText: {
					ok: 'OK',
					yes: 'Yes',
					cancel: 'Cancel'
				},
				template: '<div class="modal-box"><div class="modal-inner"><div class="modal-title"><a class="modal-close-btn"></a></div><div class="modal-text"></div><div class="modal-buttons"></div></div></div>',
				_classes: {
					box: '.modal-box',
					boxInner: ".modal-inner",
					title: '.modal-title',
					content: '.modal-text',
					buttons: '.modal-buttons',
					closebtn: '.modal-close-btn'
				}
			});
		});
		//custom2
		$('a#custom2').click(function() {
			modal({
				type: 'inverted', //Type of Modal Box (alert | confirm | prompt | success | warning | error | info | inverted | primary)
				title: 'Message', //Modal Title
				text: 'Simple primary message with custom options and <b>Atlant</b> theme.<br>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.', //Modal HTML Content
				size: 'normal', //Modal Size (normal | large | small)
				buttons: [{
					text: 'OK', //Button Text
					val: 'ok', //Button Value
					eKey: true, //Enter Keypress
					addClass: 'btn-light-blue', //Button Classes (btn-large | btn-small | btn-green | btn-light-green | btn-purple | btn-orange | btn-pink | btn-turquoise | btn-blue | btn-light-blue | btn-light-red | btn-red | btn-yellow | btn-white | btn-black | btn-rounded | btn-circle | btn-square | btn-disabled)
					/*onClick: function(argument) {
						console.log(argument);
						alert('Look in console!');
					}*/
				}, ],
				center: true, //Center Modal Box?
				autoclose: false, //Auto Close Modal Box?
				callback: null, //Callback Function after close Modal (ex: function(result){alert(result);})
				onShow: function(r) {}, //After show Modal function
				closeClick: true, //Close Modal on click near the box
				closable: true, //If Modal is closable
				theme: 'atlant', //Modal Custom Theme
				animate: false, //Slide animation
				background: 'rgba(0,0,0,0.35)', //Background Color, it can be null
				zIndex: 1050, //z-index
				buttonText: {
					ok: 'OK',
					yes: 'Yes',
					cancel: 'Cancel'
				},
				template: '<div class="modal-box"><div class="modal-inner"><div class="modal-title"><a class="modal-close-btn"></a></div><div class="modal-text"></div><div class="modal-buttons"></div></div></div>',
				_classes: {
					box: '.modal-box',
					boxInner: ".modal-inner",
					title: '.modal-title',
					content: '.modal-text',
					buttons: '.modal-buttons',
					closebtn: '.modal-close-btn'
				}
			});
		});
		//custom3
		$('a#custom3').click(function() {
			modal({
				type: 'default', //Type of Modal Box (alert | confirm | prompt | success | warning | error | info | inverted | primary)
				title: 'Message', //Modal Title
				text: 'Simple message with custom options and <b>Reseted</b> theme.', //Modal HTML Content
				//buttons : null,
				theme: 'reseted'
			});
		});
	});
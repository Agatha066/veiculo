/**
 * Validacao de formulario
 * @author Agatha souza
 */

function check(type,valor){

	let v = 0;
	
	if(valor == 150){
		v+=valor
		r=v;
	}
	if(valor == 130){
		v+=valor+r;
		r=v;
	}
	if(valor == 110){
		v+=valor+r;
		r=v;
	}
	if(valor == 0){
		v=0;
		r=v;
	}
	
	return r;
}
function validar()
{

	var cod = "locadora12@email.com"
	
	var r = check();
	
	if(r===0){
		 alert("Obrigado por nenhum dano, volte sempre!")
		 window.location.href = "main"
	}
	else{
		//var valor = parseInt(mec,DECIMAL) + parseInt(rod,DECIMAL) + parseInt(ilu,DECIMAL)
		alert("O valor a ser pago pelo dano é " +r+ " ,pagar via pix com o codigo: " +cod)
		 window.location.href = "main"
	}
}
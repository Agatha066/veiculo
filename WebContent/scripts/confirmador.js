/**
 * Confirmacao de exclusao de um veiculo
 * @author Agatha souza
 */

function confirmar(id){
	let resposta = confirm("Confirmar a exclusão deste veiculo?")
	
	if(resposta === true){
		//alert(id);
		window.location.href = "delete?id=" + id
	}
	else{
		
	}
}
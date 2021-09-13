/**
 * Confirmacao de exclusao de um veiculo
 * @author Agatha souza
 */

function validar(){
	
	let email = frmlocacao.email.value
	let senha = frmlocacao.senha.value
	
	if(email === ""){
		alert("Preencha o campo email")
		frmlocacao.email.focus()
		return false
	}
	else if(senha === ""){
		alert("Preencha o campo senha")
		frmlocacao.senha.focus
		return false
	}
	else{
		document.forms["frmlocacao"].submit()
		//window.location.href = "login?email=" + id +"&senha=" + senha
	}
}
/**
 * validar cliente
 */

function validar(){
	
	let nome = frmlocacao.nome.value
	let cpf = frmlocacao.cpf.value
	let cnh = frmlocacao.cnh.value
	let data = frmlocacao.data.value
	
	if(nome === ""){
		alert("Preencha o campo nome")
		frmlocacao.nome.focus()
		return false
	}
	else if(cpf === ""){
		alert("Preencha o campo cpf")
		frmlocacao.cpf.focus
		return false
	}
	else if(cnh === ""){
		alert("Preencha o campo cnh")
		frmlocacao.cnh.focus
		return false
	}
	else if(data === ""){
		alert("Preencha o campo data")
		frmlocacao.data.focus
		return false
	}
	else{
		document.forms["frmlocacao"].submit()
	}
}
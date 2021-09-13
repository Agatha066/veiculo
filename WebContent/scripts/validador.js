/**
 * Validacao de formulario
 * @author Agatha souza
 */

function validar(){
	
	let placa = document.getElementById("placa").value
	let marca = document.getElementById("marca").value
	let modelo = document.getElementById("modelo").value
	let diaria = document.getElementById("diaria").value
	let estado = document.getElementById("estado").value
	let cor = document.getElementById("cor").value
	let ano = document.getElementById("ano").value
	let id = document.getElementById("id").value
	
	
	if(placa === ""){
		alert("Preencha o campo placa")
		frmlocacao.placa.focus()
		return false
	}
	else if(marca === ""){
		alert("Preencha o campo marca")
		frmlocacao.marca.focus
		return false
	}
	else if(modelo === ""){
		alert("Preencha o campo modelo")
		frmlocacao.modelo.focus()
		return false
	}
	else if(diaria === ""){
		alert("Preencha o campo diaria")
		frmlocacao.diaria.focus()
		return false
	}
	else if(estado === ""){
		alert("Preencha o campo estado")
		frmlocacao.estado.focus()
		return false
	}
	else{
		document.forms["frmlocacao"].submit()
	}
}
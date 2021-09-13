/**
 * Validacao de formulario
 * @author Agatha souza
 */

function validar(){
	
	alert("oi teste");
	
	let nome = document.getElementById("nome").value
	let cpf = document.getElementById("cpf").value
	let veiculo = document.getElementById("veiculo").value
	let dataR = document.getElementById("R").value
	let dataD = document.getElementById("D").value
	let valor = document.getElementById("valor").value
	
	
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
	else if(veiculo === ""){
		alert("Preencha o campo veiculo")
		frmlocacao.veiculo.focus
		return false
	}
	else if(dataR === ""){
		alert("Preencha o campo data retirada")
		frmlocacao.dataR.focus()
		return false
	}
	else if(dataD === ""){
		alert("Preencha o campo data devolucao")
		frmlocacao.dataD.focus()
		return false
	}
	else{

		let resposta = confirm("Voce confirma o pagamento do valor de " + valor + " pelo aluguel?")
		
		if(resposta === true){
			alert("Obrigado, Volte Sempre!")
			document.forms["frmlocacao"].submit()
		}
		else{
			alert("Volte Sempre!");
		}
	}
}
/**
 * Validação de formulário
 */
 
 function validar(){
	let nome = frmItem.nome.value
	let codigo = frmItem.codigo.value
	let valor = frmItem.valor.value
	let quantidade = frmItem.quantidade.value
	
	if(nome ===""){
		alert('Preencha o campo nome')
		frmItem.nome.focus()
		return false
	}
	else if(codigo === ""){
		alert('Preencha o campo código')
		frmItem.codigo.focus
		return false
	}
	else if(valor === ""){
		alert('Preencha o campo valor')
		frmItem.valor.focus
		return false
	}
	else if(quantidade === ""){
		alert('Preencha o campo quantidade')
		frmItem.quantidade.focus
		return false
	}else{
	document.forms["frmItem"].submit()
	}
}
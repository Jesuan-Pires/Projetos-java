/**
 * Confirmação de exclusão
 */
 
 function confirmar(id){
	let resposta = confirm("Confirma exclusão deste item?")
	if(resposta === true){
		//alert(id)
		window.location.href="delete?id=" + id 
	}
}

function errorMsg(){
				Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
 			    text: 'Preencha os campos corretamente!!',
 			    confirmButtonColor: '#BB4E26'
})
}

function errorData(){
				Swal.fire({
  				icon: 'error',
  				title: 'Oops...',
 			    text: 'Coloque uma data valida!!',
 			    confirmButtonColor: '#BB4E26'
})
}

function verificarData(){
	var dataForm = document.getElementById("data").value;
	
	var array_form = dataForm.split("/");
	
	var dia_form = parseInt(array_form[0]);
	var mes_form = parseInt(array_form[1]);
	var ano_form = parseInt(array_form[2]);
	
	
	var ano_atual = new Date().getFullYear;
	var mes_atual = new Date().getMonth;
	var dia_atual = new Date().getDate;

    if (dia_form < dia_atual || mes_form < mes_atual || ano_form <ano_atual) {
        errorData()
    }

}


$(document).ready(function(){
	$("#celular").mask("(00) 00000-0000")
	$("#data").mask("00/00/0000")
})

function toggleMenu() {
    const toggleMenu = document.querySelector('.toggleMenu');
    const navbar = document.querySelector('.navbar');
    toggleMenu.classList.toggle('active')
    navbar.classList.toggle('active')
}



function successMsg(){
				Swal.fire({
  				icon: 'success',
  				title: 'Agendamento Confirmado!',
 			    text: 'Verifique sua caixa de email!',
 			    confirmButtonColor: '#BB4E26'
})
}

function complete(){
	if(nome.value ==""){
		errorMsg();
}else if(email.value ==""){
		errorMsg();
}else if(data.value == ""){
		errorMsg();
}else if(hora.value == ""){
	errorMsg();
}
else{
	successMsg();
}
		
}

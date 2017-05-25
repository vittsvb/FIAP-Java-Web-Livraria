
$(document).ready(function () { 
        $("#idCPF").mask('000.000.000-00');
        $("#idCNPJ").mask('00.000.000/0000-00');
        $("#idCEP").mask('00000-000');
        $("#idIdade").mask('00');
        $("#idPreco").mask("##0.00");
        $("idDesconto").mask('000');
        
    	var preco = $('#preco').text();
        var desconto = $('#desconto').text();
        console.log(preco);
        console.log(desconto);
        var precoFinal = preco - (preco * (desconto/100));
        console.log(precoFinal);
        document.getElementById('precoFinal').innerHTML = precoFinal;
        
 });

function filtro() {
	var input, filter, table, tr, td, i;
	input = document.getElementById("pesquisa");
	filter = input.value.toUpperCase();
	table = document.getElementById("tab");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

function filtroLivro() {
	var input, filter, table, tbody, td, i;
	input = document.getElementById("pesquisa");
	filter = input.value.toUpperCase();
	table = document.getElementById("tab");
	tbody = table.getElementsByTagName("tbody");
	for (i = 0; i < tbody.length; i++) {
		td = tbody[i].getElementsByTagName("td")[1];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tbody[i].style.display = "";
			} else {
				tbody[i].style.display = "none";
			}
		}
	}
}




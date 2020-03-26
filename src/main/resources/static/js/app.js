 var app = (function(){
    var createtable = function(){
        apiclient.getCovid19All(poblar);
    }

    var poblar = (function (res) {
        var countries = JSON.stringify(res.data);
        var lista = JSON.parse(countries)
        $("#table1").empty();
        lista.map(function(element){
            var fila = '<tr class="table-success"> <td>'+ element.country +'</td> <td>'+element.deaths+'</td> <td>'+ element.confirmed +'</td> <td>'+ element.recovered +'</td> </tr>';
            $("#table1").append(fila);
        })

    });
	var createtablebycountry = (function (country) {
        apiclient.getCovid19ByCountry(poblar2,country);
    });
	var poblar2 = (function (regions) {
		console.log(regions);
        var regiones = JSON.stringify(regions.data);
        var lista2 = JSON.parse(regiones);
        var recovered = 0;
		var deaths=0;
        var confirmed = 0;
		console.log(lista2);
		$("#table5").empty();
        lista2.map(function(element){
			console.log(element);
            deaths+=element.deaths;
            recovered+=element.recovered;
            confirmed+=element.confirmed;
            var fila1 = '<tr class="table-success"> <td>'+ element.province +'</td> <td>'+element.confirmed+'</td> <td>'+ element.deaths +'</td> <td>'+ element.recovered +'</td> </tr>';
            $("#table5").append(fila1);
        })
		$("#table2").empty();
        $("#table2").append('<tr class="table-success"> <td>Num Deaths</td> <td>'+deaths+'</td> </tr>');
        $("#table2").append('<tr class="table-success">> <td>Num Infected</td> <td>'+confirmed+'</td> </tr>');
        $("#table2").append('<tr class="table-success">> <td>Num Cured</td> <td>'+recovered+'</td> </tr>');

    });
return{
        createtable:createtable,
		createtablebycountry:createtablebycountry
    }
})();

window.onload=app.createtable;	
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
return{
        createtable:createtable
    }
})();

window.onload=app.createtable;	
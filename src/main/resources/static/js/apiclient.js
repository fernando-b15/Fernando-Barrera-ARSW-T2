  var apiclient = ( function () {

    var getCovid19All = (function (callback) {

        axios({
            method: 'GET',
            url: '/getAllCases',

        })
            .then(response => callback(response))
            .catch(error => console.log(error));
    });

    var getCovid19ByCountry = (function (callback,country) {
        axios({
            method: 'GET',
            url: '/getAllCases/getCasesByCountry/'+country,

        })
            .then(response => callback(response))
            .catch(error => console.log(error));
    })

    return{
        getCovid19All:getCovid19All,
        getCovid19ByCountry:getCovid19ByCountry
    }
})();
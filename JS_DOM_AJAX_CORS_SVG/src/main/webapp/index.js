

var countryPath = document.getElementsByTagName("path");

initListeners();
var countryCode = "";

function initListeners() {
    for (var i = 0; i < countryPath.length; i++) {

        countryPath[i].addEventListener("click", function (e) {
            fetchCountryInfo(e.target.id);

        }, false);
        countryPath[i].addEventListener("click", function (a) {
            setColor(a.target.id);
        }, false);
          countryPath[i].addEventListener("mouseout", function (a) {
            resetColor(a.target.id);
        }, false);
    }
}
function fetchCountryInfo(cid) {



    fetch("http://restcountries.eu/rest/v1/alpha?codes=" + cid.substring(0, 2)).then(function (response) {

        response.text().then(function (text) {


            var myJSON = text;

            var myObj = JSON.parse(myJSON);
            for (var i = 0; i < myObj.length; i++) {
                document.getElementById("show").innerHTML = "<li>Country:  " + myObj[i].name + "</li><li>Population:  "
                        + myObj[i].population + "</li><li>Area:  " + myObj[i].area + "</li><li>Borders:  " + myObj[i].borders;

            }
        });
    }
    );
}
;
function setColor(a) {
    document.getElementById(a).style.fill = "lightgreen";
 

};
function resetColor(a) {
    document.getElementById(a).style.fill = "#c0c0c0";
 

};
var markers = [];
var path;
var places;
function addMarkers(data, map){
    if(data!=null){
        var pathCoordinates = [];
        var locations = data.split(",");
        for(var i = 0; i < locations.length; i++){
            var infowindow = new google.maps.InfoWindow();
            var innerData = locations[i].split(";");
            var myLatLng = new google.maps.LatLng(innerData[1],innerData[2]);
            var marker = new google.maps.Marker({
                position: myLatLng,
                map:map,
                title:innerData[0]
            });

            markers.push(marker);

            pathCoordinates[i]=markers[i].position;

            path = new google.maps.Polyline({
                path: pathCoordinates,
                strokeColor: 'green',
                strokeOpacity: 1.0,
                strokeWeight: 2
            });

            path.setMap(map);
            //Creates the event listener for clicking the marker
            //and places the marker on the map
            google.maps.event.addListener(marker, 'click', (function(marker,  i) {
                return function() {
                    infowindow.setContent(innerData[0]);
                    infowindow.open(map, marker);
                }
            })(marker, i));

            map.panTo(myLatLng);
        }

        pathCoordinates[locations.length]=markers[0].position;

        path = new google.maps.Polyline({
            path: pathCoordinates,
            strokeColor: '#0066ff',
            strokeOpacity: 1.0,
            strokeWeight: 2
        });

        path.setMap(map);
    }
    localStorage.setItem("data", null);
}

function doAjax() {
    var inputText = $("#city option:selected").text();

    $.ajax({
        url : 'routes/get',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : ({
            city: inputText
        }),
        success: function (request) {
            data = request.coordinates;
            var temp=[];
            var places = [];
            $("#recomended").empty();
            for(var i = 0; i < data.length; i++){
                temp.push(data[i].name +';'+[data[i].x]+";"+data[i].y);
                places.push(request.places[i].id + ";" + request.places[i].photo + ";"+ request.places[i].name)
            }
            localStorage.setItem("data", temp);
            localStorage.setItem("places", places);
            localStorage.setItem("l", data.length);
        }

    });
}

function initialize() {
    var myLatlng = new google.maps.LatLng(-25.363882,131.044922);
    var mapOptions = {
        zoom: 11,
        center: myLatlng
    }
    var map = new google.maps.Map(document.getElementById('customMap'), mapOptions);
    addMarkers(localStorage.getItem("data"),map);

}

$(document).ready(function(){
    var places = localStorage.getItem("places").split(",");
    for(var i = 0; i < localStorage.getItem("l"); i++){
        var place = places[i].split(";");
        $("#recomended").append('<div class="col-md-4">' +
            '<div class="thumb">'+
            '<a class="hover-img" href="place?id='+place[0]+'">'+
            ' <img src="'+ place[1] +'" alt="Image Alternative text" title="Gaviota en el Top">'+
            '<div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">'+
            '<div class="text-small">'+
            ' <h5>'+place[2]+'</h5>'+
            '</div>'+
            '</div>'+
            '</a>'+
            '</div>'+
            '</div>');
    }
});
google.maps.event.addDomListener(window, 'load', initialize);

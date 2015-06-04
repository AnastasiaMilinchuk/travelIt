
function addMarkers(data, map){
    if(data!=null){
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
    for(var i = 0; i < data.length; i++){
        temp.push('<h4>'+ data[i].name +'</h4>;'+[data[i].x]+";"+data[i].y);
    }
    localStorage.setItem("data", temp);
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

google.maps.event.addDomListener(window, 'load', initialize);

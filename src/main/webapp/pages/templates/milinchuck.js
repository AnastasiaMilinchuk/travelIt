var map;
var marker;
var geocoder;
var x;
var myLatlng;
var placeSearch, autocomplete;
function initialize() {
//getLocation();
    autocomplete = new google.maps.places.Autocomplete(
        /** @type {HTMLInputElement} */(document.getElementById('autocomplete')),
        {types: ['geocode']});
    var mapOptions = {
        zoom: 7,
        center: new google.maps.LatLng(50.331436330838834, 30.41015625)

    };
    geocoder = new google.maps.Geocoder();
    map = new google.maps.Map(document.getElementById('map-canvas'),
        mapOptions);

    google.maps.event.addListener(map, 'click', function (event) {
        x = document.getElementById("coordinates");
        clearMarker();
        x.innerHTML = "Lat/LNG: " + event.latLng;
        marker = new google.maps.Marker({
            position: event.latLng,
            map: map
        })

    })
}

function codeAddress() {
    var address = document.getElementById('autocomplete').value;
    geocoder.geocode({'address': address}, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            clearMarker();
            x = document.getElementById("coordinates");
            map.setCenter(results[0].geometry.location);
            map.setZoom(11);
            marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
            x.innerHTML = "Lat/LNG: " + results[0].geometry.location;
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}

function clearMarker() {
    if (marker != null) {
        marker.setMap(null);
    }
}

//function getLocation() {
//    if (navigator.geolocation) {
//        navigator.geolocation.getCurrentPosition(showPosition);
//    } else {
//        x.innerHTML = "Geolocation is not supported by this browser.";
//    }
//}
//function showPosition(position) {
//myLatlng= new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
//	marker = new google.maps.Marker({
//               position: position,
//               map: map
//           });
//
//    x.innerHTML = "Latitude: " + position.coords.latitude +
//    "<br>Longitude: " + position.coords.longitude;
//}

// [START region_geolocation]
// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var geolocation = new google.maps.LatLng(
                position.coords.latitude, position.coords.longitude);
            var circle = new google.maps.Circle({
                center: geolocation,
                radius: position.coords.accuracy
            });
            autocomplete.setBounds(circle.getBounds());
        });
    }
}
// [END region_geolocation]

google.maps.event.addDomListener(window, 'load', initialize);

$( document ).ready( function(){
$('#add-place').click(function() {
//    alert("olol");
//    initialize();
 google.maps.event.trigger(map, 'resize');
});
    }
);
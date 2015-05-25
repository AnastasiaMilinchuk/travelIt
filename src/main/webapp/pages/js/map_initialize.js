/**
 * Created by bubble on 24.05.15.
 */
function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var myLatLng = new google.maps.LatLng(50.447585, 30.452310);
    var mapOptions = {
        center: myLatLng,
        zoom: 10,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };

    var map = new google.maps.Map(mapCanvas, mapOptions);

    if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var pos = new google.maps.LatLng(position.coords.latitude,
                position.coords.longitude);

            map.setCenter(pos);
        }, function() {
            handleNoGeolocation(true);
        });
    } else {
        // Browser doesn't support Geolocation
        handleNoGeolocation(false);
    }
}
google.maps.event.addDomListener(window, 'load', initialize);
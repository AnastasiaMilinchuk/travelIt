<div class="map">

<div id="panel">
    <!--<input id="address" type="textbox" value="Киев">-->
    <input type="button" value="Geocode" onclick="codeAddress()"/>
    <input id="autocomplete" placeholder="Enter your address"
           onFocus="geolocate()" type="text"/>

    <p id="coordinates"></p>
</div>
<br>

<div id="map-canvas"></div>
</div>

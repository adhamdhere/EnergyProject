function initialize() {
    initAutocomplete();
  }

// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">



function initAutocomplete() {
    
    
    var polyOptions = {
        strokeWeight: 3,
        strokeColor: '#000000',
        fillColor: '#90ee90',
        fillOpacity: 0.60,
        editable: true,
        draggable: true
    };

    var i = 0;
    var drawingManager;
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 40.674, lng: -73.945},
        
        styles: [
            {
                "featureType": "all",
                "elementType": "all",
                "stylers": [
                    {
                        "saturation": -100
                    },
                    {
                        "gamma": 0.5
                    }
                ]
            },
            {
                "featureType": "all",
                "elementType": "geometry",
                "stylers": [
                    {
                        "visibility": "on"
                    }
                ]
            },
            {
                "featureType": "administrative.country",
                "elementType": "geometry.fill",
                "stylers": [
                    {
                        "visibility": "on"
                    }
                ]
            },
            {
                "featureType": "administrative.country",
                "elementType": "labels.text",
                "stylers": [
                    {
                        "color": "#e90303"
                    }
                ]
            },
            {
                "featureType": "landscape.man_made",
                "elementType": "geometry.fill",
                "stylers": [
                    {
                        "visibility": "on"
                    },
                    {
                        "saturation": "-4"
                    }
                ]
            },
            {
                "featureType": "landscape.man_made",
                "elementType": "geometry.stroke",
                "stylers": [
                    {
                        "visibility": "on"
                    },
                    {
                        "color": "#000000"
                    },
                    {
                        "saturation": "66"
                    },
                    {
                        "lightness": "-92"
                    },
                    {
                        "gamma": "1.76"
                    },
                    {
                        "weight": "0.20"
                    }
                ]
            },
            {
                "featureType": "landscape.man_made",
                "elementType": "labels.text",
                "stylers": [
                    {
                        "visibility": "off"
                    }
                ]
            },
            {
                "featureType": "poi",
                "elementType": "labels",
                "stylers": [
                    {
                        "visibility": "off"
                    }
                ]
            },
            {
                "featureType": "poi.attraction",
                "elementType": "labels.icon",
                "stylers": [
                    {
                        "visibility": "off"
                    }
                ]
            },
            {
                "featureType": "poi.business",
                "elementType": "labels.text",
                "stylers": [
                    {
                        "visibility": "on"
                    },
                    {
                        "color": "#db6f6f"
                    },
                    {
                        "weight": "0.01"
                    },
                    {
                        "lightness": "9"
                    }
                ]
            },
            {
                "featureType": "poi.business",
                "elementType": "labels.icon",
                "stylers": [
                    {
                        "visibility": "simplified"
                    }
                ]
            },
            {
                "featureType": "poi.park",
                "elementType": "geometry.fill",
                "stylers": [
                    {
                        "visibility": "on"
                    },
                    {
                        "color": "#b74a4a"
                    },
                    {
                        "gamma": "1.23"
                    },
                    {
                        "weight": "0.32"
                    },
                    {
                        "saturation": "17"
                    },
                    {
                        "lightness": "40"
                    }
                ]
            },
            {
                "featureType": "transit",
                "elementType": "labels",
                "stylers": [
                    {
                        "visibility": "off"
                    }
                ]
            },
            {
                "featureType": "water",
                "elementType": "geometry.fill",
                "stylers": [
                    {
                        "visibility": "on"
                    },
                    {
                        "saturation": "40"
                    },
                    {
                        "color": "#434343"
                    }
                ]
            }
        ]
    });
        
    // Create the search box and link it to the UI element.
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function() {
        searchBox.setBounds(map.getBounds());
    });

    var markers = [];
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.

    searchBox.addListener('places_changed', function() {

        i = i + 1;

        var places = searchBox.getPlaces();
        if (places.length == 0) {
        return;
        }

        // Clear out the old markers.
        markers.forEach(function(marker) {
        marker.setMap(null);
        });
        markers = [];

        // For each place, get the icon, name and location.
        var bounds = new google.maps.LatLngBounds();
        var search_coords;
        places.forEach(function(place) {
        if (!place.geometry) {
            console.log("Returned place contains no geometry");
            return;
        }
        var icon = {
            url: place.icon,
            size: new google.maps.Size(71, 71),
            origin: new google.maps.Point(0, 0),
            anchor: new google.maps.Point(17, 34),
            scaledSize: new google.maps.Size(25, 25)
        };

        // Create a marker for each place.
        markers.push(new google.maps.Marker({
            map: map,
            icon: icon,
            title: place.name,
            position: place.geometry.location
        }));

        if (place.geometry.viewport) {
            // Only geocodes have viewport.
            bounds.union(place.geometry.viewport);
            //console.log(place.geometry.location.lat);
        } else {
            
            bounds.extend(place.geometry.location);
        }
        search_coords = place.geometry.location.toJSON();     
        });
        map.fitBounds(bounds);



        drawingManager = new google.maps.drawing.DrawingManager({
        drawingMode: google.maps.drawing.OverlayType.MARKER,
        drawingControl: i==1?true:false,
        drawingControlOptions: {
            position: google.maps.ControlPosition.BOTTOM_CENTER,
            drawingModes: ['polygon']
        },
        polygonOptions: polyOptions,
        markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
        });
        drawingManager.setMap(map);


        var addy = searchBox.getPlaces()
        var result = {
            "locationCoordinate": search_coords,
            "address": addy[0]['formatted_address'],
            "coordinate" : [],
            "area": null
        }

    
        
        google.maps.event.addListener(drawingManager, 'overlaycomplete', function(event) {
        if (event.type == 'polygon') {
            var newShape = event.overlay;
            newShape.type = event.type;

            var arr = newShape.getPath(map);
            arr = arr.getArray();
            for (var i = 0; i < arr.length; i++) {
                var json = arr[i].toJSON();
                result['coordinate'].push(json);
            }
            var area = google.maps.geometry.spherical.computeArea(newShape.getPath());
            result['area'] = area;
            console.log(result);
        }
        });
        
    });
  
  
}
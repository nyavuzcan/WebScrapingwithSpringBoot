package main.java.com.openhere.sahibinden.Controllers;

import main.java.com.openhere.Location.LocationServices.LocationOperators;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.Responses.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/openhere/geolocation")
public class LocationController {
  @Autowired
  LocationOperators locationOperators;
  @PostMapping(value = "/getGeoLocatinFromGoogleFree", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressResponse> getGeoLocationGoogleFree(@RequestBody KordinatRequest kordinatRequest){
    return locationOperators.inquireAddressFromGoogleFree(kordinatRequest);
      }


}

package main.java.com.openhere.Location.LocationServiceImpl;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import main.java.com.openhere.Location.LocationServices.LocationOperators;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.Responses.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class LocationOperatorsImpl implements LocationOperators {


  @Override
  public ResponseEntity<AddressResponse> inquireAddressFromGoogleFree(KordinatRequest kordinatRequest) throws IOException {
    WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage("https://developers.google.com/maps/documentation/geocoding/intro#place-id");


    return null;
  }
}

package main.java.com.openhere.Location.LocationServices;

import com.jaunt.ResponseException;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.Responses.AddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface LocationOperators {
  ResponseEntity<AddressResponse> inquireAddressFromGoogleFree(KordinatRequest kordinatRequest) throws IOException, ResponseException;
}

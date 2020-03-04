package main.java.com.openhere.Zingat.Controller;

import com.jaunt.ResponseException;
import main.java.com.openhere.Location.LocationServices.LocationOperators;
import main.java.com.openhere.Zingat.Entity.KiralikDukkan;
import main.java.com.openhere.Zingat.Repository.ZingatKiralikDukkanRepo;
import main.java.com.openhere.Zingat.Service.ZingatOperators;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.Responses.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/zingat")

public class ZingatController {

    @Autowired
    ZingatOperators zingatOperators;
    @GetMapping(value = "/dukkan")
    public void  inquireZingatKiralikDukkan() throws IOException {
       zingatOperators.saveKiralikDukkan();
    }


  }



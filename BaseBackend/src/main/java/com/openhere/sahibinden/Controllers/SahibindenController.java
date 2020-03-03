package main.java.com.openhere.sahibinden.Controllers;

import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.SahibindenDevrenSatilikDukkan;
import main.java.com.openhere.sahibinden.service.SahibindenDukkanOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/openhere/sahibinden")
public class SahibindenController {

  @Autowired
  private SahibindenDukkanOperators sahibindenDukkanOperators;

  @GetMapping(value = "/inquireDevrenKiralikDukkanlar")
  public ResponseEntity<SahibindenDevrenSatilikDukkan> devrenSatilikDukkanResponse(){
    sahibindenDukkanOperators.inquireSahibindenDevrenSatilikDukkan();
    return null;
  }
}

package main.java.com.openhere.sahibinden.service;

import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.SahibindenDevrenSatilikDukkan;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SahibindenDukkanOperators {
  ResponseEntity<SahibindenDevrenSatilikDukkan> inquireSahibindenDevrenSatilikDukkan() throws IOException;

}

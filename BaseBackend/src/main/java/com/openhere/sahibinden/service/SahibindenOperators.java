package main.java.com.openhere.sahibinden.service;


import main.java.com.openhere.sahibinden.RequestStructures.SatilikDaireDetay;
import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SahibindenOperators {
  ArrayList<SatilikDaireEntity> inquireSatilikDaire(String baseUrl, String totalPage) throws IOException;
  SatilikDaireDetay inquireSatilikDaireDetay(String baseUrl) throws  IOException;
  String inquireSatilikDaireDetayAciklama(String baseUrl) throws  IOException;
  List<String> inquireSatilikDaireDetayAciklamaOzellikler(String baseUrl) throws IOException;
}

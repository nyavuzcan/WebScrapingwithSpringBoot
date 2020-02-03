package main.java.com.openhere.sahibinden.service;


import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;

import java.io.IOException;
import java.util.ArrayList;

public interface SahibindenOperators {
  ArrayList<SatilikDaireEntity> inquireSatilikDaire(String baseUrl, String totalPage) throws IOException;
}

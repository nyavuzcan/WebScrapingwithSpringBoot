package main.java.com.openhere.sahibinden.service;


import main.java.com.openhere.sahibinden.RequestStructures.SatilikDaireDetay;
import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;
import org.jsoup.nodes.Document;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SahibindenOperators {
 List<SatilikDaireEntity> inquireSatilikDaire(String baseUrl, String totalPage) throws IOException;
  SatilikDaireDetay inquireSatilikDaireDetay(Document doc) throws  IOException;
  String inquireSatilikDaireDetayAciklama(Document doc) throws  IOException;
  List<String> inquireSatilikDaireDetayAciklamaOzellikler(Document doc) throws IOException;
}

package main.java.com.openhere.sahibinden.serviceImp;


import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;
import main.java.com.openhere.sahibinden.service.SahibindenOperators;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
@Service
public class SahibindenOperatorsImp implements SahibindenOperators {

  @Override
  public ArrayList<SatilikDaireEntity> inquireSatilikDaire(String baseUrl, String totalPage) throws IOException {
    final ArrayList<SatilikDaireEntity> satilikDaires = new ArrayList<>();
    //https://www.sahibinden.com/satilik?pagingOffset=1000
    int temptotalPage = Integer.parseInt(totalPage);
    for (int i = 0; i < temptotalPage; i++) {
      int temp = (temptotalPage * 20) - 20;
      Document doc = Jsoup.connect(baseUrl + "?pagingOffset=" + temp).get();
      //tr içindeki td elemanlarının 1.elemanınını aldı > hem önünde hem arkasında 1 boşuk bulunmalı.
      Elements titleElements = doc.select("tbody.searchResultsRowClass > tr.searchResultsItem > td");


      SatilikDaireEntity satilikDaire = new SatilikDaireEntity();
      for (Element element : titleElements) {

        if (!element.getElementsByClass("searchResultsTitleValue leafContent").isEmpty()) {

          satilikDaire.setIlanBaslik(element.text());
        } else if (!element.getElementsByClass("searchResultsAttributeValue").isEmpty()) {
          if (Objects.isNull(satilikDaire.getIlanAlan())) {
            satilikDaire.setIlanOdaSayisi(element.text());
          }
          satilikDaire.setIlanAlan(element.text());

        } else if (!element.getElementsByClass("searchResultsPriceValue").isEmpty()) {
          satilikDaire.setIlanIlanFiyat(element.text());
        } else if (!element.getElementsByClass("searchResultsDateValue").isEmpty()) {
          satilikDaire.setIlanTarihi(element.text());
        } else if (!element.getElementsByClass("searchResultsLocationValue").isEmpty()) {
          satilikDaire.setIlanIlIlce(element.text());
          satilikDaires.add(satilikDaire);
          satilikDaire = new SatilikDaireEntity();

        }

      }
    }

    return satilikDaires;
  }
}

package main.java.com.openhere.sahibinden.serviceImp;

import main.java.com.openhere.sahibinden.RequestStructures.SatilikDaireDetay;
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
import java.util.List;
import java.util.Objects;
@Service
public class SahibindenOperatorsImp implements SahibindenOperators {
  public final static String baseUrl="https://www.sahibinden.com";

  @Override
  public List<String> inquireSatilikDaireDetayAciklamaOzellikler(String baseUrl) throws IOException {
    Document doc = Jsoup.connect(baseUrl).get();
    Elements titleElements = doc.select("div.uiBox > div[id=classifiedProperties] > ul > li.selected");
    List<String> listeElement= titleElements.eachText();

    return listeElement;
  }

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
        if(!element.getElementsByClass("searchResultsLargeThumbnail").isEmpty()){
         // inquireSatilikDaireDetayAciklama(this.baseUrl+element.children().attr("href"));
          inquireSatilikDaireDetayAciklamaOzellikler(this.baseUrl+element.children().attr("href"));
          SatilikDaireDetay satilikDaireDetay = new SatilikDaireDetay();
          satilikDaire.setIlanDetayLink(this.baseUrl+element.children().attr("href"));
       satilikDaire.setSatilikDaireDetay(inquireSatilikDaireDetay(satilikDaire.getIlanDetayLink()));

        }
       else if (!element.getElementsByClass("searchResultsTitleValue leafContent").isEmpty()) {

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

  @Override
  public String inquireSatilikDaireDetayAciklama(String baseUrl) throws IOException {

    Document doc = Jsoup.connect(baseUrl).get();
    Element element = doc.getElementById("classifiedDescription");

    return element.text();
  }

  @Override
  public SatilikDaireDetay inquireSatilikDaireDetay(String baseUrl) throws IOException {

    Document doc = Jsoup.connect(baseUrl).get();
    Elements elements = doc.getElementsByAttributeValueContaining("class","classifiedInfo ");

    Elements childelements = elements.get(1).children();

      SatilikDaireDetay satilikDaireDetay = new SatilikDaireDetay();

    for(Element element: childelements){

      String txt = element.select("span").text();

      switch (element.elementSiblingIndex()){

        case 0:
          satilikDaireDetay.setIlanNo(txt);
          continue;

        case 1:
          satilikDaireDetay.setIlanTarih(txt);
          continue;

        case 2:
          satilikDaireDetay.setEmlakTipi(txt);
          continue;

        case 3:
          satilikDaireDetay.setmBrut(txt);
          continue;
        case 4:
          satilikDaireDetay.setmNet(txt);
          continue;

        case 5:
            satilikDaireDetay.setOdaSayisi(txt);
          continue;

        case 6:
            satilikDaireDetay.setBinaYasi(txt);
          continue;

        case 7:
            satilikDaireDetay.setBulunduguKat(txt);
          continue;

        case 8:
            satilikDaireDetay.setKatSayisi(txt);
          continue;

        case 9:
            satilikDaireDetay.setIsitma(txt);
          continue;

        case 10:
            satilikDaireDetay.setBanyoSayisi(txt);
          continue;

        case 11:
          satilikDaireDetay.setBalkon(txt);
          continue;

        case 12:
          satilikDaireDetay.setEsyali(txt);
          continue;

        case 13:
          satilikDaireDetay.setKullanimDurumu(txt);
          continue;

        case 14:
          satilikDaireDetay.setSiteIcerisinde(txt);
          continue;

        case 15:
          satilikDaireDetay.setAidat(txt);
          continue;

        case 16:
          satilikDaireDetay.setKrediyeUygun(txt);
          continue;

        case 17:
          satilikDaireDetay.setKimden(txt);
          continue;

        case 18:
          satilikDaireDetay.setTakas(txt);
          continue;

      }
      System.out.println(element.select("span").text());




    }

    return satilikDaireDetay;
  }
}

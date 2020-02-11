package main.java.com.openhere.sahibinden.serviceImp;

import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.RequestStructures.SatilikDaireDetay;
import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;
import main.java.com.openhere.sahibinden.entity.SatilikDaireİstanbulEntity;
import main.java.com.openhere.sahibinden.repository.SatilikDaireRepo;
import main.java.com.openhere.sahibinden.service.SahibindenOperators;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class SahibindenOperatorsImp implements SahibindenOperators {
    private String agent1="Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private String agent2="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36";
    private String agent3="Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";
    private String agent4="Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36";
    private String agent5="Opera/9.80 (Windows NT 6.1; WOW64) Presto/2.12.388 Version/12.18";
    private String agent6="Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6";
    private String agent7="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36 OPR/47.0.2631.39";
    private String agent8="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.125 YaBrowser/17.7.1.791 Yowser/2.5 Safari/537.36";
    private String agent9="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 YaBrowser/17.9.1.768 Yowser/2.5 Safari/537.36";
    public List<String> agentList=new ArrayList<String>();
  @Autowired
  SatilikDaireRepo satilikDaireRepo;
  public final static String baseUrl = "https://www.sahibinden.com";
  public String inquireAgent(){
    int sayi = (int)(Math.random()*9);

    agentList.add(agent1);
    agentList.add(agent2);
    agentList.add(agent3);
    agentList.add(agent4);
    agentList.add(agent5);
    agentList.add(agent6);
    agentList.add(agent7);
    agentList.add(agent8);
    agentList.add(agent9);

  //  return agentList.get(sayi);
    return "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.87 Safari/537.36";
  }

  @Override
  public List<String> inquireSatilikDaireDetayAciklamaOzellikler(Document doc) throws IOException {


        Elements titleElements = doc.select("div.uiBox > div[id=classifiedProperties] > ul > li.selected");
        List<String> listeElement = titleElements.eachText();

        return listeElement;




  }

  @Override
  public List<SatilikDaireEntity> inquireSatilikDaire(String baseUrl, String totalPage) throws IOException {
    final ArrayList<SatilikDaireEntity> satilikDaires = new ArrayList<>();

    int temptotalPage = Integer.parseInt(totalPage);
    temptotalPage++;
    for (int i = 1; i < temptotalPage; i++) {
    /*  try {
        int sayi = (int)(Math.random()*120);
        sayi+=60;
        TimeUnit.SECONDS.sleep(sayi);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }*/
      int temp = (i * 20) - 20;
      String agent= this.inquireAgent();

      while(true) {
        try {
          Document doc = Jsoup.connect(baseUrl + "?pagingOffset=" + temp).userAgent(agent).get();
          Elements titleElements = doc.select("tbody.searchResultsRowClass > tr.searchResultsItem > td");
          SatilikDaireDetay satilikDaireDetay = new SatilikDaireDetay();
          SatilikDaireİstanbulEntity satilikDaire = new SatilikDaireİstanbulEntity();
          for (Element element : titleElements) {

            if (!element.getElementsByClass("searchResultsLargeThumbnail").isEmpty()) {
              Document document = Jsoup.connect(SahibindenOperatorsImp.baseUrl + element.children().attr("href")).userAgent(agent).get();
              String detayAciklama = inquireSatilikDaireDetayAciklama(document);
            List<String> satilikDaireOzelliklerlist = inquireSatilikDaireDetayAciklamaOzellikler(document);

              satilikDaire.setIlanDetayLink(SahibindenOperatorsImp.baseUrl + element.children().attr("href"));

              satilikDaireDetay = inquireSatilikDaireDetay(document);

              satilikDaireDetay.setIlanDetayOzellikleri(satilikDaireOzelliklerlist);
              satilikDaireDetay.setIlanAciklama(detayAciklama);

              satilikDaire.setSatilikDaireDetay(satilikDaireDetay);

              satilikDaireDetay = new SatilikDaireDetay();

            } else if (!element.getElementsByClass("searchResultsTitleValue leafContent").isEmpty()) {

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
              satilikDaireRepo.save(satilikDaire);
              satilikDaires.add(satilikDaire);

              satilikDaire = new SatilikDaireİstanbulEntity();

              /*
               */

            }

          }
          break;

        }

        catch (HttpStatusException | UnknownHostException e) {
          try {
            int sayi = (int)(Math.random()*120);
            sayi+=60;
            TimeUnit.SECONDS.sleep(sayi);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
          if (false) throw e;
        }
      }


      //tr içindeki td elemanlarının 1.elemanınını aldı > hem önünde hem arkasında 1 boşuk bulunmalı.






    }


    return satilikDaires;
  }

  @Override
  public String inquireSatilikDaireDetayAciklama(Document doc) throws IOException {

        Element element = doc.getElementById("classifiedDescription");
        return element.text();

  }

  @Override
  public SatilikDaireDetay inquireSatilikDaireDetay(Document doc) throws IOException {
    String agent= this.inquireAgent();
/*    try {
      int sayi = (int)(Math.random()*60);
      sayi+=60;
      TimeUnit.SECONDS.sleep(sayi);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/



        Elements elements = doc.getElementsByAttributeValueContaining("class", "classifiedInfo ");

        Elements childelements = elements.get(1).children();

        SatilikDaireDetay satilikDaireDetay = new SatilikDaireDetay();

        satilikDaireDetay.setKordinatRequest(new KordinatRequest(doc.getElementById("gmap").attr("data-lat"),doc.getElementById("gmap").attr("data-lon")));
        for (Element element : childelements) {

          String txt = element.select("span").text();

          switch (element.elementSiblingIndex()) {

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

package main.java.com.openhere.sahibinden.serviceImp;

import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.DetaySahibindenDevrenSatilikDukkan;
import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.LinkSahibindenDevrenSatilikDukkan;
import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.SahibindenDevrenSatilikDukkan;
import main.java.com.openhere.sahibinden.repository.LinkRepos.SahibindenDevrenSatilikDukkanLink;
import main.java.com.openhere.sahibinden.repository.SahibindenDevrenSatilikDukkanRepo;
import main.java.com.openhere.sahibinden.service.PaginationSahibinden;
import main.java.com.openhere.sahibinden.service.SahibindenDukkanOperators;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class SahibindenDukkanOperatorsImpl implements SahibindenDukkanOperators {
  private String totalPage;
  public final static String baseUrl = "https://www.sahibinden.com";
  @Autowired
  private SahibindenDevrenSatilikDukkanRepo sahibindenDevrenSatilikDukkanRepo;
  @Autowired
  private SahibindenDevrenSatilikDukkanLink sahibindenDevrenSatilikDukkanLink;
  @Autowired
  PaginationSahibinden pagination;
  @Override
  public ResponseEntity<SahibindenDevrenSatilikDukkan> inquireSahibindenDevrenSatilikDukkan() throws IOException {
        final List<LinkSahibindenDevrenSatilikDukkan> linkSahibindenDevrenSatilikDukkans = sahibindenDevrenSatilikDukkanLink.findAll();
        for (LinkSahibindenDevrenSatilikDukkan dukkan : linkSahibindenDevrenSatilikDukkans){
          this.totalPage= pagination.getLastPage(dukkan.getLink());

          this.inquireDukkanSahibindenDevrenSatilik(dukkan.getLink(),this.totalPage);

        }

    return null;
  }
  public String inquireDetayText(Document doc){
    Element element = doc.getElementById("classifiedDescription");
    return element.text();
  }
  public List<String> inquireDukkanSelectedItems(Document doc) throws IOException {


    Elements titleElements = doc.select("div.uiBox > div[id=classifiedProperties] > ul > li.selected");
    List<String> listeElement = titleElements.eachText();

    return listeElement;

  }

  public DetaySahibindenDevrenSatilikDukkan inquireDetay(Document doc) throws IOException{
    Elements elements = doc.getElementsByAttributeValueContaining("class", "classifiedInfo ");

    Elements childelements = elements.get(1).children();

    DetaySahibindenDevrenSatilikDukkan detay = new DetaySahibindenDevrenSatilikDukkan();
    detay.setKordinatRequest(new KordinatRequest(doc.getElementById("gmap").attr("data-lat"),doc.getElementById("gmap").attr("data-lon")));
      detay.setAdres(doc.getElementsByClass("classifiedInfo ").get(0).getElementsByTag("h3").get(0).text());
    for (Element element : childelements){

    }

    return detay;
  }


  public void inquireDukkanSahibindenDevrenSatilik(String baseUrl, String totalPage){
    final ArrayList<SahibindenDevrenSatilikDukkan> satilikDukkans = new ArrayList<>();
    int temptotalPage = Integer.parseInt(totalPage);

    temptotalPage++;
    if (temptotalPage==1)
      temptotalPage=2;
    for (int i = 1; i < temptotalPage; i++) {
      int temp = (i * 20) - 20;
      while (true){
        try {
          Document doc = Jsoup.connect(baseUrl + "?pagingOffset=" + temp).get();
          Elements titleElements = doc.select("tbody.searchResultsRowClass > tr.searchResultsItem > td");
          if (titleElements.size()==0) break;
          DetaySahibindenDevrenSatilikDukkan detaySahibindenDevrenSatilikDukkan = new DetaySahibindenDevrenSatilikDukkan();
          SahibindenDevrenSatilikDukkan sahibindenDevrenSatilikDukkan = new SahibindenDevrenSatilikDukkan();

          for(Element element : titleElements){

            if (!element.getElementsByClass("searchResultsLargeThumbnail").isEmpty()){
              UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).

              userAgent.visit(this.baseUrl+element.children().attr("href"));

              Document dc= Jsoup.parse(userAgent.doc.innerHTML());
              String detayAciklama = inquireDetayText(dc);
              List<String> dukkanselectedItems = inquireDukkanSelectedItems(dc);

              sahibindenDevrenSatilikDukkan.setLink(this.baseUrl+element.children().attr("href"));


              sahibindenDevrenSatilikDukkan.setDetaySahibindenDevrenSatilikDukkan(inquireDetay(doc));

            }

          }
        }

        catch (ResponseException | IOException e ) {
          try {
            int sayi = (int)(Math.random()*120);
            sayi+=60;
            TimeUnit.SECONDS.sleep(sayi);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
          if (false) try {
            throw e;
          } catch (ResponseException ex) {
            ex.printStackTrace();
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      }



    }


  }
}

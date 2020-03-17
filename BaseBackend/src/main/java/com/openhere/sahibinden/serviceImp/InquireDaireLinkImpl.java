package main.java.com.openhere.sahibinden.serviceImp;

import main.java.com.openhere.sahibinden.service.InquireDaireLink;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InquireDaireLinkImpl implements InquireDaireLink {
  @Override
  public void InquireDaireLinkAll(String baseUrl) {
    final  String sahibindenUrl="https://www.sahibinden.com";
    List<String> konutCesitlist = new ArrayList<>();
    try {
      Document doc = Jsoup.connect(baseUrl).get();
    Elements linkelemets= doc.select("li.cl3 >a");
    for(Element element : linkelemets){
      element.attr("href");
      konutCesitlist.add(sahibindenUrl+element.attr("href"));
    }
    for (String forSehir : konutCesitlist){
      Document docucmentSehir = Jsoup.connect(forSehir).get();
      Element linkelementsSehir=    docucmentSehir.select("dd.address-selector > ul > li >a").first();
      Elements scriptTags = doc.getElementsByTag("script");

    }



    }   catch (HttpStatusException | UnknownHostException e) {
      e.printStackTrace();

    } catch (IOException e) {

    }

  }
}

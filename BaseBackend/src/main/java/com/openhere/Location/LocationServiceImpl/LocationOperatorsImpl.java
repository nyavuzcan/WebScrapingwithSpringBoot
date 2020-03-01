package main.java.com.openhere.Location.LocationServiceImpl;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import main.java.com.openhere.Location.LocationServices.LocationOperators;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.Responses.AddressResponse;
import main.java.com.openhere.sahibinden.entity.EczaneİstanbulEntity;
import main.java.com.openhere.sahibinden.repository.EczaneRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class LocationOperatorsImpl implements LocationOperators {
  @Autowired
  EczaneRepo eczaneRepo;

  @Override
  public ResponseEntity<AddressResponse> inquireAddressFromGoogleFree(KordinatRequest kordinatRequest) throws IOException, ResponseException {

/*
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    WebDriver web =new ChromeDriver();
    String baseUrl = "http://www.hastanebul.com.tr/istanbul-eczaneler";
    web.get(baseUrl);
*/
  Document basedoc= Jsoup.connect("https://www.istanbulnobetcieczaneler.com/arsiv/").get();

 Elements options= basedoc.getElementsByTag("option");
 options.remove(0);
  for (Element option : options){
   Document arsivDoc= Jsoup.connect("https://www.istanbulnobetcieczaneler.com/arsiv/"+option.val()).get();
   String sayfa= arsivDoc.select("body > div.container > div.container-fluid > strong:nth-child(7) > i").text();
  Integer count =  Integer.parseInt(sayfa)/10+1;
  for (int j =1 ; j<count+1; j++){

    Document sct = Jsoup.connect("https://www.istanbulnobetcieczaneler.com/nobetarsiv.php?nTarih="+option.val()+"&page="+j).get();
    Element element =  sct.getElementsByClass("table table-hover table-bordered table-striped table-condensed").first();
    Elements x=element. getElementsByAttribute("href");
    for (int z=0; z<x.size()/2; z++){
      x.remove(z);

    }
    for (Element e : x){

      Document inside = Jsoup.connect("https://www.istanbulnobetcieczaneler.com"+ e.getElementsByAttribute("href") .attr("href")).get();

      EczaneİstanbulEntity eczaneİstanbulEntity = new EczaneİstanbulEntity();
      eczaneİstanbulEntity.setAd(inside.getElementsByTag("h2").get(1).text());
      eczaneİstanbulEntity.setAdres( inside.select("#harita > div > div > div:nth-child(1) > div > table > tbody > tr:nth-child(1) > td:nth-child(3)").text());

      if(inside.getElementsByTag("tbody").get(1).getElementsByTag("tr").size()==2){

        eczaneİstanbulEntity.setTelefon(inside.select("#harita > div > div > div:nth-child(1) > div > table > tbody > tr:nth-child(2) > td:nth-child(3)").text());

      }else {
        eczaneİstanbulEntity.setTelefon(inside.select("#harita > div > div > div:nth-child(1) > div > table > tbody > tr:nth-child(3) > td:nth-child(3)").text());

      }

      String lat = inside.getElementsByAttributeValue("name","enlem").first().attr("value");
      String lot = inside.getElementsByAttributeValue("name","boylam").first().attr("value");
      eczaneİstanbulEntity.setKordinatRequest(new KordinatRequest(lat,lot));
      eczaneİstanbulEntity.setTarih(option.val());
      eczaneRepo.save(eczaneİstanbulEntity);
    }

  }



  }




/*    ArrayList<String> listem= new ArrayList<>();
    Document doc = Jsoup.connect("http://www.treczane.com/istanbul-eczaneleri.htm").get();
    Element titleElements = doc.getElementsByTag("tbody").get(1);
    Elements elements=   titleElements.getElementsByAttribute("href");
    for(Element a: elements){
      listem.add(a.attr("href")) ;

      Document document = Jsoup.connect(a.attr("href")).get();
      Element td= document.getElementsByTag("table").get(1);
  Elements tdx =    td.getElementsByTag("td");
     for (Element tdsing : tdx){
      String ilce = document.getElementsByTag("h3").get(0).text();
     String[] array=  ilce.split(" ");


       EczaneİstanbulEntity eczaneİstanbulEntity = new EczaneİstanbulEntity();
       eczaneİstanbulEntity.setAd(tdsing.getElementsByTag("b").text());
       eczaneİstanbulEntity.setAdres(  tdsing.getElementsByTag("p").get(0).text().replace(tdsing.getElementsByTag("b").get(0).text(),""));
      eczaneİstanbulEntity.setIlce(array[0]);
       eczaneRepo.save(eczaneİstanbulEntity);





     }*/



/*

    while (true){
      elements.remove(0);

      EczaneİstanbulEntity eczaneİstanbulEntit = new EczaneİstanbulEntity();

      eczaneİstanbulEntit.setIlce(elements.get(0).text());
      eczaneİstanbulEntit.setAd(elements.get(1).text());
      eczaneİstanbulEntit.setTelefon(elements.get(2).text());
      eczaneİstanbulEntit.setAdres(elements.get(3).text());
      elements.remove(0);
      elements.remove(0);
      elements.remove(0);
      elements.remove(0);
      eczaneRepo.save(eczaneİstanbulEntit);

      continue;

    }


*/

/*    WebClient webClient = new WebClient();
    final HtmlPage page = webClient.getPage("http://locationiq.com/");

   HtmlElement htmlElement = (HtmlElement) page.getByXPath("//*[@id=\"reverse-latitude\"]").get(0);

    htmlElement.setAttribute("value",kordinatRequest.getLat());
    UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).

    userAgent.visit("https://developers.google.com/maps/documentation/geocoding/intro");
    Document dc= Jsoup.parse(userAgent.doc.innerHTML());
    dc.getElementById("query-input");
   *//* HtmlElement button= (HtmlElement) page.getFirstByXPath("//*[@id=\"geocode-button\"]");
    HtmlPage pagex= button.click();
    pagex.getByXPath("//*[@id=\"result-0\"]/table/tbody/tr/td[2]/p[1]");
*/

  return null;
  }
}

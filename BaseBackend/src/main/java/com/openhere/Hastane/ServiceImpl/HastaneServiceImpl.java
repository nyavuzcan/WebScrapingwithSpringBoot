package main.java.com.openhere.Hastane.ServiceImpl;

import main.java.com.openhere.Hastane.Entity.HastaneEntity;
import main.java.com.openhere.Hastane.Entity.IstanbulAileHekimligiLinkEntity;
import main.java.com.openhere.Hastane.Repository.HastaneRepo;
import main.java.com.openhere.Hastane.Repository.IstanbulAileHekimligiLinkRepo;
import main.java.com.openhere.Hastane.Service.HastaneService;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@Service
public class HastaneServiceImpl implements HastaneService {
  @Autowired
  HastaneRepo hastaneRepo;
  @Autowired
  IstanbulAileHekimligiLinkRepo istanbulAileHekimligiLinkRepo;

  @Override
  public void SaveGuncelHastane() throws IOException {
    String kurumAdiSelecto="#hastane > div:nth-child(1) > span.value";
    String hastaneLat ="#hastane > span > span:nth-child(1)";
    String hastlots="#hastane > span > span:nth-child(2)";
    try {
      Document document = Jsoup.connect("https://www.trhastane.com/istanbul-hastaneleri.htm").get();
      Elements elements =   document.getElementById("ilceler").getElementsByTag("a");
      elements.remove(0);
      for (Element element : elements){
       String link  = element.attr("href");
       Document single = Jsoup.connect(link).get();
       Elements sayfalar = single.getElementsByClass("leftdiv").get(1).getElementsByTag("a");
       if (!single.getElementsByClass("pagination center").isEmpty()){
         link.replace("htm","-2.htm");
         Document docT=  Jsoup.connect(link).get();
         Elements yenisayfaalr = single.getElementsByClass("leftdiv").get(1).getElementsByTag("a");
         for (Element sayfa  : yenisayfaalr){
           Document docTx=  Jsoup.connect(sayfa.attr("href")).get();


           HastaneEntity hastaneEntity = new HastaneEntity();
           hastaneEntity.setKordinatRequest(new KordinatRequest( docTx.select(hastaneLat).text(),  docTx.select(hastlots).text()));
           hastaneEntity.setHastaneAdi(docTx.select(kurumAdiSelecto).text());
           Thread.sleep(3000);
      hastaneRepo.save(hastaneEntity);
         }
       }
        //2.sayfa kontrolü pagination center
        for (Element sayfa  : sayfalar){

        Document docT=  Jsoup.connect(sayfa.attr("href")).get();


          HastaneEntity hastaneEntity = new HastaneEntity();
          hastaneEntity.setKordinatRequest(new KordinatRequest( docT.select(hastaneLat).text(),  docT.select(hastlots).text()));
          hastaneEntity.setHastaneAdi(docT.select(kurumAdiSelecto).text());
          System.out.println(hastaneEntity.getHastaneAdi());
        hastaneRepo.save(hastaneEntity);
          Thread.sleep(3000);
        }

      }
    }catch (Exception i) {
      System.out.println(i);
    }
  }

  @Override
  public void saveHastane() {
    IstanbulAileHekimligiLinkEntity istanbulAileHekimligiLinkEntity = new IstanbulAileHekimligiLinkEntity();

    try {
     Document document = Jsoup.connect("http://www.istanbulhastaneleri.net/saglik-ocaklari.html").get();
     Elements elements =  document.getElementsByClass("health_center").first().getElementsByTag("li");

    int i =0;
      for (Element element : elements){
     String link  =  element.getElementsByTag("a").attr("href");
      istanbulAileHekimligiLinkEntity.setLink(link);
      String [] dizi = element.getElementsByTag("a").get(i).text().split(" ");
      istanbulAileHekimligiLinkEntity.setIlce(dizi[0]);
      i++;
      }
    } catch (Exception e) {

    }
  }

  @Override
  public void saveHastaneDifferent() throws IOException {
    ArrayList<HastaneEntity> hastaneEntities = new ArrayList<>();
    for (int i = 1 ; i<=41; i++){

      Document document = Jsoup.connect("https://www.hastane.com.tr/istanbul-hastaneleri-sayfa-"+i+".html").get();
      Elements elements =  document.getElementsByClass("MainLink");

       for (Element element : elements){
        element.getElementsByClass("MainLink").first();
         String hastaneLink ="https://www.hastane.com.tr"+element.getElementsByTag("a").attr("href");
         Document insideDoc = Jsoup.connect(hastaneLink).get();

       String  hastaneAdi= insideDoc.select("#ContentPlaceHolder1_fvHospital > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(2)").text();
        String tel = insideDoc.select("#ContentPlaceHolder1_fvHospital > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td:nth-child(2)").text();
      String a = insideDoc.select("#ContentPlaceHolder1_fvHospital > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(4) > td:nth-child(2)").text();
      String b = insideDoc.select("#ContentPlaceHolder1_fvHospital > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(5) > td:nth-child(2)").text();
       String c = insideDoc.select("#ContentPlaceHolder1_fvHospital > tbody > tr > td > table > tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(6) > td:nth-child(2)").text();

       String adres = a+" "+b+" "+c;

         HastaneEntity hastaneEntity = new HastaneEntity();

         hastaneEntity.setAdres(adres);
         hastaneEntity.setHastaneAdi(hastaneAdi);
         hastaneEntity.setTel(tel);
         hastaneEntities.add(hastaneEntity);
       }



    }
      for (int i = 0 ; i<hastaneEntities.size(); i++){
        if (!hastaneEntities.get(i).getAdres().contains("İstanbul")){
          hastaneEntities.remove(i);
        }
      }
      hastaneRepo.saveAll(hastaneEntities);
  }
}
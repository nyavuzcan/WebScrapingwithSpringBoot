package main.java.com.openhere.Zingat.ServiceImpl;

import main.java.com.openhere.Zingat.Entity.KiralikDukkan;
import main.java.com.openhere.Zingat.Entity.KiralikDukkanDetay;
import main.java.com.openhere.Zingat.Entity.Link;
import main.java.com.openhere.Zingat.Repository.ZingatKiralikDukkanRepo;
import main.java.com.openhere.Zingat.Repository.ZingatLinkRepo;
import main.java.com.openhere.Zingat.Service.ZingatKiralikDukkanService;
import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class ZingatKiralikDukkanImpl implements ZingatKiralikDukkanService {
  @Autowired
  ZingatKiralikDukkanRepo zingatKiralikDukkanRepo;
  @Autowired
  ZingatLinkRepo zingatLinkRepo;

  @Override
  public Integer getTotalpage(Link link) throws IOException {
    Document document = Jsoup.connect(link.getLink()).get();
    String value = document.getElementsByClass("result-number").first().text();
   Integer totalPage=  Integer.parseInt(value);
   if (totalPage==0) return null;
   if (totalPage <=21) return 1;
   if (totalPage >21) return totalPage/21 +1;
   return 1;

  }

  @Override
  public void saveKiralikDukkan() throws IOException {
    Integer totalPage;
    List<Link> linkList = inquireZingatLink();
    for (Link link : linkList){
    totalPage =  getTotalpage(link);
    if (Objects.isNull(totalPage)) continue;
      for (int i = 1 ; i<= totalPage ; i++){
         String newUrl = link.getLink()+"&page="+i;
         Document document = Jsoup.connect(newUrl).get();
      Elements elements =  document.getElementsByAttributeValue("data-locid","1");
            for (Element element : elements){
               String ilanLink ="https://www.zingat.com/"+element.getElementsByTag("figure").get(0).getElementsByTag("a").get(0).attr("href");
               String fiyat =  element.getElementsByClass("price").first().text();
              String baslik = element.getElementsByClass("listing-title-wrapper").first().text();
              String adres = element.getElementsByClass("location-name").get(0).text()+" "+ element.getElementsByClass("location-name").get(1).text();

             Document detayDocument =  Jsoup.connect(ilanLink).get();
        KiralikDukkanDetay kiralikDukkanDetay =     getKiralikDukkanDetay(detayDocument);
      KiralikDukkan kiralikDukkan = new KiralikDukkan();
      kiralikDukkan.setKiralikDukkanDetay(kiralikDukkanDetay);
      kiralikDukkan.setFiyat(fiyat);
      kiralikDukkan.setIlanLink(ilanLink);
      kiralikDukkan.setBaslik(baslik);
      kiralikDukkan.setAdres(adres);
              zingatKiralikDukkanRepo.save(kiralikDukkan);
            }

      }


    }


  }
  public KiralikDukkanDetay getKiralikDukkanDetay(Document detayDocument){
    Elements elements =  detayDocument.getElementsByClass("row attribute-detail-list").first().getElementsByClass("col-md-6");
    String brutAlan = null;
    String odaSayisi = null;
    String bulunduguKat = null;
    for(Element element : elements){

      if (Objects.nonNull(element.getElementsByTag("strong").first())){
        if (element.getElementsByTag("strong").first().text().equals("m²") && Objects.isNull(brutAlan)) {  brutAlan  = element.getElementsByTag("span").first().text();}
        if (element.getElementsByTag("strong").first().text().equals("Bölüm/Oda Sayısı") && Objects.isNull(odaSayisi))  {  odaSayisi  = element.getElementsByTag("span").first().text();}
        if (element.getElementsByTag("strong").first().text().equals("Binadaki Kat Sayısı") && Objects.isNull(bulunduguKat))  {  bulunduguKat  = element.getElementsByTag("span").first().text();}

      }

    }
    String lat = detayDocument.getElementById("details").attr("data-lat");
    String lot = detayDocument.getElementById("details").attr("data-lon");

    KordinatRequest kordinatRequest = new KordinatRequest(lat,lot);

    KiralikDukkanDetay kiralikDukkanDetay = new KiralikDukkanDetay();
    kiralikDukkanDetay.setKordinatRequest(kordinatRequest);
    kiralikDukkanDetay.setBrutAlan(brutAlan);
    kiralikDukkanDetay.setOdaSayisi(odaSayisi);
    kiralikDukkanDetay.setBulunduguKat(bulunduguKat);

  return kiralikDukkanDetay;



  }
  public void saveKiralikDukkanEntity(KiralikDukkan kiralikDukkan){
    zingatKiralikDukkanRepo.save(kiralikDukkan);
  }


public List<Link> inquireZingatLink(){
 return zingatLinkRepo.findAll();
}
}

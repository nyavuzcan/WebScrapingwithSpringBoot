package main.java.com.openhere.Hastane.ServiceImpl;

import main.java.com.openhere.Hastane.Entity.IstanbulAileHekimligiLinkEntity;
import main.java.com.openhere.Hastane.Repository.HastaneRepo;
import main.java.com.openhere.Hastane.Repository.IstanbulAileHekimligiLinkRepo;
import main.java.com.openhere.Hastane.Service.HastaneService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HastaneServiceImpl implements HastaneService {
  @Autowired
  HastaneRepo hastaneRepo;
  @Autowired
  IstanbulAileHekimligiLinkRepo istanbulAileHekimligiLinkRepo;

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
}
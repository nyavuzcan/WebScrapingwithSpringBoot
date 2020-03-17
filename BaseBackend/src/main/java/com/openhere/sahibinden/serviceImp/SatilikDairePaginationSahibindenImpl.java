package main.java.com.openhere.sahibinden.serviceImp;


import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import main.java.com.openhere.sahibinden.service.PaginationSahibinden;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Configurable
public class SatilikDairePaginationSahibindenImpl implements PaginationSahibinden {

  @Override
  public String getLastPage(String baseUrl) throws IOException {

    int count = 0;
    int maxTries = 300;
    while(true) {
      try {
        UserAgent userAgent = new UserAgent();                       //create new userAgent (headless browser).

        userAgent.visit(baseUrl);
        Document doc= Jsoup.parse(userAgent.doc.innerHTML());

        Elements titleElements = doc.select("ul.pageNaviButtons > li");

        if (titleElements.size()==0)
          return "0";
        int temp = titleElements.last().elementSiblingIndex();

        Element element =  titleElements.get(temp-1);

        return element.text();
      } catch (ResponseException e) {
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
          int sayi = (int)(Math.random()*120);
          sayi+=60;
          try {
            TimeUnit.SECONDS.sleep(sayi);
          } catch (InterruptedException exc) {
            exc.printStackTrace();
          }
        }
      }
    }


  }
}

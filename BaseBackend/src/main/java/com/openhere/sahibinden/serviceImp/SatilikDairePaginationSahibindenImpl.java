package main.java.com.openhere.sahibinden.serviceImp;


import main.java.com.openhere.sahibinden.service.PaginationSahibinden;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Configurable
public class SatilikDairePaginationSahibindenImpl implements PaginationSahibinden {

  @Override
  public String getLastPage(String baseUrl) throws IOException {
    Document doc = Jsoup.connect(baseUrl).get();
    Elements titleElements = doc.select("ul.pageNaviButtons > li");

    int temp = titleElements.last().elementSiblingIndex();
    Element element =  titleElements.get(temp-1);

    return element.text();
  }
}

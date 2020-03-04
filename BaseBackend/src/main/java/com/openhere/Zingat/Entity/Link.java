package main.java.com.openhere.Zingat.Entity;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "ZingatKiralikDukkanLink")
public class Link {
  private String link;
  private String ilce;

  public String getIlce() {
    return ilce;
  }

  public void setIlce(String ilce) {
    this.ilce = ilce;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}

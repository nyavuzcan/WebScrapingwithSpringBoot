package main.java.com.openhere.Zingat.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Zingat_Kiralik_Dükkanlar")
public class KiralikDukkan {
  private String ilanLink;
  private String baslik;
  private String fiyat;
  private String adres;

  private KiralikDukkanDetay kiralikDukkanDetay;

  public String getIlanLink() {
    return ilanLink;
  }

  public void setIlanLink(String ilanLink) {
    this.ilanLink = ilanLink;
  }

  public String getBaslik() {
    return baslik;
  }

  public void setBaslik(String baslik) {
    this.baslik = baslik;
  }

  public String getFiyat() {
    return fiyat;
  }

  public void setFiyat(String fiyat) {
    this.fiyat = fiyat;
  }

  public String getAdres() {
    return adres;
  }

  public void setAdres(String adres) {
    this.adres = adres;
  }

  public KiralikDukkanDetay getKiralikDukkanDetay() {
    return kiralikDukkanDetay;
  }

  public void setKiralikDukkanDetay(KiralikDukkanDetay kiralikDukkanDetay) {
    this.kiralikDukkanDetay = kiralikDukkanDetay;
  }
}

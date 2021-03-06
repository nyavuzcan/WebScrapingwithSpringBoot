package main.java.com.openhere.sahibinden.entity;

import main.java.com.openhere.sahibinden.RequestStructures.SatilikDaireDetay;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SatilikDaire")
public class SatilikDaireEntity {

  @Id
  private String id;
  private String ilanBaslik;
  private String ilanAlan;
  private String ilanOdaSayisi;
  private String ilanIlanFiyat;
  private String ilanTarihi;
  private String ilanIlIlce;
  private String ilanDetayLink;
  private SatilikDaireDetay satilikDaireDetay;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIlanBaslik() {
    return ilanBaslik;
  }

  public void setIlanBaslik(String ilanBaslik) {
    this.ilanBaslik = ilanBaslik;
  }

  public String getIlanAlan() {
    return ilanAlan;
  }

  public void setIlanAlan(String ilanAlan) {
    this.ilanAlan = ilanAlan;
  }

  public String getIlanOdaSayisi() {
    return ilanOdaSayisi;
  }

  public void setIlanOdaSayisi(String ilanOdaSayisi) {
    this.ilanOdaSayisi = ilanOdaSayisi;
  }

  public String getIlanIlanFiyat() {
    return ilanIlanFiyat;
  }

  public void setIlanIlanFiyat(String ilanIlanFiyat) {
    this.ilanIlanFiyat = ilanIlanFiyat;
  }

  public String getIlanTarihi() {
    return ilanTarihi;
  }

  public void setIlanTarihi(String ilanTarihi) {
    this.ilanTarihi = ilanTarihi;
  }

  public String getIlanIlIlce() {
    return ilanIlIlce;
  }

  public void setIlanIlIlce(String ilanIlIlce) {
    this.ilanIlIlce = ilanIlIlce;
  }

  public SatilikDaireDetay getSatilikDaireDetay() {
    return satilikDaireDetay;
  }

  public void setSatilikDaireDetay(SatilikDaireDetay satilikDaireDetay) {
    this.satilikDaireDetay = satilikDaireDetay;
  }

  public String getIlanDetayLink() {
    return ilanDetayLink;
  }

  public void setIlanDetayLink(String ilanDetayLink) {
    this.ilanDetayLink = ilanDetayLink;
  }

}

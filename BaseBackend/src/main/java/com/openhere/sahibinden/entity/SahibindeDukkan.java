package main.java.com.openhere.sahibinden.entity;

import main.java.com.openhere.sahibinden.entity.BaseEntity.BaseLinkEntity;
import org.springframework.data.mongodb.core.mapping.Document;



public class SahibindeDukkan  extends BaseLinkEntity {
  private String ilanBaslik;
  private String ilanLink;
  private String ilanFiyat;
  private String ilanTarih;
  private String ilİlce;

  public String getIlanBaslik() {
    return ilanBaslik;
  }

  public void setIlanBaslik(String ilanBaslik) {
    this.ilanBaslik = ilanBaslik;
  }

  public String getIlanLink() {
    return ilanLink;
  }

  public void setIlanLink(String ilanLink) {
    this.ilanLink = ilanLink;
  }

  public String getIlanFiyat() {
    return ilanFiyat;
  }

  public void setIlanFiyat(String ilanFiyat) {
    this.ilanFiyat = ilanFiyat;
  }

  public String getIlanTarih() {
    return ilanTarih;
  }

  public void setIlanTarih(String ilanTarih) {
    this.ilanTarih = ilanTarih;
  }

  public String getIlİlce() {
    return ilİlce;
  }

  public void setIlİlce(String ilİlce) {
    this.ilİlce = ilİlce;
  }
}

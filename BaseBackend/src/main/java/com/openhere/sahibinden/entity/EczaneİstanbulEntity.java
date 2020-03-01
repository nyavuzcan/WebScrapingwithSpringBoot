package main.java.com.openhere.sahibinden.entity;

import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import main.java.com.openhere.sahibinden.entity.BaseEntity.BaseLinkEntity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tarih_istanbulnobetcieczaneler.com")
public class EczaneİstanbulEntity extends BaseLinkEntity {
  private String İlce;
  private String Ad;
  private String Telefon;
  private String Adres;
  private KordinatRequest kordinatRequest;
  private String Tarih;

  public String getTarih() {
    return Tarih;
  }

  public void setTarih(String tarih) {
    Tarih = tarih;
  }

  public KordinatRequest getKordinatRequest() {
    return kordinatRequest;
  }

  public void setKordinatRequest(KordinatRequest kordinatRequest) {
    this.kordinatRequest = kordinatRequest;
  }

  public String getIlce() {
    return İlce;
  }

  public void setIlce(String ilce) {
    İlce = ilce;
  }

  public String getAd() {
    return Ad;
  }

  public void setAd(String ad) {
    Ad = ad;
  }

  public String getTelefon() {
    return Telefon;
  }

  public void setTelefon(String telefon) {
    Telefon = telefon;
  }

  public String getAdres() {
    return Adres;
  }

  public void setAdres(String adres) {
    Adres = adres;
  }

}

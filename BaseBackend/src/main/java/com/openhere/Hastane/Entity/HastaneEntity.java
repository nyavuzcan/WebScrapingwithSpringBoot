package main.java.com.openhere.Hastane.Entity;

import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Güncel_Hastaneler")
public class HastaneEntity {
  private String hastaneAdi;
  private String adres;
 private String tel;
 private KordinatRequest kordinatRequest;

  public KordinatRequest getKordinatRequest() {
    return kordinatRequest;
  }

  public void setKordinatRequest(KordinatRequest kordinatRequest) {
    this.kordinatRequest = kordinatRequest;
  }

  public String getHastaneAdi() {
    return hastaneAdi;
  }

  public void setHastaneAdi(String hastaneAdi) {
    this.hastaneAdi = hastaneAdi;
  }

  public String getAdres() {
    return adres;
  }

  public void setAdres(String adres) {
    this.adres = adres;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}

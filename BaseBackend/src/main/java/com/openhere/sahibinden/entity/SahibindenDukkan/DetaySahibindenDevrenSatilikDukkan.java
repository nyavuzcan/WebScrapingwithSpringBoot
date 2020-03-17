package main.java.com.openhere.sahibinden.entity.SahibindenDukkan;

import main.java.com.openhere.sahibinden.RequestStructures.KordinatRequest;

import java.util.List;

public class DetaySahibindenDevrenSatilikDukkan {
  private String Adres;

  public String getAdres() {
    return Adres;
  }

  public void setAdres(String adres) {
    Adres = adres;
  }

  public String getIlanNo() {
    return ilanNo;
  }

  public void setIlanNo(String ilanNo) {
    this.ilanNo = ilanNo;
  }

  public String getKategori() {
    return kategori;
  }

  public void setKategori(String kategori) {
    this.kategori = kategori;
  }

  public String getDurumu() {
    return durumu;
  }

  public void setDurumu(String durumu) {
    this.durumu = durumu;
  }

  public String getTipi() {
    return tipi;
  }

  public void setTipi(String tipi) {
    this.tipi = tipi;
  }

  public String getIsitma() {
    return isitma;
  }

  public void setIsitma(String isitma) {
    this.isitma = isitma;
  }

  public String getAlan() {
    return alan;
  }

  public void setAlan(String alan) {
    this.alan = alan;
  }

  public String getKimden() {
    return kimden;
  }

  public void setKimden(String kimden) {
    this.kimden = kimden;
  }

  public String getTakas() {
    return takas;
  }

  public void setTakas(String takas) {
    this.takas = takas;
  }

  public String getDukkandurumu() {
    return dukkandurumu;
  }

  public void setDukkandurumu(String dukkandurumu) {
    this.dukkandurumu = dukkandurumu;
  }

  public String getAciklama() {
    return aciklama;
  }

  public void setAciklama(String aciklama) {
    this.aciklama = aciklama;
  }

  public List<String> getIlanDetayOzellikleri() {
    return ilanDetayOzellikleri;
  }

  public void setIlanDetayOzellikleri(List<String> ilanDetayOzellikleri) {
    this.ilanDetayOzellikleri = ilanDetayOzellikleri;
  }

  public String getIlanAciklama() {
    return ilanAciklama;
  }

  public void setIlanAciklama(String ilanAciklama) {
    this.ilanAciklama = ilanAciklama;
  }

  public KordinatRequest getKordinatRequest() {
    return kordinatRequest;
  }

  public void setKordinatRequest(KordinatRequest kordinatRequest) {
    this.kordinatRequest = kordinatRequest;
  }

  private String ilanNo;
  private String kategori;
  private String durumu;
  private String tipi;
  private String isitma;
  private String alan;
  private String kimden;
  private String takas;
  private String dukkandurumu;
  private String aciklama;
  private List<String> ilanDetayOzellikleri;
  private String ilanAciklama;
  private KordinatRequest kordinatRequest;

}

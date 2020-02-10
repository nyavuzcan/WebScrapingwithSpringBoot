package main.java.com.openhere.sahibinden.dto;

import java.util.List;

public class SehirCesit {
  private String sehirCesitLink;
  private List<İlceCesit> i̇lceCesitList;

  public String getSehirCesitLink() {
    return sehirCesitLink;
  }

  public void setSehirCesitLink(String sehirCesitLink) {
    this.sehirCesitLink = sehirCesitLink;
  }

  public List<İlceCesit> getİlceCesitList() {
    return i̇lceCesitList;
  }

  public void setİlceCesitList(List<İlceCesit> i̇lceCesitList) {
    this.i̇lceCesitList = i̇lceCesitList;
  }
}

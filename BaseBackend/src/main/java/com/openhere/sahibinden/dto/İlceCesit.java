package main.java.com.openhere.sahibinden.dto;

import java.util.List;

public class İlceCesit {
  private String ilceCesitLink;
  private List<MahalleCesit> mahalleCesitList;

  public String getIlceCesitLink() {
    return ilceCesitLink;
  }

  public void setIlceCesitLink(String ilceCesitLink) {
    this.ilceCesitLink = ilceCesitLink;
  }

  public List<MahalleCesit> getMahalleCesitList() {
    return mahalleCesitList;
  }

  public void setMahalleCesitList(List<MahalleCesit> mahalleCesitList) {
    this.mahalleCesitList = mahalleCesitList;
  }
}

package main.java.com.openhere.sahibinden.entity.SahibindenDukkan;

import main.java.com.openhere.sahibinden.entity.SahibindeDukkan;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SahibindenKiralikDukkan")
public class SahibindenDevrenSatilikDukkan extends SahibindeDukkan {
  private DetaySahibindenDevrenSatilikDukkan detaySahibindenDevrenSatilikDukkan;

  public DetaySahibindenDevrenSatilikDukkan getDetaySahibindenDevrenSatilikDukkan() {
    return detaySahibindenDevrenSatilikDukkan;
  }

  public void setDetaySahibindenDevrenSatilikDukkan(DetaySahibindenDevrenSatilikDukkan detaySahibindenDevrenSatilikDukkan) {
    this.detaySahibindenDevrenSatilikDukkan = detaySahibindenDevrenSatilikDukkan;
  }
}

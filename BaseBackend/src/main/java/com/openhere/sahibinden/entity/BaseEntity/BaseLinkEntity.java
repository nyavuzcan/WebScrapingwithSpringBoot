package main.java.com.openhere.sahibinden.entity.BaseEntity;

import org.springframework.data.annotation.Id;

public class BaseLinkEntity {
  @Id
  private String id;
  private String link;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}

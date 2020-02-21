package main.java.com.openhere.sahibinden.serviceImp;


import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;

import main.java.com.openhere.sahibinden.repository.SatilikDaireRepo;
import main.java.com.openhere.sahibinden.service.InquireDaireLink;
import main.java.com.openhere.sahibinden.service.InquireSatilikDaire;
import main.java.com.openhere.sahibinden.service.PaginationSahibinden;
import main.java.com.openhere.sahibinden.service.SahibindenOperators;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InquireSatilikDaireImpl implements InquireSatilikDaire {

  final static private String baseUrl="https://www.sahibinden.com/kiralik-daire";
  private String totalPage;
  @Autowired
  PaginationSahibinden pagination;
  @Autowired
  SahibindenOperators sahibindenOperators;
  @Autowired
  SatilikDaireRepo satilikDaireRepo;
  @Autowired
  InquireDaireLink inquireDaireLink;

@Override
public void inquireDaireler() throws Exception {


  this.totalPage= pagination.getLastPage(baseUrl);
  final List<SatilikDaireEntity> satilikDaires = sahibindenOperators.inquireSatilikDaire(baseUrl,this.totalPage);
  System.out.println("finish");
  //satilikDaireRepo.saveAll(satilikDaires);


}

  @Override
  public void inquireDairelerLinks() {
  inquireDaireLink.InquireDaireLinkAll("https://www.sahibinden.com/satilik");

  }

  @Override
  public void inquireSahibindenLink() {

  }
}

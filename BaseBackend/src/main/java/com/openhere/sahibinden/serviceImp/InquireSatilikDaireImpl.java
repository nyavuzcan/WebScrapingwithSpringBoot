package main.java.com.openhere.sahibinden.serviceImp;


import main.java.com.openhere.sahibinden.entity.SahibindenLinkEntity;
import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;

import main.java.com.openhere.sahibinden.repository.KiralikDaireLink;
import main.java.com.openhere.sahibinden.repository.SatilikDaireRepo;
import main.java.com.openhere.sahibinden.service.*;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InquireSatilikDaireImpl implements InquireSatilikDaire {
  private String totalPage;

  @Autowired
  KiralikDaireLink kiralikDaireLink;
  @Autowired
  PaginationSahibinden pagination;
  @Autowired
  SahibindenOperators sahibindenOperators;
  @Autowired
  SatilikDaireRepo satilikDaireRepo;
  @Autowired
  InquireDaireLink inquireDaireLink;
  @Autowired
  LinkOperators linkOperators;


@Override
public void inquireDaireler() throws Exception {
 final List<SahibindenLinkEntity> satilikDaireEntities = kiralikDaireLink.findAllByLinkIsNotNull();
  for(SahibindenLinkEntity dairelink : satilikDaireEntities){
    this.totalPage= pagination.getLastPage(dairelink.getLink());
    final List<SatilikDaireEntity> satilikDaires = sahibindenOperators.inquireSatilikDaire(dairelink.getLink(),this.totalPage);
    System.out.println("finish");
  }

  //satilikDaireRepo.saveAll(satilikDaires);


}

  @Override
  public void inquireDairelerLinks() {
  inquireDaireLink.InquireDaireLinkAll("https://www.sahibinden.com/satilik");

  }

  @Override
  public void inquireSahibindenLink() throws InterruptedException {
    linkOperators.inquiereSahibindenLink();
  }
}

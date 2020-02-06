package main.java.com.openhere.sahibinden.serviceImp;


import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;

import main.java.com.openhere.sahibinden.repository.SatilikDaireRepo;
import main.java.com.openhere.sahibinden.service.InquireKiralikDaire;
import main.java.com.openhere.sahibinden.service.PaginationSahibinden;
import main.java.com.openhere.sahibinden.service.SahibindenOperators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class InquireKiralikDaireImpl implements InquireKiralikDaire {
public InquireKiralikDaireImpl(){

}
  final static private String baseUrl="https://www.sahibinden.com/satilik-daire";
  private String totalPage;
  @Autowired
  PaginationSahibinden pagination;
  @Autowired
  SahibindenOperators sahibindenOperators;
  @Autowired
  SatilikDaireRepo satilikDaireRepo;

@Override
public void inquireDaireler() throws Exception {


  this.totalPage= pagination.getLastPage(baseUrl);
  final ArrayList<SatilikDaireEntity> satilikDaires = sahibindenOperators.inquireSatilikDaire(baseUrl,this.totalPage);
  satilikDaireRepo.saveAll(satilikDaires);
  for (SatilikDaireEntity satilikDaire : satilikDaires){

    System.out.println(satilikDaire.getIlanBaslik());
  }


}


}

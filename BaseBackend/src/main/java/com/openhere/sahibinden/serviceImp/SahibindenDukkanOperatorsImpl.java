package main.java.com.openhere.sahibinden.serviceImp;

import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.LinkSahibindenDevrenSatilikDukkan;
import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.SahibindenDevrenSatilikDukkan;
import main.java.com.openhere.sahibinden.repository.LinkRepos.SahibindenDevrenSatilikDukkanLink;
import main.java.com.openhere.sahibinden.repository.SahibindenDevrenSatilikDukkanRepo;
import main.java.com.openhere.sahibinden.service.PaginationSahibinden;
import main.java.com.openhere.sahibinden.service.SahibindenDukkanOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SahibindenDukkanOperatorsImpl implements SahibindenDukkanOperators {
  private String totalPage;
  @Autowired
  private SahibindenDevrenSatilikDukkanRepo sahibindenDevrenSatilikDukkanRepo;
  @Autowired
  private SahibindenDevrenSatilikDukkanLink sahibindenDevrenSatilikDukkanLink;
  @Autowired
  PaginationSahibinden pagination;
  @Override
  public ResponseEntity<SahibindenDevrenSatilikDukkan> inquireSahibindenDevrenSatilikDukkan() throws IOException {
        final List<LinkSahibindenDevrenSatilikDukkan> linkSahibindenDevrenSatilikDukkans = sahibindenDevrenSatilikDukkanLink.findAllByLinkIsNotNull();
        for (LinkSahibindenDevrenSatilikDukkan dukkan : linkSahibindenDevrenSatilikDukkans){
          this.totalPage= pagination.getLastPage(dukkan.getLink());

        }

    return null;
  }
}

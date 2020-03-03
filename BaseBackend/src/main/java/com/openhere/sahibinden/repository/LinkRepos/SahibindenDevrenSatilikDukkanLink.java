package main.java.com.openhere.sahibinden.repository.LinkRepos;

import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.LinkSahibindenDevrenSatilikDukkan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SahibindenDevrenSatilikDukkanLink extends MongoRepository<LinkSahibindenDevrenSatilikDukkan,String> {
  List<LinkSahibindenDevrenSatilikDukkan> findAllByLinkIsNotNull();
}

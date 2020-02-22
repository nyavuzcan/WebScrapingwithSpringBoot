package main.java.com.openhere.sahibinden.repository;

import main.java.com.openhere.sahibinden.entity.SahibindenLinkEntity;
import main.java.com.openhere.sahibinden.entity.SatilikDaireİstanbulEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KiralikDaireLink extends MongoRepository<SahibindenLinkEntity, String> {

  List<SahibindenLinkEntity> findAllByLinkIsNotNull();
}

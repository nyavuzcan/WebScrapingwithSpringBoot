package main.java.com.openhere.sahibinden.repository;

import main.java.com.openhere.sahibinden.entity.SahibindenDukkan.SahibindenDevrenSatilikDukkan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SahibindenDevrenSatilikDukkanRepo extends MongoRepository<SahibindenDevrenSatilikDukkan,String> {

}

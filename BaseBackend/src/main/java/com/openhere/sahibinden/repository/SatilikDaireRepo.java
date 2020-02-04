package main.java.com.openhere.sahibinden.repository;

import main.java.com.openhere.sahibinden.entity.SatilikDaireEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SatilikDaireRepo extends MongoRepository<SatilikDaireEntity, String> {

}


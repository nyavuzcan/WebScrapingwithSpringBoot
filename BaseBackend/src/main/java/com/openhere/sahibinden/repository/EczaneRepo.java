package main.java.com.openhere.sahibinden.repository;

import main.java.com.openhere.sahibinden.entity.EczaneİstanbulEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EczaneRepo extends MongoRepository<EczaneİstanbulEntity, String> {
}

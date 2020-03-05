package main.java.com.openhere.Hastane.Repository;

import main.java.com.openhere.Hastane.Entity.HastaneEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaneRepo extends MongoRepository<HastaneEntity,String> {
}

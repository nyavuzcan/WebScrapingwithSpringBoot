package main.java.com.openhere.Hastane.Repository;

import main.java.com.openhere.Hastane.Entity.HastaneLink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaneLinkRepo extends MongoRepository<HastaneLink,String> {
}

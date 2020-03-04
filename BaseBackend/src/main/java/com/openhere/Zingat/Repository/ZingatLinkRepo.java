package main.java.com.openhere.Zingat.Repository;

import main.java.com.openhere.Zingat.Entity.Link;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZingatLinkRepo extends MongoRepository<Link,String> {
}

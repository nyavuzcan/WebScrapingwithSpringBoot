package main.java.com.openhere.Zingat.Repository;

import main.java.com.openhere.Zingat.Entity.KiralikDukkan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZingatKiralikDukkanRepo  extends MongoRepository<KiralikDukkan,String> {
}

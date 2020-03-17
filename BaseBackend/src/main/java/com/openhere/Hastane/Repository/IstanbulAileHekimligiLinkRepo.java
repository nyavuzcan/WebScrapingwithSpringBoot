package main.java.com.openhere.Hastane.Repository;

import main.java.com.openhere.Hastane.Entity.IstanbulAileHekimligiLinkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstanbulAileHekimligiLinkRepo extends MongoRepository<IstanbulAileHekimligiLinkEntity,String> {
}

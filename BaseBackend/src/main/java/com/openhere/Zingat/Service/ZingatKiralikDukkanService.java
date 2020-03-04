package main.java.com.openhere.Zingat.Service;

import main.java.com.openhere.Zingat.Entity.Link;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface ZingatKiralikDukkanService {
  Integer getTotalpage (Link link) throws IOException;
  void saveKiralikDukkan() throws IOException;
}

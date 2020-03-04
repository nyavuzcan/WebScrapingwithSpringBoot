package main.java.com.openhere.Zingat.ServiceImpl;

import main.java.com.openhere.Zingat.Entity.KiralikDukkan;
import main.java.com.openhere.Zingat.Repository.ZingatKiralikDukkanRepo;
import main.java.com.openhere.Zingat.Service.ZingatKiralikDukkanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZingatKiralikDukkanImpl implements ZingatKiralikDukkanService {
  @Autowired
  ZingatKiralikDukkanRepo zingatKiralikDukkanRepo;
  @Override
  public Integer getTotalpage() {
    return null;
  }

  @Override
  public void saveKiralikDukkan() {

  }


  public void saveKiralikDukkanEntity(KiralikDukkan kiralikDukkan){
    zingatKiralikDukkanRepo.save(kiralikDukkan);
  }
}

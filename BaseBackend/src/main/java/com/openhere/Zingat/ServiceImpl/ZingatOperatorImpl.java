package main.java.com.openhere.Zingat.ServiceImpl;

import main.java.com.openhere.Zingat.Service.ZingatKiralikDukkanService;
import main.java.com.openhere.Zingat.Service.ZingatOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZingatOperatorImpl implements ZingatOperators {
  @Autowired
  ZingatKiralikDukkanService zingatKiralikDukkanService;
  @Override
  public Integer getTotalpage() {

    return   zingatKiralikDukkanService.getTotalpage();
  }

  @Override
  public void saveKiralikDukkan() {
    zingatKiralikDukkanService.saveKiralikDukkan();
  }
}

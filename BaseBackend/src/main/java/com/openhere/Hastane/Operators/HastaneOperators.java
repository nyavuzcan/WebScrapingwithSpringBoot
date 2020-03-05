package main.java.com.openhere.Hastane.Operators;

import main.java.com.openhere.Hastane.Service.HastaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HastaneOperators implements HastaneOperatorsService {
  @Autowired
  HastaneService hastaneService;

  @Override
  public void inquireHastane() {
    hastaneService.saveHastane();
  }
}

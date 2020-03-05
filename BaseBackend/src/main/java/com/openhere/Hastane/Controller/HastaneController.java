package main.java.com.openhere.Hastane.Controller;

import main.java.com.openhere.Hastane.Operators.HastaneOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hastane")
public class HastaneController {

  @Autowired
  HastaneOperators hastaneOperators;

  @GetMapping(value = "/istanbul")
  public void inquireIstabulHastane() {
    hastaneOperators.inquireHastane();
  }

}

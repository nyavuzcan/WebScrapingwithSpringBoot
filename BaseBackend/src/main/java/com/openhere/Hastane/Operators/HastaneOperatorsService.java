package main.java.com.openhere.Hastane.Operators;

import java.io.IOException;

public interface HastaneOperatorsService {
  void inquireHastane();
  void  inquireDifferentHastane() throws IOException;
  void inquireGuncelHastane() throws  IOException;
}

package main.java.com.openhere.Structures.TryCatchRepeat;

abstract class Operation {
  abstract public void doIt();

  public void handleException(Exception cause) {
    //default impl: do nothing, log the exception, etc.
  }
}

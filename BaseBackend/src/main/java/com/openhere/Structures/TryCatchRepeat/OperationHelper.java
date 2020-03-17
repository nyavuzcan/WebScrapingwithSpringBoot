package main.java.com.openhere.Structures.TryCatchRepeat;


public class OperationHelper {
  public  void doWithRetry(Operation operation) {
    while (true) {
      try {
        operation.doIt();
      } catch (Exception e) {
        operation.handleException(e);
      }
    }
  }
}

package main.java.com.openhere.sahibinden.service;

import java.io.IOException;

public interface PaginationSahibinden {
  String getLastPage(String baseUrl) throws IOException;
}

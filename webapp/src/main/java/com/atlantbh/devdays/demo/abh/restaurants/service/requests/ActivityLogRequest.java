package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

import java.util.Date;

public class ActivityLogRequest {

  private String user;

  private String action;

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }
}

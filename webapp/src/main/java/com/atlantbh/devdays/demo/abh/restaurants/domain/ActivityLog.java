package com.atlantbh.devdays.demo.abh.restaurants.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "activitylogs")
public class ActivityLog {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "\"user\"")
  private String user;

  @Column(name = "action")
  private String action;

  @Column(name = "created_at", updatable = false, insertable = false)
  private String created_at;

  public ActivityLog() {}

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getCreatedAt() {
    return created_at;
  }

  public void setCreatedAt(String createdAt) {
    this.created_at = createdAt;
  }
}

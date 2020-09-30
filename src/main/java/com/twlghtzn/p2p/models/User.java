package com.twlghtzn.p2p.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@Table(name = "user")
@NoArgsConstructor
@Entity
public class User {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long dbId;
  private String name;
  private String id;

  public User(String name) {
    this.name = name;
    id = System.getenv("CHAT_APP_UNIQUE_ID");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

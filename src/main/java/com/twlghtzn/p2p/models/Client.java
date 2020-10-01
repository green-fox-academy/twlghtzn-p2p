package com.twlghtzn.p2p.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "clients")
@Entity
public class Client {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;
  private String name;
  private String uniqueId;

  public Client(String name, String uniqueId) {
    this.name = name;
    this.uniqueId = uniqueId;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUniqueId() {
    return uniqueId;
  }

  public void setName(String name) {
    this.name = name;
  }
}

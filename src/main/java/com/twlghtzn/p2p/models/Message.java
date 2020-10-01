package com.twlghtzn.p2p.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "messages")
@Entity
public class Message {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;
  private String userName;
  private String text;
  private long date;
  private long randomId;
  @ManyToOne
  private Client client;

  public Message(long randomId, String userName, String text, long date, Client client) {
    this.randomId = randomId;
    this.userName = userName;
    this.text = text;
    this.date = date;
    this.client = client;
  }

  public long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getText() {
    return text;
  }

  public long getDate() {
    return date;
  }

  public long getRandomId() {
    return randomId;
  }

  public Client getClient() {
    return client;
  }
}

package com.twlghtzn.p2p.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.CascadeType;
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
  @JsonIgnore
  private long id;
  private long randomId;
  private String userName;
  private String text;
  private long date;
  @ManyToOne(cascade = CascadeType.REFRESH)
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

  @JsonProperty("username")
  public String getUserName() {
    return userName;
  }

  public String getText() {
    return text;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @JsonProperty("timestamp")
  public long getDate() {
    return date;
  }

  public Client getClient() {
    return client;
  }

  public void setDate(long date) {
    this.date = date;
  }

  @JsonProperty("id")
  public long getRandomId() {
    return randomId;
  }

  public void setRandomId(long randomId) {
    this.randomId = randomId;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

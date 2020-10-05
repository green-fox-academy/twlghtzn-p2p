package com.twlghtzn.p2p.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "clients")
@Entity
public class Client {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @JsonIgnore
  private long id;
  @JsonIgnore
  private String name;
  private String uniqueId;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.REFRESH)
  private List<Message> messages;

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

  @JsonProperty("id")
  public String getUniqueId() {
    return uniqueId;
  }

  public void setName(String name) {
    this.name = name;
  }
}

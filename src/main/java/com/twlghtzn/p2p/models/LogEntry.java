package com.twlghtzn.p2p.models;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LogEntry {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private LocalDateTime date;
  private String level;
  private String text;
  private String endpoint;
  private String requestType;
  private String requestParams;

  public LogEntry(LocalDateTime date, String level, String text, String endpoint,
                  String requestType, String requestParams) {
    this.date = date;
    this.level = level;
    this.text = text;
    this.endpoint = endpoint;
    this.requestType = requestType;
    this.requestParams = requestParams;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getLevel() {
    return level;
  }

  public String getText() {
    return text;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getRequestType() {
    return requestType;
  }

  public String getRequestParams() {
    return requestParams;
  }
}

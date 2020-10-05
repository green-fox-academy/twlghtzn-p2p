package com.twlghtzn.p2p.models;

public class MessageMissingFieldsResponse extends Response {
  private String status;
  private String message;

  public MessageMissingFieldsResponse(String message) {
    this.status = "error";
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}

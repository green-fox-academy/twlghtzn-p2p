package com.twlghtzn.p2p.models;

public class MessageOkResponse extends Response {
  private String status;

  public MessageOkResponse() {
    this.status = "ok";
  }

  public String getStatus() {
    return status;
  }
}

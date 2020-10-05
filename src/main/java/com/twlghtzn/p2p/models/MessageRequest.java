package com.twlghtzn.p2p.models;

public class MessageRequest {
  private Message message;
  private Client client;

  public MessageRequest(long id, String username, String text, long date,
                        Client client) {
    this.client = new Client(username, client.getUniqueId());
    this.message = new Message(id, username,text, date, this.client);
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

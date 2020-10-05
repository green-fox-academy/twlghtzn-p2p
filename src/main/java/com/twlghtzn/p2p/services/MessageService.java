package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.Client;
import com.twlghtzn.p2p.models.Message;
import com.twlghtzn.p2p.models.MessageMissingFieldsResponse;
import com.twlghtzn.p2p.models.MessageRequest;
import com.twlghtzn.p2p.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
  private MessageRepository messageRepository;
  private final ClientService clientService;

  @Autowired
  public MessageService(MessageRepository messageRepository, ClientService clientService) {
    this.messageRepository = messageRepository;
    this.clientService = clientService;
  }

  public void addNewUserMessage(String text) {
    Client client = clientService.findUserClient();
    messageRepository.save(new Message(generateRandomId(),
        client.getName(), text, System.currentTimeMillis(),
        client));
  }

  public void addNewClientMessage(MessageRequest messageRequest) {
    long newRandomId = messageRequest.getMessage().getRandomId();
    String newUserName = messageRequest.getMessage().getUserName();
    String newText = messageRequest.getMessage().getText();
    long newDate = messageRequest.getMessage().getDate();
    messageRepository.save(new Message(newRandomId, newUserName, newText, newDate, clientService
        .updateClientAddIfNew(messageRequest.getMessage().getUserName(),
            messageRequest.getClient().getUniqueId())));
  }

  public boolean checkIfARequestFieldIsMissing(MessageRequest messageRequest) {
    Message message = messageRequest.getMessage();
    Client client = messageRequest.getClient();
    return message.getRandomId() == 0 || message.getUserName() == null ||
        message.getText() == null ||
        message.getDate() == 0 || client.getUniqueId() == null;
  }

  public String renderMessageField(MessageRequest messageRequest) {
    Message message = messageRequest.getMessage();
    Client client = messageRequest.getClient();
    String responseMessage = "Missing field(s): ";
    if (message.getRandomId() == 0) {
      responseMessage += "message.randomId, ";
    }
    if (message.getUserName() == null) {
      responseMessage += "message.username, ";
    }
    if (message.getText() == null) {
      responseMessage += "message.text, ";
    }
    if (message.getDate() == 0) {
      responseMessage += "message.date, ";
    }
    if (client.getUniqueId() == null) {
      responseMessage += "client.id";
    }
    return responseMessage;
  }

  public MessageMissingFieldsResponse createResponseToRequest(MessageRequest messageRequest) {
    return new MessageMissingFieldsResponse(renderMessageField(messageRequest));
  }

  public long generateRandomId() {
    return (long) (1000000 + Math.random() * 10000000);
  }

  public List<Message> getAllMessages() {
    return messageRepository.findAll();
  }
}

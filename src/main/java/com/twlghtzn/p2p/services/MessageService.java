package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.Client;
import com.twlghtzn.p2p.models.Message;
import com.twlghtzn.p2p.repositories.ClientRepository;
import com.twlghtzn.p2p.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
  private MessageRepository messageRepository;
  private ClientRepository clientRepository;

  @Autowired
  public MessageService(MessageRepository messageRepository, ClientRepository clientRepository) {
    this.messageRepository = messageRepository;
    this.clientRepository = clientRepository;
  }

  public void addNewUserMessage(String text) {
    Client client = clientRepository.findClientByUniqueId(System.getenv("CHAT_APP_UNIQUE_ID"));
    messageRepository.save(new Message(generateRandomId(),
        client.getName(), text, System.currentTimeMillis(),
        client));
  }

  public void addNewClientMessage(long randomId, String userName, String text, long date,
                                  Client client) {
    messageRepository.save(new Message(randomId, userName, text, date, client));
  }

  public long generateRandomId() {
    return (long) (1000000 + Math.random() * 10000000);
  }

  public List<Message> getAllMessages() {
    return messageRepository.findAll();
  }
}

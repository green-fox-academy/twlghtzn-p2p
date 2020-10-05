package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.MessageRequest;
import com.twlghtzn.p2p.repositories.ClientRepository;
import com.twlghtzn.p2p.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestService {
  private MessageService messageService;
  private ClientService clientService;

  @Autowired
  public RestService(MessageService messageService, ClientService clientService) {
    this.messageService = messageService;
    this.clientService = clientService;
  }


}

package com.twlghtzn.p2p.controllers;

import com.twlghtzn.p2p.models.MessageOkResponse;
import com.twlghtzn.p2p.models.MessageRequest;
import com.twlghtzn.p2p.models.Response;
import com.twlghtzn.p2p.services.ClientService;
import com.twlghtzn.p2p.services.LogService;
import com.twlghtzn.p2p.services.MessageService;
import com.twlghtzn.p2p.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {
  private RestService restService;
  private LogService logService;
  private ClientService clientService;
  private MessageService messageService;

  @Autowired
  public MessageController(RestService restService, LogService logService,
                           ClientService clientService, MessageService messageService) {
    this.restService = restService;
    this.logService = logService;
    this.clientService = clientService;
    this.messageService = messageService;
  }

  @PostMapping("/api/message/receive")
  public ResponseEntity<Response> addAMessage(@RequestBody MessageRequest messageRequest) {
    System.out.println(logService.buildLogForReceive(messageRequest));
    if (messageService.checkIfARequestFieldIsMissing(messageRequest)) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body(messageService.createResponseToRequest(messageRequest));
    } else {
      messageService.addNewClientMessage(messageRequest);
      return ResponseEntity.status(HttpStatus.OK).body(new MessageOkResponse());
    }
  }
}

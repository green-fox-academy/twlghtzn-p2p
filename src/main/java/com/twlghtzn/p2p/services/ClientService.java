package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.Client;
import com.twlghtzn.p2p.repositories.ClientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
  private ClientRepository clientRepository;

  @Autowired
  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public void updateClientAddIfNew(String name, String uniqueId) {
    if (getClient(uniqueId).isPresent()) {
      Client client = clientRepository.findClientByUniqueId(uniqueId);
      if (!client.getName().equals(name)) {
        client.setName(name);
        clientRepository.save(client);
      }
    } else {
      clientRepository.save(new Client(name, uniqueId));
    }
  }

  public Optional<Client> getClient(String uniqueId) {
    return clientRepository.findByUniqueId(uniqueId);
  }

}

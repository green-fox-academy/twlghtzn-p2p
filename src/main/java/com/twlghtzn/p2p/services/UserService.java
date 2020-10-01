package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.Client;
import com.twlghtzn.p2p.models.User;
import com.twlghtzn.p2p.repositories.ClientRepository;
import com.twlghtzn.p2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private UserRepository userRepository;
  private ClientRepository clientRepository;

  @Autowired
  public UserService(UserRepository userRepository, ClientRepository clientRepository) {
    this.userRepository = userRepository;
    this.clientRepository = clientRepository;
  }

  public void addUser(String name) {
    userRepository.save(new User(name));
    clientRepository.save(new Client(name, System.getenv("CHAT_APP_UNIQUE_ID")));
  }

  public boolean isUserPresent() {
    return userRepository.count() != 0;
  }

  public void updateUser(String name) {
    User user = userRepository.findUserByUniqueId(System.getenv("CHAT_APP_UNIQUE_ID"));
    user.setName(name);
    userRepository.save(user);
    Client client = clientRepository.findClientByUniqueId(System.getenv("CHAT_APP_UNIQUE_ID"));
    client.setName(name);
    clientRepository.save(client);
  }

  public String getUsersName() {
    return userRepository.findUserByUniqueId(System.getenv("CHAT_APP_UNIQUE_ID")).getName();
  }
}

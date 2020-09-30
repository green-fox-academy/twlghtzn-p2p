package com.twlghtzn.p2p.services;

import com.twlghtzn.p2p.models.User;
import com.twlghtzn.p2p.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void addUser(String name) {
    userRepository.save(new User(name));
  }

  public boolean isUserPresent() {
    return userRepository.findById(1L).isPresent();
  }

  public void updateUser(String name) {
    User user = userRepository.findUserByDbId(1L);
    user.setName(name);
    userRepository.save(user);
  }

  public String getUsersName() {
    return userRepository.findUserByDbId(1L).getName();
  }
}

package com.twlghtzn.p2p.repositories;

import com.twlghtzn.p2p.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findUserByUniqueId(String uniqueId);
}

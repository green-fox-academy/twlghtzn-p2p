package com.twlghtzn.p2p.repositories;

import com.twlghtzn.p2p.models.Message;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

  @Override
  List<Message> findAll();

  Message findMessageById(long id);
}

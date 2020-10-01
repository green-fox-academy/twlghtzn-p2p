package com.twlghtzn.p2p.repositories;

import com.twlghtzn.p2p.models.Client;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

  Optional<Client> findByUniqueId(String uniqueId);

  Client findClientByUniqueId(String uniqueId);
}

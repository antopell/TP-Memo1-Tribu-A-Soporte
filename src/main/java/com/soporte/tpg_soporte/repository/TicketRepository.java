package com.soporte.tpg_soporte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.soporte.tpg_soporte.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String>{
    
}

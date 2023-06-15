package com.soporte.tpg_soporte.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.soporte.tpg_soporte.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String>{
    
    @Query("{cliente:?0}")
    List<Ticket> findByCliente(Long cliente);

    @Query("{producto:?0}")
    List<Ticket> findByProducto(Long producto);
}

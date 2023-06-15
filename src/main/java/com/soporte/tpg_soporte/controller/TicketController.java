package com.soporte.tpg_soporte.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.service.TicketService;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/tickets")
    public Collection<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable String id) {
        Optional<Ticket> ticketOptional = ticketService.findById(id);
        return ResponseEntity.of(ticketOptional);
    }

    @PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @RequestParam String id) {
        Optional<Ticket> ticketOptional = ticketService.findById(id);

        if (!ticketOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ticket.setCodigo(id);
        ticketService.save(ticket);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable String id) {
        ticketService.deleteById(id);
    }
}

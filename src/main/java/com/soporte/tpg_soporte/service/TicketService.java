package com.soporte.tpg_soporte.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        Date date;
        switch (ticket.getSeveridad()) {
            case S1: 
                date = addDays(7); 
                break;
            case S2: 
                date = addDays(30); 
                break;
            case S3: 
                date = addDays(90); 
                break;
            case S4: 
                date = addDays(365); 
                break;
            default: 
                date = addDays(365);
        }
        ticket.setFechaLimite(date);
        return ticketRepository.save(ticket);
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Collection<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public void deleteById(String id) {
        ticketRepository.deleteById(id);
    }

    public Optional<Ticket> findById(String id) {
        return ticketRepository.findById(id);
    }

    public Ticket setPriority(String id, Ticket.Prioridad priority) {
        Optional<Ticket> opTicket = ticketRepository.findById(id);
        Ticket ticket = opTicket.get();
        if (opTicket.isPresent()) {
            ticket.setPrioridad(priority);
            ticketRepository.save(ticket);
        }
        return ticket;
    }

    public Ticket setSeverity(String id, Ticket.Severidad severity) {
        Optional<Ticket> opTicket = ticketRepository.findById(id);
        Ticket ticket = opTicket.get();
        if (opTicket.isPresent()) {
            ticket.setSeveridad(severity);
            ticketRepository.save(ticket);
        }
        return ticket;
    }

    public Collection<Ticket> findByCliente(Long cliente) {
        return ticketRepository.findByCliente(cliente);
    }

    public Collection<Ticket> findByVersionProducto(Long versionProducto) {
        return ticketRepository.findByVersionProducto(versionProducto);
    }

    public Date addDays(int days) {
        LocalDate fechaActual = LocalDate.now();
        return Date.from(fechaActual.plusDays(days).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}

package com.soporte.tpg_soporte.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import com.soporte.tpg_soporte.exception.ErrorNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        if (ticket.getCliente() == null) {
            throw new ErrorNotFound("Client is required");
        } else if (ticket.getTitulo() == null) {
            throw new ErrorNotFound("Title is required");
        } else if (ticket.getVersionProducto() == null) {
            throw new ErrorNotFound("Version is required");
        }
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
    public Ticket updateTicket(String id, Ticket ticket) {
        Optional<Ticket> opTicket = ticketRepository.findById(id);
        if (!opTicket.isPresent()) {
            throw new ErrorNotFound("Ticket not found");
        }
        Ticket existingTicket = opTicket.get();
        if (existingTicket.getEstado() == Ticket.Estado.RESUELTO) {
            throw new ErrorNotFound("Closed tickets can't be updated");
        }
        existingTicket.setCodigo(ticket.getCodigo());
        existingTicket.setTitulo(ticket.getTitulo());
        existingTicket.setCliente(ticket.getCliente());
        existingTicket.setDescription(ticket.getDescription());
        existingTicket.setPrioridad(ticket.getPrioridad());
        existingTicket.setEstado(ticket.getEstado());
        existingTicket.setFechaLimite(ticket.getFechaLimite());
        existingTicket.setSeveridad(ticket.getSeveridad());
        existingTicket.setFechaCreacion(ticket.getFechaCreacion());
        existingTicket.setVersionProducto(ticket.getVersionProducto());
        ticketRepository.deleteById(id);
        ticketRepository.save(existingTicket);
        return existingTicket;
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

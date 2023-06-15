package com.soporte.tpg_soporte;

import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@ContextConfiguration(classes = TpgSoporteApplication.class)
@WebAppConfiguration
public class TicketIntegrationTests {

    @Autowired
    TicketService ticketService;


    Ticket createTicket(String codigo, String titulo, Ticket.Severidad severidad, Ticket.Prioridad prioridad, Ticket.Estado estado, String description, Date sla, Date fechaCreacion, Long cliente, Long producto) {
        return ticketService.createTicket(new Ticket(codigo, titulo, severidad, prioridad, estado, description, sla, fechaCreacion, cliente, producto));
    }

    Ticket changePriority(Ticket ticket, Ticket.Prioridad priority) {
        return ticketService.setPriority(ticket.getCodigo(), priority);
    }

    Ticket changeSeverity(Ticket ticket, Ticket.Severidad severity) {return ticketService.setSeverity(ticket.getCodigo(), severity);}

    //getTimeElapsed?
}

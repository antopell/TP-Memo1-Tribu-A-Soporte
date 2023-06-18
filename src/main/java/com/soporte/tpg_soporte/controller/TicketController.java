package com.soporte.tpg_soporte.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.soporte.tpg_soporte.exception.ErrorResponse;
import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;


    @Operation(summary = "Crea un ticket", description = "Crea un ticket con su respectiva información")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Creación exitosa del ticket"),
        @ApiResponse(responseCode = "400", description = "Bad request: envío fallido", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
     })
    @PostMapping("/tickets")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }


    @Operation(summary = "Recupera tickets", description = "Devuelve una lista con todos los tickets")
    @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los tickets", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Ticket.class))))
    @GetMapping("/tickets")
    public Collection<Ticket> getTickets() {
        return ticketService.getTickets();
    }


    @Operation(summary = "Recupera ticket en base a su código", description = "Devuelve un ticket en base a su código")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Ticket no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "200", description = "Recuperación exitosa del ticket", content = @Content(schema = @Schema(implementation = Ticket.class))),
    })
    @GetMapping("/tickets/{codigo}")
    public ResponseEntity<Ticket> getTicket(@PathVariable String codigo) {
        Optional<Ticket> ticketOptional = ticketService.findById(codigo);
        return ResponseEntity.of(ticketOptional);
    }


    @Operation(summary = "Actualiza un ticket en base a su código", description = "Actualiza un ticket en base a su código")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Actualización exitosa del ticket"),
        @ApiResponse(responseCode = "404", description = "Ticket no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
     })
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

    @Operation(summary = "Elimina un ticket en base a su código", description = "Elimina un ticket en base a su código")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Eliminación exitosa del ticket"),
        @ApiResponse(responseCode = "404", description = "Ticket no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
     })
    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable String id) {
        ticketService.deleteById(id);
    }


    @Operation(summary = "Recupera los tickets en base al cliente", description = "Devuelve una lista de tickets en base al cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Cliente no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los tickets", content = @Content(schema = @Schema(implementation = Ticket.class))),
    })
    @GetMapping("/cliente/{cliente}/tickets")
    public Collection<Ticket> findTicketsByCliente(@PathVariable Long cliente) {
        return ticketService.findByCliente(cliente);
    }


    @Operation(summary = "Recupera los tickets en base al producto", description = "Devuelve una lista de tickets en base al producto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Producto no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los tickets", content = @Content(schema = @Schema(implementation = Ticket.class))),
    })
    @GetMapping("/version-producto/{versionProducto}/tickets")
    public Collection<Ticket> findTicketsByVersionProducto(@PathVariable Long versionProducto) {
        return ticketService.findByVersionProducto(versionProducto);
    }


    @Operation(summary = "Recupera los clientes", description = "Devuelve una lista de clientes")
    @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los clientes")
    @GetMapping("/clientes")
    public String getClientes() throws IOException {
        URL url = new URL("https://anypoint.mulesoft.com/mocking/api/v1/sources/exchange/assets/754f50e8-20d8-4223-bbdc-56d50131d0ae/clientes-psa/1.0.0/m/api/clientes");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        String content = "";
        while ((inputLine = in.readLine()) != null) {
            content += inputLine;
        }
        in.close();
        con.disconnect();
        return content;
    }
}
package com.soporte.tpg_soporte.controller;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import com.soporte.tpg_soporte.exception.ErrorNotFound;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.soporte.tpg_soporte.model.Cliente;
import com.soporte.tpg_soporte.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.soporte.tpg_soporte.exception.ErrorResponse;
import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.service.TicketService;
import com.soporte.tpg_soporte.model.Producto;

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
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
        try {
            Ticket createdTicket = ticketService.createTicket(ticket);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
        } catch (ErrorNotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @Operation(summary = "Recupera tickets", description = "Devuelve una lista con todos los tickets")
    @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los tickets", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Ticket.class))))
    @CrossOrigin
    @GetMapping("/tickets")
    public Collection<Ticket> getTickets() {
        return ticketService.getTickets();
    }


    @Operation(summary = "Recupera ticket en base a su código", description = "Devuelve un ticket en base a su código")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Ticket no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "200", description = "Recuperación exitosa del ticket", content = @Content(schema = @Schema(implementation = Ticket.class))),
    })
    @CrossOrigin
    @GetMapping("/tickets/{codigo}")
    public ResponseEntity<?> getTicket(@PathVariable String codigo) {
        try {
            Optional<Ticket> opTicket = ticketService.findById(codigo);
            return ResponseEntity.status(HttpStatus.OK).body(opTicket);
        } catch (ErrorNotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


    @Operation(summary = "Actualiza un ticket en base a su código", description = "Actualiza un ticket en base a su código")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Actualización exitosa del ticket"),
        @ApiResponse(responseCode = "404", description = "Ticket no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
     })
    @CrossOrigin
    @PutMapping("/tickets/{codigo}")
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket, @RequestParam String codigo) {
        try {
            Ticket ticket_updated = ticketService.updateTicket(codigo, ticket);
            return ResponseEntity.status(HttpStatus.OK).body(ticket_updated);
        } catch(ErrorNotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @Operation(summary = "Elimina un ticket en base a su código", description = "Elimina un ticket en base a su código")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Eliminación exitosa del ticket"),
        @ApiResponse(responseCode = "404", description = "Ticket no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
     })
    @CrossOrigin
    @DeleteMapping("/tickets/{codigo}")
    public ResponseEntity<?> deleteTicket(@PathVariable String codigo) {
        try {
            ticketService.deleteById(codigo);
            return ResponseEntity.status(HttpStatus.OK).body("Ticket eliminado.");
        } catch(ErrorNotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


    @Operation(summary = "Recupera los productos", description = "Devuelve una lista de productos")
    @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los productos")
    @CrossOrigin
    @GetMapping("/productos")
    public Collection<Producto> getProductos() throws IOException {
        String filePath = "/app/src/main/resources/productos.txt";
        String content = Files.readString(Path.of(filePath));
        Type listType = new TypeToken<List<Producto>>() {}.getType();
        List<Producto> productos = new Gson().fromJson(content, listType);
        return productos;

    }

    @Operation(summary = "Recupera las versiones en base al producto", description = "Devuelve una lista de versiones en base al producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Producto no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "200", description = "Recuperación exitosa de las versiones", content = @Content(schema = @Schema(implementation = Version.class))),
    })
    @CrossOrigin
    @GetMapping("/productos/{codigoProducto}/versiones")
    public Collection<Version> findVersionesByProducto(@PathVariable Long codigoProducto) throws IOException {
        String filePath = "/app/src/main/resources/versiones.txt";
        String content = Files.readString(Path.of(filePath));
        Type listType = new TypeToken<List<Version>>() {}.getType();
        List<Version> versiones = new Gson().fromJson(content, listType);
        List<Version> versionesProducto = new ArrayList<>();
        for (Version version : versiones) {
            if (version.getCodigoProducto() == codigoProducto) {
                versionesProducto.add(version);
            }
        }
        return versionesProducto;
    }

    @Operation(summary = "Recupera los tickets en base a la version del producto", description = "Devuelve una lista de tickets en base a la version del producto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Version no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los tickets", content = @Content(schema = @Schema(implementation = Ticket.class))),
    })
    @CrossOrigin
    @GetMapping("/versiones/{codigoVersion}/tickets")
    public ResponseEntity<?> findTicketsByVersionProducto(@PathVariable Long codigoVersion) {
        try {
            Collection<Ticket> tickets = ticketService.findByVersionProducto(codigoVersion);
            return ResponseEntity.ok(tickets);
        } catch (ErrorNotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(Collections.singletonList(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


    @Operation(summary = "Recupera los clientes", description = "Devuelve una lista de clientes")
    @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los clientes")
    @CrossOrigin
    @GetMapping("/clientes")
    public Collection<Cliente> getClientes() throws IOException {
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
        Type listType = new TypeToken<List<Cliente>>() {}.getType();
        List<Cliente> clientes = new Gson().fromJson(content, listType);
        return clientes;
    }

    @Operation(summary = "Recupera los tickets en base al cliente", description = "Devuelve una lista de tickets en base al cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Cliente no existe", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "200", description = "Recuperación exitosa de los tickets", content = @Content(schema = @Schema(implementation = Ticket.class))),
    })
    @CrossOrigin
    @GetMapping("/clientes/{cliente}/tickets")
    public Collection<Ticket> findTicketsByCliente(@PathVariable Long cliente) {
        return ticketService.findByCliente(cliente);
    }
}
    
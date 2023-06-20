package com.soporte.tpg_soporte;

import com.soporte.tpg_soporte.model.Ticket;
import com.soporte.tpg_soporte.service.TicketService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketPriorityAndSeverityTests {

    @Autowired
    private TicketService ticketService;
    private Ticket.Prioridad prioridad;
    private Ticket ticket;

    @Given("Client is high-priority")
    public void client_is_high_priority() {
        ticketService = new TicketService();
        prioridad = Ticket.Prioridad.ALTA;
    }

    @When("Ticket is created")
    public void ticket_is_created() {
        Date fechaAhora = new Date();
        Date fechaFinal = new Date();
        ticket = ticketService.createTicket(new Ticket(
                                "TPG1",
                                "Algo roto",
                                Ticket.Severidad.S3,
                                prioridad,
                                Ticket.Estado.PENDIENTE,
                                "desc",
                                fechaFinal,
                                fechaAhora,
                                (long)5,
                                (long)6));
    }

    @Then("Ticket priority is high")
    public void ticket_priority_is_high() {
        assertEquals(ticket.getPrioridad(), Ticket.Prioridad.ALTA);
    }

    @Given("Client is lower-priority")
    public void client_is_lower_priority() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket priority is low")
    public void ticket_priority_is_low() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Problem hinders the functionality of the client's product.")
    public void problem_hinders_the_functionality_of_the_client_s_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity is S4")
    public void ticket_severity_is_s4() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Problem that does not affect the functionality of the client's product")
    public void problem_that_does_not_affect_the_functionality_of_the_client_s_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity is S1")
    public void ticket_severity_is_s1() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Ticket with an open status")
    public void ticket_with_an_open_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Trying to change the ticket severity to S4")
    public void trying_to_change_the_ticket_severity_to_s4() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity should be S4")
    public void ticket_severity_should_be_s4() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Trying to change the ticket severity to S3")
    public void trying_to_change_the_ticket_severity_to_s3() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity should be S3")
    public void ticket_severity_should_be_s3() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Trying to change the ticket severity to S2")
    public void trying_to_change_the_ticket_severity_to_s2() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity should be S2")
    public void ticket_severity_should_be_s2() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Trying to change the ticket severity to S1")
    public void trying_to_change_the_ticket_severity_to_s1() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity should be S1")
    public void ticket_severity_should_be_s1() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Ticket with a closed status with S3 severity")
    public void ticket_with_a_closed_status_with_s3_severity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Ticket severity should remain S3")
    public void ticket_severity_should_remain_s3() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

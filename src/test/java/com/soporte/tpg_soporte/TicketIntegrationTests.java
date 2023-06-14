package com.soporte.tpg_soporte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = Memo1BankApp.class)
@WebAppConfiguration
public class TicketIntegrationTests {

    @Autowired
    TicketService ticketService;


    Ticket createTicket(String product, String version, String modifications, String client, int severity, int priority) {
        return ticketService.createTicket(new Ticket(client, product, version, modifications, client, severity, priority));
    }

    Ticket changePriority(Ticket ticket, int priority) {
        return ticketService.setPriority(ticket.getId(), priority);
    }

    Ticket changeSeverity(Ticket ticket, int severity) {return ticketService.setSeverity(ticket.getId(), severity);}

    //getTimeElapsed?
}

@ContextConfiguration(classes = Memo1BankApp.class)
@WebAppConfiguration
public class AccountIntegrationServiceTest {

    @Autowired
    AccountService accountService;

    Account createAccount(Double balance) {
        return accountService.createAccount(new Account(balance));
    }

    Account withdraw(Account account, Double sum) {
        return accountService.withdraw(account.getCbu(), sum);
    }

    Account deposit(Account account, Double sum) {
        return accountService.deposit(account.getCbu(), sum);
    }

}

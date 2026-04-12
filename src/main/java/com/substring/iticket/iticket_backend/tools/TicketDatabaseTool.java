package com.substring.iticket.iticket_backend.tools;


import com.substring.iticket.iticket_backend.entity.Ticket;
import com.substring.iticket.iticket_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    // 1
    @Tool(description = "This tool helps to create a new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details.") Ticket ticket){
        try{
            System.out.println("Going to create ticket");
            System.out.println(ticket);
            return  ticketService.createTicket(ticket);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    // 2
    @Tool(description = "This tool helps to get a ticket by it's username.")
    public Ticket getTicketByEmail(@ToolParam(description = "Email whose ticket is required") String username){
        return ticketService.getTicketByEmail(username);
    }

    // 3
    @Tool(description = "This tool helps to update an existing ticket")
    public Ticket updateTicket(@ToolParam(description = "This tool helps to update the ticket by it's ticket id") Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    // 4
    @Tool(description = "This tool for fetching current system time.")
    public String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }



}

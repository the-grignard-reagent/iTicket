package com.substring.iticket.iticket_backend.service;


import com.substring.iticket.iticket_backend.entity.Ticket;
import com.substring.iticket.iticket_backend.repository.TicketRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    public Ticket getTicketByEmail(String username){
        return ticketRepository.findByEmail(username).orElse(null);
    }

}
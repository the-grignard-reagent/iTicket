package com.substring.iticket.iticket_backend.repository;

import com.substring.iticket.iticket_backend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
//    Optional<Ticket> findByTicketId(Long ticketId);
    Optional<Ticket> findByEmail(String username);
}

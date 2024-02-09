package com.trainticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainticketbooking.entity.Ticket;
import com.trainticketbooking.service.TicketServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketServiceImpl ticketServiceImpl;
	
	@PostMapping("/book")
	public Ticket purchaseTicket(@RequestBody Ticket ticket) {
		Ticket bookedTicket = ticketServiceImpl.bookTicket(ticket);
		return bookedTicket;
	}
	
	@GetMapping("/id/{pnrNumber}")
	public ResponseEntity<Ticket> getTicketByPNR(@PathVariable long pnrNumber) {
		Ticket ticket = ticketServiceImpl.getTicketByPNR(pnrNumber);
		if (ticket != null) {
			return ResponseEntity.ok(ticket);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/cancel/{pnrNumber}")
	public ResponseEntity<Ticket> cancelTicketByPNR(@PathVariable long pnrNumber) {
		Ticket ticket = ticketServiceImpl.cancelTicketByPNR(pnrNumber);
		if (ticket != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/modify/{pnrNumber}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable long pnrNumber,@RequestBody Ticket ticket) {
		Ticket updatedTicket = ticketServiceImpl.updateTicket(pnrNumber, ticket);
		if (updatedTicket != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

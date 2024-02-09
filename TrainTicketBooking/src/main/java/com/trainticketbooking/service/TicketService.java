package com.trainticketbooking.service;

import com.trainticketbooking.entity.Ticket;

public interface TicketService {
	Ticket bookTicket(Ticket ticket);
	Ticket getTicketByPNR(long pnrNumber);
	Ticket cancelTicketByPNR(long pnrNumber);
	Ticket updateTicket(long pnrNumber, Ticket ticket);
}

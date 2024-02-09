package com.trainticketbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainticketbooking.entity.Ticket;
import com.trainticketbooking.repository.TrainRepository;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TrainRepository trainRepository;
	
	@Override
	public Ticket bookTicket(Ticket ticket) {
		Ticket bookedTicket = trainRepository.save(ticket);
		return bookedTicket;
	}
	
	@Override
	public Ticket getTicketByPNR(long pnrNumber) {
		Optional<Ticket> ticket = trainRepository.findById(pnrNumber);
		if (ticket.isPresent()) {
			return ticket.get();
		} else {
			return null;
		}
	}
	
	@Override
	public Ticket cancelTicketByPNR(long pnrNumber) {
		Ticket bookedTicket = getTicketByPNR(pnrNumber);
		trainRepository.deleteById(pnrNumber);
		return bookedTicket;
	}
	
	@Override
	public Ticket updateTicket(long pnrNumber, Ticket ticket) {
		Ticket updatedTicket = getTicketByPNR(pnrNumber);
		if (updatedTicket == null) {
			return updatedTicket;
		}
		updatedTicket.setSection(ticket.getSection());
		return trainRepository.save(updatedTicket);
	}
}

package com.trainticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnrnumber;
	private String depatureFrom;
	private String destinationTo;
	private String firstName;
	private String lastName;
	private double pricePaid;
	private String mailAddress;
	private char section;
	
	public Ticket() {
		super();
	}
	
	public Ticket(int pnrNumber, String depatureFrom, String destinationTo, String firstName, String lastName, double pricePaid, String mailAddress, char section) {
		super();
		this.pnrnumber = pnrNumber;
		this.depatureFrom = depatureFrom;
		this.destinationTo = destinationTo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pricePaid = pricePaid;
		this.mailAddress = mailAddress;
		this.setSection(section);
	}
	
	public int getPnrnumber() {
		return pnrnumber;
	}

	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}

	public String getDepatureFrom() {
		return depatureFrom;
	}
	public void setDepatureFrom(String depatureFrom) {
		this.depatureFrom = depatureFrom;
	}
	public String getdestinationTo() {
		return destinationTo;
	}
	public void setdestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Ticket [depatureFrom=" + depatureFrom + ", destinationTo=" + destinationTo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", pricePaid=" + pricePaid + ", mailAddress=" + mailAddress + ", section" + section + "]";
	}
	
}

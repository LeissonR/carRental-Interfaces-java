package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;

	private BrazilTaxService taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
	
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();  
		double hours = minutes / 60.00;
		
		if (hours <= 12.00) {
			
		}
		else {
			
		}
		
		carRental.setInvoice(new Invoice(50.00, 10.00));
	}
}

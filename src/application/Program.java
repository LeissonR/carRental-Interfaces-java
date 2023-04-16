package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Enter with Rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();

		System.out.print("Check-in (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

		System.out.print("Check-out (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter with price per Hour: ");
		Double pricePerHour = sc.nextDouble();
		System.out.print("Enter with price per Day: ");
		Double pricePerDay = sc.nextDouble();
		
		RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rs.processInvoice(carRental);
		
		System.out.println(carRental.getInvoice().toString());
		
		sc.close();
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = scan.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sd.parse(scan.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sd.parse(scan.next());
			
			
			Reservation reser = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reser);
			System.out.println();
			
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sd.parse(scan.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sd.parse(scan.next());
			
			
			reser.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reser);
		}catch (ParseException e) {
			System.out.println("Data com formato invalido");
		}catch (DomainException e) {
			System.out.println("erro na reserva: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		scan.close();
		
	}

}

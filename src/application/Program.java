package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = scan.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sd.parse(scan.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sd.parse(scan.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}else {
			Reservation reser = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reser);
			System.out.println();
			
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sd.parse(scan.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sd.parse(scan.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
			reser.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reser);
			}
			
		}
		
		scan.close();
		
	}

}

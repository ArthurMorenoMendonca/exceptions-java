package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	
	SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)) {
			//Data antes da reserva
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	
	public Date getCheckOut() {
		return checkOut;
	}

	
	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn , Date checkOut) throws DomainException {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			// caso voce digite anos anteriores ao da reserva 
			throw new DomainException("As datas de reserva para atualização devem ser datas futuras");
		}
		if(!checkOut.after(checkIn)) {
			//Data antes da reserva
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reservation: Room: " + roomNumber + ", check-in:  " 
	            + sd.format(checkIn) + ", check-out:  " + sd.format(checkOut) + ", nights: " + duration();
	}
	
	
	
	
	

}

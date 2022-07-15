package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entitites.Reservar;

public class HotelApp {

	public static void main(String[] args) throws ParseException {
		

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int number = sc.nextInt();
		
		System.out.print("Data de Check-in: (dd/MM/yyyy) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Check-out: (dd/MM/yyyy) ");
		Date checkOut = sdf.parse(sc.next());
		
		//A data de checkOut não for depois da de checkIn
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: data de Check-Out precisa ser depois da "
					+ "data de Check-In");
		}else {
			Reservar reserva = new Reservar(number, checkIn, checkOut);
			System.out.println("Reserva: "+reserva);
			System.out.println();
			System.out.println("Entre com os dados atualizados da reserva: ");
			System.out.print("Data de Check-in: (dd/MM/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out: (dd/MM/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: datas precisam ser datas neste ano ou no próximo");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: data de Check-Out precisa ser depois da "
						+ "data de Check-In");
			}else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println("Reserva: "+reserva);
			}
			
			
		}
		
		
		
		sc.close();

	}

}

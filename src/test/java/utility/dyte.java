package utility;

import java.time.LocalDate;
import java.util.Random;

public class dyte {

	public static void main(String[] args) {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		//long randomDay = minDay + random.nextInt(maxDay - minDay);

		long randomDay = minDay +  random.nextInt(maxDay - minDay);
		
		
		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

		System.out.println(randomBirthDate);
	}

}

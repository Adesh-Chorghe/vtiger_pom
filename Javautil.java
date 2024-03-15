package commonutils;

import java.util.Random;

public class Javautil {

	public int getRandomNumber() {
		
		Random random=new Random();
		int ran = random.nextInt(10);
		return ran;
		
	}
	
}

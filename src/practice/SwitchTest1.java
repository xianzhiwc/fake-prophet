package practice;

import java.util.Random;

public class SwitchTest1 {
  public static void main(String[] args) {
	Random rand = new Random(47);
	for (int i = 0; i < 20; i++) {
		int c = rand.nextInt(26)+'a';
		System.out.print((char) c +","+ c +":");
		switch (c) {
		case 'a':
		case 'e':	
		case 'i':	
		case 'o':
		case 'u': 
			System.out.println("vowel");
			break;
		case 'y':
		case 'w':
			System.out.println("Sometimes a vowel");
			break;
		default:
			System.out.println("consonant");
			break;
		}
	
	}
	
}
}

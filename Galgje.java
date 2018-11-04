package galgjeweek1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Galgje {
	
	public static void guess (String woord, int levens) {				//de methode guess, neemt woord en levens mee uit de main
		char[] filler= new char[woord.length()];						//filler om het woord te vullen met '-'
		int i = 0;
		while (i<woord.length()) {
			filler[i]='-';
			if(woord.charAt(i)== ' ') {
				filler[i] =' ';
			}
			i++;
		}
		System.out.println(filler);
		System.out.println("            levens over = " + levens);
		
		Scanner s = new Scanner(System.in); 
		
		ArrayList<Character> l=new ArrayList<Character>();
		
		while(levens>0) {
			char x = s.next().charAt(0);  //character dat gebruiker invult
			
			
			if(l.contains(x)) {
				System.out.println("Deze letter is al gebruikt");
				continue;					//while loop gaat verder
			}
			
			l.add(x);
			
			if(woord.contains(x+"")) {
				for(int y = 0; y<woord.length(); y++) {    //bekijkt alle posities van het character
					if(woord.charAt(y)==x) {				//en vervangt '-' door het character
						filler[y] = x;
					}
				}
			}
			else {
				levens--;									//gaat 1 leven vanaf
			}
			
			if(woord.equals(String.valueOf(filler))) {		//kijkt of filler gelijk is aan het woord
				System.out.println(filler);
				System.out.println("Je hebt gewonnen!");
				break;
			}
			
			
			System.out.println(filler);
			System.out.println("            levens over = " + levens);
		}
		
		if(levens==0) {
			System.out.println("Je hebt verloren!");
		}
		s.close();
	}
	
	public static void main (String[] args) {
		Random r = new Random();
		String[] woorden = {"banaan", "tapijt", "computer", "chips", "telefoon", "ooievaar", "toetsenbord", "camera"}; //array met woorden
		String woord = woorden[r.nextInt(woorden.length)];		//random woord genereren uit array met woorden. Dat woord wordt opgeslagen in 'woord'.
		int levens = 10;										//aantal levens
		guess(woord,levens);									//roept methode 'guess' aan met parameters woord en levens.
	}
}


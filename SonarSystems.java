import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SonarSystems {

	public static void main(String[] args) {

		System.out.println("for loop");
		for (int i = 0; i < 10; i++) {

			if (i == 8) {
				continue;
			}
			System.out.println(i);
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			if (i == 8) {
				break;
			}

		}
		System.out.println("\nwhile loop");
		int j = 0;
		while (j < 100) {
			System.out.println(j);
			j++;
		}
		System.out.println(" \ndo while loop");
		int k = 0;
		do {
			System.out.println(k);
			k++;

		} while (k < 20);

		// cap - numbers
		float i = 59.7f;
		// round
		System.out.println("\n");
		System.out.println(Math.round(i));
		// log
		System.out.println(Math.E);
		System.out.println(Math.log(100));

		// power
		System.out.println(Math.pow(10, 3));

		// square root
		System.out.println(Math.sqrt(4));

		// sine
		double pi = Math.PI;
		System.out.println(Math.sin(pi));

		// CHARACTERS

		char c = '\t'; // tab
		System.out.println(c + "Hello" + c + "World");

		char awesome = 'b';
		// check if it is a letter
		System.out.println(Character.isLetter(awesome));

		// check if it is uppercase
		System.out.println(Character.isUpperCase(awesome));

		// convert lowercase to uppercase
		System.out.println(Character.toUpperCase(awesome));

		// STRINGS

		String s = "hello world  ";
		System.out.println(s);

		// character location
		System.out.println(s.charAt(1));

		// string length
		System.out.println(s.length());

		// convert string to uppercase
		System.out.println(s.toUpperCase());

		// ARRAYS
		// int a[] or int[] a, are the same
		int a[] = { 1, 2, 3, 4, 5, 6 };

		System.out.println(a[0]);
		System.out.println(a.length);

		// loop through the array and print out all values
		for (int ii = 0; ii < a.length; ii++) {
			System.out.println(a[ii]);
			
		}
		//FOREACH LOOP
		float f[] = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
		for(int kk=0;kk<f.length;kk++) {
			System.out.println(f[kk]);
		}
		for(float e: f) { //the short version
			System.out.println(e);
		}
	
		//DATE AND TIME
		Date d=new Date();
		System.out.println(d.toString()); 
		
		System.out.println(d.getTime());
		System.out.println(d.getYear());
		
		//REGULAR EXPRESSIONS
		
		Pattern pat=Pattern.compile("F.....");
		Matcher mat=pat.matcher("France");
		//1st method
		boolean res=mat.matches();
		System.out.println(res);
		
		//2nd method
		boolean res2=Pattern.compile("F.....").matcher("France").matches();
		System.out.println(res2);
		
		//3rd method
		boolean res3=Pattern.matches("F.....","France");
		System.out.println(res3);
	}
}

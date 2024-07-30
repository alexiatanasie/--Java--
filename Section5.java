//section 5 : EXCEPTIONS

class MyException extends Exception {

	String str1;

	MyException(String str2) {
		str1 = str2;
	}

	public String toString() {
		return ("my exception was triggered" + str1);
	}
}

public class Section5 {

	public static void main(String[] args) {

		int array[] = new int[13];
		try {
			// System.out.println(array[13]);
			int i = 13 / 0;
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("array index error");

			System.out.println(error);
		} catch (ArithmeticException error) {
			System.out.println("maths error");
			System.out.println(error);
		}
		System.out.println("end");

		try {
			Funct();
		} catch (ArithmeticException error) {
			System.out.println("ArithmeticException triggered ");
		}
		System.out.println("end!");

		try {
			int ii = 10 / 0;
		} catch (ArithmeticException error) {
			System.out.println("division by 0");
		} finally {
			System.out.println("finally");
		}
		System.out.println("end");

		// user created exceptions
		try {
			throw new MyException("this is my custom error message");
		}

		catch (MyException error) {

			System.out.println(error);
		}
		
	}
	//throw and throws keywords
	//throw an exception.throws is attached to a method
	public static void Funct()throws ArithmeticException{
		throw new ArithmeticException(); 
	}
}

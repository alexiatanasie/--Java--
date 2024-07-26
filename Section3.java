public class Section3 {

	public static void main(String[] args) {

		Function1(7.89f, 3.55f);

		int r = ReturnFunct();
		System.out.println(r);

		Hello(13);
		Hello(22, 13);
		Hello();
		Hello(true);
		Hello(false);
		
//		int res=adder(4,5,1);
//		System.out.println(res);
		adder();
		adder(4,5,1);
	}

	public static void Function1(float var, float var2) {
		System.out.println(var * var2);
	}

	public static int ReturnFunct() {
		return 60 * 10 + 9;
	}

	// method overloading
	public static void Hello(int x) {
		System.out.println(x);

	}

	public static void Hello(int x, int y) {
		System.out.println(x * y);

	}

	public static void Hello() {
		System.out.println("Hello,Ale!");

	}

	public static void Hello(boolean x) {
		if (x == true) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

//	public static int adder(int n1,int n2,int n3) {
//		return n1+n2 -n3;
//		
//	}
	public static void adder(int... numbers) {
		if(numbers.length==0)
		{System.out.println("please pass in information");
		return;
		}
		int total=0;
		for(int num:numbers) {
			total+=num;
		}
		System.out.println(total);
	}
}

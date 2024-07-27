import java.io.*;
public class Section4 {

	public static void main(String[] args) throws IOException{
		FileInputStream input=null;
		input=new FileInputStream("FileInput.txt");
		
		int nr;
		while((nr=input.read()) !=-1) {
			System.out.println(nr);
		}

		FileOutputStream output=null;
		output=new FileOutputStream("FileOutput.txt");
		output.write(65);

   	//character streams
		FileReader inputR=null;
		inputR=new FileReader("FileInput.txt");
		
		int nrr;
		while((nrr=input.read()) !=-1) {
			System.out.println(nrr);
		}

		FileWriter outputW=null;
		outputW=new FileWriter("FileOutput.txt");
		outputW.write(65);
		
		//standard streams
		InputStreamReader in=null;
		in=new InputStreamReader(System.in);
		System.out.println("Enter characters, e for exit");
		
		char c;
		do {
			c=(char) in.read();
			System.out.println(c);
		
	}while(c!='e');
		if(in!=null) {
			in.close();
		}
		//listing files and folders
		File f=null;
		String paths[];
		f=new File("/Applications");
		paths=f.list();
		for(String p:paths) {
			System.out.println(p);
		}
	//creating folders
		String directory="/Users/Section 4 File IO/Desktop/ Ale";
		File ff=new File(directory);
		ff.mkdirs();
	}
}
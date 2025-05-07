package ro.ase.acs.classes;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;

import ro.ase.acs.models.BiletAutocar;
import ro.ase.acs.models.TipReducere;

public class Utils {
	public static Stream<BiletAutocar> getLocuriVandute(List<BiletAutocar> lista, int dist){
		return lista.stream().filter(x->x.getTipReducere()==TipReducere.STUDENT)
				.filter(y->y.getDistanta()<dist);
		
	}
	public static void salveazaInFisier(BiletAutocar b, String numeFisier)
	{
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(numeFisier);
			OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
			BufferedWriter writer=new BufferedWriter(outputStreamWriter);
			writer.write(b.getPlecare());
			writer.newLine();
			writer.write(b.getSosire());
			writer.newLine();
			writer.write(Integer.toString(b.getDistanta()));
			writer.newLine();
			writer.write(b.getTipReducere().toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

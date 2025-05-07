package ro.ase.acs.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BiletAutocar extends BiletAbstract implements Cloneable{
	
	private TipReducere tipReducere;
	private String[]statii;
	public BiletAutocar(String plecare, String sosire, int distanta,TipReducere tipReducere) {
		super(plecare, sosire, distanta);
		this.tipReducere=tipReducere;
	}
	@Override
	public float getReducere() {
		
		switch(tipReducere) {
		case STUDENT: return 0.5f;
		case PENSIONAR: return 0.9f;
		default: return 0f;
		}
	}
	public String[] getStatii() {
		if(statii!=null) {
			return Arrays.copyOf(statii,statii.length);
		}
		else {
			return null;
		}
	
	}
	public void setStatii(String[] statii) {
		if(statii!=null) {
			this.statii=Arrays.copyOf(statii,statii.length);
			
		}else {
			this.statii=null;
		}
		
	}
	public TipReducere getTipReducere() {
		return tipReducere;
	}
	
	@Override
	public float getPret() {
		
		return super.getPret()*distanta*(1-getReducere());
	}
	@Override
	public String toString() {
		return "-- "+ plecare + " " + sosire + " "+distanta+" --";
	}
	private static final List<BiletAutocar>bileteEmise=new ArrayList<>();
	
	
	public static void emiteBilet(BiletAutocar bilet) {
			bileteEmise.add(bilet);
	}
	public static Collection<BiletAutocar> bileteEmise(){
		return bileteEmise;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		BiletAutocar copy=(BiletAutocar)super.clone();
		copy.tipReducere=this.tipReducere;
		copy.setStatii(statii);
		return copy;
	}




}

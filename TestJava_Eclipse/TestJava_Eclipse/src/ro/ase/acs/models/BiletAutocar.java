package ro.ase.acs.models;

import java.util.ArrayList;
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
		return statii;
	}
	public void setStatii(String[] statii) {
		this.statii = statii;
	}
	public TipReducere getTipReducere() {
		return tipReducere;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		BiletAutocar copy=(BiletAutocar)super.clone();
		copy.distanta=this.distanta;
		copy.plecare=this.plecare;
		copy.sosire=this.sosire;
		if(this.statii!=null) {
			copy.statii=this.statii.clone();
		}
		return copy;
	}
	@Override
	public float getPret() {
		float pretul=5;
		return pretul*distanta*(1-getReducere());
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
	public String getPlecare() {
		// TODO Auto-generated method stub
		return super.getPlecare();
	}
	@Override
	public String getSosire() {
		// TODO Auto-generated method stub
		return super.getSosire();
	}
	@Override
	public int getDistanta() {
		// TODO Auto-generated method stub
		return super.getDistanta();
	}




}

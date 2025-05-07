package ro.ase.acs.models;

import ro.ase.acs.contracts.Cumparabil;

public abstract class BiletAbstract implements Cumparabil, Cloneable{
	protected String plecare;
	protected String sosire;
	protected int distanta;
	
	public BiletAbstract(String plecare, String sosire, int distanta) {
		super();
		this.plecare = plecare;
		this.sosire = sosire;
		this.distanta = distanta;
	}

	public String getPlecare() {
		return plecare;
	}

	public String getSosire() {
		return sosire;
	}

	public int getDistanta() {
		return distanta;
	}

	@Override
	public float getPret() {
		return 3;
	}
	public abstract float getReducere();

	@Override
	protected Object clone() throws CloneNotSupportedException {
		BiletAbstract copy=(BiletAbstract)super.clone();
		copy.distanta=this.distanta;
		copy.sosire=this.sosire;
		copy.plecare=this.plecare;
		return copy;
	}
	
}

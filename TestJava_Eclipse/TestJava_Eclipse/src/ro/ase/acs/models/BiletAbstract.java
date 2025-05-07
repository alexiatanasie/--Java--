package ro.ase.acs.models;

import ro.ase.acs.contracts.Cumparabil;

public abstract class BiletAbstract implements Cumparabil{
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
		return 0;
	}
	public abstract float getReducere();

}

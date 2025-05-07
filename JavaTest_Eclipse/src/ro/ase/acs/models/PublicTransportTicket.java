package ro.ase.acs.models;

import ro.ase.acs.contracts.Buyable;

public abstract class PublicTransportTicket implements Buyable{
	protected String departure;
	protected String destination;
	protected int distance;
	public PublicTransportTicket(String departure, String destination, int distance) {
		super();
		this.departure = departure;
		this.destination = destination;
		this.distance = distance;
	}
	@Override
	public float getPrice() {
		return 5;
	}
	

}

import java.util.Date;
import java.util.Deque;
import java.util.Objects;

public class FestivalTicket extends Ticket{
    public enum TicketType{
        FULL_PASS,
        ONE_DAY,
        TWO_DAYS
    }
    private TicketType ticketType;

    //cls contine un ctr default ce il apeleaza pe cel din baza
    public FestivalTicket() {
        super();
        this.ticketType = null;
    }

    public FestivalTicket(String eventName, float price, Date eventDate, TicketType ticketType) {
        super(eventName, price, eventDate);
        this.ticketType = ticketType;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FestivalTicket clone=(FestivalTicket) super.clone();
        clone.ticketType=this.ticketType;
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof FestivalTicket))return false;
        if(!super.equals(obj))return false;
        FestivalTicket festivalTicket=(FestivalTicket) obj;
        return Objects.equals(this.ticketType,festivalTicket.ticketType);
        //aici merge sa las equals ul lui
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),ticketType);
    }

    @Override
    public boolean isValid() {
        Date d=getEventDate();
        return d!=null && d.after(new java.util.Date()) && ticketType!=null;
    }
}

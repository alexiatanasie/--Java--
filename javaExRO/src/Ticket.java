import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Ticket implements ITicket, Cloneable, Comparable<Ticket>, Serializable {
    private  int id;
    private String eventName;
    private float price;
    private Date eventDate;
    private static int counter=1;

    public Ticket() {
        this.id = -1;
        this.eventName = "";
        this.price = 0;
        this.eventDate = null;
    }

    public Ticket( String eventName, float price, Date eventDate) {
        this.id = counter++;
        if(eventName==null||price<0){
            throw new IllegalArgumentException("invalid name or invalid price");
        }
        this.eventName = eventName;
        this.price = price;
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public boolean isValid() {
        return eventDate!=null && eventName!=null&& price>=0;
    }

    //setters with validations
    public void setEventName(String eventName) {
        if(eventName==null){
            throw new IllegalArgumentException("event cant be null");
        }
        this.eventName=eventName;
    }

    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        if(price<0){
            throw new IllegalArgumentException("event cant be < 0");
        }
        this.price=price;
    }


    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventName,price,eventDate); //combina mai multe valori intr-un singur hashCode
    }

    @Override
    public boolean equals(Object obj) {
//        if(this==obj)return true;
//        if(!(obj instanceof Ticket))return false;
        if(obj==null||getClass()!=obj.getClass())return false;
        Ticket ticket=(Ticket) obj;
        return Float.compare(ticket.price,price)==0 && Objects.equals(eventName,ticket.eventName) && Objects.equals(eventDate,ticket.eventDate);
    }
    //Float.compare - evita erori si trateaza cazuri speciale(NaN)
    //Objects.equals trateaza automat null si compara direct

    //clone with deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Ticket copy=(Ticket) super.clone();
        copy.eventName=this.eventName;
        copy.price=this.price;
        copy.eventDate=(Date)this.eventDate.clone();
        return copy;
    }

    //compareTo este folosita pt a ordona obiecte
    @Override
    public int compareTo(Ticket o) {
//      if(this.eventDate==null&&o.eventDate==null)return 0; //sunt egale
//      if(this.eventDate==null)return -1; //obiectul actual vine inainte
//      if(o.eventDate==null)return 1;//invers caz anterior
//      return this.eventDate.compareTo(o.eventDate);
      return o.eventDate.compareTo(this.eventDate);
    }
}

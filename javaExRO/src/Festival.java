import com.sun.source.tree.Tree;
import java.io.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Festival extends  Thread implements Serializable {
    private TreeSet<FestivalTicket> participants;
    public Predicate<FestivalTicket>p;
    public List<FestivalTicket> festivalTickets;
    private static final long serialVersionUID=1L;

    //default ctr
    public Festival() {
        participants=new TreeSet<>();
    }
    public void addParticipant(FestivalTicket ticket){
        participants.add(ticket);

    }
    public void deleteParticipants(FestivalTicket ticket){
        participants.remove(ticket);
    }
    public Set<FestivalTicket> getParticipants(){
        return participants;
    }

    public void saveData(String file) throws IOException {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(participants);

    }
    public void reloadData(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        Object obj=ois.readObject();
        if(obj instanceof TreeSet){
            participants=(TreeSet<FestivalTicket>) obj;

        }
        else{
            throw new RuntimeException("invalid data format");
        }

    }
    public List<FestivalTicket>getFullParticipants(){
        p =ticket->FestivalTicket.TicketType.FULL_PASS.equals(ticket.getTicketType());
        return participants.stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void run() {
        festivalTickets=participants.stream().filter(FestivalTicket::isValid).collect(Collectors.toList());
    }
}

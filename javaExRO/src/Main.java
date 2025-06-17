import javax.xml.parsers.SAXParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Date date=new Date();
        FestivalTicket f1=new FestivalTicket("Neversea", 200.30f, new Date(), FestivalTicket.TicketType.FULL_PASS);
        FestivalTicket f2=new FestivalTicket("Untold", 867.56f, new Date(), FestivalTicket.TicketType.FULL_PASS);
        FestivalTicket f3=new FestivalTicket("Saga", 150.56f, new Date(), FestivalTicket.TicketType.ONE_DAY);

        List<FestivalTicket> list=new ArrayList<>();
        list.add(f1);
        list.add(f2);
        list.add(f3);

        int count=0;
        for(FestivalTicket f:list){
            if(f.getTicketType()== FestivalTicket.TicketType.FULL_PASS){
                count++;
            }
            System.out.println("festivals with full pass:"+count);
        }
        Festival festival=new Festival();
        festival.addParticipant(f1);
        festival.addParticipant(f2);
        festival.addParticipant(f3);
        festival.start();
    }
}
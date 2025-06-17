import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.List;

public class UdpServer {
    public static FestivalTicket receiveTicket() {

        try {
            DatagramSocket socket = new DatagramSocket(9000); //creeaza un socket udp
            System.out.println("upd server started on 9000");
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet); //blocant

            ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            FestivalTicket ticket = (FestivalTicket) ois.readObject();


            System.out.println(ticket.getEventName()+ " "+ ticket.getTicketType());
            socket.close();
            return ticket;

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        receiveTicket();
    }

    //bubble sort compara si schimba elemente vecine parcurgand de mai multe ori lista
    //selection sort cauta cel mai mic element si il adauga la inceput

    //bubble sort dupa price
    public static void bubbleSortPrice(List<FestivalTicket> list){
        int n=list.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(list.get(j).getPrice()>list.get(j+1).getPrice()){
                    FestivalTicket temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }

    //bubble sort dupa nume
    public static void bubbleSortName(List<FestivalTicket>list){
        int n=list.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;i<n-i-1;j++){
                String name1=list.get(j).getEventName();
                String name2=list.get(j+1).getEventName();
                if(name1.compareTo(name2)>0){
                    FestivalTicket temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }

    //selection sort by price
    public static void selectionSortPrice(List<FestivalTicket>list){
        int n=list.size();
        for(int i=0;i<n-1;i++){
            int minElement=i;
            for(int j=i+1;j<n;j++){
                if(list.get(j).getPrice()<list.get(minElement).getPrice()){
                    FestivalTicket temp=list.get(j);
                    list.set(j,list.get(minElement));
                    list.set(minElement,temp);

                }
            }
        }
    }
    //selection sort by ticket type
    public static void selectionSortByType(List<FestivalTicket>list){
        int n=list.size();
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                String type1=list.get(j).getTicketType().name();
                String type2=list.get(j).getTicketType().name();
                if(type1.compareTo(type2)<0){
                    FestivalTicket temp=list.get(j);
                    list.set(j,list.get(min));
                    list.set(min,temp);
                }
            }
        }
    }
}


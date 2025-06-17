import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

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
}


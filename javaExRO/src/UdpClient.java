import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class UdpClient {

    public static void sendTicket(FestivalTicket t) throws IOException {
        DatagramSocket socket=new DatagramSocket();

        //serializare obiecte in bytes
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(t);
        oos.flush(); //golseste bufferul si trimite datele catre destinatie

        byte[] data=baos.toByteArray();

        InetAddress address=InetAddress.getByName("localhost");
        DatagramPacket packet=new DatagramPacket(data,data.length,address,9000);
        socket.send(packet);

        System.out.println("socket trimis");

    }
    public static void main(String[] args) throws IOException {
        FestivalTicket ticket=new FestivalTicket("fest",888.89f,new Date(),FestivalTicket.TicketType.FULL_PASS);
        sendTicket(ticket);
    }
}

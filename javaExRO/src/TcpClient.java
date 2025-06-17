import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",9000);
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());

        FestivalTicket ticket=new FestivalTicket("fest",777.89f,new Date(),FestivalTicket.TicketType.FULL_PASS);
        out.writeObject(ticket);
        out.flush();

        System.out.println("ticket trimis");
    }
}

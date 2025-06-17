import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=new ServerSocket(9000);
        System.out.println("tcp running on 9000");
        Socket clientSocket=serverSocket.accept(); //asteapta conexiune
        ObjectInputStream ois=new ObjectInputStream(clientSocket.getInputStream());

        FestivalTicket ticket=(FestivalTicket)ois.readObject();
        System.out.println(ticket.getEventName()+ticket.getPrice());
        clientSocket.close();

    }
}

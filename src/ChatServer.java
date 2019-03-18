import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(8080)) {
            System.out.println("server started");
            Socket socket = ss.accept();
            System.out.println("client connected" + socket);

            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                while (true) {
                    String message = in.readUTF();
                    if (message.equals("/end")) {
                        break;
                    }
                    System.out.println("received message: " + message);
                    out.writeUTF("fromServer:" + message);
                }
            }
        }
    }
}

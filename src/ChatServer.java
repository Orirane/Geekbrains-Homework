import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class ChatServer {
    private static volatile boolean exit = false;
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(8080);
            System.out.println("server started");
            Socket socket = ss.accept();
            System.out.println("client connected" + socket);

            try (DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                Thread t = new Thread(() -> {
                    Scanner sc = new Scanner(System.in);
                    try {
                        while (exit) {
                            String message = sc.nextLine();
                            if (message.equalsIgnoreCase("/end")) {
                                break;
                            }
                            out.writeUTF(message);
                        }
                    }catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                });
                t.start();
                try {
                    while (true) {
                        String message = in.readUTF();

                    if (message.equalsIgnoreCase("/end")) {
                            exit = true;
                            break;


                    }
                    if(message.equalsIgnoreCase("D:")){
                        for (String line : woah) {
                            out.writeUTF(line);
                        }
                    }
                    String timestamp = LocalTime.now().toString().substring(0, LocalTime.now().toString().indexOf("."));
                    System.out.println("["+timestamp+ "] "+"received message: " + message);
                    //out.writeUTF("fromServer:" + message +"\n");
                }}catch (EOFException e){
                     e.printStackTrace();
                     exit = true;
                     System.exit(0);
                }
            }
        }finally {
            try {
                ss.close();
            }catch (EOFException e){
                e.printStackTrace();
                System.exit(-1);
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static String[] woah = {"⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠛⢛⣉⣩⣤⣬⣉⣉⣉⠛⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿", "⣿⣿⣿⣿⣿⠿⠋⣀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣈⠻⢿⣿⣿⣿⣿⣿", "⣿⣿⣿⠟⢁⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡙⠿⣿⣿⣿", "⣿⣿⠏⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠙⢻⣷⡆⠹⣿⣿", "⣿⡇⢠⣿⣿⣿⣿⣿⣿⡟⠋⠛⢻⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⣀⣴⣿⣿⡄⢹⣿", "⡟⢀⣿⣿⣿⣿⣿⣿⣿⣧⣀⣤⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⢻", "⠁⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠟⢛⣋⣉⣉⣉⠙⢿⣿⣿⣿⣿⣿⡇⢸", "⡄⢸⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⣡⣴⣶⣿⣿⣿⣿⣿⣿⣧⠄⢿⣿⣿⣿⣿⡇⢸", "⣇⠈⣿⣿⣿⣿⣿⣿⣿⡟⠁⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⢸⣿⣿⣿⣿⠃⣼", "⣿⣆⠘⣿⣿⣿⣿⣿⣿⡇⣴⣤⣤⣬⣉⡛⠻⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⠃⢸⣿", "⣿⣿⣆⠘⢿⣿⣿⣿⣿⢀⣿⣿⣿⣿⣿⠿⠷⠌⠛⢛⣋⣉⣁⣸⣿⡿⠋⣠⣿⣿", "⣿⣿⣿⣶⡈⠙⢿⣿⣟⣈⣉⣩⣥⣤⣶⣶⣶⣾⣿⣿⣿⣿⣿⡿⠟⢁⣾⣿⣿⣿", "⣿⣿⣿⣿⣿⣶⣄⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⣉⣤⣶⣿⣿⣿⣿⣿", "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⣈⡉⠉⠛⣋⣉⣉⣤⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿" };
}


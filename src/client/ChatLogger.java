package client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public  class ChatLogger {
    private static final File chatHistory = new File("./out/production/Geekbrains-Homework/client/logs/chatlog.txt");
    private static final File chatHistoryBackup = new File("./out/production/Geekbrains-Homework/client/logs/chatlog-backup.txt");
    public static synchronized void  writeToLogs(String message){

        boolean exists = chatHistory.exists();
        if(!exists)
        {
            try {
                System.out.println("created a file");
                chatHistory.createNewFile();
            } catch (IOException e) {
                System.out.println("could not create new log file");
                e.printStackTrace();
            }

        }

        FileWriter fstream;
        try {
            fstream = new FileWriter(chatHistory, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(message+"\n");
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("could not write to the file");
            e.printStackTrace();
        }

    }
    public static synchronized void clearLogs(){
        try{
            PrintWriter writer = new PrintWriter(chatHistory);
            writer.print("");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static synchronized void backupLogs(){
        /*try(FileInputStream fis = new FileInputStream(chatHistory);
            FileWriter fWriter = new FileWriter(chatHistoryBackup)){

            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter out = new BufferedWriter(fWriter);
            String line = null;
            while ((line = in.readLine()) != null){
                out.write(line);
                out.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }*/
        chatHistoryBackup.delete();
        Path source = Paths.get(chatHistory.getPath());
        Path target = Paths.get(chatHistoryBackup.getPath());
        try {
            Files.copy(source, target);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}


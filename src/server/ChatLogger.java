package server;

import java.io.*;
import java.util.ArrayList;

public  class ChatLogger {
    private static final File f = new File("./server/logs/chatlog.txt");
    public static synchronized void  writeToLogs(String message){

        boolean exists = f.exists();
        if(!exists)
        {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("could not create new log file");
                e.printStackTrace();
            }

        }

        FileWriter fstream;
        try {
            fstream = new FileWriter(f, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(message+"\n");
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("could not write to the file");
            e.printStackTrace();
        }

    }

    public static synchronized ArrayList<String> getChatHistory(){
        ArrayList<String> TheEntiretyofChatHistory = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                TheEntiretyofChatHistory.add(line);
            }

            br.close();
            return TheEntiretyofChatHistory;
       }catch (IOException e){
           e.printStackTrace();
       }
       return TheEntiretyofChatHistory;
    }
}


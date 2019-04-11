package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueMain {
    public static void main(String[] args)throws IOException, InterruptedException {
        System.out.println("Greetings! \n Before you lies a test for console-based Queue program.");
        System.out.println("To add something to the queue, input 'insert %number%', where %number% " +
                "\nis whatever integer you want to add. If you want to display the front-most element and remove it" +
                " input: 'remove'\n" +
                "Else, if you want to display the front-most element but not remove it, input: 'peek " +
                "\nto exit the program - type 'exit'" +
                "\n\n");

        System.out.println("Now, you may begin.");
        Queue queue = new Queue(300);
        String input;
        while (true){
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            input = br.readLine();
            if(input.toLowerCase().equals("exit"))break;
            else if(input.toLowerCase().split(" ")[0].equals("insert")) {
                try {
                    queue.insert(Integer.valueOf(input.split(" ")[1]));
                }catch (NumberFormatException e){
                    System.out.println("Please remember that you should input an integer.");
                }
            }
            else if (input.toLowerCase().equals("remove")){
                if (!queue.isEmpty())System.out.println(queue.remove());
                else System.out.println("There's nothing to remove, the Queue is empty!");
            }
            else if (input.toLowerCase().equals("peek")){
                if (!queue.isEmpty())System.out.println(queue.peek());
                else System.out.println("There's nothing to see, the Queue is empty!");
            } else {
                System.out.println("Perhaps, you made a mistake when you typed in last command");
            }
        }
        System.out.println("Goodbye.");
        Thread.sleep(2000);
    }
}

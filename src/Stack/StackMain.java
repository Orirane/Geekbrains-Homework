package Stack;

import Queue.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackMain {
    public static void main(String[] args)throws IOException, InterruptedException {
        System.out.println("Greetings! \n Before you lies a test for console-based Stack program.");
        System.out.println("To add something to the stack, input 'push %number%', where %number% " +
                "\nis whatever integer you want to add. If you want to display the last element and remove it" +
                " input: 'pop'\n" +
                "Else, if you want to display the last element but not remove it, input: 'peek' " +
                "\nto exit the program - type 'exit'" +
                "\n\n");

        System.out.println("Now, you may begin.");
        Stack stack = new Stack(300);
        String input;
        while (true) {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            input = br.readLine();
            if (input.toLowerCase().equals("exit")) break;
            else if (input.toLowerCase().split(" ")[0].equals("push")) {
                try {
                    stack.push(Integer.valueOf(input.split(" ")[1]));
                } catch (NumberFormatException e) {
                    System.out.println("Please remember that you should input an integer.");
                }
            } else if (input.toLowerCase().equals("pop")) {
                if (!stack.isEmpty()) System.out.println(stack.pop());
                else System.out.println("There's nothing to pop, the Stack is empty!");
            } else if (input.toLowerCase().equals("peek")) {
                if (!stack.isEmpty()) System.out.println(stack.peek());
                else System.out.println("There's nothing to see, the Stack is empty!");
            } else {
                System.out.println("Perhaps, you made a mistake when you typed in last command");
            }
        }
        System.out.println("Goodbye.");
        Thread.sleep(2000);
    }
}


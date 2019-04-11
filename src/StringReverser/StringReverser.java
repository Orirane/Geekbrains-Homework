package StringReverser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverser {

    public static void main(String[] args)throws IOException, InterruptedException {
        System.out.println("This program reverses any string you input! try it! \n" +
                "input 'exit' to exit");

        Stack stack = new Stack(10000);
        String input;
        while (true){
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            input = br.readLine();
            if (input.equals("exit"))break;
            char[] inputarray = input.toCharArray();
            for (int i = 0; i < inputarray.length; i++) {
                stack.push(inputarray[i]);
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }
        System.out.println("tixe");
        Thread.sleep(1500);
    }
}

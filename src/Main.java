import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Barely had time to do even non starred exercises, so didn't bother making them one-size-fit-all,
        //unlike last week.
        //each of the methods can print out it's results, but the code is commented out by default.

        //Exercise 1
        invertArray();
        //Exercise 2
        fillArray();
        //Exercise 3
        multiplyArray();
        //Exercise 4
        fillDiagonal();


    }


    public static void invertArray(){
        int[] args = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < args.length ; i++) {
            args[i] = (args[i] == 1) ? 0 : 1;
        }
        //System.out.println(Arrays.toString(args));
    }
    public static void fillArray(){
        int[] arr = new int [8];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (i * 3);
        }
        //System.out.println(Arrays.toString(arr));
    }
    public static void multiplyArray(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i]*2 : arr[i];
        }
        //System.out.println(Arrays.toString(arr));
    }
    public static void fillDiagonal() {
        int[][] arr = new int[4][4];
        int column = 3;
        for (int i = 0; i < 4; i++) {
            arr[i][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            arr[i][column] = 1;
            column--;
        }

        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        } */
    }
}

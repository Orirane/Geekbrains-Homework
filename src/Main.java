import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random random;

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
        //Exercise 5; the input is a random array, first argument is size of the array second and third are minimum and
        // maximum values of each element of the array
        findMinMax(generateArray(14, -100, 100));

        //int[] checkBalArray = {1, 1, 1, 2, 1};
        //Exercise 6: It did work with both test arrays, I think it works with any array, but I can't really think
        // of a meaningful way to test it.
        System.out.println(checkBalance(generateArray(14, 0, 10)));


    }


    public static void invertArray() {
        int[] args = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < args.length; i++) {
            args[i] = (args[i] == 1) ? 0 : 1;
        }
        //System.out.println(Arrays.toString(args));
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i * 3);
        }
        //System.out.println(Arrays.toString(arr));
    }

    public static void multiplyArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
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

    public static void findMinMax(int[] arr) {
        int min = 0;
        int max = 0;
        int i = 0;
        for (int element : arr) {
            if (i == 0) {
                min = element;
                max = element;
                i++;
            }
            min = (element < min) ? element : min;
            max = (element > max) ? element : max;
        }
        System.out.println("min is: " + min + "\n max is : " + max);
        System.out.println("Input array is: " + Arrays.toString(arr));
    }

    private static boolean checkBalance(int[] arr) {
        //int j = 1;

       //System.out.println(Arrays.toString(arr));
        for (int j = 1; j < arr.length - 1; j++) {
            int sumBegin = 0;
            int sumEnd = 0;
            for (int i = 0; i < arr.length - j -1; i++) {
                sumBegin += arr[i];
                //System.out.println("sumbegin = "+sumBegin);
            }
            for (int n = arr.length - 1; n > arr.length - j - 1; n--) {
                sumEnd += arr[n];
                //System.out.println("sumend = "+sumEnd);
            }
            if (sumBegin == sumEnd) {
                return true;
            }
        }
        return false;
    }

    public static int[] generateArray(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = giveRandom(min, max);

        }
        return arr;
    }

    // returns random number between int min and int max------------
    public static int giveRandom(int min, int max) {
        random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    // returns random positive number up to limit------------
    public static int giveRandom(int limit) {
        random = new Random();
        return random.nextInt(limit + 1);
    }
}

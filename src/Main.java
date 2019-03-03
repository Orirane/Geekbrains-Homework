import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int n;
        String[][] arr = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                n = random.nextInt(100);
                arr [i][j] = String.valueOf(n);
            }
        }
        String[][] arrDataException = {
                {"1","0","1","0"},
                {"1","0","1","0"},
                {"1","0","1","0"},
                {"1","0","1","0"}

        };
        arrDataException[2][2] = "name";
        String [][] arrSizeEx = new String[3][4];
        try {
            System.out.println(ArraySum(arr));
//            System.out.println(ArraySum(arrSizeEx));
//            System.out.println(ArraySum(arrDataException));



        } catch (MyArraySizeException | MyArrayDataException | NumberFormatException e){
            e.printStackTrace();
        }
    }


    private static int ArraySum(String[][] inputArr) throws MyArrayDataException, MyArraySizeException {
        if (inputArr.length*inputArr[0].length != 16){
            throw new MyArraySizeException("Passed array is not 4x4");
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(inputArr[i][j]);
                }catch (NumberFormatException e){
                    throw new NumberFormatException("Item at index ["+i+"]["+j+"] is not a number. " +
                            "\nYes I could use a MyArrayDataException, but NumberFormatException makes way more sense" +
                            " in context ¯\\_(ツ)_/¯");
                }
            }
        }
        return sum;
    }
}

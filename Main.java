import java.util.Random;
public class Main {
    public static Random random;

    public static void main(String[] args) {
        // just some variables of the types that we learned, don't mind them.

        byte byteType = 127;
        short shortType = 32767;
        int integerType = 1337;
        long wowThatsLong = 80085;
        double doubleType = 13.37;
        String champ = "It's High noon somewhere in the world";
        char chump = 'm';
        boolean news = false;

        /*
        As per exercise (3.) the next sout uses method calculateComplexMath to print out
        the result of the expression || a * (b + (c / d)) || and uses random numbers between [-10 and 10] as parameters.

         Mind that you can't use 0 as the last parameter.
         If you use 0 as the last parameter a random number will be assigned instead
         */

        System.out.println(calculateComplexMath(giveRandom(), giveRandom(), giveRandom(), giveRandom()));


        /*for (int i = 0; i < 30; i++) {
            System.out.println(liesBetween(giveRandom(50), giveRandom(10)));
        }
        */

        // Exercise (4.) sout below prints out true if the sum of given numbers is in [10, 20] and false if not.
        System.out.println(liesBetween(giveRandom(50), giveRandom(10)));

        //Exercise (5.)

        negativeOrPositive(giveRandom(-100, 100));

        //Exercise (6.)

        System.out.println(isNegative(giveRandom(-50, 10)));

        //Exercise (7.)

        greetingsName("Владимир");

        //Exercise (8.)

            isALeapYear(giveRandom(0, 2021));


    }

    public static double calculateComplexMath(int a, int b, int c, int d){
        while (d == 0){
            d = giveRandom();
        }
       // System.out.println("Value a: " + a + "\n Value b: " + b + "\n Value c: " + c + "\n Value d:" + d );
        return (a * (b + ((double) c / d)));

    }

    //returns true if the number lies in [10, 20] ------------
    public static boolean liesBetween(int a, int b){
        int sum = a + b;
        //System.out.println("The sum is: " + sum);
        return sum >= 10 && sum <= 20;
    }

    //Either prints that the number is positive or negative. ------------
    public static void negativeOrPositive(int number){
        if (number >= 0){
            System.out.println("The number "+ number +" is positive");
        }
        //else {
           // System.out.println("The number " + number + " is negative");
        //}
    }

    //returns true if the number is negative, false, if positive.------------
    public static boolean isNegative(int number){
            return number < 0;
    }

    // prints a greeting
    public static void greetingsName(String name){
        System.out.println("Привет, "+ name );
    }

    // returns random number between [-10 and 10]------------
    public static int giveRandom(){
        random = new Random();
        return random.nextInt(10 + 1 + 10) - 10;
    }

    // returns random positive number up to limit------------
    public static int giveRandom(int limit){
        random = new Random();
        return random.nextInt(limit + 1);
    }

    // returns random number between int min and int max------------
    public static int giveRandom(int min, int max){
        random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
    //Determines if a year is a leap one or not------------
    public static void isALeapYear(int year){
        if (year % 400 == 0){
            System.out.println(year + " is a leap year.");
        }
        else if (year % 4 == 0 && year % 100 != 0 ){
            System.out.println(year + " is a leap year.");
        }
        else{
            System.out.println(year + " is NOT a leap year.");
        }
    }
}

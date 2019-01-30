import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner reader = new Scanner(System.in);
    public static Random random;

    public static void main(String[] args) {
        typingVerySlowly("Hello, if you want to guess a number - type number. \nIf you want to guess a word - type word.");
        String input = reader.nextLine().toLowerCase();
        while (true){
            if(input.equals("word")){
                typingVerySlowly("Welcome to my guessing game. If you want to exit the game - type exit.");
                guessingWordGame();
                break;
            }
            else if (input.equals("number")){
                typingVerySlowly("In this game you have to guess a number that I think of." +
                        " The number should be between 0 and 9. You will have three attempts to guess it.");
                guessingNumberGame();
                break;
            }
            else if (input.equals("exit")){
                System.exit(0);
            }
        }

        System.out.println("Thanks for playing! Press enter to exit.");
        String exit = reader.nextLine();


    }
    public static void guessingNumberGame(){
        int hiddenNumber = giveRandom(0, 9);
        int guess;
        for (int i = 0; i < 3;) {


            typingVerySlowly(" Please, make a guess.");
            guess = Integer.parseInt(reader.nextLine());
            if(guess == hiddenNumber){
                typingVerySlowly("Congratulations! You guessed the number. \n The number was: " + hiddenNumber);
                gameRestart();
                return;
            }

            else if (guess < hiddenNumber){
                typingVerySlowly("The number is greater than your guess");
                i++;
            }

            else{
                typingVerySlowly("The number is less than your guess");
                i++;
            }

        }
        typingVerySlowly("Game Over");
        gameRestart();
    }
    public static void guessingWordGame() {
        String guess;
        String hiddenWordString = randomWord();
        char[] hiddenWord = hiddenWordString.toCharArray();
        String wordMaskString = "###############";
        char[] wordMask = wordMaskString.toCharArray();
        while(true){
            typingVerySlowly(" Please, make a guess.");
            guess = reader.nextLine();
            guess = guess.toLowerCase();
            if(guess.equals("exit")){
                System.exit(0);
            }
            for (int i = 0; i < guess.length() && i < hiddenWordString.length(); i++) {
                if (guess.charAt(i) == hiddenWordString.charAt(i)){
                    wordMask[i] = hiddenWordString.charAt(i);
                }
            }
            if(String.valueOf(wordMask).substring(0,hiddenWordString.length()).equals(hiddenWordString)){
                typingVerySlowly("Congratulations, you guessed the word! The word was " + hiddenWordString);
                return;
            }
            else {
                System.out.println("guessed letters and their positions are: "+String.valueOf(wordMask));
            }

        }


    }
    public static String randomWord(){
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        return words[giveRandom(0, 24)];
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


    public static void typingVerySlowly(String input){
        int i = 0;
        String welcome = input;
        String[] arr = welcome.split("");
        for (String character : arr) {
            System.out.print(character);
            try {
                if (i < 2 && character.equals(".")){
                    Thread.sleep(250);
                    i++;
                }
                else {
                    Thread.sleep(10);
                }
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }

        try {
                Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }

        System.out.println("\n");
    }
    public static void gameRestart(){
        typingVerySlowly("Do you want to try again? y/n");
        String input = reader.nextLine();
        if(input.equals("y")){
            guessingNumberGame();
        }
    }
}


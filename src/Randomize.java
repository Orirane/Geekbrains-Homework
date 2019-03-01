import java.util.Random;
public final class Randomize {
    private static Random random;

    static int giveRandom(int min, int max) {
        random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
    // returns random positive number up to limit------------
    static int  giveRandom(int limit) {
        random = new Random();
        return random.nextInt(limit + 1);
    }
}



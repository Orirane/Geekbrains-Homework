package animals;

public class Dog extends Animal {
    private static String name = "Собака";
    public Dog(){
        super(giveRandom(300, 700), giveRandom(0, 30), ((double) giveRandom(1, 30)/10), name );
    }

    Dog(int runLimit, int swimLimit, double jumpOverLimit, String name){
        super(runLimit, swimLimit, jumpOverLimit, name);
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}

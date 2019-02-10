package animals;

import java.util.Random;

public abstract class Animal {
    private String name;
    int runLimit;
    int swimLimit;
    double jumpOverLimit;

    Animal(int runLimit, int swimLimit, double jumpOverLimit, String name){
        this.name = name;
        this.runLimit = runLimit;
        this. swimLimit = swimLimit;
        this.jumpOverLimit = jumpOverLimit;
    }

    // run checks if the animal can run desired distance, if it can - it runs full distance, otherwise it runs as far as
    // it can and then gives up.
    public void run(int distance){
        //System.out.println("Результат: run: " + (distance <= runLimit));
        if (distance <= runLimit){
            System.out.println(name+" пробежала "+ distance + " м.");
        }
        else{
            System.out.println(name + " выдохлась, пробежав " + runLimit + " м.");
        }
    }

    //swim checks if the animal can swim over desired distance - if it can - it does so, otherwise - it refuses.
    public void swim(int distance){
        //System.out.println("Результат: swim: " + (distance <= swimLimit));
        if (distance <= swimLimit){
            System.out.println(name+" проплыла "+ distance + " м.");
        }
        else {
            System.out.println(name + " оценила расстояние и не зашла в воду.");
        }
    }

    // jumpOver checks whether the desired height of the object to jump over is short enough for that animal.
    // result depends on the maximum height the animal can jump.
    public void jumpOver(double height){
        //System.out.println("Результат: jumpOver: " + (height <= jumpOverLimit));
        if ((height <= jumpOverLimit)){
            System.out.println(name+" перепрыгнула препятствие высотой в "+ height + " м.");
        }
        else {
            System.out.println(name + " не смогла перепрыгнуть препятствие.");
        }
    }

    //printInfo prints out overall stats of the given animal and it's every run, swim or jump limits.
    void printInfo(){
        System.out.println("Эта " + name + " может пробежать: " + runLimit +" м.\nПроплыть: " + swimLimit +
                " м. \nПодпрыгнуть на: " + jumpOverLimit + " м.");
    }

    // returns random number between int min and int max
    static int giveRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

}

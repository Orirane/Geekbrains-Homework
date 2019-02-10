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
    public void run(int distance){
        //System.out.println("Результат: run: " + (distance <= runLimit));
        if (distance <= runLimit){
            System.out.println(name+" пробежала "+ distance + " м.");
        }
        else{
            System.out.println(name + " выдохлась, пробежав " + runLimit + " м.");
        }
    }
    public void swim(int distance){
        //System.out.println("Результат: swim: " + (distance <= swimLimit));
        if (distance <= swimLimit){
            System.out.println(name+" проплыла "+ distance + " м.");
        }
        else {
            System.out.println(name + " оценила расстояние и не зашла в воду.");
        }
    }
    public void jumpOver(double height){
        //System.out.println("Результат: jumpOver: " + (height <= jumpOverLimit));
        if ((height <= jumpOverLimit)){
            System.out.println(name+" перепрыгнула препятствие высотой в "+ height + " м.");
        }
        else {
            System.out.println(name + " не смогла перепрыгнуть препятствие.");
        }
    }
    void printInfo(){
        System.out.println("Эта " + name + " может пробежать: " + runLimit +" м.\nПроплыть: " + swimLimit +
                " м. \nПодпрыгнуть на: " + jumpOverLimit + " м.");
    }

    // returns random number between int min and int max------------
    static int giveRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

}

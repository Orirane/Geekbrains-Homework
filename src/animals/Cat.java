package animals;

public class Cat extends Animal {
    private static String name = "Кошка";
    public Cat(){
        super(giveRandom(100, 350), giveRandom(0, 10),  + ((double)giveRandom(10,30)/10), name);
    }
    Cat(int runLimit, int swimLimit, double jumpOverLimit, String name){
        super(runLimit, swimLimit,  + jumpOverLimit, name);
    }
    Cat(String name){
        super(giveRandom(100, 350), giveRandom(0, 10),  + ((double)giveRandom(10,30)/10), name);
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Эта кошка может пробежать: " + runLimit +" м.\nПроплыть: " + swimLimit +
                " м. \nПодпрыгнуть на: " + jumpOverLimit + " м.");
    }

}

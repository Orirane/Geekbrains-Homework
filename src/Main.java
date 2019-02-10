import animals.*;
public class Main {
    public static void main(String[] args){
        Dog dog0 = new Dog();
        dog0.run(600);
        dog0.swim(20);
        dog0.jumpOver(2.1);
        //dog0.printInfo();
        Cat cat0 = new Cat();
        cat0.run(300);
        cat0.swim(3);
        cat0.jumpOver(2.3);
        //cat0.printInfo();

        StrayCat strayCat = new StrayCat();
        StrayDog strayDog = new StrayDog();
        HomeCat homeCat = new HomeCat();

        ISeekFood[] animals = new ISeekFood[] {strayCat, strayDog, homeCat};
        for (ISeekFood animal:animals) {
            animal.seekFood();

        }
    }
}

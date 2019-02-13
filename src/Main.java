import java.util.Random;

public class Main {
    private static  Random random;
    private static final String[] names = {"Ezra","Charlie","Lucy","Luna","Max","Oliver","Chloe", "Milo","Simba","Cleo","Lily","Nala","Coco",
            "George","Gracie","Jack","Jasper","Leo","Loki","Lola","Oreo","Oscar","Sophie","Tiger","Angel","Bailey",
            "Daisy","Felix","Gizmo","Pepper","Sebastian","Shadow","Simon","Tigger","Zoe","Abby","Alice","Biscuit",
            "Boots","Buttercup","Cupcake","Finn","Garfield","Jasmine","Kiki","Kitty","Lucky","Lulu","Misty",
            "Mittens","Molly","Murphy","Orion","Patches","Peanut","Rocky","Romeo","Sasha","Smokey","Stella",
            "Whiskers","Ziggy","Bandit","Bear","Belle","Boo","Buddy","Caesar","Callie","Candy","Chase","Chester",
            "Cuddles","Dusty","Emma","Fiona","Frankie","Ginger","Harley","Harry","Hazel","Hunter","Jake","Juno",
            "Maggie","Mia","Missy","Moon","Panda","Penny","Phoebe","Princess","Ruby","Rusty","Sadie","Sam","Sammy",
            "Sassy","Socks","Sylvester"};
    public static void main(String[] args) {
        random = new Random();
        //Cat cat = new Cat("Barsik", 200);
        Plate plate = new Plate(giveRandom(100, 150));
        /*plate.info();
        cat.eat(plate);
        plate.info();*/
        Cat[] cats = new Cat[70];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(names[random.nextInt(100)], giveRandom(2, 4));
        }
        for ( Cat cat : cats) {
            cat.eat(plate);
            plate.info();
        }
        plate.addFood(10);
        plate.info();
    }
    private static int giveRandom(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }


}




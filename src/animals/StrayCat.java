package animals;

import java.util.Random;

public class StrayCat extends Cat implements ISeekFood {
    private static String name = "Дикая кошка";
    public StrayCat(){
        super(giveRandom(300, 500), giveRandom(8, 35),  + ((double)giveRandom(15,40)/10), name);
    }
    public void seekFood() {
        int abilityModifier = 7;
        Random random = new Random();
        int rollResult = random.nextInt(21) + abilityModifier;
        int difficultyClass = 10;
        if (rollResult < difficultyClass) {
            System.out.println(name + " потратила несколько часов на поиски еды, но не смогла ничего найти.");
        } else if (rollResult == difficultyClass) {
            System.out.println(name + " поймала и съела небольшую мышь, но всё ещё не чувствует себя сытой.");
        } else if (rollResult < 20) {
            System.out.println(name + " прибилась к стае диких кошек и успешно поохотилась вместе с ними. " + name + " сыта.");
        } else if (rollResult == 20 + abilityModifier) {
            System.out.println(name + " во время поиска еды, почувствовала сильный запах кошачьего корма, который привел её" +
                    " к открытому окошку склада зоомагазина. Ориентируясь по запаху, " + name.toLowerCase() + " нашла" +
                    " порванный мешок кошачьего корма." + name + " запомнила это место");
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }
}

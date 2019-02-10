package animals;

import java.util.Random;

public class HomeCat extends Cat implements ISeekFood{
    private static String name = "Домашняя кошка";
    public HomeCat(){
        //super(giveRandom(300, 500), giveRandom(8, 35),  + ((double)giveRandom(15,40)/10), name);
        super(name);
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }

    @Override
    public void seekFood() {
        int abilityModifier = 3;
        Random random = new Random();
        int rollResult = random.nextInt(21) + abilityModifier;
        int difficultyClass = 10;
        if (rollResult < difficultyClass){
            System.out.println(name + " потратила несколько часов на поиски еды, но не смогла ничего найти.");
        }
        else if(rollResult == difficultyClass){
            System.out.println(name + " поймала и съела небольшую мышь, но всё ещё не чувствует себя сытой.");
        }
        else if(rollResult < 20){
            System.out.println(name + " встретила на улице доброго человека, который поиграл с ней несколько минут и " +
                    "покормил её. " + name + " сыта." );
        }
        else if (rollResult == 20 + abilityModifier) {
            System.out.println(name + " во время поиска еды, почувствовала сильный запах кошачьего корма, который привел её" +
                    " к открытому окошку склада зоомагазина. Ориентируясь по запаху, " + name.toLowerCase() + " нашла" +
                    " порванный мешок кошачьего корма." + name + " запомнила это место");
        }

    }
}

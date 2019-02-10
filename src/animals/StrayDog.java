package animals;

import java.util.Random;

public class StrayDog extends Dog implements ISeekFood {
    private static String name = "Дикая собака";
    private boolean packLeader = false;
    public StrayDog(){
        super(giveRandom(500, 900), giveRandom(15, 55), ((double) giveRandom(10, 40)/10), name );
    }
    /* seekFood is a method which prints in console the result of the animal's attempt to find food.
     * abilityModifier represents animal's inherit skill at finding food, high modifier results
     * in better chances of success
     * difficultyClass represents difficulty of the given task, which in this case is rather low.
     * rollResult rolls 1d20 and adds to it ability modifier, if rollResult is greater than difficultyClass - attempt
     * succeeds, the exact result of the succeeded roll depends on the exact value of rollResult. The higher the better.
     */
    @Override
    public void seekFood() {
        int abilityModifier = 6;
        Random random = new Random();
        int rollResult = random.nextInt(21) + abilityModifier;
        int difficultyClass = 10;
        if (rollResult < difficultyClass){
            System.out.println(name + " потратила несколько часов на поиски еды, но не смогла ничего найти.");
        }
        else if(rollResult == difficultyClass){
            System.out.println(name + " успешно поохотилась одна,  но всё ещё не чувствует себя сытой.");
        }
        else if (rollResult < 20 && packLeader){
            System.out.println("Успешно поохотилась со своей стаей.");
        }
        else if(rollResult < 20){
            System.out.println(name + " прибилась к стае диких собак и успешно поохотилась вместе с ними. " + name + " сыта.");
        }
        else if (rollResult == 20 + abilityModifier) {
            System.out.println(name + " во время последней охоты со своей стаей, воспользовалась гибелью вожака стаи и " +
                    "заняла его место.");
            packLeader = true;

        }
    }
}

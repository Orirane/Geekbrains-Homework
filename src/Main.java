import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        String[] names = {"Ivanov", "Smirnov", "Kuznetsov", "Popov", "Sokolov", "Lebedev", "Kozlov", "Novikov",
                "Morozov", };
        PhoneBook newBook = new PhoneBook();
        for (int i = 0; i < 12 ; i++) {
            newBook.add(names[random.nextInt(9)],
                    "+7(916)"+giveRandom(100, 999)+"-"+giveRandom(10, 99)+"-"+giveRandom(10, 99));
            newBook.add(names[random.nextInt(9)],
                    "+7(942)"+giveRandom(100, 999)+"-"+giveRandom(10, 99)+"-"+giveRandom(10, 99));
            newBook.add(names[random.nextInt(9)],
                    "+7(997)"+giveRandom(100, 999)+"-"+giveRandom(10, 99)+"-"+giveRandom(10, 99));

        }
        newBook.add("Vorontsov", "+7(942)487-36-31");
        newBook.add("Vorontsov", "+7(942)870-28-33");
        newBook.add("Vorontsov", "+7(942)487-36-13");
        System.out.println(newBook.get("Vorontsov")+"\n");
        newBook.removeNumber("Vorontsov", "+7(942)870-28-33");
        System.out.println(newBook.get("Vorontsov")+"\n");
        for (String name: names) {
            if (!newBook.get(name).contains("null") && !newBook.get(name).contains("There's no such entry")){
                System.out.println(newBook.get(name)+"\n");
            }
        }
        //numberOfApperances();
    }
    static void numberOfApperances(){
        List<String> groceryList = List.of("Potatoes", "Milk", "Beef", "Chicken","Pasta", "Grapes", "Chicken", "Chicken", "Apples",
                "milk", "beef", "those little sweet tomatoes", "Maple Syrup", "Pasta" );

        Map<String, Integer> countMap = new HashMap<>();
        for (String item : groceryList) {
            Integer count = countMap.get(item);
            if(count == null) {
                count = 0;
            }
            countMap.put(item, (count.intValue()+1));
        }

        System.out.println(countMap.toString());
    }
    // returns random number between int min and int max------------
    public static int giveRandom(int min, int max) {

        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
}

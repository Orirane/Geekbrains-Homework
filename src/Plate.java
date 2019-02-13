public class Plate {
    private int food;
    Plate(int food) {
        this.food = food;
    }
    void decreaseFood(int n) {
        food = (food - n < 0) ? 0 : food - n;
    }
    void info() {
        System.out.println("plate: " + food);
    }
    int getFood(){
        return food;
    }
    void addFood(int amount){
        food += amount;
    }
}
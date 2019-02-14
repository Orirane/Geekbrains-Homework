class Cat {
    private String name;
    private int appetite;
    private int satiety = 0;
    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    void eat(Plate p) {
        double percentOfAppetite = (double)appetite/100;
        if (p.getFood() >= appetite){
            satiety = 100;
            System.out.println(name+ " is full");
        }else if (p.getFood() < appetite && p.getFood() != 0){
            satiety = (int)( p.getFood()/percentOfAppetite);
            System.out.println(name + " is " + satiety + "% full");
        }else if (p.getFood() == 0){
            System.out.println("The plate is empty");
        }
        p.decreaseFood(appetite);
    }
}
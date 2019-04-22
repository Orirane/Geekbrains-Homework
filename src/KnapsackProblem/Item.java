package KnapsackProblem;

public class Item {

	private String name;
	private int value;
	private double weight;
	private double effectiveness;

	Item(String name, int value, double weight){
		this.name = name;
		this.value = value;
		this.weight = weight;
		//I should probably check for items with zero value. Guess this should work.
		//Also, effectiveness works on the principle that the less is better, mostly due to sorting in the main class.
		//I could probably do reverse sorting, but this is faster albeit less intuitive.
		if (value == 0){
			value = 1;
		}
		this.effectiveness = weight/value;
	}
	public double getEffectiveness(){
		return effectiveness;
	}

	public double getWeight() {
		return weight;
	}

	public void printItem(){
		System.out.println(name+": weight "+weight+"; value "+value+";" );
	}
}

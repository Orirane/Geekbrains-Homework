package KnapsackProblem;

import java.util.ArrayList;

public class Knapsack {
	private double weightLimit;
	private double weightLeft;
	ArrayList<Item> knapsackContents = new ArrayList<>();

	Knapsack(double weightLimit) {
		this.weightLimit = weightLimit;
		weightLeft = weightLimit;
	}

	public boolean hasEnoughWeight(double weight) {
		return (weightLimit - weight >= 0);

	}

	public void add(Item item){
		knapsackContents.add(item);
		weightLimit -=item.getWeight();
	}

	public void displayContents(){
		for (Item item:knapsackContents) {
			item.printItem();
		}
	}
}

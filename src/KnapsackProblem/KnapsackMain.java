package KnapsackProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class KnapsackMain {
	public static ArrayList<Item> itemArray = new ArrayList<>();
	public static Knapsack knapsack;

	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		System.out.println("Type the weight limit of your knapsack");
		knapsack = new Knapsack(Double.valueOf(sr.nextLine()));

		System.out.println("Type the NAME of the item which must be a single word, it's VALUE and it's WEIGHT (in that exact order) \nin one line and separating each element with whitespace"+
				"\nRepeat until satisfied.");
		while(true){
			String[] line = sr.nextLine().split(" ");
			if(line[0].equalsIgnoreCase("exit")){
				System.out.println("Finished the addition of items");
				break;
			}
			itemArray.add(new Item(line[0], Integer.valueOf(line[1]), Double.valueOf(line[2])));
			System.out.println("Item added, type exit if you want to finish");
		}
		//this is supposed to sort the @itemArray by their effectiveness. Yes I googled it, duh. I really like lambda expressions for some reason
		Collections.sort(itemArray, Comparator.comparing(i -> i.getEffectiveness()));
		recursiveAddAlltoKnapsack(0);
		knapsack.displayContents();
	}

	//I honestly think that recursion is totally pointless here and could be replaced with foreach
	private static void recursiveAddAlltoKnapsack(int pointer){
		if (pointer >= itemArray.size()){
			return;
		}
		if(knapsack.hasEnoughWeight(itemArray.get(pointer).getWeight())){
			knapsack.add(itemArray.get(pointer));
		}
		recursiveAddAlltoKnapsack(++pointer);
	}
}

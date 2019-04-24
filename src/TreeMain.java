import java.util.Random;

public class TreeMain {

    public static void main(String[] args) {
        //me while writing this so-called code https://i.imgur.com/mMpiS05.png

        Tree[] theTree = {new Tree(),new Tree(), new Tree(),new Tree(),new Tree(),new Tree(),new Tree(),new Tree(), new Tree(),new Tree(),new Tree(),
                new Tree(), new Tree(),new Tree(), new Tree(),new Tree(),new Tree(),new Tree(),new Tree(),new Tree()};
        for (int j = 0; j < 20; j++) {
            int i = 0;
            do {
                theTree[j].insert(new Node(i++, giveRandom(-100, 100)));
            } while (theTree[j].heightOfBinaryTree(theTree[j].root) < 6);

        }
        for (Tree element:theTree) {
            System.out.println(element.root.toString());
        }
    }
    private static int giveRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }
}

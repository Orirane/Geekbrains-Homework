package list;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertAfter("Polina", 22);
        itr.insertAfter("Zhenya", 15);
        itr.insertBefore("Alex", 12);
        itr.nextLink();
        itr.nextLink();
        itr.deleteCurrent(); //professionally sniping Artem
        itr.insertAfter("Alina", 23);
        itr.reset();
        itr.insertBefore("John", 15);
        itr.getCurrent().display(); //That's why you see two Johns
        itr.insertAfter("Katya", 28);
        itr.reset();
        while(!itr.atEnd()){
            itr.nextLink();
        }
        itr.insertAfter("LastMan Standing", 1337);
        itr.reset();
        itr.deleteCurrent();//And that's why you actually don't see two Johns
        list.display();


    }


}


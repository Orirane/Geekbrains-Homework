import java.util.HashMap;

public class PhoneBook {
    HashMap<String, String> phoneBook = new HashMap<>();
    PhoneBook(){

    }
    //receives name an phone number to add to the phone book hashMap, expects String name and String phone number in
    //+X(xxx)xxx-xx-xx, format.
    void add(String name, String phoneNumber){
        if (!phoneBook.containsKey(name)){
            phoneBook.put(name, phoneNumber);
        } else {
            phoneBook.put(name, phoneBook.get(name)+"; "+phoneNumber);
        }

    }
    //returns every phone number stored for a given key.
    String get(String name){
        return name + ": "+ phoneBook.get(name);

    }
}


import java.util.HashMap;
import java.util.regex.Pattern;

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
            if (!phoneBook.get(name).contains(phoneNumber)){
                phoneBook.put(name, phoneBook.get(name) + "; " + phoneNumber);
            }
        }

    }

    //regex removes the entry from value by looking for it between end and start of the line,
    // start and not word, not word and not word. Probably should include something else, but should work as is.
    void removeNumber(String name, String phoneNumber){
        if (phoneBook.get(name).contains(phoneNumber)){
            String key = name;
            String value = phoneBook.get(name).replaceAll("\\W"+ Pattern.quote(phoneNumber)+"\\W|^"+Pattern.quote(phoneNumber)+";|\\W"+Pattern.quote(phoneNumber)+"$|"+"^"+Pattern.quote(phoneNumber)+"$","").trim();
            phoneBook.remove(name);
            if (!value.equals("") && !value.equals(" ")){
                phoneBook.put(key, value);
            }
        }
    }
    //returns every phone number stored for a given key.
    String get(String name){
        if (phoneBook.containsKey(name)){
            return name + ": "+ phoneBook.get(name);
        }
        else{
            return "There's no phone numbers for name:  " + name;
        }

    }
}


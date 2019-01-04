package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private  Map<String, ArrayList<String>> contacts = new HashMap<>();

    public void add(String lastname, String phone){
        if(!contacts.containsKey(lastname)) {
            contacts.put(lastname, new ArrayList<>(Arrays.asList(new String[]{phone})));
        } else {
            contacts.get(lastname).add(phone);
        }
    }

    public String[] get(String lastname) {
        ArrayList<String> al = contacts.get(lastname);
        return (al != null) ? al.toArray(new String[al.size()]) : null;
    }
}

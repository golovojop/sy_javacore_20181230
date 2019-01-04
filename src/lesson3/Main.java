package lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] data = {
                "Oracle",
                "RedHat",
                "Java",
                "Hello",
                "world",
                "OpenJDK",
                "world",
                "Java",
                "Linux",
                "Blockchain",
                "Oracle",
                "Java",
                "Override"
        };

        ArrayList<String> al = new ArrayList<>(Arrays.asList(data));
        System.out.println("Слов в исходном массиве: " + al.size());

        // Количество уникальных слов в исходном массиве
        TreeSet<String> ts = new TreeSet<>(al);
        System.out.println("\nУникальных слов: " + ts.size());
        System.out.println(ts);

        // Количество повторений каждого слова
        System.out.println("\nКоличество повторений:");
        for(String s : ts){
            System.out.println(s + " -> " + Collections.frequency(al, s));
        }


    }
}

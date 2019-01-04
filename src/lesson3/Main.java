package lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /**
         * ДЗ_1.
         * "Массив с набором слов"
         */
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

        /**
         * ДЗ_2.
         * "Телефонный справочник"
         */
        PhoneBook pb = new PhoneBook();
        pb.add("Иванов", "+70001234567");
        pb.add("Петров", "+70007654321");
        pb.add("Сидоров", "+70007418529");

        try {
            System.out.println("\nНомера Иванова:");
            for(String s : pb.get("Иванов")) {
                System.out.println(s);
            }

            pb.add("Иванов", "+71110012323");

            System.out.println("\nНомера Иванова:");
            for(String s : pb.get("Иванов")) {
                System.out.println(s);
            }

            System.out.println("\nНомера Никитина:");
            for(String s : pb.get("Никитин")) {
                System.out.println(s);
            }
        } catch (NullPointerException e) {
            System.out.println("Отсутствуют");
        }
    }
}

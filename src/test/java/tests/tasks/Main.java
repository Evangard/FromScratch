package tests.tasks;

import java.util.*;
class Main {
    public static boolean validate(String userName) {
        return userName.matches("^[A-Z][0-9A-Za-z]+(_?[0-9A-Za-z]+)$") && userName.toCharArray().length >= 4;
    }

    public static void main(String[] arguments) {
//        HashMap<String, Integer> m = new HashMap<>();
//        m.put("A", 10);
//        m.put("B", 5);
//        m.put("C", 7);
//        m.put("D", 12);

        System.out.println("Test: " + validate("Asa_df"));
        System.out.println("Test: " + validate("A_d"));
        System.out.println("Test: " + validate("As_d"));
        System.out.println("Test: " + validate("Asa__df"));
        System.out.println("Test: " + validate("Asa_df_asd"));
        System.out.println("Test: " + validate("Asa_"));
    }

    public String getWinner(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
        return "asd";
    }
}
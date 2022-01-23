package tests.tasks;

public class Username {
    public static boolean validate(String userName) {
        return userName.matches("^[A-Z][0-9A-Za-z]+(_?[0-9A-Za-z]+)$") && userName.toCharArray().length >= 4;
    }

    public static void main(String[] arguments) {
        System.out.println("Test: " + validate("Asa_df"));
        System.out.println("Test: " + validate("A_d"));
        System.out.println("Test: " + validate("As_d"));
        System.out.println("Test: " + validate("Asa__df"));
        System.out.println("Test: " + validate("Asa_df_asd"));
        System.out.println("Test: " + validate("Asa_"));
    }
}

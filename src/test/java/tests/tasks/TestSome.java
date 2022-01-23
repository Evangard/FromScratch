package tests.tasks;

public class TestSome
{
    public static void main(String[] args) {
        String a = "Test";
        String b = "Test";
        String c = new String("Test");
        String d = new String("Test");
        Integer z = 6;
        Integer x = 6;
        System.out.println(z == x);

        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(c==d);
        System.out.println("a.equals(b) - " + a.equals(b));
        System.out.println("a.equals(c) - " + a.equals(c));
        System.out.println("c.equals(d) - " + c.equals(d));
    }
}
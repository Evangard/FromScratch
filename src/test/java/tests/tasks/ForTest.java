package tests.tasks;

public class ForTest {
    public static void main(String[] args) {
//        int [] arr = {5,7,10,3,1};
//        int max1 = 0;
//        int max2 = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (max1 < arr[i]) {
//                max2 = max1;
//                max1 = arr[i];
//            } else if (max2 < arr[i]) {
//                max2 = arr[i];
//            }
//        }
//        System.out.println(max2);
//
//
        String test = "qwerty";

        char[] charArray = test.toCharArray();

        int count = 0;
        for (char c: charArray) {
            System.out.println(c);
            count++;
        }
        System.out.println(count);
    }



}

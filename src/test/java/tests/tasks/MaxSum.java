package tests.tasks;

import java.util.Arrays;
import java.util.List;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int max1 = 0;
        int max2 = 0;
        for (Integer i : list) {
            if(max1 < i) {
                max2 = max1;
                max1 = i;
            } else if (max2 < i) {
                max2 = i;
            }
        }
        return max1 + max2;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9 ,7, 11);
        System.out.println(findMaxSum(list));
    }
}

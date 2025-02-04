package Exercice5;

import java.util.Arrays;

public class MaxSubArraySum {

    static int naiveApproach(int[] arr) {
        int res = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i ; j < arr.length; j++) {
                sum += arr[j];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    static int kadaneApproach(int[] arr) {
        int res = arr[0];
        int sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);

            res = Math.max(res, sum);
        }
        return res;
    }

    public static void test(){
        int[][] testCases = {
                {2, 3, -8, 7, -1, 2, 3},
                {-2, -3, -8, -1, -5},
                {5, 10, 15, 20},
                {-1, 3, -2, 4, -1, 2, 1, -5, 4},
                {0, 0, 0, 0},
                {10},
                {-10},
                {4, -1, 2, 1},
                {100, -90, 100, -90, 100}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i];
            int output = kadaneApproach(input);
            System.out.println("Test " + (i + 1) + ": Input " + Arrays.toString(input) + " Output " + output);
        }
    }

}

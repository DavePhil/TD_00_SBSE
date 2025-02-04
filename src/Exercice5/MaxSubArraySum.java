package Exercice5;

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

    static void test(){
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(kadaneApproach(arr));
    }

}

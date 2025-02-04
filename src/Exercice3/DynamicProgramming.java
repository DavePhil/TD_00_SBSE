package Exercice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {

    static int knapsack(int W, Items[] arr, List<Items> chosenItems) {
        int n = arr.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (arr[i - 1].getWeight() > j) {
                    // If item weight is greater than current capacity, we can't include it
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Either include the item or exclude it
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1].getWeight()] + arr[i - 1].getValue());
                }
            }
        }
        int w = W;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                chosenItems.add(arr[i - 1]);
                w -= arr[i - 1].getWeight();
            }
        }
        return dp[n][W];
    }

    public static void test(){
        List<Items[]> testCases = Arrays.asList(
                new Items[]{new Items(2, 3), new Items(3, 4), new Items(4, 5), new Items(5, 6)},
                new Items[]{new Items(60, 10), new Items(100, 20), new Items(120, 30)},
                new Items[]{new Items(10, 5), new Items(20, 10), new Items(30, 15)},
                new Items[]{new Items(1, 2), new Items(2, 3), new Items(3, 4), new Items(4, 5)},
                new Items[]{new Items(50, 1), new Items(100, 2), new Items(150, 3)},
                new Items[]{},
                new Items[]{new Items(5, 10), new Items(4, 9), new Items(3, 8)},
                new Items[]{new Items(10, 5)}
        );

        int[] weights = {5, 50, 20, 10, 5, 5, 7, 5};

        for (int i = 0; i < testCases.size(); i++) {
            Items[] items = testCases.get(i);
            int W = weights[i];

            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Inputs");
            System.out.print("Weigth: " + W + ", ");
            System.out.print("Items: ");
            for (Items item : items) {
                System.out.print("(Value: " + item.getValue() + ", Weight: " + item.getWeight() + ") ");
            }
            System.out.println();

            System.out.println("Outputs");
            List<Items> chosenItems = new ArrayList<>();
            System.out.println("Maximum value in Knapsack: " + knapsack(W, items, chosenItems));

            System.out.println("Items selected in the Knapsack:");
            for (Items item : chosenItems) {
                System.out.println("Weight: " + item.getWeight() + ", Value: " + item.getValue());
            }
            System.out.println("------------------------");
        }
    }
}

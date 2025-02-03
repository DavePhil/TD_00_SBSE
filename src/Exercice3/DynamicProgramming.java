package Exercice3;

import java.util.ArrayList;
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

    void test(){
        Items[] items = {
                new Items(2, 3),
                new Items(3, 4),
                new Items(4, 5),
                new Items(5, 6)
        };
        int W = 5;
        List<Items> chosenItems = new ArrayList<>();
        System.out.println("Maximum value in Knapsack: " + knapsack(W, items, chosenItems));

        System.out.println("Items selected in the Knapsack:");
        for (Items item : chosenItems) {
            System.out.println("Weight: " + item.getWeight() + ", Value: " + item.getValue());
        }
    }
}

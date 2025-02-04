package Exercice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    static List<int[]> naiveMethod(List<int[]> array) {
        array.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<int[]>();

        for (int i = 0; i < array.size(); i++) {
            int start = array.get(i)[0];
            int end = array.get(i)[1];

            if(!merged.isEmpty() && merged.get(merged.size() - 1)[1] >= end) {
                continue;
            }

            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j)[0] <= end) {
                    end = Math.max(end, array.get(j)[1]);
                }
            }

            merged.add(new int[]{start, end});
        }

        return merged;
    }


    static List <int[]> mergedMethod(List<int[]> array) {
        array.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<int[]>();
        merged.add(new int[]{array.get(0)[0], array.get(0)[1]});

        for (int[] ints : array) {
            int endOfLastInMerged = merged.get(merged.size() - 1)[1];
            int startOfCurrent = ints[0];
            int endOfCurrent = ints[1];

            if (startOfCurrent <= endOfLastInMerged) {
                merged.get(merged.size() - 1)[1] = Math.max(endOfLastInMerged, endOfCurrent);
            } else {
                merged.add(new int[]{startOfCurrent, endOfCurrent});
            }
        }
        return merged;
    }


    public static void test(){
        List<int[][]> testCases = Arrays.asList(
                new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                new int[][]{{1, 4}, {4, 5}},
                new int[][]{{1, 2}, {3, 4}, {5, 6}},
                new int[][]{{1, 10}, {2, 6}, {3, 5}, {7, 9}},
                new int[][]{{5, 10}, {1, 3}, {2, 6}},
                new int[][]{{1, 5}}
        );

        for (int i = 0; i < testCases.size(); i++) {
            List<int[]> intervals = new ArrayList<>(Arrays.asList(testCases.get(i)));

            List<int[]> res = mergedMethod(intervals);

            System.out.print("Test " + (i + 1) + ": Input " + Arrays.deepToString(testCases.get(i)) + " → Output ");
            for (int[] interval : res)
                System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
            System.out.println();
        }
    }
}

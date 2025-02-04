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


    static void test(){
        List<int[]> arr = new ArrayList<>(Arrays.asList(
                new int[]{7, 8},
                new int[]{1, 5},
                new int[]{2, 4},
                new int[]{4, 6}
        ));

        List<int[]> res = mergedMethod (arr);

        for (int[] interval : res)
            System.out.println(interval[0] + " " + interval[1]);
    }
}

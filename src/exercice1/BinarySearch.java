package exercice1;

public class BinarySearch {

    int binarySearch(int[] arr, int key) {
        int low = 0; int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) low = mid + 1;
            if (arr[mid] > key) high = mid - 1;
        }
        return -1;
    }

    int recursiveBinarySearch(int[] arr, int key, int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] > key) recursiveBinarySearch(arr, key, low, mid - 1);
            return recursiveBinarySearch(arr, key, mid + 1, high);
        }
        return -1;
    }

    public static void test(){
        BinarySearch search = new BinarySearch();

        int[][] testArrays = {
                {4, 9, 11, 20, 23, 27, 60},
                {1, 2, 3, 4, 5, 6, 7},
                {10, 20, 30, 40, 50, 60},
                {100, 200, 300, 400, 500},
                {5},
                {}
        };

        int[] searchValues = {23, 4, 50, 200, 5, 10};

        for (int i = 0; i < testArrays.length; i++) {
            int[] array = testArrays[i];
            int x = searchValues[i];
            int n = array.length;

            System.out.println("Test " + (i + 1) + ":");
            System.out.println("Search value: " + x);
            System.out.print("Input: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("");

            int result = search.binarySearch(array, x);
            System.out.print("Output: ");
            if (result == -1) {
                System.out.println("Element not found");
            } else {
                System.out.println("Element found at index " + result);
            }
            System.out.println("------------------------");
        }
    }
}

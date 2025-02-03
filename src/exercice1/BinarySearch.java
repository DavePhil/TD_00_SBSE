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

        int[] array = { 4, 9, 11, 23, 20, 27, 60};
        int n = array.length;
        int x = 23;
        int result = search.binarySearch(array, x);
        // int result = search.recursiveBinarySearch(array, x, 0, n - 1);
        System.out.println("Search value :" + x);
        System.out.print("Input : ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.print("Output :");
        if (result == -1) {
            System.out.println("Element not found");
        }
        else System.out.println("The element found at index " +  result);
    }
}

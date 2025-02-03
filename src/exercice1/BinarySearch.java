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
}

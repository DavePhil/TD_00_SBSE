package exercice1;

public class main {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();

        int[] array = { 4, 9, 11, 23, 20, 27, 60};
        int n = array.length;
        int x = 23;
        int result = search.binarySearch(array, x);
        // int result = search.recursiveBinarySearch(array, x, 0, n - 1);

        if (result == -1) {
            System.out.println("Element not found");
        }
        else System.out.println("The element found at index " +  result);
    }
}

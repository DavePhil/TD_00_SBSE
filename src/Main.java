import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu () {
        int selectedOption;
        int end;
        do {
            System.out.println("*******************************************************************************");
            System.out.println("Welcome to this first TP of SBSE");
            System.out.println("1. Binary Search");
            System.out.println("2. Graph Traversal (BFS and DFS)");
            System.out.println("3. Dynamic Programming (Knapsack Problem)");
            System.out.println("4. Merge Intervals");
            System.out.println("5. Maximum Subarray Sum (Kadane’s Algorithm)");
            System.out.println("6. Exit");
            System.out.println("*******************************************************************************");
            System.out.println("Select an option: ");
            selectedOption = sc.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.println("======================= Binary Search ========================");

                    System.out.println("==============================================================");
                    break;
                case 2:
                    System.out.println("=============== Graph Traversal (BFS and DFS) ================");

                    System.out.println("==============================================================");
                    break;
                case 3:
                    System.out.println("============ Dynamic Programming (Knapsack Problem) ===========");

                    System.out.println("===============================================================");
                    break;
                case 4:
                    System.out.println("======================== Average Score ========================");

                    System.out.println("===============================================================");
                    break;
                case 5:
                    System.out.println("========== Maximum Subarray Sum (Kadane’s Algorithm) ==========");

                    System.out.println("===============================================================");
                    break;
                case 6:
                    System.out.println("===================");
                    System.out.println("Thanks you user!!! ");
                    System.out.println("===================");
                    break;
                default:
                    System.out.println("You have selected an incorrect value!");
            }
            System.out.println("Do you want continue Yes(1)/No(0) ?");
            end = sc.nextInt();
        }while (end!=0);
    }
}
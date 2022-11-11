import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter goal state: ");
            int[] goal = new int[9];
            for (int i = 0; i < 9; i++) {
                goal[i] = scanner.nextInt();
            }
            new EightPuzzle(goal);
            System.out.println();
        }
    }


}
